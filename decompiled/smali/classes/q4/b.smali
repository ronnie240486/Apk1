.class public final Lq4/b;
.super Ljava/lang/Object;
.source "MyApplication"


# static fields
.field public static final k:Lv4/b;

.field public static final l:Ljava/lang/Object;

.field public static volatile m:Lq4/b;


# instance fields
.field public final a:Landroid/content/Context;

.field public final b:Lq4/n;

.field public final c:Lq4/h;

.field public final d:Lq4/k;

.field public final e:Lcom/google/android/gms/cast/framework/CastOptions;

.field public final f:Lv4/r;

.field public final g:Lcom/google/android/gms/internal/cast/h;

.field public final h:Lcom/google/android/gms/internal/cast/t;

.field public final i:Lcom/google/android/gms/internal/cast/y;

.field public final j:Lcom/google/android/gms/internal/cast/j;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lv4/b;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    const-string v2, "CastContext"

    .line 5
    .line 6
    invoke-direct {v0, v2, v1}, Lv4/b;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 7
    .line 8
    .line 9
    sput-object v0, Lq4/b;->k:Lv4/b;

    .line 10
    .line 11
    new-instance v0, Ljava/lang/Object;

    .line 12
    .line 13
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 14
    .line 15
    .line 16
    sput-object v0, Lq4/b;->l:Ljava/lang/Object;

    .line 17
    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/cast/framework/CastOptions;Ljava/util/List;Lcom/google/android/gms/internal/cast/v;Lv4/r;)V
    .locals 9

    .line 1
    const/4 v0, 0x1

    .line 2
    const/4 v1, 0x0

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object p1, p0, Lq4/b;->a:Landroid/content/Context;

    .line 7
    .line 8
    iput-object p2, p0, Lq4/b;->e:Lcom/google/android/gms/cast/framework/CastOptions;

    .line 9
    .line 10
    iput-object p5, p0, Lq4/b;->f:Lv4/r;

    .line 11
    .line 12
    new-instance v2, Lcom/google/android/gms/internal/cast/t;

    .line 13
    .line 14
    invoke-direct {v2, p1}, Lcom/google/android/gms/internal/cast/t;-><init>(Landroid/content/Context;)V

    .line 15
    .line 16
    .line 17
    iput-object v2, p0, Lq4/b;->h:Lcom/google/android/gms/internal/cast/t;

    .line 18
    .line 19
    iget-object v2, p4, Lcom/google/android/gms/internal/cast/v;->h:Lcom/google/android/gms/internal/cast/y;

    .line 20
    .line 21
    iput-object v2, p0, Lq4/b;->i:Lcom/google/android/gms/internal/cast/y;

    .line 22
    .line 23
    iget-object v2, p2, Lcom/google/android/gms/cast/framework/CastOptions;->a:Ljava/lang/String;

    .line 24
    .line 25
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    .line 26
    .line 27
    .line 28
    move-result v2

    .line 29
    const/4 v3, 0x0

    .line 30
    if-nez v2, :cond_0

    .line 31
    .line 32
    new-instance v2, Lcom/google/android/gms/internal/cast/j;

    .line 33
    .line 34
    invoke-direct {v2, p1, p2, p4}, Lcom/google/android/gms/internal/cast/j;-><init>(Landroid/content/Context;Lcom/google/android/gms/cast/framework/CastOptions;Lcom/google/android/gms/internal/cast/v;)V

    .line 35
    .line 36
    .line 37
    iput-object v2, p0, Lq4/b;->j:Lcom/google/android/gms/internal/cast/j;

    .line 38
    .line 39
    goto :goto_0

    .line 40
    :cond_0
    iput-object v3, p0, Lq4/b;->j:Lcom/google/android/gms/internal/cast/j;

    .line 41
    .line 42
    :goto_0
    new-instance v2, Ljava/util/HashMap;

    .line 43
    .line 44
    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 45
    .line 46
    .line 47
    iget-object v4, p0, Lq4/b;->j:Lcom/google/android/gms/internal/cast/j;

    .line 48
    .line 49
    if-eqz v4, :cond_1

    .line 50
    .line 51
    iget-object v5, v4, Lcom/google/android/gms/internal/cast/j;->b:Ljava/lang/String;

    .line 52
    .line 53
    iget-object v4, v4, Lcom/google/android/gms/internal/cast/j;->c:Lq4/j;

    .line 54
    .line 55
    invoke-virtual {v2, v5, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    .line 57
    .line 58
    :cond_1
    if-eqz p3, :cond_3

    .line 59
    .line 60
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 61
    .line 62
    .line 63
    move-result-object p3

    .line 64
    :goto_1
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    .line 65
    .line 66
    .line 67
    move-result v4

    .line 68
    if-eqz v4, :cond_3

    .line 69
    .line 70
    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 71
    .line 72
    .line 73
    move-result-object v4

    .line 74
    check-cast v4, Lcom/google/android/gms/internal/cast/j;

    .line 75
    .line 76
    const-string v5, "Additional SessionProvider must not be null."

    .line 77
    .line 78
    invoke-static {v4, v5}, Lb5/l;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 79
    .line 80
    .line 81
    const-string v5, "Category for SessionProvider must not be null or empty string."

    .line 82
    .line 83
    iget-object v6, v4, Lcom/google/android/gms/internal/cast/j;->b:Ljava/lang/String;

    .line 84
    .line 85
    invoke-static {v6, v5}, Lb5/l;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    .line 87
    .line 88
    invoke-virtual {v2, v6}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    .line 89
    .line 90
    .line 91
    move-result v5

    .line 92
    const-string v7, "SessionProvider for category "

    .line 93
    .line 94
    const-string v8, " already added"

    .line 95
    .line 96
    invoke-static {v7, v6, v8}, La/e;->r(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 97
    .line 98
    .line 99
    move-result-object v7

    .line 100
    if-nez v5, :cond_2

    .line 101
    .line 102
    iget-object v4, v4, Lcom/google/android/gms/internal/cast/j;->c:Lq4/j;

    .line 103
    .line 104
    invoke-virtual {v2, v6, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    .line 106
    .line 107
    goto :goto_1

    .line 108
    :cond_2
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 109
    .line 110
    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    .line 111
    .line 112
    .line 113
    move-result-object p2

    .line 114
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 115
    .line 116
    .line 117
    throw p1

    .line 118
    :cond_3
    new-instance p3, Lcom/google/android/gms/cast/framework/zzl;

    .line 119
    .line 120
    invoke-direct {p3, v0}, Lcom/google/android/gms/cast/framework/zzl;-><init>(I)V

    .line 121
    .line 122
    .line 123
    iput-object p3, p2, Lcom/google/android/gms/cast/framework/CastOptions;->p:Lcom/google/android/gms/cast/framework/zzl;

    .line 124
    .line 125
    :try_start_0
    invoke-static {p1, p2, p4, v2}, Lcom/google/android/gms/internal/cast/i;->a(Landroid/content/Context;Lcom/google/android/gms/cast/framework/CastOptions;Lcom/google/android/gms/internal/cast/v;Ljava/util/HashMap;)Lq4/n;

    .line 126
    .line 127
    .line 128
    move-result-object p3
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_3

    .line 129
    iput-object p3, p0, Lq4/b;->b:Lq4/n;

    .line 130
    .line 131
    :try_start_1
    move-object p4, p3

    .line 132
    check-cast p4, Lq4/l;

    .line 133
    .line 134
    invoke-virtual {p4}, Lcom/google/android/gms/internal/cast/a;->l()Landroid/os/Parcel;

    .line 135
    .line 136
    .line 137
    move-result-object v2

    .line 138
    const/4 v4, 0x6

    .line 139
    invoke-virtual {p4, v2, v4}, Lcom/google/android/gms/internal/cast/a;->w(Landroid/os/Parcel;I)Landroid/os/Parcel;

    .line 140
    .line 141
    .line 142
    move-result-object p4

    .line 143
    invoke-virtual {p4}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    .line 144
    .line 145
    .line 146
    move-result-object v2

    .line 147
    if-nez v2, :cond_4

    .line 148
    .line 149
    move-object v5, v3

    .line 150
    goto :goto_2

    .line 151
    :cond_4
    const-string v4, "com.google.android.gms.cast.framework.IDiscoveryManager"

    .line 152
    .line 153
    invoke-interface {v2, v4}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    .line 154
    .line 155
    .line 156
    move-result-object v5

    .line 157
    instance-of v6, v5, Lq4/r;

    .line 158
    .line 159
    if-eqz v6, :cond_5

    .line 160
    .line 161
    check-cast v5, Lq4/r;

    .line 162
    .line 163
    goto :goto_2

    .line 164
    :cond_5
    new-instance v5, Lq4/r;

    .line 165
    .line 166
    invoke-direct {v5, v2, v4, v1}, Lcom/google/android/gms/internal/cast/a;-><init>(Landroid/os/IBinder;Ljava/lang/String;I)V

    .line 167
    .line 168
    .line 169
    :goto_2
    invoke-virtual {p4}, Landroid/os/Parcel;->recycle()V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_2

    .line 170
    .line 171
    .line 172
    new-instance p4, Lq4/k;

    .line 173
    .line 174
    invoke-direct {p4, v5}, Lq4/k;-><init>(Lq4/r;)V

    .line 175
    .line 176
    .line 177
    iput-object p4, p0, Lq4/b;->d:Lq4/k;

    .line 178
    .line 179
    :try_start_2
    move-object p4, p3

    .line 180
    check-cast p4, Lq4/l;

    .line 181
    .line 182
    invoke-virtual {p4}, Lcom/google/android/gms/internal/cast/a;->l()Landroid/os/Parcel;

    .line 183
    .line 184
    .line 185
    move-result-object v2

    .line 186
    const/4 v4, 0x5

    .line 187
    invoke-virtual {p4, v2, v4}, Lcom/google/android/gms/internal/cast/a;->w(Landroid/os/Parcel;I)Landroid/os/Parcel;

    .line 188
    .line 189
    .line 190
    move-result-object p4

    .line 191
    invoke-virtual {p4}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    .line 192
    .line 193
    .line 194
    move-result-object v2

    .line 195
    if-nez v2, :cond_6

    .line 196
    .line 197
    goto :goto_3

    .line 198
    :cond_6
    const-string v3, "com.google.android.gms.cast.framework.ISessionManager"

    .line 199
    .line 200
    invoke-interface {v2, v3}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    .line 201
    .line 202
    .line 203
    move-result-object v4

    .line 204
    instance-of v5, v4, Lq4/y;

    .line 205
    .line 206
    if-eqz v5, :cond_7

    .line 207
    .line 208
    move-object v3, v4

    .line 209
    check-cast v3, Lq4/y;

    .line 210
    .line 211
    goto :goto_3

    .line 212
    :cond_7
    new-instance v4, Lq4/y;

    .line 213
    .line 214
    invoke-direct {v4, v2, v3, v1}, Lcom/google/android/gms/internal/cast/a;-><init>(Landroid/os/IBinder;Ljava/lang/String;I)V

    .line 215
    .line 216
    .line 217
    move-object v3, v4

    .line 218
    :goto_3
    invoke-virtual {p4}, Landroid/os/Parcel;->recycle()V
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_1

    .line 219
    .line 220
    .line 221
    new-instance p4, Lq4/h;

    .line 222
    .line 223
    invoke-direct {p4, v3, p1}, Lq4/h;-><init>(Lq4/y;Landroid/content/Context;)V

    .line 224
    .line 225
    .line 226
    iput-object p4, p0, Lq4/b;->c:Lq4/h;

    .line 227
    .line 228
    const-string v2, "The log tag cannot be null or empty."

    .line 229
    .line 230
    const-string v3, "PrecacheManager"

    .line 231
    .line 232
    invoke-static {v3, v2}, Lb5/l;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    .line 234
    .line 235
    iget-object v2, p0, Lq4/b;->i:Lcom/google/android/gms/internal/cast/y;

    .line 236
    .line 237
    if-eqz v2, :cond_8

    .line 238
    .line 239
    iput-object p4, v2, Lcom/google/android/gms/internal/cast/y;->f:Lq4/h;

    .line 240
    .line 241
    iget-object p4, v2, Lcom/google/android/gms/internal/cast/y;->c:Lcom/google/android/gms/internal/cast/y0;

    .line 242
    .line 243
    invoke-static {p4}, Lb5/l;->e(Ljava/lang/Object;)V

    .line 244
    .line 245
    .line 246
    new-instance v3, Lcom/google/android/gms/internal/cast/x;

    .line 247
    .line 248
    invoke-direct {v3, v2, v0}, Lcom/google/android/gms/internal/cast/x;-><init>(Lcom/google/android/gms/internal/cast/y;I)V

    .line 249
    .line 250
    .line 251
    invoke-virtual {p4, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 252
    .line 253
    .line 254
    :cond_8
    sget p4, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 255
    .line 256
    const/16 v2, 0x17

    .line 257
    .line 258
    const/4 v3, 0x3

    .line 259
    if-lt p4, v2, :cond_b

    .line 260
    .line 261
    new-instance p4, Lcom/google/android/gms/internal/cast/s0;

    .line 262
    .line 263
    invoke-static {v3}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    .line 264
    .line 265
    .line 266
    move-result-object v2

    .line 267
    instance-of v4, v2, Lcom/google/android/gms/internal/cast/q6;

    .line 268
    .line 269
    if-eqz v4, :cond_9

    .line 270
    .line 271
    check-cast v2, Lcom/google/android/gms/internal/cast/q6;

    .line 272
    .line 273
    goto :goto_5

    .line 274
    :cond_9
    instance-of v4, v2, Ljava/util/concurrent/ScheduledExecutorService;

    .line 275
    .line 276
    if-eqz v4, :cond_a

    .line 277
    .line 278
    new-instance v4, Lcom/google/android/gms/internal/cast/u6;

    .line 279
    .line 280
    check-cast v2, Ljava/util/concurrent/ScheduledExecutorService;

    .line 281
    .line 282
    invoke-direct {v4, v2}, Lcom/google/android/gms/internal/cast/u6;-><init>(Ljava/util/concurrent/ScheduledExecutorService;)V

    .line 283
    .line 284
    .line 285
    :goto_4
    move-object v2, v4

    .line 286
    goto :goto_5

    .line 287
    :cond_a
    new-instance v4, Lcom/google/android/gms/internal/cast/r6;

    .line 288
    .line 289
    invoke-direct {v4, v2}, Lcom/google/android/gms/internal/cast/r6;-><init>(Ljava/util/concurrent/ExecutorService;)V

    .line 290
    .line 291
    .line 292
    goto :goto_4

    .line 293
    :goto_5
    invoke-direct {p4, p1, v2}, Lcom/google/android/gms/internal/cast/s0;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/cast/q6;)V

    .line 294
    .line 295
    .line 296
    goto :goto_6

    .line 297
    :cond_b
    new-instance p4, Lcom/google/android/gms/internal/cast/q2;

    .line 298
    .line 299
    const/16 p1, 0x12

    .line 300
    .line 301
    invoke-direct {p4, p1}, Lcom/google/android/gms/internal/cast/q2;-><init>(I)V

    .line 302
    .line 303
    .line 304
    :goto_6
    const-string p1, "BaseNetUtils"

    .line 305
    .line 306
    const-string v2, "The log tag cannot be null or empty."

    .line 307
    .line 308
    invoke-static {p1, v2}, Lb5/l;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 309
    .line 310
    .line 311
    invoke-interface {p4}, Lcom/google/android/gms/internal/cast/q0;->a()V

    .line 312
    .line 313
    .line 314
    new-instance p1, Lcom/google/android/gms/internal/cast/h;

    .line 315
    .line 316
    invoke-direct {p1}, Lcom/google/android/gms/internal/cast/h;-><init>()V

    .line 317
    .line 318
    .line 319
    iput-object p1, p0, Lq4/b;->g:Lcom/google/android/gms/internal/cast/h;

    .line 320
    .line 321
    :try_start_3
    check-cast p3, Lq4/l;

    .line 322
    .line 323
    invoke-virtual {p3}, Lcom/google/android/gms/internal/cast/a;->l()Landroid/os/Parcel;

    .line 324
    .line 325
    .line 326
    move-result-object p4

    .line 327
    invoke-static {p4, p1}, Lcom/google/android/gms/internal/cast/e0;->d(Landroid/os/Parcel;Landroid/os/IInterface;)V

    .line 328
    .line 329
    .line 330
    invoke-virtual {p3, p4, v3}, Lcom/google/android/gms/internal/cast/a;->x(Landroid/os/Parcel;I)V
    :try_end_3
    .catch Landroid/os/RemoteException; {:try_start_3 .. :try_end_3} :catch_0

    .line 331
    .line 332
    .line 333
    iget-object p3, p0, Lq4/b;->h:Lcom/google/android/gms/internal/cast/t;

    .line 334
    .line 335
    iget-object p3, p3, Lcom/google/android/gms/internal/cast/t;->a:Lcom/google/android/gms/internal/cast/s;

    .line 336
    .line 337
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/h;->e:Ljava/util/Set;

    .line 338
    .line 339
    invoke-interface {p1, p3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 340
    .line 341
    .line 342
    iget-object p1, p2, Lcom/google/android/gms/cast/framework/CastOptions;->l:Ljava/util/ArrayList;

    .line 343
    .line 344
    invoke-static {p1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    .line 345
    .line 346
    .line 347
    move-result-object p1

    .line 348
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    .line 349
    .line 350
    .line 351
    move-result p1

    .line 352
    if-nez p1, :cond_f

    .line 353
    .line 354
    sget-object p1, Lq4/b;->k:Lv4/b;

    .line 355
    .line 356
    iget-object p2, p0, Lq4/b;->e:Lcom/google/android/gms/cast/framework/CastOptions;

    .line 357
    .line 358
    iget-object p2, p2, Lcom/google/android/gms/cast/framework/CastOptions;->l:Ljava/util/ArrayList;

    .line 359
    .line 360
    invoke-static {p2}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    .line 361
    .line 362
    .line 363
    move-result-object p2

    .line 364
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    .line 365
    .line 366
    .line 367
    move-result-object p2

    .line 368
    new-array p3, v1, [Ljava/lang/Object;

    .line 369
    .line 370
    const-string p4, "Setting Route Discovery for appIds: "

    .line 371
    .line 372
    invoke-virtual {p4, p2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 373
    .line 374
    .line 375
    move-result-object p2

    .line 376
    iget-object p4, p1, Lv4/b;->a:Ljava/lang/String;

    .line 377
    .line 378
    invoke-virtual {p1, p2, p3}, Lv4/b;->d(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 379
    .line 380
    .line 381
    move-result-object p1

    .line 382
    invoke-static {p4, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 383
    .line 384
    .line 385
    iget-object p1, p0, Lq4/b;->h:Lcom/google/android/gms/internal/cast/t;

    .line 386
    .line 387
    iget-object p2, p0, Lq4/b;->e:Lcom/google/android/gms/cast/framework/CastOptions;

    .line 388
    .line 389
    iget-object p2, p2, Lcom/google/android/gms/cast/framework/CastOptions;->l:Ljava/util/ArrayList;

    .line 390
    .line 391
    invoke-static {p2}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    .line 392
    .line 393
    .line 394
    move-result-object p2

    .line 395
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 396
    .line 397
    .line 398
    sget-object p3, Lcom/google/android/gms/internal/cast/t;->f:Lv4/b;

    .line 399
    .line 400
    invoke-interface {p2}, Ljava/util/List;->size()I

    .line 401
    .line 402
    .line 403
    move-result p4

    .line 404
    const-string v2, "SetRouteDiscovery for "

    .line 405
    .line 406
    const-string v3, " IDs"

    .line 407
    .line 408
    invoke-static {p4, v2, v3}, Lea/q;->f(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 409
    .line 410
    .line 411
    move-result-object p4

    .line 412
    new-array v2, v1, [Ljava/lang/Object;

    .line 413
    .line 414
    invoke-virtual {p3, p4, v2}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 415
    .line 416
    .line 417
    new-instance p4, Ljava/util/LinkedHashSet;

    .line 418
    .line 419
    invoke-direct {p4}, Ljava/util/LinkedHashSet;-><init>()V

    .line 420
    .line 421
    .line 422
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 423
    .line 424
    .line 425
    move-result-object p2

    .line 426
    :goto_7
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    .line 427
    .line 428
    .line 429
    move-result v2

    .line 430
    if-eqz v2, :cond_c

    .line 431
    .line 432
    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 433
    .line 434
    .line 435
    move-result-object v2

    .line 436
    check-cast v2, Ljava/lang/String;

    .line 437
    .line 438
    invoke-static {v2}, Lcom/google/android/gms/internal/cast/a1;->f(Ljava/lang/String;)Ljava/lang/String;

    .line 439
    .line 440
    .line 441
    move-result-object v2

    .line 442
    invoke-virtual {p4, v2}, Ljava/util/AbstractCollection;->add(Ljava/lang/Object;)Z

    .line 443
    .line 444
    .line 445
    goto :goto_7

    .line 446
    :cond_c
    iget-object p2, p1, Lcom/google/android/gms/internal/cast/t;->c:Ljava/util/Map;

    .line 447
    .line 448
    invoke-interface {p2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    .line 449
    .line 450
    .line 451
    move-result-object v2

    .line 452
    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    .line 453
    .line 454
    .line 455
    move-result-object v2

    .line 456
    new-array v3, v1, [Ljava/lang/Object;

    .line 457
    .line 458
    const-string v4, "resetting routes. appIdToRouteInfo has these appId route keys: "

    .line 459
    .line 460
    invoke-virtual {v4, v2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 461
    .line 462
    .line 463
    move-result-object v2

    .line 464
    invoke-virtual {p3, v2, v3}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 465
    .line 466
    .line 467
    new-instance v2, Ljava/util/HashMap;

    .line 468
    .line 469
    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 470
    .line 471
    .line 472
    monitor-enter p2

    .line 473
    :try_start_4
    invoke-interface {p4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 474
    .line 475
    .line 476
    move-result-object v3

    .line 477
    :cond_d
    :goto_8
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    .line 478
    .line 479
    .line 480
    move-result v4

    .line 481
    if-eqz v4, :cond_e

    .line 482
    .line 483
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 484
    .line 485
    .line 486
    move-result-object v4

    .line 487
    check-cast v4, Ljava/lang/String;

    .line 488
    .line 489
    invoke-static {v4}, Lcom/google/android/gms/internal/cast/a1;->f(Ljava/lang/String;)Ljava/lang/String;

    .line 490
    .line 491
    .line 492
    move-result-object v5

    .line 493
    invoke-interface {p2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 494
    .line 495
    .line 496
    move-result-object v5

    .line 497
    check-cast v5, Lcom/google/android/gms/internal/cast/r;

    .line 498
    .line 499
    if-eqz v5, :cond_d

    .line 500
    .line 501
    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 502
    .line 503
    .line 504
    goto :goto_8

    .line 505
    :catchall_0
    move-exception p1

    .line 506
    goto :goto_9

    .line 507
    :cond_e
    invoke-interface {p2}, Ljava/util/Map;->clear()V

    .line 508
    .line 509
    .line 510
    invoke-interface {p2, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 511
    .line 512
    .line 513
    monitor-exit p2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 514
    invoke-interface {p2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    .line 515
    .line 516
    .line 517
    move-result-object p2

    .line 518
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    .line 519
    .line 520
    .line 521
    move-result-object p2

    .line 522
    new-array v2, v1, [Ljava/lang/Object;

    .line 523
    .line 524
    const-string v3, "Routes reset. appIdToRouteInfo has these appId route keys: "

    .line 525
    .line 526
    invoke-virtual {v3, p2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 527
    .line 528
    .line 529
    move-result-object p2

    .line 530
    invoke-virtual {p3, p2, v2}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 531
    .line 532
    .line 533
    iget-object p3, p1, Lcom/google/android/gms/internal/cast/t;->d:Ljava/util/LinkedHashSet;

    .line 534
    .line 535
    monitor-enter p3

    .line 536
    :try_start_5
    invoke-virtual {p3}, Ljava/util/AbstractCollection;->clear()V

    .line 537
    .line 538
    .line 539
    invoke-virtual {p3, p4}, Ljava/util/AbstractCollection;->addAll(Ljava/util/Collection;)Z

    .line 540
    .line 541
    .line 542
    monitor-exit p3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 543
    invoke-virtual {p1}, Lcom/google/android/gms/internal/cast/t;->o()V

    .line 544
    .line 545
    .line 546
    goto :goto_a

    .line 547
    :catchall_1
    move-exception p1

    .line 548
    :try_start_6
    monitor-exit p3
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 549
    throw p1

    .line 550
    :goto_9
    :try_start_7
    monitor-exit p2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 551
    throw p1

    .line 552
    :cond_f
    :goto_a
    const-string v2, "com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED"

    .line 553
    .line 554
    const-string v3, "com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE"

    .line 555
    .line 556
    const-string v4, "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE"

    .line 557
    .line 558
    const-string v5, "com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE"

    .line 559
    .line 560
    const-string v6, "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED"

    .line 561
    .line 562
    const-string v7, "com.google.android.gms.cast.FLAG_CLIENT_ANALYTICS_ENABLED"

    .line 563
    .line 564
    const-string v8, "com.google.android.gms.cast.FLAG_ANALYTICS_CONSENT_TIMEOUT_SECONDS"

    .line 565
    .line 566
    filled-new-array/range {v2 .. v8}, [Ljava/lang/String;

    .line 567
    .line 568
    .line 569
    move-result-object p1

    .line 570
    invoke-virtual {p5, p1}, Lv4/r;->d([Ljava/lang/String;)Lq4/d;

    .line 571
    .line 572
    .line 573
    move-result-object p1

    .line 574
    new-instance p2, Lq4/a0;

    .line 575
    .line 576
    invoke-direct {p2, p0, v1}, Lq4/a0;-><init>(Lq4/b;I)V

    .line 577
    .line 578
    .line 579
    invoke-virtual {p1, p2}, Lq4/d;->b(Lw5/c;)V

    .line 580
    .line 581
    .line 582
    const-string p1, "com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"

    .line 583
    .line 584
    filled-new-array {p1}, [Ljava/lang/String;

    .line 585
    .line 586
    .line 587
    move-result-object p1

    .line 588
    invoke-static {}, Lc6/c;->c()Lc6/c;

    .line 589
    .line 590
    .line 591
    move-result-object p2

    .line 592
    new-instance p3, Lv4/p;

    .line 593
    .line 594
    const/4 p4, 0x2

    .line 595
    invoke-direct {p3, p5, p1, p4}, Lv4/p;-><init>(Lv4/r;[Ljava/lang/String;I)V

    .line 596
    .line 597
    .line 598
    iput-object p3, p2, Lc6/c;->c:Ljava/lang/Object;

    .line 599
    .line 600
    new-array p1, v0, [Lcom/google/android/gms/common/Feature;

    .line 601
    .line 602
    sget-object p3, Lp4/j;->d:Lcom/google/android/gms/common/Feature;

    .line 603
    .line 604
    aput-object p3, p1, v1

    .line 605
    .line 606
    iput-object p1, p2, Lc6/c;->d:Ljava/lang/Object;

    .line 607
    .line 608
    iput-boolean v1, p2, Lc6/c;->b:Z

    .line 609
    .line 610
    const/16 p1, 0x20eb

    .line 611
    .line 612
    iput p1, p2, Lc6/c;->a:I

    .line 613
    .line 614
    invoke-virtual {p2}, Lc6/c;->b()Lc6/c;

    .line 615
    .line 616
    .line 617
    move-result-object p1

    .line 618
    invoke-virtual {p5, v1, p1}, Ly4/g;->c(ILc6/c;)Lq4/d;

    .line 619
    .line 620
    .line 621
    move-result-object p1

    .line 622
    new-instance p2, Lq4/a0;

    .line 623
    .line 624
    invoke-direct {p2, p0, v0}, Lq4/a0;-><init>(Lq4/b;I)V

    .line 625
    .line 626
    .line 627
    invoke-virtual {p1, p2}, Lq4/d;->b(Lw5/c;)V

    .line 628
    .line 629
    .line 630
    return-void

    .line 631
    :catch_0
    move-exception p1

    .line 632
    new-instance p2, Ljava/lang/IllegalStateException;

    .line 633
    .line 634
    const-string p3, "Failed to call addAppVisibilityListener"

    .line 635
    .line 636
    invoke-direct {p2, p3, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 637
    .line 638
    .line 639
    throw p2

    .line 640
    :catch_1
    move-exception p1

    .line 641
    new-instance p2, Ljava/lang/IllegalStateException;

    .line 642
    .line 643
    const-string p3, "Failed to call getSessionManagerImpl"

    .line 644
    .line 645
    invoke-direct {p2, p3, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 646
    .line 647
    .line 648
    throw p2

    .line 649
    :catch_2
    move-exception p1

    .line 650
    new-instance p2, Ljava/lang/IllegalStateException;

    .line 651
    .line 652
    const-string p3, "Failed to call getDiscoveryManagerImpl"

    .line 653
    .line 654
    invoke-direct {p2, p3, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 655
    .line 656
    .line 657
    throw p2

    .line 658
    :catch_3
    move-exception p1

    .line 659
    new-instance p2, Ljava/lang/IllegalStateException;

    .line 660
    .line 661
    const-string p3, "Failed to call newCastContextImpl"

    .line 662
    .line 663
    invoke-direct {p2, p3, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 664
    .line 665
    .line 666
    throw p2
.end method

.method public static b(Landroid/content/Context;)Lq4/b;
    .locals 8

    .line 1
    const-string v0, "Must be called from the main thread."

    .line 2
    .line 3
    invoke-static {v0}, Lb5/l;->b(Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    sget-object v0, Lq4/b;->m:Lq4/b;

    .line 7
    .line 8
    if-nez v0, :cond_1

    .line 9
    .line 10
    sget-object v0, Lq4/b;->l:Ljava/lang/Object;

    .line 11
    .line 12
    monitor-enter v0

    .line 13
    :try_start_0
    sget-object v1, Lq4/b;->m:Lq4/b;

    .line 14
    .line 15
    if-nez v1, :cond_0

    .line 16
    .line 17
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    .line 18
    .line 19
    .line 20
    move-result-object v3

    .line 21
    invoke-static {v3}, Lq4/b;->d(Landroid/content/Context;)Lorg/bitspark/android/utils/CastOptionsProvider;

    .line 22
    .line 23
    .line 24
    move-result-object p0

    .line 25
    invoke-virtual {p0, v3}, Lorg/bitspark/android/utils/CastOptionsProvider;->getCastOptions(Landroid/content/Context;)Lcom/google/android/gms/cast/framework/CastOptions;

    .line 26
    .line 27
    .line 28
    move-result-object v4

    .line 29
    new-instance v7, Lv4/r;

    .line 30
    .line 31
    sget-object v1, Ly4/b;->a0:Ly4/a;

    .line 32
    .line 33
    sget-object v2, Ly4/f;->c:Ly4/f;

    .line 34
    .line 35
    sget-object v5, Lv4/r;->j:Ll6/h;

    .line 36
    .line 37
    invoke-direct {v7, v3, v5, v1, v2}, Ly4/g;-><init>(Landroid/content/Context;Ll6/h;Ly4/b;Ly4/f;)V

    .line 38
    .line 39
    .line 40
    new-instance v6, Lcom/google/android/gms/internal/cast/v;

    .line 41
    .line 42
    invoke-static {v3}, Lq1/u0;->d(Landroid/content/Context;)Lq1/u0;

    .line 43
    .line 44
    .line 45
    move-result-object v1

    .line 46
    invoke-direct {v6, v3, v1, v4, v7}, Lcom/google/android/gms/internal/cast/v;-><init>(Landroid/content/Context;Lq1/u0;Lcom/google/android/gms/cast/framework/CastOptions;Lv4/r;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 47
    .line 48
    .line 49
    :try_start_1
    new-instance v1, Lq4/b;

    .line 50
    .line 51
    invoke-virtual {p0, v3}, Lorg/bitspark/android/utils/CastOptionsProvider;->getAdditionalSessionProviders(Landroid/content/Context;)Ljava/util/List;

    .line 52
    .line 53
    .line 54
    move-result-object v5

    .line 55
    move-object v2, v1

    .line 56
    invoke-direct/range {v2 .. v7}, Lq4/b;-><init>(Landroid/content/Context;Lcom/google/android/gms/cast/framework/CastOptions;Ljava/util/List;Lcom/google/android/gms/internal/cast/v;Lv4/r;)V

    .line 57
    .line 58
    .line 59
    sput-object v1, Lq4/b;->m:Lq4/b;
    :try_end_1
    .catch Lq4/e; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 60
    .line 61
    goto :goto_0

    .line 62
    :catchall_0
    move-exception p0

    .line 63
    goto :goto_1

    .line 64
    :catch_0
    move-exception p0

    .line 65
    :try_start_2
    new-instance v1, Ljava/lang/RuntimeException;

    .line 66
    .line 67
    invoke-direct {v1, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    .line 68
    .line 69
    .line 70
    throw v1

    .line 71
    :cond_0
    :goto_0
    monitor-exit v0

    .line 72
    goto :goto_2

    .line 73
    :goto_1
    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 74
    throw p0

    .line 75
    :cond_1
    :goto_2
    sget-object p0, Lq4/b;->m:Lq4/b;

    .line 76
    .line 77
    return-object p0
.end method

.method public static c(Landroid/app/Activity;)Lq4/b;
    .locals 3

    .line 1
    const-string v0, "Must be called from the main thread."

    .line 2
    .line 3
    invoke-static {v0}, Lb5/l;->b(Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    :try_start_0
    invoke-static {p0}, Lq4/b;->b(Landroid/content/Context;)Lq4/b;

    .line 7
    .line 8
    .line 9
    move-result-object p0
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 10
    return-object p0

    .line 11
    :catch_0
    move-exception p0

    .line 12
    const/4 v0, 0x1

    .line 13
    new-array v0, v0, [Ljava/lang/Object;

    .line 14
    .line 15
    const/4 v1, 0x0

    .line 16
    aput-object p0, v0, v1

    .line 17
    .line 18
    sget-object p0, Lq4/b;->k:Lv4/b;

    .line 19
    .line 20
    iget-object v1, p0, Lv4/b;->a:Ljava/lang/String;

    .line 21
    .line 22
    const-string v2, "Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently."

    .line 23
    .line 24
    invoke-virtual {p0, v2, v0}, Lv4/b;->d(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object p0

    .line 28
    invoke-static {v1, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 29
    .line 30
    .line 31
    const/4 p0, 0x0

    .line 32
    return-object p0
.end method

.method public static d(Landroid/content/Context;)Lorg/bitspark/android/utils/CastOptionsProvider;
    .locals 2

    .line 1
    :try_start_0
    invoke-static {p0}, Ll5/b;->a(Landroid/content/Context;)La4/k;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object p0

    .line 9
    iget-object v0, v0, La4/k;->b:Landroid/content/Context;

    .line 10
    .line 11
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    const/16 v1, 0x80

    .line 16
    .line 17
    invoke-virtual {v0, p0, v1}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    .line 18
    .line 19
    .line 20
    move-result-object p0

    .line 21
    iget-object p0, p0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 22
    .line 23
    if-nez p0, :cond_0

    .line 24
    .line 25
    sget-object v0, Lq4/b;->k:Lv4/b;

    .line 26
    .line 27
    const/4 v1, 0x0

    .line 28
    new-array v1, v1, [Ljava/lang/Object;

    .line 29
    .line 30
    invoke-virtual {v0, v1}, Lv4/b;->c([Ljava/lang/Object;)V

    .line 31
    .line 32
    .line 33
    goto :goto_0

    .line 34
    :catch_0
    move-exception p0

    .line 35
    goto :goto_1

    .line 36
    :catch_1
    move-exception p0

    .line 37
    goto :goto_1

    .line 38
    :catch_2
    move-exception p0

    .line 39
    goto :goto_1

    .line 40
    :catch_3
    move-exception p0

    .line 41
    goto :goto_1

    .line 42
    :catch_4
    move-exception p0

    .line 43
    goto :goto_1

    .line 44
    :catch_5
    move-exception p0

    .line 45
    goto :goto_1

    .line 46
    :catch_6
    move-exception p0

    .line 47
    goto :goto_1

    .line 48
    :cond_0
    :goto_0
    const-string v0, "com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME"

    .line 49
    .line 50
    invoke-virtual {p0, v0}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    .line 51
    .line 52
    .line 53
    move-result-object p0

    .line 54
    if-eqz p0, :cond_1

    .line 55
    .line 56
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 57
    .line 58
    .line 59
    move-result-object p0

    .line 60
    const-class v0, Lorg/bitspark/android/utils/CastOptionsProvider;

    .line 61
    .line 62
    invoke-virtual {p0, v0}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    .line 63
    .line 64
    .line 65
    move-result-object p0

    .line 66
    const/4 v0, 0x0

    .line 67
    invoke-virtual {p0, v0}, Ljava/lang/Class;->getDeclaredConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    .line 68
    .line 69
    .line 70
    move-result-object p0

    .line 71
    invoke-virtual {p0, v0}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    .line 73
    .line 74
    move-result-object p0

    .line 75
    check-cast p0, Lorg/bitspark/android/utils/CastOptionsProvider;

    .line 76
    .line 77
    return-object p0

    .line 78
    :cond_1
    new-instance p0, Ljava/lang/IllegalStateException;

    .line 79
    .line 80
    const-string v0, "The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME."

    .line 81
    .line 82
    invoke-direct {p0, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 83
    .line 84
    .line 85
    throw p0
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_6
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_0

    .line 86
    :goto_1
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 87
    .line 88
    const-string v1, "Failed to initialize CastContext."

    .line 89
    .line 90
    invoke-direct {v0, v1, p0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 91
    .line 92
    .line 93
    throw v0
.end method


# virtual methods
.method public final a()Lq4/h;
    .locals 1

    .line 1
    const-string v0, "Must be called from the main thread."

    .line 2
    .line 3
    invoke-static {v0}, Lb5/l;->b(Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lq4/b;->c:Lq4/h;

    .line 7
    .line 8
    return-object v0
.end method
