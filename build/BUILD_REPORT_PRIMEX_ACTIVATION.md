# Relatório do APK PrimeX — Ativação pendente

## Artefato

| Campo | Valor |
|---|---|
| Arquivo | `PrimeX-activation.apk` |
| Nome exibido | `PrimeX` |
| Package id | `com.p2serv.android.ds` |
| Versão | `10.4.1` (`versionCode` 1041) |
| Orientação | Retrato |
| Tamanho | 21.781.221 bytes |
| SHA-256 | `8a34b5c54a2b9c319ae9fc7daa38c57db3d68cf089768a807e78d7533a5cc524` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Fluxo visual

A tela inicial de autenticação foi substituída por uma tela de ativação pendente inspirada na segunda imagem fornecida. Ela mostra a marca PrimeX, o título `Ative seu aparelho`, a instrução para enviar o código ao revendedor, o rótulo `MAC / ID DO APARELHO`, o identificador do próprio aparelho no formato `AA:BB:CC:DD:EE:FF`, o botão dourado `Copiar` e a mensagem `Acesso indisponível para este aparelho.`

O botão Copiar lê o mesmo valor exibido e grava-o na área de transferência como texto simples. O formulário de usuário/senha e os botões de alternância ficam ocultos nessa tela.

## Identificação

O valor interno continua sendo normalizado para 12 caracteres hexadecimais em maiúsculas. A tela usa `MacId.getDisplay(...)` para apresentar o mesmo valor com dois-pontos entre os pares. Quando o Android oculta o MAC Wi‑Fi físico, o helper usa o `ANDROID_ID` normalizado como fallback estável; nesse caso, o código exibido é um identificador do aparelho no formato do painel, mas não é o MAC físico.

## Estado de ativação

O APK deve exibir essa tela para o aparelho ainda não autorizado. Depois que o revendedor cadastrar o MAC no painel e a configuração universal retornar `registered=true` e `allowed=true`, a integração precisa trocar para a tela de conteúdo e carregar a primeira lista autorizada. O `appId` universal ainda precisa ser definido entre as famílias do PDF; `PrimeX` é o nome visual e não substitui esse identificador de backend.

## Verificações

O Apktool reconstruiu o pacote sem erro. Uma segunda desmontagem confirmou `app_name=PrimeX`, orientação retrato, o layout da tela de ativação, `MacId.getDisplay(...)`, `ClipboardManager.setPrimaryClip(...)`, a versão e o package id. O ZIP passou no teste de integridade e `apksigner` confirmou V1, V2 e V3.

Não há dispositivo Android/ADB nesta sessão para validar a renderização e a instalação em hardware real. A chave de assinatura é local e nova; desinstale uma versão anterior se o Android rejeitar a atualização por certificado diferente.
