.class public abstract Lcom/google/android/gms/internal/cast/l;
.super Lcom/google/android/gms/internal/cast/u;
.source "MyApplication"


# instance fields
.field public final synthetic d:I


# direct methods
.method public synthetic constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/google/android/gms/internal/cast/l;->d:I

    .line 2
    .line 3
    const/4 p2, 0x0

    .line 4
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/cast/u;-><init>(Ljava/lang/String;I)V

    .line 5
    .line 6
    .line 7
    return-void
.end method


# virtual methods
.method public final w(ILandroid/os/Parcel;Landroid/os/Parcel;)Z
    .locals 10

    .line 1
    const v0, 0xbdfcb8

    .line 2
    .line 3
    .line 4
    const/4 v1, 0x3

    .line 5
    const/4 v2, 0x2

    .line 6
    const/4 v3, 0x1

    .line 7
    const/4 v4, 0x0

    .line 8
    iget v5, p0, Lcom/google/android/gms/internal/cast/l;->d:I

    .line 9
    .line 10
    packed-switch v5, :pswitch_data_0

    .line 11
    .line 12
    .line 13
    if-eq p1, v3, :cond_8

    .line 14
    .line 15
    if-eq p1, v2, :cond_6

    .line 16
    .line 17
    if-eq p1, v1, :cond_1

    .line 18
    .line 19
    const/4 p2, 0x4

    .line 20
    if-eq p1, p2, :cond_0

    .line 21
    .line 22
    const/4 v3, 0x0

    .line 23
    goto/16 :goto_2

    .line 24
    .line 25
    :cond_0
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 26
    .line 27
    .line 28
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 29
    .line 30
    .line 31
    goto/16 :goto_2

    .line 32
    .line 33
    :cond_1
    move-object p1, p0

    .line 34
    check-cast p1, Lcom/google/android/gms/internal/cast/h;

    .line 35
    .line 36
    new-array p2, v4, [Ljava/lang/Object;

    .line 37
    .line 38
    sget-object v0, Lcom/google/android/gms/internal/cast/h;->g:Lv4/b;

    .line 39
    .line 40
    iget-object v1, v0, Lv4/b;->a:Ljava/lang/String;

    .line 41
    .line 42
    const-string v5, "onAppEnteredBackground"

    .line 43
    .line 44
    invoke-virtual {v0, v5, p2}, Lv4/b;->d(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 45
    .line 46
    .line 47
    move-result-object p2

    .line 48
    invoke-static {v1, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    .line 50
    .line 51
    iput v2, p1, Lcom/google/android/gms/internal/cast/h;->f:I

    .line 52
    .line 53
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/h;->e:Ljava/util/Set;

    .line 54
    .line 55
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    :cond_2
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 60
    .line 61
    .line 62
    move-result p2

    .line 63
    if-eqz p2, :cond_5

    .line 64
    .line 65
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 66
    .line 67
    .line 68
    move-result-object p2

    .line 69
    check-cast p2, Lcom/google/android/gms/internal/cast/s;

    .line 70
    .line 71
    iget-object p2, p2, Lcom/google/android/gms/internal/cast/s;->a:Lcom/google/android/gms/internal/cast/t;

    .line 72
    .line 73
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 74
    .line 75
    .line 76
    new-array v0, v4, [Ljava/lang/Object;

    .line 77
    .line 78
    sget-object v1, Lcom/google/android/gms/internal/cast/t;->f:Lv4/b;

    .line 79
    .line 80
    const-string v2, "Stopping RouteDiscovery."

    .line 81
    .line 82
    invoke-virtual {v1, v2, v0}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 83
    .line 84
    .line 85
    iget-object v0, p2, Lcom/google/android/gms/internal/cast/t;->c:Ljava/util/Map;

    .line 86
    .line 87
    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 88
    .line 89
    .line 90
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    .line 91
    .line 92
    .line 93
    move-result-object v0

    .line 94
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 95
    .line 96
    .line 97
    move-result-object v1

    .line 98
    if-ne v0, v1, :cond_4

    .line 99
    .line 100
    iget-object v0, p2, Lcom/google/android/gms/internal/cast/t;->e:Lcom/google/android/gms/internal/cast/w;

    .line 101
    .line 102
    iget-object v1, v0, Lcom/google/android/gms/internal/cast/w;->b:Ljava/lang/Object;

    .line 103
    .line 104
    check-cast v1, Lq1/u0;

    .line 105
    .line 106
    if-nez v1, :cond_3

    .line 107
    .line 108
    iget-object v1, v0, Lcom/google/android/gms/internal/cast/w;->a:Ljava/lang/Object;

    .line 109
    .line 110
    check-cast v1, Landroid/content/Context;

    .line 111
    .line 112
    invoke-static {v1}, Lq1/u0;->d(Landroid/content/Context;)Lq1/u0;

    .line 113
    .line 114
    .line 115
    move-result-object v1

    .line 116
    iput-object v1, v0, Lcom/google/android/gms/internal/cast/w;->b:Ljava/lang/Object;

    .line 117
    .line 118
    :cond_3
    iget-object v0, v0, Lcom/google/android/gms/internal/cast/w;->b:Ljava/lang/Object;

    .line 119
    .line 120
    check-cast v0, Lq1/u0;

    .line 121
    .line 122
    if-eqz v0, :cond_2

    .line 123
    .line 124
    invoke-virtual {v0, p2}, Lq1/u0;->h(Lq1/m0;)V

    .line 125
    .line 126
    .line 127
    goto :goto_0

    .line 128
    :cond_4
    new-instance v0, Lcom/google/android/gms/internal/cast/y0;

    .line 129
    .line 130
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 131
    .line 132
    .line 133
    move-result-object v1

    .line 134
    invoke-direct {v0, v1, v4}, Lcom/google/android/gms/internal/cast/y0;-><init>(Landroid/os/Looper;I)V

    .line 135
    .line 136
    .line 137
    new-instance v1, Lcom/google/android/gms/internal/cast/q;

    .line 138
    .line 139
    invoke-direct {v1, p2, v4}, Lcom/google/android/gms/internal/cast/q;-><init>(Lcom/google/android/gms/internal/cast/t;I)V

    .line 140
    .line 141
    .line 142
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 143
    .line 144
    .line 145
    goto :goto_0

    .line 146
    :cond_5
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 147
    .line 148
    .line 149
    goto :goto_2

    .line 150
    :cond_6
    move-object p1, p0

    .line 151
    check-cast p1, Lcom/google/android/gms/internal/cast/h;

    .line 152
    .line 153
    new-array p2, v4, [Ljava/lang/Object;

    .line 154
    .line 155
    sget-object v0, Lcom/google/android/gms/internal/cast/h;->g:Lv4/b;

    .line 156
    .line 157
    iget-object v1, v0, Lv4/b;->a:Ljava/lang/String;

    .line 158
    .line 159
    const-string v2, "onAppEnteredForeground"

    .line 160
    .line 161
    invoke-virtual {v0, v2, p2}, Lv4/b;->d(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 162
    .line 163
    .line 164
    move-result-object p2

    .line 165
    invoke-static {v1, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    .line 167
    .line 168
    iput v3, p1, Lcom/google/android/gms/internal/cast/h;->f:I

    .line 169
    .line 170
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/h;->e:Ljava/util/Set;

    .line 171
    .line 172
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 173
    .line 174
    .line 175
    move-result-object p1

    .line 176
    :goto_1
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 177
    .line 178
    .line 179
    move-result p2

    .line 180
    if-eqz p2, :cond_7

    .line 181
    .line 182
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 183
    .line 184
    .line 185
    move-result-object p2

    .line 186
    check-cast p2, Lcom/google/android/gms/internal/cast/s;

    .line 187
    .line 188
    iget-object p2, p2, Lcom/google/android/gms/internal/cast/s;->a:Lcom/google/android/gms/internal/cast/t;

    .line 189
    .line 190
    invoke-virtual {p2}, Lcom/google/android/gms/internal/cast/t;->o()V

    .line 191
    .line 192
    .line 193
    goto :goto_1

    .line 194
    :cond_7
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 195
    .line 196
    .line 197
    goto :goto_2

    .line 198
    :cond_8
    move-object p1, p0

    .line 199
    check-cast p1, Lcom/google/android/gms/internal/cast/h;

    .line 200
    .line 201
    new-instance p2, Lm5/b;

    .line 202
    .line 203
    invoke-direct {p2, p1}, Lm5/b;-><init>(Ljava/lang/Object;)V

    .line 204
    .line 205
    .line 206
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 207
    .line 208
    .line 209
    invoke-static {p3, p2}, Lcom/google/android/gms/internal/cast/e0;->d(Landroid/os/Parcel;Landroid/os/IInterface;)V

    .line 210
    .line 211
    .line 212
    :goto_2
    return v3

    .line 213
    :pswitch_0
    const-string v5, "There is no default route.  The media router has not yet been fully initialized."

    .line 214
    .line 215
    const/4 v6, 0x0

    .line 216
    packed-switch p1, :pswitch_data_1

    .line 217
    .line 218
    .line 219
    const/4 v3, 0x0

    .line 220
    goto/16 :goto_d

    .line 221
    .line 222
    :pswitch_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 223
    .line 224
    .line 225
    move-result p1

    .line 226
    invoke-static {p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 227
    .line 228
    .line 229
    move-object p2, p0

    .line 230
    check-cast p2, Lcom/google/android/gms/internal/cast/v;

    .line 231
    .line 232
    iget-object p2, p2, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 233
    .line 234
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 235
    .line 236
    .line 237
    invoke-static {p1}, Lq1/u0;->i(I)V

    .line 238
    .line 239
    .line 240
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 241
    .line 242
    .line 243
    goto/16 :goto_d

    .line 244
    .line 245
    :pswitch_2
    move-object p1, p0

    .line 246
    check-cast p1, Lcom/google/android/gms/internal/cast/v;

    .line 247
    .line 248
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 249
    .line 250
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 251
    .line 252
    .line 253
    invoke-static {}, Lq1/u0;->b()V

    .line 254
    .line 255
    .line 256
    invoke-static {}, Lq1/u0;->c()Lq1/h;

    .line 257
    .line 258
    .line 259
    move-result-object p1

    .line 260
    iget-object p1, p1, Lq1/h;->w:Lq1/s0;

    .line 261
    .line 262
    if-eqz p1, :cond_9

    .line 263
    .line 264
    invoke-static {}, Lq1/u0;->f()Lq1/s0;

    .line 265
    .line 266
    .line 267
    move-result-object p2

    .line 268
    iget-object p2, p2, Lq1/s0;->c:Ljava/lang/String;

    .line 269
    .line 270
    iget-object p1, p1, Lq1/s0;->c:Ljava/lang/String;

    .line 271
    .line 272
    invoke-virtual {p2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 273
    .line 274
    .line 275
    move-result p1

    .line 276
    if-eqz p1, :cond_9

    .line 277
    .line 278
    const/4 v4, 0x1

    .line 279
    :cond_9
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 280
    .line 281
    .line 282
    sget p1, Lcom/google/android/gms/internal/cast/e0;->a:I

    .line 283
    .line 284
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    .line 285
    .line 286
    .line 287
    goto/16 :goto_d

    .line 288
    .line 289
    :pswitch_3
    move-object p1, p0

    .line 290
    check-cast p1, Lcom/google/android/gms/internal/cast/v;

    .line 291
    .line 292
    iget-object p2, p1, Lcom/google/android/gms/internal/cast/v;->g:Ljava/util/HashMap;

    .line 293
    .line 294
    invoke-virtual {p2}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    .line 295
    .line 296
    .line 297
    move-result-object v0

    .line 298
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    .line 299
    .line 300
    .line 301
    move-result-object v0

    .line 302
    :cond_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 303
    .line 304
    .line 305
    move-result v1

    .line 306
    if-eqz v1, :cond_b

    .line 307
    .line 308
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 309
    .line 310
    .line 311
    move-result-object v1

    .line 312
    check-cast v1, Ljava/util/Set;

    .line 313
    .line 314
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 315
    .line 316
    .line 317
    move-result-object v1

    .line 318
    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    .line 319
    .line 320
    .line 321
    move-result v2

    .line 322
    if-eqz v2, :cond_a

    .line 323
    .line 324
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 325
    .line 326
    .line 327
    move-result-object v2

    .line 328
    check-cast v2, Lq1/m0;

    .line 329
    .line 330
    iget-object v4, p1, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 331
    .line 332
    invoke-virtual {v4, v2}, Lq1/u0;->h(Lq1/m0;)V

    .line 333
    .line 334
    .line 335
    goto :goto_3

    .line 336
    :cond_b
    invoke-virtual {p2}, Ljava/util/HashMap;->clear()V

    .line 337
    .line 338
    .line 339
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 340
    .line 341
    .line 342
    goto/16 :goto_d

    .line 343
    .line 344
    :pswitch_4
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 345
    .line 346
    .line 347
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 348
    .line 349
    .line 350
    goto/16 :goto_d

    .line 351
    .line 352
    :pswitch_5
    move-object p1, p0

    .line 353
    check-cast p1, Lcom/google/android/gms/internal/cast/v;

    .line 354
    .line 355
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 356
    .line 357
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 358
    .line 359
    .line 360
    invoke-static {}, Lq1/u0;->f()Lq1/s0;

    .line 361
    .line 362
    .line 363
    move-result-object p1

    .line 364
    iget-object p1, p1, Lq1/s0;->c:Ljava/lang/String;

    .line 365
    .line 366
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 367
    .line 368
    .line 369
    invoke-virtual {p3, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 370
    .line 371
    .line 372
    goto/16 :goto_d

    .line 373
    .line 374
    :pswitch_6
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 375
    .line 376
    .line 377
    move-result-object p1

    .line 378
    invoke-static {p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 379
    .line 380
    .line 381
    move-object p2, p0

    .line 382
    check-cast p2, Lcom/google/android/gms/internal/cast/v;

    .line 383
    .line 384
    iget-object p2, p2, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 385
    .line 386
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 387
    .line 388
    .line 389
    invoke-static {}, Lq1/u0;->b()V

    .line 390
    .line 391
    .line 392
    invoke-static {}, Lq1/u0;->c()Lq1/h;

    .line 393
    .line 394
    .line 395
    move-result-object p2

    .line 396
    iget-object p2, p2, Lq1/h;->i:Ljava/util/ArrayList;

    .line 397
    .line 398
    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 399
    .line 400
    .line 401
    move-result-object p2

    .line 402
    :cond_c
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    .line 403
    .line 404
    .line 405
    move-result v0

    .line 406
    if-eqz v0, :cond_d

    .line 407
    .line 408
    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 409
    .line 410
    .line 411
    move-result-object v0

    .line 412
    check-cast v0, Lq1/s0;

    .line 413
    .line 414
    iget-object v1, v0, Lq1/s0;->c:Ljava/lang/String;

    .line 415
    .line 416
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 417
    .line 418
    .line 419
    move-result v1

    .line 420
    if-eqz v1, :cond_c

    .line 421
    .line 422
    iget-object v6, v0, Lq1/s0;->s:Landroid/os/Bundle;

    .line 423
    .line 424
    :cond_d
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 425
    .line 426
    .line 427
    if-nez v6, :cond_e

    .line 428
    .line 429
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    .line 430
    .line 431
    .line 432
    goto/16 :goto_d

    .line 433
    .line 434
    :cond_e
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 435
    .line 436
    .line 437
    invoke-virtual {v6, p3, v3}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    .line 438
    .line 439
    .line 440
    goto/16 :goto_d

    .line 441
    .line 442
    :pswitch_7
    move-object p1, p0

    .line 443
    check-cast p1, Lcom/google/android/gms/internal/cast/v;

    .line 444
    .line 445
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 446
    .line 447
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 448
    .line 449
    .line 450
    invoke-static {}, Lq1/u0;->b()V

    .line 451
    .line 452
    .line 453
    invoke-static {}, Lq1/u0;->c()Lq1/h;

    .line 454
    .line 455
    .line 456
    move-result-object p1

    .line 457
    iget-object p1, p1, Lq1/h;->v:Lq1/s0;

    .line 458
    .line 459
    if-eqz p1, :cond_f

    .line 460
    .line 461
    invoke-static {}, Lq1/u0;->f()Lq1/s0;

    .line 462
    .line 463
    .line 464
    move-result-object p2

    .line 465
    iget-object p2, p2, Lq1/s0;->c:Ljava/lang/String;

    .line 466
    .line 467
    iget-object p1, p1, Lq1/s0;->c:Ljava/lang/String;

    .line 468
    .line 469
    invoke-virtual {p2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 470
    .line 471
    .line 472
    move-result p1

    .line 473
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 474
    .line 475
    .line 476
    sget p2, Lcom/google/android/gms/internal/cast/e0;->a:I

    .line 477
    .line 478
    invoke-virtual {p3, p1}, Landroid/os/Parcel;->writeInt(I)V

    .line 479
    .line 480
    .line 481
    goto/16 :goto_d

    .line 482
    .line 483
    :cond_f
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 484
    .line 485
    invoke-direct {p1, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 486
    .line 487
    .line 488
    throw p1

    .line 489
    :pswitch_8
    move-object p1, p0

    .line 490
    check-cast p1, Lcom/google/android/gms/internal/cast/v;

    .line 491
    .line 492
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 493
    .line 494
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 495
    .line 496
    .line 497
    invoke-static {}, Lq1/u0;->b()V

    .line 498
    .line 499
    .line 500
    invoke-static {}, Lq1/u0;->c()Lq1/h;

    .line 501
    .line 502
    .line 503
    move-result-object p1

    .line 504
    iget-object p1, p1, Lq1/h;->v:Lq1/s0;

    .line 505
    .line 506
    if-eqz p1, :cond_10

    .line 507
    .line 508
    invoke-virtual {p1, v3}, Lq1/s0;->l(Z)V

    .line 509
    .line 510
    .line 511
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 512
    .line 513
    .line 514
    goto/16 :goto_d

    .line 515
    .line 516
    :cond_10
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 517
    .line 518
    invoke-direct {p1, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 519
    .line 520
    .line 521
    throw p1

    .line 522
    :pswitch_9
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 523
    .line 524
    .line 525
    move-result-object p1

    .line 526
    invoke-static {p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 527
    .line 528
    .line 529
    move-object p2, p0

    .line 530
    check-cast p2, Lcom/google/android/gms/internal/cast/v;

    .line 531
    .line 532
    new-array v0, v3, [Ljava/lang/Object;

    .line 533
    .line 534
    aput-object p1, v0, v4

    .line 535
    .line 536
    sget-object v1, Lcom/google/android/gms/internal/cast/v;->l:Lv4/b;

    .line 537
    .line 538
    const-string v2, "select route with routeId = %s"

    .line 539
    .line 540
    invoke-virtual {v1, v2, v0}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 541
    .line 542
    .line 543
    iget-object p2, p2, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 544
    .line 545
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 546
    .line 547
    .line 548
    invoke-static {}, Lq1/u0;->b()V

    .line 549
    .line 550
    .line 551
    invoke-static {}, Lq1/u0;->c()Lq1/h;

    .line 552
    .line 553
    .line 554
    move-result-object p2

    .line 555
    iget-object p2, p2, Lq1/h;->i:Ljava/util/ArrayList;

    .line 556
    .line 557
    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 558
    .line 559
    .line 560
    move-result-object p2

    .line 561
    :cond_11
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    .line 562
    .line 563
    .line 564
    move-result v0

    .line 565
    if-eqz v0, :cond_12

    .line 566
    .line 567
    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 568
    .line 569
    .line 570
    move-result-object v0

    .line 571
    check-cast v0, Lq1/s0;

    .line 572
    .line 573
    iget-object v2, v0, Lq1/s0;->c:Ljava/lang/String;

    .line 574
    .line 575
    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 576
    .line 577
    .line 578
    move-result v2

    .line 579
    if-eqz v2, :cond_11

    .line 580
    .line 581
    new-array p1, v4, [Ljava/lang/Object;

    .line 582
    .line 583
    const-string p2, "media route is found and selected"

    .line 584
    .line 585
    invoke-virtual {v1, p2, p1}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 586
    .line 587
    .line 588
    invoke-virtual {v0, v3}, Lq1/s0;->l(Z)V

    .line 589
    .line 590
    .line 591
    :cond_12
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 592
    .line 593
    .line 594
    goto/16 :goto_d

    .line 595
    .line 596
    :pswitch_a
    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 597
    .line 598
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 599
    .line 600
    .line 601
    move-result-object p1

    .line 602
    check-cast p1, Landroid/os/Bundle;

    .line 603
    .line 604
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 605
    .line 606
    .line 607
    move-result v0

    .line 608
    invoke-static {p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 609
    .line 610
    .line 611
    move-object p2, p0

    .line 612
    check-cast p2, Lcom/google/android/gms/internal/cast/v;

    .line 613
    .line 614
    invoke-static {p1}, Lq1/l0;->b(Landroid/os/Bundle;)Lq1/l0;

    .line 615
    .line 616
    .line 617
    move-result-object p1

    .line 618
    if-nez p1, :cond_13

    .line 619
    .line 620
    goto/16 :goto_8

    .line 621
    .line 622
    :cond_13
    iget-object p2, p2, Lcom/google/android/gms/internal/cast/v;->e:Lq1/u0;

    .line 623
    .line 624
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 625
    .line 626
    .line 627
    invoke-static {}, Lq1/u0;->b()V

    .line 628
    .line 629
    .line 630
    invoke-static {}, Lq1/u0;->c()Lq1/h;

    .line 631
    .line 632
    .line 633
    move-result-object p2

    .line 634
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 635
    .line 636
    .line 637
    invoke-virtual {p1}, Lq1/l0;->d()Z

    .line 638
    .line 639
    .line 640
    move-result v1

    .line 641
    if-eqz v1, :cond_14

    .line 642
    .line 643
    goto :goto_8

    .line 644
    :cond_14
    and-int/lit8 v1, v0, 0x2

    .line 645
    .line 646
    if-nez v1, :cond_15

    .line 647
    .line 648
    iget-boolean v1, p2, Lq1/h;->p:Z

    .line 649
    .line 650
    if-eqz v1, :cond_15

    .line 651
    .line 652
    :goto_4
    const/4 v4, 0x1

    .line 653
    goto :goto_8

    .line 654
    :cond_15
    iget-object v1, p2, Lq1/h;->u:Lq1/x0;

    .line 655
    .line 656
    if-eqz v1, :cond_16

    .line 657
    .line 658
    iget-boolean v1, v1, Lq1/x0;->b:Z

    .line 659
    .line 660
    if-eqz v1, :cond_16

    .line 661
    .line 662
    invoke-virtual {p2}, Lq1/h;->h()Z

    .line 663
    .line 664
    .line 665
    move-result v1

    .line 666
    if-eqz v1, :cond_16

    .line 667
    .line 668
    const/4 v1, 0x1

    .line 669
    goto :goto_5

    .line 670
    :cond_16
    const/4 v1, 0x0

    .line 671
    :goto_5
    iget-object v2, p2, Lq1/h;->i:Ljava/util/ArrayList;

    .line 672
    .line 673
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 674
    .line 675
    .line 676
    move-result v5

    .line 677
    const/4 v6, 0x0

    .line 678
    :goto_6
    if-ge v6, v5, :cond_1a

    .line 679
    .line 680
    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 681
    .line 682
    .line 683
    move-result-object v7

    .line 684
    check-cast v7, Lq1/s0;

    .line 685
    .line 686
    and-int/lit8 v8, v0, 0x1

    .line 687
    .line 688
    if-eqz v8, :cond_17

    .line 689
    .line 690
    invoke-virtual {v7}, Lq1/s0;->d()Z

    .line 691
    .line 692
    .line 693
    move-result v8

    .line 694
    if-eqz v8, :cond_17

    .line 695
    .line 696
    goto :goto_7

    .line 697
    :cond_17
    if-eqz v1, :cond_18

    .line 698
    .line 699
    invoke-virtual {v7}, Lq1/s0;->d()Z

    .line 700
    .line 701
    .line 702
    move-result v8

    .line 703
    if-nez v8, :cond_18

    .line 704
    .line 705
    invoke-virtual {v7}, Lq1/s0;->c()Lq1/e0;

    .line 706
    .line 707
    .line 708
    move-result-object v8

    .line 709
    iget-object v9, p2, Lq1/h;->r:Lq1/p;

    .line 710
    .line 711
    if-eq v8, v9, :cond_18

    .line 712
    .line 713
    goto :goto_7

    .line 714
    :cond_18
    invoke-virtual {v7, p1}, Lq1/s0;->h(Lq1/l0;)Z

    .line 715
    .line 716
    .line 717
    move-result v7

    .line 718
    if-eqz v7, :cond_19

    .line 719
    .line 720
    goto :goto_4

    .line 721
    :cond_19
    :goto_7
    add-int/2addr v6, v3

    .line 722
    goto :goto_6

    .line 723
    :cond_1a
    :goto_8
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 724
    .line 725
    .line 726
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    .line 727
    .line 728
    .line 729
    goto/16 :goto_d

    .line 730
    .line 731
    :pswitch_b
    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 732
    .line 733
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 734
    .line 735
    .line 736
    move-result-object p1

    .line 737
    check-cast p1, Landroid/os/Bundle;

    .line 738
    .line 739
    invoke-static {p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 740
    .line 741
    .line 742
    move-object p2, p0

    .line 743
    check-cast p2, Lcom/google/android/gms/internal/cast/v;

    .line 744
    .line 745
    invoke-static {p1}, Lq1/l0;->b(Landroid/os/Bundle;)Lq1/l0;

    .line 746
    .line 747
    .line 748
    move-result-object p1

    .line 749
    if-nez p1, :cond_1b

    .line 750
    .line 751
    goto :goto_9

    .line 752
    :cond_1b
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    .line 753
    .line 754
    .line 755
    move-result-object v0

    .line 756
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 757
    .line 758
    .line 759
    move-result-object v1

    .line 760
    if-ne v0, v1, :cond_1c

    .line 761
    .line 762
    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/cast/v;->A(Lq1/l0;)V

    .line 763
    .line 764
    .line 765
    goto :goto_9

    .line 766
    :cond_1c
    new-instance v0, Lcom/google/android/gms/internal/cast/y0;

    .line 767
    .line 768
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 769
    .line 770
    .line 771
    move-result-object v1

    .line 772
    invoke-direct {v0, v1, v4}, Lcom/google/android/gms/internal/cast/y0;-><init>(Landroid/os/Looper;I)V

    .line 773
    .line 774
    .line 775
    new-instance v1, Lcom/google/android/gms/internal/cast/n;

    .line 776
    .line 777
    invoke-direct {v1, p2, v2, p1}, Lcom/google/android/gms/internal/cast/n;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 778
    .line 779
    .line 780
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 781
    .line 782
    .line 783
    :goto_9
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 784
    .line 785
    .line 786
    goto/16 :goto_d

    .line 787
    .line 788
    :pswitch_c
    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 789
    .line 790
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 791
    .line 792
    .line 793
    move-result-object p1

    .line 794
    check-cast p1, Landroid/os/Bundle;

    .line 795
    .line 796
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 797
    .line 798
    .line 799
    move-result v0

    .line 800
    invoke-static {p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 801
    .line 802
    .line 803
    move-object p2, p0

    .line 804
    check-cast p2, Lcom/google/android/gms/internal/cast/v;

    .line 805
    .line 806
    invoke-static {p1}, Lq1/l0;->b(Landroid/os/Bundle;)Lq1/l0;

    .line 807
    .line 808
    .line 809
    move-result-object p1

    .line 810
    if-nez p1, :cond_1d

    .line 811
    .line 812
    goto :goto_a

    .line 813
    :cond_1d
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    .line 814
    .line 815
    .line 816
    move-result-object v2

    .line 817
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 818
    .line 819
    .line 820
    move-result-object v5

    .line 821
    if-ne v2, v5, :cond_1e

    .line 822
    .line 823
    invoke-virtual {p2, p1, v0}, Lcom/google/android/gms/internal/cast/v;->z(Lq1/l0;I)V

    .line 824
    .line 825
    .line 826
    goto :goto_a

    .line 827
    :cond_1e
    new-instance v2, Lcom/google/android/gms/internal/cast/y0;

    .line 828
    .line 829
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 830
    .line 831
    .line 832
    move-result-object v5

    .line 833
    invoke-direct {v2, v5, v4}, Lcom/google/android/gms/internal/cast/y0;-><init>(Landroid/os/Looper;I)V

    .line 834
    .line 835
    .line 836
    new-instance v4, Landroidx/appcompat/widget/r0;

    .line 837
    .line 838
    invoke-direct {v4, p2, p1, v0, v1}, Landroidx/appcompat/widget/r0;-><init>(Ljava/lang/Object;Ljava/lang/Object;II)V

    .line 839
    .line 840
    .line 841
    invoke-virtual {v2, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 842
    .line 843
    .line 844
    :goto_a
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 845
    .line 846
    .line 847
    goto :goto_d

    .line 848
    :pswitch_d
    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 849
    .line 850
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 851
    .line 852
    .line 853
    move-result-object p1

    .line 854
    check-cast p1, Landroid/os/Bundle;

    .line 855
    .line 856
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    .line 857
    .line 858
    .line 859
    move-result-object v0

    .line 860
    if-nez v0, :cond_1f

    .line 861
    .line 862
    goto :goto_b

    .line 863
    :cond_1f
    const-string v1, "com.google.android.gms.cast.framework.internal.IMediaRouterCallback"

    .line 864
    .line 865
    invoke-interface {v0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    .line 866
    .line 867
    .line 868
    move-result-object v2

    .line 869
    instance-of v5, v2, Lcom/google/android/gms/internal/cast/m;

    .line 870
    .line 871
    if-eqz v5, :cond_20

    .line 872
    .line 873
    move-object v6, v2

    .line 874
    check-cast v6, Lcom/google/android/gms/internal/cast/m;

    .line 875
    .line 876
    goto :goto_b

    .line 877
    :cond_20
    new-instance v6, Lcom/google/android/gms/internal/cast/m;

    .line 878
    .line 879
    invoke-direct {v6, v0, v1, v4}, Lcom/google/android/gms/internal/cast/a;-><init>(Landroid/os/IBinder;Ljava/lang/String;I)V

    .line 880
    .line 881
    .line 882
    :goto_b
    invoke-static {p2}, Lcom/google/android/gms/internal/cast/e0;->b(Landroid/os/Parcel;)V

    .line 883
    .line 884
    .line 885
    move-object p2, p0

    .line 886
    check-cast p2, Lcom/google/android/gms/internal/cast/v;

    .line 887
    .line 888
    invoke-static {p1}, Lq1/l0;->b(Landroid/os/Bundle;)Lq1/l0;

    .line 889
    .line 890
    .line 891
    move-result-object p1

    .line 892
    if-nez p1, :cond_21

    .line 893
    .line 894
    goto :goto_c

    .line 895
    :cond_21
    iget-object v0, p2, Lcom/google/android/gms/internal/cast/v;->g:Ljava/util/HashMap;

    .line 896
    .line 897
    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    .line 898
    .line 899
    .line 900
    move-result v1

    .line 901
    if-nez v1, :cond_22

    .line 902
    .line 903
    new-instance v1, Ljava/util/HashSet;

    .line 904
    .line 905
    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 906
    .line 907
    .line 908
    invoke-virtual {v0, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 909
    .line 910
    .line 911
    :cond_22
    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 912
    .line 913
    .line 914
    move-result-object p1

    .line 915
    check-cast p1, Ljava/util/Set;

    .line 916
    .line 917
    new-instance v0, Lcom/google/android/gms/internal/cast/p;

    .line 918
    .line 919
    iget-object v1, p2, Lcom/google/android/gms/internal/cast/v;->h:Lcom/google/android/gms/internal/cast/y;

    .line 920
    .line 921
    invoke-direct {v0, v6, p2, v1}, Lcom/google/android/gms/internal/cast/p;-><init>(Lcom/google/android/gms/internal/cast/m;Lcom/google/android/gms/internal/cast/v;Lcom/google/android/gms/internal/cast/y;)V

    .line 922
    .line 923
    .line 924
    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 925
    .line 926
    .line 927
    :goto_c
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 928
    .line 929
    .line 930
    :goto_d
    return v3

    .line 931
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch

    .line 932
    .line 933
    .line 934
    .line 935
    .line 936
    .line 937
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method
