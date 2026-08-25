.class public final Ls0/d;
.super Landroid/view/inputmethod/InputConnectionWrapper;
.source "MyApplication"


# instance fields
.field public final synthetic a:Landroidx/media3/common/x;


# direct methods
.method public constructor <init>(Landroid/view/inputmethod/InputConnection;Landroidx/media3/common/x;)V
    .locals 0

    .line 1
    iput-object p2, p0, Ls0/d;->a:Landroidx/media3/common/x;

    .line 2
    .line 3
    const/4 p2, 0x0

    .line 4
    invoke-direct {p0, p1, p2}, Landroid/view/inputmethod/InputConnectionWrapper;-><init>(Landroid/view/inputmethod/InputConnection;Z)V

    .line 5
    .line 6
    .line 7
    return-void
.end method


# virtual methods
.method public final commitContent(Landroid/view/inputmethod/InputContentInfo;ILandroid/os/Bundle;)Z
    .locals 3

    .line 1
    const/4 v0, 0x0

    .line 2
    if-nez p1, :cond_0

    .line 3
    .line 4
    goto :goto_0

    .line 5
    :cond_0
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 6
    .line 7
    const/16 v2, 0x19

    .line 8
    .line 9
    if-ge v1, v2, :cond_1

    .line 10
    .line 11
    goto :goto_0

    .line 12
    :cond_1
    new-instance v0, Lr4/n;

    .line 13
    .line 14
    new-instance v1, Ls0/f;

    .line 15
    .line 16
    invoke-direct {v1, p1}, Ls0/f;-><init>(Ljava/lang/Object;)V

    .line 17
    .line 18
    .line 19
    const/4 v2, 0x1

    .line 20
    invoke-direct {v0, v2, v1}, Lr4/n;-><init>(ILjava/lang/Object;)V

    .line 21
    .line 22
    .line 23
    :goto_0
    iget-object v1, p0, Ls0/d;->a:Landroidx/media3/common/x;

    .line 24
    .line 25
    invoke-virtual {v1, v0, p2, p3}, Landroidx/media3/common/x;->d(Lr4/n;ILandroid/os/Bundle;)Z

    .line 26
    .line 27
    .line 28
    move-result v0

    .line 29
    if-eqz v0, :cond_2

    .line 30
    .line 31
    const/4 p1, 0x1

    .line 32
    return p1

    .line 33
    :cond_2
    invoke-super {p0, p1, p2, p3}, Landroid/view/inputmethod/InputConnectionWrapper;->commitContent(Landroid/view/inputmethod/InputContentInfo;ILandroid/os/Bundle;)Z

    .line 34
    .line 35
    .line 36
    move-result p1

    .line 37
    return p1
.end method
