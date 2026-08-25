.class public Lla/e;
.super Lka/b;
.source "MyApplication"

# interfaces
.implements Landroid/view/View$OnKeyListener;
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public U:Landroid/widget/Button;

.field public V:Landroid/widget/TextView;

.field public W:Landroid/widget/TextView;

.field public X:Landroid/widget/TextView;

.field public Y:Landroid/widget/TextView;

.field public Z:Landroid/widget/TextView;

.field public b0:Landroid/widget/TextView;

.field public c0:Landroid/widget/TextView;

.field public d0:Landroid/widget/TextView;

.field public e0:Z

.field public f0:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lka/b;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput-boolean v0, p0, Lla/e;->e0:Z

    .line 6
    .line 7
    return-void
.end method


# virtual methods
.method public final B()V
    .locals 8

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-super {p0}, Le8/a;->B()V

    .line 3
    .line 4
    .line 5
    const/4 v1, 0x1

    .line 6
    iput-boolean v1, p0, Lla/e;->e0:Z

    .line 7
    .line 8
    const-string v2, "UTITykbbjANJ\n"

    .line 9
    .line 10
    const-string v3, "PV10oyiJ/28=\n"

    .line 11
    .line 12
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object v2

    .line 16
    const-string v3, "c05dUFbL+0w=\n"

    .line 17
    .line 18
    const-string v4, "HCAPNSW+lik=\n"

    .line 19
    .line 20
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 21
    .line 22
    .line 23
    move-result-object v3

    .line 24
    sget-boolean v4, Lorg/bitspark/android/utils/m;->b:Z

    .line 25
    .line 26
    invoke-static {v2, v3}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    .line 28
    .line 29
    const-string v2, "ql1dABswz3WS\n"

    .line 30
    .line 31
    const-string v3, "5jI6aXVivBk=\n"

    .line 32
    .line 33
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 34
    .line 35
    .line 36
    move-result-object v2

    .line 37
    const-string v3, "ygVq2xRz12fwA2PDby6c\n"

    .line 38
    .line 39
    const-string v4, "uW0FrEEAshU=\n"

    .line 40
    .line 41
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 42
    .line 43
    .line 44
    move-result-object v3

    .line 45
    invoke-static {v2, v3}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    .line 47
    .line 48
    iget-boolean v2, p0, Lla/e;->e0:Z

    .line 49
    .line 50
    if-nez v2, :cond_0

    .line 51
    .line 52
    const-string v0, "YC5XYFD3Lw5Y\n"

    .line 53
    .line 54
    const-string v1, "LEEwCT6lXGI=\n"

    .line 55
    .line 56
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 57
    .line 58
    .line 59
    move-result-object v0

    .line 60
    const-string v1, "/Fl9553xT2v0W2f22OcKeeBFeg==\n"

    .line 61
    .line 62
    const-string v2, "lTcUk/iVbw0=\n"

    .line 63
    .line 64
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 65
    .line 66
    .line 67
    move-result-object v1

    .line 68
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    .line 70
    .line 71
    goto/16 :goto_3

    .line 72
    .line 73
    :cond_0
    sget-object v2, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 74
    .line 75
    if-eqz v2, :cond_b

    .line 76
    .line 77
    iget-object v2, v2, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    .line 78
    .line 79
    if-eqz v2, :cond_b

    .line 80
    .line 81
    iget-object v3, p0, Lla/e;->V:Landroid/widget/TextView;

    .line 82
    .line 83
    iget-object v2, v2, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->name:Ljava/lang/String;

    .line 84
    .line 85
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 86
    .line 87
    .line 88
    iget-object v2, p0, Lla/e;->W:Landroid/widget/TextView;

    .line 89
    .line 90
    sget-object v3, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 91
    .line 92
    iget-object v3, v3, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    .line 93
    .line 94
    iget-object v3, v3, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->reseller:Ljava/lang/String;

    .line 95
    .line 96
    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 97
    .line 98
    .line 99
    iget-object v2, p0, Lla/e;->Y:Landroid/widget/TextView;

    .line 100
    .line 101
    invoke-virtual {p0}, Landroidx/fragment/app/s;->j()Landroid/content/Context;

    .line 102
    .line 103
    .line 104
    move-result-object v3

    .line 105
    const v4, 0x7f060330

    .line 106
    .line 107
    .line 108
    invoke-static {v3, v4}, Lu7/d;->i(Landroid/content/Context;I)I

    .line 109
    .line 110
    .line 111
    move-result v3

    .line 112
    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 113
    .line 114
    .line 115
    sget-object v2, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 116
    .line 117
    iget-object v2, v2, Lorg/bitspark/android/beans/AuthInfo;->user:Lorg/bitspark/android/beans/AuthInfo$UserBean;

    .line 118
    .line 119
    if-eqz v2, :cond_9

    .line 120
    .line 121
    iget-object v2, v2, Lorg/bitspark/android/beans/AuthInfo$UserBean;->user_name:Ljava/lang/String;

    .line 122
    .line 123
    if-eqz v2, :cond_2

    .line 124
    .line 125
    sget-object v2, Lea/g;->b:Ljava/lang/String;

    .line 126
    .line 127
    invoke-static {v0, v2}, Lorg/bitspark/android/utils/m;->f(ILjava/lang/String;)Ljava/lang/Integer;

    .line 128
    .line 129
    .line 130
    move-result-object v2

    .line 131
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    .line 132
    .line 133
    .line 134
    move-result v2

    .line 135
    const/4 v3, 0x2

    .line 136
    if-ne v2, v3, :cond_1

    .line 137
    .line 138
    iget-object v2, p0, Lla/e;->X:Landroid/widget/TextView;

    .line 139
    .line 140
    const-string v3, "LVwuKDfkUqA0Pg==\n"

    .line 141
    .line 142
    const-string v4, "fW59bWWycvY=\n"

    .line 143
    .line 144
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 145
    .line 146
    .line 147
    move-result-object v3

    .line 148
    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 149
    .line 150
    .line 151
    goto :goto_0

    .line 152
    :cond_1
    iget-object v2, p0, Lla/e;->X:Landroid/widget/TextView;

    .line 153
    .line 154
    sget-object v3, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 155
    .line 156
    iget-object v3, v3, Lorg/bitspark/android/beans/AuthInfo;->user:Lorg/bitspark/android/beans/AuthInfo$UserBean;

    .line 157
    .line 158
    iget-object v3, v3, Lorg/bitspark/android/beans/AuthInfo$UserBean;->user_name:Ljava/lang/String;

    .line 159
    .line 160
    sget-object v4, Lea/h;->c:Ljava/lang/String;

    .line 161
    .line 162
    const-string v5, ""

    .line 163
    .line 164
    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    .line 165
    .line 166
    .line 167
    move-result-object v3

    .line 168
    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 169
    .line 170
    .line 171
    :cond_2
    :goto_0
    iget-object v2, p0, Lla/e;->X:Landroid/widget/TextView;

    .line 172
    .line 173
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setSelected(Z)V

    .line 174
    .line 175
    .line 176
    invoke-virtual {p0}, Landroidx/fragment/app/s;->m()Landroid/content/res/Resources;

    .line 177
    .line 178
    .line 179
    move-result-object v2

    .line 180
    const v3, 0x7f1201e2

    .line 181
    .line 182
    .line 183
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 184
    .line 185
    .line 186
    move-result-object v2

    .line 187
    sget-object v3, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 188
    .line 189
    iget-object v3, v3, Lorg/bitspark/android/beans/AuthInfo;->user:Lorg/bitspark/android/beans/AuthInfo$UserBean;

    .line 190
    .line 191
    iget v3, v3, Lorg/bitspark/android/beans/AuthInfo$UserBean;->user_status:I

    .line 192
    .line 193
    const/4 v4, -0x1

    .line 194
    if-ne v3, v4, :cond_3

    .line 195
    .line 196
    invoke-virtual {p0}, Landroidx/fragment/app/s;->m()Landroid/content/res/Resources;

    .line 197
    .line 198
    .line 199
    move-result-object v2

    .line 200
    const v3, 0x7f1201e3

    .line 201
    .line 202
    .line 203
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 204
    .line 205
    .line 206
    move-result-object v2

    .line 207
    goto :goto_1

    .line 208
    :cond_3
    if-nez v3, :cond_4

    .line 209
    .line 210
    invoke-virtual {p0}, Landroidx/fragment/app/s;->m()Landroid/content/res/Resources;

    .line 211
    .line 212
    .line 213
    move-result-object v2

    .line 214
    const v3, 0x7f1201e1

    .line 215
    .line 216
    .line 217
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 218
    .line 219
    .line 220
    move-result-object v2

    .line 221
    iget-object v3, p0, Lla/e;->Y:Landroid/widget/TextView;

    .line 222
    .line 223
    const/high16 v4, -0x10000

    .line 224
    .line 225
    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 226
    .line 227
    .line 228
    :cond_4
    :goto_1
    iget-object v3, p0, Lla/e;->Y:Landroid/widget/TextView;

    .line 229
    .line 230
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 231
    .line 232
    .line 233
    sget-object v2, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 234
    .line 235
    iget-object v2, v2, Lorg/bitspark/android/beans/AuthInfo;->user:Lorg/bitspark/android/beans/AuthInfo$UserBean;

    .line 236
    .line 237
    iget-wide v2, v2, Lorg/bitspark/android/beans/AuthInfo$UserBean;->EndTime:J

    .line 238
    .line 239
    const-wide/16 v4, 0x0

    .line 240
    .line 241
    cmp-long v6, v2, v4

    .line 242
    .line 243
    if-lez v6, :cond_8

    .line 244
    .line 245
    new-instance v2, Ljava/text/SimpleDateFormat;

    .line 246
    .line 247
    const-string v3, "0QbcQBZdrXfMGw==\n"

    .line 248
    .line 249
    const-string v4, "qH+lOTsQ4Fo=\n"

    .line 250
    .line 251
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 252
    .line 253
    .line 254
    move-result-object v3

    .line 255
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    .line 256
    .line 257
    .line 258
    move-result-object v4

    .line 259
    invoke-direct {v2, v3, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 260
    .line 261
    .line 262
    iget-object v3, p0, Lla/e;->Z:Landroid/widget/TextView;

    .line 263
    .line 264
    sget-object v4, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 265
    .line 266
    iget-object v4, v4, Lorg/bitspark/android/beans/AuthInfo;->user:Lorg/bitspark/android/beans/AuthInfo$UserBean;

    .line 267
    .line 268
    iget-wide v4, v4, Lorg/bitspark/android/beans/AuthInfo$UserBean;->EndTime:J

    .line 269
    .line 270
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 271
    .line 272
    .line 273
    move-result-object v4

    .line 274
    invoke-virtual {v2, v4}, Ljava/text/Format;->format(Ljava/lang/Object;)Ljava/lang/String;

    .line 275
    .line 276
    .line 277
    move-result-object v2

    .line 278
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 279
    .line 280
    .line 281
    sget-object v2, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 282
    .line 283
    iget-object v2, v2, Lorg/bitspark/android/beans/AuthInfo;->user:Lorg/bitspark/android/beans/AuthInfo$UserBean;

    .line 284
    .line 285
    iget-wide v2, v2, Lorg/bitspark/android/beans/AuthInfo$UserBean;->EndTime:J

    .line 286
    .line 287
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 288
    .line 289
    .line 290
    move-result-wide v4

    .line 291
    sget-wide v6, Lorg/bitspark/android/utils/m;->a:J

    .line 292
    .line 293
    add-long/2addr v4, v6

    .line 294
    sub-long/2addr v2, v4

    .line 295
    const-wide/16 v4, 0xe10

    .line 296
    .line 297
    div-long/2addr v2, v4

    .line 298
    const-wide/16 v4, 0x3e8

    .line 299
    .line 300
    div-long/2addr v2, v4

    .line 301
    const-wide/16 v4, 0x18

    .line 302
    .line 303
    div-long v6, v2, v4

    .line 304
    .line 305
    long-to-int v7, v6

    .line 306
    rem-long/2addr v2, v4

    .line 307
    long-to-int v3, v2

    .line 308
    if-gez v7, :cond_5

    .line 309
    .line 310
    const/4 v7, 0x0

    .line 311
    :cond_5
    if-gez v3, :cond_6

    .line 312
    .line 313
    const/4 v3, 0x0

    .line 314
    :cond_6
    if-nez v7, :cond_7

    .line 315
    .line 316
    iget-object v2, p0, Lla/e;->b0:Landroid/widget/TextView;

    .line 317
    .line 318
    const v4, 0x7f1201ce

    .line 319
    .line 320
    .line 321
    invoke-virtual {p0, v4}, Landroidx/fragment/app/s;->n(I)Ljava/lang/String;

    .line 322
    .line 323
    .line 324
    move-result-object v4

    .line 325
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 326
    .line 327
    .line 328
    move-result-object v3

    .line 329
    new-array v5, v1, [Ljava/lang/Object;

    .line 330
    .line 331
    aput-object v3, v5, v0

    .line 332
    .line 333
    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 334
    .line 335
    .line 336
    move-result-object v0

    .line 337
    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 338
    .line 339
    .line 340
    goto :goto_2

    .line 341
    :cond_7
    iget-object v2, p0, Lla/e;->b0:Landroid/widget/TextView;

    .line 342
    .line 343
    const v3, 0x7f1201cd

    .line 344
    .line 345
    .line 346
    invoke-virtual {p0, v3}, Landroidx/fragment/app/s;->n(I)Ljava/lang/String;

    .line 347
    .line 348
    .line 349
    move-result-object v3

    .line 350
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 351
    .line 352
    .line 353
    move-result-object v4

    .line 354
    new-array v5, v1, [Ljava/lang/Object;

    .line 355
    .line 356
    aput-object v4, v5, v0

    .line 357
    .line 358
    invoke-static {v3, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 359
    .line 360
    .line 361
    move-result-object v0

    .line 362
    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 363
    .line 364
    .line 365
    goto :goto_2

    .line 366
    :cond_8
    iget-object v0, p0, Lla/e;->Z:Landroid/widget/TextView;

    .line 367
    .line 368
    invoke-virtual {p0}, Landroidx/fragment/app/s;->m()Landroid/content/res/Resources;

    .line 369
    .line 370
    .line 371
    move-result-object v2

    .line 372
    const v3, 0x7f1201ad

    .line 373
    .line 374
    .line 375
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 376
    .line 377
    .line 378
    move-result-object v2

    .line 379
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 380
    .line 381
    .line 382
    :cond_9
    :goto_2
    sget-object v0, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 383
    .line 384
    iget-object v0, v0, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    .line 385
    .line 386
    iget v0, v0, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->type:I

    .line 387
    .line 388
    if-ne v0, v1, :cond_a

    .line 389
    .line 390
    iget-object v0, p0, Lla/e;->b0:Landroid/widget/TextView;

    .line 391
    .line 392
    invoke-virtual {p0}, Landroidx/fragment/app/s;->m()Landroid/content/res/Resources;

    .line 393
    .line 394
    .line 395
    move-result-object v1

    .line 396
    const v2, 0x7f1200ac

    .line 397
    .line 398
    .line 399
    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 400
    .line 401
    .line 402
    move-result-object v1

    .line 403
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 404
    .line 405
    .line 406
    :cond_a
    iget-object v0, p0, Lla/e;->c0:Landroid/widget/TextView;

    .line 407
    .line 408
    sget-object v1, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 409
    .line 410
    iget-object v1, v1, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    .line 411
    .line 412
    iget-object v1, v1, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->telephone:Ljava/lang/String;

    .line 413
    .line 414
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 415
    .line 416
    .line 417
    iget-object v0, p0, Lla/e;->d0:Landroid/widget/TextView;

    .line 418
    .line 419
    sget-object v1, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    .line 420
    .line 421
    iget-object v1, v1, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    .line 422
    .line 423
    iget-object v1, v1, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->website:Ljava/lang/String;

    .line 424
    .line 425
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 426
    .line 427
    .line 428
    :cond_b
    :goto_3
    return-void
.end method

.method public final Q()V
    .locals 2

    .line 1
    sget-object v0, Lea/h;->a:Ljava/lang/String;

    .line 2
    .line 3
    iget-object v0, p0, Lla/e;->U:Landroid/widget/Button;

    .line 4
    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    iget-object v0, p0, Lla/e;->U:Landroid/widget/Button;

    .line 14
    .line 15
    const/4 v1, 0x0

    .line 16
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 17
    .line 18
    .line 19
    goto :goto_0

    .line 20
    :cond_0
    iget-object v0, p0, Lla/e;->U:Landroid/widget/Button;

    .line 21
    .line 22
    if-eqz v0, :cond_1

    .line 23
    .line 24
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 25
    .line 26
    .line 27
    :cond_1
    :goto_0
    return-void
.end method

.method public final onClick(Landroid/view/View;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    const v0, 0x7f0b0272

    .line 6
    .line 7
    .line 8
    if-ne p1, v0, :cond_0

    .line 9
    .line 10
    invoke-virtual {p0}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    check-cast p1, Lorg/bitspark/android/Spark;

    .line 15
    .line 16
    invoke-virtual {p1}, Lorg/bitspark/android/Spark;->Q0()V

    .line 17
    .line 18
    .line 19
    :cond_0
    return-void
.end method

.method public final onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 3

    .line 1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getRepeatCount()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    if-nez v1, :cond_5

    .line 10
    .line 11
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    if-nez v1, :cond_5

    .line 16
    .line 17
    const v1, 0x7f0b0272

    .line 18
    .line 19
    .line 20
    const/4 v2, 0x1

    .line 21
    if-ne v0, v1, :cond_1

    .line 22
    .line 23
    const/16 v0, 0x13

    .line 24
    .line 25
    if-eq p2, v0, :cond_0

    .line 26
    .line 27
    const/16 v0, 0x14

    .line 28
    .line 29
    if-ne p2, v0, :cond_1

    .line 30
    .line 31
    :cond_0
    iget-object p1, p0, Lla/e;->U:Landroid/widget/Button;

    .line 32
    .line 33
    invoke-virtual {p1}, Landroid/view/View;->requestFocus()Z

    .line 34
    .line 35
    .line 36
    iget-object p1, p0, Lla/e;->U:Landroid/widget/Button;

    .line 37
    .line 38
    invoke-virtual {p1, v2}, Landroid/view/View;->setSelected(Z)V

    .line 39
    .line 40
    .line 41
    return v2

    .line 42
    :cond_1
    const/16 v0, 0x15

    .line 43
    .line 44
    if-eq p2, v0, :cond_3

    .line 45
    .line 46
    const/4 v0, 0x4

    .line 47
    if-ne p2, v0, :cond_2

    .line 48
    .line 49
    goto :goto_0

    .line 50
    :cond_2
    const/16 v0, 0x16

    .line 51
    .line 52
    if-ne p2, v0, :cond_5

    .line 53
    .line 54
    return v2

    .line 55
    :cond_3
    :goto_0
    invoke-virtual {p0}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    check-cast p1, Lorg/bitspark/android/Spark;

    .line 60
    .line 61
    iget-object p2, p1, Lorg/bitspark/android/Spark;->E:Landroid/widget/RadioButton;

    .line 62
    .line 63
    if-eqz p2, :cond_4

    .line 64
    .line 65
    invoke-virtual {p2}, Landroid/view/View;->isShown()Z

    .line 66
    .line 67
    .line 68
    move-result p2

    .line 69
    if-eqz p2, :cond_4

    .line 70
    .line 71
    iget-object p2, p1, Lorg/bitspark/android/Spark;->E:Landroid/widget/RadioButton;

    .line 72
    .line 73
    invoke-static {p2}, Lo9/d;->y(Landroid/view/View;)Z

    .line 74
    .line 75
    .line 76
    iget-object p1, p1, Lorg/bitspark/android/Spark;->E:Landroid/widget/RadioButton;

    .line 77
    .line 78
    invoke-virtual {p1, v2}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 79
    .line 80
    .line 81
    :cond_4
    return v2

    .line 82
    :cond_5
    invoke-super {p0, p1, p2, p3}, Lka/b;->onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z

    .line 83
    .line 84
    .line 85
    move-result p1

    .line 86
    return p1
.end method

.method public final t(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 0

    .line 1
    const p2, 0x7f0e0120

    .line 2
    .line 3
    .line 4
    const/4 p3, 0x0

    .line 5
    invoke-virtual {p1, p2, p3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    const p2, 0x7f0b0272

    .line 10
    .line 11
    .line 12
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 13
    .line 14
    .line 15
    move-result-object p2

    .line 16
    check-cast p2, Landroid/widget/Button;

    .line 17
    .line 18
    iput-object p2, p0, Lla/e;->U:Landroid/widget/Button;

    .line 19
    .line 20
    invoke-virtual {p2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 21
    .line 22
    .line 23
    iget-object p2, p0, Lla/e;->U:Landroid/widget/Button;

    .line 24
    .line 25
    invoke-virtual {p2, p0}, Landroid/view/View;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 26
    .line 27
    .line 28
    const p2, 0x7f0b03ac

    .line 29
    .line 30
    .line 31
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 32
    .line 33
    .line 34
    move-result-object p2

    .line 35
    check-cast p2, Landroid/widget/TextView;

    .line 36
    .line 37
    iput-object p2, p0, Lla/e;->V:Landroid/widget/TextView;

    .line 38
    .line 39
    const p2, 0x7f0b0363

    .line 40
    .line 41
    .line 42
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 43
    .line 44
    .line 45
    move-result-object p2

    .line 46
    check-cast p2, Landroid/widget/TextView;

    .line 47
    .line 48
    iput-object p2, p0, Lla/e;->W:Landroid/widget/TextView;

    .line 49
    .line 50
    const p2, 0x7f0b0457

    .line 51
    .line 52
    .line 53
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 54
    .line 55
    .line 56
    move-result-object p2

    .line 57
    check-cast p2, Landroid/widget/TextView;

    .line 58
    .line 59
    iput-object p2, p0, Lla/e;->X:Landroid/widget/TextView;

    .line 60
    .line 61
    const p2, 0x7f0b0453

    .line 62
    .line 63
    .line 64
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 65
    .line 66
    .line 67
    move-result-object p2

    .line 68
    check-cast p2, Landroid/widget/TextView;

    .line 69
    .line 70
    iput-object p2, p0, Lla/e;->Y:Landroid/widget/TextView;

    .line 71
    .line 72
    const p2, 0x7f0b0187

    .line 73
    .line 74
    .line 75
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 76
    .line 77
    .line 78
    move-result-object p2

    .line 79
    check-cast p2, Landroid/widget/TextView;

    .line 80
    .line 81
    iput-object p2, p0, Lla/e;->Z:Landroid/widget/TextView;

    .line 82
    .line 83
    const p2, 0x7f0b0186

    .line 84
    .line 85
    .line 86
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 87
    .line 88
    .line 89
    move-result-object p2

    .line 90
    check-cast p2, Landroid/widget/TextView;

    .line 91
    .line 92
    iput-object p2, p0, Lla/e;->b0:Landroid/widget/TextView;

    .line 93
    .line 94
    const p2, 0x7f0b0336

    .line 95
    .line 96
    .line 97
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 98
    .line 99
    .line 100
    move-result-object p2

    .line 101
    check-cast p2, Landroid/widget/TextView;

    .line 102
    .line 103
    iput-object p2, p0, Lla/e;->c0:Landroid/widget/TextView;

    .line 104
    .line 105
    const p2, 0x7f0b0490

    .line 106
    .line 107
    .line 108
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 109
    .line 110
    .line 111
    move-result-object p2

    .line 112
    check-cast p2, Landroid/widget/TextView;

    .line 113
    .line 114
    iput-object p2, p0, Lla/e;->d0:Landroid/widget/TextView;

    .line 115
    .line 116
    const p2, 0x7f0b03ae

    .line 117
    .line 118
    .line 119
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 120
    .line 121
    .line 122
    move-result-object p2

    .line 123
    iput-object p2, p0, Lla/e;->f0:Landroid/view/View;

    .line 124
    .line 125
    sget-boolean p3, Lea/h;->y:Z

    .line 126
    .line 127
    if-nez p3, :cond_0

    .line 128
    .line 129
    const/16 p3, 0x8

    .line 130
    .line 131
    invoke-virtual {p2, p3}, Landroid/view/View;->setVisibility(I)V

    .line 132
    .line 133
    .line 134
    :cond_0
    return-object p1
.end method
