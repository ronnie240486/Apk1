.class public final synthetic Lcom/google/android/gms/internal/cast/m1;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Landroid/view/Choreographer$FrameCallback;


# instance fields
.field public final synthetic a:Lcom/google/android/gms/internal/cast/w;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/internal/cast/w;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lcom/google/android/gms/internal/cast/m1;->a:Lcom/google/android/gms/internal/cast/w;

    .line 5
    .line 6
    return-void
.end method


# virtual methods
.method public final doFrame(J)V
    .locals 2

    .line 1
    iget-object p1, p0, Lcom/google/android/gms/internal/cast/m1;->a:Lcom/google/android/gms/internal/cast/w;

    .line 2
    .line 3
    iget-object p1, p1, Lcom/google/android/gms/internal/cast/w;->b:Ljava/lang/Object;

    .line 4
    .line 5
    check-cast p1, Lcom/google/android/gms/internal/cast/k1;

    .line 6
    .line 7
    iget p2, p1, Lcom/google/android/gms/internal/cast/k1;->c:I

    .line 8
    .line 9
    add-int/lit8 p2, p2, 0x1

    .line 10
    .line 11
    iput p2, p1, Lcom/google/android/gms/internal/cast/k1;->c:I

    .line 12
    .line 13
    iget-object p2, p1, Lcom/google/android/gms/internal/cast/k1;->d:Ljava/lang/Object;

    .line 14
    .line 15
    check-cast p2, Lp/k;

    .line 16
    .line 17
    iget-object v0, p1, Lcom/google/android/gms/internal/cast/k1;->e:Ljava/lang/Object;

    .line 18
    .line 19
    check-cast v0, Landroid/animation/AnimatorSet;

    .line 20
    .line 21
    invoke-virtual {p2, v0}, Lp/k;->containsKey(Ljava/lang/Object;)Z

    .line 22
    .line 23
    .line 24
    move-result v1

    .line 25
    if-eqz v1, :cond_0

    .line 26
    .line 27
    invoke-virtual {p2, v0}, Lp/k;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object p2

    .line 31
    check-cast p2, Ljava/lang/Boolean;

    .line 32
    .line 33
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    .line 34
    .line 35
    .line 36
    move-result p2

    .line 37
    if-eqz p2, :cond_0

    .line 38
    .line 39
    goto :goto_1

    .line 40
    :cond_0
    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    .line 41
    .line 42
    .line 43
    move-result p2

    .line 44
    if-nez p2, :cond_3

    .line 45
    .line 46
    iget p2, p1, Lcom/google/android/gms/internal/cast/k1;->b:I

    .line 47
    .line 48
    const/4 v1, -0x1

    .line 49
    if-ne p2, v1, :cond_1

    .line 50
    .line 51
    goto :goto_0

    .line 52
    :cond_1
    iget p1, p1, Lcom/google/android/gms/internal/cast/k1;->c:I

    .line 53
    .line 54
    if-ltz p1, :cond_2

    .line 55
    .line 56
    goto :goto_1

    .line 57
    :cond_2
    :goto_0
    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    .line 58
    .line 59
    .line 60
    :cond_3
    :goto_1
    return-void
.end method
