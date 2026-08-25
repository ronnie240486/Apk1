.class public final Lr4/i;
.super Lr4/o;
.source "MyApplication"


# instance fields
.field public final synthetic u:I

.field public final synthetic v:Lr4/f;

.field public final synthetic w:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Lr4/f;Ljava/lang/Object;I)V
    .locals 0

    .line 1
    iput p3, p0, Lr4/i;->u:I

    iput-object p2, p0, Lr4/i;->w:Ljava/lang/Object;

    iput-object p1, p0, Lr4/i;->v:Lr4/f;

    const/4 p2, 0x0

    invoke-direct {p0, p1, p2}, Lr4/o;-><init>(Lr4/f;Z)V

    return-void
.end method

.method public constructor <init>(Lr4/f;[I)V
    .locals 1

    const/4 v0, 0x0

    iput v0, p0, Lr4/i;->u:I

    .line 2
    iput-object p2, p0, Lr4/i;->w:Ljava/lang/Object;

    iput-object p1, p0, Lr4/i;->v:Lr4/f;

    const/4 p2, 0x1

    invoke-direct {p0, p1, p2}, Lr4/o;-><init>(Lr4/f;Z)V

    return-void
.end method


# virtual methods
.method public final k0()V
    .locals 18

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    const-wide v2, 0x408f400000000000L    # 1000.0

    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    const-string v0, "currentTime"

    .line 9
    .line 10
    const-string v4, "activeTrackIds"

    .line 11
    .line 12
    const-string v5, "mediaSessionId"

    .line 13
    .line 14
    const/4 v6, 0x1

    .line 15
    const-string v7, "type"

    .line 16
    .line 17
    const-string v8, "requestId"

    .line 18
    .line 19
    iget-object v9, v1, Lr4/i;->w:Ljava/lang/Object;

    .line 20
    .line 21
    iget-object v10, v1, Lr4/i;->v:Lr4/f;

    .line 22
    .line 23
    const/4 v11, 0x0

    .line 24
    iget v12, v1, Lr4/i;->u:I

    .line 25
    .line 26
    packed-switch v12, :pswitch_data_0

    .line 27
    .line 28
    .line 29
    iget-object v0, v10, Lr4/f;->c:Lv4/l;

    .line 30
    .line 31
    invoke-virtual/range {p0 .. p0}, Lr4/o;->l0()Lv4/m;

    .line 32
    .line 33
    .line 34
    move-result-object v2

    .line 35
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 36
    .line 37
    .line 38
    check-cast v9, [J

    .line 39
    .line 40
    new-instance v3, Lorg/json/JSONObject;

    .line 41
    .line 42
    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 43
    .line 44
    .line 45
    invoke-virtual {v0}, Lv4/o;->b()J

    .line 46
    .line 47
    .line 48
    move-result-wide v12

    .line 49
    :try_start_0
    invoke-virtual {v3, v8, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 50
    .line 51
    .line 52
    const-string v8, "EDIT_TRACKS_INFO"

    .line 53
    .line 54
    invoke-virtual {v3, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 55
    .line 56
    .line 57
    invoke-virtual {v0}, Lv4/l;->p()J

    .line 58
    .line 59
    .line 60
    move-result-wide v7

    .line 61
    invoke-virtual {v3, v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 62
    .line 63
    .line 64
    new-instance v5, Lorg/json/JSONArray;

    .line 65
    .line 66
    invoke-direct {v5}, Lorg/json/JSONArray;-><init>()V

    .line 67
    .line 68
    .line 69
    :goto_0
    array-length v7, v9

    .line 70
    if-ge v11, v7, :cond_0

    .line 71
    .line 72
    aget-wide v7, v9, v11

    .line 73
    .line 74
    invoke-virtual {v5, v11, v7, v8}, Lorg/json/JSONArray;->put(IJ)Lorg/json/JSONArray;

    .line 75
    .line 76
    .line 77
    add-int/2addr v11, v6

    .line 78
    goto :goto_0

    .line 79
    :cond_0
    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    .line 81
    .line 82
    :catch_0
    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    .line 83
    .line 84
    .line 85
    move-result-object v3

    .line 86
    invoke-virtual {v0, v12, v13, v3}, Lv4/o;->c(JLjava/lang/String;)V

    .line 87
    .line 88
    .line 89
    iget-object v0, v0, Lv4/l;->q:Lv4/n;

    .line 90
    .line 91
    invoke-virtual {v0, v12, v13, v2}, Lv4/n;->a(JLv4/m;)V

    .line 92
    .line 93
    .line 94
    return-void

    .line 95
    :pswitch_0
    iget-object v4, v10, Lr4/f;->c:Lv4/l;

    .line 96
    .line 97
    invoke-virtual/range {p0 .. p0}, Lr4/o;->l0()Lv4/m;

    .line 98
    .line 99
    .line 100
    move-result-object v6

    .line 101
    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 102
    .line 103
    .line 104
    new-instance v10, Lorg/json/JSONObject;

    .line 105
    .line 106
    invoke-direct {v10}, Lorg/json/JSONObject;-><init>()V

    .line 107
    .line 108
    .line 109
    invoke-virtual {v4}, Lv4/o;->b()J

    .line 110
    .line 111
    .line 112
    move-result-wide v12

    .line 113
    check-cast v9, Lp4/g;

    .line 114
    .line 115
    iget-boolean v14, v9, Lp4/g;->b:Z

    .line 116
    .line 117
    if-eqz v14, :cond_1

    .line 118
    .line 119
    const-wide v14, 0x3e800000000L

    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    goto :goto_1

    .line 125
    :cond_1
    iget-wide v14, v9, Lp4/g;->a:J

    .line 126
    .line 127
    :goto_1
    :try_start_1
    invoke-virtual {v10, v8, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 128
    .line 129
    .line 130
    const-string v8, "SEEK"

    .line 131
    .line 132
    invoke-virtual {v10, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 133
    .line 134
    .line 135
    invoke-virtual {v4}, Lv4/l;->p()J

    .line 136
    .line 137
    .line 138
    move-result-wide v7

    .line 139
    invoke-virtual {v10, v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 140
    .line 141
    .line 142
    sget-object v5, Lv4/a;->a:Ljava/util/regex/Pattern;

    .line 143
    .line 144
    long-to-double v7, v14

    .line 145
    div-double/2addr v7, v2

    .line 146
    invoke-virtual {v10, v0, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 147
    .line 148
    .line 149
    :catch_1
    invoke-virtual {v10}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    .line 150
    .line 151
    .line 152
    move-result-object v0

    .line 153
    invoke-virtual {v4, v12, v13, v0}, Lv4/o;->c(JLjava/lang/String;)V

    .line 154
    .line 155
    .line 156
    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 157
    .line 158
    .line 159
    move-result-object v0

    .line 160
    iput-object v0, v4, Lv4/l;->g:Ljava/lang/Long;

    .line 161
    .line 162
    new-instance v0, Lv4/i;

    .line 163
    .line 164
    invoke-direct {v0, v4, v6, v11}, Lv4/i;-><init>(Lv4/l;Lv4/m;I)V

    .line 165
    .line 166
    .line 167
    iget-object v2, v4, Lv4/l;->m:Lv4/n;

    .line 168
    .line 169
    invoke-virtual {v2, v12, v13, v0}, Lv4/n;->a(JLv4/m;)V

    .line 170
    .line 171
    .line 172
    return-void

    .line 173
    :pswitch_1
    iget-object v5, v10, Lr4/f;->c:Lv4/l;

    .line 174
    .line 175
    invoke-virtual/range {p0 .. p0}, Lr4/o;->l0()Lv4/m;

    .line 176
    .line 177
    .line 178
    move-result-object v10

    .line 179
    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 180
    .line 181
    .line 182
    check-cast v9, Lcom/google/android/gms/cast/MediaLoadRequestData;

    .line 183
    .line 184
    iget-object v12, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->a:Lcom/google/android/gms/cast/MediaInfo;

    .line 185
    .line 186
    iget-object v13, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->b:Lcom/google/android/gms/cast/MediaQueueData;

    .line 187
    .line 188
    if-nez v12, :cond_3

    .line 189
    .line 190
    if-eqz v13, :cond_2

    .line 191
    .line 192
    goto :goto_2

    .line 193
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 194
    .line 195
    const-string v2, "MediaInfo and MediaQueueData should not be both null"

    .line 196
    .line 197
    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 198
    .line 199
    .line 200
    throw v0

    .line 201
    :cond_3
    :goto_2
    new-instance v12, Lorg/json/JSONObject;

    .line 202
    .line 203
    invoke-direct {v12}, Lorg/json/JSONObject;-><init>()V

    .line 204
    .line 205
    .line 206
    :try_start_2
    iget-object v14, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->a:Lcom/google/android/gms/cast/MediaInfo;

    .line 207
    .line 208
    if-eqz v14, :cond_4

    .line 209
    .line 210
    const-string v15, "media"

    .line 211
    .line 212
    invoke-virtual {v14}, Lcom/google/android/gms/cast/MediaInfo;->j()Lorg/json/JSONObject;

    .line 213
    .line 214
    .line 215
    move-result-object v14

    .line 216
    invoke-virtual {v12, v15, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 217
    .line 218
    .line 219
    goto :goto_3

    .line 220
    :catch_2
    move-exception v0

    .line 221
    goto :goto_5

    .line 222
    :cond_4
    :goto_3
    if-eqz v13, :cond_5

    .line 223
    .line 224
    const-string v14, "queueData"

    .line 225
    .line 226
    invoke-virtual {v13}, Lcom/google/android/gms/cast/MediaQueueData;->j()Lorg/json/JSONObject;

    .line 227
    .line 228
    .line 229
    move-result-object v13

    .line 230
    invoke-virtual {v12, v14, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 231
    .line 232
    .line 233
    :cond_5
    const-string v13, "autoplay"

    .line 234
    .line 235
    iget-object v14, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->c:Ljava/lang/Boolean;

    .line 236
    .line 237
    invoke-virtual {v12, v13, v14}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 238
    .line 239
    .line 240
    iget-wide v13, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->d:J

    .line 241
    .line 242
    const-wide/16 v15, -0x1

    .line 243
    .line 244
    cmp-long v17, v13, v15

    .line 245
    .line 246
    if-eqz v17, :cond_6

    .line 247
    .line 248
    sget-object v15, Lv4/a;->a:Ljava/util/regex/Pattern;

    .line 249
    .line 250
    long-to-double v13, v13

    .line 251
    div-double/2addr v13, v2

    .line 252
    invoke-virtual {v12, v0, v13, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 253
    .line 254
    .line 255
    :cond_6
    const-string v0, "playbackRate"

    .line 256
    .line 257
    iget-wide v2, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->e:D

    .line 258
    .line 259
    invoke-virtual {v12, v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 260
    .line 261
    .line 262
    const-string v0, "credentials"

    .line 263
    .line 264
    iget-object v2, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->i:Ljava/lang/String;

    .line 265
    .line 266
    invoke-virtual {v12, v0, v2}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 267
    .line 268
    .line 269
    const-string v0, "credentialsType"

    .line 270
    .line 271
    iget-object v2, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->j:Ljava/lang/String;

    .line 272
    .line 273
    invoke-virtual {v12, v0, v2}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 274
    .line 275
    .line 276
    const-string v0, "atvCredentials"

    .line 277
    .line 278
    iget-object v2, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->k:Ljava/lang/String;

    .line 279
    .line 280
    invoke-virtual {v12, v0, v2}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 281
    .line 282
    .line 283
    const-string v0, "atvCredentialsType"

    .line 284
    .line 285
    iget-object v2, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->l:Ljava/lang/String;

    .line 286
    .line 287
    invoke-virtual {v12, v0, v2}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 288
    .line 289
    .line 290
    iget-object v0, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->f:[J

    .line 291
    .line 292
    if-eqz v0, :cond_8

    .line 293
    .line 294
    new-instance v2, Lorg/json/JSONArray;

    .line 295
    .line 296
    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 297
    .line 298
    .line 299
    const/4 v3, 0x0

    .line 300
    :goto_4
    array-length v13, v0

    .line 301
    if-ge v3, v13, :cond_7

    .line 302
    .line 303
    aget-wide v13, v0, v3

    .line 304
    .line 305
    invoke-virtual {v2, v3, v13, v14}, Lorg/json/JSONArray;->put(IJ)Lorg/json/JSONArray;

    .line 306
    .line 307
    .line 308
    add-int/2addr v3, v6

    .line 309
    goto :goto_4

    .line 310
    :cond_7
    invoke-virtual {v12, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 311
    .line 312
    .line 313
    :cond_8
    const-string v0, "customData"

    .line 314
    .line 315
    iget-object v2, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->h:Lorg/json/JSONObject;

    .line 316
    .line 317
    invoke-virtual {v12, v0, v2}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 318
    .line 319
    .line 320
    iget-wide v2, v9, Lcom/google/android/gms/cast/MediaLoadRequestData;->m:J

    .line 321
    .line 322
    invoke-virtual {v12, v8, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 323
    .line 324
    .line 325
    goto :goto_6

    .line 326
    :goto_5
    new-array v2, v6, [Ljava/lang/Object;

    .line 327
    .line 328
    aput-object v0, v2, v11

    .line 329
    .line 330
    sget-object v0, Lcom/google/android/gms/cast/MediaLoadRequestData;->n:Lv4/b;

    .line 331
    .line 332
    iget-object v3, v0, Lv4/b;->a:Ljava/lang/String;

    .line 333
    .line 334
    const-string v4, "Error transforming MediaLoadRequestData into JSONObject"

    .line 335
    .line 336
    invoke-virtual {v0, v4, v2}, Lv4/b;->d(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 337
    .line 338
    .line 339
    move-result-object v0

    .line 340
    invoke-static {v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 341
    .line 342
    .line 343
    new-instance v12, Lorg/json/JSONObject;

    .line 344
    .line 345
    invoke-direct {v12}, Lorg/json/JSONObject;-><init>()V

    .line 346
    .line 347
    .line 348
    :goto_6
    invoke-virtual {v5}, Lv4/o;->b()J

    .line 349
    .line 350
    .line 351
    move-result-wide v2

    .line 352
    :try_start_3
    invoke-virtual {v12, v8, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 353
    .line 354
    .line 355
    const-string v0, "LOAD"

    .line 356
    .line 357
    invoke-virtual {v12, v7, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    .line 358
    .line 359
    .line 360
    :catch_3
    invoke-virtual {v12}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    .line 361
    .line 362
    .line 363
    move-result-object v0

    .line 364
    invoke-virtual {v5, v2, v3, v0}, Lv4/o;->c(JLjava/lang/String;)V

    .line 365
    .line 366
    .line 367
    iget-object v0, v5, Lv4/l;->j:Lv4/n;

    .line 368
    .line 369
    invoke-virtual {v0, v2, v3, v10}, Lv4/n;->a(JLv4/m;)V

    .line 370
    .line 371
    .line 372
    return-void

    .line 373
    :pswitch_2
    iget-object v0, v10, Lr4/f;->c:Lv4/l;

    .line 374
    .line 375
    invoke-virtual/range {p0 .. p0}, Lr4/o;->l0()Lv4/m;

    .line 376
    .line 377
    .line 378
    move-result-object v2

    .line 379
    check-cast v9, [I

    .line 380
    .line 381
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 382
    .line 383
    .line 384
    new-instance v3, Lorg/json/JSONObject;

    .line 385
    .line 386
    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 387
    .line 388
    .line 389
    invoke-virtual {v0}, Lv4/o;->b()J

    .line 390
    .line 391
    .line 392
    move-result-wide v12

    .line 393
    :try_start_4
    invoke-virtual {v3, v8, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 394
    .line 395
    .line 396
    const-string v4, "QUEUE_GET_ITEMS"

    .line 397
    .line 398
    invoke-virtual {v3, v7, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 399
    .line 400
    .line 401
    invoke-virtual {v0}, Lv4/l;->p()J

    .line 402
    .line 403
    .line 404
    move-result-wide v7

    .line 405
    invoke-virtual {v3, v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 406
    .line 407
    .line 408
    new-instance v4, Lorg/json/JSONArray;

    .line 409
    .line 410
    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 411
    .line 412
    .line 413
    array-length v5, v9

    .line 414
    :goto_7
    if-ge v11, v5, :cond_9

    .line 415
    .line 416
    aget v7, v9, v11

    .line 417
    .line 418
    invoke-virtual {v4, v7}, Lorg/json/JSONArray;->put(I)Lorg/json/JSONArray;

    .line 419
    .line 420
    .line 421
    add-int/2addr v11, v6

    .line 422
    goto :goto_7

    .line 423
    :cond_9
    const-string v5, "itemIds"

    .line 424
    .line 425
    invoke-virtual {v3, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_4

    .line 426
    .line 427
    .line 428
    :catch_4
    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    .line 429
    .line 430
    .line 431
    move-result-object v3

    .line 432
    invoke-virtual {v0, v12, v13, v3}, Lv4/o;->c(JLjava/lang/String;)V

    .line 433
    .line 434
    .line 435
    iget-object v0, v0, Lv4/l;->t:Lv4/n;

    .line 436
    .line 437
    invoke-virtual {v0, v12, v13, v2}, Lv4/n;->a(JLv4/m;)V

    .line 438
    .line 439
    .line 440
    return-void

    .line 441
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
