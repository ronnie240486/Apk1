# Relatório do PrimeX — transição automática após autorização

## Problema confirmado

A captura do aparelho mostrou uma resposta autorizada do painel (`HTTP 200`, `registered=true`, `allowed=true`, lista encontrada), mas a interface permaneceu na tela MAC. A chamada existente `Spark.G/H` enviava a playlist ao carregador nativo, porém não alterava explicitamente a página do `ViewPager` que exibe o conteúdo.

## Correção aplicada

Após receber a playlist, o PrimeX agora executa `Spark.G` e `Spark.H` na thread de interface e procura diretamente na árvore visual da Activity o `MyViewPager` real pelo ID `0x7f0b0328`, que foi confirmado no layout do host `ka.z`. Em seguida, chama explicitamente `setCurrentItem(1)`. A matriz original `Lea/g.n` foi conferida e contém os índices `0` para a ativação e `1` para a página seguinte. Se o pager não for encontrado ou a chamada falhar, o diagnóstico grava o motivo em vez de afirmar que entrou.

O status final passa a informar se a página seguinte foi aberta, se o conteúdo foi enviado mas a página não foi localizada ou se ocorreu uma falha durante a transição. O monitor de cinco segundos é encerrado ao autorizar; enquanto não autoriza, ele continua tentando e registrando cada ciclo.

## Fluxo

| Situação | Comportamento |
|---|---|
| HTTP 404, erro de rede ou não autorizado | Mostra o erro e tenta novamente em 5 segundos |
| `registered=true`, `allowed=true`, com playlist | Carrega a URL, seleciona a página de conteúdo e encerra o monitor |
| Playlist autorizada sem fragmento localizável | Mostra `Conteúdo enviado; página não localizada.` |
| Exceção na transição | Mostra a mensagem e grava no Logcat com `PrimeX-Prestige` |

## Validação

A desmontagem do APK final confirmou a rota Prestige, intervalo `0x1388` (5.000 ms), as chamadas `Spark.G/H`, o ID real `0x7f0b0328`, `findViewById`, `setCurrentItem(1)` e as quatro classes `MacActivation`, `$Poller`, `$Poller$1` e `$Poller$2`. O layout continua MAC-only e mantém o logo PrimeX e o diagnóstico visível. `apksigner` confirmou V1, V2 e V3, e `unzip -t` passou sem erros.

## Arquivo

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-auto-transition.apk` |
| Package ID | `com.p2serv.android.ds` |
| Versão | `10.4.1` |
| Tamanho | 21.859.256 bytes |
| SHA-256 | `4fce7efe9c867a4aa95ec503905e651649a56d5b59df46d2c188d82e9075cfd6` |
| Teste real | A confirmação final depende do aparelho; a captura anterior já confirmou a autorização e o problema de transição |
