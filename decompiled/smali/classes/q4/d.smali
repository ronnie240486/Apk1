.class public final Lq4/d;
.super Ljava/lang/Object;
.source "MyApplication"


# instance fields
.field public a:Z

.field public final b:Ljava/lang/Object;

.field public final c:Ljava/lang/Object;

.field public d:Ljava/lang/Object;

.field public e:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lq4/d;->b:Ljava/lang/Object;

    new-instance v0, Lk3/t;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Lk3/t;-><init>(I)V

    iput-object v0, p0, Lq4/d;->c:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lorg/bitspark/android/Spark;Landroidx/mediarouter/app/MediaRouteButton;)V
    .locals 0

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lq4/d;->b:Ljava/lang/Object;

    .line 4
    invoke-static {p2}, Lb5/l;->e(Ljava/lang/Object;)V

    iput-object p2, p0, Lq4/d;->c:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public a(Lw5/a;)V
    .locals 2

    .line 1
    sget-object v0, Lw5/e;->a:La4/r;

    .line 2
    .line 3
    new-instance v1, Lw5/f;

    .line 4
    .line 5
    invoke-direct {v1, v0, p1}, Lw5/f;-><init>(Ljava/util/concurrent/Executor;Lw5/a;)V

    .line 6
    .line 7
    .line 8
    iget-object p1, p0, Lq4/d;->c:Ljava/lang/Object;

    .line 9
    .line 10
    check-cast p1, Lk3/t;

    .line 11
    .line 12
    invoke-virtual {p1, v1}, Lk3/t;->h(Lw5/f;)V

    .line 13
    .line 14
    .line 15
    invoke-virtual {p0}, Lq4/d;->g()V

    .line 16
    .line 17
    .line 18
    return-void
.end method

.method public b(Lw5/c;)V
    .locals 2

    .line 1
    sget-object v0, Lw5/e;->a:La4/r;

    .line 2
    .line 3
    new-instance v1, Lw5/f;

    .line 4
    .line 5
    invoke-direct {v1, v0, p1}, Lw5/f;-><init>(La4/r;Lw5/c;)V

    .line 6
    .line 7
    .line 8
    iget-object p1, p0, Lq4/d;->c:Ljava/lang/Object;

    .line 9
    .line 10
    check-cast p1, Lk3/t;

    .line 11
    .line 12
    invoke-virtual {p1, v1}, Lk3/t;->h(Lw5/f;)V

    .line 13
    .line 14
    .line 15
    invoke-virtual {p0}, Lq4/d;->g()V

    .line 16
    .line 17
    .line 18
    return-void
.end method

.method public c()Ljava/lang/Exception;
    .locals 2

    .line 1
    iget-object v0, p0, Lq4/d;->b:Ljava/lang/Object;

    .line 2
    .line 3
    monitor-enter v0

    .line 4
    :try_start_0
    iget-object v1, p0, Lq4/d;->e:Ljava/lang/Object;

    .line 5
    .line 6
    check-cast v1, Ljava/lang/Exception;

    .line 7
    .line 8
    monitor-exit v0

    .line 9
    return-object v1

    .line 10
    :catchall_0
    move-exception v1

    .line 11
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 12
    throw v1
.end method

.method public d()Ljava/lang/Object;
    .locals 4

    .line 1
    iget-object v0, p0, Lq4/d;->b:Ljava/lang/Object;

    .line 2
    .line 3
    monitor-enter v0

    .line 4
    :try_start_0
    iget-boolean v1, p0, Lq4/d;->a:Z

    .line 5
    .line 6
    const-string v2, "Task is not yet complete"

    .line 7
    .line 8
    invoke-static {v2, v1}, Lb5/l;->g(Ljava/lang/String;Z)V

    .line 9
    .line 10
    .line 11
    iget-object v1, p0, Lq4/d;->e:Ljava/lang/Object;

    .line 12
    .line 13
    check-cast v1, Ljava/lang/Exception;

    .line 14
    .line 15
    if-nez v1, :cond_0

    .line 16
    .line 17
    iget-object v1, p0, Lq4/d;->d:Ljava/lang/Object;

    .line 18
    .line 19
    monitor-exit v0

    .line 20
    return-object v1

    .line 21
    :catchall_0
    move-exception v1

    .line 22
    goto :goto_0

    .line 23
    :cond_0
    new-instance v2, Landroidx/fragment/app/q;

    .line 24
    .line 25
    const/16 v3, 0xb

    .line 26
    .line 27
    invoke-direct {v2, v1, v3}, Landroidx/fragment/app/q;-><init>(Ljava/lang/Throwable;I)V

    .line 28
    .line 29
    .line 30
    throw v2

    .line 31
    :goto_0
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 32
    throw v1
