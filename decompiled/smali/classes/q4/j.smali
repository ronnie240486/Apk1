.class public final Lq4/j;
.super Lcom/google/android/gms/internal/cast/u;
.source "MyApplication"


# instance fields
.field public final synthetic d:I

.field public final e:Ljava/lang/Object;


# direct methods
.method public constructor <init>(La0/f;)V
    .locals 2

    const/4 v0, 0x0

    iput v0, p0, Lq4/j;->d:I

    .line 1
    const-string v0, "com.google.android.gms.cast.framework.ICastStateListener"

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/internal/cast/u;-><init>(Ljava/lang/String;I)V

    .line 2
    iput-object p1, p0, Lq4/j;->e:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/cast/j;)V
    .locals 1

    const/4 v0, 0x2

    iput v0, p0, Lq4/j;->d:I

    .line 3
    iput-object p1, p0, Lq4/j;->e:Ljava/lang/Object;

    .line 4
    const-string p1, "com.google.android.gms.cast.framework.ISessionProvider"

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/cast/u;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public constructor <init>(Lq4/c;)V
    .locals 1

    const/4 v0, 0x3

    iput v0, p0, Lq4/j;->d:I

    .line 5
    iput-object p1, p0, Lq4/j;->e:Ljava/lang/Object;

    .line 6
    const-string p1, "com.google.android.gms.cast.framework.ICastConnectionController"

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/cast/u;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public constructor <init>(Lq4/g;)V
    .locals 1

    const/4 v0, 0x1

    iput v0, p0, Lq4/j;->d:I

    .line 7
    iput-object p1, p0, Lq4/j;->e:Ljava/lang/Object;

    .line 8
    const-string p1, "com.google.android.gms.cast.framework.ISessionProxy"

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/cast/u;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public constructor <init>(Ls4/b;)V
    .locals 1

    const/4 v0, 0x4

    iput v0, p0, Lq4/j;->d:I

    .line 9
    iput-object p1, p0, Lq4/j;->e:Ljava/lang/Object;

    .line 10
    const-string p1, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTaskProgressPublisher"

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/cast/u;-><init>(Ljava/lang/String;I)V

    return-void
.end method


