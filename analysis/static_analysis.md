# Análise estática de P2Server 10.4.1

> Este relatório foi produzido por desmontagem estática. O APK não foi instalado nem executado.

## Identificação

| Campo | Valor |
|---|---|
| Arquivo | `P2Server10.4.1.apk` |
| SHA-256 | `7ad7528f9ac5fad884fdb783a19a9df66f3738b386351347a10aecd986df8cc9` |
| Fontes Java recuperados pelo JADX | 5999 |
| Arquivos Smali recuperados pelo Apktool | 8183 |
| Bibliotecas nativas | 20 |

## Pacotes de código

| Grupo | Classes Java |
|---|---:|
| `androidx.*` | 1970 |
| `com.* (other)` | 1155 |
| `p041d7.*` | 175 |
| `okhttp3.*` | 134 |
| `okio.*` | 76 |
| `p138n0.*` | 73 |
| `p173q1.*` | 72 |
| `org.bitspark` | 72 |
| `p063fa.*` | 68 |
| `retrofit2.*` | 62 |
| `p213t9.*` | 62 |
| `p055ea.*` | 50 |
| `p205t.*` | 41 |
| `p258y1.*` | 41 |
| `p116ka.*` | 39 |
| `p016b3.*` | 35 |
| `p020b7.*` | 34 |
| `p049e3.*` | 32 |
| `p105k.*` | 31 |
| `p029c7.*` | 30 |
| `p176q4.*` | 28 |
| `p247x2.*` | 27 |
| `p018b5.*` | 25 |
| `p271z4.*` | 25 |
| `android.*` | 25 |
| `p129m1.*` | 24 |
| `p187r4.*` | 24 |
| `p221u6.*` | 24 |
| `me.*` | 24 |
| `p230v4.*` | 23 |
| `p254x9.*` | 23 |
| `p270z3.*` | 23 |
| `p091i9.*` | 23 |
| `p014b1.*` | 22 |
| `p109k3.*` | 21 |
| `p130m2.*` | 21 |
| `p253x8.*` | 21 |
| `p005a4.*` | 20 |
| `p148o0.*` | 19 |
| `p178q6.*` | 19 |
| `p124l6.*` | 19 |
| `p000a.*` | 17 |
| `p103j9.*` | 17 |
| `p144n7.*` | 17 |
| `p180q8.*` | 17 |
| `p104ja.*` | 17 |
| `p036d2.*` | 16 |
| `p154o7.*` | 16 |
| `p165p4.*` | 16 |
| `p046e0.*` | 15 |
| `p185r2.*` | 15 |
| `sa.*` | 15 |
| `p261y4.*` | 15 |
| `p192r9.*` | 15 |
| `p251x6.*` | 15 |
| `ga.*` | 15 |
| `p094j0.*` | 14 |
| `p186r3.*` | 14 |
| `ua.*` | 14 |
| `p236w.*` | 14 |
| `p268z1.*` | 14 |
| `p125l7.*` | 14 |
| `qa.*` | 14 |
| `p067g2.*` | 13 |
| `p093j.*` | 13 |
| `p243w8.*` | 13 |
| `p249x4.*` | 13 |
| `p025c2.*` | 12 |
| `p056f0.*` | 12 |
| `p228v2.*` | 12 |
| `p256y.*` | 12 |
| `p275z9.*` | 12 |
| `p160p.*` | 12 |
| `p048e2.*` | 11 |
| `p065g0.*` | 11 |
| `p086i3.*` | 11 |
| `p140n2.*` | 11 |
| `p199s4.*` | 11 |
| `p225v.*` | 11 |
| `p259y2.*` | 11 |
| `p076h2.*` | 11 |
| `p008a9.*` | 10 |
| `p015b2.*` | 10 |
| `p181q9.*` | 10 |
| `p207t1.*` | 10 |
| `p215u.*` | 10 |
| `p118l0.*` | 10 |
| `p030c9.*` | 9 |
| `p047e1.*` | 9 |
| `p087i4.*` | 9 |
| `p151o3.*` | 9 |
| `p156o9.*` | 9 |
| `p035d1.*` | 9 |
| `p034d0.*` | 8 |
| `p051e6.*` | 8 |
| `p077h4.*` | 8 |
| `p106k0.*` | 8 |
| `p143n5.*` | 8 |
| `p182r.*` | 8 |
| `p002a1.*` | 7 |
| `p009aa.*` | 7 |
| `p017b4.*` | 7 |
| `p050e4.*` | 7 |
| `p064g.*` | 7 |
| `p080h7.*` | 7 |
| `p113k7.*` | 7 |
| `p141n3.*` | 7 |
| `p194s.*` | 7 |
| `p195s0.*` | 7 |
| `p233v7.*` | 7 |
| `p120l2.*` | 7 |
| `p262y5.*` | 7 |
| `p269z2.*` | 7 |
| `p001a0.*` | 7 |
| `p007a7.*` | 7 |
| `p169p8.*` | 7 |
| `p004a3.*` | 6 |
| `p090i8.*` | 6 |
| `p108k2.*` | 6 |
| `p127m.*` | 6 |
| `p196s1.*` | 6 |
| `p193ra.*` | 6 |
| `p197s2.*` | 6 |
| `p219u4.*` | 6 |
| `p222u7.*` | 6 |
| `p237w0.*` | 6 |
| `p242w5.*` | 6 |
| `p059f6.*` | 5 |
| `p174q2.*` | 5 |
| `p184r1.*` | 5 |
| `la.*` | 5 |
| `p101j7.*` | 5 |
| `p223u8.*` | 5 |
| `p081h8.*` | 5 |
| `p026c3.*` | 5 |
| `p003a2.*` | 4 |
| `p070g7.*` | 4 |
| `p072go.*` | 4 |
| `p060f7.*` | 4 |
| `p084i1.*` | 4 |
| `p114k8.*` | 4 |
| `p128m0.*` | 4 |
| `p132m5.*` | 4 |
| `p175q3.*` | 4 |
| `p198s3.*` | 4 |
| `p208t2.*` | 4 |
| `p117l.*` | 4 |
| `p227v1.*` | 4 |
| `p224u9.*` | 4 |
| `p119l1.*` | 4 |
| `p260y3.*` | 4 |
| `p019b6.*` | 4 |
| `ba.*` | 4 |
| `p131m3.*` | 4 |
| `p164p3.*` | 4 |
| `p097j3.*` | 4 |
| `p068g3.*` | 4 |
| `p136m9.*` | 4 |
| `p209t3.*` | 4 |
| `p061f8.*` | 4 |
| `p226v0.*` | 4 |
| `p189r6.*` | 4 |
| `io.*` | 4 |
| `p023c0.*` | 3 |
| `p037d3.*` | 3 |
| `p040d6.*` | 3 |
| `p073h.*` | 3 |
| `p098j4.*` | 3 |
| `p177q5.*` | 3 |
| `p170p9.*` | 3 |
| `p203s8.*` | 3 |
| `p204s9.*` | 3 |
| `p212t7.*` | 3 |
| `p239w2.*` | 3 |
| `p246x.*` | 3 |
| `p248x3.*` | 3 |
| `p267z0.*` | 3 |
| `p038d4.*` | 3 |
| `p039d5.*` | 3 |
| `p153o5.*` | 3 |
| `p201s6.*` | 3 |
| `p265ya.*` | 3 |
| `p179q7.*` | 3 |
| `p024c1.*` | 3 |
| `p044da.*` | 3 |
| `p085i2.*` | 3 |
| `p028c6.*` | 3 |
| `p264y8.*` | 3 |
| `p218u2.*` | 3 |
| `p210t4.*` | 3 |
| `com.tvbus` | 3 |
| `p012b.*` | 2 |
| `p022c.*` | 2 |
| `p042d8.*` | 2 |
| `p069g4.*` | 2 |
| `p082ha.*` | 2 |
| `p102j8.*` | 2 |
| `p115k9.*` | 2 |
| `p134m7.*` | 2 |
| `na.*` | 2 |
| `p147o.*` | 2 |
| `org.*` | 2 |
| `p200s5.*` | 2 |
| `p238w1.*` | 2 |
| `p232v6.*` | 2 |
| `p235v9.*` | 2 |
| `p245wa.*` | 2 |
| `p255xa.*` | 2 |
| `p111k5.*` | 2 |
| `p231v5.*` | 2 |
| `p066g1.*` | 2 |
| `p135m8.*` | 2 |
| `p220u5.*` | 2 |
| `p095j1.*` | 2 |
| `p171q.*` | 2 |
| `p206t0.*` | 2 |
| `p052e7.*` | 2 |
| `p006a6.*` | 2 |
| `p190r7.*` | 2 |
| `p107k1.*` | 2 |
| `p099j5.*` | 2 |
| `p123l5.*` | 2 |
| `p167p6.*` | 2 |
| `p139n1.*` | 2 |
| `p272z5.*` | 2 |
| `p013b0.*` | 1 |
| `p027c4.*` | 1 |
| `p021b9.*` | 1 |
| `p054e9.*` | 1 |
| `p045e.*` | 1 |
| `p075h1.*` | 1 |
| `p057f1.*` | 1 |
| `p079h6.*` | 1 |
| `p089i7.*` | 1 |
| `p083i.*` | 1 |
| `p062f9.*` | 1 |
| `p110k4.*` | 1 |
| `p112k6.*` | 1 |
| `p137n.*` | 1 |
| `p142n4.*` | 1 |
| `p152o4.*` | 1 |
| `p157oa.*` | 1 |
| `p172q0.*` | 1 |
| `p161p0.*` | 1 |
| `p162p1.*` | 1 |
| `p163p2.*` | 1 |
| `p166p5.*` | 1 |
| `p168p7.*` | 1 |
| `p183r0.*` | 1 |
| `p216u0.*` | 1 |
| `p217u1.*` | 1 |
| `p229v3.*` | 1 |
| `p234v8.*` | 1 |
| `p240w3.*` | 1 |
| `p126l8.*` | 1 |
| `p257y0.*` | 1 |
| `p266z.*` | 1 |
| `p250x5.*` | 1 |
| `p252x7.*` | 1 |
| `p191r8.*` | 1 |
| `p211t6.*` | 1 |
| `p244w9.*` | 1 |
| `p263y6.*` | 1 |
| `p043d9.*` | 1 |
| `p074h0.*` | 1 |
| `p274z8.*` | 1 |
| `p146n9.*` | 1 |
| `p150o2.*` | 1 |
| `p202s7.*` | 1 |
| `va.*` | 1 |
| `p188r5.*` | 1 |
| `pa.*` | 1 |
| `p122l4.*` | 1 |
| `p241w4.*` | 1 |
| `p214ta.*` | 1 |
| `p092ia.*` | 1 |
| `p149o1.*` | 1 |
| `p071g9.*` | 1 |
| `p053e8.*` | 1 |
| `p133m6.*` | 1 |
| `p121l3.*` | 1 |
| `p088i5.*` | 1 |
| `p078h5.*` | 1 |
| `p058f2.*` | 1 |
| `p273z6.*` | 1 |
| `p100j6.*` | 1 |
| `ma.*` | 1 |
| `p096j2.*` | 1 |
| `p145n8.*` | 1 |
| `p155o8.*` | 1 |
| `com.p2serv` | 1 |
| `kotlin.*` | 1 |
| `coil.*` | 1 |

