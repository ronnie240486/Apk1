.class public final Lcom/google/android/gms/cast/framework/internal/featurehighlight/d;
.super Landroid/animation/AnimatorListenerAdapter;
.source "MyApplication"


# instance fields
.field public final synthetic a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/d;->a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 2
    .line 3
    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 10

    .line 1
    const/4 p1, 0x2

    .line 2
    new-instance v0, Landroid/animation/AnimatorSet;

    .line 3
    .line 4
    invoke-direct {v0}, Landroid/animation/AnimatorSet;-><init>()V

    .line 5
    .line 6
    .line 7
    new-array v1, p1, [F

    .line 8
    .line 9
    fill-array-data v1, :array_0

    .line 10
    .line 11
    .line 12
    iget-object v2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/d;->a:Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 13
    .line 14
    iget-object v3, v2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 15
    .line 16
    const-string v4, "scale"

    .line 17
    .line 18
    invoke-static {v3, v4, v1}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    const-wide/16 v5, 0x1f4

    .line 23
    .line 24
    invoke-virtual {v1, v5, v6}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 25
    .line 26
    .line 27
    move-result-object v1

    .line 28
    new-array v7, p1, [F

    .line 29
    .line 30
    fill-array-data v7, :array_1

    .line 31
    .line 32
    .line 33
    invoke-static {v3, v4, v7}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    .line 34
    .line 35
    .line 36
    move-result-object v4

    .line 37
    invoke-virtual {v4, v5, v6}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 38
    .line 39
    .line 40
    move-result-object v4

    .line 41
    new-array v7, p1, [F

    .line 42
    .line 43
    fill-array-data v7, :array_2

    .line 44
    .line 45
    .line 46
    const-string v8, "pulseScale"

    .line 47
    .line 48
    invoke-static {v8, v7}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 49
    .line 50
    .line 51
    move-result-object v7

    .line 52
    new-array v8, p1, [F

    .line 53
    .line 54
    fill-array-data v8, :array_3

    .line 55
    .line 56
    .line 57
    const-string v9, "pulseAlpha"

    .line 58
    .line 59
    invoke-static {v9, v8}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    .line 60
    .line 61
    .line 62
    move-result-object v8

    .line 63
    new-array p1, p1, [Landroid/animation/PropertyValuesHolder;

    .line 64
    .line 65
    const/4 v9, 0x0

    .line 66
    aput-object v7, p1, v9

    .line 67
    .line 68
    const/4 v7, 0x1

    .line 69
    aput-object v8, p1, v7

    .line 70
    .line 71
    invoke-static {v3, p1}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    .line 72
    .line 73
    .line 74
    move-result-object p1

    .line 75
    invoke-virtual {p1, v5, v6}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 76
    .line 77
    .line 78
    move-result-object p1

    .line 79
    invoke-virtual {v0, v1}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 80
    .line 81
    .line 82
    invoke-virtual {v0, v4}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 83
    .line 84
    .line 85
    move-result-object v3

    .line 86
    invoke-virtual {v3, p1}, Landroid/animation/AnimatorSet$Builder;->with(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 87
    .line 88
    .line 89
    move-result-object p1

    .line 90
    invoke-virtual {p1, v1}, Landroid/animation/AnimatorSet$Builder;->after(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 91
    .line 92
    .line 93
    sget-object p1, Lcom/google/android/gms/internal/cast/o1;->c:Landroid/view/animation/Interpolator;

    .line 94
    .line 95
    invoke-virtual {v0, p1}, Landroid/animation/AnimatorSet;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 96
    .line 97
    .line 98
    invoke-virtual {v0, v5, v6}, Landroid/animation/AnimatorSet;->setStartDelay(J)V

    .line 99
    .line 100
    .line 101
    new-instance p1, Lcom/google/android/gms/internal/cast/k1;

    .line 102
    .line 103
    invoke-direct {p1, v0}, Lcom/google/android/gms/internal/cast/k1;-><init>(Landroid/animation/AnimatorSet;)V

    .line 104
    .line 105
    .line 106
    invoke-virtual {v0, p1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 107
    .line 108
    .line 109
    iput-object v0, v2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 110
    .line 111
    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    .line 112
    .line 113
    .line 114
    return-void

    .line 115
    :array_0
    .array-data 4
        0x3f800000    # 1.0f
        0x3f8ccccd    # 1.1f
    .end array-data

    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    :array_1
    .array-data 4
        0x3f8ccccd    # 1.1f
        0x3f800000    # 1.0f
    .end array-data

    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    :array_2
    .array-data 4
        0x3f8ccccd    # 1.1f
        0x40000000    # 2.0f
    .end array-data

    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    :array_3
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data
.end method
