.class public final Lcom/google/android/gms/cast/framework/internal/featurehighlight/b;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "MyApplication"


# instance fields
.field public final synthetic a:Landroidx/mediarouter/app/MediaRouteButton;

.field public final synthetic b:La1/b;


# direct methods
.method public constructor <init>(Landroidx/mediarouter/app/MediaRouteButton;La1/b;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/b;->a:Landroidx/mediarouter/app/MediaRouteButton;

    .line 2
    .line 3
    iput-object p2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/b;->b:La1/b;

    .line 4
    .line 5
    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
.end method


# virtual methods
.method public final onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 11

    .line 1
    const/4 p1, 0x2

    .line 2
    const/4 v0, 0x1

    .line 3
    const/4 v1, 0x0

    .line 4
    iget-object v2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/b;->a:Landroidx/mediarouter/app/MediaRouteButton;

    .line 5
    .line 6
    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 7
    .line 8
    .line 9
    move-result-object v3

    .line 10
    if-eqz v3, :cond_0

    .line 11
    .line 12
    invoke-virtual {v2}, Landroidx/mediarouter/app/MediaRouteButton;->performClick()Z

    .line 13
    .line 14
    .line 15
    :cond_0
    iget-object v2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/b;->b:La1/b;

    .line 16
    .line 17
    iget-object v3, v2, La1/b;->d:Ljava/lang/Object;

    .line 18
    .line 19
    check-cast v3, Lcom/google/android/gms/internal/cast/o;

    .line 20
    .line 21
    iget-boolean v3, v3, Lcom/google/android/gms/internal/cast/o;->f:Z

    .line 22
    .line 23
    if-nez v3, :cond_1

    .line 24
    .line 25
    goto/16 :goto_0

    .line 26
    .line 27
    :cond_1
    iget-object v3, v2, La1/b;->b:Ljava/lang/Object;

    .line 28
    .line 29
    check-cast v3, Lorg/bitspark/android/Spark;

    .line 30
    .line 31
    invoke-static {v3}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    .line 32
    .line 33
    .line 34
    move-result-object v4

    .line 35
    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    .line 36
    .line 37
    .line 38
    move-result-object v4

    .line 39
    const-string v5, "googlecast-introOverlayShown"

    .line 40
    .line 41
    invoke-interface {v4, v5, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 42
    .line 43
    .line 44
    move-result-object v4

    .line 45
    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 46
    .line 47
    .line 48
    new-instance v4, Lcom/google/android/gms/internal/cast/n;

    .line 49
    .line 50
    invoke-direct {v4, v2, v1, v3}, Lcom/google/android/gms/internal/cast/n;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 51
    .line 52
    .line 53
    iget-object v2, v2, La1/b;->c:Ljava/lang/Object;

    .line 54
    .line 55
    check-cast v2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 56
    .line 57
    iget-object v3, v2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->m:Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;

    .line 58
    .line 59
    invoke-virtual {v3}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;->asView()Landroid/view/View;

    .line 60
    .line 61
    .line 62
    move-result-object v3

    .line 63
    new-array v5, v0, [F

    .line 64
    .line 65
    const/4 v6, 0x0

    .line 66
    aput v6, v5, v1

    .line 67
    .line 68
    const-string v6, "alpha"

    .line 69
    .line 70
    invoke-static {v3, v6, v5}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    .line 71
    .line 72
    .line 73
    move-result-object v3

    .line 74
    const-wide/16 v7, 0xc8

    .line 75
    .line 76
    invoke-virtual {v3, v7, v8}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 77
    .line 78
    .line 79
    move-result-object v3

    .line 80
    sget-object v5, Lcom/google/android/gms/internal/cast/o1;->b:Landroid/view/animation/Interpolator;

    .line 81
    .line 82
    invoke-virtual {v3, v5}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 83
    .line 84
    .line 85
    new-array v9, v0, [F

    .line 86
    .line 87
    const/high16 v10, 0x3f900000    # 1.125f

    .line 88
    .line 89
    aput v10, v9, v1

    .line 90
    .line 91
    const-string v10, "scale"

    .line 92
    .line 93
    invoke-static {v10, v9}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 94
    .line 95
    .line 96
    move-result-object v9

    .line 97
    filled-new-array {v1}, [I

    .line 98
    .line 99
    .line 100
    move-result-object v10

    .line 101
    invoke-static {v6, v10}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    .line 102
    .line 103
    .line 104
    move-result-object v6

    .line 105
    new-array v10, p1, [Landroid/animation/PropertyValuesHolder;

    .line 106
    .line 107
    aput-object v9, v10, v1

    .line 108
    .line 109
    aput-object v6, v10, v0

    .line 110
    .line 111
    iget-object v6, v2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 112
    .line 113
    invoke-static {v6, v10}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    .line 114
    .line 115
    .line 116
    move-result-object v6

    .line 117
    invoke-virtual {v6, v5}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 118
    .line 119
    .line 120
    invoke-virtual {v6, v7, v8}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 121
    .line 122
    .line 123
    move-result-object v5

    .line 124
    iget-object v6, v2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 125
    .line 126
    invoke-virtual {v6}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;->a()Landroid/animation/Animator;

    .line 127
    .line 128
    .line 129
    move-result-object v6

    .line 130
    new-instance v7, Landroid/animation/AnimatorSet;

    .line 131
    .line 132
    invoke-direct {v7}, Landroid/animation/AnimatorSet;-><init>()V

    .line 133
    .line 134
    .line 135
    const/4 v8, 0x3

    .line 136
    new-array v8, v8, [Landroid/animation/Animator;

    .line 137
    .line 138
    aput-object v3, v8, v1

    .line 139
    .line 140
    aput-object v5, v8, v0

    .line 141
    .line 142
    aput-object v6, v8, p1

    .line 143
    .line 144
    invoke-virtual {v7, v8}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 145
    .line 146
    .line 147
    new-instance p1, La7/d;

    .line 148
    .line 149
    invoke-direct {p1, v0, v2, v4, v1}, La7/d;-><init>(ILjava/lang/Object;Ljava/lang/Object;Z)V

    .line 150
    .line 151
    .line 152
    invoke-virtual {v7, p1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 153
    .line 154
    .line 155
    iget-object p1, v2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 156
    .line 157
    if-eqz p1, :cond_2

    .line 158
    .line 159
    invoke-virtual {p1}, Landroid/animation/Animator;->cancel()V

    .line 160
    .line 161
    .line 162
    :cond_2
    iput-object v7, v2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 163
    .line 164
    invoke-virtual {v7}, Landroid/animation/Animator;->start()V

    .line 165
    .line 166
    .line 167
    :goto_0
    return v0
.end method