## Permissões declaradas

- `android.permission.INTERNET`
- `android.permission.READ_PHONE_STATE`
- `android.permission.READ_OWNER_DATA`
- `android.permission.WRITE_OWNER_DATA`
- `android.permission.ACCESS_NETWORK_STATE`
- `android.permission.ACCESS_WIFI_STATE`
- `android.permission.WRITE_EXTERNAL_STORAGE`
- `android.permission.READ_EXTERNAL_STORAGE`
- `android.permission.RECEIVE_BOOT_COMPLETED`
- `android.permission.WAKE_LOCK`
- `android.permission.MODIFY_AUDIO_SETTINGS`
- `android.permission.SYSTEM_ALERT_WINDOW`
- `android.permission.REQUEST_INSTALL_PACKAGES`
- `android.permission.FOREGROUND_SERVICE`
- `com.p2serv.android.ds.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`
- `android.permission.MOUNT_UNMOUNT_FILESYSTEMS`

## Componentes Android

| Tipo | Nome | Exportado |
|---|---|---|
| `activity` | `org.bitspark.android.Spark` | `não especificado` |
| `receiver` | `org.bitspark.android.broadcast.ActionReceiver` | `não especificado` |
| `service` | `com.tvbus.engine.TVService` | `não especificado` |
| `provider` | `androidx.core.content.FileProvider` | `não especificado` |
| `receiver` | `com.google.android.gms.cast.framework.media.MediaIntentReceiver` | `não especificado` |
| `service` | `com.google.android.gms.cast.framework.ReconnectionService` | `não especificado` |
| `activity` | `com.google.android.gms.common.api.GoogleApiActivity` | `não especificado` |
| `provider` | `androidx.startup.InitializationProvider` | `não especificado` |
| `provider` | `me.jessyan.autosize.InitProvider` | `não especificado` |
| `receiver` | `androidx.profileinstaller.ProfileInstallReceiver` | `não especificado` |
| `service` | `com.google.android.datatransport.runtime.backends.TransportBackendDiscovery` | `não especificado` |
| `service` | `com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService` | `não especificado` |
| `receiver` | `com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver` | `não especificado` |

