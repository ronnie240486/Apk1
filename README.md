# P2Server 10.4.1 — desmontagem estática

Este repositório contém a saída de uma desmontagem estática do arquivo `P2Server10.4.1.apk`, fornecido para análise. O pacote original **não foi instalado nem executado** durante o processo.

> A saída de um decompilador é uma aproximação do aplicativo compilado. Ela pode conter nomes artificiais, métodos incompletos, trechos não recompiláveis e diferenças em relação ao código-fonte original.

## Identificação do artefato

| Campo | Valor |
|---|---|
| Aplicativo | P2Server |
| Versão declarada | 10.4.1 |
| `applicationId` | `com.p2serv.android.ds` |
| `versionCode` | 1041 |
| `compileSdkVersion` | 35 |
| `minSdkVersion` | 21 |
| SHA-256 do APK analisado | `7ad7528f9ac5fad884fdb783a19a9df66f3738b386351347a10aecd986df8cc9` |

## Conteúdo

| Caminho | Conteúdo |
|---|---|
| `decompiled/java/` | Fontes Java recuperados pelo JADX, incluindo código próprio e dependências empacotadas |
| `decompiled/smali/classes/` | Smali correspondente ao primeiro DEX |
| `decompiled/smali/classes2/` | Smali correspondente ao segundo DEX |
| `decompiled/resources/` | Recursos Android decodificados pelo Apktool |
| `decompiled/assets/` | Assets extraídos, incluindo fontes e arquivos de suporte |
| `decompiled/native-libs/` | Bibliotecas nativas ARM64 e ARMv7 incluídas no pacote |
| `original/` | DEXs, tabela de recursos, manifestos binário/decodificado e metadados do Apktool |
| `analysis/` | Relatórios de inspeção, análise estática e strings relevantes dos binários |
| `jadx-project/` | Arquivos Gradle mínimos gerados pelo JADX para referência estrutural |
| `integration/` | Camada de referência para as rotas universais descritas em `main(3).pdf` |
| `analysis/pdf_main3/` | PDF recebido, texto extraído e resumo do contrato aplicado |

## Principais observações

O manifesto declara permissões de acesso à Internet, estado de rede e Wi-Fi, armazenamento externo, inicialização após boot, bloqueio de suspensão, alteração de áudio, sobreposição de janelas, solicitação de instalação de pacotes e montagem/desmontagem de sistemas de arquivos. O aplicativo também declara tráfego sem TLS por meio de `usesCleartextTraffic="true"`.

Entre os componentes declarados estão a atividade principal `org.bitspark.android.Spark`, o `BroadcastReceiver` `org.bitspark.android.broadcast.ActionReceiver` e o serviço `com.tvbus.engine.TVService`. O receiver reage a boot concluído, alterações de conectividade, tela ligada/desligada e ajuste de horário. Esses dados devem ser interpretados como propriedades declaradas do pacote, não como prova isolada de comportamento malicioso.

Grande parte da lógica de negócio e de vários modelos Java é delegada a métodos nativos. O pacote contém bibliotecas como `libgojni.so`, `libtvcore.so`, `libffmpegJNI.so`, `libijkplayer.so`, `libijkcodec.so`, `libBugly.so` e `libmarsxlog.so` para as arquiteturas `arm64-v8a` e `armeabi-v7a`. Portanto, a recuperação Java não representa integralmente a implementação nativa.

## Integração universal derivada do PDF

O PDF recebido foi analisado e aplicado como uma camada isolada em `integration/`. Ela implementa, em código Android/Java de referência, configuração por MAC, atualização, heartbeat, avisos, ACKs, comandos remotos, falha de reprodução e failover, usando HTTPS obrigatório e sem cache HTTP para status ou playlists.

O documento não identifica o `P2Server` como um dos appIds universais. O APK desmontado também mantém um contrato legado próprio e lógica protegida em bibliotecas nativas. Por isso, o projeto não altera arbitrariamente o backend legado nem escolhe `nexus` ou outra família sem confirmação do desenvolvedor; a camada está pronta para ser conectada ao projeto-fonte Android real quando o appId correto for informado.

## Como consultar

Para investigar o fluxo de inicialização, comece por `original/AndroidManifest.decoded.xml`, `decompiled/java/org/bitspark/android/Spark.java`, `decompiled/java/org/bitspark/android/SpkApplication.java`, `decompiled/java/org/bitspark/android/broadcast/ActionReceiver.java`, `decompiled/java/com/tvbus/engine/TVService.java` e `decompiled/java/com/tvbus/engine/TVCore.java`.

Para comparar a saída de alto nível com o bytecode, use `decompiled/java/` em conjunto com `decompiled/smali/`. Para revisar indicadores, limitações e hashes, consulte `analysis/static_analysis.md` e `analysis/native_analysis.txt`.

## Limitações e segurança

A análise foi exclusivamente estática. Não foram feitas chamadas aos endpoints encontrados, não houve tentativa de login, não houve execução das bibliotecas nativas e não foi produzido um APK recompilado ou assinado.

O conteúdo pode estar sujeito a direitos autorais, licenças de bibliotecas de terceiros, segredos incorporados ou restrições de redistribuição. Antes de distribuir este repositório publicamente, confirme que você possui autorização para publicar o material e revise cuidadosamente os relatórios e os binários. O APK original foi deliberadamente omitido deste repositório; os DEXs e bibliotecas extraídos permanecem apenas como artefatos de análise.

## Ferramentas usadas

- [JADX](https://github.com/skylot/jadx), para recuperar fontes Java e a estrutura Gradle.
- [Apktool](https://github.com/iBotPeaches/Apktool), para decodificar recursos, manifesto e Smali.

## Estado do resultado

Este é um **snapshot de engenharia reversa**, não o projeto-fonte original e não deve ser tratado como um projeto Android pronto para compilação. Arquivos grandes e binários foram mantidos para permitir correlação com a saída textual e verificação do artefato analisado.
