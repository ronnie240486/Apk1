.class public abstract Ln3/a;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Ljava/lang/Cloneable;


# instance fields
.field public a:I

.field public b:Lx2/k;

.field public c:Lcom/bumptech/glide/g;

.field public d:Landroid/graphics/drawable/Drawable;

.field public e:I

.field public f:Lg0/g;

.field public g:Z

.field public h:I

.field public i:I

.field public j:Lv2/e;

.field public k:Z

.field public l:Lv2/h;

.field public m:Lr3/b;

.field public n:Ljava/lang/Class;

.field public o:Z

.field public p:Landroid/content/res/Resources$Theme;

.field public q:Z

.field public r:Z

.field public s:Z


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    sget-object v0, Lx2/k;->d:Lx2/k;

    .line 5
    .line 6
    iput-object v0, p0, Ln3/a;->b:Lx2/k;

    .line 7
    .line 8
    sget-object v0, Lcom/bumptech/glide/g;->c:Lcom/bumptech/glide/g;

    .line 9
    .line 10
    iput-object v0, p0, Ln3/a;->c:Lcom/bumptech/glide/g;

    .line 11
    .line 12
    const/4 v0, 0x1

    .line 13
    iput-boolean v0, p0, Ln3/a;->g:Z

    .line 14
    .line 15
    const/4 v1, -0x1

    .line 16
    iput v1, p0, Ln3/a;->h:I

    .line 17
    .line 18
    iput v1, p0, Ln3/a;->i:I

    .line 19
    .line 20
    sget-object v1, Lq3/c;->b:Lq3/c;

    .line 21
    .line 22
    iput-object v1, p0, Ln3/a;->j:Lv2/e;

    .line 23
    .line 24
    new-instance v1, Lv2/h;

    .line 25
    .line 26
    invoke-direct {v1}, Lv2/h;-><init>()V

    .line 27
    .line 28
    .line 29
    iput-object v1, p0, Ln3/a;->l:Lv2/h;

    .line 30
    .line 31
    new-instance v1, Lr3/b;

    .line 32
    .line 33
    const/4 v2, 0x0

    .line 34
    invoke-direct {v1, v2}, Lp/k;-><init>(I)V

    .line 35
    .line 36
    .line 37
    iput-object v1, p0, Ln3/a;->m:Lr3/b;

    .line 38
    .line 39
    const-class v1, Ljava/lang/Object;

    .line 40
    .line 41
    iput-object v1, p0, Ln3/a;->n:Ljava/lang/Class;

    .line 42
    .line 43
    iput-boolean v0, p0, Ln3/a;->r:Z

    .line 44
    .line 45
    return-void
.end method

.method public static h(II)Z
    .locals 0

    .line 1
    and-int/2addr p0, p1

    .line 2
    if-eqz p0, :cond_0

    .line 3
    .line 4
    const/4 p0, 0x1

    .line 5
    goto :goto_0

    .line 6
    :cond_0
    const/4 p0, 0x0

    .line 7
    :goto_0
    return p0
.end method


