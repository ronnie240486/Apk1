# PrimeX — Tela de ativação pendente

## APK final

| Campo | Valor |
|---|---|
| Arquivo | `PrimeX-activation-final.apk` |
| Nome exibido | `PrimeX` |
| Package id | `com.p2serv.android.ds` |
| Versão | `10.4.1` (`versionCode` 1041) |
| Orientação | Retrato |
| Tamanho | 21.781.217 bytes |
| SHA-256 | `e1d40b9c8ca77678a65eb99040298220daea53e967a90e6012738f64d8ed9603` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Tela reproduzida

A tela de login foi substituída por uma tela de ativação pendente inspirada na segunda imagem: marca PrimeX, título `Ative seu aparelho`, instrução para enviar o código ao revendedor, rótulo `MAC / ID DO APARELHO`, MAC do próprio aparelho em `AA:BB:CC:DD:EE:FF`, botão dourado `Copiar` com ícone e mensagem `Acesso indisponível para este aparelho.`

O botão Copiar coloca o MAC exibido na área de transferência. O formulário de usuário e senha, os botões de login e o seletor de olho ficam ocultos nessa tela.

## Identificador

O helper mantém internamente 12 caracteres hexadecimais em maiúsculas e apresenta visualmente os pares separados por dois-pontos. O MAC Wi‑Fi é usado quando o Android o expõe; caso contrário, o `ANDROID_ID` é normalizado como fallback estável. Em versões modernas do Android, o fallback pode ser necessário por restrições de privacidade.

## Ativação pelo painel

Esta versão implementa a tela pendente e o cadastro visual do MAC. A troca automática para a lista após o revendedor cadastrar o aparelho ainda depende de definir o `appId` universal correto do painel (`prestige`, `optimus`, `imperio`, `infinitus`, `supremus`, `evolux` ou `nexus`) e ligar a resposta `registered`/`allowed` à navegação do APK. `PrimeX` é apenas o nome exibido e não substitui o `appId` do backend.

## Verificações

O Apktool reconstruiu o APK sem erro. Uma segunda desmontagem confirmou o nome PrimeX, a orientação retrato, o layout de ativação, `MacId.getDisplay(...)`, `ClipboardManager.setPrimaryClip(...)` e o ícone do botão. O ZIP passou no teste de integridade e `apksigner` confirmou V1, V2 e V3.

Não há dispositivo Android/ADB disponível nesta sessão para testar renderização, instalação ou resposta real do painel. Para instalar sobre uma versão assinada por outro certificado, remova primeiro a versão anterior.
