.class Lcom/tvbus/engine/TVService$TVServer;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tvbus/engine/TVService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "TVServer"
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "TVBusServer"


# instance fields
.field final synthetic this$0:Lcom/tvbus/engine/TVService;

.field tvcore:Lcom/tvbus/engine/TVCore;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x2e

    invoke-static {v0}, Lcom/nmmedit/protect/NativeUtil;->classesInit0(I)V

    return-void
.end method

.method private constructor <init>(Lcom/tvbus/engine/TVService;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/tvbus/engine/TVService$TVServer;->this$0:Lcom/tvbus/engine/TVService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    invoke-static {}, Lcom/tvbus/engine/TVCore;->getInstance()Lcom/tvbus/engine/TVCore;

    move-result-object p1

    iput-object p1, p0, Lcom/tvbus/engine/TVService$TVServer;->tvcore:Lcom/tvbus/engine/TVCore;

    return-void
.end method

.method public synthetic constructor <init>(Lcom/tvbus/engine/TVService;Lcom/tvbus/engine/TVService$1;)V
    .locals 0

    .line 3
    invoke-direct {p0, p1}, Lcom/tvbus/engine/TVService$TVServer;-><init>(Lcom/tvbus/engine/TVService;)V

    return-void
.end method


# virtual methods
.method public native run()V
.end method
