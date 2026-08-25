.class public final Lga/b;
.super Ljava/lang/Object;
.source "MyApplication"


# static fields
.field public static final c:Ljava/lang/String;


# instance fields
.field public a:Landroid/widget/PopupWindow;

.field public b:Landroid/widget/FrameLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    const-string v0, "eqapoIE=\n"

    .line 2
    .line 3
    const-string v1, "OPXk0+Zs+Kg=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    sput-object v0, Lga/b;->c:Ljava/lang/String;

    .line 10
    .line 11
    return-void
.end method

.method public static a(Lga/b;Ljava/lang/String;Lorg/bitspark/android/Spark;)V
    .locals 5

    .line 1
    const v0, 0x7f0e0073

    .line 2
    .line 3
    .line 4
    const/4 v1, 0x0

    .line 5
    invoke-static {p2, v0, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 6
    .line 7
    .line 8
    move-result-object p2

    .line 9
    sget v0, Lea/a;->i:I

    .line 10
    .line 11
    mul-int/lit16 v0, v0, 0x212

    .line 12
    .line 13
    div-int/lit16 v0, v0, 0x780

    .line 14
    .line 15
    const-string v1, "XnLcn0BSJg==\n"

    .line 16
    .line 17
    const-string v2, "LRqz6BA9VkE=\n"

    .line 18
    .line 19
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v1

    .line 23
    new-instance v2, Ljava/lang/StringBuilder;

    .line 24
    .line 25
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 26
    .line 27
    .line 28
    const-string v3, "3ETrPKafOU0=\n"

    .line 29
    .line 30
    const-string v4, "uC2GWcjHA20=\n"

    .line 31
    .line 32
    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 33
    .line 34
    .line 35
    move-result-object v3

    .line 36
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 37
    .line 38
    .line 39
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 40
    .line 41
    .line 42
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 43
    .line 44
    .line 45
    move-result-object v2

    .line 46
    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 47
    .line 48
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    .line 50
    .line 51
    new-instance v1, Landroid/widget/PopupWindow;

    .line 52
    .line 53
    const/4 v2, -0x2

    .line 54
    invoke-direct {v1, p2, v0, v2}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;II)V

    .line 55
    .line 56
    .line 57
    iput-object v1, p0, Lga/b;->a:Landroid/widget/PopupWindow;

    .line 58
    .line 59
    invoke-virtual {v1}, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;

    .line 60
    .line 61
    .line 62
    move-result-object p2

    .line 63
    const v0, 0x7f0b02a4

    .line 64
    .line 65
    .line 66
    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 67
    .line 68
    .line 69
    move-result-object p2

    .line 70
    check-cast p2, Landroid/widget/TextView;

    .line 71
    .line 72
    iget-object v0, p0, Lga/b;->a:Landroid/widget/PopupWindow;

    .line 73
    .line 74
    invoke-virtual {v0}, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    const v1, 0x7f0b02a8

    .line 79
    .line 80
    .line 81
    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 82
    .line 83
    .line 84
    move-result-object v0

    .line 85
    check-cast v0, Landroid/widget/TextView;

    .line 86
    .line 87
    const/high16 v1, 0x41700000    # 15.0f

    .line 88
    .line 89
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    .line 90
    .line 91
    .line 92
    const/high16 v0, 0x41600000    # 14.0f

    .line 93
    .line 94
    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setTextSize(F)V

    .line 95
    .line 96
    .line 97
    invoke-virtual {p2, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 98
    .line 99
    .line 100
    iget-object p1, p0, Lga/b;->a:Landroid/widget/PopupWindow;

    .line 101
    .line 102
    new-instance p2, Landroid/graphics/drawable/BitmapDrawable;

    .line 103
    .line 104
    invoke-direct {p2}, Landroid/graphics/drawable/BitmapDrawable;-><init>()V

    .line 105
    .line 106
    .line 107
    invoke-virtual {p1, p2}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 108
    .line 109
    .line 110
    iget-object p1, p0, Lga/b;->a:Landroid/widget/PopupWindow;

    .line 111
    .line 112
    const p2, 0x7f1304e8

    .line 113
    .line 114
    .line 115
    invoke-virtual {p1, p2}, Landroid/widget/PopupWindow;->setAnimationStyle(I)V

    .line 116
    .line 117
    .line 118
    const/4 p1, 0x2

    .line 119
    new-array p1, p1, [I

    .line 120
    .line 121
    iget-object p2, p0, Lga/b;->b:Landroid/widget/FrameLayout;

    .line 122
    .line 123
    invoke-virtual {p2, p1}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 124
    .line 125
    .line 126
    iget-object p0, p0, Lga/b;->a:Landroid/widget/PopupWindow;

    .line 127
    .line 128
    const/16 p1, 0x35

    .line 129
    .line 130
    const/16 v0, 0x14

    .line 131
    .line 132
    const/16 v1, 0x3c

    .line 133
    .line 134
    invoke-virtual {p0, p2, p1, v0, v1}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    .line 135
    .line 136
    .line 137
    return-void
.end method