## Bibliotecas nativas incluídas

| ABI | Biblioteca | Tamanho (bytes) |
|---|---|---:|
| `arm64-v8a` | `libBugly.so` | 190656 |
| `arm64-v8a` | `libBugly_Native.so` | 195200 |
| `arm64-v8a` | `libc++_shared.so` | 936368 |
| `arm64-v8a` | `libffmpegJNI.so` | 1371000 |
| `arm64-v8a` | `libgojni.so` | 7917840 |
| `arm64-v8a` | `libijkcodec.so` | 268640 |
| `arm64-v8a` | `libijkplayer.so` | 355960 |
| `arm64-v8a` | `libmarsxlog.so` | 662232 |
| `arm64-v8a` | `libtvcore.so` | 1211124 |
| `armeabi-v7a` | `libBugly.so` | 165628 |
| `armeabi-v7a` | `libBugly_Native.so` | 182320 |
| `armeabi-v7a` | `libc++_shared.so` | 558988 |
| `armeabi-v7a` | `libffmpegJNI.so` | 1342608 |
| `armeabi-v7a` | `libgojni.so` | 7846584 |
| `armeabi-v7a` | `libijkcodec.so` | 143752 |
| `armeabi-v7a` | `libijkplayer.so` | 318444 |
| `armeabi-v7a` | `libmarsxlog.so` | 346308 |
| `armeabi-v7a` | `libtvcore.so` | 1025524 |

