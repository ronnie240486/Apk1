# Relatório do PrimeX — monitor persistente com log de diagnóstico

## Problema tratado

O fluxo foi ajustado para não depender apenas de uma mensagem genérica de acesso indisponível. O monitor permanece em execução enquanto a tela de ativação estiver aguardando autorização e realiza uma nova consulta a cada cinco segundos.

## Informações registradas em cada tentativa

| Informação | Registro |
|---|---|
| Identificador | MAC/ID exatamente como exibido e enviado, em `AA:BB:CC:DD:EE:FF` |
| Sessão | Identificador hexadecimal gerado ao iniciar o monitor |
| Tentativa | Contador crescente a cada consulta |
| Rota | `/api/v5/apps/prestige/config` |
| Horário | Hora da última consulta e timestamp no log |
| Rede | Código HTTP ou `--` quando não houve resposta |
| Autorização | Valores de `registered` e `allowed` |
| Conteúdo | Se uma playlist foi encontrada |
| Erro | Corpo resumido de erro do painel ou mensagem da exceção de rede |

O resultado é mostrado na própria tela de ativação e também enviado ao Logcat com a tag `PrimeX-Prestige`. Além disso, o aplicativo grava um histórico no arquivo privado `primex-prestige-monitor.log`, dentro do diretório interno da aplicação. A gravação do log está protegida para nunca interromper o loop de consulta.

## Comportamento de espera e entrada automática

Quando o painel responder com erro, MAC não cadastrado, `registered=false`, `allowed=false`, ausência de playlist ou erro de rede, o PrimeX atualiza o diagnóstico e volta a aguardar cinco segundos antes da próxima tentativa. O loop só é encerrado quando encontra `registered=true`, `allowed=true` e uma playlist válida, ou quando o processo é explicitamente interrompido. Nesse caso, a primeira URL é enviada ao carregador existente por `Spark.G` e `Spark.H` na thread de interface para tentar abrir automaticamente o conteúdo.

## Correção de empacotamento

O monitor agora é convertido para DEX usando todas as classes `MacActivation*.class` geradas pelo compilador. A desmontagem confirmou as quatro classes necessárias:

```text
MacActivation.smali
MacActivation$Poller.smali
MacActivation$Poller$1.smali
MacActivation$Poller$2.smali
```

A classe `$Poller$2` é o `Runnable` responsável por publicar o diagnóstico na tela e estava ausente na versão que apresentou `NoClassDefFoundError`.

## Validação

O APK foi reconstruído pelo Apktool sem erro, alinhado e assinado com V1, V2 e V3. A desmontagem do APK assinado confirmou o loop com intervalo hexadecimal `0x1388` (5.000 ms), a rota Prestige, o MAC enviado, o contador de tentativas, `Logcat`, `FileWriter`, a referência ao `TextView`, as chamadas `Spark.G/H` e as quatro classes internas. O teste `unzip -t` também passou.

## Arquivo

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-monitor-log.apk` |
| Package ID | `com.p2serv.android.ds` |
| Versão | `10.4.1` |
| Tamanho | 21.785.454 bytes |
| SHA-256 | `ec7c170a60754edc342b8c3ab2c7e84565921de3f3316a12d4c0442c49b3c9ad` |
| Teste real | Ainda depende do aparelho; não há ADB disponível nesta sessão |
