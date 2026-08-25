.class public final Lcom/google/android/gms/internal/cast/k1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "MyApplication"


# instance fields
.field public final synthetic a:I

.field public final b:I

.field public c:I

.field public final d:Ljava/lang/Object;

.field public final e:Ljava/lang/Object;

.field public final f:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Landroid/animation/AnimatorSet;)V
    .locals 2

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/internal/cast/k1;->a:I

    .line 1
    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    .line 2
    new-instance v0, Lp/k;

    const/4 v1, 0x0

    .line 3
    invoke-direct {v0, v1}, Lp/k;-><init>(I)V

    .line 4
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/k1;->d:Ljava/lang/Object;

    .line 5
    new-instance v0, Lcom/google/android/gms/internal/cast/w;

    .line 6
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 7
    iput-object p0, v0, Lcom/google/android/gms/internal/cast/w;->b:Ljava/lang/Object;

    .line 8
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/k1;->f:Ljava/lang/Object;

    iput-object p1, p0, Lcom/google/android/gms/internal/cast/k1;->e:Ljava/lang/Object;

    const/4 p1, -0x1

    iput p1, p0, Lcom/google/android/gms/internal/cast/k1;->b:I

    return-void
.end method

.method public constructor <init>(Lcom/google/android/material/textfield/p;ILandroid/widget/TextView;ILandroid/widget/TextView;)V
    .locals 1

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/cast/k1;->a:I

    .line 9
    iput-object p1, p0, Lcom/google/android/gms/internal/cast/k1;->f:Ljava/lang/Object;

    iput p2, p0, Lcom/google/android/gms/internal/cast/k1;->b:I

    iput-object p3, p0, Lcom/google/android/gms/internal/cast/k1;->d:Ljava/lang/Object;

    iput p4, p0, Lcom/google/android/gms/internal/cast/k1;->c:I

    iput-object p5, p0, Lcom/google/android/gms/internal/cast/k1;->e:Ljava/lang/Object;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/gms/internal/cast/k1;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    invoke-super {p0, p1}, Landroid/animation/AnimatorListenerAdapter;->onAnimationCancel(Landroid/animation/Animator;)V

    .line 7
    .line 8
    .line 9
    return-void

    .line 10
    :pswitch_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/k1;->d:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast v0, Lp/k;

    .line 13
    .line 14
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 15
    .line 16
    invoke-virtual {v0, p1, v1}, Lp/k;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    nop

    .line 21
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 3

    .line 1
    iget v0, p0, Lcom/google/android/gms/internal/cast/k1;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget p1, p0, Lcom/google/android/gms/internal/cast/k1;->b:I

    .line 7
    .line 8
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/k1;->f:Ljava/lang/Object;

    .line 9
    .line 10
    check-cast v0, Lcom/google/android/material/textfield/p;

    .line 11
    .line 12
    iput p1, v0, Lcom/google/android/material/textfield/p;->h:I

    .line 13
    .line 14
    const/4 p1, 0x0

    .line 15
    iput-object p1, v0, Lcom/google/android/material/textfield/p;->f:Landroid/animation/AnimatorSet;

    .line 16
    .line 17
    iget-object v1, p0, Lcom/google/android/gms/internal/cast/k1;->d:Ljava/lang/Object;

    .line 18
    .line 19
    check-cast v1, Landroid/widget/TextView;

    .line 20
    .line 21
    if-eqz v1, :cond_0

    .line 22
    .line 23
    const/4 v2, 0x4

    .line 24
    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 25
    .line 26
    .line 27
    iget v1, p0, Lcom/google/android/gms/internal/cast/k1;->c:I

    .line 28
    .line 29
    const/4 v2, 0x1

    .line 30
    if-ne v1, v2, :cond_0

    .line 31
    .line 32
    iget-object v0, v0, Lcom/google/android/material/textfield/p;->l:Landroidx/appcompat/widget/AppCompatTextView;

    .line 33
    .line 34
    if-eqz v0, :cond_0

    .line 35
    .line 36
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 37
    .line 38
    .line 39
    :cond_0
    iget-object p1, p0, Lcom/google/android/gms/internal/cast/k1;->e:Ljava/lang/Object;

    .line 40
    .line 41
    check-cast p1, Landroid/widget/TextView;

    .line 42
    .line 43
    if-eqz p1, :cond_1

    .line 44
    .line 45
    const/4 v0, 0x0

    .line 46
    invoke-virtual {p1, v0}, Landroid/view/View;->setTranslationY(F)V

    .line 47
    .line 48
    .line 49
    const/high16 v0, 0x3f800000    # 1.0f

    .line 50
    .line 51
    invoke-virtual {p1, v0}, Landroid/view/View;->setAlpha(F)V

    .line 52
    .line 53
    .line 54
    :cond_1
    return-void

    .line 55
    :pswitch_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/k1;->d:Ljava/lang/Object;

    .line 56
    .line 57
    check-cast v0, Lp/k;

    .line 58
    .line 59
    invoke-virtual {v0, p1}, Lp/k;->containsKey(Ljava/lang/Object;)Z

    .line 60
    .line 61
    .line 62
    move-result v1

    .line 63
    if-eqz v1, :cond_2

    .line 64
    .line 65
    invoke-virtual {v0, p1}, Lp/k;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    .line 67
    .line 68
    move-result-object p1

    .line 69
    check-cast p1, Ljava/lang/Boolean;

    .line 70
    .line 71
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    .line 72
    .line 73
    .line 74
    move-result p1

    .line 75
    if-eqz p1, :cond_2

    .line 76
    .line 77
    goto :goto_0

    .line 78
    :cond_2
    sget-object p1, Lcom/google/android/gms/internal/cast/n1;->b:Lcom/google/android/gms/internal/cast/l1;

    .line 79
    .line 80
    invoke-virtual {p1}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    .line 81
    .line 82
    .line 83
    move-result-object p1

    .line 84
    check-cast p1, Lcom/google/android/gms/internal/cast/n1;

    .line 85
    .line 86
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 87
    .line 88
    .line 89
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/k1;->f:Ljava/lang/Object;

    .line 90
    .line 91
    check-cast v0, Lcom/google/android/gms/internal/cast/w;

    .line 92
    .line 93
    iget-object v1, v0, Lcom/google/android/gms/internal/cast/w;->a:Ljava/lang/Object;

    .line 94
    .line 95
    check-cast v1, Lcom/google/android/gms/internal/cast/m1;

    .line 96
    .line 97
    if-nez v1, :cond_3

    .line 98
    .line 99
    new-instance v1, Lcom/google/android/gms/internal/cast/m1;

    .line 100
    .line 101
    invoke-direct {v1, v0}, Lcom/google/android/gms/internal/cast/m1;-><init>(Lcom/google/android/gms/internal/cast/w;)V

    .line 102
    .line 103
    .line 104
    iput-object v1, v0, Lcom/google/android/gms/internal/cast/w;->a:Ljava/lang/Object;

    .line 105
    .line 106
    :cond_3
    iget-object v0, v0, Lcom/google/android/gms/internal/cast/w;->a:Ljava/lang/Object;

    .line 107
    .line 108
    check-cast v0, Lcom/google/android/gms/internal/cast/m1;

    .line 109
    .line 110
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/n1;->a:Landroid/view/Choreographer;

    .line 111
    .line 112
    invoke-virtual {p1, v0}, Landroid/view/Choreographer;->postFrameCallback(Landroid/view/Choreographer$FrameCallback;)V

    .line 113
    .line 114
    .line 115
    :goto_0
    return-void

    .line 116
    nop

    .line 117
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public final onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/gms/internal/cast/k1;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object p1, p0, Lcom/google/android/gms/internal/cast/k1;->e:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast p1, Landroid/widget/TextView;

    .line 9
    .line 10
    if-eqz p1, :cond_0

    .line 11
    .line 12
    const/4 v0, 0x0

    .line 13
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 14
    .line 15
    .line 16
    :cond_0
    return-void

    .line 17
    :pswitch_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/k1;->d:Ljava/lang/Object;

    .line 18
    .line 19
    check-cast v0, Lp/k;

    .line 20
    .line 21
    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .line 22
    .line 23
    invoke-virtual {v0, p1, v1}, Lp/k;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    .line 25
    .line 26
    return-void

    .line 27
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
