.class public final Lea/b0;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic a:Lea/k;


# direct methods
.method public constructor <init>(Lea/k;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lea/b0;->a:Lea/k;

    .line 5
    .line 6
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 26

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    iget-object v0, v1, Lea/b0;->a:Lea/k;

    .line 4
    .line 5
    iget-object v2, v0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 6
    .line 7
    invoke-virtual {v2}, Lorg/bitspark/android/Spark;->c0()Z

    .line 8
    .line 9
    .line 10
    move-result v2

    .line 11
    iget-object v0, v0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 12
    .line 13
    if-nez v2, :cond_1

    .line 14
    .line 15
    iget-object v2, v0, Lorg/bitspark/android/Spark;->J1:Landroidx/media3/exoplayer/ExoPlayer;

    .line 16
    .line 17
    invoke-interface {v2}, Landroidx/media3/common/Player;->isPlaying()Z

    .line 18
    .line 19
    .line 20
    move-result v2

    .line 21
    if-eqz v2, :cond_0

    .line 22
    .line 23
    iget-object v2, v0, Lorg/bitspark/android/Spark;->R:Landroid/widget/ImageView;

    .line 24
    .line 25
    invoke-virtual {v2}, Landroid/view/View;->performClick()Z

    .line 26
    .line 27
    .line 28
    goto :goto_0

    .line 29
    :cond_0
    iget-object v2, v0, Lorg/bitspark/android/Spark;->J1:Landroidx/media3/exoplayer/ExoPlayer;

    .line 30
    .line 31
    invoke-interface {v2}, Landroidx/media3/common/Player;->pause()V

    .line 32
    .line 33
    .line 34
    goto :goto_0

    .line 35
    :cond_1
    iget-object v2, v0, Lorg/bitspark/android/Spark;->J1:Landroidx/media3/exoplayer/ExoPlayer;

    .line 36
    .line 37
    invoke-interface {v2}, Landroidx/media3/common/Player;->pause()V

    .line 38
    .line 39
    .line 40
    :goto_0
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 41
    .line 42
    .line 43
    move-result-object v2

    .line 44
    iget-boolean v3, v2, Lorg/bitspark/android/utils/b;->h:Z

    .line 45
    .line 46
    if-nez v3, :cond_2

    .line 47
    .line 48
    goto/16 :goto_5

    .line 49
    .line 50
    :cond_2
    if-nez v3, :cond_3

    .line 51
    .line 52
    goto/16 :goto_5

    .line 53
    .line 54
    :cond_3
    iget-object v3, v2, Lorg/bitspark/android/utils/b;->f:Lq4/c;

    .line 55
    .line 56
    if-nez v3, :cond_4

    .line 57
    .line 58
    iget-object v3, v2, Lorg/bitspark/android/utils/b;->d:Lq4/b;

    .line 59
    .line 60
    invoke-virtual {v3}, Lq4/b;->a()Lq4/h;

    .line 61
    .line 62
    .line 63
    move-result-object v3

    .line 64
    invoke-virtual {v3}, Lq4/h;->c()Lq4/c;

    .line 65
    .line 66
    .line 67
    move-result-object v3

    .line 68
    iput-object v3, v2, Lorg/bitspark/android/utils/b;->f:Lq4/c;

    .line 69
    .line 70
    if-nez v3, :cond_4

    .line 71
    .line 72
    goto/16 :goto_5

    .line 73
    .line 74
    :cond_4
    iget-boolean v3, v2, Lorg/bitspark/android/utils/b;->h:Z

    .line 75
    .line 76
    if-nez v3, :cond_5

    .line 77
    .line 78
    goto/16 :goto_5

    .line 79
    .line 80
    :cond_5
    iget-object v3, v2, Lorg/bitspark/android/utils/b;->n:Lr4/f;

    .line 81
    .line 82
    if-nez v3, :cond_6

    .line 83
    .line 84
    iget-object v3, v2, Lorg/bitspark/android/utils/b;->f:Lq4/c;

    .line 85
    .line 86
    invoke-virtual {v3}, Lq4/c;->f()Lr4/f;

    .line 87
    .line 88
    .line 89
    move-result-object v3

    .line 90
    iput-object v3, v2, Lorg/bitspark/android/utils/b;->n:Lr4/f;

    .line 91
    .line 92
    if-nez v3, :cond_6

    .line 93
    .line 94
    goto/16 :goto_5

    .line 95
    .line 96
    :cond_6
    iget-object v2, v2, Lorg/bitspark/android/utils/b;->m:Ljava/lang/String;

    .line 97
    .line 98
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    .line 99
    .line 100
    .line 101
    move-result v2

    .line 102
    if-eqz v2, :cond_7

    .line 103
    .line 104
    goto/16 :goto_5

    .line 105
    .line 106
    :cond_7
    iget-object v2, v0, Lorg/bitspark/android/Spark;->E1:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 107
    .line 108
    sget-object v3, Lorg/bitspark/android/Constants$VIDEO_TYPE;->BSLIVE:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 109
    .line 110
    const-wide/16 v4, 0x0

    .line 111
    .line 112
    if-ne v2, v3, :cond_8

    .line 113
    .line 114
    invoke-static {}, Lra/f;->b()Lra/f;

    .line 115
    .line 116
    .line 117
    move-result-object v2

    .line 118
    iget-object v2, v2, Lra/f;->e:Lorg/bitspark/android/beans/ChannelBean;

    .line 119
    .line 120
    invoke-virtual {v2}, Lorg/bitspark/android/beans/ChannelBean;->getName()Lorg/bitspark/android/beans/ChannelBean$NameBean;

    .line 121
    .line 122
    .line 123
    move-result-object v2

    .line 124
    invoke-virtual {v2}, Lorg/bitspark/android/beans/ChannelBean$NameBean;->getInit()Ljava/lang/String;

    .line 125
    .line 126
    .line 127
    move-result-object v2

    .line 128
    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    .line 129
    .line 130
    .line 131
    move-result-object v2

    .line 132
    iget-object v3, v0, Lorg/bitspark/android/Spark;->t1:Landroid/widget/TextView;

    .line 133
    .line 134
    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    .line 135
    .line 136
    .line 137
    move-result-object v3

    .line 138
    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 139
    .line 140
    .line 141
    move-result-object v3

    .line 142
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 143
    .line 144
    .line 145
    invoke-static {}, Lorg/bitspark/android/Spark;->Y()Ljava/lang/String;

    .line 146
    .line 147
    .line 148
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 149
    .line 150
    .line 151
    move-result-object v0

    .line 152
    iput-object v2, v0, Lorg/bitspark/android/utils/b;->l:Ljava/lang/String;

    .line 153
    .line 154
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 155
    .line 156
    .line 157
    move-result-object v0

    .line 158
    iput-object v3, v0, Lorg/bitspark/android/utils/b;->k:Ljava/lang/String;

    .line 159
    .line 160
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 161
    .line 162
    .line 163
    move-result-object v0

    .line 164
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 165
    .line 166
    .line 167
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 168
    .line 169
    .line 170
    move-result-object v0

    .line 171
    iput-wide v4, v0, Lorg/bitspark/android/utils/b;->j:J

    .line 172
    .line 173
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 174
    .line 175
    .line 176
    move-result-object v0

    .line 177
    iput-wide v4, v0, Lorg/bitspark/android/utils/b;->i:J

    .line 178
    .line 179
    :cond_8
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 180
    .line 181
    .line 182
    move-result-object v2

    .line 183
    iget-boolean v0, v2, Lorg/bitspark/android/utils/b;->h:Z

    .line 184
    .line 185
    if-nez v0, :cond_9

    .line 186
    .line 187
    goto/16 :goto_5

    .line 188
    .line 189
    :cond_9
    new-instance v10, Lcom/google/android/gms/cast/MediaMetadata;

    .line 190
    .line 191
    const/4 v0, 0x1

    .line 192
    invoke-direct {v10, v0}, Lcom/google/android/gms/cast/MediaMetadata;-><init>(I)V

    .line 193
    .line 194
    .line 195
    iget-object v3, v2, Lorg/bitspark/android/utils/b;->k:Ljava/lang/String;

    .line 196
    .line 197
    iget-object v6, v10, Lcom/google/android/gms/cast/MediaMetadata;->b:Landroid/os/Bundle;

    .line 198
    .line 199
    if-eqz v3, :cond_a

    .line 200
    .line 201
    const-string v3, "g5Z34RDHeJOMnDSuGcxlm4mdNKga2zmXgYpu4RrNY5WEmG6uWftCtrSwToMy\n"

    .line 202
    .line 203
    const-string v7, "4Pkaz3eoF/Q=\n"

    .line 204
    .line 205
    invoke-static {v3, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 206
    .line 207
    .line 208
    move-result-object v3

    .line 209
    iget-object v7, v2, Lorg/bitspark/android/utils/b;->k:Ljava/lang/String;

    .line 210
    .line 211
    invoke-static {v0, v3}, Lcom/google/android/gms/cast/MediaMetadata;->j(ILjava/lang/String;)V

    .line 212
    .line 213
    .line 214
    invoke-virtual {v6, v3, v7}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    .line 216
    .line 217
    :cond_a
    iget-object v3, v2, Lorg/bitspark/android/utils/b;->l:Ljava/lang/String;

    .line 218
    .line 219
    if-eqz v3, :cond_b

    .line 220
    .line 221
    const-string v3, "ZI6aN52Mq8BrhNl4lIe2yG6F2X6XkOrEZpKDN5eGsMZjgIN41LeN80uk\n"

    .line 222
    .line 223
    const-string v7, "B+H3GfrjxKc=\n"

    .line 224
    .line 225
    invoke-static {v3, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 226
    .line 227
    .line 228
    move-result-object v3

    .line 229
    iget-object v7, v2, Lorg/bitspark/android/utils/b;->l:Ljava/lang/String;

    .line 230
    .line 231
    invoke-static {v0, v3}, Lcom/google/android/gms/cast/MediaMetadata;->j(ILjava/lang/String;)V

    .line 232
    .line 233
    .line 234
    invoke-virtual {v6, v3, v7}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    .line 236
    .line 237
    :cond_b
    iget-object v0, v2, Lorg/bitspark/android/utils/b;->m:Ljava/lang/String;

    .line 238
    .line 239
    const-string v3, "dgypdQ==\n"

    .line 240
    .line 241
    const-string v6, "Gz/cTddxNv0=\n"

    .line 242
    .line 243
    invoke-static {v3, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 244
    .line 245
    .line 246
    move-result-object v3

    .line 247
    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    .line 248
    .line 249
    .line 250
    move-result v0

    .line 251
    if-eqz v0, :cond_f

    .line 252
    .line 253
    iget-object v3, v2, Lorg/bitspark/android/utils/b;->m:Ljava/lang/String;

    .line 254
    .line 255
    :try_start_0
    invoke-static {}, Ljava/net/NetworkInterface;->getNetworkInterfaces()Ljava/util/Enumeration;

    .line 256
    .line 257
    .line 258
    move-result-object v0

    .line 259
    invoke-static {v0}, Ljava/util/Collections;->list(Ljava/util/Enumeration;)Ljava/util/ArrayList;

    .line 260
    .line 261
    .line 262
    move-result-object v0

    .line 263
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 264
    .line 265
    .line 266
    move-result-object v0

    .line 267
    :cond_c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 268
    .line 269
    .line 270
    move-result v6

    .line 271
    if-eqz v6, :cond_e

    .line 272
    .line 273
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 274
    .line 275
    .line 276
    move-result-object v6

    .line 277
    check-cast v6, Ljava/net/NetworkInterface;

    .line 278
    .line 279
    invoke-virtual {v6}, Ljava/net/NetworkInterface;->getInetAddresses()Ljava/util/Enumeration;

    .line 280
    .line 281
    .line 282
    move-result-object v6

    .line 283
    invoke-static {v6}, Ljava/util/Collections;->list(Ljava/util/Enumeration;)Ljava/util/ArrayList;

    .line 284
    .line 285
    .line 286
    move-result-object v6

    .line 287
    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 288
    .line 289
    .line 290
    move-result-object v6

    .line 291
    :cond_d
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    .line 292
    .line 293
    .line 294
    move-result v7

    .line 295
    if-eqz v7, :cond_c

    .line 296
    .line 297
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 298
    .line 299
    .line 300
    move-result-object v7

    .line 301
    check-cast v7, Ljava/net/InetAddress;

    .line 302
    .line 303
    invoke-virtual {v7}, Ljava/net/InetAddress;->isLoopbackAddress()Z

    .line 304
    .line 305
    .line 306
    move-result v8

    .line 307
    if-nez v8, :cond_d

    .line 308
    .line 309
    invoke-virtual {v7}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    .line 310
    .line 311
    .line 312
    move-result-object v8

    .line 313
    const/16 v9, 0x3a

    .line 314
    .line 315
    invoke-virtual {v8, v9}, Ljava/lang/String;->indexOf(I)I

    .line 316
    .line 317
    .line 318
    move-result v8

    .line 319
    const/4 v9, -0x1

    .line 320
    if-ne v8, v9, :cond_d

    .line 321
    .line 322
    invoke-virtual {v7}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    .line 323
    .line 324
    .line 325
    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 326
    goto :goto_1

    .line 327
    :catch_0
    move-exception v0

    .line 328
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 329
    .line 330
    .line 331
    :cond_e
    const/4 v0, 0x0

    .line 332
    :goto_1
    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    .line 333
    .line 334
    .line 335
    move-result-object v3

    .line 336
    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    .line 337
    .line 338
    .line 339
    move-result-object v6

    .line 340
    invoke-static {v0}, Lea/q;->l(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 341
    .line 342
    .line 343
    move-result-object v0

    .line 344
    const-string v7, "Kw==\n"

    .line 345
    .line 346
    const-string v8, "EShGbVwqx6o=\n"

    .line 347
    .line 348
    invoke-static {v7, v8}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 349
    .line 350
    .line 351
    move-result-object v7

    .line 352
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 353
    .line 354
    .line 355
    invoke-virtual {v3}, Landroid/net/Uri;->getPort()I

    .line 356
    .line 357
    .line 358
    move-result v3

    .line 359
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 360
    .line 361
    .line 362
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 363
    .line 364
    .line 365
    move-result-object v0

    .line 366
    invoke-virtual {v6, v0}, Landroid/net/Uri$Builder;->encodedAuthority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 367
    .line 368
    .line 369
    move-result-object v0

    .line 370
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    .line 371
    .line 372
    .line 373
    move-result-object v0

    .line 374
    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    .line 375
    .line 376
    .line 377
    move-result-object v0

    .line 378
    :goto_2
    move-object v7, v0

    .line 379
    goto :goto_3

    .line 380
    :cond_f
    iget-object v0, v2, Lorg/bitspark/android/utils/b;->m:Ljava/lang/String;

    .line 381
    .line 382
    goto :goto_2

    .line 383
    :goto_3
    const-string v0, "SHMQYcwtLwEa\n"

    .line 384
    .line 385
    const-string v3, "OhZxDZlfQzs=\n"

    .line 386
    .line 387
    invoke-static {v0, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 388
    .line 389
    .line 390
    const-string v0, "eVfXcr3VdLR/Cg==\n"

    .line 391
    .line 392
    const-string v3, "Dz6zF9KmW9k=\n"

    .line 393
    .line 394
    invoke-static {v0, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 395
    .line 396
    .line 397
    move-result-object v9

    .line 398
    iget-wide v11, v2, Lorg/bitspark/android/utils/b;->j:J

    .line 399
    .line 400
    cmp-long v0, v11, v4

    .line 401
    .line 402
    if-gez v0, :cond_11

    .line 403
    .line 404
    const-wide/16 v3, -0x1

    .line 405
    .line 406
    cmp-long v0, v11, v3

    .line 407
    .line 408
    if-nez v0, :cond_10

    .line 409
    .line 410
    goto :goto_4

    .line 411
    :cond_10
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 412
    .line 413
    const-string v2, "Invalid stream duration"

    .line 414
    .line 415
    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 416
    .line 417
    .line 418
    throw v0

    .line 419
    :cond_11
    :goto_4
    new-instance v4, Lcom/google/android/gms/cast/MediaInfo;

    .line 420
    .line 421
    move-object v6, v4

    .line 422
    const/16 v22, 0x0

    .line 423
    .line 424
    const/16 v23, 0x0

    .line 425
    .line 426
    const/4 v8, 0x1

    .line 427
    const/4 v13, 0x0

    .line 428
    const/4 v14, 0x0

    .line 429
    const/4 v15, 0x0

    .line 430
    const/16 v16, 0x0

    .line 431
    .line 432
    const/16 v17, 0x0

    .line 433
    .line 434
    const/16 v18, 0x0

    .line 435
    .line 436
    const/16 v19, 0x0

    .line 437
    .line 438
    const-wide/16 v20, -0x1

    .line 439
    .line 440
    const/16 v24, 0x0

    .line 441
    .line 442
    const/16 v25, 0x0

    .line 443
    .line 444
    invoke-direct/range {v6 .. v25}, Lcom/google/android/gms/cast/MediaInfo;-><init>(Ljava/lang/String;ILjava/lang/String;Lcom/google/android/gms/cast/MediaMetadata;JLjava/util/ArrayList;Lcom/google/android/gms/cast/TextTrackStyle;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lcom/google/android/gms/cast/VastAdsRequest;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 445
    .line 446
    .line 447
    iget-object v0, v2, Lorg/bitspark/android/utils/b;->n:Lr4/f;

    .line 448
    .line 449
    sget-object v6, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 450
    .line 451
    const-string v3, "968luulHMunmuS68rUUs/w==\n"

    .line 452
    .line 453
    const-string v5, "gtxAyMQkQIw=\n"

    .line 454
    .line 455
    invoke-static {v3, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 456
    .line 457
    .line 458
    move-result-object v13

    .line 459
    const-string v3, "PNXOn0ZqH5ZwwsrXV3wUkDTA1ME=\n"

    .line 460
    .line 461
    const-string v5, "XaG4sjMZeuQ=\n"

    .line 462
    .line 463
    invoke-static {v3, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 464
    .line 465
    .line 466
    move-result-object v15

    .line 467
    iget-wide v7, v2, Lorg/bitspark/android/utils/b;->i:J

    .line 468
    .line 469
    new-instance v2, Lcom/google/android/gms/cast/MediaLoadRequestData;

    .line 470
    .line 471
    const/16 v16, 0x0

    .line 472
    .line 473
    const-wide/16 v17, 0x0

    .line 474
    .line 475
    const/4 v5, 0x0

    .line 476
    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    .line 477
    .line 478
    const/4 v11, 0x0

    .line 479
    const/4 v12, 0x0

    .line 480
    const/4 v14, 0x0

    .line 481
    move-object v3, v2

    .line 482
    invoke-direct/range {v3 .. v18}, Lcom/google/android/gms/cast/MediaLoadRequestData;-><init>(Lcom/google/android/gms/cast/MediaInfo;Lcom/google/android/gms/cast/MediaQueueData;Ljava/lang/Boolean;JD[JLorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    .line 483
    .line 484
    .line 485
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 486
    .line 487
    .line 488
    const-string v3, "Must be called from the main thread."

    .line 489
    .line 490
    invoke-static {v3}, Lb5/l;->b(Ljava/lang/String;)V

    .line 491
    .line 492
    .line 493
    invoke-virtual {v0}, Lr4/f;->F()Z

    .line 494
    .line 495
    .line 496
    move-result v3

    .line 497
    if-nez v3, :cond_12

    .line 498
    .line 499
    invoke-static {}, Lr4/f;->x()Lr4/m;

    .line 500
    .line 501
    .line 502
    goto :goto_5

    .line 503
    :cond_12
    new-instance v3, Lr4/i;

    .line 504
    .line 505
    const/4 v4, 0x1

    .line 506
    invoke-direct {v3, v0, v2, v4}, Lr4/i;-><init>(Lr4/f;Ljava/lang/Object;I)V

    .line 507
    .line 508
    .line 509
    invoke-static {v3}, Lr4/f;->G(Lr4/o;)V

    .line 510
    .line 511
    .line 512
    :goto_5
    return-void
.end method
