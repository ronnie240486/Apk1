.class public final Lga/c;
.super Lcom/lzy/okgo/callback/StringCallback;
.source "MyApplication"


# instance fields
.field public final synthetic a:I

.field public final synthetic b:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lga/c;->a:I

    .line 2
    .line 3
    iput-object p2, p0, Lga/c;->b:Ljava/lang/Object;

    .line 4
    .line 5
    invoke-direct {p0}, Lcom/lzy/okgo/callback/StringCallback;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
.end method


# virtual methods
.method public onCacheSuccess(Lcom/lzy/okgo/model/Response;)V
    .locals 5

    .line 1
    iget-object v0, p0, Lga/c;->b:Ljava/lang/Object;

    .line 2
    .line 3
    iget v1, p0, Lga/c;->a:I

    .line 4
    .line 5
    packed-switch v1, :pswitch_data_0

    .line 6
    .line 7
    .line 8
    invoke-super {p0, p1}, Lcom/lzy/okgo/callback/AbsCallback;->onCacheSuccess(Lcom/lzy/okgo/model/Response;)V

    .line 9
    .line 10
    .line 11
    return-void

    .line 12
    :pswitch_0
    const-string p1, "93m0UK/9yF3bRIdT\n"

    .line 13
    .line 14
    const-string v0, "tSriP8u+oDw=\n"

    .line 15
    .line 16
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    const-string v0, "4/n3A03mWgPs/e1NXuUeJvbz7gNY6F0o4bzsSA==\n"

    .line 21
    .line 22
    const-string v1, "hJyDIzuJPkA=\n"

    .line 23
    .line 24
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v0

    .line 28
    sget-boolean v1, Lorg/bitspark/android/utils/m;->b:Z

    .line 29
    .line 30
    invoke-static {p1, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    .line 32
    .line 33
    return-void

    .line 34
    :pswitch_1
    const-string v1, "qipj43u2\n"

    .line 35
    .line 36
    const-string v2, "6Hk2kB7EPJU=\n"

    .line 37
    .line 38
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 39
    .line 40
    .line 41
    move-result-object v1

    .line 42
    new-instance v2, Ljava/lang/StringBuilder;

    .line 43
    .line 44
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 45
    .line 46
    .line 47
    const-string v3, "l3mkWp8UhFDQeqIVk0GTWZN0tVqRCtAVzjw=\n"

    .line 48
    .line 49
    const-string v4, "8BzQev5h8Dg=\n"

    .line 50
    .line 51
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 52
    .line 53
    .line 54
    move-result-object v3

    .line 55
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    .line 57
    .line 58
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 59
    .line 60
    .line 61
    move-result-object v3

    .line 62
    check-cast v3, Ljava/lang/String;

    .line 63
    .line 64
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 65
    .line 66
    .line 67
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 68
    .line 69
    .line 70
    move-result-object v2

    .line 71
    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 72
    .line 73
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    .line 75
    .line 76
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 77
    .line 78
    .line 79
    move-result-object v1

    .line 80
    check-cast v1, Ljava/lang/String;

    .line 81
    .line 82
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->code()I

    .line 83
    .line 84
    .line 85
    move-result p1

    .line 86
    check-cast v0, Lga/m;

    .line 87
    .line 88
    invoke-static {v0, v1, p1}, Lga/m;->d(Lga/m;Ljava/lang/String;I)V

    .line 89
    .line 90
    .line 91
    return-void

    .line 92
    :pswitch_2
    const-string v1, "Xi6foib8cRFw\n"

    .line 93
    .line 94
    const-string v2, "HH3cykeSH3Q=\n"

    .line 95
    .line 96
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 97
    .line 98
    .line 99
    move-result-object v1

    .line 100
    const-string v2, "A7F269iYqToKsW7r3YKnOUS3Y6jTleg7Dw==\n"

    .line 101
    .line 102
    const-string v3, "ZNQCy7vwyFQ=\n"

    .line 103
    .line 104
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 105
    .line 106
    .line 107
    move-result-object v2

    .line 108
    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 109
    .line 110
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    .line 112
    .line 113
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 114
    .line 115
    .line 116
    move-result-object p1

    .line 117
    check-cast p1, Ljava/lang/String;

    .line 118
    .line 119
    check-cast v0, Lga/d;

    .line 120
    .line 121
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 122
    .line 123
    .line 124
    new-instance v0, Lcom/tencent/bugly/proguard/i0;

    .line 125
    .line 126
    const/4 v1, 0x1

    .line 127
    invoke-direct {v0, v1, p1}, Lcom/tencent/bugly/proguard/i0;-><init>(ILjava/lang/Object;)V

    .line 128
    .line 129
    .line 130
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 131
    .line 132
    .line 133
    return-void

    .line 134
    nop

    .line 135
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final onError(Lcom/lzy/okgo/model/Response;)V
    .locals 8

    .line 1
    const/4 v0, 0x1

    .line 2
    iget-object v1, p0, Lga/c;->b:Ljava/lang/Object;

    .line 3
    .line 4
    iget v2, p0, Lga/c;->a:I

    .line 5
    .line 6
    packed-switch v2, :pswitch_data_0

    .line 7
    .line 8
    .line 9
    const-string p1, "9fmKP6VcaubP9ZI7\n"

    .line 10
    .line 11
    const-string v0, "u5z+SMouAbM=\n"

    .line 12
    .line 13
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    const-string v0, "fZU19mYpQndIky/hIz5TbUraLvZwP1V9W4ko/nYmFmxbiSv3bTlTJB6fKepsOA==\n"

    .line 18
    .line 19
    const-string v2, "PvpbmANKNh4=\n"

    .line 20
    .line 21
    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 26
    .line 27
    invoke-static {p1, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    .line 29
    .line 30
    const-string p1, "II1sTZ3ZdzBL0TA=\n"

    .line 31
    .line 32
    const-string v0, "Zf8eIu/5RRA=\n"

    .line 33
    .line 34
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 35
    .line 36
    .line 37
    move-result-object p1

    .line 38
    check-cast v1, Lorg/bitspark/android/utils/j;

    .line 39
    .line 40
    invoke-interface {v1, p1}, Lorg/bitspark/android/utils/j;->b(Ljava/lang/String;)V

    .line 41
    .line 42
    .line 43
    return-void

    .line 44
    :pswitch_0
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 45
    .line 46
    const/16 v0, 0x16

    .line 47
    .line 48
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 49
    .line 50
    .line 51
    return-void

    .line 52
    :pswitch_1
    const-string v2, "3Q5rYjVh\n"

    .line 53
    .line 54
    const-string v3, "n10+EVATvDg=\n"

    .line 55
    .line 56
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 57
    .line 58
    .line 59
    move-result-object v2

    .line 60
    new-instance v3, Ljava/lang/StringBuilder;

    .line 61
    .line 62
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 63
    .line 64
    .line 65
    const-string v4, "OVO7UJSeQ5Z7HaxHlYFe2CVY3mGJlVSMdg==\n"

    .line 66
    .line 67
    const-string v5, "Vj3+IubxMbY=\n"

    .line 68
    .line 69
    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 70
    .line 71
    .line 72
    move-result-object v4

    .line 73
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 74
    .line 75
    .line 76
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->code()I

    .line 77
    .line 78
    .line 79
    move-result v4

    .line 80
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 81
    .line 82
    .line 83
    const-string v4, "i3cHnt0h+tCddw==\n"

    .line 84
    .line 85
    const-string v5, "p1dU6rxVj6M=\n"

    .line 86
    .line 87
    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 88
    .line 89
    .line 90
    move-result-object v4

    .line 91
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 92
    .line 93
    .line 94
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->message()Ljava/lang/String;

    .line 95
    .line 96
    .line 97
    move-result-object v4

    .line 98
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 99
    .line 100
    .line 101
    const-string v4, "OpY547k+IQ9ljFE=\n"

    .line 102
    .line 103
    const-string v5, "FrZxhthaRH0=\n"

    .line 104
    .line 105
    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 106
    .line 107
    .line 108
    move-result-object v4

    .line 109
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 110
    .line 111
    .line 112
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->headers()Lokhttp3/Headers;

    .line 113
    .line 114
    .line 115
    move-result-object v4

    .line 116
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 117
    .line 118
    .line 119
    const-string v4, "BBab8TZ618w=\n"

    .line 120
    .line 121
    const-string v5, "KDbZnlID7ew=\n"

    .line 122
    .line 123
    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 124
    .line 125
    .line 126
    move-result-object v4

    .line 127
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 128
    .line 129
    .line 130
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 131
    .line 132
    .line 133
    move-result-object v4

    .line 134
    check-cast v4, Ljava/lang/String;

    .line 135
    .line 136
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 137
    .line 138
    .line 139
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 140
    .line 141
    .line 142
    move-result-object v3

    .line 143
    sget-boolean v4, Lorg/bitspark/android/utils/m;->b:Z

    .line 144
    .line 145
    invoke-static {v2, v3}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    .line 147
    .line 148
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->getException()Ljava/lang/Throwable;

    .line 149
    .line 150
    .line 151
    move-result-object p1

    .line 152
    if-eqz p1, :cond_0

    .line 153
    .line 154
    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    .line 155
    .line 156
    .line 157
    move-result-object v2

    .line 158
    const-string v3, "ag5636sA\n"

    .line 159
    .line 160
    const-string v4, "KF0vrM5ykig=\n"

    .line 161
    .line 162
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 163
    .line 164
    .line 165
    move-result-object v3

    .line 166
    new-instance v4, Ljava/lang/StringBuilder;

    .line 167
    .line 168
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 169
    .line 170
    .line 171
    const-string v5, "KOuj0cKMW1JqpaPb04ZZBi7qiJmQ\n"

    .line 172
    .line 173
    const-string v6, "R4Xmo7DjKXI=\n"

    .line 174
    .line 175
    invoke-static {v5, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 176
    .line 177
    .line 178
    move-result-object v5

    .line 179
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 180
    .line 181
    .line 182
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    .line 183
    .line 184
    .line 185
    move-result-object p1

    .line 186
    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 187
    .line 188
    .line 189
    const-string p1, "BMay1uc=\n"

    .line 190
    .line 191
    const-string v5, "JOuf+8cL72Y=\n"

    .line 192
    .line 193
    invoke-static {p1, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 194
    .line 195
    .line 196
    move-result-object p1

    .line 197
    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 198
    .line 199
    .line 200
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 201
    .line 202
    .line 203
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 204
    .line 205
    .line 206
    move-result-object p1

    .line 207
    invoke-static {v3, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    .line 209
    .line 210
    :cond_0
    const-string p1, "uA==\n"

    .line 211
    .line 212
    const-string v2, "jE8oZ9qTqrY=\n"

    .line 213
    .line 214
    invoke-static {p1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 215
    .line 216
    .line 217
    move-result-object p1

    .line 218
    check-cast v1, Lga/m;

    .line 219
    .line 220
    invoke-static {v1, p1}, Lga/m;->a(Lga/m;Ljava/lang/String;)V

    .line 221
    .line 222
    .line 223
    invoke-static {v1}, Lga/m;->b(Lga/m;)Z

    .line 224
    .line 225
    .line 226
    move-result p1

    .line 227
    if-eqz p1, :cond_1

    .line 228
    .line 229
    invoke-virtual {v1}, Lga/m;->f()V

    .line 230
    .line 231
    .line 232
    goto :goto_0

    .line 233
    :cond_1
    new-instance p1, Ljava/lang/StringBuilder;

    .line 234
    .line 235
    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 236
    .line 237
    .line 238
    iget-object v2, v1, Lga/m;->a:Landroid/content/Context;

    .line 239
    .line 240
    const v3, 0x7f120127

    .line 241
    .line 242
    .line 243
    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 244
    .line 245
    .line 246
    move-result-object v2

    .line 247
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 248
    .line 249
    .line 250
    const-string v2, "oQ==\n"

    .line 251
    .line 252
    const-string v3, "ldpx5Ha01FE=\n"

    .line 253
    .line 254
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 255
    .line 256
    .line 257
    move-result-object v2

    .line 258
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 259
    .line 260
    .line 261
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 262
    .line 263
    .line 264
    move-result-object p1

    .line 265
    invoke-static {v0, p1}, Lorg/bitspark/android/Spark;->t0(ILjava/lang/String;)V

    .line 266
    .line 267
    .line 268
    sget-object p1, Lea/g;->a:Ljava/lang/String;

    .line 269
    .line 270
    invoke-static {p1}, Lorg/bitspark/android/utils/m;->l(Ljava/lang/String;)V

    .line 271
    .line 272
    .line 273
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 274
    .line 275
    const/16 v0, 0xa

    .line 276
    .line 277
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 278
    .line 279
    .line 280
    const-string p1, "rw==\n"

    .line 281
    .line 282
    const-string v0, "m4FYO00pGEk=\n"

    .line 283
    .line 284
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 285
    .line 286
    .line 287
    move-result-object p1

    .line 288
    invoke-static {v1, p1}, Lga/m;->c(Lga/m;Ljava/lang/String;)V

    .line 289
    .line 290
    .line 291
    :goto_0
    return-void

    .line 292
    :pswitch_2
    sget-object p1, Lorg/bitspark/android/Spark;->d2:Lda/c;

    .line 293
    .line 294
    const-string v2, "+j6B4oV9Gg==\n"

    .line 295
    .line 296
    const-string v3, "mVbgjOsYdlQ=\n"

    .line 297
    .line 298
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 299
    .line 300
    .line 301
    move-result-object v2

    .line 302
    iget-object v3, p1, Lda/c;->b:Lda/b;

    .line 303
    .line 304
    invoke-virtual {v3, v2}, Lda/b;->b(Ljava/lang/String;)Ljava/io/File;

    .line 305
    .line 306
    .line 307
    move-result-object v3

    .line 308
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    .line 309
    .line 310
    .line 311
    move-result v4

    .line 312
    const/4 v5, 0x0

    .line 313
    if-nez v4, :cond_2

    .line 314
    .line 315
    goto/16 :goto_5

    .line 316
    .line 317
    :cond_2
    :try_start_0
    new-instance v4, Ljava/io/BufferedReader;

    .line 318
    .line 319
    new-instance v6, Ljava/io/FileReader;

    .line 320
    .line 321
    invoke-direct {v6, v3}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    .line 322
    .line 323
    .line 324
    invoke-direct {v4, v6}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 325
    .line 326
    .line 327
    :try_start_1
    const-string v3, ""

    .line 328
    .line 329
    :goto_1
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    .line 330
    .line 331
    .line 332
    move-result-object v6

    .line 333
    if-eqz v6, :cond_3

    .line 334
    .line 335
    new-instance v7, Ljava/lang/StringBuilder;

    .line 336
    .line 337
    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 338
    .line 339
    .line 340
    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 341
    .line 342
    .line 343
    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 344
    .line 345
    .line 346
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 347
    .line 348
    .line 349
    move-result-object v3

    .line 350
    goto :goto_1

    .line 351
    :catchall_0
    move-exception p1

    .line 352
    move-object v5, v4

    .line 353
    goto/16 :goto_8

    .line 354
    .line 355
    :catch_0
    move-exception p1

    .line 356
    goto :goto_4

    .line 357
    :cond_3
    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    .line 358
    .line 359
    .line 360
    move-result-object v6

    .line 361
    invoke-static {v6}, Lo9/e;->u([B)Z

    .line 362
    .line 363
    .line 364
    move-result v6

    .line 365
    if-nez v6, :cond_5

    .line 366
    .line 367
    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    .line 368
    .line 369
    .line 370
    move-result-object p1

    .line 371
    invoke-static {p1}, Lo9/e;->r([B)Z

    .line 372
    .line 373
    .line 374
    move-result p1

    .line 375
    if-eqz p1, :cond_4

    .line 376
    .line 377
    const/16 p1, 0x20

    .line 378
    .line 379
    invoke-virtual {v3, p1}, Ljava/lang/String;->indexOf(I)I

    .line 380
    .line 381
    .line 382
    move-result p1

    .line 383
    add-int/2addr p1, v0

    .line 384
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    .line 385
    .line 386
    .line 387
    move-result v2

    .line 388
    invoke-virtual {v3, p1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 389
    .line 390
    .line 391
    move-result-object p1
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 392
    move-object v5, p1

    .line 393
    goto :goto_2

    .line 394
    :cond_4
    move-object v5, v3

    .line 395
    :goto_2
    :try_start_2
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 396
    .line 397
    .line 398
    goto :goto_5

    .line 399
    :catch_1
    move-exception p1

    .line 400
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 401
    .line 402
    .line 403
    goto :goto_5

    .line 404
    :cond_5
    :try_start_3
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    .line 405
    .line 406
    .line 407
    goto :goto_3

    .line 408
    :catch_2
    move-exception v3

    .line 409
    invoke-virtual {v3}, Ljava/lang/Throwable;->printStackTrace()V

    .line 410
    .line 411
    .line 412
    :goto_3
    invoke-virtual {p1, v2}, Lda/c;->g(Ljava/lang/String;)V

    .line 413
    .line 414
    .line 415
    goto :goto_5

    .line 416
    :catchall_1
    move-exception p1

    .line 417
    goto :goto_8

    .line 418
    :catch_3
    move-exception p1

    .line 419
    move-object v4, v5

    .line 420
    :goto_4
    :try_start_4
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 421
    .line 422
    .line 423
    if-eqz v4, :cond_6

    .line 424
    .line 425
    :try_start_5
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    .line 426
    .line 427
    .line 428
    :cond_6
    :goto_5
    if-eqz v5, :cond_7

    .line 429
    .line 430
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    .line 431
    .line 432
    .line 433
    move-result p1

    .line 434
    const/16 v2, 0x32

    .line 435
    .line 436
    invoke-static {p1, v2}, Ljava/lang/Math;->min(II)I

    .line 437
    .line 438
    .line 439
    move-result p1

    .line 440
    const/4 v2, 0x0

    .line 441
    invoke-virtual {v5, v2, p1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 442
    .line 443
    .line 444
    move-result-object p1

    .line 445
    goto :goto_6

    .line 446
    :cond_7
    const-string p1, "/N5huw==\n"

    .line 447
    .line 448
    const-string v2, "kqsN166ZzN0=\n"

    .line 449
    .line 450
    invoke-static {p1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 451
    .line 452
    .line 453
    move-result-object p1

    .line 454
    :goto_6
    const-string v2, "L8ZHuFG70AoB\n"

    .line 455
    .line 456
    const-string v3, "bZUE0DDVvm8=\n"

    .line 457
    .line 458
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 459
    .line 460
    .line 461
    move-result-object v2

    .line 462
    new-instance v3, Ljava/lang/StringBuilder;

    .line 463
    .line 464
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 465
    .line 466
    .line 467
    const-string v4, "RQexvtiiFUhMB6m+3bgbSwIRoOzNrwYGRAOs8pfqBkNDBuX4yaUZBkEDpvbe+04G\n"

    .line 468
    .line 469
    const-string v6, "ImLFnrvKdCY=\n"

    .line 470
    .line 471
    invoke-static {v4, v6, v3, p1}, Lea/q;->j(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/String;

    .line 472
    .line 473
    .line 474
    move-result-object p1

    .line 475
    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 476
    .line 477
    invoke-static {v2, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 478
    .line 479
    .line 480
    if-eqz v5, :cond_8

    .line 481
    .line 482
    const-string p1, "ihhTkTIq5Rik\n"

    .line 483
    .line 484
    const-string v2, "yEsQ+VNEi30=\n"

    .line 485
    .line 486
    invoke-static {p1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 487
    .line 488
    .line 489
    move-result-object p1

    .line 490
    const-string v2, "ABWAedXG2DIJFZh50NzWMUcDkSvAy8t8ARGdNZqOyzkGFNQ/xMHUfAQRlzHTnA==\n"

    .line 491
    .line 492
    const-string v3, "Z3D0WbauuVw=\n"

    .line 493
    .line 494
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 495
    .line 496
    .line 497
    move-result-object v2

    .line 498
    invoke-static {p1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 499
    .line 500
    .line 501
    check-cast v1, Lga/d;

    .line 502
    .line 503
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 504
    .line 505
    .line 506
    new-instance p1, Lcom/tencent/bugly/proguard/i0;

    .line 507
    .line 508
    invoke-direct {p1, v0, v5}, Lcom/tencent/bugly/proguard/i0;-><init>(ILjava/lang/Object;)V

    .line 509
    .line 510
    .line 511
    invoke-virtual {p1}, Ljava/lang/Thread;->start()V

    .line 512
    .line 513
    .line 514
    goto :goto_7

    .line 515
    :cond_8
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 516
    .line 517
    const/16 v0, 0x15

    .line 518
    .line 519
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 520
    .line 521
    .line 522
    :goto_7
    return-void

    .line 523
    :goto_8
    if-eqz v5, :cond_9

    .line 524
    .line 525
    :try_start_6
    invoke-virtual {v5}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    .line 526
    .line 527
    .line 528
    goto :goto_9

    .line 529
    :catch_4
    move-exception v0

    .line 530
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 531
    .line 532
    .line 533
    :cond_9
    :goto_9
    throw p1

    .line 534
    nop

    .line 535
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final onSuccess(Lcom/lzy/okgo/model/Response;)V
    .locals 10

    .line 1
    const/4 v0, 0x1

    .line 2
    iget v1, p0, Lga/c;->a:I

    .line 3
    .line 4
    packed-switch v1, :pswitch_data_0

    .line 5
    .line 6
    .line 7
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->isSuccessful()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    iget-object v1, p0, Lga/c;->b:Ljava/lang/Object;

    .line 12
    .line 13
    check-cast v1, Lorg/bitspark/android/utils/j;

    .line 14
    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    const-string p1, "hNI72mhp3A==\n"

    .line 18
    .line 19
    const-string v0, "y5kb9EZH/BM=\n"

    .line 20
    .line 21
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 22
    .line 23
    .line 24
    move-result-object p1

    .line 25
    invoke-interface {v1, p1}, Lorg/bitspark/android/utils/j;->a(Ljava/lang/String;)V

    .line 26
    .line 27
    .line 28
    goto :goto_0

    .line 29
    :cond_0
    const-string v0, "74qHxbwn6tzVhp/B\n"

    .line 30
    .line 31
    const-string v2, "oe/zstNVgYk=\n"

    .line 32
    .line 33
    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 34
    .line 35
    .line 36
    move-result-object v0

    .line 37
    new-instance v2, Ljava/lang/StringBuilder;

    .line 38
    .line 39
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 40
    .line 41
    .line 42
    const-string v3, "rA1cthULxyeZC0ahUBzWPZtCR7YDHdAtihFBvgUEkzyKEUK3HhvWdM9CH/gzB9cr1UI=\n"

    .line 43
    .line 44
    const-string v4, "72Iy2HBos04=\n"

    .line 45
    .line 46
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 47
    .line 48
    .line 49
    move-result-object v3

    .line 50
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->code()I

    .line 54
    .line 55
    .line 56
    move-result p1

    .line 57
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 58
    .line 59
    .line 60
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 61
    .line 62
    .line 63
    move-result-object p1

    .line 64
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 65
    .line 66
    invoke-static {v0, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    .line 68
    .line 69
    const-string p1, "2GzlrRW0EiqzMLk=\n"

    .line 70
    .line 71
    const-string v0, "nR6XwmeUIwo=\n"

    .line 72
    .line 73
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 74
    .line 75
    .line 76
    move-result-object p1

    .line 77
    invoke-interface {v1, p1}, Lorg/bitspark/android/utils/j;->b(Ljava/lang/String;)V

    .line 78
    .line 79
    .line 80
    :goto_0
    return-void

    .line 81
    :pswitch_0
    const-string v0, "YuKl7ADfoOlO35bv\n"

    .line 82
    .line 83
    const-string v1, "ILHzg2ScyIg=\n"

    .line 84
    .line 85
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 86
    .line 87
    .line 88
    move-result-object v0

    .line 89
    const-string v1, "pZtg5gxQCYuqn3qoH1NNrrCReeYJWh++p4w0qRE=\n"

    .line 90
    .line 91
    const-string v2, "wv4Uxno/bcg=\n"

    .line 92
    .line 93
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 94
    .line 95
    .line 96
    move-result-object v1

    .line 97
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 98
    .line 99
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    .line 101
    .line 102
    iget-object v0, p0, Lga/c;->b:Ljava/lang/Object;

    .line 103
    .line 104
    check-cast v0, Lga/o;

    .line 105
    .line 106
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 107
    .line 108
    .line 109
    move-result-object p1

    .line 110
    check-cast p1, Ljava/lang/String;

    .line 111
    .line 112
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 113
    .line 114
    .line 115
    const/16 v0, 0x16

    .line 116
    .line 117
    :try_start_0
    const-class v1, Lorg/bitspark/android/beans/GroupBeanModel;

    .line 118
    .line 119
    invoke-static {p1, v1}, Lcom/alibaba/fastjson/JSON;->parseArray(Ljava/lang/String;Ljava/lang/Class;)Ljava/util/List;

    .line 120
    .line 121
    .line 122
    move-result-object p1

    .line 123
    sput-object p1, Lga/o;->f:Ljava/util/List;

    .line 124
    .line 125
    sget-object p1, Lga/o;->f:Ljava/util/List;

    .line 126
    .line 127
    new-instance v1, La0/e;

    .line 128
    .line 129
    const/4 v2, 0x4

    .line 130
    invoke-direct {v1, v2}, La0/e;-><init>(I)V

    .line 131
    .line 132
    .line 133
    invoke-static {p1, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 134
    .line 135
    .line 136
    sget-object p1, Lga/o;->f:Ljava/util/List;

    .line 137
    .line 138
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 139
    .line 140
    .line 141
    move-result-object p1

    .line 142
    :goto_1
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 143
    .line 144
    .line 145
    move-result v1

    .line 146
    if-eqz v1, :cond_1

    .line 147
    .line 148
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 149
    .line 150
    .line 151
    move-result-object v1

    .line 152
    check-cast v1, Lorg/bitspark/android/beans/GroupBeanModel;

    .line 153
    .line 154
    iget-object v1, v1, Lorg/bitspark/android/beans/GroupBeanModel;->items:Ljava/util/List;

    .line 155
    .line 156
    new-instance v2, Lga/n;

    .line 157
    .line 158
    invoke-direct {v2}, Ljava/lang/Object;-><init>()V

    .line 159
    .line 160
    .line 161
    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 162
    .line 163
    .line 164
    goto :goto_1

    .line 165
    :catchall_0
    move-exception p1

    .line 166
    goto :goto_5

    .line 167
    :catch_0
    move-exception p1

    .line 168
    goto :goto_3

    .line 169
    :cond_1
    sget-object p1, Lga/o;->f:Ljava/util/List;

    .line 170
    .line 171
    if-eqz p1, :cond_2

    .line 172
    .line 173
    invoke-static {}, Lga/o;->a()V

    .line 174
    .line 175
    .line 176
    :cond_2
    const-string p1, "9JTP69XeFa7wlJ3u35pM4arbnQ==\n"

    .line 177
    .line 178
    const-string v1, "hPW9mLD+cc8=\n"

    .line 179
    .line 180
    invoke-static {p1, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 181
    .line 182
    .line 183
    :goto_2
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 184
    .line 185
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 186
    .line 187
    .line 188
    goto :goto_4

    .line 189
    :goto_3
    :try_start_1
    sget-object v1, Lga/o;->a:Ljava/lang/String;

    .line 190
    .line 191
    new-instance v2, Ljava/lang/StringBuilder;

    .line 192
    .line 193
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 194
    .line 195
    .line 196
    const-string v3, "NZpCHQoaA8chuFgPAVQQxGWfURoOGhDaN5RCT08=\n"

    .line 197
    .line 198
    const-string v4, "Rfswbm86dag=\n"

    .line 199
    .line 200
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 201
    .line 202
    .line 203
    move-result-object v3

    .line 204
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 205
    .line 206
    .line 207
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 208
    .line 209
    .line 210
    move-result-object p1

    .line 211
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 212
    .line 213
    .line 214
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 215
    .line 216
    .line 217
    move-result-object p1

    .line 218
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 219
    .line 220
    invoke-static {v1, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 221
    .line 222
    .line 223
    goto :goto_2

    .line 224
    :goto_4
    return-void

    .line 225
    :goto_5
    sget-object v1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 226
    .line 227
    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 228
    .line 229
    .line 230
    throw p1

    .line 231
    :pswitch_1
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->isSuccessful()Z

    .line 232
    .line 233
    .line 234
    move-result v1

    .line 235
    const/16 v2, 0xa

    .line 236
    .line 237
    const v3, 0x7f120127

    .line 238
    .line 239
    .line 240
    iget-object v4, p0, Lga/c;->b:Ljava/lang/Object;

    .line 241
    .line 242
    check-cast v4, Lga/m;

    .line 243
    .line 244
    if-nez v1, :cond_4

    .line 245
    .line 246
    const-string v1, "wYybp+gX\n"

    .line 247
    .line 248
    const-string v5, "g9/O1I1laOE=\n"

    .line 249
    .line 250
    invoke-static {v1, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 251
    .line 252
    .line 253
    move-result-object v1

    .line 254
    new-instance v5, Ljava/lang/StringBuilder;

    .line 255
    .line 256
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 257
    .line 258
    .line 259
    const-string v6, "fED3NbQJ5wpgFIQuuB6iEGB90SO0D/EKdVvIYA==\n"

    .line 260
    .line 261
    const-string v7, "Ey6kQNdqgnk=\n"

    .line 262
    .line 263
    invoke-static {v6, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 264
    .line 265
    .line 266
    move-result-object v6

    .line 267
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 268
    .line 269
    .line 270
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->headers()Lokhttp3/Headers;

    .line 271
    .line 272
    .line 273
    move-result-object v6

    .line 274
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 275
    .line 276
    .line 277
    const-string v6, "WhjB\n"

    .line 278
    .line 279
    const-string v7, "dzXspZDSYBQ=\n"

    .line 280
    .line 281
    invoke-static {v6, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 282
    .line 283
    .line 284
    move-result-object v6

    .line 285
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 286
    .line 287
    .line 288
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 289
    .line 290
    .line 291
    move-result-object p1

    .line 292
    check-cast p1, Ljava/lang/String;

    .line 293
    .line 294
    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 295
    .line 296
    .line 297
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 298
    .line 299
    .line 300
    move-result-object p1

    .line 301
    sget-boolean v5, Lorg/bitspark/android/utils/m;->b:Z

    .line 302
    .line 303
    invoke-static {v1, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 304
    .line 305
    .line 306
    const-string p1, "Pw==\n"

    .line 307
    .line 308
    const-string v1, "DQqJblo5ns0=\n"

    .line 309
    .line 310
    invoke-static {p1, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 311
    .line 312
    .line 313
    move-result-object p1

    .line 314
    invoke-static {v4, p1}, Lga/m;->a(Lga/m;Ljava/lang/String;)V

    .line 315
    .line 316
    .line 317
    invoke-static {v4}, Lga/m;->b(Lga/m;)Z

    .line 318
    .line 319
    .line 320
    move-result p1

    .line 321
    if-eqz p1, :cond_3

    .line 322
    .line 323
    invoke-virtual {v4}, Lga/m;->f()V

    .line 324
    .line 325
    .line 326
    goto/16 :goto_7

    .line 327
    .line 328
    :cond_3
    new-instance p1, Ljava/lang/StringBuilder;

    .line 329
    .line 330
    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 331
    .line 332
    .line 333
    iget-object v1, v4, Lga/m;->a:Landroid/content/Context;

    .line 334
    .line 335
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 336
    .line 337
    .line 338
    move-result-object v1

    .line 339
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 340
    .line 341
    .line 342
    const-string v1, "bQ==\n"

    .line 343
    .line 344
    const-string v3, "Xy0oxgoPqzE=\n"

    .line 345
    .line 346
    invoke-static {v1, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 347
    .line 348
    .line 349
    move-result-object v1

    .line 350
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 351
    .line 352
    .line 353
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 354
    .line 355
    .line 356
    move-result-object p1

    .line 357
    invoke-static {v0, p1}, Lorg/bitspark/android/Spark;->t0(ILjava/lang/String;)V

    .line 358
    .line 359
    .line 360
    sget-object p1, Lea/g;->a:Ljava/lang/String;

    .line 361
    .line 362
    invoke-static {p1}, Lorg/bitspark/android/utils/m;->l(Ljava/lang/String;)V

    .line 363
    .line 364
    .line 365
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 366
    .line 367
    invoke-virtual {p1, v2}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 368
    .line 369
    .line 370
    const-string p1, "3w==\n"

    .line 371
    .line 372
    const-string v0, "7QuZWysXn/4=\n"

    .line 373
    .line 374
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 375
    .line 376
    .line 377
    move-result-object p1

    .line 378
    invoke-static {v4, p1}, Lga/m;->c(Lga/m;Ljava/lang/String;)V

    .line 379
    .line 380
    .line 381
    goto/16 :goto_7

    .line 382
    .line 383
    :cond_4
    const-string v1, "9xE7l1sj\n"

    .line 384
    .line 385
    const-string v5, "tUJu5D5RfZY=\n"

    .line 386
    .line 387
    invoke-static {v1, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 388
    .line 389
    .line 390
    move-result-object v1

    .line 391
    new-instance v5, Ljava/lang/StringBuilder;

    .line 392
    .line 393
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 394
    .line 395
    .line 396
    const-string v6, "RO2ldWrFf1kD7qM6ZpB4VFH+tCcr32ARDrbx\n"

    .line 397
    .line 398
    const-string v7, "I4jRVQuwCzE=\n"

    .line 399
    .line 400
    invoke-static {v6, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 401
    .line 402
    .line 403
    move-result-object v6

    .line 404
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 405
    .line 406
    .line 407
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 408
    .line 409
    .line 410
    move-result-object v6

    .line 411
    check-cast v6, Ljava/lang/String;

    .line 412
    .line 413
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 414
    .line 415
    .line 416
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 417
    .line 418
    .line 419
    move-result-object v5

    .line 420
    sget-boolean v6, Lorg/bitspark/android/utils/m;->b:Z

    .line 421
    .line 422
    invoke-static {v1, v5}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 423
    .line 424
    .line 425
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->headers()Lokhttp3/Headers;

    .line 426
    .line 427
    .line 428
    move-result-object v1

    .line 429
    const-string v5, "LKCoXA==\n"

    .line 430
    .line 431
    const-string v6, "aMHcOaUPvTI=\n"

    .line 432
    .line 433
    invoke-static {v5, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 434
    .line 435
    .line 436
    move-result-object v5

    .line 437
    invoke-virtual {v1, v5}, Lokhttp3/Headers;->get(Ljava/lang/String;)Ljava/lang/String;

    .line 438
    .line 439
    .line 440
    move-result-object v1

    .line 441
    const-string v5, "Aswm7LJM\n"

    .line 442
    .line 443
    const-string v6, "QJ9zn9c+JVE=\n"

    .line 444
    .line 445
    invoke-static {v5, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 446
    .line 447
    .line 448
    move-result-object v5

    .line 449
    new-instance v6, Ljava/lang/StringBuilder;

    .line 450
    .line 451
    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 452
    .line 453
    .line 454
    const-string v7, "G0JrxaOxMdghSnyJ5g==\n"

    .line 455
    .line 456
    const-string v8, "SCcZs8bDEaw=\n"

    .line 457
    .line 458
    invoke-static {v7, v8}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 459
    .line 460
    .line 461
    move-result-object v7

    .line 462
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 463
    .line 464
    .line 465
    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 466
    .line 467
    .line 468
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 469
    .line 470
    .line 471
    move-result-object v6

    .line 472
    invoke-static {v5, v6}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 473
    .line 474
    .line 475
    if-eqz v1, :cond_6

    .line 476
    .line 477
    new-instance v5, Ljava/text/SimpleDateFormat;

    .line 478
    .line 479
    const-string v6, "/OlXlC+GQqX04V+Ydptf/JnkWoJijxz2yoxo\n"

    .line 480
    .line 481
    const-string v7, "uawSuA/iJoU=\n"

    .line 482
    .line 483
    invoke-static {v6, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 484
    .line 485
    .line 486
    move-result-object v6

    .line 487
    sget-object v7, Ljava/util/Locale;->US:Ljava/util/Locale;

    .line 488
    .line 489
    invoke-direct {v5, v6, v7}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 490
    .line 491
    .line 492
    new-instance v6, Ljava/text/SimpleDateFormat;

    .line 493
    .line 494
    const-string v7, "8IDMUyiZ8f/4iKkGcYSokv2NsxJlx6LBlZ8=\n"

    .line 495
    .line 496
    const-string v8, "tcWJfwj90bI=\n"

    .line 497
    .line 498
    invoke-static {v7, v8}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 499
    .line 500
    .line 501
    move-result-object v7

    .line 502
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    .line 503
    .line 504
    .line 505
    move-result-object v8

    .line 506
    invoke-direct {v6, v7, v8}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 507
    .line 508
    .line 509
    :try_start_2
    invoke-virtual {v5, v1}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    .line 510
    .line 511
    .line 512
    move-result-object v1

    .line 513
    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    .line 514
    .line 515
    .line 516
    move-result-wide v7

    .line 517
    sput-wide v7, Lga/m;->d:J

    .line 518
    .line 519
    const-string v1, "ffeuFnab\n"

    .line 520
    .line 521
    const-string v5, "P6T7ZRPp90g=\n"

    .line 522
    .line 523
    invoke-static {v1, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 524
    .line 525
    .line 526
    move-result-object v1

    .line 527
    new-instance v5, Ljava/lang/StringBuilder;

    .line 528
    .line 529
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 530
    .line 531
    .line 532
    const-string v7, "DNeV56bk9Ao2w4Op4w==\n"

    .line 533
    .line 534
    const-string v8, "X67mk8OJ1H4=\n"

    .line 535
    .line 536
    invoke-static {v7, v8}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 537
    .line 538
    .line 539
    move-result-object v7

    .line 540
    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 541
    .line 542
    .line 543
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 544
    .line 545
    .line 546
    move-result-wide v7

    .line 547
    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 548
    .line 549
    .line 550
    move-result-object v7

    .line 551
    invoke-virtual {v6, v7}, Ljava/text/Format;->format(Ljava/lang/Object;)Ljava/lang/String;

    .line 552
    .line 553
    .line 554
    move-result-object v6

    .line 555
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 556
    .line 557
    .line 558
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 559
    .line 560
    .line 561
    move-result-object v5

    .line 562
    invoke-static {v1, v5}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 563
    .line 564
    .line 565
    sget-wide v5, Lga/m;->d:J

    .line 566
    .line 567
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 568
    .line 569
    .line 570
    move-result-wide v7

    .line 571
    sub-long/2addr v5, v7

    .line 572
    invoke-static {v5, v6}, Ljava/lang/Math;->abs(J)J

    .line 573
    .line 574
    .line 575
    move-result-wide v5

    .line 576
    const-wide/32 v7, 0x927c0

    .line 577
    .line 578
    .line 579
    cmp-long v1, v5, v7

    .line 580
    .line 581
    if-lez v1, :cond_6

    .line 582
    .line 583
    sget-wide v5, Lga/m;->d:J

    .line 584
    .line 585
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 586
    .line 587
    .line 588
    move-result-wide v7

    .line 589
    sub-long/2addr v5, v7

    .line 590
    sput-wide v5, Lorg/bitspark/android/utils/m;->a:J

    .line 591
    .line 592
    const-string v1, "smWdPPUB\n"

    .line 593
    .line 594
    const-string v5, "8DbIT5Bz378=\n"

    .line 595
    .line 596
    invoke-static {v1, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 597
    .line 598
    .line 599
    move-result-object v1

    .line 600
    new-instance v5, Ljava/lang/StringBuilder;

    .line 601
    .line 602
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 603
    .line 604
    .line 605
    const-string v6, "FGOMaBFAZbsdY/oc\n"

    .line 606
    .line 607
    const-string v7, "UCbAPFAfMfI=\n"

    .line 608
    .line 609
    invoke-static {v6, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 610
    .line 611
    .line 612
    move-result-object v6

    .line 613
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 614
    .line 615
    .line 616
    sget-wide v6, Lorg/bitspark/android/utils/m;->a:J

    .line 617
    .line 618
    const-wide/16 v8, 0x3e8

    .line 619
    .line 620
    div-long/2addr v6, v8

    .line 621
    long-to-int v7, v6

    .line 622
    int-to-long v6, v7

    .line 623
    invoke-static {v6, v7}, Lorg/bitspark/android/utils/m;->q(J)Ljava/lang/String;

    .line 624
    .line 625
    .line 626
    move-result-object v6

    .line 627
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 628
    .line 629
    .line 630
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 631
    .line 632
    .line 633
    move-result-object v5

    .line 634
    invoke-static {v1, v5}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/text/ParseException; {:try_start_2 .. :try_end_2} :catch_1

    .line 635
    .line 636
    .line 637
    goto/16 :goto_6

    .line 638
    .line 639
    :catch_1
    const-string v1, "e9t5P0Eu\n"

    .line 640
    .line 641
    const-string v5, "OYgsTCRchqA=\n"

    .line 642
    .line 643
    invoke-static {v1, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 644
    .line 645
    .line 646
    move-result-object v1

    .line 647
    new-instance v5, Ljava/lang/StringBuilder;

    .line 648
    .line 649
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 650
    .line 651
    .line 652
    const-string v6, "dKwPibiVgylo+HysuoSVP166P5mrgo81deI=\n"

    .line 653
    .line 654
    const-string v7, "G8Jc/Nv25lo=\n"

    .line 655
    .line 656
    invoke-static {v6, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 657
    .line 658
    .line 659
    move-result-object v6

    .line 660
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 661
    .line 662
    .line 663
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->headers()Lokhttp3/Headers;

    .line 664
    .line 665
    .line 666
    move-result-object v6

    .line 667
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 668
    .line 669
    .line 670
    const-string v6, "GwOG\n"

    .line 671
    .line 672
    const-string v7, "Ni6rJyMNVD8=\n"

    .line 673
    .line 674
    invoke-static {v6, v7}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 675
    .line 676
    .line 677
    move-result-object v6

    .line 678
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 679
    .line 680
    .line 681
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 682
    .line 683
    .line 684
    move-result-object p1

    .line 685
    check-cast p1, Ljava/lang/String;

    .line 686
    .line 687
    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 688
    .line 689
    .line 690
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 691
    .line 692
    .line 693
    move-result-object p1

    .line 694
    invoke-static {v1, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 695
    .line 696
    .line 697
    const-string p1, "lw==\n"

    .line 698
    .line 699
    const-string v1, "pOmTjO8fjOE=\n"

    .line 700
    .line 701
    invoke-static {p1, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 702
    .line 703
    .line 704
    move-result-object p1

    .line 705
    invoke-static {v4, p1}, Lga/m;->a(Lga/m;Ljava/lang/String;)V

    .line 706
    .line 707
    .line 708
    invoke-static {v4}, Lga/m;->b(Lga/m;)Z

    .line 709
    .line 710
    .line 711
    move-result p1

    .line 712
    if-eqz p1, :cond_5

    .line 713
    .line 714
    invoke-virtual {v4}, Lga/m;->f()V

    .line 715
    .line 716
    .line 717
    goto :goto_7

    .line 718
    :cond_5
    new-instance p1, Ljava/lang/StringBuilder;

    .line 719
    .line 720
    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 721
    .line 722
    .line 723
    iget-object v1, v4, Lga/m;->a:Landroid/content/Context;

    .line 724
    .line 725
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 726
    .line 727
    .line 728
    move-result-object v1

    .line 729
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 730
    .line 731
    .line 732
    const-string v1, "Qg==\n"

    .line 733
    .line 734
    const-string v3, "cdYxcLfHUlA=\n"

    .line 735
    .line 736
    invoke-static {v1, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 737
    .line 738
    .line 739
    move-result-object v1

    .line 740
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 741
    .line 742
    .line 743
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 744
    .line 745
    .line 746
    move-result-object p1

    .line 747
    invoke-static {v0, p1}, Lorg/bitspark/android/Spark;->t0(ILjava/lang/String;)V

    .line 748
    .line 749
    .line 750
    sget-object p1, Lea/g;->a:Ljava/lang/String;

    .line 751
    .line 752
    invoke-static {p1}, Lorg/bitspark/android/utils/m;->l(Ljava/lang/String;)V

    .line 753
    .line 754
    .line 755
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 756
    .line 757
    invoke-virtual {p1, v2}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 758
    .line 759
    .line 760
    const-string p1, "gg==\n"

    .line 761
    .line 762
    const-string v0, "saPqZ1bTPUk=\n"

    .line 763
    .line 764
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 765
    .line 766
    .line 767
    move-result-object p1

    .line 768
    invoke-static {v4, p1}, Lga/m;->c(Lga/m;Ljava/lang/String;)V

    .line 769
    .line 770
    .line 771
    goto :goto_7

    .line 772
    :cond_6
    :goto_6
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 773
    .line 774
    .line 775
    move-result-object v0

    .line 776
    check-cast v0, Ljava/lang/String;

    .line 777
    .line 778
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->code()I

    .line 779
    .line 780
    .line 781
    move-result p1

    .line 782
    invoke-static {v4, v0, p1}, Lga/m;->d(Lga/m;Ljava/lang/String;I)V

    .line 783
    .line 784
    .line 785
    const-string p1, "Rg==\n"

    .line 786
    .line 787
    const-string v0, "ds2HGvLGp8M=\n"

    .line 788
    .line 789
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 790
    .line 791
    .line 792
    move-result-object p1

    .line 793
    new-instance v0, Ljava/lang/StringBuilder;

    .line 794
    .line 795
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 796
    .line 797
    .line 798
    const-string v1, "jT1q34c0kbGCN37F00c=\n"

    .line 799
    .line 800
    const-string v2, "4VINtuln5NI=\n"

    .line 801
    .line 802
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 803
    .line 804
    .line 805
    move-result-object v1

    .line 806
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 807
    .line 808
    .line 809
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 810
    .line 811
    .line 812
    const-string p1, "+rBCnQ==\n"

    .line 813
    .line 814
    const-string v1, "2p1vvayVkx8=\n"

    .line 815
    .line 816
    invoke-static {p1, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 817
    .line 818
    .line 819
    move-result-object p1

    .line 820
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 821
    .line 822
    .line 823
    iget p1, v4, Lga/m;->b:I

    .line 824
    .line 825
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 826
    .line 827
    .line 828
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 829
    .line 830
    .line 831
    move-result-object p1

    .line 832
    sget-object v0, Lga/m;->c:Ljava/lang/String;

    .line 833
    .line 834
    invoke-static {v0, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 835
    .line 836
    .line 837
    const/4 p1, 0x0

    .line 838
    iput p1, v4, Lga/m;->b:I

    .line 839
    .line 840
    :goto_7
    return-void

    .line 841
    :pswitch_2
    const-string v1, "R0hi+UYa6Jlp\n"

    .line 842
    .line 843
    const-string v2, "BRshkSd0hvw=\n"

    .line 844
    .line 845
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 846
    .line 847
    .line 848
    move-result-object v1

    .line 849
    const-string v2, "5fpjzKPpEMbs+nvMpvMexaLscp625AOI7fQ=\n"

    .line 850
    .line 851
    const-string v3, "gp8X7MCBcag=\n"

    .line 852
    .line 853
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 854
    .line 855
    .line 856
    move-result-object v2

    .line 857
    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 858
    .line 859
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 860
    .line 861
    .line 862
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 863
    .line 864
    .line 865
    move-result-object v1

    .line 866
    check-cast v1, Ljava/lang/String;

    .line 867
    .line 868
    iget-object v2, p0, Lga/c;->b:Ljava/lang/Object;

    .line 869
    .line 870
    check-cast v2, Lga/d;

    .line 871
    .line 872
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 873
    .line 874
    .line 875
    new-instance v2, Lcom/tencent/bugly/proguard/i0;

    .line 876
    .line 877
    invoke-direct {v2, v0, v1}, Lcom/tencent/bugly/proguard/i0;-><init>(ILjava/lang/Object;)V

    .line 878
    .line 879
    .line 880
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 881
    .line 882
    .line 883
    sget-object v0, Lorg/bitspark/android/Spark;->d2:Lda/c;

    .line 884
    .line 885
    const-string v1, "ESHco+txmQ==\n"

    .line 886
    .line 887
    const-string v2, "ckm9zYUU9WI=\n"

    .line 888
    .line 889
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 890
    .line 891
    .line 892
    move-result-object v1

    .line 893
    invoke-virtual {v0, v1}, Lda/c;->g(Ljava/lang/String;)V

    .line 894
    .line 895
    .line 896
    sget-object v0, Lorg/bitspark/android/Spark;->d2:Lda/c;

    .line 897
    .line 898
    const-string v1, "TyEJqw0Xvw==\n"

    .line 899
    .line 900
    const-string v2, "LEloxWNy0xk=\n"

    .line 901
    .line 902
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 903
    .line 904
    .line 905
    move-result-object v1

    .line 906
    invoke-virtual {p1}, Lcom/lzy/okgo/model/Response;->body()Ljava/lang/Object;

    .line 907
    .line 908
    .line 909
    move-result-object p1

    .line 910
    check-cast p1, Ljava/lang/String;

    .line 911
    .line 912
    sget v2, Lea/h;->g:I

    .line 913
    .line 914
    div-int/lit16 v2, v2, 0x3e8

    .line 915
    .line 916
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 917
    .line 918
    .line 919
    new-instance v3, Ljava/lang/StringBuilder;

    .line 920
    .line 921
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 922
    .line 923
    .line 924
    invoke-static {v2}, Lo9/e;->n(I)Ljava/lang/String;

    .line 925
    .line 926
    .line 927
    move-result-object v2

    .line 928
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 929
    .line 930
    .line 931
    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 932
    .line 933
    .line 934
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 935
    .line 936
    .line 937
    move-result-object p1

    .line 938
    new-instance v2, Lda/a;

    .line 939
    .line 940
    invoke-direct {v2, v0, v1, p1}, Lda/a;-><init>(Lda/c;Ljava/lang/String;Ljava/lang/String;)V

    .line 941
    .line 942
    .line 943
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 944
    .line 945
    .line 946
    return-void

    .line 947
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