# virtual methods
.method public final w(ILandroid/os/Parcel;Landroid/os/Parcel;)Z
    .locals 18

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    move/from16 v0, p1

    .line 4
    .line 5
    move-object/from16 v2, p2

    .line 6
    .line 7
    move-object/from16 v3, p3

    .line 8
    .line 9
    const/16 v4, 0x1b

    .line 10
    .line 11
    const/4 v5, 0x4

    .line 12
    const/4 v6, 0x3

    .line 13
    iget-object v7, v1, Lq4/j;->e:Ljava/lang/Object;

    .line 14
    .line 15
    const v8, 0xbdfcb8

    .line 16
    .line 17
    .line 18
    const/4 v9, 0x2

    .line 19
    const/4 v10, 0x1

    .line 20
    const/4 v11, 0x0

    .line 21
    iget v12, v1, Lq4/j;->d:I

    .line 22
    .line 23
    packed-switch v12, :pswitch_data_0

    .line 24
    .line 25
    .line 26
    if-eq v0, v10, :cond_1

    .line 27
    .line 28
    if-eq v0, v9, :cond_0

    .line 29
    .line 30
    const/4 v10, 0x0

    .line 31
    goto :goto_0

    .line 32
    :cond_0
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 33
    .line 34
    .line 35
    invoke-virtual {v3, v8}, Landroid/os/Parcel;->writeInt(I)V

    .line 36
    .line 37
    .line 38
    goto :goto_0

    .line 39
    :cond_1
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    .line 40
    .line 41
    .line 42
    move-result-wide v4

    .line 43
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    .line 44
    .line 45
    .line 46
    move-result-wide v12

    .line 47
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 48
    .line 49
    .line 50
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 51
    .line 52
    .line 53
    move-result-object v0

    .line 54
    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 55
    .line 56
    .line 57
    move-result-object v2

    .line 58
    new-array v4, v9, [Ljava/lang/Long;

    .line 59
    .line 60
    aput-object v0, v4, v11

    .line 61
    .line 62
    aput-object v2, v4, v10

    .line 63
    .line 64
    check-cast v7, Ls4/b;

    .line 65
    .line 66
    invoke-static {v7, v4}, Ls4/b;->a(Ls4/b;[Ljava/lang/Object;)V

    .line 67
    .line 68
    .line 69
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 70
    .line 71
    .line 72
    :goto_0
    return v10

    .line 73
    :pswitch_0
    check-cast v7, Lq4/c;

    .line 74
    .line 75
    if-eq v0, v10, :cond_8

    .line 76
    .line 77
    if-eq v0, v9, :cond_6

    .line 78
    .line 79
    if-eq v0, v6, :cond_4

    .line 80
    .line 81
    if-eq v0, v5, :cond_3

    .line 82
    .line 83
    const/4 v2, 0x5

    .line 84
    if-eq v0, v2, :cond_2

    .line 85
    .line 86
    const/4 v10, 0x0

    .line 87
    goto/16 :goto_1

    .line 88
    .line 89
    :cond_2
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 90
    .line 91
    .line 92
    invoke-virtual {v3, v8}, Landroid/os/Parcel;->writeInt(I)V

    .line 93
    .line 94
    .line 95
    goto/16 :goto_1

    .line 96
    .line 97
    :cond_3
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    .line 98
    .line 99
    .line 100
    move-result v0

    .line 101
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 102
    .line 103
    .line 104
    invoke-static {v7, v0}, Lq4/c;->h(Lq4/c;I)V

    .line 105
    .line 106
    .line 107
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 108
    .line 109
    .line 110
    goto/16 :goto_1

    .line 111
    .line 112
    :cond_4
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 113
    .line 114
    .line 115
    move-result-object v0

    .line 116
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 117
    .line 118
    .line 119
    iget-object v2, v7, Lq4/c;->i:Lp4/o;

    .line 120
    .line 121
    if-eqz v2, :cond_5

    .line 122
    .line 123
    invoke-virtual {v2}, Lp4/o;->j()Z

    .line 124
    .line 125
    .line 126
    move-result v2

    .line 127
    if-eqz v2, :cond_5

    .line 128
    .line 129
    iget-object v2, v7, Lq4/c;->i:Lp4/o;

    .line 130
    .line 131
    invoke-static {}, Lc6/c;->c()Lc6/c;

    .line 132
    .line 133
    .line 134
    move-result-object v4

    .line 135
    new-instance v5, Lp4/l;

    .line 136
    .line 137
    invoke-direct {v5, v2, v0}, Lp4/l;-><init>(Lp4/o;Ljava/lang/String;)V

    .line 138
    .line 139
    .line 140
    iput-object v5, v4, Lc6/c;->c:Ljava/lang/Object;

    .line 141
    .line 142
    const/16 v0, 0x20d9

    .line 143
    .line 144
    iput v0, v4, Lc6/c;->a:I

    .line 145
    .line 146
    invoke-virtual {v4}, Lc6/c;->b()Lc6/c;

    .line 147
    .line 148
    .line 149
    move-result-object v0

    .line 150
    invoke-virtual {v2, v10, v0}, Ly4/g;->c(ILc6/c;)Lq4/d;

    .line 151
    .line 152
    .line 153
    :cond_5
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 154
    .line 155
    .line 156
    goto/16 :goto_1

    .line 157
    .line 158
    :cond_6
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 159
    .line 160
    .line 161
    move-result-object v0

    .line 162
    sget-object v5, Lcom/google/android/gms/cast/LaunchOptions;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 163
    .line 164
    invoke-static {v2, v5}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 165
    .line 166
    .line 167
    move-result-object v5

    .line 168
    check-cast v5, Lcom/google/android/gms/cast/LaunchOptions;

    .line 169
    .line 170
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 171
    .line 172
    .line 173
    iget-object v2, v7, Lq4/c;->i:Lp4/o;

    .line 174
    .line 175
    if-eqz v2, :cond_7

    .line 176
    .line 177
    invoke-virtual {v2}, Lp4/o;->j()Z

    .line 178
    .line 179
    .line 180
    move-result v2

    .line 181
    if-eqz v2, :cond_7

    .line 182
    .line 183
    iget-object v2, v7, Lq4/c;->i:Lp4/o;

    .line 184
    .line 185
    invoke-static {}, Lc6/c;->c()Lc6/c;

    .line 186
    .line 187
    .line 188
    move-result-object v6

    .line 189
    new-instance v7, La1/b;

    .line 190
    .line 191
    invoke-direct {v7, v2, v0, v5, v4}, La1/b;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;I)V

    .line 192
    .line 193
    .line 194
    iput-object v7, v6, Lc6/c;->c:Ljava/lang/Object;

    .line 195
    .line 196
    const/16 v0, 0x20d6

    .line 197
    .line 198
    iput v0, v6, Lc6/c;->a:I

    .line 199
    .line 200
    invoke-virtual {v6}, Lc6/c;->b()Lc6/c;

    .line 201
    .line 202
    .line 203
    move-result-object v0

    .line 204
    invoke-virtual {v2, v10, v0}, Ly4/g;->c(ILc6/c;)Lq4/d;

    .line 205
    .line 206
    .line 207
    move-result-object v0

    .line 208
    new-instance v2, Lq4/c0;

    .line 209
    .line 210
    invoke-direct {v2, v1, v11}, Lq4/c0;-><init>(Lq4/j;I)V

    .line 211
    .line 212
    .line 213
    invoke-virtual {v0, v2}, Lq4/d;->a(Lw5/a;)V

    .line 214
    .line 215
    .line 216
    :cond_7
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 217
    .line 218
    .line 219
    goto :goto_1

    .line 220
    :cond_8
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 221
    .line 222
    .line 223
    move-result-object v0

    .line 224
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 225
    .line 226
    .line 227
    move-result-object v4

    .line 228
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 229
    .line 230
    .line 231
    iget-object v2, v7, Lq4/c;->i:Lp4/o;

    .line 232
    .line 233
    if-eqz v2, :cond_9

    .line 234
    .line 235
    invoke-virtual {v2}, Lp4/o;->j()Z

    .line 236
    .line 237
    .line 238
    move-result v2

    .line 239
    if-eqz v2, :cond_9

    .line 240
    .line 241
    iget-object v2, v7, Lq4/c;->i:Lp4/o;

    .line 242
    .line 243
    invoke-static {}, Lc6/c;->c()Lc6/c;

    .line 244
    .line 245
    .line 246
    move-result-object v5

    .line 247
    new-instance v6, Lp4/k;

    .line 248
    .line 249
    invoke-direct {v6, v2, v0, v4, v11}, Lp4/k;-><init>(Lp4/o;Ljava/lang/String;Ljava/lang/String;I)V

    .line 250
    .line 251
    .line 252
    iput-object v6, v5, Lc6/c;->c:Ljava/lang/Object;

    .line 253
    .line 254
    const/16 v0, 0x20d7

    .line 255
    .line 256
    iput v0, v5, Lc6/c;->a:I

    .line 257
    .line 258
    invoke-virtual {v5}, Lc6/c;->b()Lc6/c;

    .line 259
    .line 260
    .line 261
    move-result-object v0

    .line 262
    invoke-virtual {v2, v10, v0}, Ly4/g;->c(ILc6/c;)Lq4/d;

    .line 263
    .line 264
    .line 265
    move-result-object v0

    .line 266
    new-instance v2, Lq4/c0;

    .line 267
    .line 268
    invoke-direct {v2, v1, v10}, Lq4/c0;-><init>(Lq4/j;I)V

    .line 269
    .line 270
    .line 271
    invoke-virtual {v0, v2}, Lq4/d;->a(Lw5/a;)V

    .line 272
    .line 273
    .line 274
    :cond_9
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 275
    .line 276
    .line 277
    :goto_1
    return v10

    .line 278
    :pswitch_1
    check-cast v7, Lcom/google/android/gms/internal/cast/j;

    .line 279
    .line 280
    if-eq v0, v10, :cond_d

    .line 281
    .line 282
    if-eq v0, v9, :cond_c

    .line 283
    .line 284
    if-eq v0, v6, :cond_b

    .line 285
    .line 286
    if-eq v0, v5, :cond_a

    .line 287
    .line 288
    const/4 v10, 0x0

    .line 289
    goto :goto_2

    .line 290
    :cond_a
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 291
    .line 292
    .line 293
    invoke-virtual {v3, v8}, Landroid/os/Parcel;->writeInt(I)V

    .line 294
    .line 295
    .line 296
    goto :goto_2

    .line 297
    :cond_b
    iget-object v0, v7, Lcom/google/android/gms/internal/cast/j;->b:Ljava/lang/String;

    .line 298
    .line 299
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 300
    .line 301
    .line 302
    invoke-virtual {v3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 303
    .line 304
    .line 305
    goto :goto_2

    .line 306
    :cond_c
    iget-object v0, v7, Lcom/google/android/gms/internal/cast/j;->d:Lcom/google/android/gms/cast/framework/CastOptions;

    .line 307
    .line 308
    iget-boolean v0, v0, Lcom/google/android/gms/cast/framework/CastOptions;->e:Z

    .line 309
    .line 310
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 311
    .line 312
    .line 313
    sget v2, Lcom/google/android/gms/internal/cast/e0;->a:I

    .line 314
    .line 315
    invoke-virtual {v3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 316
    .line 317
    .line 318
    goto :goto_2

    .line 319
    :cond_d
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 320
    .line 321
    .line 322
    move-result-object v14

    .line 323
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 324
    .line 325
    .line 326
    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 327
    .line 328
    .line 329
    new-instance v0, Lq4/c;

    .line 330
    .line 331
    new-instance v2, Ls4/j;

    .line 332
    .line 333
    iget-object v4, v7, Lcom/google/android/gms/internal/cast/j;->a:Landroid/content/Context;

    .line 334
    .line 335
    iget-object v15, v7, Lcom/google/android/gms/internal/cast/j;->d:Lcom/google/android/gms/cast/framework/CastOptions;

    .line 336
    .line 337
    iget-object v5, v7, Lcom/google/android/gms/internal/cast/j;->e:Lcom/google/android/gms/internal/cast/v;

    .line 338
    .line 339
    invoke-direct {v2, v4, v15, v5}, Ls4/j;-><init>(Landroid/content/Context;Lcom/google/android/gms/cast/framework/CastOptions;Lcom/google/android/gms/internal/cast/v;)V

    .line 340
    .line 341
    .line 342
    iget-object v12, v7, Lcom/google/android/gms/internal/cast/j;->a:Landroid/content/Context;

    .line 343
    .line 344
    iget-object v13, v7, Lcom/google/android/gms/internal/cast/j;->b:Ljava/lang/String;

    .line 345
    .line 346
    move-object v11, v0

    .line 347
    move-object/from16 v16, v5

    .line 348
    .line 349
    move-object/from16 v17, v2

    .line 350
    .line 351
    invoke-direct/range {v11 .. v17}, Lq4/c;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/cast/framework/CastOptions;Lcom/google/android/gms/internal/cast/v;Ls4/j;)V

    .line 352
    .line 353
    .line 354
    invoke-virtual {v0}, Lq4/g;->d()Lm5/a;

    .line 355
    .line 356
    .line 357
    move-result-object v0

    .line 358
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 359
    .line 360
    .line 361
    invoke-static {v3, v0}, Lcom/google/android/gms/internal/cast/e0;->d(Landroid/os/Parcel;Landroid/os/IInterface;)V

    .line 362
    .line 363
    .line 364
    :goto_2
    return v10

    .line 365
    :pswitch_2
    check-cast v7, Lq4/g;

    .line 366
    .line 367
    packed-switch v0, :pswitch_data_1

    .line 368
    .line 369
    .line 370
    const/4 v10, 0x0

    .line 371
    goto/16 :goto_9

    .line 372
    .line 373
    :pswitch_3
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 374
    .line 375
    invoke-static {v2, v0}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 376
    .line 377
    .line 378
    move-result-object v0

    .line 379
    check-cast v0, Landroid/os/Bundle;

    .line 380
    .line 381
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 382
    .line 383
    .line 384
    check-cast v7, Lq4/c;

    .line 385
    .line 386
    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 387
    .line 388
    .line 389
    invoke-static {v0}, Lcom/google/android/gms/cast/CastDevice;->l(Landroid/os/Bundle;)Lcom/google/android/gms/cast/CastDevice;

    .line 390
    .line 391
    .line 392
    move-result-object v0

    .line 393
    if-eqz v0, :cond_13

    .line 394
    .line 395
    iget-object v2, v7, Lq4/c;->k:Lcom/google/android/gms/cast/CastDevice;

    .line 396
    .line 397
    invoke-virtual {v0, v2}, Lcom/google/android/gms/cast/CastDevice;->equals(Ljava/lang/Object;)Z

    .line 398
    .line 399
    .line 400
    move-result v2

    .line 401
    if-nez v2, :cond_13

    .line 402
    .line 403
    iget-object v2, v0, Lcom/google/android/gms/cast/CastDevice;->d:Ljava/lang/String;

    .line 404
    .line 405
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    .line 406
    .line 407
    .line 408
    move-result v4

    .line 409
    if-nez v4, :cond_f

    .line 410
    .line 411
    iget-object v4, v7, Lq4/c;->k:Lcom/google/android/gms/cast/CastDevice;

    .line 412
    .line 413
    if-eqz v4, :cond_e

    .line 414
    .line 415
    iget-object v4, v4, Lcom/google/android/gms/cast/CastDevice;->d:Ljava/lang/String;

    .line 416
    .line 417
    invoke-static {v4, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    .line 418
    .line 419
    .line 420
    move-result v2

    .line 421
    if-nez v2, :cond_f

    .line 422
    .line 423
    :cond_e
    const/4 v2, 0x1

    .line 424
    goto :goto_3

    .line 425
    :cond_f
    const/4 v2, 0x0

    .line 426
    :goto_3
    iput-object v0, v7, Lq4/c;->k:Lcom/google/android/gms/cast/CastDevice;

    .line 427
    .line 428
    if-eq v10, v2, :cond_10

    .line 429
    .line 430
    const-string v4, "unchanged"

    .line 431
    .line 432
    goto :goto_4

    .line 433
    :cond_10
    const-string v4, "changed"

    .line 434
    .line 435
    :goto_4
    new-array v5, v9, [Ljava/lang/Object;

    .line 436
    .line 437
    aput-object v0, v5, v11

    .line 438
    .line 439
    aput-object v4, v5, v10

    .line 440
    .line 441
    const-string v0, "update to device (%s) with name %s"

    .line 442
    .line 443
    sget-object v4, Lq4/c;->m:Lv4/b;

    .line 444
    .line 445
    invoke-virtual {v4, v0, v5}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 446
    .line 447
    .line 448
    if-eqz v2, :cond_13

    .line 449
    .line 450
    iget-object v0, v7, Lq4/c;->k:Lcom/google/android/gms/cast/CastDevice;

    .line 451
    .line 452
    if-eqz v0, :cond_13

    .line 453
    .line 454
    iget-object v2, v7, Lq4/c;->h:Ls4/j;

    .line 455
    .line 456
    if-eqz v2, :cond_11

    .line 457
    .line 458
    new-array v4, v10, [Ljava/lang/Object;

    .line 459
    .line 460
    aput-object v0, v4, v11

    .line 461
    .line 462
    sget-object v5, Ls4/j;->v:Lv4/b;

    .line 463
    .line 464
    iget-object v6, v5, Lv4/b;->a:Ljava/lang/String;

    .line 465
    .line 466
    const-string v8, "update Cast device to %s"

    .line 467
    .line 468
    invoke-virtual {v5, v8, v4}, Lv4/b;->d(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 469
    .line 470
    .line 471
    move-result-object v4

    .line 472
    invoke-static {v6, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 473
    .line 474
    .line 475
    iput-object v0, v2, Ls4/j;->o:Lcom/google/android/gms/cast/CastDevice;

    .line 476
    .line 477
    invoke-virtual {v2}, Ls4/j;->c()V

    .line 478
    .line 479
    .line 480
    :cond_11
    iget-object v0, v7, Lq4/c;->d:Ljava/util/HashSet;

    .line 481
    .line 482
    new-instance v2, Ljava/util/HashSet;

    .line 483
    .line 484
    invoke-direct {v2, v0}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 485
    .line 486
    .line 487
    invoke-virtual {v2}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 488
    .line 489
    .line 490
    move-result-object v0

    .line 491
    :goto_5
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 492
    .line 493
    .line 494
    move-result v2

    .line 495
    if-eqz v2, :cond_12

    .line 496
    .line 497
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 498
    .line 499
    .line 500
    move-result-object v2

    .line 501
    check-cast v2, Lcom/google/android/gms/internal/cast/k0;

    .line 502
    .line 503
    iget v4, v2, Lcom/google/android/gms/internal/cast/k0;->a:I

    .line 504
    .line 505
    packed-switch v4, :pswitch_data_2

    .line 506
    .line 507
    .line 508
    goto :goto_5

    .line 509
    :pswitch_4
    sget v4, Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;->n0:I

    .line 510
    .line 511
    iget-object v2, v2, Lcom/google/android/gms/internal/cast/k0;->b:Ljava/lang/Object;

    .line 512
    .line 513
    check-cast v2, Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;

    .line 514
    .line 515
    invoke-virtual {v2}, Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;->s()V

    .line 516
    .line 517
    .line 518
    goto :goto_5

    .line 519
    :cond_12
    iget-object v0, v7, Lq4/c;->l:Lcom/google/android/gms/internal/cast/a5;

    .line 520
    .line 521
    if-eqz v0, :cond_13

    .line 522
    .line 523
    iget-object v0, v0, Lcom/google/android/gms/internal/cast/a5;->a:Lc2/b;

    .line 524
    .line 525
    invoke-virtual {v0}, Lc2/b;->l()Lcom/google/android/gms/internal/cast/d8;

    .line 526
    .line 527
    .line 528
    move-result-object v0

    .line 529
    iget v2, v0, Lcom/google/android/gms/internal/cast/d8;->u:I

    .line 530
    .line 531
    add-int/2addr v2, v10

    .line 532
    iput v2, v0, Lcom/google/android/gms/internal/cast/d8;->u:I

    .line 533
    .line 534
    :cond_13
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 535
    .line 536
    .line 537
    goto/16 :goto_9

    .line 538
    .line 539
    :pswitch_5
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 540
    .line 541
    invoke-static {v2, v0}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 542
    .line 543
    .line 544
    move-result-object v0

    .line 545
    check-cast v0, Landroid/os/Bundle;

    .line 546
    .line 547
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 548
    .line 549
    .line 550
    check-cast v7, Lq4/c;

    .line 551
    .line 552
    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 553
    .line 554
    .line 555
    invoke-static {v0}, Lcom/google/android/gms/cast/CastDevice;->l(Landroid/os/Bundle;)Lcom/google/android/gms/cast/CastDevice;

    .line 556
    .line 557
    .line 558
    move-result-object v0

    .line 559
    iput-object v0, v7, Lq4/c;->k:Lcom/google/android/gms/cast/CastDevice;

    .line 560
    .line 561
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 562
    .line 563
    .line 564
    goto/16 :goto_9

    .line 565
    .line 566
    :pswitch_6
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 567
    .line 568
    invoke-static {v2, v0}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 569
    .line 570
    .line 571
    move-result-object v0

    .line 572
    check-cast v0, Landroid/os/Bundle;

    .line 573
    .line 574
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 575
    .line 576
    .line 577
    check-cast v7, Lq4/c;

    .line 578
    .line 579
    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 580
    .line 581
    .line 582
    invoke-static {v0}, Lcom/google/android/gms/cast/CastDevice;->l(Landroid/os/Bundle;)Lcom/google/android/gms/cast/CastDevice;

    .line 583
    .line 584
    .line 585
    move-result-object v0

    .line 586
    iput-object v0, v7, Lq4/c;->k:Lcom/google/android/gms/cast/CastDevice;

    .line 587
    .line 588
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 589
    .line 590
    .line 591
    goto/16 :goto_9

    .line 592
    .line 593
    :pswitch_7
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 594
    .line 595
    .line 596
    invoke-virtual {v3, v8}, Landroid/os/Parcel;->writeInt(I)V

    .line 597
    .line 598
    .line 599
    goto/16 :goto_9

    .line 600
    .line 601
    :pswitch_8
    check-cast v7, Lq4/c;

    .line 602
    .line 603
    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 604
    .line 605
    .line 606
    const-string v0, "Must be called from the main thread."

    .line 607
    .line 608
    invoke-static {v0}, Lb5/l;->b(Ljava/lang/String;)V

    .line 609
    .line 610
    .line 611
    iget-object v0, v7, Lq4/c;->j:Lr4/f;

    .line 612
    .line 613
    if-nez v0, :cond_14

    .line 614
    .line 615
    const-wide/16 v4, 0x0

    .line 616
    .line 617
    goto :goto_6

    .line 618
    :cond_14
    invoke-virtual {v0}, Lr4/f;->h()J

    .line 619
    .line 620
    .line 621
    move-result-wide v4

    .line 622
    iget-object v0, v7, Lq4/c;->j:Lr4/f;

    .line 623
    .line 624
    invoke-virtual {v0}, Lr4/f;->c()J

    .line 625
    .line 626
    .line 627
    move-result-wide v6

    .line 628
    sub-long/2addr v4, v6

    .line 629
    :goto_6
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 630
    .line 631
    .line 632
    invoke-virtual {v3, v4, v5}, Landroid/os/Parcel;->writeLong(J)V

    .line 633
    .line 634
    .line 635
    goto/16 :goto_9

    .line 636
    .line 637
    :pswitch_9
    sget v0, Lcom/google/android/gms/internal/cast/e0;->a:I

    .line 638
    .line 639
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    .line 640
    .line 641
    .line 642
    move-result v0

    .line 643
    if-eqz v0, :cond_15

    .line 644
    .line 645
    const/4 v0, 0x1

    .line 646
    goto :goto_7

    .line 647
    :cond_15
    const/4 v0, 0x0

    .line 648
    :goto_7
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 649
    .line 650
    .line 651
    check-cast v7, Lq4/c;

    .line 652
    .line 653
    iget-object v2, v7, Lq4/c;->e:Lq4/q;

    .line 654
    .line 655
    if-eqz v2, :cond_16

    .line 656
    .line 657
    :try_start_0
    check-cast v2, Lq4/o;

    .line 658
    .line 659
    invoke-virtual {v2}, Lcom/google/android/gms/internal/cast/a;->l()Landroid/os/Parcel;

    .line 660
    .line 661
    .line 662
    move-result-object v4

    .line 663
    invoke-virtual {v4, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 664
    .line 665
    .line 666
    invoke-virtual {v4, v11}, Landroid/os/Parcel;->writeInt(I)V

    .line 667
    .line 668
    .line 669
    const/4 v0, 0x6

    .line 670
    invoke-virtual {v2, v4, v0}, Lcom/google/android/gms/internal/cast/a;->x(Landroid/os/Parcel;I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 671
    .line 672
    .line 673
    goto :goto_8

    .line 674
    :catch_0
    move-exception v0

    .line 675
    const-class v2, Lq4/q;

    .line 676
    .line 677
    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    .line 678
    .line 679
    .line 680
    move-result-object v2

    .line 681
    new-array v4, v9, [Ljava/lang/Object;

    .line 682
    .line 683
    const-string v5, "disconnectFromDevice"

    .line 684
    .line 685
    aput-object v5, v4, v11

    .line 686
    .line 687
    aput-object v2, v4, v10

    .line 688
    .line 689
    const-string v2, "Unable to call %s on %s."

    .line 690
    .line 691
    sget-object v5, Lq4/c;->m:Lv4/b;

    .line 692
    .line 693
    invoke-virtual {v5, v0, v2, v4}, Lv4/b;->a(Ljava/lang/Exception;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 694
    .line 695
    .line 696
    :goto_8
    invoke-virtual {v7, v11}, Lq4/g;->b(I)V

    .line 697
    .line 698
    .line 699
    :cond_16
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 700
    .line 701
    .line 702
    goto :goto_9

    .line 703
    :pswitch_a
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 704
    .line 705
    invoke-static {v2, v0}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 706
    .line 707
    .line 708
    move-result-object v0

    .line 709
    check-cast v0, Landroid/os/Bundle;

    .line 710
    .line 711
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 712
    .line 713
    .line 714
    check-cast v7, Lq4/c;

    .line 715
    .line 716
    invoke-virtual {v7, v0}, Lq4/c;->j(Landroid/os/Bundle;)V

    .line 717
    .line 718
    .line 719
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 720
    .line 721
    .line 722
    goto :goto_9

    .line 723
    :pswitch_b
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 724
    .line 725
    invoke-static {v2, v0}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 726
    .line 727
    .line 728
    move-result-object v0

    .line 729
    check-cast v0, Landroid/os/Bundle;

    .line 730
    .line 731
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 732
    .line 733
    .line 734
    check-cast v7, Lq4/c;

    .line 735
    .line 736
    invoke-virtual {v7, v0}, Lq4/c;->j(Landroid/os/Bundle;)V

    .line 737
    .line 738
    .line 739
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 740
    .line 741
    .line 742
    goto :goto_9

    .line 743
    :pswitch_c
    new-instance v0, Lm5/b;

    .line 744
    .line 745
    invoke-direct {v0, v7}, Lm5/b;-><init>(Ljava/lang/Object;)V

    .line 746
    .line 747
    .line 748
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 749
    .line 750
    .line 751
    invoke-static {v3, v0}, Lcom/google/android/gms/internal/cast/e0;->d(Landroid/os/Parcel;Landroid/os/IInterface;)V

    .line 752
    .line 753
    .line 754
    :goto_9
    return v10

    .line 755
    :pswitch_d
    check-cast v7, La0/f;

    .line 756
    .line 757
    if-eq v0, v10, :cond_1b

    .line 758
    .line 759
    if-eq v0, v9, :cond_18

    .line 760
    .line 761
    if-eq v0, v6, :cond_17

    .line 762
    .line 763
    const/4 v10, 0x0

    .line 764
    goto :goto_a

    .line 765
    :cond_17
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 766
    .line 767
    .line 768
    invoke-virtual {v3, v8}, Landroid/os/Parcel;->writeInt(I)V

    .line 769
    .line 770
    .line 771
    goto :goto_a

    .line 772
    :cond_18
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    .line 773
    .line 774
    .line 775
    move-result v0

    .line 776
    invoke-static/range {p2 .. p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 777
    .line 778
    .line 779
    iget-object v2, v7, La0/f;->e:Ljava/lang/Object;

    .line 780
    .line 781
    check-cast v2, Lorg/bitspark/android/utils/b;

    .line 782
    .line 783
    if-eq v0, v10, :cond_19

    .line 784
    .line 785
    iget-object v6, v7, La0/f;->b:Ljava/lang/Object;

    .line 786
    .line 787
    check-cast v6, Lorg/bitspark/android/Spark;

    .line 788
    .line 789
    iget-object v8, v7, La0/f;->c:Ljava/lang/Object;

    .line 790
    .line 791
    check-cast v8, Landroidx/mediarouter/app/MediaRouteButton;

    .line 792
    .line 793
    invoke-static {v2, v6, v8}, Lorg/bitspark/android/utils/b;->a(Lorg/bitspark/android/utils/b;Lorg/bitspark/android/Spark;Landroidx/mediarouter/app/MediaRouteButton;)V

    .line 794
    .line 795
    .line 796
    iget-object v8, v7, La0/f;->d:Ljava/lang/Object;

    .line 797
    .line 798
    check-cast v8, Landroidx/mediarouter/app/MediaRouteButton;

    .line 799
    .line 800
    invoke-static {v2, v6, v8}, Lorg/bitspark/android/utils/b;->a(Lorg/bitspark/android/utils/b;Lorg/bitspark/android/Spark;Landroidx/mediarouter/app/MediaRouteButton;)V

    .line 801
    .line 802
    .line 803
    :cond_19
    if-ne v0, v5, :cond_1a

    .line 804
    .line 805
    iget-object v0, v2, Lorg/bitspark/android/utils/b;->e:Lcom/google/android/gms/internal/cast/o;

    .line 806
    .line 807
    if-eqz v0, :cond_1a

    .line 808
    .line 809
    sget-object v0, Lka/m0;->E0:Landroidx/mediarouter/app/c;

    .line 810
    .line 811
    new-instance v2, La/f;

    .line 812
    .line 813
    invoke-direct {v2, v4, v7}, La/f;-><init>(ILjava/lang/Object;)V

    .line 814
    .line 815
    .line 816
    const-wide/16 v4, 0x7d0

    .line 817
    .line 818
    invoke-virtual {v0, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 819
    .line 820
    .line 821
    :cond_1a
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 822
    .line 823
    .line 824
    goto :goto_a

    .line 825
    :cond_1b
    new-instance v0, Lm5/b;

    .line 826
    .line 827
    invoke-direct {v0, v7}, Lm5/b;-><init>(Ljava/lang/Object;)V

    .line 828
    .line 829
    .line 830
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 831
    .line 832
    .line 833
    invoke-static {v3, v0}, Lcom/google/android/gms/internal/cast/e0;->d(Landroid/os/Parcel;Landroid/os/IInterface;)V

    .line 834
    .line 835
    .line 836
    :goto_a
    return v10

    .line 837
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_d
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch

    .line 838
    .line 839
    .line 840
    .line 841
    .line 842
    .line 843
    .line 844
    .line 845
    .line 846
    .line 847
    .line 848
    .line 849
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_3
    .end packed-switch

    .line 850
    .line 851
    .line 852
    .line 853
    .line 854
    .line 855
    .line 856
    .line 857
    .line 858
    .line 859
    .line 860
    .line 861
    .line 862
    .line 863
    .line 864
    .line 865
    .line 866
    .line 867
    .line 868
    .line 869
    .line 870
    .line 871
    :pswitch_data_2
    .packed-switch 0x2
        :pswitch_4
    .end packed-switch
.end method
