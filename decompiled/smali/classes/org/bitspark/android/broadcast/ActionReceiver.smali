.class public Lorg/bitspark/android/broadcast/ActionReceiver;
.super Landroid/content/BroadcastReceiver;


# static fields
.field public static final a:Ljava/lang/String;

.field public static final b:Ljava/lang/String;

.field public static final c:Ljava/lang/String;

.field public static final d:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/16 v0, 0x30

    invoke-static {v0}, Lcom/nmmedit/protect/NativeUtil;->classesInit0(I)V

    .line 1
    .line 2
    const-string v0, "rw+MKb56WX2OKqs4\n"

    .line 3
    .line 4
    const-string v1, "7VzOSt8JLS8=\n"

    .line 5
    .line 6
    .line 7
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 8
    move-result-object v0

    .line 9
    .line 10
    sput-object v0, Lorg/bitspark/android/broadcast/ActionReceiver;->a:Ljava/lang/String;

    .line 11
    .line 12
    const-string v0, "vDU1Q2fbomm0NSVUZsboJr4vOF5mnIQIkg8Ockf/lguYDxR1\n"

    .line 13
    .line 14
    const-string v1, "3VtRMQiyxkc=\n"

    .line 15
    .line 16
    .line 17
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 18
    move-result-object v0

    .line 19
    .line 20
    sput-object v0, Lorg/bitspark/android/broadcast/ActionReceiver;->b:Ljava/lang/String;

    .line 21
    .line 22
    const-string v0, "w7eBeyf8ZHTLt5FsJuEuO8GtjGYmu1QT75y6Wg3B\n"

    .line 23
    .line 24
    const-string v1, "otnlCUiVAFo=\n"

    .line 25
    .line 26
    .line 27
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 28
    move-result-object v0

    .line 29
    .line 30
    sput-object v0, Lorg/bitspark/android/broadcast/ActionReceiver;->c:Ljava/lang/String;

    .line 31
    .line 32
    const-string v0, "FCq1NM2tWKkcKqUjzLAS5hYwuCnM6m/EJwGUCP2LesE=\n"

    .line 33
    .line 34
    const-string v1, "dUTRRqLEPIc=\n"

    .line 35
    .line 36
    .line 37
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 38
    .line 39
    const-string v0, "/h16qBKSUZLxFmr0HpRb0rEwUZQzvnbo1iVXjiSkdvTePVmf\n"

    .line 40
    .line 41
    const-string v1, "n3Me2n37Nbw=\n"

    .line 42
    .line 43
    .line 44
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 45
    move-result-object v0

    .line 46
    .line 47
    sput-object v0, Lorg/bitspark/android/broadcast/ActionReceiver;->d:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
.end method


# virtual methods
.method public final native onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end method
