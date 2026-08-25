# Relatório do PrimeX — analisador Prestige visível

## Resultado

Foi gerado o APK `PrimeX-prestige-visible-analyzer.apk`, com tela de ativação somente por MAC/ID do próprio aparelho. Não há entrada visível de usuário ou senha. O valor exibido na tela é o mesmo valor passado ao monitor.

## Fluxo implementado

| Item | Implementação |
|---|---|
| Nome visual | PrimeX |
| Package ID | `com.p2serv.android.ds` |
| App ID do painel | `prestige` |
| Rota consultada | `GET https://renciaapp.manus.space/api/v5/apps/prestige/config?mac={MAC}` |
| Frequência | Uma consulta a cada 5 segundos |
| MAC enviado | Exatamente o valor mostrado na tela, em `AA:BB:CC:DD:EE:FF` |
| Critério de autorização | `registered=true`, `allowed=true` e uma URL em `playlist_urls` ou `playlist_url` |
| Ação autorizada | Envia a primeira URL ao carregador nativo existente para abrir automaticamente |
| Diagnóstico visível | MAC, appId implícito Prestige, horário, HTTP, registered, allowed, lista encontrada e erro |

## Diagnóstico na própria tela

Enquanto aguarda, o APK atualiza o texto inferior da tela a cada tentativa. Exemplos de estados são `HTTP 404` com “MAC não cadastrado”, erro de rede com a classe da exceção, `HTTP 200` com os valores de autorização e “Abrindo automaticamente...” quando a lista é encontrada. Isso permite comparar sem adivinhação o MAC cadastrado no painel com o MAC realmente enviado pelo aparelho.

## Validações realizadas

O Apktool reconstruiu o APK sem erro. A desmontagem do APK assinado confirmou o manifesto em orientação retrato, o layout com fundo `primex_activation_bg`, uma única tela MAC-only e as três classes `MacActivation`, `MacActivation$Poller` e `MacActivation$Poller$1`. O DEX contém o appId Prestige, a rota de configuração, o intervalo de 5.000 ms, os campos `registered`/`allowed`, o parser de `playlist_urls` e o callback visual para `TextView`. O arquivo ZIP passou em `unzip -t`, e `apksigner` confirmou V1, V2 e V3.

## Limitação importante

Não há aparelho Android nem ADB disponível nesta sessão. Portanto, a chamada real a partir do aparelho e a abertura do player precisam ser confirmadas instalando esta versão e observando o diagnóstico na tela. A chave de assinatura anterior não estava presente no workspace; este APK foi assinado com uma chave local nova, então é necessário desinstalar a versão anterior antes de instalar esta versão.
