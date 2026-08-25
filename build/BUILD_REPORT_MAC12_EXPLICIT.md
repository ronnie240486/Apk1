# Relatório do APK MAC12 explícito

## Artefato

| Campo | Valor |
|---|---|
| Arquivo | `P2Server10.4.1-mac12-explicit-signed.apk` |
| Pacote | `com.p2serv.android.ds` |
| Versão | `10.4.1` (`versionCode` 1041) |
| Tamanho | 21.777.044 bytes |
| SHA-256 | `365676326ede4e96e1e34d96f92c5d26bc557a68f4be17e69b02f7193264b09d` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Ajuste solicitado

A tela agora mostra explicitamente os campos `Login (MAC 12 dígitos)` e `Senha (MAC 12 dígitos)`. Na abertura da tela, o APK não usa credenciais antigas: ele obtém o identificador atual por `MacId.get12(context)` e preenche o mesmo valor nos dois campos. Os campos usam texto visível para que seja possível conferir o valor antes de pressionar `LOGIN`.

Quando há um MAC Wi‑Fi disponível, ele é normalizado para 12 caracteres hexadecimais. Quando o Android não libera o MAC físico ou fornece `02:00:00:00:00:00`, o APK usa o `ANDROID_ID` normalizado como fallback estável de 12 caracteres. Esse fallback é uma limitação da privacidade do Android e não representa o MAC físico.

O envio não acrescenta o sufixo de domínio legado quando o login possui exatamente 12 caracteres hexadecimais. A rotina de autenticação existente continua responsável pelo POST ao backend legado.

## Verificações

O Apktool reconstruiu o pacote sem erro. A segunda desmontagem confirmou os hints visíveis, `inputType="textVisiblePassword"`, a chamada obrigatória de `MacId.get12(...)` e o preenchimento do campo de senha com o mesmo valor. O ZIP passou no teste de integridade, e `apksigner` confirmou V1, V2 e V3.

Não há dispositivo Android/ADB disponível nesta sessão para testar hardware real, instalação ou resposta do backend. Para instalar sobre uma versão assinada por outro certificado, desinstale primeiro a versão anterior.
