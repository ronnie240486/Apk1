# Relatório do APK MAC12 com interface corrigida

## Artefato

| Campo | Valor |
|---|---|
| Arquivo | `P2Server10.4.1-mac12-ui-signed.apk` |
| Pacote | `com.p2serv.android.ds` |
| Versão | `10.4.1` (`versionCode` 1041) |
| Tamanho | 21.777.044 bytes |
| SHA-256 | `1f9855e3c7635dffbea47409694a3c860ce5d084e059d2e098f5bbda22a90574` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Correção solicitada

A tela que aparecia como `Login com nome de usuário!` foi alterada para `Login com MAC de 12 dígitos`. Quando não existem credenciais salvas, o formulário preenche automaticamente o mesmo identificador MAC12 nos campos de usuário e senha. O valor não é truncado para seis caracteres e não recebe o sufixo de domínio legado quando tem exatamente 12 caracteres hexadecimais.

O botão de envio continua disponível para o usuário confirmar o login. O modo `Device ID` também grava o mesmo MAC12 como usuário e senha antes de chamar o fluxo legado de autenticação.

## Verificações

O Apktool reconstruiu o APK sem erro. Uma segunda desmontagem confirmou o título alterado, a chamada `MacId.get12(...)`, os caminhos de preenchimento `mac_username_ready` e `mac_password_ready` e a condição que evita o sufixo legado para 12 dígitos. O ZIP passou no teste de integridade e `apksigner` confirmou V1, V2 e V3.

Não há dispositivo Android/ADB nesta sessão para testar a instalação e o login em hardware real. A chave de assinatura é local e nova; para instalar sobre uma cópia anterior assinada por outro certificado, desinstale primeiro a versão anterior.
