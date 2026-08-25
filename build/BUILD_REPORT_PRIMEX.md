# Relatório do APK PrimeX

## Artefato

| Campo | Valor |
|---|---|
| Arquivo | `PrimeX-mac12.apk` |
| Nome exibido | `PrimeX` |
| Package id | `com.p2serv.android.ds` |
| Versão | `10.4.1` (`versionCode` 1041) |
| Tamanho | 21.777.044 bytes |
| SHA-256 | `82b11a4dcf59acdf051585670280067c8731b059576d32076e51b44b07952760` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Alteração de marca

O rótulo do aplicativo e a identificação na área “Sobre” foram alterados de `P2Server`/`RedBeanTV` para `PrimeX`. O package id foi preservado para não quebrar referências internas do APK desmontado.

O fluxo de tela permanece com `Login (MAC 12 dígitos)` e `Senha (MAC 12 dígitos)`, preenchidos com o identificador do próprio aparelho. A rotina `MacId` usa o MAC Wi‑Fi quando o Android o fornece e, quando o sistema o oculta, usa o `ANDROID_ID` normalizado como fallback estável de 12 caracteres.

## Configuração do painel

O nome `PrimeX` é apenas a marca exibida no APK. Ele não determina automaticamente o `appId` universal do backend. O PDF lista os `appId` `prestige`, `optimus`, `imperio`, `infinitus`, `supremus`, `evolux` e `nexus`; o APK só poderá ativar automaticamente a lista do painel depois que o `appId` correspondente for definido no cliente e o MAC for cadastrado no painel.

## Verificações

O Apktool reconstruiu o APK sem erro. Uma segunda desmontagem confirmou `app_name=PrimeX`, a versão e o package id. Os hints dos campos MAC12 e a chamada de `MacId.get12(...)` permanecem presentes. O ZIP passou no teste de integridade, e `apksigner` confirmou V1, V2 e V3.

Não há dispositivo Android/ADB disponível nesta sessão para testar instalação ou resposta do backend em hardware real. A assinatura usa uma chave local nova; remova a versão anterior se o Android rejeitar a atualização por certificado diferente.
