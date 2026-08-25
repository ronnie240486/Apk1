# PrimeX — correção do monitor Prestige

## Problema corrigido

O APK anterior falhava ao abrir a tela com `java.lang.NoClassDefFoundError: Failed resolution of: Lorg/bitspark/android/MacActivation$Poller;`. A causa foi o empacotamento incompleto do DEX: a classe principal `MacActivation` foi incluída, mas as classes internas `MacActivation$Poller` e `MacActivation$Poller$1` ficaram de fora.

## APK corrigido

| Campo | Valor |
|---|---|
| Arquivo | `PrimeX-prestige-auto-fixed.apk` |
| Nome exibido | `PrimeX` |
| Package id | `com.p2serv.android.ds` |
| App ID | `prestige` |
| Intervalo | 5 segundos |
| Tamanho | 21.785.454 bytes |
| SHA-256 | `fc5d05672a4e7000b50733c40c76dd7b2b941d85711754ecee45130aee636c46` |
| Assinatura | V1, V2 e V3 verificadas por `apksigner` |

## Conteúdo corrigido

O APK agora contém as três classes necessárias:

```text
MacActivation.smali
MacActivation$Poller.smali
MacActivation$Poller$1.smali
```

O monitor continua usando exclusivamente o MAC/ID do aparelho, consultando:

```text
GET https://renciaapp.manus.space/api/v5/apps/prestige/config?mac=AA%3ABB%3ACC%3ADD%3AEE%3AFF
```

Quando `registered=true`, `allowed=true` e existe uma primeira `playlist_url`, o monitor envia a URL ao carregador de conteúdo existente. Nos demais estados, permanece na tela de ativação.

## Validações

O Apktool reconstruiu o pacote sem erro. A nova desmontagem confirmou as três classes do monitor, a rota Prestige, o intervalo hexadecimal `0x1388` equivalente a 5.000 ms, os campos `registered`/`allowed`, a chamada iniciada pela tela e a assinatura V1/V2/V3. O teste `unzip -t` também passou.

Não há ADB ou aparelho físico disponível nesta sessão; portanto, a abertura em hardware real e o retorno autorizado do painel ainda precisam ser confirmados no dispositivo.
