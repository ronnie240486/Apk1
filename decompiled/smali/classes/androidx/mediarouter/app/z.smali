.class public final Landroidx/mediarouter/app/z;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic a:I

.field public final synthetic b:Ljava/lang/Object;

.field public final synthetic c:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p2, p0, Landroidx/mediarouter/app/z;->a:I

    .line 2
    .line 3
    iput-object p1, p0, Landroidx/mediarouter/app/z;->c:Ljava/lang/Object;

    .line 4
    .line 5
    iput-object p3, p0, Landroidx/mediarouter/app/z;->b:Ljava/lang/Object;

    .line 6
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    .line 9
    .line 10
    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 5

    .line 1
    iget v0, p0, Landroidx/mediarouter/app/z;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/mediarouter/app/z;->c:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lma/a;

    .line 9
    .line 10
    iget-object v1, v0, Lma/a;->e:Lna/a;

    .line 11
    .line 12
    if-eqz v1, :cond_0

    .line 13
    .line 14
    iget-object v2, p0, Landroidx/mediarouter/app/z;->b:Ljava/lang/Object;

    .line 15
    .line 16
    check-cast v2, Lt3/d;

    .line 17
    .line 18
    invoke-virtual {v2}, Landroidx/recyclerview/widget/p1;->getLayoutPosition()I

    .line 19
    .line 20
    .line 21
    move-result v2

    .line 22
    iget-object v1, v1, Lna/a;->a:Lorg/bitspark/android/keyboard/custom/MyKeyBoardView;

    .line 23
    .line 24
    invoke-static {v1, p1, v2}, Lorg/bitspark/android/keyboard/custom/MyKeyBoardView;->a(Lorg/bitspark/android/keyboard/custom/MyKeyBoardView;Landroid/view/View;I)V

    .line 25
    .line 26
    .line 27
    :cond_0
    iget-object v0, v0, Lma/a;->g:Lna/a;

    .line 28
    .line 29
    if-eqz v0, :cond_2

    .line 30
    .line 31
    iget-object v0, v0, Lna/a;->a:Lorg/bitspark/android/keyboard/custom/MyKeyBoardView;

    .line 32
    .line 33
    iget-object v0, v0, Lorg/bitspark/android/keyboard/custom/MyKeyBoardView;->i:Lna/b;

    .line 34
    .line 35
    if-eqz v0, :cond_2

    .line 36
    .line 37
    instance-of v0, p1, Landroid/widget/TextView;

    .line 38
    .line 39
    if-eqz v0, :cond_1

    .line 40
    .line 41
    check-cast p1, Landroid/widget/TextView;

    .line 42
    .line 43
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    .line 44
    .line 45
    .line 46
    move-result-object p1

    .line 47
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 48
    .line 49
    .line 50
    move-result-object p1

    .line 51
    goto :goto_0

    .line 52
    :cond_1
    const/4 p1, 0x0

    .line 53
    :goto_0
    const-string v0, "SN6kUF4n\n"

    .line 54
    .line 55
    const-string v1, "deOZOzteN6g=\n"

    .line 56
    .line 57
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 58
    .line 59
    .line 60
    move-result-object v0

    .line 61
    new-instance v1, Ljava/lang/StringBuilder;

    .line 62
    .line 63
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 64
    .line 65
    .line 66
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 67
    .line 68
    .line 69
    const-string p1, ""

    .line 70
    .line 71
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 72
    .line 73
    .line 74
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 75
    .line 76
    .line 77
    move-result-object p1

    .line 78
    invoke-static {v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    .line 80
    .line 81
    :cond_2
    return-void

    .line 82
    :pswitch_0
    iget-object p1, p0, Landroidx/mediarouter/app/z;->c:Ljava/lang/Object;

    .line 83
    .line 84
    check-cast p1, Lfa/x;

    .line 85
    .line 86
    iget-object v0, p1, Lfa/x;->d:Lea/k;

    .line 87
    .line 88
    if-eqz v0, :cond_6

    .line 89
    .line 90
    iget-object v0, p0, Landroidx/mediarouter/app/z;->b:Ljava/lang/Object;

    .line 91
    .line 92
    check-cast v0, Lfa/w;

    .line 93
    .line 94
    invoke-virtual {v0}, Landroidx/recyclerview/widget/p1;->getBindingAdapterPosition()I

    .line 95
    .line 96
    .line 97
    move-result v0

    .line 98
    const/4 v1, -0x1

    .line 99
    if-eq v0, v1, :cond_6

    .line 100
    .line 101
    const/4 v1, 0x0

    .line 102
    const/4 v2, 0x0

    .line 103
    :goto_1
    iget-object v3, p1, Lfa/x;->c:Ljava/util/ArrayList;

    .line 104
    .line 105
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 106
    .line 107
    .line 108
    move-result v3

    .line 109
    if-ge v2, v3, :cond_4

    .line 110
    .line 111
    iget-object v3, p1, Lfa/x;->c:Ljava/util/ArrayList;

    .line 112
    .line 113
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 114
    .line 115
    .line 116
    move-result-object v3

    .line 117
    check-cast v3, Lorg/bitspark/android/beans/Menu;

    .line 118
    .line 119
    if-ne v2, v0, :cond_3

    .line 120
    .line 121
    const/4 v4, 0x1

    .line 122
    goto :goto_2

    .line 123
    :cond_3
    const/4 v4, 0x0

    .line 124
    :goto_2
    invoke-virtual {v3, v4}, Lorg/bitspark/android/beans/Menu;->setSelected(Z)V

    .line 125
    .line 126
    .line 127
    add-int/lit8 v2, v2, 0x1

    .line 128
    .line 129
    goto :goto_1

    .line 130
    :cond_4
    invoke-virtual {p1}, Landroidx/recyclerview/widget/k0;->notifyDataSetChanged()V

    .line 131
    .line 132
    .line 133
    iget-object v2, p1, Lfa/x;->c:Ljava/util/ArrayList;

    .line 134
    .line 135
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 136
    .line 137
    .line 138
    move-result v2

    .line 139
    if-ge v0, v2, :cond_6

    .line 140
    .line 141
    iget-object v2, p1, Lfa/x;->d:Lea/k;

    .line 142
    .line 143
    iget-object p1, p1, Lfa/x;->c:Ljava/util/ArrayList;

    .line 144
    .line 145
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 146
    .line 147
    .line 148
    move-result-object p1

    .line 149
    check-cast p1, Lorg/bitspark/android/beans/Menu;

    .line 150
    .line 151
    iget-object p1, v2, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 152
    .line 153
    iput-boolean v1, p1, Lorg/bitspark/android/Spark;->G0:Z

    .line 154
    .line 155
    iget-object p1, p1, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 156
    .line 157
    iget-object p1, p1, Lta/a;->C:Ljava/util/ArrayList;

    .line 158
    .line 159
    invoke-virtual {p1}, Ljava/util/ArrayList;->clear()V

    .line 160
    .line 161
    .line 162
    invoke-static {}, Lra/f;->b()Lra/f;

    .line 163
    .line 164
    .line 165
    move-result-object p1

    .line 166
    invoke-virtual {p1}, Lra/f;->a()V

    .line 167
    .line 168
    .line 169
    invoke-static {}, Lra/f;->b()Lra/f;

    .line 170
    .line 171
    .line 172
    move-result-object p1

    .line 173
    iput-boolean v1, p1, Lra/f;->h:Z

    .line 174
    .line 175
    invoke-static {}, Lra/f;->b()Lra/f;

    .line 176
    .line 177
    .line 178
    move-result-object p1

    .line 179
    iget-object v1, p1, Lra/f;->e:Lorg/bitspark/android/beans/ChannelBean;

    .line 180
    .line 181
    if-nez v1, :cond_5

    .line 182
    .line 183
    goto :goto_3

    .line 184
    :cond_5
    iget-boolean v2, p1, Lra/f;->g:Z

    .line 185
    .line 186
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 187
    .line 188
    .line 189
    move-result-object v2

    .line 190
    iget-object v3, p1, Lra/f;->l:Ljava/lang/String;

    .line 191
    .line 192
    invoke-virtual {p1, v1, v2, v0, v3}, Lra/f;->f(Lorg/bitspark/android/beans/ChannelBean;Ljava/lang/Boolean;ILjava/lang/String;)V

    .line 193
    .line 194
    .line 195
    :cond_6
    :goto_3
    return-void

    .line 196
    :pswitch_1
    iget-object p1, p0, Landroidx/mediarouter/app/z;->c:Ljava/lang/Object;

    .line 197
    .line 198
    check-cast p1, Lorg/bitspark/android/Spark;

    .line 199
    .line 200
    iget-boolean v0, p1, Lorg/bitspark/android/Spark;->o0:Z

    .line 201
    .line 202
    const/16 v1, 0x8

    .line 203
    .line 204
    const/4 v2, 0x0

    .line 205
    if-eqz v0, :cond_8

    .line 206
    .line 207
    iget-object v0, p1, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 208
    .line 209
    iget-object v0, v0, Lta/a;->d:Landroidx/lifecycle/d0;

    .line 210
    .line 211
    const/4 v3, 0x1

    .line 212
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 213
    .line 214
    .line 215
    move-result-object v4

    .line 216
    invoke-virtual {v0, v4}, Landroidx/lifecycle/d0;->h(Ljava/lang/Object;)V

    .line 217
    .line 218
    .line 219
    const-string v0, "vIwpCn+VBYeqgyIXaoY=\n"

    .line 220
    .line 221
    const-string v4, "79x2TjrDTMQ=\n"

    .line 222
    .line 223
    invoke-static {v0, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 224
    .line 225
    .line 226
    move-result-object v0

    .line 227
    invoke-static {v3, v0}, Lorg/bitspark/android/utils/m;->m(ILjava/lang/String;)V

    .line 228
    .line 229
    .line 230
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 231
    .line 232
    .line 233
    move-result-object v0

    .line 234
    invoke-virtual {v0, p1}, Lorg/bitspark/android/utils/b;->e(Landroid/app/Activity;)Z

    .line 235
    .line 236
    .line 237
    move-result v0

    .line 238
    if-eqz v0, :cond_7

    .line 239
    .line 240
    sget-boolean v0, Lea/h;->P:Z

    .line 241
    .line 242
    if-eqz v0, :cond_7

    .line 243
    .line 244
    invoke-virtual {p1}, Lorg/bitspark/android/Spark;->a0()V

    .line 245
    .line 246
    .line 247
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 248
    .line 249
    .line 250
    move-result-object v0

    .line 251
    invoke-virtual {v0}, Lorg/bitspark/android/utils/b;->c()V

    .line 252
    .line 253
    .line 254
    iget-object v0, p1, Lorg/bitspark/android/Spark;->E0:Landroidx/mediarouter/app/MediaRouteButton;

    .line 255
    .line 256
    invoke-virtual {v0, v2}, Landroidx/mediarouter/app/MediaRouteButton;->setVisibility(I)V

    .line 257
    .line 258
    .line 259
    iget-object v0, p1, Lorg/bitspark/android/Spark;->T1:Landroidx/mediarouter/app/MediaRouteButton;

    .line 260
    .line 261
    invoke-virtual {v0, v2}, Landroidx/mediarouter/app/MediaRouteButton;->setVisibility(I)V

    .line 262
    .line 263
    .line 264
    goto :goto_4

    .line 265
    :cond_7
    iget-object v0, p1, Lorg/bitspark/android/Spark;->E0:Landroidx/mediarouter/app/MediaRouteButton;

    .line 266
    .line 267
    invoke-virtual {v0, v1}, Landroidx/mediarouter/app/MediaRouteButton;->setVisibility(I)V

    .line 268
    .line 269
    .line 270
    iget-object v0, p1, Lorg/bitspark/android/Spark;->T1:Landroidx/mediarouter/app/MediaRouteButton;

    .line 271
    .line 272
    invoke-virtual {v0, v1}, Landroidx/mediarouter/app/MediaRouteButton;->setVisibility(I)V

    .line 273
    .line 274
    .line 275
    goto :goto_4

    .line 276
    :cond_8
    iget-object v0, p1, Lorg/bitspark/android/Spark;->E0:Landroidx/mediarouter/app/MediaRouteButton;

    .line 277
    .line 278
    invoke-virtual {v0, v1}, Landroidx/mediarouter/app/MediaRouteButton;->setVisibility(I)V

    .line 279
    .line 280
    .line 281
    iget-object v0, p1, Lorg/bitspark/android/Spark;->T1:Landroidx/mediarouter/app/MediaRouteButton;

    .line 282
    .line 283
    invoke-virtual {v0, v1}, Landroidx/mediarouter/app/MediaRouteButton;->setVisibility(I)V

    .line 284
    .line 285
    .line 286
    iget-object v0, p1, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 287
    .line 288
    iget-object v0, v0, Lta/a;->d:Landroidx/lifecycle/d0;

    .line 289
    .line 290
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 291
    .line 292
    .line 293
    move-result-object v1

    .line 294
    invoke-virtual {v0, v1}, Landroidx/lifecycle/d0;->h(Ljava/lang/Object;)V

    .line 295
    .line 296
    .line 297
    const-string v0, "iOzoCmrlcvee4+MXf/Y=\n"

    .line 298
    .line 299
    const-string v1, "27y3Ti+zO7Q=\n"

    .line 300
    .line 301
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 302
    .line 303
    .line 304
    move-result-object v0

    .line 305
    invoke-static {v2, v0}, Lorg/bitspark/android/utils/m;->m(ILjava/lang/String;)V

    .line 306
    .line 307
    .line 308
    :goto_4
    iget-object v0, p0, Landroidx/mediarouter/app/z;->b:Ljava/lang/Object;

    .line 309
    .line 310
    check-cast v0, Landroid/app/Dialog;

    .line 311
    .line 312
    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 313
    .line 314
    .line 315
    iget-object p1, p1, Lorg/bitspark/android/Spark;->T:Lga/m;

    .line 316
    .line 317
    invoke-virtual {p1}, Lga/m;->i()V

    .line 318
    .line 319
    .line 320
    return-void

    .line 321
    :pswitch_2
    iget-object p1, p0, Landroidx/mediarouter/app/z;->c:Ljava/lang/Object;

    .line 322
    .line 323
    check-cast p1, Landroidx/mediarouter/app/a0;

    .line 324
    .line 325
    iget-object v0, p1, Landroidx/mediarouter/app/a0;->e:Landroidx/mediarouter/app/b0;

    .line 326
    .line 327
    iget-object v0, v0, Landroidx/mediarouter/app/b0;->g:Landroidx/mediarouter/app/c0;

    .line 328
    .line 329
    iget-object v1, p0, Landroidx/mediarouter/app/z;->b:Ljava/lang/Object;

    .line 330
    .line 331
    check-cast v1, Lq1/s0;

    .line 332
    .line 333
    iput-object v1, v0, Landroidx/mediarouter/app/c0;->m:Lq1/s0;

    .line 334
    .line 335
    const/4 v0, 0x1

    .line 336
    invoke-virtual {v1, v0}, Lq1/s0;->l(Z)V

    .line 337
    .line 338
    .line 339
    iget-object v0, p1, Landroidx/mediarouter/app/a0;->b:Landroid/widget/ImageView;

    .line 340
    .line 341
    const/4 v1, 0x4

    .line 342
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 343
    .line 344
    .line 345
    iget-object p1, p1, Landroidx/mediarouter/app/a0;->c:Landroid/widget/ProgressBar;

    .line 346
    .line 347
    const/4 v0, 0x0

    .line 348
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 349
    .line 350
    .line 351
    return-void

    .line 352
    nop

    .line 353
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
