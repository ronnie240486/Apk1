# PrimeX — acesso somente por MAC

## APK final

| Campo | Valor |
|---|---|
| Arquivo | `PrimeX-mac-only.apk` |
| Nome exibido | `PrimeX` |
| Package id | `com.p2serv.android.ds` |
| Versão | `10.4.1` (`versionCode` 1041) |
| Orientação | Retrato |
| Tamanho | 21.781.217 bytes |
| SHA-256 | `138d6ba11dc770a1a482a496c885579cb7f7cbd7571b7e5f0f8c2fde259635da` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Comportamento

A tela de entrada não apresenta login, senha ou formulário de credenciais. Ela mostra apenas a ativação do aparelho, o MAC/ID do próprio dispositivo no formato `AA:BB:CC:DD:EE:FF`, o botão `Copiar` e o aviso de acesso indisponível enquanto o cadastro não for autorizado.

O MAC interno é mantido como 12 caracteres hexadecimais em maiúsculas. `getDisplay(...)` acrescenta os dois-pontos somente para exibição e cópia no formato aceito pelo painel. O botão copia exatamente o código mostrado na tela.

Quando o Android não fornece o MAC Wi‑Fi físico, o helper usa o `ANDROID_ID` normalizado como identificador estável. Isso é uma limitação de privacidade do Android e deve ser considerado ao cadastrar o aparelho no painel.

## Ativação

Depois de copiar o código, cadastre o MAC no painel com a lista. A troca automática para conteúdo autorizado ainda depende de configurar o `appId` universal correspondente ao painel e de conectar as respostas `registered` e `allowed` à navegação do aplicativo.

## Verificações

O Apktool reconstruiu o APK sem erro. Uma segunda desmontagem confirmou a ausência de elementos visíveis de login/senha, a tela de ativação, `MacId.getDisplay(...)`, a cópia via `ClipboardManager`, orientação retrato e nome PrimeX. O ZIP passou no teste de integridade e `apksigner` confirmou V1, V2 e V3.

Não há dispositivo Android/ADB nesta sessão para testar a renderização, instalação ou comunicação real com o painel.
