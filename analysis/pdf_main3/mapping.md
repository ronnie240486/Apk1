# Mapeamento de `main(3).pdf` para P2Server 10.4.1

## Resultado executivo

O PDF descreve um contrato universal de backend para famílias de APK que usam configuração por MAC e as rotas `/api/v5/*`. O P2Server desmontado não implementa esse contrato de forma identificável. Ele possui um fluxo legado de login e configuração entregue por `AuthInfo.ServiceBean`, usa `com.lzy.okgo`, mantém URLs de serviço recebidas do backend e delega parte da lógica a bibliotecas nativas protegidas.

A aplicação realizada foi, portanto, uma **camada de integração de referência separada**, e não uma substituição arbitrária do contrato legado dentro do APK. Essa decisão evita escolher sem evidência um `appId` universal — o PDF lista `prestige`, `optimus`, `imperio`, `infinitus`, `supremus`, `evolux` e `nexus`, mas não lista `P2Server`.

## Correspondência implementada

| Requisito do PDF | Implementação | Arquivo |
|---|---|---|
| Base HTTPS e JSON UTF-8 | Cliente com base padrão `https://renciaapp.manus.space`, rejeição de base não HTTPS e codificação UTF-8 | `integration/.../UniversalApiClient.java` |
| Validação de appId e MAC | AppIds universais validados e MAC exigido no formato `AA:BB:CC:DD:EE:FF` | `integration/.../UniversalContract.java`, `UniversalApiClient.java` |
| Configuração por MAC | `GET /api/v5/apps/{appId}/config?mac={MAC}` e campos visuais/controle | `UniversalApiClient.java`, `UniversalContract.java` |
| Atualização | `GET /api/v5/apps/{appId}/update?mac={MAC}` | `UniversalApiClient.java` |
| Heartbeat | Heartbeat imediato ao trocar conteúdo e polling a cada 60 segundos | `UniversalRuntime.java` |
| Avisos e vencimento | Parse de notificações, ACK depois da exibição e modal único por `expiration_modal_key` | `UniversalRuntime.java` |
| Sincronização de listas | Sincronização somente quando `playlist_sync_required` for sinalizado | `UniversalRuntime.java` |
| Falha real do player | `POST /api/v5/playback-failure`, somente pelo callback explícito de falha real | `UniversalApiClient.java`, `UniversalRuntime.java` |
| Failover | Recarregamento quando `switch_applied`, `playlist_sync_required` ou `primary_restored` vier na resposta | `UniversalRuntime.java` |
| Comandos remotos | Consulta e ACK com status limitado a `executed` ou `failed`; handler do host é obrigatório | `UniversalApiClient.java`, `UniversalRuntime.java` |
| Login opcional | `POST /api/v5/app-login`, sem registrar senha | `UniversalApiClient.java`, `UniversalContract.java` |
| Cache e privacidade | Sem cache HTTP para status/listas; senha não aparece em logs ou exceções do cliente | `UniversalApiClient.java` |

## O que não foi alterado

A classe nativa `TVCore`, o serviço `TVService`, o fluxo legado de `C2630m` e as bibliotecas protegidas não foram substituídos. A árvore decompilada contém métodos `native` inicializados por `NativeUtil.classesInit0(...)`, e não há projeto-fonte original ou configuração de build completa para garantir uma recompilação funcional do APK.

Também não foi feita chamada ao backend, login no serviço, troca de playlist real, execução de comando remoto ou geração de APK recompilado. O módulo é código de referência pronto para ser integrado ao aplicativo-fonte com o `appId` confirmado pelo responsável pelo backend.

## Evidências usadas

A comparação foi feita com `analysis/pdf_main3/main3.txt`, `analysis/pdf_main3/summary.md`, `original/AndroidManifest.decoded.xml`, `decompiled/java/org/bitspark/android/beans/AuthInfo.java`, `decompiled/java/ga/C2630m.java`, `decompiled/java/ga/C2620c.java` e `analysis/decoded_strings.md`.
