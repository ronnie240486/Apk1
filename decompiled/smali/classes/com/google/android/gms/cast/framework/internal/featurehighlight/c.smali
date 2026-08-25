.class public final Lcom/google/android/gms/cast/framework/internal/featurehighlight/c;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Landroid/view/View$OnLayoutChangeListener;


# instance fields
.field public final synthetic a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/c;->a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 5
    .line 6
    return-void
.end method


# virtual methods
.method public final onLayoutChange(Landroid/view/View;IIIIIIII)V
    .locals 16

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    const/4 v1, 0x3

    .line 4
    const/4 v2, 0x1

    .line 5
    const/4 v3, 0x0

    .line 6
    const/4 v4, 0x2

    .line 7
    iget-object v5, v0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/c;->a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 8
    .line 9
    iget-object v6, v5, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 10
    .line 11
    if-eqz v6, :cond_1

    .line 12
    .line 13
    invoke-virtual {v5, v3}, Landroid/view/View;->setVisibility(I)V

    .line 14
    .line 15
    .line 16
    iget-object v6, v5, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->m:Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;

    .line 17
    .line 18
    invoke-virtual {v6}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;->asView()Landroid/view/View;

    .line 19
    .line 20
    .line 21
    move-result-object v6

    .line 22
    const/4 v7, 0x0

    .line 23
    new-array v8, v4, [F

    .line 24
    .line 25
    fill-array-data v8, :array_0

    .line 26
    .line 27
    .line 28
    const-string v9, "alpha"

    .line 29
    .line 30
    invoke-static {v6, v9, v8}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    .line 31
    .line 32
    .line 33
    move-result-object v6

    .line 34
    const-wide/16 v10, 0x15e

    .line 35
    .line 36
    invoke-virtual {v6, v10, v11}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 37
    .line 38
    .line 39
    move-result-object v6

    .line 40
    sget-object v8, Lcom/google/android/gms/internal/cast/o1;->a:Landroid/view/animation/Interpolator;

    .line 41
    .line 42
    invoke-virtual {v6, v8}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 43
    .line 44
    .line 45
    iget-object v12, v5, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->b:Landroid/graphics/Rect;

    .line 46
    .line 47
    invoke-virtual {v12}, Landroid/graphics/Rect;->exactCenterX()F

    .line 48
    .line 49
    .line 50
    move-result v13

    .line 51
    iget-object v14, v5, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 52
    .line 53
    iget v15, v14, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->i:F

    .line 54
    .line 55
    sub-float/2addr v13, v15

    .line 56
    invoke-virtual {v12}, Landroid/graphics/Rect;->exactCenterY()F

    .line 57
    .line 58
    .line 59
    move-result v12

    .line 60
    iget v15, v14, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->j:F

    .line 61
    .line 62
    sub-float/2addr v12, v15

    .line 63
    new-array v15, v4, [F

    .line 64
    .line 65
    fill-array-data v15, :array_1

    .line 66
    .line 67
    .line 68
    const-string v10, "scale"

    .line 69
    .line 70
    invoke-static {v10, v15}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 71
    .line 72
    .line 73
    move-result-object v11

    .line 74
    new-array v15, v4, [F

    .line 75
    .line 76
    aput v13, v15, v3

    .line 77
    .line 78
    aput v7, v15, v2

    .line 79
    .line 80
    const-string v13, "translationX"

    .line 81
    .line 82
    invoke-static {v13, v15}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 83
    .line 84
    .line 85
    move-result-object v13

    .line 86
    new-array v15, v4, [F

    .line 87
    .line 88
    aput v12, v15, v3

    .line 89
    .line 90
    aput v7, v15, v2

    .line 91
    .line 92
    const-string v7, "translationY"

    .line 93
    .line 94
    invoke-static {v7, v15}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 95
    .line 96
    .line 97
    move-result-object v7

    .line 98
    iget v12, v14, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->m:I

    .line 99
    .line 100
    filled-new-array {v3, v12}, [I

    .line 101
    .line 102
    .line 103
    move-result-object v12

    .line 104
    invoke-static {v9, v12}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    .line 105
    .line 106
    .line 107
    move-result-object v12

    .line 108
    const/4 v15, 0x4

    .line 109
    new-array v15, v15, [Landroid/animation/PropertyValuesHolder;

    .line 110
    .line 111
    aput-object v11, v15, v3

    .line 112
    .line 113
    aput-object v13, v15, v2

    .line 114
    .line 115
    aput-object v7, v15, v4

    .line 116
    .line 117
    aput-object v12, v15, v1

    .line 118
    .line 119
    invoke-static {v14, v15}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    .line 120
    .line 121
    .line 122
    move-result-object v7

    .line 123
    invoke-virtual {v7, v8}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 124
    .line 125
    .line 126
    const-wide/16 v11, 0x15e

    .line 127
    .line 128
    invoke-virtual {v7, v11, v12}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 129
    .line 130
    .line 131
    move-result-object v7

    .line 132
    new-array v11, v4, [F

    .line 133
    .line 134
    fill-array-data v11, :array_2

    .line 135
    .line 136
    .line 137
    invoke-static {v10, v11}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 138
    .line 139
    .line 140
    move-result-object v10

    .line 141
    const/16 v11, 0xff

    .line 142
    .line 143
    filled-new-array {v3, v11}, [I

    .line 144
    .line 145
    .line 146
    move-result-object v11

    .line 147
    invoke-static {v9, v11}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    .line 148
    .line 149
    .line 150
    move-result-object v9

    .line 151
    new-array v11, v4, [Landroid/animation/PropertyValuesHolder;

    .line 152
    .line 153
    aput-object v10, v11, v3

    .line 154
    .line 155
    aput-object v9, v11, v2

    .line 156
    .line 157
    iget-object v9, v5, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 158
    .line 159
    invoke-static {v9, v11}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    .line 160
    .line 161
    .line 162
    move-result-object v9

    .line 163
    invoke-virtual {v9, v8}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 164
    .line 165
    .line 166
    const-wide/16 v10, 0x15e

    .line 167
    .line 168
    invoke-virtual {v9, v10, v11}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 169
    .line 170
    .line 171
    move-result-object v8

    .line 172
    new-instance v9, Landroid/animation/AnimatorSet;

    .line 173
    .line 174
    invoke-direct {v9}, Landroid/animation/AnimatorSet;-><init>()V

    .line 175
    .line 176
    .line 177
    new-array v1, v1, [Landroid/animation/Animator;

    .line 178
    .line 179
    aput-object v6, v1, v3

    .line 180
    .line 181
    aput-object v7, v1, v2

    .line 182
    .line 183
    aput-object v8, v1, v4

    .line 184
    .line 185
    invoke-virtual {v9, v1}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 186
    .line 187
    .line 188
    new-instance v1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/d;

    .line 189
    .line 190
    invoke-direct {v1, v5}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/d;-><init>(Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;)V

    .line 191
    .line 192
    .line 193
    invoke-virtual {v9, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 194
    .line 195
    .line 196
    iget-object v1, v5, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 197
    .line 198
    if-eqz v1, :cond_0

    .line 199
    .line 200
    invoke-virtual {v1}, Landroid/animation/Animator;->cancel()V

    .line 201
    .line 202
    .line 203
    :cond_0
    iput-object v9, v5, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 204
    .line 205
    invoke-virtual {v9}, Landroid/animation/Animator;->start()V

    .line 206
    .line 207
    .line 208
    invoke-virtual {v5, v0}, Landroid/view/View;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 209
    .line 210
    .line 211
    return-void

    .line 212
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    .line 213
    .line 214
    const-string v2, "Target view must be set before animation"

    .line 215
    .line 216
    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 217
    .line 218
    .line 219
    throw v1

    .line 220
    nop

    .line 221
    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    :array_1
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    :array_2
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method