## Indicadores encontrados no código e recursos

> Os resultados abaixo são indicadores para revisão manual; uma ocorrência de domínio, IP ou nome de chave não prova, isoladamente, comportamento malicioso.

### URLs HTTP(S)

| Arquivo | Valor |
|---|---|
| `jadx/app/src/main/java/p018b5/AbstractC1323w.java` | `https://plus.google.com/` |
| `jadx/app/src/main/java/p046e0/AbstractC2343b.java` | `http://schemas.android.com/apk/res/android` |
| `jadx/app/src/main/java/p047e1/C2363g.java` | `http://ns.adobe.com/xap/1.0/` |
| `jadx/app/src/main/java/retrofit2/Response.java` | `http://localhost/` |
| `jadx/app/src/main/java/p237w0/AbstractC4044e.java` | `https://issuetracker.google.com/issues/116541301` |
| `jadx/app/src/main/java/p249x4/C4112e.java` | `https://github.com/ReactiveX/RxJava/wiki/Error-Handling` |
| `jadx/app/src/main/java/androidx/media3/datasource/HttpDataSource.java` | `https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted` |
| `jadx/app/src/main/java/androidx/media3/datasource/RawResourceDataSource.java` | `http://g.co/dev/packagevisibility` |
| `jadx/app/src/main/java/androidx/media3/exoplayer/ExoPlayerImpl.java` | `https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread` |
| `jadx/app/src/main/java/androidx/media3/exoplayer/drm/FrameworkMediaDrm.java` | `https://x` |
| `jadx/app/src/main/java/androidx/media3/exoplayer/drm/FrameworkMediaDrm.java` | `https://default.url` |
| `jadx/app/src/main/java/androidx/media3/exoplayer/drm/HttpMediaDrmCallback.java` | `http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense` |
| `jadx/app/src/main/java/androidx/media3/extractor/jpeg/JpegMotionPhotoExtractor.java` | `http://ns.adobe.com/xap/1.0/` |
| `jadx/app/src/main/java/androidx/media3/extractor/text/ttml/TtmlParser.java` | `http://www.w3.org/ns/ttml#parameter` |
| `jadx/app/src/main/java/androidx/media3/extractor/metadata/emsg/EventMessage.java` | `https://aomedia.org/emsg/ID3` |
| `jadx/app/src/main/java/androidx/media3/extractor/metadata/emsg/EventMessage.java` | `https://developer.apple.com/streaming/emsg-id3` |
| `jadx/app/src/main/java/com/bumptech/glide/AbstractC1466d.java` | `https://github.com/ReactiveX/RxJava/wiki/What` |
| `jadx/app/src/main/java/com/google/android/gms/auth/api/signin/GoogleSignInOptions.java` | `https://www.googleapis.com/auth/games_lite` |
| `jadx/app/src/main/java/com/google/android/gms/auth/api/signin/GoogleSignInOptions.java` | `https://www.googleapis.com/auth/games` |
| `jadx/app/src/main/java/com/google/android/material/chip/Chip.java` | `http://schemas.android.com/apk/res/android` |
| `jadx/app/src/main/java/com/google/android/material/chip/Chip.java` | `http://schemas.android.com/apk/res-auto` |
| `jadx/app/src/main/java/com/tencent/bugly/proguard/C2021ad.java` | `https://h.trace.qq.com/kv` |
| `jadx/app/src/main/java/com/tencent/bugly/proguard/C2020ac.java` | `https://astat.bugly.qcloud.com/rqd/async` |
| `jadx/app/src/main/java/com/tencent/bugly/proguard/C2020ac.java` | `https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async` |
| `jadx/app/src/main/java/com/tencent/bugly/crashreport/common/strategy/StrategyBean.java` | `https://android.bugly.qq.com/rqd/async` |
| `apktool/smali/b5/w.smali` | `https://plus.google.com/` |
| `apktool/smali/e0/b.smali` | `http://schemas.android.com/apk/res/android` |
| `apktool/smali/e1/g.smali` | `http://ns.adobe.com/xap/1.0/` |
| `apktool/smali/retrofit2/Response.smali` | `http://localhost/` |
| `apktool/smali/w0/e.smali` | `https://issuetracker.google.com/issues/116541301` |
| `apktool/smali/x4/e.smali` | `https://github.com/ReactiveX/RxJava/wiki/Error-Handling` |
| `apktool/smali/androidx/media3/datasource/HttpDataSource$CleartextNotPermittedException.smali` | `https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted` |
| `apktool/smali/androidx/media3/datasource/RawResourceDataSource.smali` | `http://g.co/dev/packagevisibility` |
| `apktool/smali/androidx/media3/exoplayer/ExoPlayerImpl.smali` | `https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread` |
| `apktool/smali/androidx/media3/exoplayer/drm/FrameworkMediaDrm.smali` | `https://x` |
| `apktool/smali/androidx/media3/exoplayer/drm/FrameworkMediaDrm.smali` | `https://default.url` |
| `apktool/smali/androidx/media3/exoplayer/drm/HttpMediaDrmCallback.smali` | `http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense` |
| `apktool/smali/androidx/media3/extractor/jpeg/JpegMotionPhotoExtractor.smali` | `http://ns.adobe.com/xap/1.0/` |
| `apktool/smali/androidx/media3/extractor/metadata/emsg/EventMessage.smali` | `https://aomedia.org/emsg/ID3` |
| `apktool/smali/androidx/media3/extractor/metadata/emsg/EventMessage.smali` | `https://developer.apple.com/streaming/emsg-id3` |
| `apktool/smali/androidx/media3/extractor/text/ttml/TtmlParser.smali` | `http://www.w3.org/ns/ttml#parameter` |
| `apktool/smali/com/bumptech/glide/d.smali` | `https://github.com/ReactiveX/RxJava/wiki/What` |
| `apktool/smali/com/google/android/gms/auth/api/signin/GoogleSignInOptions.smali` | `https://www.googleapis.com/auth/games_lite` |
| `apktool/smali/com/google/android/gms/auth/api/signin/GoogleSignInOptions.smali` | `https://www.googleapis.com/auth/games` |
| `apktool/smali/com/google/android/material/chip/Chip.smali` | `http://schemas.android.com/apk/res/android` |
| `apktool/smali/com/google/android/material/chip/Chip.smali` | `http://schemas.android.com/apk/res-auto` |
| `apktool/smali/com/tencent/bugly/proguard/ac.smali` | `https://astat.bugly.qcloud.com/rqd/async` |
| `apktool/smali/com/tencent/bugly/proguard/ac.smali` | `https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async` |
| `apktool/smali/com/tencent/bugly/proguard/ad.smali` | `https://h.trace.qq.com/kv` |
| `apktool/smali/com/tencent/bugly/crashreport/common/strategy/StrategyBean.smali` | `https://android.bugly.qq.com/rqd/async` |
| `apktool/AndroidManifest.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/subtitle_unfocus_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/subtitle_item_pressed.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/subtitle_item_normal.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/subtitle_item_focused.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/subtitle_item_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/subtitle_focus_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_transparent.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_source_item_bg_unfocused.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_source_item_bg_focused.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_signal_strength_normal.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_signal_strength_focused.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_setting_item_normal_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_setting_item_focused_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_rb_unselected.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/shape_rating_bar_divider.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/usercenter_item_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/user_rb_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/tooltip_frame_light.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/tooltip_frame_dark.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/test_level_drawable.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/test_custom_background.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/username_login_btn_select.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/usercenter_item_down.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/lb_headers_right_fading.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/lb_control_button_secondary.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/loginout_select.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/login_bg_unfocus.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/login_bg_select.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/login_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/left_choose.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/lb_speech_orb.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/lb_selectable_item_rounded_rect.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/lb_search_orb.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/lb_playback_progress_bar.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/lb_playback_now_playing_bar.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/lb_onboarding_start_button_background.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/material_ic_keyboard_arrow_right_black_24dp.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/material_ic_keyboard_arrow_left_black_24dp.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/material_ic_edit_black_24dp.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/material_ic_clear_black_24dp.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/material_ic_calendar_black_24dp.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/material_cursor_drawable.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_cast_route_seekbar_track.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_cast_mute_button.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_cast_group_seekbar_track.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_cast_checkbox.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_button_light_static.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_button_light.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_button_dark_static.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_button_dark.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_button_connecting_light.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_button_connecting_dark.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_button_connected_light.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_button_connected_dark.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/menu_rb_bg.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/menu_item_bg_selected.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/menu_item_bg_hint.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/material_ic_menu_arrow_down_black_24dp.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_vol_type_audiotrack_light.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_vol_type_audiotrack_dark.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_media_stop_light.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_media_stop_dark.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_media_play_light.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_media_play_dark.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_media_pause_light.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_media_pause_dark.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_group_expand.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_group_collapse.xml` | `http://schemas.android.com/apk/res/android` |
| `apktool/res/drawable/mr_dialog_close_light.xml` | `http://schemas.android.com/apk/res/android` |

