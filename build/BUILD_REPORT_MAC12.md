# Relatório do APK MAC12

## Artefato

| Campo | Valor |
|---|---|
| Arquivo | `P2Server10.4.1-mac12-signed.apk` |
| Pacote | `com.p2serv.android.ds` |
| Versão | `10.4.1` (`versionCode` 1041) |
| Tamanho | 21.777.044 bytes |
| SHA-256 | `ef5d9780b090340e194a49fb1dcbce298cf2c3e3a8e778b1c3ad679126bb165f` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Alterações de autenticação

O botão que antes aparecia como `Login com o ID do dispositivo` passou a aparecer como `Login com MAC de 12 dígitos` em português do Brasil. O fluxo gera um identificador de 12 caracteres hexadecimais, grava esse valor como usuário e senha e encaminha a autenticação pela rotina de login existente do APK, que também envia os dados do dispositivo.

Quando o Android fornece o MAC Wi‑Fi, ele é normalizado sem separadores e usado como identificador. Quando o sistema oculta o MAC ou devolve o placeholder `02:00:00:00:00:00`, o APK usa o `ANDROID_ID` normalizado e truncado/preenchido para 12 caracteres. Isso é necessário porque versões modernas do Android frequentemente não liberam o MAC físico para aplicativos comuns; nesse caso, o valor mostrado ao servidor é um identificador estável de 12 caracteres, não uma garantia de MAC físico.

## Verificações

O Apktool reconstruiu o APK após a alteração Smali e incluiu `org/bitspark/android/MacId.smali`. Uma segunda desmontagem confirmou a chamada `MacId.get12(context)`, a gravação nos campos de usuário e senha e a chamada do login normal. O arquivo ZIP passou no teste de integridade. O `apksigner` confirmou V1, V2 e V3.

Não há dispositivo Android/ADB disponível nesta sessão para executar uma instalação real. Portanto, a instalação foi validada estruturalmente e pela assinatura, mas a aceitação final depende da versão do Android e do estado de uma instalação anterior.

## Instalação

Como o certificado é uma chave local nova, desinstale primeiro uma versão anterior assinada por outro certificado. Depois instale este APK. Ele não deve ser tratado como atualização oficial sobre um APK assinado por outro fornecedor.
