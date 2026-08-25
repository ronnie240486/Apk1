.class public Lorg/bitspark/android/SpkApplication;
.super Landroid/app/Application;


# static fields
.field public static final b:Ljava/lang/String;

.field public static c:Lorg/bitspark/android/SpkApplication;


# instance fields
.field public a:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/16 v0, 0x2f

    invoke-static {v0}, Lcom/nmmedit/protect/NativeUtil;->classesInit0(I)V

    .line 1
    .line 2
    const-string v0, "meBbdJg=\n"

    .line 3
    .line 4
    const-string v1, "1JkaBOg7zzw=\n"

    .line 5
    .line 6
    .line 7
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 8
    move-result-object v0

    .line 9
    .line 10
    sput-object v0, Lorg/bitspark/android/SpkApplication;->b:Ljava/lang/String;

    .line 11
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput-boolean v0, p0, Lorg/bitspark/android/SpkApplication;->a:Z

    .line 6
    .line 7
    return-void
.end method


# virtual methods
.method public final native attachBaseContext(Landroid/content/Context;)V
.end method

.method public final native onCreate()V
.end method
