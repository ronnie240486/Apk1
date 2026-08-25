.class public Lcom/tvbus/engine/TVService;
.super Landroid/app/Service;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tvbus/engine/TVService$TVServer;
    }
.end annotation


# static fields
.field static final TAG:Ljava/lang/String; = "TVBusService"

.field public static bInited:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x11

    invoke-static {v0}, Lcom/nmmedit/protect/NativeUtil;->classesInit0(I)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
.end method


# virtual methods
.method public native onBind(Landroid/content/Intent;)Landroid/os/IBinder;
.end method

.method public native onCreate()V
.end method

.method public native onDestroy()V
.end method

.method public native onStartCommand(Landroid/content/Intent;II)I
.end method