### domínios/hosts

| Arquivo | Valor |
|---|---|
| `jadx/app/src/main/java/p018b5/AbstractC1323w.java` | `plus.google.com` |
| `jadx/app/src/main/java/p046e0/AbstractC2343b.java` | `schemas.android.com` |
| `jadx/app/src/main/java/p047e1/C2363g.java` | `ns.adobe.com` |
| `jadx/app/src/main/java/p055ea/C2428a.java` | `R.string.app` |
| `jadx/app/src/main/java/p063fa/C2509b.java` | `R.layout.app` |
| `jadx/app/src/main/java/p063fa/C2509b.java` | `R.id.app` |
| `jadx/app/src/main/java/p063fa/C2568x.java` | `R.id.tv` |
| `jadx/app/src/main/java/p063fa/C2550o1.java` | `R.id.tv` |
| `jadx/app/src/main/java/sa/C3745p.java` | `R.layout.tv` |
| `jadx/app/src/main/java/p237w0/AbstractC4044e.java` | `issuetracker.google.com` |
| `jadx/app/src/main/java/p249x4/BinderC4115h.java` | `android.com` |
| `jadx/app/src/main/java/p249x4/C4110c.java` | `com.google.android.wearable.app` |
| `jadx/app/src/main/java/p249x4/C4112e.java` | `github.com` |
| `jadx/app/src/main/java/p251x6/C4136o.java` | `R.id.tv` |
| `jadx/app/src/main/java/p275z9/ExecutorC4361c.java` | `Dispatchers.IO` |
| `jadx/app/src/main/java/p116ka/C2924i0.java` | `R.id.tv` |
| `jadx/app/src/main/java/p116ka/ViewOnKeyListenerC2944y.java` | `R.id.tv` |
| `jadx/app/src/main/java/p116ka/ViewOnKeyListenerC2932m0.java` | `R.id.tv` |
| `jadx/app/src/main/java/p104ja/C2815k.java` | `R.id.tv` |
| `jadx/app/src/main/java/p104ja/C2817m.java` | `R.id.tv` |
| `jadx/app/src/main/java/p104ja/C2819o.java` | `R.id.tv` |
| `jadx/app/src/main/java/p104ja/C2821q.java` | `R.id.tv` |
| `jadx/app/src/main/java/p123l5/AbstractC2973a.java` | `com.google.android.tv` |
| `jadx/app/src/main/java/ma/C3091a.java` | `R.id.tv` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0164v.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0168x.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AppLocalesMetadataHolderService.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0134g.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0145l0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/InterfaceC0146m.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0150o.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/ExecutorC0151o0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0152p.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0153p0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0161t0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0162u.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0163u0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AlertController$RecycleListView.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/ActionBar$LayoutParams.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0131e0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState$SavedState.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0125b0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0166w.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0127c0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0130e.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0136h.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0124b.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0129d0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0133f0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0157r0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/RunnableC0147m0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/ExecutorC0149n0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractDialogC0139i0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0128d.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/DialogInterfaceC0140j.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0138i.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0160t.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/RunnableC0156r.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0154q.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AppCompatActivity.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0142k.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0143k0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/ViewOnClickListenerC0141j0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/LayoutInflaterFactory2C0135g0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/AbstractC0170y.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/WindowCallbackC0171z.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0155q0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/ViewOnClickListenerC0122a.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0144l.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0158s.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/RunnableC0148n.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/RunnableC0126c.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0167w0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0165v0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0123a0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/HandlerC0132f.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0159s0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/appcompat/app/C0169x0.java` | `androidx.appcompat.app` |
| `jadx/app/src/main/java/androidx/core/app/CoreComponentFactory.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/NotificationCompatSideChannelService.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0313a.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/InterfaceC0316b.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0317b0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/InterfaceC0319c.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0321c1.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0323d0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0326f.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0327f0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0328g.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0329g0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0331h0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/InterfaceC0336k.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0324e.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0325e0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0353s0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0357u0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0339l0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0341m0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/InterfaceC0342n.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0343n0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0345o0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0358v.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0347p0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/C0359v0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0348q.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0360w.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0349q0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/C0361w0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0350r.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0362x.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0364y.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0351r0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0366z.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/C0363x0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/C0318b1.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/RemoteActionCompat.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/AbstractC0315a1.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/ServiceConnectionC0365y0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/C0367z0.java` | `androidx.core.app` |
| `jadx/app/src/main/java/androidx/core/app/JobIntentService.java` | `androidx.core.app` |

### Firebase/API keys

Nenhuma ocorrência encontrada pelas expressões usadas.

### IPs

| Arquivo | Valor |
|---|---|
| `jadx/app/src/main/java/p222u7/AbstractC3928d.java` | `3.3.3.3` |
| `jadx/app/src/main/java/androidx/media3/exoplayer/rtsp/RtpUtils.java` | `0.0.0.0` |
| `jadx/app/src/main/java/com/tencent/bugly/proguard/C2018aa.java` | `4.1.9.3` |
| `jadx/app/src/main/java/com/tencent/bugly/proguard/C2094p.java` | `4.1.9.3` |
| `apktool/smali/u7/d.smali` | `3.3.3.3` |
| `apktool/smali/androidx/media3/exoplayer/rtsp/RtpUtils.smali` | `0.0.0.0` |
| `apktool/smali/com/tencent/bugly/proguard/aa.smali` | `4.1.9.3` |
| `apktool/smali/com/tencent/bugly/proguard/p.smali` | `4.1.9.3` |

## Certificado de assinatura

```text
Signer #1:

