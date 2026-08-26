# PrimeX r11 — entrada imediata após autorização

A captura mostrou `HTTP 200`, `registered=true` e playlist encontrada, mas a tela MAC permanecia aberta. A causa foi a leitura da playlist M3U ocorrer antes da troca de tela. Na r11, a thread de autorização chama `AuthInfo`, `Spark.G/H`, troca para o `main_vp` e atualiza a Home imediatamente. Somente depois uma thread separada lê `group-title` e, no UI thread, aplica categorias e atualiza o Live.

O monitor continua consultando o painel Prestige a cada cinco segundos enquanto aguarda autorização. O marcador visual de teste foi removido da tela principal.

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-r11.apk` |
| Package | `com.p2serv.android.ds` |
| VersionCode | `1043` |
| VersionName | `10.4.1-PrimeX-r10` |
| Tamanho | `21.867.448` bytes |
| SHA-256 | `d2b3f26fc176a3bd8505b0cf8387d27180da31400e4bdbc1e899024f24e8eace` |
| Assinatura | V1/V2/V3 verificada |
| Teste real | Necessário no aparelho |
