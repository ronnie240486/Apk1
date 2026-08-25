# PrimeX — categorias originais e pós-autorização null-safe

## Problema confirmado

O painel autorizou o aparelho com `HTTP 200`, `registered=true`, `allowed=true` e playlist encontrada. A exceção ocorria depois da autorização, durante a ponte para o fluxo legado.

## Correção aplicada

A ponte agora preenche também `AuthInfo.KeysBean` e todos os campos essenciais de `ServiceBean` e `UserBean`. A etapa nativa `Spark.H` é isolada e, se falhar, o erro é registrado sem impedir a tentativa de abrir a interface original. A navegação marca o botão Home, seleciona o `main_vp` principal no índice 0, chama `ka/r.Z()` e `ka/r.c0()` com proteção contra objetos ausentes e registra a etapa precisa no diagnóstico.

A tela Live original permanece responsável por categorias, canais e EPG: `vg_group`, `rv_channel` e `epg_listview`. O monitor continua consultando o painel Prestige a cada cinco segundos enquanto aguarda autorização.

## Validação

A versão foi compilada com as quatro classes do monitor. A desmontagem confirmou `AuthInfo`, `KeysBean`, `ServiceBean`, `UserBean`, `Spark.H` isolado, `main_vp` `0x7f0b027b`, botão Home, chamadas `Z()`/`c0()`, rota Prestige e intervalo de 5.000 ms. Assinatura V1/V2/V3 e teste ZIP passaram.

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-categories-nullsafe.apk` |
| Package | `com.p2serv.android.ds` |
| Versão | `10.4.1` |
| Tamanho | 21.863.352 bytes |
| SHA-256 | `59a246a652744bd8249bb27cc09b50d73ebecc7aa5cfdc5b4e9d501db8014659` |
| Teste real | Necessário no aparelho |
