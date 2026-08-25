.class public final La7/d;
.super Landroid/animation/AnimatorListenerAdapter;
.source "MyApplication"


# instance fields
.field public final synthetic a:I

.field public final synthetic b:Ljava/lang/Object;

.field public final synthetic c:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;Ljava/lang/Object;Z)V
    .locals 0

    .line 1
    iput p1, p0, La7/d;->a:I

    iput-object p3, p0, La7/d;->b:Ljava/lang/Object;

    iput-object p2, p0, La7/d;->c:Ljava/lang/Object;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 0

    .line 2
    iput p2, p0, La7/d;->a:I

    iput-object p1, p0, La7/d;->b:Ljava/lang/Object;

    iput-object p3, p0, La7/d;->c:Ljava/lang/Object;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 1

    .line 1
    iget v0, p0, La7/d;->a:I

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
    iget-object p1, p0, La7/d;->b:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast p1, Ln0/b1;

    .line 13
    .line 14
    invoke-interface {p1}, Ln0/b1;->b()V

    .line 15
    .line 16
    .line 17
    return-void

    .line 18
    nop

    .line 19
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method

.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 1

    .line 1
    iget v0, p0, La7/d;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, La7/d;->b:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lp/e;

    .line 9
    .line 10
    invoke-virtual {v0, p1}, Lp/k;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, La7/d;->c:Ljava/lang/Object;

    .line 14
    .line 15
    check-cast v0, Landroidx/transition/Transition;

    .line 16
    .line 17
    iget-object v0, v0, Landroidx/transition/Transition;->m:Ljava/util/ArrayList;

    .line 18
    .line 19
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 20
    .line 21
    .line 22
    return-void

    .line 23
    :pswitch_0
    iget-object p1, p0, La7/d;->b:Ljava/lang/Object;

    .line 24
    .line 25
    check-cast p1, Ln0/b1;

    .line 26
    .line 27
    invoke-interface {p1}, Ln0/b1;->a()V

    .line 28
    .line 29
    .line 30
    return-void

    .line 31
    :pswitch_1
    iget-object p1, p0, La7/d;->c:Ljava/lang/Object;

    .line 32
    .line 33
    check-cast p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 34
    .line 35
    const/16 v0, 0x8

    .line 36
    .line 37
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 38
    .line 39
    .line 40
    const/4 v0, 0x0

    .line 41
    iput-object v0, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 42
    .line 43
    iget-object p1, p0, La7/d;->b:Ljava/lang/Object;

    .line 44
    .line 45
    check-cast p1, Lcom/google/android/gms/internal/cast/n;

    .line 46
    .line 47
    invoke-virtual {p1}, Lcom/google/android/gms/internal/cast/n;->run()V

    .line 48
    .line 49
    .line 50
    return-void

    .line 51
    :pswitch_2
    iget-object p1, p0, La7/d;->c:Ljava/lang/Object;

    .line 52
    .line 53
    check-cast p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 54
    .line 55
    const/16 v0, 0x8

    .line 56
    .line 57
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 58
    .line 59
    .line 60
    const/4 v0, 0x0

    .line 61
    iput-object v0, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->g:Landroid/animation/AnimatorSet;

    .line 62
    .line 63
    iget-object p1, p0, La7/d;->b:Ljava/lang/Object;

    .line 64
    .line 65
    check-cast p1, Lcom/google/android/gms/internal/cast/n;

    .line 66
    .line 67
    invoke-virtual {p1}, Lcom/google/android/gms/internal/cast/n;->run()V

    .line 68
    .line 69
    .line 70
    return-void

    .line 71
    :pswitch_3
    iget-object p1, p0, La7/d;->b:Ljava/lang/Object;

    .line 72
    .line 73
    check-cast p1, Lf6/e;

    .line 74
    .line 75
    const/4 v0, 0x0

    .line 76
    invoke-interface {p1, v0}, Lf6/e;->setCircularRevealOverlayDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 77
    .line 78
    .line 79
    return-void

    .line 80
    nop

    .line 81
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 1

    .line 1
    iget v0, p0, La7/d;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    :pswitch_0
    invoke-super {p0, p1}, Landroid/animation/AnimatorListenerAdapter;->onAnimationStart(Landroid/animation/Animator;)V

    .line 7
    .line 8
    .line 9
    return-void

    .line 10
    :pswitch_1
    iget-object v0, p0, La7/d;->c:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast v0, Landroidx/transition/Transition;

    .line 13
    .line 14
    iget-object v0, v0, Landroidx/transition/Transition;->m:Ljava/util/ArrayList;

    .line 15
    .line 16
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :pswitch_2
    iget-object p1, p0, La7/d;->b:Ljava/lang/Object;

    .line 21
    .line 22
    check-cast p1, Ln0/b1;

    .line 23
    .line 24
    invoke-interface {p1}, Ln0/b1;->c()V

    .line 25
    .line 26
    .line 27
    return-void

    .line 28
    :pswitch_3
    iget-object p1, p0, La7/d;->b:Ljava/lang/Object;

    .line 29
    .line 30
    check-cast p1, Lf6/e;

    .line 31
    .line 32
    iget-object v0, p0, La7/d;->c:Ljava/lang/Object;

    .line 33
    .line 34
    check-cast v0, Landroid/graphics/drawable/Drawable;

    .line 35
    .line 36
    invoke-interface {p1, v0}, Lf6/e;->setCircularRevealOverlayDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 37
    .line 38
    .line 39
    return-void

    .line 40
    nop

    .line 41
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method
