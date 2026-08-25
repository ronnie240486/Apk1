.class public final Lra/c;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Lra/a;


# instance fields
.field public a:Landroid/widget/VideoView;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    const-string v0, "QjKuo62WqYdmLo8=\n"

    .line 2
    .line 3
    const-string v1, "D0v4ysnzxtE=\n"

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
    const-string v0, "m7VJ4hf+\n"

    .line 2
    .line 3
    const-string v1, "6N0mlS3eLk8=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 9
    .line 10
    const/4 v1, 0x0

    .line 11
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 12
    .line 13
    .line 14
    return-void
.end method

.method public final b()V
    .locals 2

    .line 1
    const-string v0, "9tIk9E9cSpEtDQ==\n"

    .line 2
    .line 3
    const-string v1, "hLdQhjZmanY=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method

.method public final c()V
    .locals 2

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/widget/VideoView;->stopPlayback()V

    .line 4
    .line 5
    .line 6
    const-string v0, "sIvtkF6owzuhnuGLNA==\n"

    .line 7
    .line 8
    const-string v1, "w/+C4A7EokI=\n"

    .line 9
    .line 10
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final d()V
    .locals 2

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/widget/VideoView;->resume()V

    .line 4
    .line 5
    .line 6
    const-string v0, "f1GNADLeiaI=\n"

    .line 7
    .line 8
    const-string v1, "DTT+dV+7s4I=\n"

    .line 9
    .line 10
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final e()V
    .locals 2

    .line 1
    const-string v0, "kfVVqn2hugdY\n"

    .line 2
    .line 3
    const-string v1, "4oE62keBXa4=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method

.method public final f()V
    .locals 1

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    invoke-static {v0}, Lo9/d;->y(Landroid/view/View;)Z

    .line 4
    .line 5
    .line 6
    return-void
.end method

.method public final g(Landroid/net/Uri;Ljava/util/HashMap;)V
    .locals 2

    .line 1
    const-string v0, "366VRLTwLKT5mago/Q==\n"

    .line 2
    .line 3
    const-string v1, "rMvhEt2UScs=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 9
    .line 10
    invoke-virtual {v0, p1, p2}, Landroid/widget/VideoView;->setVideoURI(Landroid/net/Uri;Ljava/util/Map;)V

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final getBufferedPercentage()I
    .locals 2

    .line 1
    const-string v0, "JjIRNrLoP0MzMgEkovw6Qy8jBBOitHnB6O0=\n"

    .line 2
    .line 3
    const-string v1, "QVdldMeOWSY=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x0

    .line 9
    return v0
.end method

.method public final getCurrentPosition()J
    .locals 2

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/widget/VideoView;->getCurrentPosition()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    int-to-long v0, v0

    .line 8
    return-wide v0
.end method

.method public final getDuration()J
    .locals 2

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/widget/VideoView;->getDuration()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    int-to-long v0, v0

    .line 8
    return-wide v0
.end method

.method public final getPlayWhenReady()Z
    .locals 2

    .line 1
    const-string v0, "tunmdY8vhyG56fx3hi+aD+usdYxZ\n"

    .line 2
    .line 3
    const-string v1, "0YySJeNO/nY=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x0

    .line 9
    return v0
.end method

.method public final h(Ljava/lang/String;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Landroid/widget/VideoView;->setVideoPath(Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    const-string p1, "4qXTOJ3eUmDBodMGzpo=\n"

    .line 7
    .line 8
    const-string v0, "kcCnbvS6Nw8=\n"

    .line 9
    .line 10
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final i(I)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

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
    .locals 1

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/widget/VideoView;->isPlaying()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
.end method

.method public final isVisible()Z
    .locals 2

    .line 1
    const-string v0, "yAxT6FDmpcfERSU=\n"

    .line 2
    .line 3
    const-string v1, "oX8FgSOPx6s=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 9
    .line 10
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 11
    .line 12
    .line 13
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 14
    .line 15
    .line 16
    move-result v0

    .line 17
    if-nez v0, :cond_0

    .line 18
    .line 19
    const/4 v0, 0x1

    .line 20
    goto :goto_0

    .line 21
    :cond_0
    const/4 v0, 0x0

    .line 22
    :goto_0
    return v0
.end method

.method public final j()V
    .locals 2

    .line 1
    const-string v0, "loOuTwjl\n"

    .line 2
    .line 3
    const-string v1, "/urKKjLFBAA=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 9
    .line 10
    const/16 v1, 0x8

    .line 11
    .line 12
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 13
    .line 14
    .line 15
    return-void
.end method

.method public final pause()V
    .locals 2

    .line 1
    const-string v0, "ByFn7ro7mg==\n"

    .line 2
    .line 3
    const-string v1, "d0ASnd8Bunw=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 9
    .line 10
    invoke-virtual {v0}, Landroid/widget/VideoView;->pause()V

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final prepare()V
    .locals 2

    .line 1
    const-string v0, "GDXinJdDRZVIoC5W\n"

    .line 2
    .line 3
    const-string v1, "aEeH7PYxIK8=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method

.method public final release()V
    .locals 2

    .line 1
    const-string v0, "/FdJ9R4nyJOu1Ywq\n"

    .line 2
    .line 3
    const-string v1, "jjIlkH9Urak=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method

.method public final seekTo(J)V
    .locals 1

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    long-to-int p2, p1

    .line 4
    invoke-virtual {v0, p2}, Landroid/widget/VideoView;->seekTo(I)V

    .line 5
    .line 6
    .line 7
    return-void
.end method

.method public final setPlayWhenReady(Z)V
    .locals 1

    .line 1
    const-string p1, "Bvs6LpkvK0Md+yAskC82bU++qddP\n"

    .line 2
    .line 3
    const-string v0, "dZ5OfvVOUhQ=\n"

    .line 4
    .line 5
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method

.method public final start()V
    .locals 2

    .line 1
    iget-object v0, p0, Lra/c;->a:Landroid/widget/VideoView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    .line 4
    .line 5
    .line 6
    const-string v0, "6Pid8znS5A==\n"

    .line 7
    .line 8
    const-string v1, "m4z8gU3oxJw=\n"

    .line 9
    .line 10
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    return-void
.end method

.method public final stop()V
    .locals 2

    .line 1
    const-string v0, "4bXy/Ce+TXIo\n"

    .line 2
    .line 3
    const-string v1, "ksGdjB2eqts=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    return-void
.end method
