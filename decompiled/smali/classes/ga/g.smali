.class public final Lga/g;
.super Ljava/lang/Thread;
.source "MyApplication"


# instance fields
.field public final synthetic a:Ljava/io/File;

.field public final synthetic b:Lga/h;


# direct methods
.method public constructor <init>(Lga/h;Ljava/io/File;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lga/g;->b:Lga/h;

    .line 2
    .line 3
    iput-object p2, p0, Lga/g;->a:Ljava/io/File;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 17

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0}, Ljava/lang/Runtime;->totalMemory()J

    .line 8
    .line 9
    .line 10
    move-result-wide v2

    .line 11
    long-to-int v0, v2

    .line 12
    const-string v4, "AZR68Ek=\n"

    .line 13
    .line 14
    const-string v5, "Q8c/oA6LwTk=\n"

    .line 15
    .line 16
    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object v4

    .line 20
    new-instance v5, Ljava/lang/StringBuilder;

    .line 21
    .line 22
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 23
    .line 24
    .line 25
    const-string v6, "Ays/RBfSZ78DKz9EF5s19l96TxxHgCj7BDY=\n"

    .line 26
    .line 27
    const-string v7, "PhYCeSrvWoI=\n"

    .line 28
    .line 29
    invoke-static {v6, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 30
    .line 31
    .line 32
    move-result-object v6

    .line 33
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 34
    .line 35
    .line 36
    invoke-virtual {v5, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 37
    .line 38
    .line 39
    const-string v2, "mXSvf5ge8nvDcvQ8\n"

    .line 40
    .line 41
    const-string v3, "uRfOHPB7oRI=\n"

    .line 42
    .line 43
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 44
    .line 45
    .line 46
    move-result-object v2

    .line 47
    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 48
    .line 49
    .line 50
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 54
    .line 55
    .line 56
    move-result-object v0

    .line 57
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 58
    .line 59
    invoke-static {v4, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    .line 61
    .line 62
    new-instance v0, Ljava/util/Date;

    .line 63
    .line 64
    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 65
    .line 66
    .line 67
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    .line 68
    .line 69
    .line 70
    move-result-wide v2

    .line 71
    sget-wide v4, Lorg/bitspark/android/utils/m;->a:J

    .line 72
    .line 73
    add-long/2addr v2, v4

    .line 74
    const-wide/32 v4, 0x5265c00

    .line 75
    .line 76
    .line 77
    add-long/2addr v2, v4

    .line 78
    invoke-static {v2, v3}, Lorg/bitspark/android/utils/m;->c(J)J

    .line 79
    .line 80
    .line 81
    move-result-wide v2

    .line 82
    const-string v0, "y9whau4=\n"

    .line 83
    .line 84
    const-string v4, "iY9kOqmJjcs=\n"

    .line 85
    .line 86
    invoke-static {v0, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 87
    .line 88
    .line 89
    move-result-object v0

    .line 90
    new-instance v4, Ljava/lang/StringBuilder;

    .line 91
    .line 92
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 93
    .line 94
    .line 95
    const-string v5, "6dX1zz+LpR7q4P3QP62+HPia\n"

    .line 96
    .line 97
    const-string v6, "nbqYolD513E=\n"

    .line 98
    .line 99
    invoke-static {v5, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 100
    .line 101
    .line 102
    move-result-object v5

    .line 103
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 104
    .line 105
    .line 106
    iget-object v5, v1, Lga/g;->b:Lga/h;

    .line 107
    .line 108
    iget-object v5, v5, Lga/h;->a:Ljava/text/SimpleDateFormat;

    .line 109
    .line 110
    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 111
    .line 112
    .line 113
    move-result-object v2

    .line 114
    invoke-virtual {v5, v2}, Ljava/text/Format;->format(Ljava/lang/Object;)Ljava/lang/String;

    .line 115
    .line 116
    .line 117
    move-result-object v2

    .line 118
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 119
    .line 120
    .line 121
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 122
    .line 123
    .line 124
    move-result-object v2

    .line 125
    invoke-static {v0, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    .line 127
    .line 128
    :try_start_0
    new-instance v0, Ljava/util/Date;

    .line 129
    .line 130
    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 131
    .line 132
    .line 133
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    .line 134
    .line 135
    .line 136
    move-result-wide v2

    .line 137
    iget-object v0, v1, Lga/g;->a:Ljava/io/File;

    .line 138
    .line 139
    invoke-static {v0}, Lga/h;->e(Ljava/io/File;)Ljava/util/ArrayList;

    .line 140
    .line 141
    .line 142
    move-result-object v0

    .line 143
    const/4 v4, 0x0

    .line 144
    const/4 v5, 0x0

    .line 145
    :goto_0
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 146
    .line 147
    .line 148
    move-result v6

    .line 149
    if-ge v5, v6, :cond_5

    .line 150
    .line 151
    new-instance v6, Ljava/util/HashMap;

    .line 152
    .line 153
    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 154
    .line 155
    .line 156
    new-instance v7, Ljava/util/ArrayList;

    .line 157
    .line 158
    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 159
    .line 160
    .line 161
    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 162
    .line 163
    .line 164
    move-result-object v8

    .line 165
    check-cast v8, Lorg/bitspark/android/beans/EpgBeans;

    .line 166
    .line 167
    invoke-virtual {v8}, Lorg/bitspark/android/beans/EpgBeans;->getEpg()Ljava/util/List;

    .line 168
    .line 169
    .line 170
    move-result-object v8

    .line 171
    new-instance v9, Lga/f;

    .line 172
    .line 173
    invoke-direct {v9}, Ljava/lang/Object;-><init>()V

    .line 174
    .line 175
    .line 176
    invoke-static {v8, v9}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 177
    .line 178
    .line 179
    const-wide/16 v9, 0x0

    .line 180
    .line 181
    move-wide v12, v9

    .line 182
    const/4 v11, 0x0

    .line 183
    :goto_1
    invoke-interface {v8}, Ljava/util/List;->size()I

    .line 184
    .line 185
    .line 186
    move-result v14

    .line 187
    if-ge v11, v14, :cond_2

    .line 188
    .line 189
    sget-object v14, Lea/h;->a:Ljava/lang/String;

    .line 190
    .line 191
    invoke-interface {v8, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 192
    .line 193
    .line 194
    move-result-object v14

    .line 195
    check-cast v14, Lorg/bitspark/android/beans/EpgBeans$EpgBean;

    .line 196
    .line 197
    invoke-virtual {v14}, Lorg/bitspark/android/beans/EpgBeans$EpgBean;->getTime()Ljava/lang/Long;

    .line 198
    .line 199
    .line 200
    move-result-object v14

    .line 201
    invoke-virtual {v14}, Ljava/lang/Long;->longValue()J

    .line 202
    .line 203
    .line 204
    move-result-wide v14

    .line 205
    invoke-static {v14, v15}, Lorg/bitspark/android/utils/m;->c(J)J

    .line 206
    .line 207
    .line 208
    move-result-wide v14

    .line 209
    cmp-long v16, v12, v14

    .line 210
    .line 211
    if-eqz v16, :cond_1

    .line 212
    .line 213
    cmp-long v16, v12, v9

    .line 214
    .line 215
    if-eqz v16, :cond_0

    .line 216
    .line 217
    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 218
    .line 219
    .line 220
    move-result-object v12

    .line 221
    invoke-virtual {v6, v12, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    .line 223
    .line 224
    new-instance v7, Ljava/util/ArrayList;

    .line 225
    .line 226
    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 227
    .line 228
    .line 229
    goto :goto_2

    .line 230
    :catchall_0
    move-exception v0

    .line 231
    goto/16 :goto_4

    .line 232
    .line 233
    :catch_0
    move-exception v0

    .line 234
    goto/16 :goto_5

    .line 235
    .line 236
    :cond_0
    :goto_2
    invoke-interface {v8, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 237
    .line 238
    .line 239
    move-result-object v12

    .line 240
    check-cast v12, Lorg/bitspark/android/beans/EpgBeans$EpgBean;

    .line 241
    .line 242
    invoke-interface {v7, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 243
    .line 244
    .line 245
    move-wide v12, v14

    .line 246
    goto :goto_3

    .line 247
    :cond_1
    invoke-interface {v8, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 248
    .line 249
    .line 250
    move-result-object v14

    .line 251
    check-cast v14, Lorg/bitspark/android/beans/EpgBeans$EpgBean;

    .line 252
    .line 253
    invoke-interface {v7, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 254
    .line 255
    .line 256
    :goto_3
    add-int/lit8 v11, v11, 0x1

    .line 257
    .line 258
    goto :goto_1

    .line 259
    :cond_2
    invoke-interface {v7}, Ljava/util/List;->size()I

    .line 260
    .line 261
    .line 262
    move-result v8

    .line 263
    if-lez v8, :cond_3

    .line 264
    .line 265
    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 266
    .line 267
    .line 268
    move-result-object v8

    .line 269
    invoke-virtual {v6, v8, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 270
    .line 271
    .line 272
    :cond_3
    invoke-virtual {v6}, Ljava/util/HashMap;->size()I

    .line 273
    .line 274
    .line 275
    move-result v7

    .line 276
    if-lez v7, :cond_4

    .line 277
    .line 278
    sget-object v7, Lorg/bitspark/android/Spark;->d2:Lda/c;

    .line 279
    .line 280
    new-instance v8, Ljava/lang/StringBuilder;

    .line 281
    .line 282
    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 283
    .line 284
    .line 285
    const-string v9, "Sj7Ti/p9V4wEMtOc+g==\n"

    .line 286
    .line 287
    const-string v10, "KVay5dcYJ+s=\n"

    .line 288
    .line 289
    invoke-static {v9, v10}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 290
    .line 291
    .line 292
    move-result-object v9

    .line 293
    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 294
    .line 295
    .line 296
    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 297
    .line 298
    .line 299
    move-result-object v9

    .line 300
    check-cast v9, Lorg/bitspark/android/beans/EpgBeans;

    .line 301
    .line 302
    invoke-virtual {v9}, Lorg/bitspark/android/beans/EpgBeans;->getId()I

    .line 303
    .line 304
    .line 305
    move-result v9

    .line 306
    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 307
    .line 308
    .line 309
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 310
    .line 311
    .line 312
    move-result-object v8

    .line 313
    invoke-virtual {v7, v8}, Lda/c;->g(Ljava/lang/String;)V

    .line 314
    .line 315
    .line 316
    sget-object v7, Lorg/bitspark/android/Spark;->d2:Lda/c;

    .line 317
    .line 318
    new-instance v8, Ljava/lang/StringBuilder;

    .line 319
    .line 320
    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 321
    .line 322
    .line 323
    const-string v9, "qpKFW2J5tv3knoVMYg==\n"

    .line 324
    .line 325
    const-string v10, "yfrkNU8cxpo=\n"

    .line 326
    .line 327
    invoke-static {v9, v10}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 328
    .line 329
    .line 330
    move-result-object v9

    .line 331
    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 332
    .line 333
    .line 334
    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 335
    .line 336
    .line 337
    move-result-object v9

    .line 338
    check-cast v9, Lorg/bitspark/android/beans/EpgBeans;

    .line 339
    .line 340
    invoke-virtual {v9}, Lorg/bitspark/android/beans/EpgBeans;->getId()I

    .line 341
    .line 342
    .line 343
    move-result v9

    .line 344
    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 345
    .line 346
    .line 347
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 348
    .line 349
    .line 350
    move-result-object v8

    .line 351
    sget v9, Lea/h;->g:I

    .line 352
    .line 353
    div-int/lit16 v9, v9, 0x3e8

    .line 354
    .line 355
    invoke-virtual {v7, v8, v6, v9}, Lda/c;->d(Ljava/lang/String;Ljava/io/Serializable;I)V

    .line 356
    .line 357
    .line 358
    :cond_4
    add-int/lit8 v5, v5, 0x1

    .line 359
    .line 360
    goto/16 :goto_0

    .line 361
    .line 362
    :cond_5
    sget-object v0, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 363
    .line 364
    const/16 v4, 0x12d

    .line 365
    .line 366
    invoke-virtual {v0, v4}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 367
    .line 368
    .line 369
    const-string v0, "q3SwdVI=\n"

    .line 370
    .line 371
    const-string v4, "6Sf1JRUPCfA=\n"

    .line 372
    .line 373
    invoke-static {v0, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 374
    .line 375
    .line 376
    move-result-object v0

    .line 377
    new-instance v4, Ljava/lang/StringBuilder;

    .line 378
    .line 379
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 380
    .line 381
    .line 382
    const-string v5, "Y5TDe6HdBy5v0cdn5ooKNWmUgjmvhA==\n"

    .line 383
    .line 384
    const-string v6, "B/GiF4Gqblo=\n"

    .line 385
    .line 386
    invoke-static {v5, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 387
    .line 388
    .line 389
    move-result-object v5

    .line 390
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 391
    .line 392
    .line 393
    new-instance v5, Ljava/util/Date;

    .line 394
    .line 395
    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    .line 396
    .line 397
    .line 398
    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    .line 399
    .line 400
    .line 401
    move-result-wide v5

    .line 402
    sub-long/2addr v5, v2

    .line 403
    invoke-virtual {v4, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 404
    .line 405
    .line 406
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 407
    .line 408
    .line 409
    move-result-object v2

    .line 410
    invoke-static {v0, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 411
    .line 412
    .line 413
    goto :goto_6

    .line 414
    :goto_4
    throw v0

    .line 415
    :goto_5
    const-string v2, "M07e2Es=\n"

    .line 416
    .line 417
    const-string v3, "cR2biAwS6UI=\n"

    .line 418
    .line 419
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 420
    .line 421
    .line 422
    move-result-object v2

    .line 423
    const-string v3, "QhEv8+Ia/XlVUDnh81u4bEACMvKm\n"

    .line 424
    .line 425
    const-string v4, "MnBdgIc6mAk=\n"

    .line 426
    .line 427
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 428
    .line 429
    .line 430
    move-result-object v3

    .line 431
    invoke-static {v2, v3}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 432
    .line 433
    .line 434
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 435
    .line 436
    .line 437
    :goto_6
    return-void
.end method
