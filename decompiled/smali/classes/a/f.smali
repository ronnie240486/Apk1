.class public final La/f;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic a:I

.field public final synthetic b:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, La/f;->a:I

    .line 2
    .line 3
    iput-object p2, p0, La/f;->b:Ljava/lang/Object;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 15

    .line 1
    const-wide/16 v0, 0x0

    .line 2
    .line 3
    const v2, 0x7f120046

    .line 4
    .line 5
    .line 6
    const/4 v3, 0x0

    .line 7
    const/4 v4, 0x2

    .line 8
    const/4 v5, 0x1

    .line 9
    const/4 v6, 0x0

    .line 10
    iget v7, p0, La/f;->a:I

    .line 11
    .line 12
    packed-switch v7, :pswitch_data_0

    .line 13
    .line 14
    .line 15
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 16
    .line 17
    check-cast v0, Lq1/k0;

    .line 18
    .line 19
    invoke-virtual {v0}, Lq1/k0;->h()Z

    .line 20
    .line 21
    .line 22
    return-void

    .line 23
    :pswitch_0
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 24
    .line 25
    check-cast v0, Lcom/google/android/gms/cast/CastRemoteDisplayLocalService;

    .line 26
    .line 27
    iget-boolean v1, v0, Lcom/google/android/gms/cast/CastRemoteDisplayLocalService;->a:Z

    .line 28
    .line 29
    new-instance v2, Ljava/lang/StringBuilder;

    .line 30
    .line 31
    const-string v3, "onCreate after delay. The local service been started: "

    .line 32
    .line 33
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 34
    .line 35
    .line 36
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 37
    .line 38
    .line 39
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 40
    .line 41
    .line 42
    move-result-object v1

    .line 43
    invoke-virtual {v0, v1}, Lcom/google/android/gms/cast/CastRemoteDisplayLocalService;->a(Ljava/lang/String;)V

    .line 44
    .line 45
    .line 46
    iget-boolean v1, v0, Lcom/google/android/gms/cast/CastRemoteDisplayLocalService;->a:Z

    .line 47
    .line 48
    if-nez v1, :cond_0

    .line 49
    .line 50
    new-array v1, v4, [Ljava/lang/Object;

    .line 51
    .line 52
    aput-object v0, v1, v6

    .line 53
    .line 54
    const-string v2, "The local service has not been been started, stopping it"

    .line 55
    .line 56
    aput-object v2, v1, v5

    .line 57
    .line 58
    sget-object v2, Lcom/google/android/gms/cast/CastRemoteDisplayLocalService;->d:Lv4/b;

    .line 59
    .line 60
    iget-object v3, v2, Lv4/b;->a:Ljava/lang/String;

    .line 61
    .line 62
    const-string v4, "[Instance: %s] %s"

    .line 63
    .line 64
    invoke-virtual {v2, v4, v1}, Lv4/b;->d(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 65
    .line 66
    .line 67
    move-result-object v1

    .line 68
    invoke-static {v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 69
    .line 70
    .line 71
    invoke-virtual {v0}, Landroid/app/Service;->stopSelf()V

    .line 72
    .line 73
    .line 74
    :cond_0
    return-void

    .line 75
    :pswitch_1
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 76
    .line 77
    check-cast v0, La0/f;

    .line 78
    .line 79
    iget-object v0, v0, La0/f;->e:Ljava/lang/Object;

    .line 80
    .line 81
    check-cast v0, Lorg/bitspark/android/utils/b;

    .line 82
    .line 83
    iget-object v0, v0, Lorg/bitspark/android/utils/b;->e:Lcom/google/android/gms/internal/cast/o;

    .line 84
    .line 85
    if-eqz v0, :cond_1

    .line 86
    .line 87
    iget-boolean v1, v0, Lcom/google/android/gms/internal/cast/o;->f:Z

    .line 88
    .line 89
    if-eqz v1, :cond_1

    .line 90
    .line 91
    iget-object v1, v0, Lcom/google/android/gms/internal/cast/o;->b:Lorg/bitspark/android/Spark;

    .line 92
    .line 93
    if-eqz v1, :cond_1

    .line 94
    .line 95
    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    .line 96
    .line 97
    .line 98
    move-result-object v1

    .line 99
    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    .line 100
    .line 101
    .line 102
    move-result-object v1

    .line 103
    check-cast v1, Landroid/view/ViewGroup;

    .line 104
    .line 105
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 106
    .line 107
    .line 108
    invoke-virtual {v0}, Lcom/google/android/gms/internal/cast/o;->a()V

    .line 109
    .line 110
    .line 111
    :cond_1
    return-void

    .line 112
    :pswitch_2
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 113
    .line 114
    check-cast v0, Lm1/b;

    .line 115
    .line 116
    iget-object v1, v0, Lm1/b;->f:Landroidx/media/MediaBrowserServiceCompat;

    .line 117
    .line 118
    iget-object v1, v1, Landroidx/media/MediaBrowserServiceCompat;->d:Lp/e;

    .line 119
    .line 120
    iget-object v0, v0, Lm1/b;->d:Lm1/p;

    .line 121
    .line 122
    iget-object v0, v0, Lm1/p;->a:Landroid/os/Messenger;

    .line 123
    .line 124
    invoke-virtual {v0}, Landroid/os/Messenger;->getBinder()Landroid/os/IBinder;

    .line 125
    .line 126
    .line 127
    move-result-object v0

    .line 128
    invoke-virtual {v1, v0}, Lp/k;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    .line 130
    .line 131
    return-void

    .line 132
    :pswitch_3
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 133
    .line 134
    check-cast v0, Lka/l0;

    .line 135
    .line 136
    iget-object v1, v0, Lka/l0;->d:Lka/m0;

    .line 137
    .line 138
    invoke-virtual {v1}, Landroidx/fragment/app/s;->j()Landroid/content/Context;

    .line 139
    .line 140
    .line 141
    move-result-object v1

    .line 142
    iget-object v0, v0, Lka/l0;->d:Lka/m0;

    .line 143
    .line 144
    invoke-virtual {v0}, Landroidx/fragment/app/s;->m()Landroid/content/res/Resources;

    .line 145
    .line 146
    .line 147
    move-result-object v0

    .line 148
    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 149
    .line 150
    .line 151
    move-result-object v0

    .line 152
    invoke-static {v1, v6, v0}, Lba/d;->a(Landroid/content/Context;ILjava/lang/String;)Lba/d;

    .line 153
    .line 154
    .line 155
    move-result-object v0

    .line 156
    invoke-virtual {v0}, Lba/d;->show()V

    .line 157
    .line 158
    .line 159
    return-void

    .line 160
    :pswitch_4
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 161
    .line 162
    check-cast v0, Lka/j0;

    .line 163
    .line 164
    iget-object v0, v0, Lka/j0;->b:Lka/m0;

    .line 165
    .line 166
    iget-object v0, v0, Lka/m0;->g0:Lorg/bitspark/android/view/CircularProgressBar;

    .line 167
    .line 168
    const/16 v1, 0x8

    .line 169
    .line 170
    invoke-virtual {v0, v1}, Lorg/bitspark/android/view/CircularProgressBar;->setVisibility(I)V

    .line 171
    .line 172
    .line 173
    return-void

    .line 174
    :pswitch_5
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 175
    .line 176
    check-cast v0, Landroidx/appcompat/widget/r0;

    .line 177
    .line 178
    iget-object v1, v0, Landroidx/appcompat/widget/r0;->d:Ljava/lang/Object;

    .line 179
    .line 180
    check-cast v1, Lka/i0;

    .line 181
    .line 182
    invoke-virtual {v1}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 183
    .line 184
    .line 185
    move-result-object v1

    .line 186
    invoke-virtual {v1}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    .line 187
    .line 188
    .line 189
    move-result-object v1

    .line 190
    iget-object v2, v0, Landroidx/appcompat/widget/r0;->c:Ljava/lang/Object;

    .line 191
    .line 192
    check-cast v2, Ljava/lang/String;

    .line 193
    .line 194
    invoke-virtual {v1, v2}, Landroidx/fragment/app/j0;->z(Ljava/lang/String;)Landroidx/fragment/app/s;

    .line 195
    .line 196
    .line 197
    move-result-object v1

    .line 198
    check-cast v1, Lsa/l;

    .line 199
    .line 200
    if-eqz v1, :cond_2

    .line 201
    .line 202
    iget-object v1, v1, Lsa/l;->U:Landroidx/recyclerview/widget/RecyclerView;

    .line 203
    .line 204
    if-eqz v1, :cond_2

    .line 205
    .line 206
    iget v2, v0, Landroidx/appcompat/widget/r0;->b:I

    .line 207
    .line 208
    invoke-static {v1, v2}, Lo9/d;->z(Landroidx/recyclerview/widget/RecyclerView;I)V

    .line 209
    .line 210
    .line 211
    :cond_2
    const-string v1, "/k9t2V+CmMbEZnv8XZucwdw=\n"

    .line 212
    .line 213
    const-string v2, "qCAJnTr2+a8=\n"

    .line 214
    .line 215
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 216
    .line 217
    .line 218
    move-result-object v1

    .line 219
    new-instance v2, Ljava/lang/StringBuilder;

    .line 220
    .line 221
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 222
    .line 223
    .line 224
    const-string v3, "3sXlnlHYndqhpOzex1k=\n"

    .line 225
    .line 226
    const-string v4, "O0NoeP15dVs=\n"

    .line 227
    .line 228
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 229
    .line 230
    .line 231
    move-result-object v3

    .line 232
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 233
    .line 234
    .line 235
    iget-object v0, v0, Landroidx/appcompat/widget/r0;->d:Ljava/lang/Object;

    .line 236
    .line 237
    check-cast v0, Lka/i0;

    .line 238
    .line 239
    invoke-virtual {v0}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 240
    .line 241
    .line 242
    move-result-object v0

    .line 243
    invoke-virtual {v0}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    .line 244
    .line 245
    .line 246
    move-result-object v0

    .line 247
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 248
    .line 249
    .line 250
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 251
    .line 252
    .line 253
    move-result-object v0

    .line 254
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 255
    .line 256
    invoke-static {v1, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    .line 258
    .line 259
    return-void

    .line 260
    :pswitch_6
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 261
    .line 262
    check-cast v0, Lka/i0;

    .line 263
    .line 264
    invoke-virtual {v0}, Lka/i0;->Q()V

    .line 265
    .line 266
    .line 267
    return-void

    .line 268
    :pswitch_7
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 269
    .line 270
    check-cast v0, Landroid/widget/TextView;

    .line 271
    .line 272
    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    .line 273
    .line 274
    .line 275
    move-result v1

    .line 276
    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    .line 277
    .line 278
    .line 279
    move-result v2

    .line 280
    const-string v3, "GSNYn2IyHtA8KVuO\n"

    .line 281
    .line 282
    const-string v5, "UUw1+iRAf7c=\n"

    .line 283
    .line 284
    invoke-static {v3, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 285
    .line 286
    .line 287
    const-string v3, "lrTj0mAMzKaXhf7kbQeCsZC/rbA=\n"

    .line 288
    .line 289
    const-string v5, "5dGXkAFiosM=\n"

    .line 290
    .line 291
    invoke-static {v3, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 292
    .line 293
    .line 294
    const-string v3, "+CyZ0wepoQ==\n"

    .line 295
    .line 296
    const-string v5, "xRGk7jqUnAo=\n"

    .line 297
    .line 298
    invoke-static {v3, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 299
    .line 300
    .line 301
    if-eqz v1, :cond_4

    .line 302
    .line 303
    if-nez v2, :cond_3

    .line 304
    .line 305
    goto :goto_0

    .line 306
    :cond_3
    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 307
    .line 308
    .line 309
    sget-object v2, Lorg/bitspark/android/SpkApplication;->c:Lorg/bitspark/android/SpkApplication;

    .line 310
    .line 311
    invoke-virtual {v2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    .line 312
    .line 313
    .line 314
    move-result-object v2

    .line 315
    const v3, 0x7f0600c9

    .line 316
    .line 317
    .line 318
    invoke-static {v2, v3}, Lu7/d;->i(Landroid/content/Context;I)I

    .line 319
    .line 320
    .line 321
    move-result v2

    .line 322
    sget-object v3, Lorg/bitspark/android/SpkApplication;->c:Lorg/bitspark/android/SpkApplication;

    .line 323
    .line 324
    invoke-virtual {v3}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    .line 325
    .line 326
    .line 327
    move-result-object v3

    .line 328
    const v5, 0x7f0600c8

    .line 329
    .line 330
    .line 331
    invoke-static {v3, v5}, Lu7/d;->i(Landroid/content/Context;I)I

    .line 332
    .line 333
    .line 334
    move-result v3

    .line 335
    new-instance v13, Landroid/graphics/LinearGradient;

    .line 336
    .line 337
    int-to-float v8, v1

    .line 338
    filled-new-array {v2, v3}, [I

    .line 339
    .line 340
    .line 341
    move-result-object v10

    .line 342
    new-array v11, v4, [F

    .line 343
    .line 344
    fill-array-data v11, :array_0

    .line 345
    .line 346
    .line 347
    sget-object v12, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    .line 348
    .line 349
    const/4 v7, 0x0

    .line 350
    const/4 v9, 0x0

    .line 351
    const/4 v6, 0x0

    .line 352
    move-object v5, v13

    .line 353
    invoke-direct/range {v5 .. v12}, Landroid/graphics/LinearGradient;-><init>(FFFF[I[FLandroid/graphics/Shader$TileMode;)V

    .line 354
    .line 355
    .line 356
    invoke-virtual {v0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    .line 357
    .line 358
    .line 359
    move-result-object v1

    .line 360
    invoke-virtual {v1, v13}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 361
    .line 362
    .line 363
    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 364
    .line 365
    .line 366
    :cond_4
    :goto_0
    return-void

    .line 367
    :pswitch_8
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 368
    .line 369
    check-cast v0, Lka/c;

    .line 370
    .line 371
    iget-object v1, v0, Lka/c;->b:Lka/e;

    .line 372
    .line 373
    invoke-virtual {v1}, Landroidx/fragment/app/s;->j()Landroid/content/Context;

    .line 374
    .line 375
    .line 376
    move-result-object v1

    .line 377
    iget-object v0, v0, Lka/c;->b:Lka/e;

    .line 378
    .line 379
    invoke-virtual {v0}, Landroidx/fragment/app/s;->m()Landroid/content/res/Resources;

    .line 380
    .line 381
    .line 382
    move-result-object v0

    .line 383
    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 384
    .line 385
    .line 386
    move-result-object v0

    .line 387
    invoke-static {v1, v6, v0}, Lba/d;->a(Landroid/content/Context;ILjava/lang/String;)Lba/d;

    .line 388
    .line 389
    .line 390
    move-result-object v0

    .line 391
    invoke-virtual {v0}, Lba/d;->show()V

    .line 392
    .line 393
    .line 394
    return-void

    .line 395
    :pswitch_9
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 396
    .line 397
    check-cast v0, Landroidx/leanback/widget/picker/DatePicker;

    .line 398
    .line 399
    iget v1, v0, Landroidx/leanback/widget/picker/DatePicker;->u:I

    .line 400
    .line 401
    iget v2, v0, Landroidx/leanback/widget/picker/DatePicker;->t:I

    .line 402
    .line 403
    iget v7, v0, Landroidx/leanback/widget/picker/DatePicker;->v:I

    .line 404
    .line 405
    filled-new-array {v1, v2, v7}, [I

    .line 406
    .line 407
    .line 408
    move-result-object v1

    .line 409
    const/4 v2, 0x1

    .line 410
    const/4 v7, 0x1

    .line 411
    :goto_1
    if-ltz v4, :cond_e

    .line 412
    .line 413
    aget v8, v1, v4

    .line 414
    .line 415
    if-gez v8, :cond_5

    .line 416
    .line 417
    goto/16 :goto_a

    .line 418
    .line 419
    :cond_5
    sget-object v9, Landroidx/leanback/widget/picker/DatePicker;->C:[I

    .line 420
    .line 421
    aget v9, v9, v4

    .line 422
    .line 423
    iget-object v10, v0, Landroidx/leanback/widget/picker/Picker;->c:Ljava/util/ArrayList;

    .line 424
    .line 425
    if-nez v10, :cond_6

    .line 426
    .line 427
    move-object v8, v3

    .line 428
    goto :goto_2

    .line 429
    :cond_6
    invoke-virtual {v10, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 430
    .line 431
    .line 432
    move-result-object v8

    .line 433
    check-cast v8, Li1/d;

    .line 434
    .line 435
    :goto_2
    if-eqz v2, :cond_8

    .line 436
    .line 437
    iget-object v10, v0, Landroidx/leanback/widget/picker/DatePicker;->y:Ljava/util/Calendar;

    .line 438
    .line 439
    invoke-virtual {v10, v9}, Ljava/util/Calendar;->get(I)I

    .line 440
    .line 441
    .line 442
    move-result v10

    .line 443
    iget v11, v8, Li1/d;->b:I

    .line 444
    .line 445
    if-eq v10, v11, :cond_7

    .line 446
    .line 447
    iput v10, v8, Li1/d;->b:I

    .line 448
    .line 449
    :goto_3
    const/4 v10, 0x1

    .line 450
    goto :goto_4

    .line 451
    :cond_7
    const/4 v10, 0x0

    .line 452
    goto :goto_4

    .line 453
    :cond_8
    iget-object v10, v0, Landroidx/leanback/widget/picker/DatePicker;->A:Ljava/util/Calendar;

    .line 454
    .line 455
    invoke-virtual {v10, v9}, Ljava/util/Calendar;->getActualMinimum(I)I

    .line 456
    .line 457
    .line 458
    move-result v10

    .line 459
    iget v11, v8, Li1/d;->b:I

    .line 460
    .line 461
    if-eq v10, v11, :cond_7

    .line 462
    .line 463
    iput v10, v8, Li1/d;->b:I

    .line 464
    .line 465
    goto :goto_3

    .line 466
    :goto_4
    if-eqz v7, :cond_a

    .line 467
    .line 468
    iget-object v11, v0, Landroidx/leanback/widget/picker/DatePicker;->z:Ljava/util/Calendar;

    .line 469
    .line 470
    invoke-virtual {v11, v9}, Ljava/util/Calendar;->get(I)I

    .line 471
    .line 472
    .line 473
    move-result v11

    .line 474
    iget v12, v8, Li1/d;->c:I

    .line 475
    .line 476
    if-eq v11, v12, :cond_9

    .line 477
    .line 478
    iput v11, v8, Li1/d;->c:I

    .line 479
    .line 480
    :goto_5
    const/4 v11, 0x1

    .line 481
    goto :goto_6

    .line 482
    :cond_9
    const/4 v11, 0x0

    .line 483
    :goto_6
    or-int/2addr v10, v11

    .line 484
    goto :goto_7

    .line 485
    :cond_a
    iget-object v11, v0, Landroidx/leanback/widget/picker/DatePicker;->A:Ljava/util/Calendar;

    .line 486
    .line 487
    invoke-virtual {v11, v9}, Ljava/util/Calendar;->getActualMaximum(I)I

    .line 488
    .line 489
    .line 490
    move-result v11

    .line 491
    iget v12, v8, Li1/d;->c:I

    .line 492
    .line 493
    if-eq v11, v12, :cond_9

    .line 494
    .line 495
    iput v11, v8, Li1/d;->c:I

    .line 496
    .line 497
    goto :goto_5

    .line 498
    :goto_7
    iget-object v11, v0, Landroidx/leanback/widget/picker/DatePicker;->A:Ljava/util/Calendar;

    .line 499
    .line 500
    invoke-virtual {v11, v9}, Ljava/util/Calendar;->get(I)I

    .line 501
    .line 502
    .line 503
    move-result v11

    .line 504
    iget-object v12, v0, Landroidx/leanback/widget/picker/DatePicker;->y:Ljava/util/Calendar;

    .line 505
    .line 506
    invoke-virtual {v12, v9}, Ljava/util/Calendar;->get(I)I

    .line 507
    .line 508
    .line 509
    move-result v12

    .line 510
    if-ne v11, v12, :cond_b

    .line 511
    .line 512
    const/4 v11, 0x1

    .line 513
    goto :goto_8

    .line 514
    :cond_b
    const/4 v11, 0x0

    .line 515
    :goto_8
    and-int/2addr v2, v11

    .line 516
    iget-object v11, v0, Landroidx/leanback/widget/picker/DatePicker;->A:Ljava/util/Calendar;

    .line 517
    .line 518
    invoke-virtual {v11, v9}, Ljava/util/Calendar;->get(I)I

    .line 519
    .line 520
    .line 521
    move-result v11

    .line 522
    iget-object v12, v0, Landroidx/leanback/widget/picker/DatePicker;->z:Ljava/util/Calendar;

    .line 523
    .line 524
    invoke-virtual {v12, v9}, Ljava/util/Calendar;->get(I)I

    .line 525
    .line 526
    .line 527
    move-result v12

    .line 528
    if-ne v11, v12, :cond_c

    .line 529
    .line 530
    const/4 v11, 0x1

    .line 531
    goto :goto_9

    .line 532
    :cond_c
    const/4 v11, 0x0

    .line 533
    :goto_9
    and-int/2addr v7, v11

    .line 534
    if-eqz v10, :cond_d

    .line 535
    .line 536
    aget v10, v1, v4

    .line 537
    .line 538
    invoke-virtual {v0, v10, v8}, Landroidx/leanback/widget/picker/Picker;->b(ILi1/d;)V

    .line 539
    .line 540
    .line 541
    :cond_d
    aget v8, v1, v4

    .line 542
    .line 543
    iget-object v10, v0, Landroidx/leanback/widget/picker/DatePicker;->A:Ljava/util/Calendar;

    .line 544
    .line 545
    invoke-virtual {v10, v9}, Ljava/util/Calendar;->get(I)I

    .line 546
    .line 547
    .line 548
    move-result v9

    .line 549
    invoke-virtual {v0, v8, v9}, Landroidx/leanback/widget/picker/Picker;->c(II)V

    .line 550
    .line 551
    .line 552
    :goto_a
    add-int/lit8 v4, v4, -0x1

    .line 553
    .line 554
    goto/16 :goto_1

    .line 555
    .line 556
    :cond_e
    return-void

    .line 557
    :pswitch_a
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 558
    .line 559
    check-cast v0, Lga/a;

    .line 560
    .line 561
    iget-object v0, v0, Lga/a;->b:Lga/b;

    .line 562
    .line 563
    iget-object v0, v0, Lga/b;->a:Landroid/widget/PopupWindow;

    .line 564
    .line 565
    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 566
    .line 567
    .line 568
    return-void

    .line 569
    :pswitch_b
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 570
    .line 571
    check-cast v0, Lg/e;

    .line 572
    .line 573
    invoke-virtual {v0, v5}, Lg/g;->a(Z)V

    .line 574
    .line 575
    .line 576
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->invalidateSelf()V

    .line 577
    .line 578
    .line 579
    return-void

    .line 580
    :pswitch_c
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 581
    .line 582
    check-cast v0, Landroidx/core/app/h;

    .line 583
    .line 584
    iget-object v0, v0, Landroidx/core/app/h;->b:Ljava/lang/Object;

    .line 585
    .line 586
    check-cast v0, Lfa/x0;

    .line 587
    .line 588
    iget-object v1, v0, Lfa/x0;->j:Ljava/util/ArrayList;

    .line 589
    .line 590
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 591
    .line 592
    .line 593
    move-result v1

    .line 594
    sub-int/2addr v1, v5

    .line 595
    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/k0;->notifyItemInserted(I)V

    .line 596
    .line 597
    .line 598
    return-void

    .line 599
    :pswitch_d
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 600
    .line 601
    check-cast v0, Lea/k;

    .line 602
    .line 603
    iget-object v0, v0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 604
    .line 605
    iget-object v1, v0, Lorg/bitspark/android/Spark;->A0:Landroidx/leanback/widget/HorizontalGridView;

    .line 606
    .line 607
    iget-object v0, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 608
    .line 609
    invoke-virtual {v0, v6}, Lta/a;->d(I)I

    .line 610
    .line 611
    .line 612
    move-result v0

    .line 613
    invoke-virtual {v1, v0}, Landroidx/leanback/widget/j;->smoothScrollToPosition(I)V

    .line 614
    .line 615
    .line 616
    return-void

    .line 617
    :pswitch_e
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 618
    .line 619
    check-cast v0, Lea/x;

    .line 620
    .line 621
    iget-object v0, v0, Lea/x;->b:Lorg/bitspark/android/Spark;

    .line 622
    .line 623
    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->Z()V

    .line 624
    .line 625
    .line 626
    return-void

    .line 627
    :pswitch_f
    iget-object v2, p0, La/f;->b:Ljava/lang/Object;

    .line 628
    .line 629
    check-cast v2, Lda/b;

    .line 630
    .line 631
    iget-object v3, v2, Lda/b;->f:Ljava/io/File;

    .line 632
    .line 633
    invoke-virtual {v3}, Ljava/io/File;->listFiles()[Ljava/io/File;

    .line 634
    .line 635
    .line 636
    move-result-object v3

    .line 637
    if-eqz v3, :cond_11

    .line 638
    .line 639
    array-length v4, v3

    .line 640
    const/4 v7, 0x0

    .line 641
    const/4 v8, 0x0

    .line 642
    :goto_b
    if-ge v6, v4, :cond_10

    .line 643
    .line 644
    aget-object v9, v3, v6

    .line 645
    .line 646
    int-to-long v10, v7

    .line 647
    if-nez v9, :cond_f

    .line 648
    .line 649
    move-wide v12, v0

    .line 650
    goto :goto_c

    .line 651
    :cond_f
    invoke-virtual {v9}, Ljava/io/File;->length()J

    .line 652
    .line 653
    .line 654
    move-result-wide v12

    .line 655
    :goto_c
    add-long/2addr v12, v10

    .line 656
    long-to-int v7, v12

    .line 657
    add-int/2addr v8, v5

    .line 658
    invoke-virtual {v9}, Ljava/io/File;->lastModified()J

    .line 659
    .line 660
    .line 661
    move-result-wide v10

    .line 662
    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 663
    .line 664
    .line 665
    move-result-object v10

    .line 666
    iget-object v11, v2, Lda/b;->e:Ljava/util/Map;

    .line 667
    .line 668
    invoke-interface {v11, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 669
    .line 670
    .line 671
    add-int/2addr v6, v5

    .line 672
    goto :goto_b

    .line 673
    :cond_10
    iget-object v0, v2, Lda/b;->a:Ljava/util/concurrent/atomic/AtomicLong;

    .line 674
    .line 675
    int-to-long v3, v7

    .line 676
    invoke-virtual {v0, v3, v4}, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V

    .line 677
    .line 678
    .line 679
    iget-object v0, v2, Lda/b;->b:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 680
    .line 681
    invoke-virtual {v0, v8}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 682
    .line 683
    .line 684
    :cond_11
    return-void

    .line 685
    :pswitch_10
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 686
    .line 687
    check-cast v0, Lcom/tencent/bugly/proguard/au;

    .line 688
    .line 689
    invoke-static {v0}, Lcom/tencent/bugly/proguard/au;->a(Lcom/tencent/bugly/proguard/au;)V

    .line 690
    .line 691
    .line 692
    return-void

    .line 693
    :pswitch_11
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 694
    .line 695
    check-cast v0, Ljava/util/List;

    .line 696
    .line 697
    invoke-static {v0}, Lcom/tencent/bugly/proguard/ag;->c(Ljava/util/List;)V

    .line 698
    .line 699
    .line 700
    return-void

    .line 701
    :pswitch_12
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 702
    .line 703
    check-cast v0, Landroid/view/View;

    .line 704
    .line 705
    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 706
    .line 707
    .line 708
    move-result-object v1

    .line 709
    const-string v2, "input_method"

    .line 710
    .line 711
    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 712
    .line 713
    .line 714
    move-result-object v1

    .line 715
    check-cast v1, Landroid/view/inputmethod/InputMethodManager;

    .line 716
    .line 717
    invoke-virtual {v1, v0, v5}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 718
    .line 719
    .line 720
    return-void

    .line 721
    :pswitch_13
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 722
    .line 723
    check-cast v0, Lcom/bumptech/glide/o;

    .line 724
    .line 725
    iget-object v1, v0, Lcom/bumptech/glide/o;->c:Lk3/g;

    .line 726
    .line 727
    invoke-interface {v1, v0}, Lk3/g;->h(Lk3/i;)V

    .line 728
    .line 729
    .line 730
    return-void

    .line 731
    :pswitch_14
    sget-object v0, Lcom/tencent/mars/xlog/Log;->toastSupportContext:Landroid/content/Context;

    .line 732
    .line 733
    iget-object v1, p0, La/f;->b:Ljava/lang/Object;

    .line 734
    .line 735
    check-cast v1, Ljava/lang/String;

    .line 736
    .line 737
    invoke-static {v0, v1, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 738
    .line 739
    .line 740
    move-result-object v0

    .line 741
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 742
    .line 743
    .line 744
    return-void

    .line 745
    :pswitch_15
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 746
    .line 747
    check-cast v0, Lc6/c;

    .line 748
    .line 749
    iput-boolean v6, v0, Lc6/c;->b:Z

    .line 750
    .line 751
    iget-object v1, v0, Lc6/c;->d:Ljava/lang/Object;

    .line 752
    .line 753
    check-cast v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;

    .line 754
    .line 755
    iget-object v2, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->K:Lv0/d;

    .line 756
    .line 757
    if-eqz v2, :cond_12

    .line 758
    .line 759
    invoke-virtual {v2}, Lv0/d;->g()Z

    .line 760
    .line 761
    .line 762
    move-result v2

    .line 763
    if-eqz v2, :cond_12

    .line 764
    .line 765
    iget v1, v0, Lc6/c;->a:I

    .line 766
    .line 767
    invoke-virtual {v0, v1}, Lc6/c;->d(I)V

    .line 768
    .line 769
    .line 770
    goto :goto_d

    .line 771
    :cond_12
    iget v2, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->J:I

    .line 772
    .line 773
    if-ne v2, v4, :cond_13

    .line 774
    .line 775
    iget v0, v0, Lc6/c;->a:I

    .line 776
    .line 777
    invoke-virtual {v1, v0}, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->B(I)V

    .line 778
    .line 779
    .line 780
    :cond_13
    :goto_d
    return-void

    .line 781
    :pswitch_16
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 782
    .line 783
    check-cast v0, Landroidx/viewpager/widget/ViewPager;

    .line 784
    .line 785
    invoke-virtual {v0, v6}, Landroidx/viewpager/widget/ViewPager;->setScrollState(I)V

    .line 786
    .line 787
    .line 788
    invoke-virtual {v0}, Landroidx/viewpager/widget/ViewPager;->p()V

    .line 789
    .line 790
    .line 791
    return-void

    .line 792
    :pswitch_17
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 793
    .line 794
    check-cast v0, Landroidx/lifecycle/d0;

    .line 795
    .line 796
    iget-object v2, v0, Landroidx/lifecycle/d0;->a:Ljava/lang/Object;

    .line 797
    .line 798
    monitor-enter v2

    .line 799
    :try_start_0
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 800
    .line 801
    check-cast v0, Landroidx/lifecycle/d0;

    .line 802
    .line 803
    iget-object v0, v0, Landroidx/lifecycle/d0;->f:Ljava/lang/Object;

    .line 804
    .line 805
    iget-object v1, p0, La/f;->b:Ljava/lang/Object;

    .line 806
    .line 807
    check-cast v1, Landroidx/lifecycle/d0;

    .line 808
    .line 809
    sget-object v3, Landroidx/lifecycle/d0;->k:Ljava/lang/Object;

    .line 810
    .line 811
    iput-object v3, v1, Landroidx/lifecycle/d0;->f:Ljava/lang/Object;

    .line 812
    .line 813
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 814
    iget-object v1, p0, La/f;->b:Ljava/lang/Object;

    .line 815
    .line 816
    check-cast v1, Landroidx/lifecycle/d0;

    .line 817
    .line 818
    invoke-virtual {v1, v0}, Landroidx/lifecycle/d0;->j(Ljava/lang/Object;)V

    .line 819
    .line 820
    .line 821
    return-void

    .line 822
    :catchall_0
    move-exception v0

    .line 823
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 824
    throw v0

    .line 825
    :pswitch_18
    iget-object v2, p0, La/f;->b:Ljava/lang/Object;

    .line 826
    .line 827
    check-cast v2, Landroidx/core/widget/h;

    .line 828
    .line 829
    iget-boolean v3, v2, Landroidx/core/widget/h;->o:Z

    .line 830
    .line 831
    if-nez v3, :cond_14

    .line 832
    .line 833
    goto/16 :goto_f

    .line 834
    .line 835
    :cond_14
    iget-boolean v3, v2, Landroidx/core/widget/h;->m:Z

    .line 836
    .line 837
    iget-object v4, v2, Landroidx/core/widget/h;->a:Landroidx/core/widget/a;

    .line 838
    .line 839
    if-eqz v3, :cond_15

    .line 840
    .line 841
    iput-boolean v6, v2, Landroidx/core/widget/h;->m:Z

    .line 842
    .line 843
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    .line 844
    .line 845
    .line 846
    move-result-wide v7

    .line 847
    iput-wide v7, v4, Landroidx/core/widget/a;->e:J

    .line 848
    .line 849
    const-wide/16 v9, -0x1

    .line 850
    .line 851
    iput-wide v9, v4, Landroidx/core/widget/a;->g:J

    .line 852
    .line 853
    iput-wide v7, v4, Landroidx/core/widget/a;->f:J

    .line 854
    .line 855
    const/high16 v3, 0x3f000000    # 0.5f

    .line 856
    .line 857
    iput v3, v4, Landroidx/core/widget/a;->h:F

    .line 858
    .line 859
    :cond_15
    iget-wide v7, v4, Landroidx/core/widget/a;->g:J

    .line 860
    .line 861
    cmp-long v3, v7, v0

    .line 862
    .line 863
    if-lez v3, :cond_16

    .line 864
    .line 865
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    .line 866
    .line 867
    .line 868
    move-result-wide v7

    .line 869
    iget-wide v9, v4, Landroidx/core/widget/a;->g:J

    .line 870
    .line 871
    iget v3, v4, Landroidx/core/widget/a;->i:I

    .line 872
    .line 873
    int-to-long v11, v3

    .line 874
    add-long/2addr v9, v11

    .line 875
    cmp-long v3, v7, v9

    .line 876
    .line 877
    if-lez v3, :cond_16

    .line 878
    .line 879
    goto :goto_e

    .line 880
    :cond_16
    invoke-virtual {v2}, Landroidx/core/widget/h;->e()Z

    .line 881
    .line 882
    .line 883
    move-result v3

    .line 884
    if-nez v3, :cond_17

    .line 885
    .line 886
    :goto_e
    iput-boolean v6, v2, Landroidx/core/widget/h;->o:Z

    .line 887
    .line 888
    goto :goto_f

    .line 889
    :cond_17
    iget-boolean v3, v2, Landroidx/core/widget/h;->n:Z

    .line 890
    .line 891
    iget-object v5, v2, Landroidx/core/widget/h;->c:Landroid/widget/ListView;

    .line 892
    .line 893
    if-eqz v3, :cond_18

    .line 894
    .line 895
    iput-boolean v6, v2, Landroidx/core/widget/h;->n:Z

    .line 896
    .line 897
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    .line 898
    .line 899
    .line 900
    move-result-wide v9

    .line 901
    const/4 v13, 0x0

    .line 902
    const/4 v14, 0x0

    .line 903
    const/4 v11, 0x3

    .line 904
    const/4 v12, 0x0

    .line 905
    move-wide v7, v9

    .line 906
    invoke-static/range {v7 .. v14}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    .line 907
    .line 908
    .line 909
    move-result-object v3

    .line 910
    invoke-virtual {v5, v3}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 911
    .line 912
    .line 913
    invoke-virtual {v3}, Landroid/view/MotionEvent;->recycle()V

    .line 914
    .line 915
    .line 916
    :cond_18
    iget-wide v6, v4, Landroidx/core/widget/a;->f:J

    .line 917
    .line 918
    cmp-long v3, v6, v0

    .line 919
    .line 920
    if-eqz v3, :cond_19

    .line 921
    .line 922
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    .line 923
    .line 924
    .line 925
    move-result-wide v0

    .line 926
    invoke-virtual {v4, v0, v1}, Landroidx/core/widget/a;->a(J)F

    .line 927
    .line 928
    .line 929
    move-result v3

    .line 930
    const/high16 v6, -0x3f800000    # -4.0f

    .line 931
    .line 932
    mul-float v6, v6, v3

    .line 933
    .line 934
    mul-float v6, v6, v3

    .line 935
    .line 936
    const/high16 v7, 0x40800000    # 4.0f

    .line 937
    .line 938
    mul-float v3, v3, v7

    .line 939
    .line 940
    add-float/2addr v3, v6

    .line 941
    iget-wide v6, v4, Landroidx/core/widget/a;->f:J

    .line 942
    .line 943
    sub-long v6, v0, v6

    .line 944
    .line 945
    iput-wide v0, v4, Landroidx/core/widget/a;->f:J

    .line 946
    .line 947
    long-to-float v0, v6

    .line 948
    mul-float v0, v0, v3

    .line 949
    .line 950
    iget v1, v4, Landroidx/core/widget/a;->d:F

    .line 951
    .line 952
    mul-float v0, v0, v1

    .line 953
    .line 954
    float-to-int v0, v0

    .line 955
    iget-object v1, v2, Landroidx/core/widget/h;->q:Landroidx/appcompat/widget/s1;

    .line 956
    .line 957
    invoke-virtual {v1, v0}, Landroid/widget/AbsListView;->scrollListBy(I)V

    .line 958
    .line 959
    .line 960
    sget-object v0, Ln0/s0;->a:Ljava/util/WeakHashMap;

    .line 961
    .line 962
    invoke-virtual {v5, p0}, Landroid/view/View;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 963
    .line 964
    .line 965
    :goto_f
    return-void

    .line 966
    :cond_19
    new-instance v0, Ljava/lang/RuntimeException;

    .line 967
    .line 968
    const-string v1, "Cannot compute scroll delta before calling start()"

    .line 969
    .line 970
    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 971
    .line 972
    .line 973
    throw v0

    .line 974
    :pswitch_19
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 975
    .line 976
    check-cast v0, Landroidx/appcompat/widget/Toolbar;

    .line 977
    .line 978
    invoke-virtual {v0}, Landroidx/appcompat/widget/Toolbar;->v()Z

    .line 979
    .line 980
    .line 981
    return-void

    .line 982
    :pswitch_1a
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 983
    .line 984
    check-cast v0, Landroidx/appcompat/widget/s1;

    .line 985
    .line 986
    iput-object v3, v0, Landroidx/appcompat/widget/s1;->l:La/f;

    .line 987
    .line 988
    invoke-virtual {v0}, Landroidx/appcompat/widget/s1;->drawableStateChanged()V

    .line 989
    .line 990
    .line 991
    return-void

    .line 992
    :pswitch_1b
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 993
    .line 994
    check-cast v0, Landroidx/appcompat/app/s0;

    .line 995
    .line 996
    iget-object v1, v0, Landroidx/appcompat/app/s0;->s:Landroidx/appcompat/app/z;

    .line 997
    .line 998
    invoke-virtual {v0}, Landroidx/appcompat/app/s0;->V()Landroid/view/Menu;

    .line 999
    .line 1000
    .line 1001
    move-result-object v0

    .line 1002
    instance-of v2, v0, Lk/l;

    .line 1003
    .line 1004
    if-eqz v2, :cond_1a

    .line 1005
    .line 1006
    move-object v2, v0

    .line 1007
    check-cast v2, Lk/l;

    .line 1008
    .line 1009
    goto :goto_10

    .line 1010
    :cond_1a
    move-object v2, v3

    .line 1011
    :goto_10
    if-eqz v2, :cond_1b

    .line 1012
    .line 1013
    invoke-virtual {v2}, Lk/l;->y()V

    .line 1014
    .line 1015
    .line 1016
    :cond_1b
    :try_start_2
    invoke-interface {v0}, Landroid/view/Menu;->clear()V

    .line 1017
    .line 1018
    .line 1019
    invoke-virtual {v1, v6, v0}, Landroidx/appcompat/app/z;->onCreatePanelMenu(ILandroid/view/Menu;)Z

    .line 1020
    .line 1021
    .line 1022
    move-result v4

    .line 1023
    if-eqz v4, :cond_1c

    .line 1024
    .line 1025
    invoke-virtual {v1, v6, v3, v0}, Landroidx/appcompat/app/z;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    .line 1026
    .line 1027
    .line 1028
    move-result v1

    .line 1029
    if-nez v1, :cond_1d

    .line 1030
    .line 1031
    goto :goto_11

    .line 1032
    :catchall_1
    move-exception v0

    .line 1033
    goto :goto_12

    .line 1034
    :cond_1c
    :goto_11
    invoke-interface {v0}, Landroid/view/Menu;->clear()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1035
    .line 1036
    .line 1037
    :cond_1d
    if-eqz v2, :cond_1e

    .line 1038
    .line 1039
    invoke-virtual {v2}, Lk/l;->x()V

    .line 1040
    .line 1041
    .line 1042
    :cond_1e
    return-void

    .line 1043
    :goto_12
    if-eqz v2, :cond_1f

    .line 1044
    .line 1045
    invoke-virtual {v2}, Lk/l;->x()V

    .line 1046
    .line 1047
    .line 1048
    :cond_1f
    throw v0

    .line 1049
    :pswitch_1c
    :try_start_3
    iget-object v0, p0, La/f;->b:Ljava/lang/Object;

    .line 1050
    .line 1051
    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1052
    .line 1053
    invoke-static {v0}, Landroidx/activity/ComponentActivity;->h(Landroidx/activity/ComponentActivity;)V
    :try_end_3
    .catch Ljava/lang/IllegalStateException; {:try_start_3 .. :try_end_3} :catch_0

    .line 1054
    .line 1055
    .line 1056
    goto :goto_13

    .line 1057
    :catch_0
    move-exception v0

    .line 1058
    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    .line 1059
    .line 1060
    .line 1061
    move-result-object v1

    .line 1062
    const-string v2, "Can not perform this action after onSaveInstanceState"

    .line 1063
    .line 1064
    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    .line 1065
    .line 1066
    .line 1067
    move-result v1

    .line 1068
    if-eqz v1, :cond_20

    .line 1069
    .line 1070
    :goto_13
    return-void

    .line 1071
    :cond_20
    throw v0

    .line 1072
    nop

    .line 1073
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
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

    .line 1074
    .line 1075
    .line 1076
    .line 1077
    .line 1078
    .line 1079
    .line 1080
    .line 1081
    .line 1082
    .line 1083
    .line 1084
    .line 1085
    .line 1086
    .line 1087
    .line 1088
    .line 1089
    .line 1090
    .line 1091
    .line 1092
    .line 1093
    .line 1094
    .line 1095
    .line 1096
    .line 1097
    .line 1098
    .line 1099
    .line 1100
    .line 1101
    .line 1102
    .line 1103
    .line 1104
    .line 1105
    .line 1106
    .line 1107
    .line 1108
    .line 1109
    .line 1110
    .line 1111
    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method