# virtual methods
.method public a(Ln3/a;)Ln3/a;
    .locals 3

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->a(Ln3/a;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iget v0, p1, Ln3/a;->a:I

    .line 15
    .line 16
    iget v0, p1, Ln3/a;->a:I

    .line 17
    .line 18
    const/high16 v1, 0x100000

    .line 19
    .line 20
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 21
    .line 22
    .line 23
    move-result v0

    .line 24
    if-eqz v0, :cond_1

    .line 25
    .line 26
    iget-boolean v0, p1, Ln3/a;->s:Z

    .line 27
    .line 28
    iput-boolean v0, p0, Ln3/a;->s:Z

    .line 29
    .line 30
    :cond_1
    iget v0, p1, Ln3/a;->a:I

    .line 31
    .line 32
    const/4 v1, 0x4

    .line 33
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 34
    .line 35
    .line 36
    move-result v0

    .line 37
    if-eqz v0, :cond_2

    .line 38
    .line 39
    iget-object v0, p1, Ln3/a;->b:Lx2/k;

    .line 40
    .line 41
    iput-object v0, p0, Ln3/a;->b:Lx2/k;

    .line 42
    .line 43
    :cond_2
    iget v0, p1, Ln3/a;->a:I

    .line 44
    .line 45
    const/16 v1, 0x8

    .line 46
    .line 47
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 48
    .line 49
    .line 50
    move-result v0

    .line 51
    if-eqz v0, :cond_3

    .line 52
    .line 53
    iget-object v0, p1, Ln3/a;->c:Lcom/bumptech/glide/g;

    .line 54
    .line 55
    iput-object v0, p0, Ln3/a;->c:Lcom/bumptech/glide/g;

    .line 56
    .line 57
    :cond_3
    iget v0, p1, Ln3/a;->a:I

    .line 58
    .line 59
    const/16 v1, 0x10

    .line 60
    .line 61
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 62
    .line 63
    .line 64
    move-result v0

    .line 65
    if-eqz v0, :cond_4

    .line 66
    .line 67
    iget-object v0, p1, Ln3/a;->d:Landroid/graphics/drawable/Drawable;

    .line 68
    .line 69
    iput-object v0, p0, Ln3/a;->d:Landroid/graphics/drawable/Drawable;

    .line 70
    .line 71
    const/4 v0, 0x0

    .line 72
    iput v0, p0, Ln3/a;->e:I

    .line 73
    .line 74
    iget v0, p0, Ln3/a;->a:I

    .line 75
    .line 76
    and-int/lit8 v0, v0, -0x21

    .line 77
    .line 78
    iput v0, p0, Ln3/a;->a:I

    .line 79
    .line 80
    :cond_4
    iget v0, p1, Ln3/a;->a:I

    .line 81
    .line 82
    const/16 v1, 0x20

    .line 83
    .line 84
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 85
    .line 86
    .line 87
    move-result v0

    .line 88
    const/4 v1, 0x0

    .line 89
    if-eqz v0, :cond_5

    .line 90
    .line 91
    iget v0, p1, Ln3/a;->e:I

    .line 92
    .line 93
    iput v0, p0, Ln3/a;->e:I

    .line 94
    .line 95
    iput-object v1, p0, Ln3/a;->d:Landroid/graphics/drawable/Drawable;

    .line 96
    .line 97
    iget v0, p0, Ln3/a;->a:I

    .line 98
    .line 99
    and-int/lit8 v0, v0, -0x11

    .line 100
    .line 101
    iput v0, p0, Ln3/a;->a:I

    .line 102
    .line 103
    :cond_5
    iget v0, p1, Ln3/a;->a:I

    .line 104
    .line 105
    const/16 v2, 0x40

    .line 106
    .line 107
    invoke-static {v0, v2}, Ln3/a;->h(II)Z

    .line 108
    .line 109
    .line 110
    move-result v0

    .line 111
    if-eqz v0, :cond_6

    .line 112
    .line 113
    iget-object v0, p1, Ln3/a;->f:Lg0/g;

    .line 114
    .line 115
    iput-object v0, p0, Ln3/a;->f:Lg0/g;

    .line 116
    .line 117
    iget v0, p0, Ln3/a;->a:I

    .line 118
    .line 119
    and-int/lit16 v0, v0, -0x81

    .line 120
    .line 121
    iput v0, p0, Ln3/a;->a:I

    .line 122
    .line 123
    :cond_6
    iget v0, p1, Ln3/a;->a:I

    .line 124
    .line 125
    const/16 v2, 0x80

    .line 126
    .line 127
    invoke-static {v0, v2}, Ln3/a;->h(II)Z

    .line 128
    .line 129
    .line 130
    move-result v0

    .line 131
    if-eqz v0, :cond_7

    .line 132
    .line 133
    iput-object v1, p0, Ln3/a;->f:Lg0/g;

    .line 134
    .line 135
    iget v0, p0, Ln3/a;->a:I

    .line 136
    .line 137
    and-int/lit8 v0, v0, -0x41

    .line 138
    .line 139
    iput v0, p0, Ln3/a;->a:I

    .line 140
    .line 141
    :cond_7
    iget v0, p1, Ln3/a;->a:I

    .line 142
    .line 143
    const/16 v1, 0x100

    .line 144
    .line 145
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 146
    .line 147
    .line 148
    move-result v0

    .line 149
    if-eqz v0, :cond_8

    .line 150
    .line 151
    iget-boolean v0, p1, Ln3/a;->g:Z

    .line 152
    .line 153
    iput-boolean v0, p0, Ln3/a;->g:Z

    .line 154
    .line 155
    :cond_8
    iget v0, p1, Ln3/a;->a:I

    .line 156
    .line 157
    const/16 v1, 0x200

    .line 158
    .line 159
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 160
    .line 161
    .line 162
    move-result v0

    .line 163
    if-eqz v0, :cond_9

    .line 164
    .line 165
    iget v0, p1, Ln3/a;->i:I

    .line 166
    .line 167
    iput v0, p0, Ln3/a;->i:I

    .line 168
    .line 169
    iget v0, p1, Ln3/a;->h:I

    .line 170
    .line 171
    iput v0, p0, Ln3/a;->h:I

    .line 172
    .line 173
    :cond_9
    iget v0, p1, Ln3/a;->a:I

    .line 174
    .line 175
    const/16 v1, 0x400

    .line 176
    .line 177
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 178
    .line 179
    .line 180
    move-result v0

    .line 181
    if-eqz v0, :cond_a

    .line 182
    .line 183
    iget-object v0, p1, Ln3/a;->j:Lv2/e;

    .line 184
    .line 185
    iput-object v0, p0, Ln3/a;->j:Lv2/e;

    .line 186
    .line 187
    :cond_a
    iget v0, p1, Ln3/a;->a:I

    .line 188
    .line 189
    const/16 v1, 0x1000

    .line 190
    .line 191
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 192
    .line 193
    .line 194
    move-result v0

    .line 195
    if-eqz v0, :cond_b

    .line 196
    .line 197
    iget-object v0, p1, Ln3/a;->n:Ljava/lang/Class;

    .line 198
    .line 199
    iput-object v0, p0, Ln3/a;->n:Ljava/lang/Class;

    .line 200
    .line 201
    :cond_b
    iget v0, p1, Ln3/a;->a:I

    .line 202
    .line 203
    const/16 v1, 0x2000

    .line 204
    .line 205
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 206
    .line 207
    .line 208
    move-result v0

    .line 209
    if-eqz v0, :cond_c

    .line 210
    .line 211
    iget v0, p0, Ln3/a;->a:I

    .line 212
    .line 213
    and-int/lit16 v0, v0, -0x4001

    .line 214
    .line 215
    iput v0, p0, Ln3/a;->a:I

    .line 216
    .line 217
    :cond_c
    iget v0, p1, Ln3/a;->a:I

    .line 218
    .line 219
    const/16 v1, 0x4000

    .line 220
    .line 221
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 222
    .line 223
    .line 224
    move-result v0

    .line 225
    if-eqz v0, :cond_d

    .line 226
    .line 227
    iget v0, p0, Ln3/a;->a:I

    .line 228
    .line 229
    and-int/lit16 v0, v0, -0x2001

    .line 230
    .line 231
    iput v0, p0, Ln3/a;->a:I

    .line 232
    .line 233
    :cond_d
    iget v0, p1, Ln3/a;->a:I

    .line 234
    .line 235
    const v1, 0x8000

    .line 236
    .line 237
    .line 238
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 239
    .line 240
    .line 241
    move-result v0

    .line 242
    if-eqz v0, :cond_e

    .line 243
    .line 244
    iget-object v0, p1, Ln3/a;->p:Landroid/content/res/Resources$Theme;

    .line 245
    .line 246
    iput-object v0, p0, Ln3/a;->p:Landroid/content/res/Resources$Theme;

    .line 247
    .line 248
    :cond_e
    iget v0, p1, Ln3/a;->a:I

    .line 249
    .line 250
    const/high16 v1, 0x20000

    .line 251
    .line 252
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 253
    .line 254
    .line 255
    move-result v0

    .line 256
    if-eqz v0, :cond_f

    .line 257
    .line 258
    iget-boolean v0, p1, Ln3/a;->k:Z

    .line 259
    .line 260
    iput-boolean v0, p0, Ln3/a;->k:Z

    .line 261
    .line 262
    :cond_f
    iget v0, p1, Ln3/a;->a:I

    .line 263
    .line 264
    const/16 v1, 0x800

    .line 265
    .line 266
    invoke-static {v0, v1}, Ln3/a;->h(II)Z

    .line 267
    .line 268
    .line 269
    move-result v0

    .line 270
    if-eqz v0, :cond_10

    .line 271
    .line 272
    iget-object v0, p0, Ln3/a;->m:Lr3/b;

    .line 273
    .line 274
    iget-object v1, p1, Ln3/a;->m:Lr3/b;

    .line 275
    .line 276
    invoke-virtual {v0, v1}, Lp/e;->putAll(Ljava/util/Map;)V

    .line 277
    .line 278
    .line 279
    iget-boolean v0, p1, Ln3/a;->r:Z

    .line 280
    .line 281
    iput-boolean v0, p0, Ln3/a;->r:Z

    .line 282
    .line 283
    :cond_10
    iget v0, p0, Ln3/a;->a:I

    .line 284
    .line 285
    iget v1, p1, Ln3/a;->a:I

    .line 286
    .line 287
    or-int/2addr v0, v1

    .line 288
    iput v0, p0, Ln3/a;->a:I

    .line 289
    .line 290
    iget-object v0, p0, Ln3/a;->l:Lv2/h;

    .line 291
    .line 292
    iget-object p1, p1, Ln3/a;->l:Lv2/h;

    .line 293
    .line 294
    iget-object v0, v0, Lv2/h;->b:Lr3/b;

    .line 295
    .line 296
    iget-object p1, p1, Lv2/h;->b:Lr3/b;

    .line 297
    .line 298
    invoke-virtual {v0, p1}, Lr3/b;->g(Lp/e;)V

    .line 299
    .line 300
    .line 301
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 302
    .line 303
    .line 304
    return-object p0
.end method

.method public b()Ln3/a;
    .locals 4

    .line 1
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    check-cast v0, Ln3/a;

    .line 6
    .line 7
    new-instance v1, Lv2/h;

    .line 8
    .line 9
    invoke-direct {v1}, Lv2/h;-><init>()V

    .line 10
    .line 11
    .line 12
    iput-object v1, v0, Ln3/a;->l:Lv2/h;

    .line 13
    .line 14
    iget-object v2, p0, Ln3/a;->l:Lv2/h;

    .line 15
    .line 16
    iget-object v1, v1, Lv2/h;->b:Lr3/b;

    .line 17
    .line 18
    iget-object v2, v2, Lv2/h;->b:Lr3/b;

    .line 19
    .line 20
    invoke-virtual {v1, v2}, Lr3/b;->g(Lp/e;)V

    .line 21
    .line 22
    .line 23
    new-instance v1, Lr3/b;

    .line 24
    .line 25
    const/4 v2, 0x0

    .line 26
    invoke-direct {v1, v2}, Lp/k;-><init>(I)V

    .line 27
    .line 28
    .line 29
    iput-object v1, v0, Ln3/a;->m:Lr3/b;

    .line 30
    .line 31
    iget-object v3, p0, Ln3/a;->m:Lr3/b;

    .line 32
    .line 33
    invoke-virtual {v1, v3}, Lp/e;->putAll(Ljava/util/Map;)V

    .line 34
    .line 35
    .line 36
    iput-boolean v2, v0, Ln3/a;->o:Z

    .line 37
    .line 38
    iput-boolean v2, v0, Ln3/a;->q:Z
    :try_end_0
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 39
    .line 40
    return-object v0

    .line 41
    :catch_0
    move-exception v0

    .line 42
    new-instance v1, Ljava/lang/RuntimeException;

    .line 43
    .line 44
    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    .line 45
    .line 46
    .line 47
    throw v1
.end method

.method public final c(Ljava/lang/Class;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->c(Ljava/lang/Class;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iput-object p1, p0, Ln3/a;->n:Ljava/lang/Class;

    .line 15
    .line 16
    iget p1, p0, Ln3/a;->a:I

    .line 17
    .line 18
    or-int/lit16 p1, p1, 0x1000

    .line 19
    .line 20
    iput p1, p0, Ln3/a;->a:I

    .line 21
    .line 22
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 23
    .line 24
    .line 25
    return-object p0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
.end method

.method public final d(Lx2/k;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->d(Lx2/k;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iput-object p1, p0, Ln3/a;->b:Lx2/k;

    .line 15
    .line 16
    iget p1, p0, Ln3/a;->a:I

    .line 17
    .line 18
    or-int/lit8 p1, p1, 0x4

    .line 19
    .line 20
    iput p1, p0, Ln3/a;->a:I

    .line 21
    .line 22
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 23
    .line 24
    .line 25
    return-object p0
.end method

.method public final e(I)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->e(I)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iput p1, p0, Ln3/a;->e:I

    .line 15
    .line 16
    iget p1, p0, Ln3/a;->a:I

    .line 17
    .line 18
    or-int/lit8 p1, p1, 0x20

    .line 19
    .line 20
    const/4 v0, 0x0

    .line 21
    iput-object v0, p0, Ln3/a;->d:Landroid/graphics/drawable/Drawable;

    .line 22
    .line 23
    and-int/lit8 p1, p1, -0x11

    .line 24
    .line 25
    iput p1, p0, Ln3/a;->a:I

    .line 26
    .line 27
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 28
    .line 29
    .line 30
    return-object p0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 1

    .line 1
    instance-of v0, p1, Ln3/a;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    check-cast p1, Ln3/a;

    .line 6
    .line 7
    invoke-virtual {p0, p1}, Ln3/a;->g(Ln3/a;)Z

    .line 8
    .line 9
    .line 10
    move-result p1

    .line 11
    return p1

    .line 12
    :cond_0
    const/4 p1, 0x0

    .line 13
    return p1
.end method

.method public final f(Landroid/graphics/drawable/Drawable;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->f(Landroid/graphics/drawable/Drawable;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iput-object p1, p0, Ln3/a;->d:Landroid/graphics/drawable/Drawable;

    .line 15
    .line 16
    iget p1, p0, Ln3/a;->a:I

    .line 17
    .line 18
    or-int/lit8 p1, p1, 0x10

    .line 19
    .line 20
    const/4 v0, 0x0

    .line 21
    iput v0, p0, Ln3/a;->e:I

    .line 22
    .line 23
    and-int/lit8 p1, p1, -0x21

    .line 24
    .line 25
    iput p1, p0, Ln3/a;->a:I

    .line 26
    .line 27
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 28
    .line 29
    .line 30
    return-object p0
.end method

.method public final g(Ln3/a;)Z
    .locals 2

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 2
    .line 3
    .line 4
    const/high16 v0, 0x3f800000    # 1.0f

    .line 5
    .line 6
    invoke-static {v0, v0}, Ljava/lang/Float;->compare(FF)I

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    if-nez v0, :cond_0

    .line 11
    .line 12
    iget v0, p0, Ln3/a;->e:I

    .line 13
    .line 14
    iget v1, p1, Ln3/a;->e:I

    .line 15
    .line 16
    if-ne v0, v1, :cond_0

    .line 17
    .line 18
    iget-object v0, p0, Ln3/a;->d:Landroid/graphics/drawable/Drawable;

    .line 19
    .line 20
    iget-object v1, p1, Ln3/a;->d:Landroid/graphics/drawable/Drawable;

    .line 21
    .line 22
    invoke-static {v0, v1}, Lr3/n;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 23
    .line 24
    .line 25
    move-result v0

    .line 26
    if-eqz v0, :cond_0

    .line 27
    .line 28
    iget-object v0, p0, Ln3/a;->f:Lg0/g;

    .line 29
    .line 30
    iget-object v1, p1, Ln3/a;->f:Lg0/g;

    .line 31
    .line 32
    invoke-static {v0, v1}, Lr3/n;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 33
    .line 34
    .line 35
    move-result v0

    .line 36
    if-eqz v0, :cond_0

    .line 37
    .line 38
    const/4 v0, 0x0

    .line 39
    invoke-static {v0, v0}, Lr3/n;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 40
    .line 41
    .line 42
    move-result v0

    .line 43
    if-eqz v0, :cond_0

    .line 44
    .line 45
    iget-boolean v0, p0, Ln3/a;->g:Z

    .line 46
    .line 47
    iget-boolean v1, p1, Ln3/a;->g:Z

    .line 48
    .line 49
    if-ne v0, v1, :cond_0

    .line 50
    .line 51
    iget v0, p0, Ln3/a;->h:I

    .line 52
    .line 53
    iget v1, p1, Ln3/a;->h:I

    .line 54
    .line 55
    if-ne v0, v1, :cond_0

    .line 56
    .line 57
    iget v0, p0, Ln3/a;->i:I

    .line 58
    .line 59
    iget v1, p1, Ln3/a;->i:I

    .line 60
    .line 61
    if-ne v0, v1, :cond_0

    .line 62
    .line 63
    iget-boolean v0, p0, Ln3/a;->k:Z

    .line 64
    .line 65
    iget-boolean v1, p1, Ln3/a;->k:Z

    .line 66
    .line 67
    if-ne v0, v1, :cond_0

    .line 68
    .line 69
    iget-object v0, p0, Ln3/a;->b:Lx2/k;

    .line 70
    .line 71
    iget-object v1, p1, Ln3/a;->b:Lx2/k;

    .line 72
    .line 73
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 74
    .line 75
    .line 76
    move-result v0

    .line 77
    if-eqz v0, :cond_0

    .line 78
    .line 79
    iget-object v0, p0, Ln3/a;->c:Lcom/bumptech/glide/g;

    .line 80
    .line 81
    iget-object v1, p1, Ln3/a;->c:Lcom/bumptech/glide/g;

    .line 82
    .line 83
    if-ne v0, v1, :cond_0

    .line 84
    .line 85
    iget-object v0, p0, Ln3/a;->l:Lv2/h;

    .line 86
    .line 87
    iget-object v1, p1, Ln3/a;->l:Lv2/h;

    .line 88
    .line 89
    invoke-virtual {v0, v1}, Lv2/h;->equals(Ljava/lang/Object;)Z

    .line 90
    .line 91
    .line 92
    move-result v0

    .line 93
    if-eqz v0, :cond_0

    .line 94
    .line 95
    iget-object v0, p0, Ln3/a;->m:Lr3/b;

    .line 96
    .line 97
    iget-object v1, p1, Ln3/a;->m:Lr3/b;

    .line 98
    .line 99
    invoke-virtual {v0, v1}, Lp/k;->equals(Ljava/lang/Object;)Z

    .line 100
    .line 101
    .line 102
    move-result v0

    .line 103
    if-eqz v0, :cond_0

    .line 104
    .line 105
    iget-object v0, p0, Ln3/a;->n:Ljava/lang/Class;

    .line 106
    .line 107
    iget-object v1, p1, Ln3/a;->n:Ljava/lang/Class;

    .line 108
    .line 109
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 110
    .line 111
    .line 112
    move-result v0

    .line 113
    if-eqz v0, :cond_0

    .line 114
    .line 115
    iget-object v0, p0, Ln3/a;->j:Lv2/e;

    .line 116
    .line 117
    iget-object v1, p1, Ln3/a;->j:Lv2/e;

    .line 118
    .line 119
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 120
    .line 121
    .line 122
    move-result v0

    .line 123
    if-eqz v0, :cond_0

    .line 124
    .line 125
    iget-object v0, p0, Ln3/a;->p:Landroid/content/res/Resources$Theme;

    .line 126
    .line 127
    iget-object p1, p1, Ln3/a;->p:Landroid/content/res/Resources$Theme;

    .line 128
    .line 129
    invoke-static {v0, p1}, Lr3/n;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 130
    .line 131
    .line 132
    move-result p1

    .line 133
    if-eqz p1, :cond_0

    .line 134
    .line 135
    const/4 p1, 0x1

    .line 136
    goto :goto_0

    .line 137
    :cond_0
    const/4 p1, 0x0

    .line 138
    :goto_0
    return p1
.end method

.method public hashCode()I
    .locals 3

    .line 1
    sget-object v0, Lr3/n;->a:[C

    .line 2
    .line 3
    const/high16 v0, 0x3f800000    # 1.0f

    .line 4
    .line 5
    invoke-static {v0}, Ljava/lang/Float;->floatToIntBits(F)I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    const/16 v1, 0x11

    .line 10
    .line 11
    invoke-static {v0, v1}, Lr3/n;->g(II)I

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    iget v1, p0, Ln3/a;->e:I

    .line 16
    .line 17
    invoke-static {v1, v0}, Lr3/n;->g(II)I

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    iget-object v1, p0, Ln3/a;->d:Landroid/graphics/drawable/Drawable;

    .line 22
    .line 23
    invoke-static {v0, v1}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 24
    .line 25
    .line 26
    move-result v0

    .line 27
    const/4 v1, 0x0

    .line 28
    invoke-static {v1, v0}, Lr3/n;->g(II)I

    .line 29
    .line 30
    .line 31
    move-result v0

    .line 32
    iget-object v2, p0, Ln3/a;->f:Lg0/g;

    .line 33
    .line 34
    invoke-static {v0, v2}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 35
    .line 36
    .line 37
    move-result v0

    .line 38
    invoke-static {v1, v0}, Lr3/n;->g(II)I

    .line 39
    .line 40
    .line 41
    move-result v0

    .line 42
    const/4 v2, 0x0

    .line 43
    invoke-static {v0, v2}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 44
    .line 45
    .line 46
    move-result v0

    .line 47
    iget-boolean v2, p0, Ln3/a;->g:Z

    .line 48
    .line 49
    invoke-static {v2, v0}, Lr3/n;->g(II)I

    .line 50
    .line 51
    .line 52
    move-result v0

    .line 53
    iget v2, p0, Ln3/a;->h:I

    .line 54
    .line 55
    invoke-static {v2, v0}, Lr3/n;->g(II)I

    .line 56
    .line 57
    .line 58
    move-result v0

    .line 59
    iget v2, p0, Ln3/a;->i:I

    .line 60
    .line 61
    invoke-static {v2, v0}, Lr3/n;->g(II)I

    .line 62
    .line 63
    .line 64
    move-result v0

    .line 65
    iget-boolean v2, p0, Ln3/a;->k:Z

    .line 66
    .line 67
    invoke-static {v2, v0}, Lr3/n;->g(II)I

    .line 68
    .line 69
    .line 70
    move-result v0

    .line 71
    const/4 v2, 0x1

    .line 72
    invoke-static {v2, v0}, Lr3/n;->g(II)I

    .line 73
    .line 74
    .line 75
    move-result v0

    .line 76
    invoke-static {v1, v0}, Lr3/n;->g(II)I

    .line 77
    .line 78
    .line 79
    move-result v0

    .line 80
    invoke-static {v1, v0}, Lr3/n;->g(II)I

    .line 81
    .line 82
    .line 83
    move-result v0

    .line 84
    iget-object v1, p0, Ln3/a;->b:Lx2/k;

    .line 85
    .line 86
    invoke-static {v0, v1}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 87
    .line 88
    .line 89
    move-result v0

    .line 90
    iget-object v1, p0, Ln3/a;->c:Lcom/bumptech/glide/g;

    .line 91
    .line 92
    invoke-static {v0, v1}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 93
    .line 94
    .line 95
    move-result v0

    .line 96
    iget-object v1, p0, Ln3/a;->l:Lv2/h;

    .line 97
    .line 98
    invoke-static {v0, v1}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 99
    .line 100
    .line 101
    move-result v0

    .line 102
    iget-object v1, p0, Ln3/a;->m:Lr3/b;

    .line 103
    .line 104
    invoke-static {v0, v1}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 105
    .line 106
    .line 107
    move-result v0

    .line 108
    iget-object v1, p0, Ln3/a;->n:Ljava/lang/Class;

    .line 109
    .line 110
    invoke-static {v0, v1}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 111
    .line 112
    .line 113
    move-result v0

    .line 114
    iget-object v1, p0, Ln3/a;->j:Lv2/e;

    .line 115
    .line 116
    invoke-static {v0, v1}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 117
    .line 118
    .line 119
    move-result v0

    .line 120
    iget-object v1, p0, Ln3/a;->p:Landroid/content/res/Resources$Theme;

    .line 121
    .line 122
    invoke-static {v0, v1}, Lr3/n;->h(ILjava/lang/Object;)I

    .line 123
    .line 124
    .line 125
    move-result v0

    .line 126
    return v0
.end method

.method public final i(Le3/n;Le3/e;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1, p2}, Ln3/a;->i(Le3/n;Le3/e;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    sget-object v0, Le3/n;->g:Lv2/g;

    .line 15
    .line 16
    invoke-virtual {p0, v0, p1}, Ln3/a;->o(Lv2/g;Ljava/lang/Object;)Ln3/a;

    .line 17
    .line 18
    .line 19
    const/4 p1, 0x0

    .line 20
    invoke-virtual {p0, p2, p1}, Ln3/a;->u(Lv2/l;Z)Ln3/a;

    .line 21
    .line 22
    .line 23
    move-result-object p1

    .line 24
    return-object p1
.end method

.method public final j(II)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1, p2}, Ln3/a;->j(II)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iput p1, p0, Ln3/a;->i:I

    .line 15
    .line 16
    iput p2, p0, Ln3/a;->h:I

    .line 17
    .line 18
    iget p1, p0, Ln3/a;->a:I

    .line 19
    .line 20
    or-int/lit16 p1, p1, 0x200

    .line 21
    .line 22
    iput p1, p0, Ln3/a;->a:I

    .line 23
    .line 24
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 25
    .line 26
    .line 27
    return-object p0
.end method

.method public final k(Lg0/g;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->k(Lg0/g;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iput-object p1, p0, Ln3/a;->f:Lg0/g;

    .line 15
    .line 16
    iget p1, p0, Ln3/a;->a:I

    .line 17
    .line 18
    or-int/lit8 p1, p1, 0x40

    .line 19
    .line 20
    and-int/lit16 p1, p1, -0x81

    .line 21
    .line 22
    iput p1, p0, Ln3/a;->a:I

    .line 23
    .line 24
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 25
    .line 26
    .line 27
    return-object p0
.end method

.method public final l()Ln3/a;
    .locals 2

    .line 1
    sget-object v0, Lcom/bumptech/glide/g;->d:Lcom/bumptech/glide/g;

    .line 2
    .line 3
    iget-boolean v1, p0, Ln3/a;->q:Z

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    invoke-virtual {v0}, Ln3/a;->l()Ln3/a;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    return-object v0

    .line 16
    :cond_0
    iput-object v0, p0, Ln3/a;->c:Lcom/bumptech/glide/g;

    .line 17
    .line 18
    iget v0, p0, Ln3/a;->a:I

    .line 19
    .line 20
    or-int/lit8 v0, v0, 0x8

    .line 21
    .line 22
    iput v0, p0, Ln3/a;->a:I

    .line 23
    .line 24
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 25
    .line 26
    .line 27
    return-object p0
.end method

.method public final m(Lv2/g;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->m(Lv2/g;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iget-object v0, p0, Ln3/a;->l:Lv2/h;

    .line 15
    .line 16
    iget-object v0, v0, Lv2/h;->b:Lr3/b;

    .line 17
    .line 18
    invoke-virtual {v0, p1}, Lp/k;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 19
    .line 20
    .line 21
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 22
    .line 23
    .line 24
    return-object p0
.end method

.method public final n()V
    .locals 2

    .line 1
    iget-boolean v0, p0, Ln3/a;->o:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 7
    .line 8
    const-string v1, "You cannot modify locked T, consider clone()"

    .line 9
    .line 10
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    throw v0
.end method

.method public final o(Lv2/g;Ljava/lang/Object;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1, p2}, Ln3/a;->o(Lv2/g;Ljava/lang/Object;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    invoke-static {p1}, Lr3/f;->b(Ljava/lang/Object;)V

    .line 15
    .line 16
    .line 17
    invoke-static {p2}, Lr3/f;->b(Ljava/lang/Object;)V

    .line 18
    .line 19
    .line 20
    iget-object v0, p0, Ln3/a;->l:Lv2/h;

    .line 21
    .line 22
    iget-object v0, v0, Lv2/h;->b:Lr3/b;

    .line 23
    .line 24
    invoke-virtual {v0, p1, p2}, Lr3/b;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    .line 26
    .line 27
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 28
    .line 29
    .line 30
    return-object p0
.end method

.method public final p(Lv2/e;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->p(Lv2/e;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iput-object p1, p0, Ln3/a;->j:Lv2/e;

    .line 15
    .line 16
    iget p1, p0, Ln3/a;->a:I

    .line 17
    .line 18
    or-int/lit16 p1, p1, 0x400

    .line 19
    .line 20
    iput p1, p0, Ln3/a;->a:I

    .line 21
    .line 22
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 23
    .line 24
    .line 25
    return-object p0
.end method

.method public final q(Z)Ln3/a;
    .locals 2

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    invoke-virtual {p1, v1}, Ln3/a;->q(Z)Ln3/a;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    return-object p1

    .line 15
    :cond_0
    xor-int/2addr p1, v1

    .line 16
    iput-boolean p1, p0, Ln3/a;->g:Z

    .line 17
    .line 18
    iget p1, p0, Ln3/a;->a:I

    .line 19
    .line 20
    or-int/lit16 p1, p1, 0x100

    .line 21
    .line 22
    iput p1, p0, Ln3/a;->a:I

    .line 23
    .line 24
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 25
    .line 26
    .line 27
    return-object p0
.end method

.method public final r(Landroid/content/res/Resources$Theme;)Ln3/a;
    .locals 2

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1}, Ln3/a;->r(Landroid/content/res/Resources$Theme;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    iput-object p1, p0, Ln3/a;->p:Landroid/content/res/Resources$Theme;

    .line 15
    .line 16
    if-eqz p1, :cond_1

    .line 17
    .line 18
    iget v0, p0, Ln3/a;->a:I

    .line 19
    .line 20
    const v1, 0x8000

    .line 21
    .line 22
    .line 23
    or-int/2addr v0, v1

    .line 24
    iput v0, p0, Ln3/a;->a:I

    .line 25
    .line 26
    sget-object v0, Lg3/d;->b:Lv2/g;

    .line 27
    .line 28
    invoke-virtual {p0, v0, p1}, Ln3/a;->o(Lv2/g;Ljava/lang/Object;)Ln3/a;

    .line 29
    .line 30
    .line 31
    move-result-object p1

    .line 32
    return-object p1

    .line 33
    :cond_1
    iget p1, p0, Ln3/a;->a:I

    .line 34
    .line 35
    const v0, -0x8001

    .line 36
    .line 37
    .line 38
    and-int/2addr p1, v0

    .line 39
    iput p1, p0, Ln3/a;->a:I

    .line 40
    .line 41
    sget-object p1, Lg3/d;->b:Lv2/g;

    .line 42
    .line 43
    invoke-virtual {p0, p1}, Ln3/a;->m(Lv2/g;)Ln3/a;

    .line 44
    .line 45
    .line 46
    move-result-object p1

    .line 47
    return-object p1
.end method

.method public final s(Le3/n;Le3/e;)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1, p2}, Ln3/a;->s(Le3/n;Le3/e;)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    sget-object v0, Le3/n;->g:Lv2/g;

    .line 15
    .line 16
    invoke-virtual {p0, v0, p1}, Ln3/a;->o(Lv2/g;Ljava/lang/Object;)Ln3/a;

    .line 17
    .line 18
    .line 19
    const/4 p1, 0x1

    .line 20
    invoke-virtual {p0, p2, p1}, Ln3/a;->u(Lv2/l;Z)Ln3/a;

    .line 21
    .line 22
    .line 23
    move-result-object p1

    .line 24
    return-object p1
.end method

.method public final t(Ljava/lang/Class;Lv2/l;Z)Ln3/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1, p2, p3}, Ln3/a;->t(Ljava/lang/Class;Lv2/l;Z)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    invoke-static {p2}, Lr3/f;->b(Ljava/lang/Object;)V

    .line 15
    .line 16
    .line 17
    iget-object v0, p0, Ln3/a;->m:Lr3/b;

    .line 18
    .line 19
    invoke-virtual {v0, p1, p2}, Lr3/b;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 20
    .line 21
    .line 22
    iget p1, p0, Ln3/a;->a:I

    .line 23
    .line 24
    const p2, 0x10800

    .line 25
    .line 26
    .line 27
    or-int/2addr p2, p1

    .line 28
    iput p2, p0, Ln3/a;->a:I

    .line 29
    .line 30
    const/4 p2, 0x0

    .line 31
    iput-boolean p2, p0, Ln3/a;->r:Z

    .line 32
    .line 33
    if-eqz p3, :cond_1

    .line 34
    .line 35
    const p2, 0x30800

    .line 36
    .line 37
    .line 38
    or-int/2addr p1, p2

    .line 39
    iput p1, p0, Ln3/a;->a:I

    .line 40
    .line 41
    const/4 p1, 0x1

    .line 42
    iput-boolean p1, p0, Ln3/a;->k:Z

    .line 43
    .line 44
    :cond_1
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 45
    .line 46
    .line 47
    return-object p0
.end method

.method public final u(Lv2/l;Z)Ln3/a;
    .locals 2

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0, p1, p2}, Ln3/a;->u(Lv2/l;Z)Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1

    .line 14
    :cond_0
    new-instance v0, Le3/s;

    .line 15
    .line 16
    invoke-direct {v0, p1, p2}, Le3/s;-><init>(Lv2/l;Z)V

    .line 17
    .line 18
    .line 19
    const-class v1, Landroid/graphics/Bitmap;

    .line 20
    .line 21
    invoke-virtual {p0, v1, p1, p2}, Ln3/a;->t(Ljava/lang/Class;Lv2/l;Z)Ln3/a;

    .line 22
    .line 23
    .line 24
    const-class v1, Landroid/graphics/drawable/Drawable;

    .line 25
    .line 26
    invoke-virtual {p0, v1, v0, p2}, Ln3/a;->t(Ljava/lang/Class;Lv2/l;Z)Ln3/a;

    .line 27
    .line 28
    .line 29
    const-class v1, Landroid/graphics/drawable/BitmapDrawable;

    .line 30
    .line 31
    invoke-virtual {p0, v1, v0, p2}, Ln3/a;->t(Ljava/lang/Class;Lv2/l;Z)Ln3/a;

    .line 32
    .line 33
    .line 34
    new-instance v0, Li3/e;

    .line 35
    .line 36
    invoke-direct {v0, p1}, Li3/e;-><init>(Lv2/l;)V

    .line 37
    .line 38
    .line 39
    const-class p1, Li3/d;

    .line 40
    .line 41
    invoke-virtual {p0, p1, v0, p2}, Ln3/a;->t(Ljava/lang/Class;Lv2/l;Z)Ln3/a;

    .line 42
    .line 43
    .line 44
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 45
    .line 46
    .line 47
    return-object p0
.end method

.method public final v()Ln3/a;
    .locals 2

    .line 1
    iget-boolean v0, p0, Ln3/a;->q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0}, Ln3/a;->b()Ln3/a;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0}, Ln3/a;->v()Ln3/a;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    return-object v0

    .line 14
    :cond_0
    const/4 v0, 0x1

    .line 15
    iput-boolean v0, p0, Ln3/a;->s:Z

    .line 16
    .line 17
    iget v0, p0, Ln3/a;->a:I

    .line 18
    .line 19
    const/high16 v1, 0x100000

    .line 20
    .line 21
    or-int/2addr v0, v1

    .line 22
    iput v0, p0, Ln3/a;->a:I

    .line 23
    .line 24
    invoke-virtual {p0}, Ln3/a;->n()V

    .line 25
    .line 26
    .line 27
    return-object p0
.end method
