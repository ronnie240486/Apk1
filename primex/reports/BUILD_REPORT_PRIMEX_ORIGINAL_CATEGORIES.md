# PrimeX — categorias e navegação original

A revisão anterior chegava à tela de cartões porque selecionava `page_login` (ID `0x7f0b0328`). A nova revisão reproduz a sequência original de Home: marca o botão Home (`Spark.B`), seleciona o pager principal `main_vp` (ID `0x7f0b027b`) no índice 0, chama `ka/r.Z()` para montar o adaptador de grupos, chama `ka/r.c0()` para atualizar a categoria selecionada e preserva o fluxo `AuthInfo`/playlist.

A tela Live original continua sendo usada, com `vg_group` para categorias, `rv_channel` para canais e `epg_listview` para EPG. O monitor Prestige continua consultando a cada cinco segundos até autorização; após autorização, a playlist é colocada no estado legado e o fluxo original de categorias é acionado.

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-original-categories.apk` |
| Package | `com.p2serv.android.ds` |
| Versão | `10.4.1` |
| Tamanho | 21.863.352 bytes |
| SHA-256 | `7e6f928b95d00e702df00830a507a117372308b1f522eab7f84e433712f03284` |
| Assinatura | V1/V2/V3 verificada |
| Classes do monitor | `MacActivation`, `Poller`, `Poller$1`, `Poller$2` |
