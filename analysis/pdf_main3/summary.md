# Resumo verificado de main(3).pdf

## Base e contrato

O documento técnico, datado de 25/08/2026, define a origem `https://renciaapp.manus.space`, uso de HTTPS e JSON UTF-8, e recomenda que o APK não fixe URLs de listas, imagens ou mensagens no código. O MAC deve ser enviado preferencialmente no formato `AA:BB:CC:DD:EE:FF`.

## Fluxo universal recomendado

Na abertura: consultar `GET /api/v5/apps/{appId}/config?mac={MAC}`, respeitar `registered` e `allowed`, aplicar configuração visual, carregar a primeira lista e iniciar heartbeat/avisos a cada 60 segundos. O appId universal documentado é um destes: `prestige`, `optimus`, `imperio`, `infinitus`, `supremus`, `evolux` ou `nexus`.

No ciclo de 60 segundos: chamar `GET /api/v5/heartbeat?mac={MAC}&current_content={TITULO}`, `GET /api/v5/list-notifications?mac={MAC}`, exibir notificações e modal de vencimento uma única vez por `expiration_modal_key`, sincronizar listas quando `playlist_sync_required` for verdadeiro e executar somente comandos remotos suportados, confirmando o resultado.

Em falha real de reprodução: chamar `POST /api/v5/playback-failure` com JSON contendo `mac` e `active_list_number`. Só aplicar a troca quando o servidor retornar `switch_applied` ou `playlist_sync_required`; quando `failover_state` for `primary_restored`, sincronizar em segundo plano e retornar à Lista 1.

## ACKs

Avisos são confirmados por `POST /api/v5/list-notifications/ack` com `mac` e `alert_id`. Comandos são consultados por `GET /api/v5/remote-commands?mac={MAC}` e confirmados por `POST /api/v5/remote-commands/ack` com `mac`, `command_id`, `status` (`executed` ou `failed`) e, opcionalmente, `result_message`.

## Visuais e atualização

A configuração universal pode fornecer `logo_url`, `banner_url`, `background_url`, `message_image_url`, ícones, mensagens de bloqueio e renovação, opções do player e `playlist_urls`. A atualização usa `GET /api/v5/apps/{appId}/update?mac={MAC}` e oferece `version`, `url`, `apk_link`, `force_update`, `update_available` e `release_notes`.

## Compatibilidade

O documento separa rotas legadas por família: Maximus, Fusion/Ultra e Ouro Pro. O P2Server não aparece explicitamente entre os appIds universais nem entre essas famílias; por isso, a aplicação automática de uma família ou de um appId seria uma suposição não validada.

## Restrições de implementação

Status, mensagens, listas e bloqueios não devem usar cache HTTP. Imagens podem usar cache local. O servidor decide a lista ativa. Senhas de listas não devem aparecer em logs, analytics, telas de erro ou mensagens. Em falha de rede, manter a última aparência e a última lista válida.