Certificate #1:
Owner: CN=SERV, OU=SERV, O=SERV, L=SERV, ST=SERV, C=SERV
Issuer: CN=SERV, OU=SERV, O=SERV, L=SERV, ST=SERV, C=SERV
Serial number: d97b5941d050c7e3
Valid from: Thu Feb 13 06:46:41 UTC 2025 until: Mon Jul 01 06:46:41 UTC 2052
Certificate fingerprints:
	 SHA1: 6B:34:05:A9:2A:D9:DD:86:1A:32:13:AE:AD:31:3A:90:93:B3:4A:A3
	 SHA256: E1:20:B4:19:85:41:53:BE:60:20:76:80:48:F5:A2:4A:00:15:48:28:69:DD:D6:06:4D:CD:FF:7F:56:FB:99:2D
Signature algorithm name: SHA256withRSA
Subject Public Key Algorithm: 2048-bit RSA key
Version: 3

Extensions: 

#1: ObjectId: 2.5.29.14 Criticality=false
SubjectKeyIdentifier [
KeyIdentifier [
0000: EB 82 43 43 6D 63 D4 CC   DE C0 40 19 6A 46 25 E3  ..CCmc....@.jF%.
0010: 34 1F 60 10                                        4.`.
]
]
```

## Observações

- O pacote contém duas imagens DEX (`classes.dex` e `classes2.dex`).
- O manifesto permite tráfego HTTP sem TLS por `usesCleartextTraffic="true"`.
- Há componentes que reagem a inicialização do dispositivo, mudanças de conectividade, tela ligada/desligada e ajuste de horário.
- Bibliotecas nativas (`libgojni.so`, `libtvcore.so`, `libffmpegJNI.so`, entre outras) não são convertidas integralmente em Java; a análise deve preservar os binários e registrar essa limitação.

