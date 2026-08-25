# PrimeX — ativação automática por MAC

## APK

| Campo | Valor |
|---|---|
| Arquivo | `PrimeX-prestige-auto.apk` |
| Nome exibido | `PrimeX` |
| Package id | `com.p2serv.android.ds` |
| App ID do painel | `prestige` |
| Intervalo de consulta | 5 segundos |
| SHA-256 | `2f46d9b03c9191b6eb77deed048925b6ba545875b2c838b0884d8732c2523b3c` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Rota usada

```text
GET https://renciaapp.manus.space/api/v5/apps/prestige/config?mac=AA%3ABB%3ACC%3ADD%3AEE%3AFF
```

O APK envia o MAC do próprio aparelho no formato `AA:BB:CC:DD:EE:FF`, com os dois-pontos codificados na query string. A implementação consulta o endpoint logo ao abrir a tela e repete a consulta a cada 5 segundos enquanto o dispositivo não estiver autorizado.

Uma consulta somente de leitura realizada com o MAC de teste `AA:BB:CC:DD:EE:FF` retornou HTTP 404 e o JSON `{"registered":false,"error":"MAC não cadastrado."}`. O APK trata esse estado como pendente e mantém a tela de ativação.

## Estados

Quando `registered=false`, quando `allowed=false`, quando não há playlist ou quando ocorre erro de rede, o APK permanece na tela de ativação. Quando `registered=true`, `allowed=true` e existe uma `playlist_urls` ou `playlist_url`, o monitor para a consulta, agenda a transição na thread de UI e entrega a primeira URL ao carregador nativo existente do player.

## Fundo e tela

A tela usa o fundo próprio `primex_activation_bg`, um gradiente escuro em tons vinho, roxo e azul, diferente do fundo original. Ela exibe o MAC/ID, botão `Copiar`, título PrimeX e o aviso de acesso indisponível enquanto o painel não autorizar o dispositivo.

## Limitações

O `appId=prestige` foi escolhido conforme a confirmação do usuário e a imagem de referência. O carregamento da primeira lista usa as chamadas nativas existentes do APK (`Spark.G`/`Spark.H`); a resposta real autorizada e a compatibilidade da playlist precisam ser testadas com um MAC cadastrado no painel e em um dispositivo físico. Quando o Android não expõe o MAC Wi‑Fi físico, o helper usa o `ANDROID_ID` normalizado como fallback estável.

Não há dispositivo Android/ADB disponível nesta sessão para validar instalação, renderização ou troca de tela em hardware real.
