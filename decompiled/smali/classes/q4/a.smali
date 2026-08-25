.class public abstract Lq4/a;
.super Ljava/lang/Object;
.source "MyApplication"


# static fields
.field public static final a:Ljava/util/ArrayList;

.field public static final b:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    const-string v0, "The log tag cannot be null or empty."

    .line 2
    .line 3
    const-string v1, "CastButtonFactory"

    .line 4
    .line 5
    invoke-static {v1, v0}, Lb5/l;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    new-instance v0, Ljava/util/ArrayList;

    .line 9
    .line 10
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 11
    .line 12
    .line 13
    new-instance v0, Ljava/util/ArrayList;

    .line 14
    .line 15
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 16
    .line 17
    .line 18
    sput-object v0, Lq4/a;->a:Ljava/util/ArrayList;

    .line 19
    .line 20
    new-instance v0, Ljava/lang/Object;

    .line 21
    .line 22
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 23
    .line 24
    .line 25
    sput-object v0, Lq4/a;->b:Ljava/lang/Object;

    .line 26
    .line 27
    return-void
.end method

.method public static a(Lorg/bitspark/android/Spark;Landroidx/mediarouter/app/MediaRouteButton;)V
    .locals 5

    .line 1
    const/4 v0, 0x1

    .line 2
    const-string v1, "Must be called from the main thread."

    .line 3
    .line 4
    invoke-static {v1}, Lb5/l;->b(Ljava/lang/String;)V

    .line 5
    .line 6
    .line 7
    if-eqz p1, :cond_1

    .line 8
    .line 9
    const-string v1, "Must be called from the main thread."

    .line 10
    .line 11
    invoke-static {v1}, Lb5/l;->b(Ljava/lang/String;)V

    .line 12
    .line 13
    .line 14
    invoke-static {p0}, Lq4/b;->c(Landroid/app/Activity;)Lq4/b;

    .line 15
    .line 16
    .line 17
    move-result-object p0

    .line 18
    if-eqz p0, :cond_0

    .line 19
    .line 20
    invoke-static {v1}, Lb5/l;->b(Ljava/lang/String;)V

    .line 21
    .line 22
    .line 23
    :try_start_0
    iget-object p0, p0, Lq4/b;->b:Lq4/n;

    .line 24
    .line 25
    check-cast p0, Lq4/l;

    .line 26
    .line 27
    invoke-virtual {p0}, Lcom/google/android/gms/internal/cast/a;->l()Landroid/os/Parcel;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    invoke-virtual {p0, v1, v0}, Lcom/google/android/gms/internal/cast/a;->w(Landroid/os/Parcel;I)Landroid/os/Parcel;

    .line 32
    .line 33
    .line 34
    move-result-object p0

    .line 35
    sget-object v1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 36
    .line 37
    invoke-static {p0, v1}, Lcom/google/android/gms/internal/cast/e0;->a(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    .line 38
    .line 39
    .line 40
    move-result-object v1

    .line 41
    check-cast v1, Landroid/os/Bundle;

    .line 42
    .line 43
    invoke-virtual {p0}, Landroid/os/Parcel;->recycle()V

    .line 44
    .line 45
    .line 46
    invoke-static {v1}, Lq1/l0;->b(Landroid/os/Bundle;)Lq1/l0;

    .line 47
    .line 48
    .line 49
    move-result-object p0
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 50
    goto :goto_0

    .line 51
    :catch_0
    move-exception p0

    .line 52
    const-class v1, Lq4/n;

    .line 53
    .line 54
    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    .line 55
    .line 56
    .line 57
    move-result-object v1

    .line 58
    const/4 v2, 0x2

    .line 59
    new-array v2, v2, [Ljava/lang/Object;

    .line 60
    .line 61
    const-string v3, "getMergedSelectorAsBundle"

    .line 62
    .line 63
    const/4 v4, 0x0

    .line 64
    aput-object v3, v2, v4

    .line 65
    .line 66
    aput-object v1, v2, v0

    .line 67
    .line 68
    const-string v0, "Unable to call %s on %s."

    .line 69
    .line 70
    sget-object v1, Lq4/b;->k:Lv4/b;

    .line 71
    .line 72
    invoke-virtual {v1, p0, v0, v2}, Lv4/b;->a(Ljava/lang/Exception;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 73
    .line 74
    .line 75
    const/4 p0, 0x0

    .line 76
    :goto_0
    if-eqz p0, :cond_0

    .line 77
    .line 78
    invoke-virtual {p1, p0}, Landroidx/mediarouter/app/MediaRouteButton;->setRouteSelector(Lq1/l0;)V

    .line 79
    .line 80
    .line 81
    :cond_0
    sget-object p0, Lq4/a;->b:Ljava/lang/Object;

    .line 82
    .line 83
    monitor-enter p0

    .line 84
    :try_start_1
    sget-object v0, Lq4/a;->a:Ljava/util/ArrayList;

    .line 85
    .line 86
    new-instance v1, Ljava/lang/ref/WeakReference;

    .line 87
    .line 88
    invoke-direct {v1, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 89
    .line 90
    .line 91
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 92
    .line 93
    .line 94
    monitor-exit p0

    .line 95
    goto :goto_1

    .line 96
    :catchall_0
    move-exception p1

    .line 97
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 98
    throw p1

    .line 99
    :cond_1
    :goto_1
    sget-object p0, Lcom/google/android/gms/internal/cast/s2;->I:Lcom/google/android/gms/internal/cast/s2;

    .line 100
    .line 101
    invoke-static {p0}, Lcom/google/android/gms/internal/cast/r2;->a(Lcom/google/android/gms/internal/cast/s2;)V

    .line 102
    .line 103
    .line 104
    return-void
.end method
