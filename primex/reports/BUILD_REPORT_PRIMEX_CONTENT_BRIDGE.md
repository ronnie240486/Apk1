# PrimeX — ponte de conteúdo após ativação MAC

## Resultado do teste do aparelho

O painel respondeu corretamente com `HTTP 200`, `registered=true`, `allowed=true` e `playlist_urls`. A versão anterior carregava a URL e mudava o `ViewPager`, mas a tela seguinte permanecia sem dados porque o fluxo MAC não preenchia o objeto global `ga.m.e` (`AuthInfo`) usado pelas páginas legadas.

## Correção

Após a autorização, o monitor agora cria o objeto `AuthInfo` e seus objetos `ServiceBean` e `UserBean` por reflexão, grava a playlist autorizada em `ch_url`, `auth_url`, `vod_url` e `epg_url`, define o serviço como habilitado e registra o objeto no campo global `ga.m.e`. Também grava a URL em `Spark.Z`, atualiza a página `la/e` por `B()`, notifica o handler oficial com `sendEmptyMessage(0x0f)`, chama `Spark.G/H` e seleciona `MyViewPager.setCurrentItem(1)`.

Com isso, a página de conteúdo recebe os dados de serviço/usuário e a URL antes da troca visual. O monitor continua em cinco segundos apenas até a autorização e registra qualquer falha no diagnóstico e no Logcat.

## Validação estática

A versão final foi compilada com as quatro classes `MacActivation`, `MacActivation$Poller`, `MacActivation$Poller$1` e `MacActivation$Poller$2`. A desmontagem confirmou a rota Prestige, intervalo `0x1388`, classes `AuthInfo`, `ServiceBean`, `UserBean`, campo global `ga.m.e`, campo `Spark.Z`, chamada ao handler `0x0f`, `Spark.G/H` e `setCurrentItem(1)`. A assinatura V1/V2/V3 e o teste ZIP passaram.

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-content-bridge.apk` |
| Package | `com.p2serv.android.ds` |
| Versão | `10.4.1` |
| Tamanho | 21.863.352 bytes |
| SHA-256 | `966ccc53a30d9b4cf88318fbc02989c0dbdbec770934089f778243c5be9a42d5` |
| Teste real | Necessário no aparelho; a captura anterior confirmou a autorização e a tela vazia |
