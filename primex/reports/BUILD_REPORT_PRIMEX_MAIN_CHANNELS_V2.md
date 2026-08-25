# PrimeX — abertura da tela principal de canais

## Diagnóstico do aparelho

A autorização do painel já estava funcionando com `HTTP 200`, `registered=true`, `allowed=true` e uma playlist. A tela que apareceu em seguida, com os cartões **Provedor**, **Usuário**, **Vencimento** e **Suporte**, não era a lista de canais. Ela correspondia ao `page_login` interno do fragmento de informações.

## Correção

O APK anterior selecionava o pager interno `page_login` (ID `0x7f0b0328`). A nova versão aponta para o pager principal `main_vp` (ID `0x7f0b027b`), armazenado no campo `Spark.y`, e seleciona o índice `0`, que é a Home/tela principal de canais. A ponte `AuthInfo` permanece ativa: antes da navegação, a playlist autorizada é registrada no estado legado, o handler oficial recebe a mensagem `0x0f`, e `Spark.G/H` é chamado com a URL retornada pelo Prestige.

## Fluxo final

| Situação | Comportamento |
|---|---|
| Não autorizado ou erro de rede | Continua consultando a cada 5 segundos e mostra o diagnóstico |
| Autorizado com playlist | Preenche `AuthInfo`, registra a URL, atualiza o fluxo legado, carrega a playlist e abre `main_vp` no índice 0 |
| Pager principal ausente | Registra `MyViewPager principal main_vp 0x7f0b027b não encontrado` no Logcat e no diagnóstico |
| Falha na carga | Mantém a mensagem da exceção para identificar o ponto restante |

## Validação estática

A versão foi compilada com `MacActivation`, `MacActivation$Poller`, `MacActivation$Poller$1` e `MacActivation$Poller$2`. A desmontagem confirmou `main_vp`/`0x7f0b027b`, `Spark.y`, chamada `u(0,false)` com fallback para `setCurrentItem(0)`, ponte `AuthInfo`, `ga.m.e`, handler `0x0f`, `Spark.G/H`, rota Prestige e intervalo de 5.000 ms. A assinatura V1/V2/V3 e o teste ZIP passaram.

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-main-channels-v2.apk` |
| Package | `com.p2serv.android.ds` |
| Versão | `10.4.1` |
| Tamanho | 21.863.352 bytes |
| SHA-256 | `2bde0a4f159311135c212ec5b562cc44fac5a5ecd138a51c32461930f49383bf` |
| Teste real | Necessário no aparelho; a captura anterior confirmou a autorização e mostrou que o alvo anterior era a tela de cartões |
