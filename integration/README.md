# Universal Rencia integration layer

Esta pasta contém uma camada de referência implementada a partir do contrato descrito em `analysis/pdf_main3/main3.txt`. Ela foi mantida separada da árvore decompilada porque o APK P2Server 10.4.1 possui métodos críticos protegidos por `NativeUtil` e delegados a bibliotecas nativas; a saída do JADX não constitui o projeto-fonte original nem pode ser tratada como uma base Android recompilável sem revisão.

## Arquivos

| Arquivo | Responsabilidade |
|---|---|
| `src/main/java/com/rencia/universal/UniversalContract.java` | Modelos JSON para configuração, atualização, heartbeat, avisos, vencimento, failover, comandos e login |
| `src/main/java/com/rencia/universal/UniversalApiClient.java` | Cliente síncrono HTTPS para as rotas `/api/v5/*`, com JSON UTF-8 e cache HTTP desabilitado |
| `src/main/java/com/rencia/universal/UniversalRuntime.java` | Ciclo de abertura e polling de 60 segundos, ACKs, modal único por chave, atualização e failover controlado |

## Uso esperado

O host Android precisa fornecer um `appId` universal permitido pelo documento (`prestige`, `optimus`, `imperio`, `infinitus`, `supremus`, `evolux` ou `nexus`), o MAC no formato `AA:BB:CC:DD:EE:FF`, um `StateStore` persistente e um `Listener` que conecte as decisões à interface e ao player.

O runtime chama a configuração na abertura, respeita `registered` e `allowed`, inicia heartbeat e avisos a cada 60 segundos, envia heartbeat imediato quando o conteúdo muda, confirma avisos somente depois de exibidos e confirma comandos exclusivamente com `executed` ou `failed`. Falhas de reprodução devem ser informadas apenas pelo callback `reportRealPlaybackFailure()` quando o player detectar uma falha real de rede, timeout ou indisponibilidade da lista.

O cliente rejeita base URLs que não usem HTTPS, valida o formato do MAC e não imprime o corpo de login nem a senha. Status, mensagens, playlists e bloqueios não usam cache HTTP. A lógica de seleção da lista não toma decisões próprias: o runtime só solicita sincronização quando a resposta do servidor sinaliza `switch_applied`, `playlist_sync_required` ou `primary_restored`.

## Decisão de compatibilidade

O PDF não lista `P2Server` entre os appIds universais, e o APK analisado contém um contrato legado próprio, com login, URLs de serviço entregues por `AuthInfo.ServiceBean`, token de serviço e endpoints observados em `auth3.moveplay.me`. Por esse motivo, nenhum appId foi escolhido automaticamente e nenhuma rota universal foi injetada na classe nativa existente. Para transformar esta camada em uma atualização funcional do APK, é necessário confirmar qual família/appId do backend deve representar o P2Server e integrar a camada ao projeto-fonte Android original.
