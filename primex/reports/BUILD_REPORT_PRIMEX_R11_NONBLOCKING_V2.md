# PrimeX r11 — entrada imediata após autorização

A captura mostrou autorização correta, mas a tela MAC permanecia aberta. A correção separa a troca de tela da leitura da playlist: primeiro o fluxo faz `AuthInfo`, `Spark.G/H`, troca para `main_vp` e abre a Home; somente depois uma thread separada lê a playlist M3U e atualiza categorias no UI thread.

Esta revisão usa `versionCode 1044` e `versionName 10.4.1-PrimeX-r11` para permitir atualização sobre a r10. O marcador visual de teste foi removido. O monitor mantém a consulta ao painel Prestige a cada cinco segundos enquanto aguarda autorização.

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-r11.apk` |
| Package | `com.p2serv.android.ds` |
| VersionCode | `1044` |
| VersionName | `10.4.1-PrimeX-r11` |
| Tamanho | `21.867.448` bytes |
| SHA-256 | `13ea00ea8314355954fd25329d5371ec0e67b3a41e05115aabceccd1c6a79e67` |
| Assinatura | V1/V2/V3 verificada |
| Teste real | Necessário no aparelho |

A validação estática confirmou as sete classes `MacActivation` geradas pelo compilador, incluindo as classes internas anônimas necessárias, e confirmou o método `loadPlaylistCategoriesAsync` no DEX final. Isso confirma o empacotamento da correção; a confirmação visual do comportamento ainda depende do teste no aparelho.