.end method

.method public e()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lq4/d;->b:Ljava/lang/Object;

    .line 2
    .line 3
    monitor-enter v0

    .line 4
    :try_start_0
    iget-boolean v1, p0, Lq4/d;->a:Z

    .line 5
    .line 6
    const/4 v2, 0x0

    .line 7
    if-eqz v1, :cond_0

    .line 8
    .line 9
    iget-object v1, p0, Lq4/d;->e:Ljava/lang/Object;

    .line 10
    .line 11
    check-cast v1, Ljava/lang/Exception;

    .line 12
    .line 13
    if-nez v1, :cond_0

    .line 14
    .line 15
    const/4 v2, 0x1

    .line 16
    :cond_0
    monitor-exit v0

    .line 17
    return v2

    .line 18
    :catchall_0
    move-exception v1

    .line 19
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 20
    throw v1
.end method

.method public f()V
    .locals 4

    .line 1
    iget-boolean v0, p0, Lq4/d;->a:Z

    .line 2
    .line 3
    if-eqz v0, :cond_3

    .line 4
    .line 5
    sget v0, Lk8/d;->a:I

    .line 6
    .line 7
    iget-object v0, p0, Lq4/d;->b:Ljava/lang/Object;

    .line 8
    .line 9
    monitor-enter v0

    .line 10
    :try_start_0
    iget-boolean v1, p0, Lq4/d;->a:Z

    .line 11
    .line 12
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 13
    if-eqz v1, :cond_2

    .line 14
    .line 15
    invoke-virtual {p0}, Lq4/d;->c()Ljava/lang/Exception;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    if-nez v0, :cond_1

    .line 20
    .line 21
    invoke-virtual {p0}, Lq4/d;->e()Z

    .line 22
    .line 23
    .line 24
    move-result v1

    .line 25
    if-eqz v1, :cond_0

    .line 26
    .line 27
    invoke-virtual {p0}, Lq4/d;->d()Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    .line 32
    .line 33
    .line 34
    move-result-object v1

    .line 35
    const-string v2, "result "

    .line 36
    .line 37
    invoke-virtual {v2, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object v1

    .line 41
    goto :goto_0

    .line 42
    :cond_0
    const-string v1, "unknown issue"

    .line 43
    .line 44
    goto :goto_0

    .line 45
    :cond_1
    const-string v1, "failure"

    .line 46
    .line 47
    :goto_0
    const-string v2, "Complete with: "

    .line 48
    .line 49
    new-instance v3, Lk8/d;

    .line 50
    .line 51
    invoke-virtual {v2, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 52
    .line 53
    .line 54
    move-result-object v1

    .line 55
    invoke-direct {v3, v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 56
    .line 57
    .line 58
    goto :goto_1

    .line 59
    :cond_2
    new-instance v3, Ljava/lang/IllegalStateException;

    .line 60
    .line 61
    const-string v0, "DuplicateTaskCompletionException can only be created from completed Task."

    .line 62
    .line 63
    invoke-direct {v3, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 64
    .line 65
    .line 66
    :goto_1
    throw v3

    .line 67
    :catchall_0
    move-exception v1

    .line 68
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 69
    throw v1

    .line 70
    :cond_3
    return-void
.end method

.method public g()V
    .locals 2

    .line 1
    iget-object v0, p0, Lq4/d;->b:Ljava/lang/Object;

    .line 2
    .line 3
    monitor-enter v0

    .line 4
    :try_start_0
    iget-boolean v1, p0, Lq4/d;->a:Z

    .line 5
    .line 6
    if-nez v1, :cond_0

    .line 7
    .line 8
    monitor-exit v0

    .line 9
    return-void

    .line 10
    :catchall_0
    move-exception v1

    .line 11
    goto :goto_0

    .line 12
    :cond_0
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 13
    iget-object v0, p0, Lq4/d;->c:Ljava/lang/Object;

    .line 14
    .line 15
    check-cast v0, Lk3/t;

    .line 16
    .line 17
    invoke-virtual {v0, p0}, Lk3/t;->i(Lq4/d;)V

    .line 18
    .line 19
    .line 20
    return-void

    .line 21
    :goto_0
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 22
    throw v1
.end method
