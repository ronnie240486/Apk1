.class public final Lw5/d;
.super Ljava/lang/Object;
.source "MyApplication"


# instance fields
.field public final a:Lq4/d;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Lq4/d;

    .line 5
    .line 6
    invoke-direct {v0}, Lq4/d;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lw5/d;->a:Lq4/d;

    .line 10
    .line 11
    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/Exception;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lw5/d;->a:Lq4/d;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 4
    .line 5
    .line 6
    iget-object v1, v0, Lq4/d;->b:Ljava/lang/Object;

    .line 7
    .line 8
    monitor-enter v1

    .line 9
    :try_start_0
    invoke-virtual {v0}, Lq4/d;->f()V

    .line 10
    .line 11
    .line 12
    const/4 v2, 0x1

    .line 13
    iput-boolean v2, v0, Lq4/d;->a:Z

    .line 14
    .line 15
    iput-object p1, v0, Lq4/d;->e:Ljava/lang/Object;

    .line 16
    .line 17
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 18
    iget-object p1, v0, Lq4/d;->c:Ljava/lang/Object;

    .line 19
    .line 20
    check-cast p1, Lk3/t;

    .line 21
    .line 22
    invoke-virtual {p1, v0}, Lk3/t;->i(Lq4/d;)V

    .line 23
    .line 24
    .line 25
    return-void

    .line 26
    :catchall_0
    move-exception p1

    .line 27
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 28
    throw p1
.end method

.method public final b(Ljava/lang/Object;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lw5/d;->a:Lq4/d;

    .line 2
    .line 3
    iget-object v1, v0, Lq4/d;->b:Ljava/lang/Object;

    .line 4
    .line 5
    monitor-enter v1

    .line 6
    :try_start_0
    invoke-virtual {v0}, Lq4/d;->f()V

    .line 7
    .line 8
    .line 9
    const/4 v2, 0x1

    .line 10
    iput-boolean v2, v0, Lq4/d;->a:Z

    .line 11
    .line 12
    iput-object p1, v0, Lq4/d;->d:Ljava/lang/Object;

    .line 13
    .line 14
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 15
    iget-object p1, v0, Lq4/d;->c:Ljava/lang/Object;

    .line 16
    .line 17
    check-cast p1, Lk3/t;

    .line 18
    .line 19
    invoke-virtual {p1, v0}, Lk3/t;->i(Lq4/d;)V

    .line 20
    .line 21
    .line 22
    return-void

    .line 23
    :catchall_0
    move-exception p1

    .line 24
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 25
    throw p1
.end method

.method public final c(Ljava/lang/Exception;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lw5/d;->a:Lq4/d;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 4
    .line 5
    .line 6
    const-string v1, "Exception must not be null"

    .line 7
    .line 8
    invoke-static {p1, v1}, Lb5/l;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 9
    .line 10
    .line 11
    iget-object v1, v0, Lq4/d;->b:Ljava/lang/Object;

    .line 12
    .line 13
    monitor-enter v1

    .line 14
    :try_start_0
    iget-boolean v2, v0, Lq4/d;->a:Z

    .line 15
    .line 16
    if-eqz v2, :cond_0

    .line 17
    .line 18
    monitor-exit v1

    .line 19
    goto :goto_0

    .line 20
    :catchall_0
    move-exception p1

    .line 21
    goto :goto_1

    .line 22
    :cond_0
    const/4 v2, 0x1

    .line 23
    iput-boolean v2, v0, Lq4/d;->a:Z

    .line 24
    .line 25
    iput-object p1, v0, Lq4/d;->e:Ljava/lang/Object;

    .line 26
    .line 27
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 28
    iget-object p1, v0, Lq4/d;->c:Ljava/lang/Object;

    .line 29
    .line 30
    check-cast p1, Lk3/t;

    .line 31
    .line 32
    invoke-virtual {p1, v0}, Lk3/t;->i(Lq4/d;)V

    .line 33
    .line 34
    .line 35
    :goto_0
    return-void

    .line 36
    :goto_1
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 37
    throw p1
.end method

.method public final d(Ljava/lang/Boolean;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lw5/d;->a:Lq4/d;

    .line 2
    .line 3
    iget-object v1, v0, Lq4/d;->b:Ljava/lang/Object;

    .line 4
    .line 5
    monitor-enter v1

    .line 6
    :try_start_0
    iget-boolean v2, v0, Lq4/d;->a:Z

    .line 7
    .line 8
    if-eqz v2, :cond_0

    .line 9
    .line 10
    monitor-exit v1

    .line 11
    goto :goto_0

    .line 12
    :catchall_0
    move-exception p1

    .line 13
    goto :goto_1

    .line 14
    :cond_0
    const/4 v2, 0x1

    .line 15
    iput-boolean v2, v0, Lq4/d;->a:Z

    .line 16
    .line 17
    iput-object p1, v0, Lq4/d;->d:Ljava/lang/Object;

    .line 18
    .line 19
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 20
    iget-object p1, v0, Lq4/d;->c:Ljava/lang/Object;

    .line 21
    .line 22
    check-cast p1, Lk3/t;

    .line 23
    .line 24
    invoke-virtual {p1, v0}, Lk3/t;->i(Lq4/d;)V

    .line 25
    .line 26
    .line 27
    :goto_0
    return-void

    .line 28
    :goto_1
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 29
    throw p1
.end method
