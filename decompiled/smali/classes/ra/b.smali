.class public final Lra/b;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Lra/a;


# instance fields
.field public a:Landroidx/media3/exoplayer/ExoPlayer;

.field public b:Landroidx/media3/ui/PlayerView;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    const-string v0, "kkug+uURDMymV5c=\n"

    .line 2
    .line 3
    const-string v1, "3zLlgopBYK0=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    invoke-interface {v0}, Landroidx/media3/common/Player;->clearMediaItems()V

    .line 4
    .line 5
    .line 6
    const-string v0, "aKZvQbTQ\n"

    .line 7
    .line 8
    const-string v1, "G84ANo7wMUc=\n"

    .line 9
    .line 10
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, Lra/b;->b:Landroidx/media3/ui/PlayerView;

    .line 14
    .line 15
    const/4 v1, 0x0

    .line 16
    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerView;->setVisibility(I)V

    .line 17
    .line 18
    .line 19
    return-void
.end method

.method public final b()V
    .locals 4

    .line 1
    const-string v0, "YUOgYyTmNFtVX5c7OdMsSFUAxStlhg==\n"

    .line 2
    .line 3
    const-string v1, "LDrlG0u2WDo=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 9
    .line 10
    invoke-interface {v0}, Landroidx/media3/common/Player;->getCurrentMediaItem()Landroidx/media3/common/MediaItem;

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    if-nez v1, :cond_0

    .line 15
    .line 16
    return-void

    .line 17
    :cond_0
    const-string v2, "C9FoL8ntIhc/zV931Ng6BD+SDWeIjG4=\n"

    .line 18
    .line 19
    const-string v3, "RqgtV6a9TnY=\n"

    .line 20
    .line 21
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 22
    .line 23
    .line 24
    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->setMediaItem(Landroidx/media3/common/MediaItem;)V

    .line 25
    .line 26
    .line 27
    invoke-interface {v0}, Landroidx/media3/common/Player;->prepare()V

    .line 28
    .line 29
    .line 30
    const/4 v1, 0x1

    .line 31
    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->setPlayWhenReady(Z)V

    .line 32
    .line 33
    .line 34
    const-string v0, "bPYB9AogKUowolU=\n"

    .line 35
    .line 36
    const-string v1, "HpN1hnMaCXs=\n"

    .line 37
    .line 38
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 39
    .line 40
    .line 41
    return-void
.end method

.method public final c()V
    .locals 2

    .line 1
    const-string v0, "/2nIWL/F0F3ufMRD1YlWjTY=\n"

    .line 2
    .line 3
    const-string v1, "jB2nKO+psSQ=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method

.method public final d()V
    .locals 2

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->setPlayWhenReady(Z)V

    .line 5
    .line 6
    .line 7
    return-void
.end method

.method public final e()V
    .locals 2

    .line 1
    const-string v0, "eDYVSBnv\n"

    .line 2
    .line 3
    const-string v1, "C0J6OCPPk5o=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 9
    .line 10
    invoke-interface {v0}, Landroidx/media3/common/Player;->stop()V

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final f()V
    .locals 1

    .line 1
    iget-object v0, p0, Lra/b;->b:Landroidx/media3/ui/PlayerView;

    .line 2
    .line 3
    invoke-static {v0}, Lo9/d;->y(Landroid/view/View;)Z

    .line 4
    .line 5
    .line 6
    return-void
.end method

