.class public final Lcom/google/android/gms/cast/framework/internal/featurehighlight/a;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "MyApplication"


# instance fields
.field public final synthetic a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/a;->a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 2
    .line 3
    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
.end method


# virtual methods
.method public final onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 16

    .line 1
    const/4 v0, 0x3

    .line 2
    const/4 v1, 0x2

    .line 3
    const/4 v2, 0x0

    .line 4
    const/4 v3, 0x1

    .line 5
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    .line 6
    .line 7
    .line 8
    move-result v4

    .line 9
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    .line 10
    .line 11
    .line 12
    move-result v5

    .line 13
    move-object/from16 v6, p0

    .line 14
    .line 15
    iget-object v7, v6, Lcom/google/android/gms/cast/framework/internal/featurehighlight/a;->a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 16
    .line 17
    iget-object v8, v7, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->k:La1/b;

    .line 18
    .line 19
    if-eqz v8, :cond_3

    .line 20
    .line 21
    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    .line 22
    .line 23
    .line 24
    move-result v8

    .line 25
    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    .line 26
    .line 27
    .line 28
    move-result v9

    .line 29
    iget-object v10, v7, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->c:Landroid/graphics/Rect;

    .line 30
    .line 31
    invoke-virtual {v10, v8, v9}, Landroid/graphics/Rect;->contains(II)Z

    .line 32
    .line 33
    .line 34
    move-result v8

    .line 35
    if-eqz v8, :cond_0

    .line 36
    .line 37
    iget-object v8, v7, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 38
    .line 39
    iget v9, v8, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->i:F

    .line 40
    .line 41
    iget v10, v8, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->j:F

    .line 42
    .line 43
    invoke-static {v4, v5, v9, v10}, Lcom/google/android/gms/internal/cast/a1;->a(FFFF)F

    .line 44
    .line 45
    .line 46
    move-result v4

    .line 47
    iget v5, v8, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->g:F

    .line 48
    .line 49
    cmpg-float v4, v4, v5

    .line 50
    .line 51
    if-gez v4, :cond_0

    .line 52
    .line 53
    goto/16 :goto_0

    .line 54
    .line 55
    :cond_0
    iget-object v4, v7, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->k:La1/b;

    .line 56
    .line 57
    iget-object v5, v4, La1/b;->d:Ljava/lang/Object;

    .line 58
    .line 59
    check-cast v5, Lcom/google/android/gms/internal/cast/o;

    .line 60
    .line 61
    iget-boolean v5, v5, Lcom/google/android/gms/internal/cast/o;->f:Z

    .line 62
    .line 63
    if-nez v5, :cond_1

    .line 64
    .line 65
    goto/16 :goto_0

    .line 66
    .line 67
    :cond_1
    iget-object v5, v4, La1/b;->b:Ljava/lang/Object;

    .line 68
    .line 69
    check-cast v5, Lorg/bitspark/android/Spark;

    .line 70
    .line 71
    invoke-static {v5}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    .line 72
    .line 73
    .line 74
    move-result-object v7

    .line 75
    invoke-interface {v7}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    .line 76
    .line 77
    .line 78
    move-result-object v7

    .line 79
    const-string v8, "googlecast-introOverlayShown"

    .line 80
    .line 81
    invoke-interface {v7, v8, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 82
    .line 83
    .line 84
    move-result-object v7

    .line 85
    invoke-interface {v7}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 86
    .line 87
    .line 88
    new-instance v7, Lcom/google/android/gms/internal/cast/n;

    .line 89
    .line 90
    invoke-direct {v7, v4, v3, v5}, Lcom/google/android/gms/internal/cast/n;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 91
    .line 92
    .line 93
    iget-object v4, v4, La1/b;->c:Ljava/lang/Object;

    .line 94
    .line 95
    check-cast v4, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 96
    .line 97
    iget-object v5, v4, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->m:Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;

    .line 98
    .line 99
    invoke-virtual {v5}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;->asView()Landroid/view/View;

    .line 100
    .line 101
    .line 102
    move-result-object v5

    .line 103
    const/4 v8, 0x0

    .line 104
    new-array v9, v3, [F

    .line 105
    .line 106
    aput v8, v9, v2

    .line 107
    .line 108
    const-string v10, "alpha"

    .line 109
    .line 110
    invoke-static {v5, v10, v9}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    .line 111
    .line 112
    .line 113
    move-result-object v5

    .line 114
    const-wide/16 v11, 0xc8

    .line 115
    .line 116
    invoke-virtual {v5, v11, v12}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 117
    .line 118
    .line 119
    move-result-object v5

    .line 120
    sget-object v9, Lcom/google/android/gms/internal/cast/o1;->b:Landroid/view/animation/Interpolator;

    .line 121
    .line 122
    invoke-virtual {v5, v9}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 123
    .line 124
    .line 125
    iget-object v13, v4, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->b:Landroid/graphics/Rect;

    .line 126
    .line 127
    invoke-virtual {v13}, Landroid/graphics/Rect;->exactCenterX()F

    .line 128
    .line 129
    .line 130
    move-result v14

    .line 131
    iget-object v15, v4, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 132
    .line 133
    iget v11, v15, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->i:F

    .line 134
    .line 135
    sub-float/2addr v14, v11

    .line 136
    invoke-virtual {v13}, Landroid/graphics/Rect;->exactCenterY()F

    .line 137
    .line 138
    .line 139
    move-result v11

    .line 140
    iget v12, v15, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->j:F

    .line 141
    .line 142
    sub-float/2addr v11, v12

    .line 143
    new-array v12, v3, [F

    .line 144
    .line 145
    aput v8, v12, v2

    .line 146
    .line 147
    const-string v13, "scale"

    .line 148
    .line 149
    invoke-static {v13, v12}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 150
    .line 151
    .line 152
    move-result-object v12

    .line 153
    filled-new-array {v2}, [I

    .line 154
    .line 155
    .line 156
    move-result-object v13

    .line 157
    invoke-static {v10, v13}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    .line 158
    .line 159
    .line 160
    move-result-object v10

    .line 161
    new-array v13, v1, [F

    .line 162
    .line 163
    aput v8, v13, v2

    .line 164
    .line 165
    aput v14, v13, v3

    .line 166
    .line 167
    const-string v14, "translationX"

    .line 168
    .line 169
    invoke-static {v14, v13}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 170
    .line 171
    .line 172
    move-result-object v13

    .line 173
    new-array v14, v1, [F

    .line 174
    .line 175
    aput v8, v14, v2

    .line 176
    .line 177
    aput v11, v14, v3

    .line 178
    .line 179
    const-string v8, "translationY"

    .line 180
    .line 181
    invoke-static {v8, v14}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 182
    .line 183
    .line 184
    move-result-object v8

    .line 185
    const/4 v11, 0x4

    .line 186
    new-array v11, v11, [Landroid/animation/PropertyValuesHolder;

    .line 187
    .line 188
    aput-object v12, v11, v2

    .line 189
    .line 190
    aput-object v13, v11, v3

    .line 191
    .line 192
    aput-object v8, v11, v1

    .line 193
    .line 194
    aput-object v10, v11, v0

    .line 195
    .line 196
    invoke-static {v15, v11}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    .line 197
    .line 198
    .line 199
    move-result-object v8

    .line 200
    invoke-virtual {v8, v9}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 201
    .line 202
    .line 203
    const-wide/16 v9, 0xc8

    .line 204
    .line 205
    invoke-virtual {v8, v9, v10}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 206
    .line 207
    .line 208
    move-result-object v8

    .line 209
    iget-object v9, v4, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 210
    .line 211
    invoke-virtual {v9}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;->a()Landroid/animation/Animator;

    .line 212
    .line 213
    .line 214
    move-result-object v9

    .line 215
    new-instance v10, Landroid/animation/AnimatorSet;

    .line 216
    .line 217
    invoke-direct {v10}, Landroid/animation/AnimatorSet;-><init>()V

    .line 218
    .line 219
    .line 220
    new-array v0, v0, [Landroid/animation/Animator;

    .line 221
    .line 222
    aput-object v5, v0, v2

    .line 223
    .line 224
    aput-object v8, v0, v3

    .line 225
    .line 226
    aput-object v9, v0, v1

    .line 227
    .line 228
    invoke-virtual {v10, v0}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 229
    .line 230
    .line 231
    new-instance v0, La7/d;

    .line 232
    .line 233
    invoke-direct {v0, v1, v4, v7, v2}, La7/d;-><init>(ILjava/lang/Object;Ljava/lang/Object;Z)V

    .line 234
    .line 235
    .line 236
    invoke-virtual {v10, v0}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 237
    .line 238
    .line 239
    iget-object v0, v4, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 240
    .line 241
    if-eqz v0, :cond_2

    .line 242
    .line 243
    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    .line 244
    .line 245
    .line 246
    :cond_2
    iput-object v10, v4, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 247
    .line 248
    invoke-virtual {v10}, Landroid/animation/Animator;->start()V

    .line 249
    .line 250
    .line 251
    :cond_3
    :goto_0
    return v3
.end method
