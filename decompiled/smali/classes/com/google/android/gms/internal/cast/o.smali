.class public final Lcom/google/android/gms/internal/cast/o;
.super Landroid/widget/RelativeLayout;
.source "MyApplication"


# instance fields
.field public final a:Z

.field public b:Lorg/bitspark/android/Spark;

.field public c:Lj7/c;

.field public d:Landroidx/mediarouter/app/MediaRouteButton;

.field public e:Ljava/lang/String;

.field public f:Z


# direct methods
.method public constructor <init>(Lq4/d;)V
    .locals 1

    .line 1
    iget-object v0, p1, Lq4/d;->b:Ljava/lang/Object;

    .line 2
    .line 3
    check-cast v0, Lorg/bitspark/android/Spark;

    .line 4
    .line 5
    invoke-direct {p0, v0}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 6
    .line 7
    .line 8
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/o;->b:Lorg/bitspark/android/Spark;

    .line 9
    .line 10
    iget-boolean v0, p1, Lq4/d;->a:Z

    .line 11
    .line 12
    iput-boolean v0, p0, Lcom/google/android/gms/internal/cast/o;->a:Z

    .line 13
    .line 14
    iget-object v0, p1, Lq4/d;->e:Ljava/lang/Object;

    .line 15
    .line 16
    check-cast v0, Lj7/c;

    .line 17
    .line 18
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/o;->c:Lj7/c;

    .line 19
    .line 20
    iget-object v0, p1, Lq4/d;->c:Ljava/lang/Object;

    .line 21
    .line 22
    check-cast v0, Landroidx/mediarouter/app/MediaRouteButton;

    .line 23
    .line 24
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/o;->d:Landroidx/mediarouter/app/MediaRouteButton;

    .line 25
    .line 26
    iget-object p1, p1, Lq4/d;->d:Ljava/lang/Object;

    .line 27
    .line 28
    check-cast p1, Ljava/lang/String;

    .line 29
    .line 30
    iput-object p1, p0, Lcom/google/android/gms/internal/cast/o;->e:Ljava/lang/String;

    .line 31
    .line 32
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/o;->b:Lorg/bitspark/android/Spark;

    .line 6
    .line 7
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/o;->c:Lj7/c;

    .line 8
    .line 9
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/o;->d:Landroidx/mediarouter/app/MediaRouteButton;

    .line 10
    .line 11
    iput-object v0, p0, Lcom/google/android/gms/internal/cast/o;->e:Ljava/lang/String;

    .line 12
    .line 13
    const/4 v0, 0x0

    .line 14
    iput-boolean v0, p0, Lcom/google/android/gms/internal/cast/o;->f:Z

    .line 15
    .line 16
    return-void
.end method
