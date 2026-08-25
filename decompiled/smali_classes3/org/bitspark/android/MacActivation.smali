.class public final Lorg/bitspark/android/MacActivation;
.super Ljava/lang/Object;
.source "MacActivation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/bitspark/android/MacActivation$Poller;
    }
.end annotation


# static fields
.field private static final APP_ID:Ljava/lang/String; = "prestige"

.field private static final BASE_URL:Ljava/lang/String; = "https://renciaapp.manus.space"

.field private static final POLL_MS:J = 0x1388L

.field private static volatile running:Z

.field private static volatile worker:Ljava/lang/Thread;


# direct methods
.method private constructor <init>()V
    .registers 1

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Z
    .registers 1

    .line 14
    sget-boolean v0, Lorg/bitspark/android/MacActivation;->running:Z

    return v0
.end method

.method static synthetic access$002(Z)Z
    .registers 1

    .line 14
    sput-boolean p0, Lorg/bitspark/android/MacActivation;->running:Z

    return p0
.end method

.method static synthetic access$200(Ljava/io/InputStream;)Ljava/lang/String;
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 14
    invoke-static {p0}, Lorg/bitspark/android/MacActivation;->read(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$300(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 2

    .line 14
    invoke-static {p0, p1}, Lorg/bitspark/android/MacActivation;->readBoolean(Ljava/lang/String;Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method static synthetic access$400(Ljava/lang/String;)Ljava/lang/String;
    .registers 1

    .line 14
    invoke-static {p0}, Lorg/bitspark/android/MacActivation;->firstPlaylist(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static firstPlaylist(Ljava/lang/String;)Ljava/lang/String;
    .registers 6

    .line 118
    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 119
    :cond_4
    const-string v1, "\"playlist_urls\""

    invoke-virtual {p0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 120
    const/4 v2, -0x1

    const/16 v3, 0x22

    if-ltz v1, :cond_2e

    .line 121
    const/16 v4, 0x5b

    invoke-virtual {p0, v4, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 122
    if-gez v1, :cond_19

    move v1, v2

    goto :goto_1f

    :cond_19
    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v3, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 123
    :goto_1f
    if-ltz v1, :cond_2e

    .line 124
    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v3, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v4

    .line 125
    if-le v4, v1, :cond_2e

    invoke-virtual {p0, v1, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 128
    :cond_2e
    const-string v1, "\"playlist_url\""

    invoke-virtual {p0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 129
    if-ltz v1, :cond_5a

    .line 130
    const/16 v4, 0x3a

    invoke-virtual {p0, v4, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 131
    if-gez v1, :cond_40

    move v1, v2

    goto :goto_46

    :cond_40
    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v3, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 132
    :goto_46
    if-gez v1, :cond_49

    goto :goto_4f

    :cond_49
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {p0, v3, v2}, Ljava/lang/String;->indexOf(II)I

    move-result v2

    .line 133
    :goto_4f
    if-ltz v1, :cond_5a

    add-int/lit8 v1, v1, 0x1

    if-le v2, v1, :cond_5a

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 135
    :cond_5a
    return-object v0
.end method

.method private static read(Ljava/io/InputStream;)Ljava/lang/String;
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 95
    if-nez p0, :cond_5

    const-string p0, ""

    return-object p0

    .line 96
    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 97
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v2, Ljava/io/InputStreamReader;

    sget-object v3, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v2, p0, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    invoke-direct {v1, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 100
    :goto_16
    :try_start_16
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_20

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_1f
    .catchall {:try_start_16 .. :try_end_1f} :catchall_28

    goto :goto_16

    .line 101
    :cond_20
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V

    .line 102
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 97
    :catchall_28
    move-exception p0

    :try_start_29
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_2c
    .catchall {:try_start_29 .. :try_end_2c} :catchall_2d

    goto :goto_31

    :catchall_2d
    move-exception v0

    invoke-virtual {p0, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :goto_31
    throw p0
.end method

.method private static readBoolean(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 8

    .line 106
    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    .line 107
    :cond_4
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 108
    invoke-virtual {p0, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 109
    if-gez v1, :cond_22

    return v0

    .line 110
    :cond_22
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result p1

    add-int/2addr v1, p1

    const/16 p1, 0x3a

    invoke-virtual {p0, p1, v1}, Ljava/lang/String;->indexOf(II)I

    move-result p1

    .line 111
    if-gez p1, :cond_30

    return v0

    .line 112
    :cond_30
    add-int/lit8 p1, p1, 0x1

    move v2, p1

    .line 113
    :goto_33
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result p1

    if-ge v2, p1, :cond_46

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result p1

    invoke-static {p1}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result p1

    if-eqz p1, :cond_46

    add-int/lit8 v2, v2, 0x1

    goto :goto_33

    .line 114
    :cond_46
    const/4 v4, 0x0

    const/4 v5, 0x4

    const/4 v1, 0x1

    const-string v3, "true"

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result p0

    return p0
.end method

.method public static declared-synchronized start(Landroid/content/Context;Lorg/bitspark/android/Spark;Ljava/lang/String;)V
    .registers 6

    const-class v0, Lorg/bitspark/android/MacActivation;

    monitor-enter v0

    .line 24
    if-eqz p0, :cond_3e

    if-eqz p1, :cond_3e

    if-eqz p2, :cond_3e

    :try_start_9
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result p0

    if-nez p0, :cond_10

    goto :goto_3e

    .line 25
    :cond_10
    sget-object p0, Lorg/bitspark/android/MacActivation;->worker:Ljava/lang/Thread;

    if-eqz p0, :cond_1e

    sget-object p0, Lorg/bitspark/android/MacActivation;->worker:Ljava/lang/Thread;

    invoke-virtual {p0}, Ljava/lang/Thread;->isAlive()Z

    move-result p0
    :try_end_1a
    .catchall {:try_start_9 .. :try_end_1a} :catchall_3b

    if-eqz p0, :cond_1e

    monitor-exit v0

    return-void

    .line 26
    :cond_1e
    const/4 p0, 0x1

    :try_start_1f
    sput-boolean p0, Lorg/bitspark/android/MacActivation;->running:Z

    .line 27
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lorg/bitspark/android/MacActivation$Poller;

    invoke-direct {v2, p1, p2}, Lorg/bitspark/android/MacActivation$Poller;-><init>(Lorg/bitspark/android/Spark;Ljava/lang/String;)V

    const-string p1, "PrimeX-Prestige-Poll"

    invoke-direct {v1, v2, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    sput-object v1, Lorg/bitspark/android/MacActivation;->worker:Ljava/lang/Thread;

    .line 28
    sget-object p1, Lorg/bitspark/android/MacActivation;->worker:Ljava/lang/Thread;

    invoke-virtual {p1, p0}, Ljava/lang/Thread;->setDaemon(Z)V

    .line 29
    sget-object p0, Lorg/bitspark/android/MacActivation;->worker:Ljava/lang/Thread;

    invoke-virtual {p0}, Ljava/lang/Thread;->start()V
    :try_end_39
    .catchall {:try_start_1f .. :try_end_39} :catchall_3b

    .line 30
    monitor-exit v0

    return-void

    .line 23
    :catchall_3b
    move-exception p0

    :try_start_3c
    monitor-exit v0
    :try_end_3d
    .catchall {:try_start_3c .. :try_end_3d} :catchall_3b

    throw p0

    .line 24
    :cond_3e
    :goto_3e
    monitor-exit v0

    return-void
.end method

.method public static declared-synchronized stop()V
    .registers 2

    const-class v0, Lorg/bitspark/android/MacActivation;

    monitor-enter v0

    .line 33
    const/4 v1, 0x0

    :try_start_4
    sput-boolean v1, Lorg/bitspark/android/MacActivation;->running:Z

    .line 34
    const/4 v1, 0x0

    sput-object v1, Lorg/bitspark/android/MacActivation;->worker:Ljava/lang/Thread;
    :try_end_9
    .catchall {:try_start_4 .. :try_end_9} :catchall_b

    .line 35
    monitor-exit v0

    return-void

    .line 32
    :catchall_b
    move-exception v1

    :try_start_c
    monitor-exit v0
    :try_end_d
    .catchall {:try_start_c .. :try_end_d} :catchall_b

    throw v1
.end method
