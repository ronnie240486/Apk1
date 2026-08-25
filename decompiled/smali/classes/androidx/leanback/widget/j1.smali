.class public final Landroidx/leanback/widget/j1;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Ln0/s;


# instance fields
.field public a:I

.field public b:I

.field public c:Ljava/lang/Object;


# virtual methods
.method public a()V
    .locals 2

    .line 1
    iget v0, p0, Landroidx/leanback/widget/j1;->a:I

    .line 2
    .line 3
    const/4 v1, 0x2

    .line 4
    if-ne v0, v1, :cond_2

    .line 5
    .line 6
    iget v0, p0, Landroidx/leanback/widget/j1;->b:I

    .line 7
    .line 8
    if-lez v0, :cond_1

    .line 9
    .line 10
    iget-object v0, p0, Landroidx/leanback/widget/j1;->c:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast v0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;

    .line 13
    .line 14
    if-eqz v0, :cond_0

    .line 15
    .line 16
    iget-object v1, v0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->g:Ljava/lang/Object;

    .line 17
    .line 18
    check-cast v1, Lq/b;

    .line 19
    .line 20
    monitor-enter v1

    .line 21
    :try_start_0
    iget v0, v0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->b:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 22
    .line 23
    monitor-exit v1

    .line 24
    iget v1, p0, Landroidx/leanback/widget/j1;->b:I

    .line 25
    .line 26
    if-eq v0, v1, :cond_6

    .line 27
    .line 28
    goto :goto_0

    .line 29
    :catchall_0
    move-exception v0

    .line 30
    monitor-exit v1

    .line 31
    throw v0

    .line 32
    :cond_0
    :goto_0
    new-instance v0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;

    .line 33
    .line 34
    iget v1, p0, Landroidx/leanback/widget/j1;->b:I

    .line 35
    .line 36
    invoke-direct {v0, v1}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;-><init>(I)V

    .line 37
    .line 38
    .line 39
    iput-object v0, p0, Landroidx/leanback/widget/j1;->c:Ljava/lang/Object;

    .line 40
    .line 41
    goto :goto_2

    .line 42
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 43
    .line 44
    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    .line 45
    .line 46
    .line 47
    throw v0

    .line 48
    :cond_2
    const/4 v1, 0x3

    .line 49
    if-eq v0, v1, :cond_4

    .line 50
    .line 51
    const/4 v1, 0x1

    .line 52
    if-ne v0, v1, :cond_3

    .line 53
    .line 54
    goto :goto_1

    .line 55
    :cond_3
    const/4 v0, 0x0

    .line 56
    iput-object v0, p0, Landroidx/leanback/widget/j1;->c:Ljava/lang/Object;

    .line 57
    .line 58
    goto :goto_2

    .line 59
    :cond_4
    :goto_1
    iget-object v0, p0, Landroidx/leanback/widget/j1;->c:Ljava/lang/Object;

    .line 60
    .line 61
    check-cast v0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;

    .line 62
    .line 63
    const v1, 0x7fffffff

    .line 64
    .line 65
    .line 66
    if-eqz v0, :cond_5

    .line 67
    .line 68
    invoke-virtual {v0}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->c()I

    .line 69
    .line 70
    .line 71
    move-result v0

    .line 72
    if-eq v0, v1, :cond_6

    .line 73
    .line 74
    :cond_5
    new-instance v0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;

    .line 75
    .line 76
    invoke-direct {v0, v1}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;-><init>(I)V

    .line 77
    .line 78
    .line 79
    iput-object v0, p0, Landroidx/leanback/widget/j1;->c:Ljava/lang/Object;

    .line 80
    .line 81
    :cond_6
    :goto_2
    return-void
.end method

.method public onApplyWindowInsets(Landroid/view/View;Ln0/r1;)Ln0/r1;
    .locals 4

    .line 1
    iget-object p1, p2, Ln0/r1;->a:Ln0/o1;

    .line 2
    .line 3
    const/4 v0, 0x7

    .line 4
    invoke-virtual {p1, v0}, Ln0/o1;->g(I)Lf0/c;

    .line 5
    .line 6
    .line 7
    move-result-object p1

    .line 8
    iget p1, p1, Lf0/c;->b:I

    .line 9
    .line 10
    iget-object v0, p0, Landroidx/leanback/widget/j1;->c:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast v0, Landroid/view/View;

    .line 13
    .line 14
    iget v1, p0, Landroidx/leanback/widget/j1;->a:I

    .line 15
    .line 16
    if-ltz v1, :cond_0

    .line 17
    .line 18
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 19
    .line 20
    .line 21
    move-result-object v2

    .line 22
    add-int/2addr v1, p1

    .line 23
    iput v1, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 24
    .line 25
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 30
    .line 31
    .line 32
    :cond_0
    invoke-virtual {v0}, Landroid/view/View;->getPaddingLeft()I

    .line 33
    .line 34
    .line 35
    move-result v1

    .line 36
    iget v2, p0, Landroidx/leanback/widget/j1;->b:I

    .line 37
    .line 38
    add-int/2addr v2, p1

    .line 39
    invoke-virtual {v0}, Landroid/view/View;->getPaddingRight()I

    .line 40
    .line 41
    .line 42
    move-result p1

    .line 43
    invoke-virtual {v0}, Landroid/view/View;->getPaddingBottom()I

    .line 44
    .line 45
    .line 46
    move-result v3

    .line 47
    invoke-virtual {v0, v1, v2, p1, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 48
    .line 49
    .line 50
    return-object p2
.end method
