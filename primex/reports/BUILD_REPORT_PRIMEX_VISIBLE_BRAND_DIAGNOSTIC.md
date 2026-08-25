# Relatório do PrimeX — logo e diagnóstico visível em paisagem

## Problema observado

A captura do aparelho mostrou que o monitor já estava executando, pois a tela exibiu `Analisador Prestige • consulta a cada 5 segundos`, uma sessão e uma tentativa. Porém, o layout anterior deixava apenas a parte inferior do diagnóstico visível e ainda mostrava o ícone P2 original. Assim, o usuário não conseguia conferir o MAC, o HTTP e o erro da consulta.

## Correção visual

A tela foi reorganizada em um `ScrollView` com uma sequência vertical compacta. O logo PrimeX aparece no topo, seguido do nome PrimeX, título de ativação, instrução, MAC/ID, botão Copiar e painel completo do monitor. O diagnóstico usa o mesmo `TextView` atualizado pelo monitor, mas agora fica dentro do fluxo vertical da tela e pode ser lido em retrato ou paisagem.

O ícone original `hdplayer_icon` foi removido da parte visível. Foi adicionado o recurso `primex_logo.png`, um emblema PrimeX transparente em ouro, branco e azul-marinho, apropriado para o fundo vinho/roxo da tela.

## Monitor preservado

| Item | Implementação |
|---|---|
| Consulta | `GET https://renciaapp.manus.space/api/v5/apps/prestige/config?mac={MAC}` |
| Frequência | A cada 5 segundos |
| Identificador | MAC/ID exato exibido e enviado |
| Diagnóstico | Sessão, tentativa, MAC, rota, horário, HTTP, registered, allowed, playlist e erro |
| Log técnico | Logcat com tag `PrimeX-Prestige` e arquivo privado `primex-prestige-monitor.log` |
| Entrada automática | `Spark.G` e `Spark.H` quando há autorização e playlist |
| Classes do monitor | `MacActivation`, `$Poller`, `$Poller$1` e `$Poller$2` |

## Validação

O APK foi reconstruído pelo Apktool, alinhado e assinado com V1, V2 e V3. A desmontagem confirmou `@drawable/primex_logo` no `userlogin_head`, `ScrollView`/`LinearLayout` para o painel, o `TextView` `login_error`, a rota Prestige, `0x1388` como intervalo de 5.000 ms, o arquivo de log e as quatro classes internas. `unzip -t` também passou sem erro.

## Arquivo

| Campo | Valor |
|---|---|
| APK | `PrimeX-prestige-visible-brand.apk` |
| Package ID | `com.p2serv.android.ds` |
| Versão | `10.4.1` |
| Tamanho | 21.859.256 bytes |
| SHA-256 | `550ee11cd369a95683df2a8a0f7cb23ba92e2efeea05367f303a27d45f0498d8` |
| Teste real | A confirmação final depende de instalar no aparelho; não há ADB disponível nesta sessão |
