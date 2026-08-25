.class public final synthetic Lcom/google/android/gms/internal/cast/n;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic a:I

.field public final synthetic b:Ljava/lang/Object;

.field public final synthetic c:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/google/android/gms/internal/cast/n;->a:I

    .line 2
    .line 3
    iput-object p1, p0, Lcom/google/android/gms/internal/cast/n;->b:Ljava/lang/Object;

    .line 4
    .line 5
    iput-object p3, p0, Lcom/google/android/gms/internal/cast/n;->c:Ljava/lang/Object;

    .line 6
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    .line 9
    .line 10
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget v0, p0, Lcom/google/android/gms/internal/cast/n;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/n;->b:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lcom/google/android/gms/internal/cast/v;

    .line 9
    .line 10
    iget-object v1, p0, Lcom/google/android/gms/internal/cast/n;->c:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast v1, Lq1/l0;

    .line 13
    .line 14
    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/cast/v;->A(Lq1/l0;)V

    .line 15
    .line 16
    .line 17
    return-void

    .line 18
    :pswitch_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/n;->b:Ljava/lang/Object;

    .line 19
    .line 20
    check-cast v0, La1/b;

    .line 21
    .line 22
    iget-object v0, v0, La1/b;->d:Ljava/lang/Object;

    .line 23
    .line 24
    check-cast v0, Lcom/google/android/gms/internal/cast/o;

    .line 25
    .line 26
    iget-boolean v1, v0, Lcom/google/android/gms/internal/cast/o;->f:Z

    .line 27
    .line 28
    if-eqz v1, :cond_1

    .line 29
    .line 30
    iget-object v1, p0, Lcom/google/android/gms/internal/cast/n;->c:Ljava/lang/Object;

    .line 31
    .line 32
    check-cast v1, Lorg/bitspark/android/Spark;

    .line 33
    .line 34
    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    .line 35
    .line 36
    .line 37
    move-result-object v1

    .line 38
    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    .line 39
    .line 40
    .line 41
    move-result-object v1

    .line 42
    check-cast v1, Landroid/view/ViewGroup;

    .line 43
    .line 44
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 45
    .line 46
    .line 47
    iget-object v1, v0, Lcom/google/android/gms/internal/cast/o;->c:Lj7/c;

    .line 48
    .line 49
    if-eqz v1, :cond_0

    .line 50
    .line 51
    iget-object v1, v1, Lj7/c;->b:Ljava/lang/Object;

    .line 52
    .line 53
    check-cast v1, Lorg/bitspark/android/utils/b;

    .line 54
    .line 55
    const/4 v2, 0x0

    .line 56
    iput-object v2, v1, Lorg/bitspark/android/utils/b;->e:Lcom/google/android/gms/internal/cast/o;

    .line 57
    .line 58
    :cond_0
    invoke-virtual {v0}, Lcom/google/android/gms/internal/cast/o;->a()V

    .line 59
    .line 60
    .line 61
    :cond_1
    return-void

    .line 62
    :pswitch_1
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/n;->b:Ljava/lang/Object;

    .line 63
    .line 64
    check-cast v0, La1/b;

    .line 65
    .line 66
    iget-object v0, v0, La1/b;->d:Ljava/lang/Object;

    .line 67
    .line 68
    check-cast v0, Lcom/google/android/gms/internal/cast/o;

    .line 69
    .line 70
    iget-boolean v1, v0, Lcom/google/android/gms/internal/cast/o;->f:Z

    .line 71
    .line 72
    if-eqz v1, :cond_3

    .line 73
    .line 74
    iget-object v1, p0, Lcom/google/android/gms/internal/cast/n;->c:Ljava/lang/Object;

    .line 75
    .line 76
    check-cast v1, Lorg/bitspark/android/Spark;

    .line 77
    .line 78
    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    .line 79
    .line 80
    .line 81
    move-result-object v1

    .line 82
    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    .line 83
    .line 84
    .line 85
    move-result-object v1

    .line 86
    check-cast v1, Landroid/view/ViewGroup;

    .line 87
    .line 88
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 89
    .line 90
    .line 91
    iget-object v1, v0, Lcom/google/android/gms/internal/cast/o;->c:Lj7/c;

    .line 92
    .line 93
    if-eqz v1, :cond_2

    .line 94
    .line 95
    iget-object v1, v1, Lj7/c;->b:Ljava/lang/Object;

    .line 96
    .line 97
    check-cast v1, Lorg/bitspark/android/utils/b;

    .line 98
    .line 99
    const/4 v2, 0x0

    .line 100
    iput-object v2, v1, Lorg/bitspark/android/utils/b;->e:Lcom/google/android/gms/internal/cast/o;

    .line 101
    .line 102
    :cond_2
    invoke-virtual {v0}, Lcom/google/android/gms/internal/cast/o;->a()V

    .line 103
    .line 104
    .line 105
    :cond_3
    return-void

    .line 106
    nop

    .line 107
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
