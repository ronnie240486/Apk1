.class public final Lfa/d0;
.super Lfa/i0;
.source "MyApplication"


# static fields
.field public static final i:Ljava/lang/String;


# instance fields
.field public c:I

.field public final d:Ljava/util/ArrayList;

.field public e:Landroid/view/View;

.field public final f:Lka/n;

.field public g:Z

.field public h:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    const-string v0, "QV1iGx2KFKpgZUUSDJAfvQ==\n"

    .line 2
    .line 3
    const-string v1, "DCQhc3zkes8=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    sput-object v0, Lfa/d0;->i:Ljava/lang/String;

    .line 10
    .line 11
    return-void
.end method

.method public constructor <init>(ILka/n;Ljava/util/ArrayList;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Lfa/i0;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lfa/d0;->d:Ljava/util/ArrayList;

    .line 10
    .line 11
    const/4 v1, 0x1

    .line 12
    iput-boolean v1, p0, Lfa/d0;->g:Z

    .line 13
    .line 14
    const/4 v1, 0x0

    .line 15
    iput-boolean v1, p0, Lfa/d0;->h:Z

    .line 16
    .line 17
    iput p1, p0, Lfa/d0;->c:I

    .line 18
    .line 19
    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 20
    .line 21
    .line 22
    iput-object p2, p0, Lfa/d0;->f:Lka/n;

    .line 23
    .line 24
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 5

    .line 1
    iget v0, p0, Lfa/d0;->c:I

    .line 2
    .line 3
    invoke-static {}, Lra/f;->b()Lra/f;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    iget v1, v1, Lra/f;->j:I

    .line 8
    .line 9
    sget-object v2, Lfa/d0;->i:Ljava/lang/String;

    .line 10
    .line 11
    if-ne v0, v1, :cond_0

    .line 12
    .line 13
    iget-object v0, p0, Lfa/d0;->d:Ljava/util/ArrayList;

    .line 14
    .line 15
    invoke-static {}, Lra/f;->b()Lra/f;

    .line 16
    .line 17
    .line 18
    move-result-object v1

    .line 19
    iget-object v1, v1, Lra/f;->e:Lorg/bitspark/android/beans/ChannelBean;

    .line 20
    .line 21
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    .line 22
    .line 23
    .line 24
    move-result v0

    .line 25
    new-instance v1, Ljava/lang/StringBuilder;

    .line 26
    .line 27
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 28
    .line 29
    .line 30
    const-string v3, "AcVK1awscTAIx27qsyR8MAnOBKU=\n"

    .line 31
    .line 32
    const-string v4, "ZqA+hcBNCFk=\n"

    .line 33
    .line 34
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 35
    .line 36
    .line 37
    move-result-object v3

    .line 38
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 39
    .line 40
    .line 41
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 42
    .line 43
    .line 44
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 45
    .line 46
    .line 47
    move-result-object v1

    .line 48
    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 49
    .line 50
    invoke-static {v2, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    .line 52
    .line 53
    return v0

    .line 54
    :cond_0
    const-string v0, "M09kRDZN0wawhYbW3bxQi90d447S4Sy4ZAcr\n"

    .line 55
    .line 56
    const-string v1, "VD0LMUYEtyY=\n"

    .line 57
    .line 58
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 59
    .line 60
    .line 61
    move-result-object v0

    .line 62
    sget-boolean v1, Lorg/bitspark/android/utils/m;->b:Z

    .line 63
    .line 64
    invoke-static {v2, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    .line 66
    .line 67
    const/4 v0, 0x0

    .line 68
    return v0
.end method

.method public final b(Landroid/view/View;)V
    .locals 3

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 4
    .line 5
    .line 6
    const-string v1, "aX3CXfIFyUpufdJY/gzbEzo=\n"

    .line 7
    .line 8
    const-string v2, "Ghi2DpdprCk=\n"

    .line 9
    .line 10
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 15
    .line 16
    .line 17
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 18
    .line 19
    .line 20
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    sget-boolean v1, Lorg/bitspark/android/utils/m;->b:Z

    .line 25
    .line 26
    sget-object v1, Lfa/d0;->i:Ljava/lang/String;

    .line 27
    .line 28
    invoke-static {v1, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    .line 30
    .line 31
    iput-object p1, p0, Lfa/d0;->e:Landroid/view/View;

    .line 32
    .line 33
    return-void
.end method

.method public final getItemCount()I
    .locals 1

    .line 1
    iget-object v0, p0, Lfa/d0;->d:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
.end method

.method public final onBindViewHolder(Landroidx/recyclerview/widget/p1;I)V
    .locals 11

    .line 1
    const/4 v0, 0x1

    .line 2
    check-cast p1, Lfa/c0;

    .line 3
    .line 4
    invoke-virtual {p1}, Landroidx/recyclerview/widget/p1;->getAbsoluteAdapterPosition()I

    .line 5
    .line 6
    .line 7
    move-result v1

    .line 8
    iget-object v2, p0, Lfa/d0;->d:Ljava/util/ArrayList;

    .line 9
    .line 10
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 11
    .line 12
    .line 13
    move-result-object v2

    .line 14
    check-cast v2, Lorg/bitspark/android/beans/ChannelBean;

    .line 15
    .line 16
    invoke-static {v2}, Lga/h;->d(Lorg/bitspark/android/beans/ChannelBean;)I

    .line 17
    .line 18
    .line 19
    move-result v3

    .line 20
    invoke-virtual {v2}, Lorg/bitspark/android/beans/ChannelBean;->getName()Lorg/bitspark/android/beans/ChannelBean$NameBean;

    .line 21
    .line 22
    .line 23
    move-result-object v4

    .line 24
    invoke-virtual {v4}, Lorg/bitspark/android/beans/ChannelBean$NameBean;->getInit()Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v4

    .line 28
    invoke-static {v3}, Lga/h;->c(I)Ljava/util/ArrayList;

    .line 29
    .line 30
    .line 31
    move-result-object v3

    .line 32
    const-string v5, ""

    .line 33
    .line 34
    const/4 v6, 0x0

    .line 35
    if-eqz v3, :cond_0

    .line 36
    .line 37
    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    .line 38
    .line 39
    .line 40
    move-result v7

    .line 41
    if-nez v7, :cond_0

    .line 42
    .line 43
    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 44
    .line 45
    .line 46
    move-result-object v3

    .line 47
    check-cast v3, Lorg/bitspark/android/beans/EpgBeans$EpgBean;

    .line 48
    .line 49
    invoke-virtual {v3}, Lorg/bitspark/android/beans/EpgBeans$EpgBean;->getName()Ljava/lang/String;

    .line 50
    .line 51
    .line 52
    move-result-object v3

    .line 53
    goto :goto_0

    .line 54
    :cond_0
    move-object v3, v5

    .line 55
    :goto_0
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    .line 56
    .line 57
    .line 58
    move-result v7

    .line 59
    sget-object v8, Lea/h;->a:Ljava/lang/String;

    .line 60
    .line 61
    iget-object v8, p1, Lfa/c0;->c:Landroid/widget/ImageView;

    .line 62
    .line 63
    const/16 v9, 0x8

    .line 64
    .line 65
    invoke-virtual {v8, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 66
    .line 67
    .line 68
    iget-object v8, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 69
    .line 70
    new-instance v10, Lfa/a0;

    .line 71
    .line 72
    invoke-direct {v10, p0, v1, v2}, Lfa/a0;-><init>(Lfa/d0;ILorg/bitspark/android/beans/ChannelBean;)V

    .line 73
    .line 74
    .line 75
    invoke-virtual {v8, v10}, Landroid/view/View;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 76
    .line 77
    .line 78
    iget-object v8, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 79
    .line 80
    new-instance v10, Lfa/q;

    .line 81
    .line 82
    invoke-direct {v10, p0, p2, v0}, Lfa/q;-><init>(Landroidx/recyclerview/widget/k0;II)V

    .line 83
    .line 84
    .line 85
    invoke-virtual {v8, v10}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 86
    .line 87
    .line 88
    iget-object v8, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 89
    .line 90
    new-instance v10, Lfa/h;

    .line 91
    .line 92
    invoke-direct {v10, p2, v0, p0}, Lfa/h;-><init>(IILjava/lang/Object;)V

    .line 93
    .line 94
    .line 95
    invoke-virtual {v8, v10}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 96
    .line 97
    .line 98
    iget-object p2, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 99
    .line 100
    new-instance v8, Lfa/b0;

    .line 101
    .line 102
    invoke-direct {v8, p0, v1}, Lfa/b0;-><init>(Lfa/d0;I)V

    .line 103
    .line 104
    .line 105
    invoke-virtual {p2, v8}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 106
    .line 107
    .line 108
    iget-object p2, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 109
    .line 110
    new-instance v8, Lfa/f;

    .line 111
    .line 112
    invoke-direct {v8, v1, v0, p0}, Lfa/f;-><init>(IILjava/lang/Object;)V

    .line 113
    .line 114
    .line 115
    invoke-virtual {p2, v8}, Landroid/view/View;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 116
    .line 117
    .line 118
    invoke-virtual {v2}, Lorg/bitspark/android/beans/ChannelBean;->getLogo()Lorg/bitspark/android/beans/ChannelBean$LogoBean;

    .line 119
    .line 120
    .line 121
    move-result-object p2

    .line 122
    invoke-virtual {p2}, Lorg/bitspark/android/beans/ChannelBean$LogoBean;->getImage()Lorg/bitspark/android/beans/ChannelBean$LogoBean$ImageBean;

    .line 123
    .line 124
    .line 125
    move-result-object p2

    .line 126
    invoke-virtual {p2}, Lorg/bitspark/android/beans/ChannelBean$LogoBean$ImageBean;->getBig()Ljava/lang/String;

    .line 127
    .line 128
    .line 129
    move-result-object v0

    .line 130
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    .line 131
    .line 132
    .line 133
    move-result v0

    .line 134
    if-nez v0, :cond_1

    .line 135
    .line 136
    invoke-virtual {p2}, Lorg/bitspark/android/beans/ChannelBean$LogoBean$ImageBean;->getBig()Ljava/lang/String;

    .line 137
    .line 138
    .line 139
    goto :goto_1

    .line 140
    :cond_1
    invoke-virtual {p2}, Lorg/bitspark/android/beans/ChannelBean$LogoBean$ImageBean;->getSmall()Ljava/lang/String;

    .line 141
    .line 142
    .line 143
    :goto_1
    iget p2, p0, Lfa/d0;->c:I

    .line 144
    .line 145
    const/4 v0, -0x3

    .line 146
    if-eq p2, v0, :cond_2

    .line 147
    .line 148
    invoke-virtual {v2}, Lorg/bitspark/android/beans/ChannelBean;->getSid()I

    .line 149
    .line 150
    .line 151
    move-result p2

    .line 152
    if-lez p2, :cond_2

    .line 153
    .line 154
    new-instance p2, Ljava/lang/StringBuilder;

    .line 155
    .line 156
    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    .line 157
    .line 158
    .line 159
    invoke-virtual {v2}, Lorg/bitspark/android/beans/ChannelBean;->getSid()I

    .line 160
    .line 161
    .line 162
    move-result v0

    .line 163
    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 164
    .line 165
    .line 166
    const-string v0, "FA==\n"

    .line 167
    .line 168
    const-string v1, "Ot+sv26+NRI=\n"

    .line 169
    .line 170
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 171
    .line 172
    .line 173
    move-result-object v0

    .line 174
    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 175
    .line 176
    .line 177
    invoke-virtual {p2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 178
    .line 179
    .line 180
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 181
    .line 182
    .line 183
    move-result-object v4

    .line 184
    :cond_2
    iget-object p2, p1, Lfa/c0;->a:Landroid/widget/TextView;

    .line 185
    .line 186
    invoke-virtual {p2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 187
    .line 188
    .line 189
    if-eqz v7, :cond_3

    .line 190
    .line 191
    iget-object p2, p1, Lfa/c0;->b:Landroid/widget/TextView;

    .line 192
    .line 193
    invoke-virtual {p2, v9}, Landroid/view/View;->setVisibility(I)V

    .line 194
    .line 195
    .line 196
    iget-object p2, p1, Lfa/c0;->e:Landroid/widget/TextView;

    .line 197
    .line 198
    invoke-virtual {p2, v6}, Landroid/view/View;->setVisibility(I)V

    .line 199
    .line 200
    .line 201
    goto :goto_2

    .line 202
    :cond_3
    iget-object p2, p1, Lfa/c0;->b:Landroid/widget/TextView;

    .line 203
    .line 204
    invoke-virtual {p2, v6}, Landroid/view/View;->setVisibility(I)V

    .line 205
    .line 206
    .line 207
    iget-object p2, p1, Lfa/c0;->e:Landroid/widget/TextView;

    .line 208
    .line 209
    invoke-virtual {p2, v9}, Landroid/view/View;->setVisibility(I)V

    .line 210
    .line 211
    .line 212
    iget-object p2, p1, Lfa/c0;->b:Landroid/widget/TextView;

    .line 213
    .line 214
    invoke-virtual {p2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 215
    .line 216
    .line 217
    :goto_2
    iget-object p2, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 218
    .line 219
    invoke-virtual {p2, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 220
    .line 221
    .line 222
    sget-object p2, Lga/d;->f:Ljava/util/HashSet;

    .line 223
    .line 224
    new-instance v0, Ljava/lang/StringBuilder;

    .line 225
    .line 226
    invoke-direct {v0, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 227
    .line 228
    .line 229
    invoke-virtual {v2}, Lorg/bitspark/android/beans/ChannelBean;->getChid()I

    .line 230
    .line 231
    .line 232
    move-result v1

    .line 233
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 234
    .line 235
    .line 236
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 237
    .line 238
    .line 239
    move-result-object v0

    .line 240
    invoke-virtual {p2, v0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    .line 241
    .line 242
    .line 243
    move-result p2

    .line 244
    if-eqz p2, :cond_4

    .line 245
    .line 246
    iget-object p1, p1, Lfa/c0;->d:Landroid/widget/ImageView;

    .line 247
    .line 248
    invoke-virtual {p1, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 249
    .line 250
    .line 251
    goto :goto_3

    .line 252
    :cond_4
    iget-object p1, p1, Lfa/c0;->d:Landroid/widget/ImageView;

    .line 253
    .line 254
    invoke-virtual {p1, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 255
    .line 256
    .line 257
    :goto_3
    return-void
.end method

.method public final onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/p1;
    .locals 1

    .line 1
    const p2, 0x7f0e00f4

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    invoke-static {p1, p2, p1, v0}, La/e;->i(Landroid/view/ViewGroup;ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    new-instance p2, Lfa/c0;

    .line 10
    .line 11
    invoke-direct {p2, p1}, Landroidx/recyclerview/widget/p1;-><init>(Landroid/view/View;)V

    .line 12
    .line 13
    .line 14
    const v0, 0x7f0b00c4

    .line 15
    .line 16
    .line 17
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    check-cast v0, Landroid/widget/ImageView;

    .line 22
    .line 23
    iput-object v0, p2, Lfa/c0;->d:Landroid/widget/ImageView;

    .line 24
    .line 25
    const v0, 0x7f0b00c2

    .line 26
    .line 27
    .line 28
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 29
    .line 30
    .line 31
    move-result-object v0

    .line 32
    check-cast v0, Landroid/widget/TextView;

    .line 33
    .line 34
    iput-object v0, p2, Lfa/c0;->a:Landroid/widget/TextView;

    .line 35
    .line 36
    const v0, 0x7f0b041d

    .line 37
    .line 38
    .line 39
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    check-cast v0, Landroid/widget/TextView;

    .line 44
    .line 45
    iput-object v0, p2, Lfa/c0;->e:Landroid/widget/TextView;

    .line 46
    .line 47
    const v0, 0x7f0b0350

    .line 48
    .line 49
    .line 50
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 51
    .line 52
    .line 53
    move-result-object v0

    .line 54
    check-cast v0, Landroid/widget/TextView;

    .line 55
    .line 56
    iput-object v0, p2, Lfa/c0;->b:Landroid/widget/TextView;

    .line 57
    .line 58
    const v0, 0x7f0b00c1

    .line 59
    .line 60
    .line 61
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 62
    .line 63
    .line 64
    move-result-object p1

    .line 65
    check-cast p1, Landroid/widget/ImageView;

    .line 66
    .line 67
    iput-object p1, p2, Lfa/c0;->c:Landroid/widget/ImageView;

    .line 68
    .line 69
    return-object p2
.end method

.method public final onViewRecycled(Landroidx/recyclerview/widget/p1;)V
    .locals 2

    .line 1
    check-cast p1, Lfa/c0;

    .line 2
    .line 3
    invoke-super {p0, p1}, Landroidx/recyclerview/widget/k0;->onViewRecycled(Landroidx/recyclerview/widget/p1;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 7
    .line 8
    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-static {v0}, Lcom/bumptech/glide/b;->e(Landroid/content/Context;)Lcom/bumptech/glide/o;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    iget-object v1, p1, Lfa/c0;->d:Landroid/widget/ImageView;

    .line 17
    .line 18
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/o;->k(Landroid/widget/ImageView;)V

    .line 19
    .line 20
    .line 21
    iget-object v0, p1, Landroidx/recyclerview/widget/p1;->itemView:Landroid/view/View;

    .line 22
    .line 23
    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    invoke-static {v0}, Lcom/bumptech/glide/b;->e(Landroid/content/Context;)Lcom/bumptech/glide/o;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    iget-object p1, p1, Lfa/c0;->c:Landroid/widget/ImageView;

    .line 32
    .line 33
    invoke-virtual {v0, p1}, Lcom/bumptech/glide/o;->k(Landroid/widget/ImageView;)V

    .line 34
    .line 35
    .line 36
    return-void
.end method
