.class public final Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;
.super Landroid/view/ViewGroup;
.source "MyApplication"


# instance fields
.field public final a:[I

.field public final b:Landroid/graphics/Rect;

.field public final c:Landroid/graphics/Rect;

.field public final d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

.field public final e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

.field public f:Landroidx/mediarouter/app/MediaRouteButton;

.field public g:Landroid/animation/AnimatorSet;

.field public final h:Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;

.field public final i:Lj7/c;

.field public j:Lj7/c;

.field public k:La1/b;

.field public l:Z

.field public m:Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 3

    .line 1
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x2

    .line 5
    new-array v0, v0, [I

    .line 6
    .line 7
    iput-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->a:[I

    .line 8
    .line 9
    new-instance v0, Landroid/graphics/Rect;

    .line 10
    .line 11
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 12
    .line 13
    .line 14
    iput-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->b:Landroid/graphics/Rect;

    .line 15
    .line 16
    new-instance v0, Landroid/graphics/Rect;

    .line 17
    .line 18
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 19
    .line 20
    .line 21
    iput-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->c:Landroid/graphics/Rect;

    .line 22
    .line 23
    const v0, 0x7f0b00b3

    .line 24
    .line 25
    .line 26
    invoke-virtual {p0, v0}, Landroid/view/View;->setId(I)V

    .line 27
    .line 28
    .line 29
    const/4 v0, 0x0

    .line 30
    invoke-virtual {p0, v0}, Landroid/view/View;->setWillNotDraw(Z)V

    .line 31
    .line 32
    .line 33
    new-instance v1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 34
    .line 35
    invoke-direct {v1, p1}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;-><init>(Landroid/app/Activity;)V

    .line 36
    .line 37
    .line 38
    iput-object v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 39
    .line 40
    invoke-virtual {v1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 41
    .line 42
    .line 43
    new-instance v1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 44
    .line 45
    invoke-direct {v1, p1}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;-><init>(Landroid/app/Activity;)V

    .line 46
    .line 47
    .line 48
    iput-object v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 49
    .line 50
    invoke-virtual {v1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 51
    .line 52
    .line 53
    new-instance v1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;

    .line 54
    .line 55
    invoke-direct {v1, p0}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;-><init>(Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;)V

    .line 56
    .line 57
    .line 58
    iput-object v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->h:Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;

    .line 59
    .line 60
    new-instance v1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/a;

    .line 61
    .line 62
    invoke-direct {v1, p0}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/a;-><init>(Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;)V

    .line 63
    .line 64
    .line 65
    new-instance v2, Lj7/c;

    .line 66
    .line 67
    invoke-direct {v2, p1, v1}, Lj7/c;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$SimpleOnGestureListener;)V

    .line 68
    .line 69
    .line 70
    iput-object v2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->i:Lj7/c;

    .line 71
    .line 72
    iget-object p1, v2, Lj7/c;->b:Ljava/lang/Object;

    .line 73
    .line 74
    check-cast p1, Landroid/view/GestureDetector;

    .line 75
    .line 76
    invoke-virtual {p1, v0}, Landroid/view/GestureDetector;->setIsLongpressEnabled(Z)V

    .line 77
    .line 78
    .line 79
    const/16 p1, 0x8

    .line 80
    .line 81
    invoke-virtual {p0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 82
    .line 83
    .line 84
    return-void
.end method


# virtual methods
.method public final checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 0

    .line 1
    instance-of p1, p1, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 2
    .line 3
    return p1
.end method

.method public final generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 2

    .line 1
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 2
    .line 3
    const/4 v1, -0x2

    .line 4
    invoke-direct {v0, v1, v1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V

    .line 5
    .line 6
    .line 7
    return-object v0
.end method

.method public final generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 2

    .line 1
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method public final generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .line 2
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-direct {v0, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method public final onDraw(Landroid/graphics/Canvas;)V
    .locals 9

    .line 1
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 5
    .line 6
    invoke-virtual {v0, p1}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 7
    .line 8
    .line 9
    iget-object v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 10
    .line 11
    invoke-virtual {v1, p1}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 12
    .line 13
    .line 14
    iget-object v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 15
    .line 16
    if-eqz v1, :cond_4

    .line 17
    .line 18
    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    if-eqz v1, :cond_3

    .line 23
    .line 24
    iget-object v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 25
    .line 26
    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    iget-object v2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 31
    .line 32
    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    .line 33
    .line 34
    .line 35
    move-result v2

    .line 36
    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .line 37
    .line 38
    invoke-static {v1, v2, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    .line 39
    .line 40
    .line 41
    move-result-object v1

    .line 42
    new-instance v2, Landroid/graphics/Canvas;

    .line 43
    .line 44
    invoke-direct {v2, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 45
    .line 46
    .line 47
    iget-object v3, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 48
    .line 49
    invoke-virtual {v3, v2}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    .line 50
    .line 51
    .line 52
    iget-object v0, v0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->f:Landroid/graphics/Paint;

    .line 53
    .line 54
    invoke-virtual {v0}, Landroid/graphics/Paint;->getColor()I

    .line 55
    .line 56
    .line 57
    move-result v0

    .line 58
    invoke-static {v0}, Landroid/graphics/Color;->red(I)I

    .line 59
    .line 60
    .line 61
    move-result v2

    .line 62
    invoke-static {v0}, Landroid/graphics/Color;->green(I)I

    .line 63
    .line 64
    .line 65
    move-result v3

    .line 66
    invoke-static {v0}, Landroid/graphics/Color;->blue(I)I

    .line 67
    .line 68
    .line 69
    move-result v0

    .line 70
    const/4 v4, 0x0

    .line 71
    const/4 v5, 0x0

    .line 72
    :goto_0
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    .line 73
    .line 74
    .line 75
    move-result v6

    .line 76
    if-ge v5, v6, :cond_2

    .line 77
    .line 78
    const/4 v6, 0x0

    .line 79
    :goto_1
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    .line 80
    .line 81
    .line 82
    move-result v7

    .line 83
    if-ge v6, v7, :cond_1

    .line 84
    .line 85
    invoke-virtual {v1, v6, v5}, Landroid/graphics/Bitmap;->getPixel(II)I

    .line 86
    .line 87
    .line 88
    move-result v7

    .line 89
    invoke-static {v7}, Landroid/graphics/Color;->alpha(I)I

    .line 90
    .line 91
    .line 92
    move-result v8

    .line 93
    if-eqz v8, :cond_0

    .line 94
    .line 95
    invoke-static {v7}, Landroid/graphics/Color;->alpha(I)I

    .line 96
    .line 97
    .line 98
    move-result v7

    .line 99
    invoke-static {v7, v2, v3, v0}, Landroid/graphics/Color;->argb(IIII)I

    .line 100
    .line 101
    .line 102
    move-result v7

    .line 103
    invoke-virtual {v1, v6, v5, v7}, Landroid/graphics/Bitmap;->setPixel(III)V

    .line 104
    .line 105
    .line 106
    :cond_0
    add-int/lit8 v6, v6, 0x1

    .line 107
    .line 108
    goto :goto_1

    .line 109
    :cond_1
    add-int/lit8 v5, v5, 0x1

    .line 110
    .line 111
    goto :goto_0

    .line 112
    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->b:Landroid/graphics/Rect;

    .line 113
    .line 114
    iget v2, v0, Landroid/graphics/Rect;->left:I

    .line 115
    .line 116
    int-to-float v2, v2

    .line 117
    iget v0, v0, Landroid/graphics/Rect;->top:I

    .line 118
    .line 119
    int-to-float v0, v0

    .line 120
    const/4 v3, 0x0

    .line 121
    invoke-virtual {p1, v1, v2, v0, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 122
    .line 123
    .line 124
    :cond_3
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 125
    .line 126
    .line 127
    return-void

    .line 128
    :cond_4
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 129
    .line 130
    const-string v0, "Neither target view nor drawable was set"

    .line 131
    .line 132
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 133
    .line 134
    .line 135
    throw p1
.end method

.method public final onLayout(ZIIII)V
    .locals 9

    .line 1
    iget-object p1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 2
    .line 3
    if-eqz p1, :cond_6

    .line 4
    .line 5
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->a:[I

    .line 10
    .line 11
    const/4 v1, 0x1

    .line 12
    const/4 v2, 0x0

    .line 13
    if-eqz p1, :cond_0

    .line 14
    .line 15
    iget-object p1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 16
    .line 17
    invoke-virtual {p0, v0}, Landroid/view/View;->getLocationInWindow([I)V

    .line 18
    .line 19
    .line 20
    aget v3, v0, v2

    .line 21
    .line 22
    aget v4, v0, v1

    .line 23
    .line 24
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationInWindow([I)V

    .line 25
    .line 26
    .line 27
    aget p1, v0, v2

    .line 28
    .line 29
    sub-int/2addr p1, v3

    .line 30
    aput p1, v0, v2

    .line 31
    .line 32
    aget p1, v0, v1

    .line 33
    .line 34
    sub-int/2addr p1, v4

    .line 35
    aput p1, v0, v1

    .line 36
    .line 37
    :cond_0
    aget p1, v0, v2

    .line 38
    .line 39
    aget v3, v0, v1

    .line 40
    .line 41
    iget-object v4, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 42
    .line 43
    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    .line 44
    .line 45
    .line 46
    move-result v4

    .line 47
    add-int/2addr v4, p1

    .line 48
    aget v0, v0, v1

    .line 49
    .line 50
    iget-object v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 51
    .line 52
    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    .line 53
    .line 54
    .line 55
    move-result v1

    .line 56
    add-int/2addr v1, v0

    .line 57
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->b:Landroid/graphics/Rect;

    .line 58
    .line 59
    invoke-virtual {v0, p1, v3, v4, v1}, Landroid/graphics/Rect;->set(IIII)V

    .line 60
    .line 61
    .line 62
    iget-object p1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->c:Landroid/graphics/Rect;

    .line 63
    .line 64
    invoke-virtual {p1, p2, p3, p4, p5}, Landroid/graphics/Rect;->set(IIII)V

    .line 65
    .line 66
    .line 67
    iget-object p2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 68
    .line 69
    invoke-virtual {p2, p1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 70
    .line 71
    .line 72
    iget-object p2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 73
    .line 74
    invoke-virtual {p2, p1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 75
    .line 76
    .line 77
    iget-object p2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->h:Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;

    .line 78
    .line 79
    iget-object p3, p2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->g:Ljava/lang/Object;

    .line 80
    .line 81
    check-cast p3, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;

    .line 82
    .line 83
    iget-object p4, p3, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->m:Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;

    .line 84
    .line 85
    invoke-virtual {p4}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/HelpTextView;->asView()Landroid/view/View;

    .line 86
    .line 87
    .line 88
    move-result-object p4

    .line 89
    invoke-virtual {v0}, Landroid/graphics/Rect;->isEmpty()Z

    .line 90
    .line 91
    .line 92
    move-result p5

    .line 93
    if-nez p5, :cond_3

    .line 94
    .line 95
    invoke-virtual {p1}, Landroid/graphics/Rect;->isEmpty()Z

    .line 96
    .line 97
    .line 98
    move-result p5

    .line 99
    if-eqz p5, :cond_1

    .line 100
    .line 101
    goto/16 :goto_0

    .line 102
    .line 103
    :cond_1
    invoke-virtual {v0}, Landroid/graphics/Rect;->centerY()I

    .line 104
    .line 105
    .line 106
    move-result p5

    .line 107
    invoke-virtual {v0}, Landroid/graphics/Rect;->centerX()I

    .line 108
    .line 109
    .line 110
    move-result v8

    .line 111
    invoke-virtual {p1}, Landroid/graphics/Rect;->centerY()I

    .line 112
    .line 113
    .line 114
    move-result v1

    .line 115
    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    .line 116
    .line 117
    .line 118
    move-result v2

    .line 119
    iget v3, p2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->b:I

    .line 120
    .line 121
    add-int/2addr v3, v3

    .line 122
    invoke-static {v3, v2}, Ljava/lang/Math;->max(II)I

    .line 123
    .line 124
    .line 125
    move-result v2

    .line 126
    div-int/lit8 v2, v2, 0x2

    .line 127
    .line 128
    add-int v3, p5, v2

    .line 129
    .line 130
    iget v4, p2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->c:I

    .line 131
    .line 132
    if-ge p5, v1, :cond_2

    .line 133
    .line 134
    add-int p5, v3, v4

    .line 135
    .line 136
    iget v1, p1, Landroid/graphics/Rect;->bottom:I

    .line 137
    .line 138
    sub-int/2addr v1, p5

    .line 139
    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    .line 140
    .line 141
    .line 142
    move-result v2

    .line 143
    invoke-virtual {p2, p4, v2, v1}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->k(Landroid/view/View;II)V

    .line 144
    .line 145
    .line 146
    iget v5, p1, Landroid/graphics/Rect;->left:I

    .line 147
    .line 148
    iget v6, p1, Landroid/graphics/Rect;->right:I

    .line 149
    .line 150
    invoke-virtual {p4}, Landroid/view/View;->getMeasuredWidth()I

    .line 151
    .line 152
    .line 153
    move-result v7

    .line 154
    move-object v3, p2

    .line 155
    move-object v4, p4

    .line 156
    invoke-virtual/range {v3 .. v8}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->j(Landroid/view/View;IIII)I

    .line 157
    .line 158
    .line 159
    move-result p1

    .line 160
    invoke-virtual {p4}, Landroid/view/View;->getMeasuredWidth()I

    .line 161
    .line 162
    .line 163
    move-result v1

    .line 164
    add-int/2addr v1, p1

    .line 165
    invoke-virtual {p4}, Landroid/view/View;->getMeasuredHeight()I

    .line 166
    .line 167
    .line 168
    move-result v2

    .line 169
    add-int/2addr v2, p5

    .line 170
    invoke-virtual {p4, p1, p5, v1, v2}, Landroid/view/View;->layout(IIII)V

    .line 171
    .line 172
    .line 173
    goto :goto_1

    .line 174
    :cond_2
    sub-int/2addr p5, v2

    .line 175
    iget v1, p1, Landroid/graphics/Rect;->top:I

    .line 176
    .line 177
    sub-int/2addr p5, v4

    .line 178
    sub-int v1, p5, v1

    .line 179
    .line 180
    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    .line 181
    .line 182
    .line 183
    move-result v2

    .line 184
    invoke-virtual {p2, p4, v2, v1}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->k(Landroid/view/View;II)V

    .line 185
    .line 186
    .line 187
    iget v5, p1, Landroid/graphics/Rect;->left:I

    .line 188
    .line 189
    iget v6, p1, Landroid/graphics/Rect;->right:I

    .line 190
    .line 191
    invoke-virtual {p4}, Landroid/view/View;->getMeasuredWidth()I

    .line 192
    .line 193
    .line 194
    move-result v7

    .line 195
    move-object v3, p2

    .line 196
    move-object v4, p4

    .line 197
    invoke-virtual/range {v3 .. v8}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->j(Landroid/view/View;IIII)I

    .line 198
    .line 199
    .line 200
    move-result p1

    .line 201
    invoke-virtual {p4}, Landroid/view/View;->getMeasuredHeight()I

    .line 202
    .line 203
    .line 204
    move-result v1

    .line 205
    sub-int v1, p5, v1

    .line 206
    .line 207
    invoke-virtual {p4}, Landroid/view/View;->getMeasuredWidth()I

    .line 208
    .line 209
    .line 210
    move-result v2

    .line 211
    add-int/2addr v2, p1

    .line 212
    invoke-virtual {p4, p1, v1, v2, p5}, Landroid/view/View;->layout(IIII)V

    .line 213
    .line 214
    .line 215
    goto :goto_1

    .line 216
    :cond_3
    :goto_0
    invoke-virtual {p4, v2, v2, v2, v2}, Landroid/view/View;->layout(IIII)V

    .line 217
    .line 218
    .line 219
    :goto_1
    invoke-virtual {p4}, Landroid/view/View;->getLeft()I

    .line 220
    .line 221
    .line 222
    move-result p1

    .line 223
    invoke-virtual {p4}, Landroid/view/View;->getTop()I

    .line 224
    .line 225
    .line 226
    move-result p5

    .line 227
    invoke-virtual {p4}, Landroid/view/View;->getRight()I

    .line 228
    .line 229
    .line 230
    move-result v1

    .line 231
    invoke-virtual {p4}, Landroid/view/View;->getBottom()I

    .line 232
    .line 233
    .line 234
    move-result p4

    .line 235
    iget-object p2, p2, Lcom/google/android/gms/cast/framework/internal/featurehighlight/f;->f:Ljava/lang/Object;

    .line 236
    .line 237
    check-cast p2, Landroid/graphics/Rect;

    .line 238
    .line 239
    invoke-virtual {p2, p1, p5, v1, p4}, Landroid/graphics/Rect;->set(IIII)V

    .line 240
    .line 241
    .line 242
    iget-object p1, p3, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 243
    .line 244
    iget-object p4, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->d:Landroid/graphics/Rect;

    .line 245
    .line 246
    invoke-virtual {p4, v0}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 247
    .line 248
    .line 249
    iget-object p4, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->e:Landroid/graphics/Rect;

    .line 250
    .line 251
    invoke-virtual {p4, p2}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 252
    .line 253
    .line 254
    invoke-virtual {v0}, Landroid/graphics/Rect;->exactCenterX()F

    .line 255
    .line 256
    .line 257
    move-result p4

    .line 258
    invoke-virtual {v0}, Landroid/graphics/Rect;->exactCenterY()F

    .line 259
    .line 260
    .line 261
    move-result p5

    .line 262
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    .line 263
    .line 264
    .line 265
    move-result-object v1

    .line 266
    iget v2, v1, Landroid/graphics/Rect;->top:I

    .line 267
    .line 268
    int-to-float v2, v2

    .line 269
    sub-float v2, p5, v2

    .line 270
    .line 271
    iget v3, v1, Landroid/graphics/Rect;->bottom:I

    .line 272
    .line 273
    int-to-float v3, v3

    .line 274
    sub-float/2addr v3, p5

    .line 275
    invoke-static {v2, v3}, Ljava/lang/Math;->min(FF)F

    .line 276
    .line 277
    .line 278
    move-result v2

    .line 279
    iget v3, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->a:I

    .line 280
    .line 281
    int-to-float v3, v3

    .line 282
    cmpg-float v2, v2, v3

    .line 283
    .line 284
    if-gez v2, :cond_4

    .line 285
    .line 286
    iput p4, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->i:F

    .line 287
    .line 288
    iput p5, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->j:F

    .line 289
    .line 290
    goto :goto_3

    .line 291
    :cond_4
    invoke-virtual {v1}, Landroid/graphics/Rect;->exactCenterX()F

    .line 292
    .line 293
    .line 294
    move-result p5

    .line 295
    iget v1, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->b:I

    .line 296
    .line 297
    cmpg-float p4, p4, p5

    .line 298
    .line 299
    if-gtz p4, :cond_5

    .line 300
    .line 301
    invoke-virtual {p2}, Landroid/graphics/Rect;->exactCenterX()F

    .line 302
    .line 303
    .line 304
    move-result p4

    .line 305
    int-to-float p5, v1

    .line 306
    add-float/2addr p4, p5

    .line 307
    goto :goto_2

    .line 308
    :cond_5
    invoke-virtual {p2}, Landroid/graphics/Rect;->exactCenterX()F

    .line 309
    .line 310
    .line 311
    move-result p4

    .line 312
    int-to-float p5, v1

    .line 313
    sub-float/2addr p4, p5

    .line 314
    :goto_2
    iput p4, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->i:F

    .line 315
    .line 316
    invoke-virtual {p2}, Landroid/graphics/Rect;->exactCenterY()F

    .line 317
    .line 318
    .line 319
    move-result p5

    .line 320
    iput p5, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->j:F

    .line 321
    .line 322
    :goto_3
    iget p4, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->i:F

    .line 323
    .line 324
    invoke-static {p4, p5, v0}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->a(FFLandroid/graphics/Rect;)F

    .line 325
    .line 326
    .line 327
    move-result p4

    .line 328
    iget p5, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->i:F

    .line 329
    .line 330
    iget v1, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->j:F

    .line 331
    .line 332
    invoke-static {p5, v1, p2}, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->a(FFLandroid/graphics/Rect;)F

    .line 333
    .line 334
    .line 335
    move-result p2

    .line 336
    invoke-static {p4, p2}, Ljava/lang/Math;->max(FF)F

    .line 337
    .line 338
    .line 339
    move-result p2

    .line 340
    iget p4, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->c:I

    .line 341
    .line 342
    int-to-float p4, p4

    .line 343
    add-float/2addr p4, p2

    .line 344
    iput p4, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;->g:F

    .line 345
    .line 346
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->invalidateSelf()V

    .line 347
    .line 348
    .line 349
    iget-object p1, p3, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 350
    .line 351
    iget-object p2, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;->c:Landroid/graphics/Rect;

    .line 352
    .line 353
    invoke-virtual {p2, v0}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 354
    .line 355
    .line 356
    invoke-virtual {p2}, Landroid/graphics/Rect;->exactCenterX()F

    .line 357
    .line 358
    .line 359
    move-result p3

    .line 360
    iput p3, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;->h:F

    .line 361
    .line 362
    invoke-virtual {p2}, Landroid/graphics/Rect;->exactCenterY()F

    .line 363
    .line 364
    .line 365
    move-result p3

    .line 366
    iput p3, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;->i:F

    .line 367
    .line 368
    invoke-virtual {p2}, Landroid/graphics/Rect;->width()I

    .line 369
    .line 370
    .line 371
    move-result p3

    .line 372
    int-to-float p3, p3

    .line 373
    invoke-virtual {p2}, Landroid/graphics/Rect;->height()I

    .line 374
    .line 375
    .line 376
    move-result p2

    .line 377
    int-to-float p2, p2

    .line 378
    const/high16 p4, 0x40000000    # 2.0f

    .line 379
    .line 380
    div-float/2addr p3, p4

    .line 381
    div-float/2addr p2, p4

    .line 382
    iget p4, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;->d:I

    .line 383
    .line 384
    int-to-float p4, p4

    .line 385
    invoke-static {p3, p2}, Ljava/lang/Math;->max(FF)F

    .line 386
    .line 387
    .line 388
    move-result p2

    .line 389
    invoke-static {p4, p2}, Ljava/lang/Math;->max(FF)F

    .line 390
    .line 391
    .line 392
    move-result p2

    .line 393
    iput p2, p1, Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;->f:F

    .line 394
    .line 395
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->invalidateSelf()V

    .line 396
    .line 397
    .line 398
    return-void

    .line 399
    :cond_6
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 400
    .line 401
    const-string p2, "Target view must be set before layout"

    .line 402
    .line 403
    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 404
    .line 405
    .line 406
    throw p1
.end method

.method public final onMeasure(II)V
    .locals 2

    .line 1
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    invoke-static {v0, p1}, Landroid/view/View;->resolveSize(II)I

    .line 10
    .line 11
    .line 12
    move-result p1

    .line 13
    invoke-static {v1, p2}, Landroid/view/View;->resolveSize(II)I

    .line 14
    .line 15
    .line 16
    move-result p2

    .line 17
    invoke-virtual {p0, p1, p2}, Landroid/view/View;->setMeasuredDimension(II)V

    .line 18
    .line 19
    .line 20
    return-void
.end method

.method public final onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3

    .line 1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    float-to-int v0, v0

    .line 12
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    .line 13
    .line 14
    .line 15
    move-result v1

    .line 16
    float-to-int v1, v1

    .line 17
    iget-object v2, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->b:Landroid/graphics/Rect;

    .line 18
    .line 19
    invoke-virtual {v2, v0, v1}, Landroid/graphics/Rect;->contains(II)Z

    .line 20
    .line 21
    .line 22
    move-result v0

    .line 23
    iput-boolean v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->l:Z

    .line 24
    .line 25
    const/4 v0, 0x0

    .line 26
    :cond_0
    iget-boolean v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->l:Z

    .line 27
    .line 28
    const/4 v2, 0x1

    .line 29
    if-eqz v1, :cond_2

    .line 30
    .line 31
    iget-object v1, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->j:Lj7/c;

    .line 32
    .line 33
    if-eqz v1, :cond_1

    .line 34
    .line 35
    iget-object v1, v1, Lj7/c;->b:Ljava/lang/Object;

    .line 36
    .line 37
    check-cast v1, Landroid/view/GestureDetector;

    .line 38
    .line 39
    invoke-virtual {v1, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 40
    .line 41
    .line 42
    if-ne v0, v2, :cond_1

    .line 43
    .line 44
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    .line 45
    .line 46
    .line 47
    move-result-object p1

    .line 48
    const/4 v0, 0x3

    .line 49
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->setAction(I)V

    .line 50
    .line 51
    .line 52
    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 53
    .line 54
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 55
    .line 56
    .line 57
    move-result-object v0

    .line 58
    if-eqz v0, :cond_3

    .line 59
    .line 60
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->f:Landroidx/mediarouter/app/MediaRouteButton;

    .line 61
    .line 62
    invoke-virtual {v0, p1}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 63
    .line 64
    .line 65
    goto :goto_0

    .line 66
    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->i:Lj7/c;

    .line 67
    .line 68
    iget-object v0, v0, Lj7/c;->b:Ljava/lang/Object;

    .line 69
    .line 70
    check-cast v0, Landroid/view/GestureDetector;

    .line 71
    .line 72
    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 73
    .line 74
    .line 75
    :cond_3
    :goto_0
    return v2
.end method

.method public final verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .locals 1

    .line 1
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-nez v0, :cond_1

    .line 6
    .line 7
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->d:Lcom/google/android/gms/cast/framework/internal/featurehighlight/OuterHighlightDrawable;

    .line 8
    .line 9
    if-eq p1, v0, :cond_1

    .line 10
    .line 11
    iget-object v0, p0, Lcom/google/android/gms/cast/framework/internal/featurehighlight/e;->e:Lcom/google/android/gms/cast/framework/internal/featurehighlight/InnerZoneDrawable;

    .line 12
    .line 13
    if-eq p1, v0, :cond_1

    .line 14
    .line 15
    if-nez p1, :cond_0

    .line 16
    .line 17
    goto :goto_0

    .line 18
    :cond_0
    const/4 p1, 0x0

    .line 19
    return p1

    .line 20
    :cond_1
    :goto_0
    const/4 p1, 0x1

    .line 21
    return p1
.end method
