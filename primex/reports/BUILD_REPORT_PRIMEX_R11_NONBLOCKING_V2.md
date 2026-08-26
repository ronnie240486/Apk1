# PrimeX r11-v2 — entrada imediata após autorização

A captura mostrou autorização correta, mas a tela MAC permanecia aberta. A correção separa a troca de tela da leitura da playlist: primeiro o fluxo faz `AuthInfo`, `Spark.G/H`, troca para `main_vp` e abre a Home; somente depois uma thread separada lê a playlist M3U e atualiza categorias no UI thread.

Esta revisão usa versionCode 1044 e versionName 10.4.1-PrimeX-r11 para permitir atualização sobre a r10/r11 anterior. O marcador visual de teste foi removido.

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-r11-v2.apk` |
| Package | `com.p2serv.android.ds` |
| VersionCode | `1044` |
| VersionName | `10.4.1-PrimeX-r11` |
| Tamanho | `21.867.448` bytes |
| SHA-256 | `b0d1ab3da33e64197f8a4148c8fa808f5afab3c928dfc668080aa2e01adaa498` |
| Assinatura | V1/V2/V3 verificada |
| Teste real | Necessário no aparelho |
