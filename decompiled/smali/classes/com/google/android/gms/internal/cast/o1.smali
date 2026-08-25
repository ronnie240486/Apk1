.class public abstract Lcom/google/android/gms/internal/cast/o1;
.super Ljava/lang/Object;
.source "MyApplication"


# static fields
.field public static final a:Landroid/view/animation/Interpolator;

.field public static final b:Landroid/view/animation/Interpolator;

.field public static final c:Landroid/view/animation/Interpolator;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .line 1
    const/4 v0, 0x0

    .line 2
    const v1, 0x3e4ccccd    # 0.2f

    .line 3
    .line 4
    .line 5
    const/high16 v2, 0x3f800000    # 1.0f

    .line 6
    .line 7
    invoke-static {v0, v0, v1, v2}, Lp0/a;->b(FFFF)Landroid/view/animation/Interpolator;

    .line 8
    .line 9
    .line 10
    move-result-object v3

    .line 11
    sput-object v3, Lcom/google/android/gms/internal/cast/o1;->a:Landroid/view/animation/Interpolator;

    .line 12
    .line 13
    const v3, 0x3ecccccd    # 0.4f

    .line 14
    .line 15
    .line 16
    invoke-static {v3, v0, v2, v2}, Lp0/a;->b(FFFF)Landroid/view/animation/Interpolator;

    .line 17
    .line 18
    .line 19
    move-result-object v4

    .line 20
    sput-object v4, Lcom/google/android/gms/internal/cast/o1;->b:Landroid/view/animation/Interpolator;

    .line 21
    .line 22
    invoke-static {v3, v0, v1, v2}, Lp0/a;->b(FFFF)Landroid/view/animation/Interpolator;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    sput-object v0, Lcom/google/android/gms/internal/cast/o1;->c:Landroid/view/animation/Interpolator;

    .line 27
    .line 28
    return-void
.end method
