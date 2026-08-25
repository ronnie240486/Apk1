.class public Lcom/tvbus/engine/TVCore;
.super Ljava/lang/Object;


# static fields
.field static final RM_CLIENT:I = 0x2

.field static final RM_MASTER:I = 0x1

.field static final RM_STANDALONE:I

.field private static inst:Lcom/tvbus/engine/TVCore;

.field private static nativeHandle:J


# instance fields
.field private mkBroker:Ljava/lang/String;

.field private tvListener:Lcom/tvbus/engine/TVListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x25

    invoke-static {v0}, Lcom/nmmedit/protect/NativeUtil;->classesInit0(I)V

    .line 1
    .line 2
    :try_start_0
    const-string v0, "tvcore"

    .line 3
    .line 4
    .line 5
    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 6
    :catchall_0
    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput-object v0, p0, Lcom/tvbus/engine/TVCore;->tvListener:Lcom/tvbus/engine/TVListener;

    .line 6
    .line 7
    iput-object v0, p0, Lcom/tvbus/engine/TVCore;->mkBroker:Ljava/lang/String;

    .line 8
    .line 9
    return-void
.end method

.method private native description(J)Ljava/lang/String;
.end method

.method private native diagnose(J)V
.end method

.method private native err2String(JI)Ljava/lang/String;
.end method

.method public static native declared-synchronized getInstance()Lcom/tvbus/engine/TVCore;
.end method

.method private native getVersion(J)Ljava/lang/String;
.end method

.method private native getVersion2(J)Ljava/lang/String;
.end method

.method private native init(JLandroid/content/Context;)I
.end method

.method private native initialise()J
.end method

.method private native quit(J)V
.end method

.method private native run(J)I
.end method

.method private native setAuthItems(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method private native setAuthUrl(JLjava/lang/String;)V
.end method

.method private native setDomainSuffix(JLjava/lang/String;)V
.end method

.method private native setListener(JLcom/tvbus/engine/TVListener;)V
.end method

.method private native setMKBroker(JLjava/lang/String;)V
.end method

.method private native setOption(JLjava/lang/String;Ljava/lang/String;)V
.end method

.method private native setPassword(JLjava/lang/String;)V
.end method

.method private native setPlayPort(JI)V
.end method

.method private native setRunningMode(JI)V
.end method

.method private native setServPort(JI)V
.end method

.method private native setUsername(JLjava/lang/String;)V
.end method

.method private native start(JLjava/lang/String;)V
.end method

.method private native start2(JLjava/lang/String;Ljava/lang/String;)V
.end method

.method private native stop(J)V
.end method

.method private native stop2(JI)V
.end method


# virtual methods
.method public native description()Ljava/lang/String;
.end method

.method public native diagnose()V
.end method

.method public native err2String(I)Ljava/lang/String;
.end method

.method public native getVersion()Ljava/lang/String;
.end method

.method public native getVersion(I)Ljava/lang/String;
.end method

.method public native init(Landroid/content/Context;)I
.end method

.method public native quit()V
.end method

.method public native run()I
.end method

.method public native setAuthItems(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public native setAuthUrl(Ljava/lang/String;)V
.end method

.method public native setDomainSuffix(Ljava/lang/String;)V
.end method

.method public native setMKBroker(Ljava/lang/String;)V
.end method

.method public native setOption(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public native setPassword(Ljava/lang/String;)V
.end method

.method public native setPlayPort(I)V
.end method

.method public native setRunningMode(I)V
.end method

.method public native setServPort(I)V
.end method

.method public native setTVListener(Lcom/tvbus/engine/TVListener;)V
.end method

.method public native setUsername(Ljava/lang/String;)V
.end method

.method public native start(Ljava/lang/String;)V
.end method

.method public native start(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public native stop()V
.end method

.method public native stop(I)V
.end method
