.class public final synthetic Lcom/google/android/gms/internal/cast/q;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic a:I

.field public final synthetic b:Lcom/google/android/gms/internal/cast/t;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/internal/cast/t;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/google/android/gms/internal/cast/q;->a:I

    .line 2
    .line 3
    iput-object p1, p0, Lcom/google/android/gms/internal/cast/q;->b:Lcom/google/android/gms/internal/cast/t;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget v0, p0, Lcom/google/android/gms/internal/cast/q;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/q;->b:Lcom/google/android/gms/internal/cast/t;

    .line 7
    .line 8
    invoke-virtual {v0}, Lcom/google/android/gms/internal/cast/t;->p()V

    .line 9
    .line 10
    .line 11
    return-void

    .line 12
    :pswitch_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cast/q;->b:Lcom/google/android/gms/internal/cast/t;

    .line 13
    .line 14
    iget-object v1, v0, Lcom/google/android/gms/internal/cast/t;->e:Lcom/google/android/gms/internal/cast/w;

    .line 15
    .line 16
    iget-object v2, v1, Lcom/google/android/gms/internal/cast/w;->b:Ljava/lang/Object;

    .line 17
    .line 18
    check-cast v2, Lq1/u0;

    .line 19
    .line 20
    if-nez v2, :cond_0

    .line 21
    .line 22
    iget-object v2, v1, Lcom/google/android/gms/internal/cast/w;->a:Ljava/lang/Object;

    .line 23
    .line 24
    check-cast v2, Landroid/content/Context;

    .line 25
    .line 26
    invoke-static {v2}, Lq1/u0;->d(Landroid/content/Context;)Lq1/u0;

    .line 27
    .line 28
    .line 29
    move-result-object v2

    .line 30
    iput-object v2, v1, Lcom/google/android/gms/internal/cast/w;->b:Ljava/lang/Object;

    .line 31
    .line 32
    :cond_0
    iget-object v1, v1, Lcom/google/android/gms/internal/cast/w;->b:Ljava/lang/Object;

    .line 33
    .line 34
    check-cast v1, Lq1/u0;

    .line 35
    .line 36
    if-eqz v1, :cond_1

    .line 37
    .line 38
    invoke-virtual {v1, v0}, Lq1/u0;->h(Lq1/m0;)V

    .line 39
    .line 40
    .line 41
    :cond_1
    return-void

    .line 42
    nop

    .line 43
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