.method public final g(Landroid/net/Uri;Ljava/util/HashMap;)V
    .locals 0

    .line 1
    const-string p1, "woMYy3WJyPHktCWnPAoEJA==\n"

    .line 2
    .line 3
    const-string p2, "seZsnRztrZ4=\n"

    .line 4
    .line 5
    invoke-static {p1, p2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method

.method public final getBufferedPercentage()I
    .locals 1

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    invoke-interface {v0}, Landroidx/media3/common/Player;->getBufferedPercentage()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
.end method

.method public final getCurrentPosition()J
    .locals 2

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    invoke-interface {v0}, Landroidx/media3/common/Player;->getCurrentPosition()J

    .line 4
    .line 5
    .line 6
    move-result-wide v0

    .line 7
    return-wide v0
.end method

.method public final getDuration()J
    .locals 2

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    invoke-interface {v0}, Landroidx/media3/common/Player;->getDuration()J

    .line 4
    .line 5
    .line 6
    move-result-wide v0

    .line 7
    return-wide v0
.end method

.method public final getPlayWhenReady()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlayWhenReady()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
.end method

.method public final h(Ljava/lang/String;)V
    .locals 1

    .line 1
    const-string p1, "uvb9huo6ZEmZ8v24uX7mj3M=\n"

    .line 2
    .line 3
    const-string v0, "yZOJ0INeASY=\n"

    .line 4
    .line 5
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method

.method public final i(I)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lra/b;->b:Landroidx/media3/ui/PlayerView;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroid/view/View;->getId()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-ne p1, v0, :cond_0

    .line 10
    .line 11
    const/4 p1, 0x1

    .line 12
    goto :goto_0

    .line 13
    :cond_0
    const/4 p1, 0x0

    .line 14
    :goto_0
    return p1
.end method

.method public final isPlaying()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlayWhenReady()Z

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    if-eqz v1, :cond_1

    .line 8
    .line 9
    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlaybackState()I

    .line 10
    .line 11
    .line 12
    move-result v1

    .line 13
    const/4 v2, 0x3

    .line 14
    if-eq v1, v2, :cond_0

    .line 15
    .line 16
    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlaybackState()I

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    const/4 v1, 0x2

    .line 21
    if-ne v0, v1, :cond_1

    .line 22
    .line 23
    :cond_0
    const/4 v0, 0x1

    .line 24
    goto :goto_0

    .line 25
    :cond_1
    const/4 v0, 0x0

    .line 26
    :goto_0
    return v0
.end method

.method public final isVisible()Z
    .locals 2

    .line 1
    const-string v0, "6wAkRPbbITznSVI=\n"

    .line 2
    .line 3
    const-string v1, "gnNyLYWyQ1A=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/b;->b:Landroidx/media3/ui/PlayerView;

    .line 9
    .line 10
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 11
    .line 12
    .line 13
    move-result v0

    .line 14
    if-nez v0, :cond_0

    .line 15
    .line 16
    const/4 v0, 0x1

    .line 17
    goto :goto_0

    .line 18
    :cond_0
    const/4 v0, 0x0

    .line 19
    :goto_0
    return v0
.end method

.method public final j()V
    .locals 2

    .line 1
    const-string v0, "I5+3SkCR\n"

    .line 2
    .line 3
    const-string v1, "S/bTL3qxJFg=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/b;->b:Landroidx/media3/ui/PlayerView;

    .line 9
    .line 10
    const/16 v1, 0x8

    .line 11
    .line 12
    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerView;->setVisibility(I)V

    .line 13
    .line 14
    .line 15
    return-void
.end method

.method public final pause()V
    .locals 2

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->setPlayWhenReady(Z)V

    .line 5
    .line 6
    .line 7
    return-void
.end method

.method public final prepare()V
    .locals 2

    .line 1
    const-string v0, "UKIGuZh04YwA\n"

    .line 2
    .line 3
    const-string v1, "INBjyfkGhLY=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 9
    .line 10
    invoke-interface {v0}, Landroidx/media3/common/Player;->prepare()V

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final release()V
    .locals 2

    .line 1
    const-string v0, "NaxBZa8MDNRn\n"

    .line 2
    .line 3
    const-string v1, "R8ktAM5/ae4=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 9
    .line 10
    invoke-interface {v0}, Landroidx/media3/exoplayer/ExoPlayer;->release()V

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final seekTo(J)V
    .locals 1

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    invoke-interface {v0, p1, p2}, Landroidx/media3/common/Player;->seekTo(J)V

    .line 4
    .line 5
    .line 6
    return-void
.end method

.method public final setPlayWhenReady(Z)V
    .locals 1

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Landroidx/media3/common/Player;->setPlayWhenReady(Z)V

    .line 4
    .line 5
    .line 6
    return-void
.end method

.method public final start()V
    .locals 2

    .line 1
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->setPlayWhenReady(Z)V

    .line 5
    .line 6
    .line 7
    return-void
.end method

.method public final stop()V
    .locals 2

    .line 1
    const-string v0, "FKkBncoX\n"

    .line 2
    .line 3
    const-string v1, "Z91u7fA3szw=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/b;->a:Landroidx/media3/exoplayer/ExoPlayer;

    .line 9
    .line 10
    invoke-interface {v0}, Landroidx/media3/common/Player;->stop()V

    .line 11
    .line 12
    .line 13
    return-void
.end method
