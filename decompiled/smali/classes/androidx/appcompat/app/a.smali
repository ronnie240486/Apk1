.class public final Landroidx/appcompat/app/a;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic a:I

.field public final synthetic b:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Landroidx/appcompat/app/a;->a:I

    iput-object p2, p0, Landroidx/appcompat/app/a;->b:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Lfa/b;Lha/a;)V
    .locals 0

    const/16 p2, 0x9

    iput p2, p0, Landroidx/appcompat/app/a;->a:I

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/appcompat/app/a;->b:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 7

    .line 1
    const v0, 0x7f1201a2

    .line 2
    .line 3
    .line 4
    const v1, 0x7f1201a3

    .line 5
    .line 6
    .line 7
    const/4 v2, 0x0

    .line 8
    const/4 v3, 0x0

    .line 9
    const/4 v4, 0x1

    .line 10
    iget-object v5, p0, Landroidx/appcompat/app/a;->b:Ljava/lang/Object;

    .line 11
    .line 12
    iget v6, p0, Landroidx/appcompat/app/a;->a:I

    .line 13
    .line 14
    packed-switch v6, :pswitch_data_0

    .line 15
    .line 16
    .line 17
    check-cast v5, Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;

    .line 18
    .line 19
    iget-object p1, v5, Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;->d0:Landroid/widget/TextView;

    .line 20
    .line 21
    invoke-virtual {p1}, Landroid/view/View;->isClickable()Z

    .line 22
    .line 23
    .line 24
    move-result p1

    .line 25
    if-eqz p1, :cond_1

    .line 26
    .line 27
    invoke-virtual {v5}, Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;->p()Lr4/f;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    if-eqz p1, :cond_1

    .line 32
    .line 33
    const-string v0, "Must be called from the main thread."

    .line 34
    .line 35
    invoke-static {v0}, Lb5/l;->b(Ljava/lang/String;)V

    .line 36
    .line 37
    .line 38
    invoke-virtual {p1}, Lr4/f;->F()Z

    .line 39
    .line 40
    .line 41
    move-result v0

    .line 42
    if-nez v0, :cond_0

    .line 43
    .line 44
    invoke-static {}, Lr4/f;->x()Lr4/m;

    .line 45
    .line 46
    .line 47
    goto :goto_0

    .line 48
    :cond_0
    new-instance v0, Lr4/h;

    .line 49
    .line 50
    const/4 v1, 0x5

    .line 51
    invoke-direct {v0, p1, v1}, Lr4/h;-><init>(Lr4/f;I)V

    .line 52
    .line 53
    .line 54
    invoke-static {v0}, Lr4/f;->G(Lr4/o;)V

    .line 55
    .line 56
    .line 57
    :cond_1
    :goto_0
    return-void

    .line 58
    :pswitch_0
    check-cast v5, Lt3/c;

    .line 59
    .line 60
    iget-object p1, v5, Lt3/c;->a:Lq1/f0;

    .line 61
    .line 62
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 63
    .line 64
    .line 65
    return-void

    .line 66
    :pswitch_1
    check-cast v5, Lsa/e;

    .line 67
    .line 68
    invoke-virtual {v5}, Landroid/app/Dialog;->dismiss()V

    .line 69
    .line 70
    .line 71
    return-void

    .line 72
    :pswitch_2
    check-cast v5, Lsa/e;

    .line 73
    .line 74
    invoke-virtual {v5}, Landroid/app/Dialog;->dismiss()V

    .line 75
    .line 76
    .line 77
    return-void

    .line 78
    :pswitch_3
    check-cast v5, Lsa/g;

    .line 79
    .line 80
    invoke-virtual {v5}, Landroid/widget/PopupWindow;->dismiss()V

    .line 81
    .line 82
    .line 83
    return-void

    .line 84
    :pswitch_4
    check-cast v5, Lla/d;

    .line 85
    .line 86
    iput-object v2, v5, Lla/d;->k0:Lsa/p;

    .line 87
    .line 88
    invoke-virtual {v5}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 89
    .line 90
    .line 91
    move-result-object p1

    .line 92
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 93
    .line 94
    .line 95
    move-result-object p1

    .line 96
    const-string v2, "PL4la9l+a90BqQho2w==\n"

    .line 97
    .line 98
    const-string v6, "aMhkB7wMH5k=\n"

    .line 99
    .line 100
    invoke-static {v2, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 101
    .line 102
    .line 103
    move-result-object v2

    .line 104
    invoke-virtual {p1, v2}, Landroidx/fragment/app/j0;->z(Ljava/lang/String;)Landroidx/fragment/app/s;

    .line 105
    .line 106
    .line 107
    move-result-object p1

    .line 108
    if-eqz p1, :cond_2

    .line 109
    .line 110
    move-object v2, p1

    .line 111
    check-cast v2, Landroidx/fragment/app/m;

    .line 112
    .line 113
    invoke-virtual {v2, v4, v3}, Landroidx/fragment/app/m;->Q(ZZ)V

    .line 114
    .line 115
    .line 116
    invoke-virtual {v5}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 117
    .line 118
    .line 119
    move-result-object v2

    .line 120
    invoke-virtual {v2}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 121
    .line 122
    .line 123
    move-result-object v2

    .line 124
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 125
    .line 126
    .line 127
    new-instance v6, Landroidx/fragment/app/a;

    .line 128
    .line 129
    invoke-direct {v6, v2}, Landroidx/fragment/app/a;-><init>(Landroidx/fragment/app/j0;)V

    .line 130
    .line 131
    .line 132
    invoke-virtual {v6, p1}, Landroidx/fragment/app/a;->h(Landroidx/fragment/app/s;)V

    .line 133
    .line 134
    .line 135
    invoke-virtual {v6, v4}, Landroidx/fragment/app/a;->e(Z)I

    .line 136
    .line 137
    .line 138
    invoke-virtual {v5}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 139
    .line 140
    .line 141
    move-result-object p1

    .line 142
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 143
    .line 144
    .line 145
    move-result-object p1

    .line 146
    invoke-virtual {p1, v4}, Landroidx/fragment/app/j0;->u(Z)Z

    .line 147
    .line 148
    .line 149
    invoke-virtual {p1}, Landroidx/fragment/app/j0;->A()V

    .line 150
    .line 151
    .line 152
    :cond_2
    new-instance p1, Lla/b;

    .line 153
    .line 154
    invoke-direct {p1, v5, v3}, Lla/b;-><init>(Lla/d;I)V

    .line 155
    .line 156
    .line 157
    new-instance v2, Lla/b;

    .line 158
    .line 159
    invoke-direct {v2, v5, v4}, Lla/b;-><init>(Lla/d;I)V

    .line 160
    .line 161
    .line 162
    iget-boolean v3, v5, Lla/d;->l0:Z

    .line 163
    .line 164
    if-eqz v3, :cond_3

    .line 165
    .line 166
    invoke-virtual {v5, v1}, Landroidx/fragment/app/s;->n(I)Ljava/lang/String;

    .line 167
    .line 168
    .line 169
    move-result-object v0

    .line 170
    goto :goto_1

    .line 171
    :cond_3
    invoke-virtual {v5, v0}, Landroidx/fragment/app/s;->n(I)Ljava/lang/String;

    .line 172
    .line 173
    .line 174
    move-result-object v0

    .line 175
    :goto_1
    new-instance v1, Lsa/p;

    .line 176
    .line 177
    invoke-direct {v1}, Lsa/p;-><init>()V

    .line 178
    .line 179
    .line 180
    iput-object p1, v1, Lsa/p;->k0:Ljava/lang/Runnable;

    .line 181
    .line 182
    iput-object v2, v1, Lsa/p;->l0:Ljava/lang/Runnable;

    .line 183
    .line 184
    new-instance p1, Landroid/os/Bundle;

    .line 185
    .line 186
    invoke-direct {p1}, Landroid/os/Bundle;-><init>()V

    .line 187
    .line 188
    .line 189
    sget-object v2, Lsa/p;->s0:Ljava/lang/String;

    .line 190
    .line 191
    invoke-virtual {p1, v2, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    .line 193
    .line 194
    invoke-virtual {v1, p1}, Landroidx/fragment/app/s;->O(Landroid/os/Bundle;)V

    .line 195
    .line 196
    .line 197
    iput-object v1, v5, Lla/d;->k0:Lsa/p;

    .line 198
    .line 199
    new-instance p1, Lla/a;

    .line 200
    .line 201
    invoke-direct {p1, v5}, Lla/a;-><init>(Lla/d;)V

    .line 202
    .line 203
    .line 204
    iput-object p1, v1, Lsa/p;->r0:Lsa/o;

    .line 205
    .line 206
    invoke-virtual {v5}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 207
    .line 208
    .line 209
    move-result-object p1

    .line 210
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 211
    .line 212
    .line 213
    move-result-object p1

    .line 214
    const-string v0, "qWnSYTxT66GUfv9iPg==\n"

    .line 215
    .line 216
    const-string v2, "/R+TDVkhn+U=\n"

    .line 217
    .line 218
    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 219
    .line 220
    .line 221
    move-result-object v0

    .line 222
    invoke-virtual {v1, p1, v0}, Landroidx/fragment/app/m;->S(Landroidx/fragment/app/k0;Ljava/lang/String;)V

    .line 223
    .line 224
    .line 225
    iget-object p1, v5, Lla/d;->X:Landroid/widget/RelativeLayout;

    .line 226
    .line 227
    const/4 v0, 0x4

    .line 228
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 229
    .line 230
    .line 231
    return-void

    .line 232
    :pswitch_5
    check-cast v5, Lka/y;

    .line 233
    .line 234
    iput-object v2, v5, Lka/y;->r1:Lsa/p;

    .line 235
    .line 236
    invoke-virtual {v5}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 237
    .line 238
    .line 239
    move-result-object p1

    .line 240
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 241
    .line 242
    .line 243
    move-result-object p1

    .line 244
    const-string v2, "LKsiaJtYxGARvA9rmQ==\n"

    .line 245
    .line 246
    const-string v6, "eN1jBP4qsCQ=\n"

    .line 247
    .line 248
    invoke-static {v2, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 249
    .line 250
    .line 251
    move-result-object v2

    .line 252
    invoke-virtual {p1, v2}, Landroidx/fragment/app/j0;->z(Ljava/lang/String;)Landroidx/fragment/app/s;

    .line 253
    .line 254
    .line 255
    move-result-object p1

    .line 256
    if-eqz p1, :cond_4

    .line 257
    .line 258
    move-object v2, p1

    .line 259
    check-cast v2, Landroidx/fragment/app/m;

    .line 260
    .line 261
    invoke-virtual {v2, v4, v3}, Landroidx/fragment/app/m;->Q(ZZ)V

    .line 262
    .line 263
    .line 264
    invoke-virtual {v5}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 265
    .line 266
    .line 267
    move-result-object v2

    .line 268
    invoke-virtual {v2}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 269
    .line 270
    .line 271
    move-result-object v2

    .line 272
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 273
    .line 274
    .line 275
    new-instance v6, Landroidx/fragment/app/a;

    .line 276
    .line 277
    invoke-direct {v6, v2}, Landroidx/fragment/app/a;-><init>(Landroidx/fragment/app/j0;)V

    .line 278
    .line 279
    .line 280
    invoke-virtual {v6, p1}, Landroidx/fragment/app/a;->h(Landroidx/fragment/app/s;)V

    .line 281
    .line 282
    .line 283
    invoke-virtual {v6, v4}, Landroidx/fragment/app/a;->e(Z)I

    .line 284
    .line 285
    .line 286
    invoke-virtual {v5}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 287
    .line 288
    .line 289
    move-result-object p1

    .line 290
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 291
    .line 292
    .line 293
    move-result-object p1

    .line 294
    invoke-virtual {p1, v4}, Landroidx/fragment/app/j0;->u(Z)Z

    .line 295
    .line 296
    .line 297
    invoke-virtual {p1}, Landroidx/fragment/app/j0;->A()V

    .line 298
    .line 299
    .line 300
    :cond_4
    new-instance p1, Lka/w;

    .line 301
    .line 302
    invoke-direct {p1, v5, v3}, Lka/w;-><init>(Lka/y;I)V

    .line 303
    .line 304
    .line 305
    new-instance v2, Lka/w;

    .line 306
    .line 307
    invoke-direct {v2, v5, v4}, Lka/w;-><init>(Lka/y;I)V

    .line 308
    .line 309
    .line 310
    iget-boolean v3, v5, Lka/y;->q1:Z

    .line 311
    .line 312
    if-eqz v3, :cond_5

    .line 313
    .line 314
    invoke-virtual {v5, v1}, Landroidx/fragment/app/s;->n(I)Ljava/lang/String;

    .line 315
    .line 316
    .line 317
    move-result-object v0

    .line 318
    goto :goto_2

    .line 319
    :cond_5
    invoke-virtual {v5, v0}, Landroidx/fragment/app/s;->n(I)Ljava/lang/String;

    .line 320
    .line 321
    .line 322
    move-result-object v0

    .line 323
    :goto_2
    new-instance v1, Lsa/p;

    .line 324
    .line 325
    invoke-direct {v1}, Lsa/p;-><init>()V

    .line 326
    .line 327
    .line 328
    iput-object p1, v1, Lsa/p;->k0:Ljava/lang/Runnable;

    .line 329
    .line 330
    iput-object v2, v1, Lsa/p;->l0:Ljava/lang/Runnable;

    .line 331
    .line 332
    new-instance p1, Landroid/os/Bundle;

    .line 333
    .line 334
    invoke-direct {p1}, Landroid/os/Bundle;-><init>()V

    .line 335
    .line 336
    .line 337
    sget-object v2, Lsa/p;->s0:Ljava/lang/String;

    .line 338
    .line 339
    invoke-virtual {p1, v2, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    .line 341
    .line 342
    invoke-virtual {v1, p1}, Landroidx/fragment/app/s;->O(Landroid/os/Bundle;)V

    .line 343
    .line 344
    .line 345
    iput-object v1, v5, Lka/y;->r1:Lsa/p;

    .line 346
    .line 347
    new-instance p1, Lx4/e;

    .line 348
    .line 349
    const/16 v0, 0x13

    .line 350
    .line 351
    invoke-direct {p1, v0}, Lx4/e;-><init>(I)V

    .line 352
    .line 353
    .line 354
    iput-object p1, v1, Lsa/p;->r0:Lsa/o;

    .line 355
    .line 356
    invoke-virtual {v5}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 357
    .line 358
    .line 359
    move-result-object p1

    .line 360
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 361
    .line 362
    .line 363
    move-result-object p1

    .line 364
    const-string v0, "kzFOlWvkeeyuJmOWaQ==\n"

    .line 365
    .line 366
    const-string v2, "x0cP+Q6WDag=\n"

    .line 367
    .line 368
    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 369
    .line 370
    .line 371
    move-result-object v0

    .line 372
    invoke-virtual {v1, p1, v0}, Landroidx/fragment/app/m;->S(Landroidx/fragment/app/k0;Ljava/lang/String;)V

    .line 373
    .line 374
    .line 375
    new-instance p1, Ljava/lang/StringBuilder;

    .line 376
    .line 377
    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 378
    .line 379
    .line 380
    const-string v0, "WGpB+8/GX9pDf0b9z9wPlhIiHbCC2BGWEiIdsILYJQ==\n"

    .line 381
    .line 382
    const-string v1, "LBwjjrzmL6g=\n"

    .line 383
    .line 384
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 385
    .line 386
    .line 387
    move-result-object v0

    .line 388
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 389
    .line 390
    .line 391
    invoke-static {}, Lcom/tvbus/engine/TVCore;->getInstance()Lcom/tvbus/engine/TVCore;

    .line 392
    .line 393
    .line 394
    move-result-object v0

    .line 395
    const/16 v1, 0x7ea

    .line 396
    .line 397
    invoke-virtual {v0, v1}, Lcom/tvbus/engine/TVCore;->getVersion(I)Ljava/lang/String;

    .line 398
    .line 399
    .line 400
    move-result-object v0

    .line 401
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 402
    .line 403
    .line 404
    const-string v0, "OoQ+gwAzOQYMhD6DADM5BgyEPrU=\n"

    .line 405
    .line 406
    const-string v1, "MLgCvzwPBTo=\n"

    .line 407
    .line 408
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 409
    .line 410
    .line 411
    move-result-object v0

    .line 412
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 413
    .line 414
    .line 415
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 416
    .line 417
    .line 418
    move-result-object p1

    .line 419
    sget-boolean v0, Lorg/bitspark/android/utils/m;->b:Z

    .line 420
    .line 421
    sget-object v0, Lka/y;->u1:Ljava/lang/String;

    .line 422
    .line 423
    invoke-static {v0, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 424
    .line 425
    .line 426
    new-instance p1, Ljava/lang/StringBuilder;

    .line 427
    .line 428
    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 429
    .line 430
    .line 431
    const-string v1, "Hy+MSv/GW2kEOopY/twLJVVn0RWz2BUlVWfRFbPYIQ==\n"

    .line 432
    .line 433
    const-string v2, "a1nvK43mKxs=\n"

    .line 434
    .line 435
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 436
    .line 437
    .line 438
    move-result-object v1

    .line 439
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 440
    .line 441
    .line 442
    const-wide/16 v1, 0x7ea

    .line 443
    .line 444
    invoke-static {v1, v2}, Lio/binstream/libtvcar/Libtvcar;->getVersion(J)Ljava/lang/String;

    .line 445
    .line 446
    .line 447
    move-result-object v1

    .line 448
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 449
    .line 450
    .line 451
    const-string v1, "WPqSJTnXm/Ru+pIlOdeb9G76khM=\n"

    .line 452
    .line 453
    const-string v2, "UsauGQXrp8g=\n"

    .line 454
    .line 455
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 456
    .line 457
    .line 458
    move-result-object v1

    .line 459
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 460
    .line 461
    .line 462
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 463
    .line 464
    .line 465
    move-result-object p1

    .line 466
    invoke-static {v0, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 467
    .line 468
    .line 469
    return-void

    .line 470
    :pswitch_6
    check-cast v5, Lka/i;

    .line 471
    .line 472
    iget-object p1, v5, Lka/i;->a:Lka/j;

    .line 473
    .line 474
    iget-object v0, p1, Lka/j;->W:Lorg/bitspark/android/beans/EventBean;

    .line 475
    .line 476
    invoke-virtual {p1, v0}, Lka/j;->R(Lorg/bitspark/android/beans/EventBean;)V

    .line 477
    .line 478
    .line 479
    return-void

    .line 480
    :pswitch_7
    check-cast v5, Lfa/j1;

    .line 481
    .line 482
    iget v0, v5, Lfa/p;->a:I

    .line 483
    .line 484
    invoke-virtual {v5, v0}, Landroidx/recyclerview/widget/k0;->notifyItemChanged(I)V

    .line 485
    .line 486
    .line 487
    iget-object v0, v5, Lfa/p;->c:Landroidx/recyclerview/widget/RecyclerView;

    .line 488
    .line 489
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 490
    .line 491
    .line 492
    move-result v0

    .line 493
    iput v0, v5, Lfa/p;->b:I

    .line 494
    .line 495
    iget-object v0, v5, Lfa/p;->c:Landroidx/recyclerview/widget/RecyclerView;

    .line 496
    .line 497
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 498
    .line 499
    .line 500
    move-result p1

    .line 501
    iput p1, v5, Lfa/p;->a:I

    .line 502
    .line 503
    iget p1, v5, Lfa/p;->a:I

    .line 504
    .line 505
    invoke-virtual {v5, p1}, Landroidx/recyclerview/widget/k0;->notifyItemChanged(I)V

    .line 506
    .line 507
    .line 508
    return-void

    .line 509
    :pswitch_8
    check-cast v5, Lfa/h1;

    .line 510
    .line 511
    iget v0, v5, Lfa/p;->a:I

    .line 512
    .line 513
    invoke-virtual {v5, v0}, Landroidx/recyclerview/widget/k0;->notifyItemChanged(I)V

    .line 514
    .line 515
    .line 516
    iget-object v0, v5, Lfa/p;->c:Landroidx/recyclerview/widget/RecyclerView;

    .line 517
    .line 518
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 519
    .line 520
    .line 521
    move-result v0

    .line 522
    iput v0, v5, Lfa/p;->b:I

    .line 523
    .line 524
    iget-object v0, v5, Lfa/p;->c:Landroidx/recyclerview/widget/RecyclerView;

    .line 525
    .line 526
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 527
    .line 528
    .line 529
    move-result p1

    .line 530
    iput p1, v5, Lfa/p;->a:I

    .line 531
    .line 532
    iget p1, v5, Lfa/p;->a:I

    .line 533
    .line 534
    invoke-virtual {v5, p1}, Landroidx/recyclerview/widget/k0;->notifyItemChanged(I)V

    .line 535
    .line 536
    .line 537
    return-void

    .line 538
    :pswitch_9
    sget-object p1, Lfa/u;->e:Ljava/lang/String;

    .line 539
    .line 540
    const-string v0, "D8Fb35WTtqwPwVvQmpyr/ly/CovLxQ==\n"

    .line 541
    .line 542
    const-string v1, "Mvxm4qiui5E=\n"

    .line 543
    .line 544
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 545
    .line 546
    .line 547
    move-result-object v0

    .line 548
    sget-boolean v1, Lorg/bitspark/android/utils/m;->b:Z

    .line 549
    .line 550
    invoke-static {p1, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 551
    .line 552
    .line 553
    check-cast v5, Lfa/u;

    .line 554
    .line 555
    iget-object p1, v5, Lfa/u;->d:Landroidx/recyclerview/widget/RecyclerView;

    .line 556
    .line 557
    iget v0, v5, Lfa/u;->b:I

    .line 558
    .line 559
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroidx/recyclerview/widget/p1;

    .line 560
    .line 561
    .line 562
    move-result-object p1

    .line 563
    if-eqz p1, :cond_6

    .line 564
    .line 565
    iget-object p1, v5, Lfa/u;->d:Landroidx/recyclerview/widget/RecyclerView;

    .line 566
    .line 567
    iget v0, v5, Lfa/u;->b:I

    .line 568
    .line 569
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroidx/recyclerview/widget/p1;

    .line 570
    .line 571
    .line 572
    move-result-object p1

    .line 573
    iget-object p1, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 574
    .line 575
    if-eqz p1, :cond_6

    .line 576
    .line 577
    iget-object p1, v5, Lfa/u;->d:Landroidx/recyclerview/widget/RecyclerView;

    .line 578
    .line 579
    iget v0, v5, Lfa/u;->b:I

    .line 580
    .line 581
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroidx/recyclerview/widget/p1;

    .line 582
    .line 583
    .line 584
    move-result-object p1

    .line 585
    iget-object p1, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 586
    .line 587
    invoke-virtual {p1}, Landroid/view/View;->performClick()Z

    .line 588
    .line 589
    .line 590
    sput v4, Lfa/u;->f:I

    .line 591
    .line 592
    :cond_6
    return-void

    .line 593
    :pswitch_a
    sget-object p1, Lfa/o;->i:Ljava/lang/String;

    .line 594
    .line 595
    const-string v0, "1Bjc+zRk4C7UGNz0O2v9fIdmja9qMg==\n"

    .line 596
    .line 597
    const-string v1, "6SXhxglZ3RM=\n"

    .line 598
    .line 599
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 600
    .line 601
    .line 602
    move-result-object v0

    .line 603
    sget-boolean v1, Lorg/bitspark/android/utils/m;->b:Z

    .line 604
    .line 605
    invoke-static {p1, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 606
    .line 607
    .line 608
    check-cast v5, Lfa/o;

    .line 609
    .line 610
    iget-object p1, v5, Lfa/o;->e:Landroidx/recyclerview/widget/RecyclerView;

    .line 611
    .line 612
    iget v0, v5, Lfa/o;->b:I

    .line 613
    .line 614
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroidx/recyclerview/widget/p1;

    .line 615
    .line 616
    .line 617
    move-result-object p1

    .line 618
    if-eqz p1, :cond_7

    .line 619
    .line 620
    iget-object p1, v5, Lfa/o;->e:Landroidx/recyclerview/widget/RecyclerView;

    .line 621
    .line 622
    iget v0, v5, Lfa/o;->b:I

    .line 623
    .line 624
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroidx/recyclerview/widget/p1;

    .line 625
    .line 626
    .line 627
    move-result-object p1

    .line 628
    iget-object p1, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 629
    .line 630
    if-eqz p1, :cond_7

    .line 631
    .line 632
    iget-object p1, v5, Lfa/o;->e:Landroidx/recyclerview/widget/RecyclerView;

    .line 633
    .line 634
    iget v0, v5, Lfa/o;->b:I

    .line 635
    .line 636
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroidx/recyclerview/widget/p1;

    .line 637
    .line 638
    .line 639
    move-result-object p1

    .line 640
    iget-object p1, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 641
    .line 642
    invoke-virtual {p1}, Landroid/view/View;->performClick()Z

    .line 643
    .line 644
    .line 645
    :cond_7
    return-void

    .line 646
    :pswitch_b
    check-cast v5, Lfa/b;

    .line 647
    .line 648
    iget v0, v5, Lfa/o;->b:I

    .line 649
    .line 650
    invoke-virtual {v5, v0}, Landroidx/recyclerview/widget/k0;->notifyItemChanged(I)V

    .line 651
    .line 652
    .line 653
    iget-object v0, v5, Lfa/o;->e:Landroidx/recyclerview/widget/RecyclerView;

    .line 654
    .line 655
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 656
    .line 657
    .line 658
    move-result v0

    .line 659
    iput v0, v5, Lfa/o;->d:I

    .line 660
    .line 661
    iget-object v0, v5, Lfa/o;->e:Landroidx/recyclerview/widget/RecyclerView;

    .line 662
    .line 663
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 664
    .line 665
    .line 666
    move-result p1

    .line 667
    iput p1, v5, Lfa/o;->b:I

    .line 668
    .line 669
    iget p1, v5, Lfa/o;->b:I

    .line 670
    .line 671
    invoke-virtual {v5, p1}, Landroidx/recyclerview/widget/k0;->notifyItemChanged(I)V

    .line 672
    .line 673
    .line 674
    return-void

    .line 675
    :pswitch_c
    check-cast v5, Lcom/google/android/material/textfield/q;

    .line 676
    .line 677
    iget-object p1, v5, Lcom/google/android/material/textfield/n;->a:Lcom/google/android/material/textfield/TextInputLayout;

    .line 678
    .line 679
    invoke-virtual {p1}, Lcom/google/android/material/textfield/TextInputLayout;->getEditText()Landroid/widget/EditText;

    .line 680
    .line 681
    .line 682
    move-result-object p1

    .line 683
    if-nez p1, :cond_8

    .line 684
    .line 685
    goto :goto_4

    .line 686
    :cond_8
    invoke-virtual {p1}, Landroid/widget/TextView;->getSelectionEnd()I

    .line 687
    .line 688
    .line 689
    move-result v0

    .line 690
    invoke-static {v5}, Lcom/google/android/material/textfield/q;->d(Lcom/google/android/material/textfield/q;)Z

    .line 691
    .line 692
    .line 693
    move-result v1

    .line 694
    if-eqz v1, :cond_9

    .line 695
    .line 696
    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 697
    .line 698
    .line 699
    goto :goto_3

    .line 700
    :cond_9
    invoke-static {}, Landroid/text/method/PasswordTransformationMethod;->getInstance()Landroid/text/method/PasswordTransformationMethod;

    .line 701
    .line 702
    .line 703
    move-result-object v1

    .line 704
    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 705
    .line 706
    .line 707
    :goto_3
    if-ltz v0, :cond_a

    .line 708
    .line 709
    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setSelection(I)V

    .line 710
    .line 711
    .line 712
    :cond_a
    iget-object p1, v5, Lcom/google/android/material/textfield/n;->a:Lcom/google/android/material/textfield/TextInputLayout;

    .line 713
    .line 714
    iget-object v0, p1, Lcom/google/android/material/textfield/TextInputLayout;->f0:Lcom/google/android/material/internal/CheckableImageButton;

    .line 715
    .line 716
    iget-object v1, p1, Lcom/google/android/material/textfield/TextInputLayout;->h0:Landroid/content/res/ColorStateList;

    .line 717
    .line 718
    invoke-static {p1, v0, v1}, Lu7/d;->x(Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;)V

    .line 719
    .line 720
    .line 721
    :goto_4
    return-void

    .line 722
    :pswitch_d
    check-cast v5, Lcom/google/android/material/textfield/m;

    .line 723
    .line 724
    iget-object p1, v5, Lcom/google/android/material/textfield/n;->a:Lcom/google/android/material/textfield/TextInputLayout;

    .line 725
    .line 726
    invoke-virtual {p1}, Lcom/google/android/material/textfield/TextInputLayout;->getEditText()Landroid/widget/EditText;

    .line 727
    .line 728
    .line 729
    move-result-object p1

    .line 730
    check-cast p1, Landroid/widget/AutoCompleteTextView;

    .line 731
    .line 732
    invoke-static {v5, p1}, Lcom/google/android/material/textfield/m;->d(Lcom/google/android/material/textfield/m;Landroid/widget/AutoCompleteTextView;)V

    .line 733
    .line 734
    .line 735
    return-void

    .line 736
    :pswitch_e
    check-cast v5, Lcom/google/android/material/textfield/e;

    .line 737
    .line 738
    iget-object p1, v5, Lcom/google/android/material/textfield/n;->a:Lcom/google/android/material/textfield/TextInputLayout;

    .line 739
    .line 740
    invoke-virtual {p1}, Lcom/google/android/material/textfield/TextInputLayout;->getEditText()Landroid/widget/EditText;

    .line 741
    .line 742
    .line 743
    move-result-object p1

    .line 744
    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    .line 745
    .line 746
    .line 747
    move-result-object p1

    .line 748
    if-eqz p1, :cond_b

    .line 749
    .line 750
    invoke-interface {p1}, Landroid/text/Editable;->clear()V

    .line 751
    .line 752
    .line 753
    :cond_b
    iget-object p1, v5, Lcom/google/android/material/textfield/n;->a:Lcom/google/android/material/textfield/TextInputLayout;

    .line 754
    .line 755
    iget-object v0, p1, Lcom/google/android/material/textfield/TextInputLayout;->f0:Lcom/google/android/material/internal/CheckableImageButton;

    .line 756
    .line 757
    iget-object v1, p1, Lcom/google/android/material/textfield/TextInputLayout;->h0:Landroid/content/res/ColorStateList;

    .line 758
    .line 759
    invoke-static {p1, v0, v1}, Lu7/d;->x(Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;)V

    .line 760
    .line 761
    .line 762
    return-void

    .line 763
    :pswitch_f
    check-cast p1, Lcom/google/android/material/navigation/d;

    .line 764
    .line 765
    invoke-virtual {p1}, Lcom/google/android/material/navigation/d;->getItemData()Lk/n;

    .line 766
    .line 767
    .line 768
    move-result-object p1

    .line 769
    check-cast v5, Lcom/google/android/material/navigation/f;

    .line 770
    .line 771
    iget-object v0, v5, Lcom/google/android/material/navigation/f;->B:Lk/l;

    .line 772
    .line 773
    iget-object v1, v5, Lcom/google/android/material/navigation/f;->A:Lcom/google/android/material/navigation/h;

    .line 774
    .line 775
    invoke-virtual {v0, p1, v1, v3}, Lk/l;->q(Landroid/view/MenuItem;Lk/y;I)Z

    .line 776
    .line 777
    .line 778
    move-result v0

    .line 779
    if-nez v0, :cond_c

    .line 780
    .line 781
    invoke-virtual {p1, v4}, Lk/n;->setChecked(Z)Landroid/view/MenuItem;

    .line 782
    .line 783
    .line 784
    :cond_c
    return-void

    .line 785
    :pswitch_10
    check-cast p1, Lcom/google/android/material/internal/NavigationMenuItemView;

    .line 786
    .line 787
    check-cast v5, Lcom/google/android/material/internal/r;

    .line 788
    .line 789
    iget-object v0, v5, Lcom/google/android/material/internal/r;->e:Lcom/google/android/material/internal/j;

    .line 790
    .line 791
    if-eqz v0, :cond_d

    .line 792
    .line 793
    iput-boolean v4, v0, Lcom/google/android/material/internal/j;->c:Z

    .line 794
    .line 795
    :cond_d
    invoke-virtual {p1}, Lcom/google/android/material/internal/NavigationMenuItemView;->getItemData()Lk/n;

    .line 796
    .line 797
    .line 798
    move-result-object p1

    .line 799
    iget-object v0, v5, Lcom/google/android/material/internal/r;->c:Lk/l;

    .line 800
    .line 801
    invoke-virtual {v0, p1, v5, v3}, Lk/l;->q(Landroid/view/MenuItem;Lk/y;I)Z

    .line 802
    .line 803
    .line 804
    move-result v0

    .line 805
    if-eqz p1, :cond_e

    .line 806
    .line 807
    invoke-virtual {p1}, Lk/n;->isCheckable()Z

    .line 808
    .line 809
    .line 810
    move-result v1

    .line 811
    if-eqz v1, :cond_e

    .line 812
    .line 813
    if-eqz v0, :cond_e

    .line 814
    .line 815
    iget-object v0, v5, Lcom/google/android/material/internal/r;->e:Lcom/google/android/material/internal/j;

    .line 816
    .line 817
    invoke-virtual {v0, p1}, Lcom/google/android/material/internal/j;->b(Lk/n;)V

    .line 818
    .line 819
    .line 820
    goto :goto_5

    .line 821
    :cond_e
    const/4 v4, 0x0

    .line 822
    :goto_5
    iget-object p1, v5, Lcom/google/android/material/internal/r;->e:Lcom/google/android/material/internal/j;

    .line 823
    .line 824
    if-eqz p1, :cond_f

    .line 825
    .line 826
    iput-boolean v3, p1, Lcom/google/android/material/internal/j;->c:Z

    .line 827
    .line 828
    :cond_f
    if-eqz v4, :cond_10

    .line 829
    .line 830
    invoke-virtual {v5, v3}, Lcom/google/android/material/internal/r;->j(Z)V

    .line 831
    .line 832
    .line 833
    :cond_10
    return-void

    .line 834
    :pswitch_11
    check-cast v5, Lcom/google/android/material/datepicker/r;

    .line 835
    .line 836
    iget p1, v5, Lcom/google/android/material/datepicker/r;->Y:I

    .line 837
    .line 838
    const/4 v0, 0x2

    .line 839
    if-ne p1, v0, :cond_11

    .line 840
    .line 841
    invoke-virtual {v5, v4}, Lcom/google/android/material/datepicker/r;->S(I)V

    .line 842
    .line 843
    .line 844
    goto :goto_6

    .line 845
    :cond_11
    if-ne p1, v4, :cond_12

    .line 846
    .line 847
    invoke-virtual {v5, v0}, Lcom/google/android/material/datepicker/r;->S(I)V

    .line 848
    .line 849
    .line 850
    :cond_12
    :goto_6
    return-void

    .line 851
    :pswitch_12
    check-cast v5, Landroidx/appcompat/widget/Toolbar;

    .line 852
    .line 853
    iget-object p1, v5, Landroidx/appcompat/widget/Toolbar;->M:Landroidx/appcompat/widget/q3;

    .line 854
    .line 855
    if-nez p1, :cond_13

    .line 856
    .line 857
    goto :goto_7

    .line 858
    :cond_13
    iget-object v2, p1, Landroidx/appcompat/widget/q3;->b:Lk/n;

    .line 859
    .line 860
    :goto_7
    if-eqz v2, :cond_14

    .line 861
    .line 862
    invoke-virtual {v2}, Lk/n;->collapseActionView()Z

    .line 863
    .line 864
    .line 865
    :cond_14
    return-void

    .line 866
    :pswitch_13
    check-cast v5, Lj/a;

    .line 867
    .line 868
    invoke-virtual {v5}, Lj/a;->a()V

    .line 869
    .line 870
    .line 871
    return-void

    .line 872
    :pswitch_14
    check-cast v5, Landroidx/appcompat/app/h;

    .line 873
    .line 874
    iget-object p1, v5, Landroidx/appcompat/app/h;->h:Landroid/widget/Button;

    .line 875
    .line 876
    iget-object p1, v5, Landroidx/appcompat/app/h;->x:Landroidx/appcompat/app/f;

    .line 877
    .line 878
    iget-object v0, v5, Landroidx/appcompat/app/h;->b:Landroidx/appcompat/app/j;

    .line 879
    .line 880
    invoke-virtual {p1, v4, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    .line 881
    .line 882
    .line 883
    move-result-object p1

    .line 884
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    .line 885
    .line 886
    .line 887
    return-void

    .line 888
    nop

    .line 889
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
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
        :pswitch_0
    .end packed-switch
.end method
