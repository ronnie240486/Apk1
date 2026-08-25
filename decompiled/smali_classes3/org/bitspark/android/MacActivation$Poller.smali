.class final Lorg/bitspark/android/MacActivation$Poller;
.super Ljava/lang/Object;
.source "MacActivation.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/bitspark/android/MacActivation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Poller"
.end annotation


# instance fields
.field private final mac:Ljava/lang/String;

.field private final spark:Lorg/bitspark/android/Spark;


# direct methods
.method constructor <init>(Lorg/bitspark/android/Spark;Ljava/lang/String;)V
    .registers 3

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lorg/bitspark/android/MacActivation$Poller;->spark:Lorg/bitspark/android/Spark;

    .line 43
    iput-object p2, p0, Lorg/bitspark/android/MacActivation$Poller;->mac:Ljava/lang/String;

    .line 44
    return-void
.end method

.method static synthetic access$100(Lorg/bitspark/android/MacActivation$Poller;)Lorg/bitspark/android/Spark;
    .registers 1

    .line 37
    iget-object p0, p0, Lorg/bitspark/android/MacActivation$Poller;->spark:Lorg/bitspark/android/Spark;

    return-object p0
.end method

.method private authorizedPlaylist()Ljava/lang/String;
    .registers 6

    .line 69
    nop

    .line 71
    const/4 v0, 0x0

    :try_start_2
    iget-object v1, p0, Lorg/bitspark/android/MacActivation$Poller;->mac:Ljava/lang/String;

    const-string v2, "UTF-8"

    invoke-static {v1, v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 72
    new-instance v2, Ljava/net/URL;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://renciaapp.manus.space/api/v5/apps/prestige/config?mac="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 74
    invoke-virtual {v2}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v1

    check-cast v1, Ljava/net/HttpURLConnection;
    :try_end_28
    .catchall {:try_start_2 .. :try_end_28} :catchall_87

    .line 75
    :try_start_28
    const-string v2, "GET"

    invoke-virtual {v1, v2}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 76
    const/16 v2, 0x1f40

    invoke-virtual {v1, v2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 77
    const/16 v2, 0x2ee0

    invoke-virtual {v1, v2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 78
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 79
    const-string v2, "Accept"

    const-string v3, "application/json"

    invoke-virtual {v1, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const-string v2, "Cache-Control"

    const-string v3, "no-cache, no-store"

    invoke-virtual {v1, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    .line 82
    const/16 v3, 0xc8

    if-lt v2, v3, :cond_7f

    const/16 v3, 0x12c

    if-lt v2, v3, :cond_56

    goto :goto_7f

    .line 83
    :cond_56
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    # invokes: Lorg/bitspark/android/MacActivation;->read(Ljava/io/InputStream;)Ljava/lang/String;
    invoke-static {v2}, Lorg/bitspark/android/MacActivation;->access$200(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v2

    .line 84
    const-string v3, "registered"

    # invokes: Lorg/bitspark/android/MacActivation;->readBoolean(Ljava/lang/String;Ljava/lang/String;)Z
    invoke-static {v2, v3}, Lorg/bitspark/android/MacActivation;->access$300(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_79

    const-string v3, "allowed"

    # invokes: Lorg/bitspark/android/MacActivation;->readBoolean(Ljava/lang/String;Ljava/lang/String;)Z
    invoke-static {v2, v3}, Lorg/bitspark/android/MacActivation;->access$300(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_6f

    goto :goto_79

    .line 85
    :cond_6f
    # invokes: Lorg/bitspark/android/MacActivation;->firstPlaylist(Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v2}, Lorg/bitspark/android/MacActivation;->access$400(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0
    :try_end_73
    .catchall {:try_start_28 .. :try_end_73} :catchall_85

    .line 89
    if-eqz v1, :cond_78

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 85
    :cond_78
    return-object v0

    .line 89
    :cond_79
    :goto_79
    if-eqz v1, :cond_7e

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 84
    :cond_7e
    return-object v0

    .line 89
    :cond_7f
    :goto_7f
    if-eqz v1, :cond_84

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 82
    :cond_84
    return-object v0

    .line 86
    :catchall_85
    move-exception v2

    goto :goto_89

    :catchall_87
    move-exception v1

    move-object v1, v0

    .line 87
    :goto_89
    nop

    .line 89
    if-eqz v1, :cond_8f

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 87
    :cond_8f
    return-object v0
.end method


# virtual methods
.method public run()V
    .registers 4

    .line 47
    nop

    :goto_1
    # getter for: Lorg/bitspark/android/MacActivation;->running:Z
    invoke-static {}, Lorg/bitspark/android/MacActivation;->access$000()Z

    move-result v0

    if-eqz v0, :cond_32

    .line 48
    invoke-direct {p0}, Lorg/bitspark/android/MacActivation$Poller;->authorizedPlaylist()Ljava/lang/String;

    move-result-object v0

    .line 49
    if-eqz v0, :cond_22

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_22

    .line 50
    const/4 v1, 0x0

    # setter for: Lorg/bitspark/android/MacActivation;->running:Z
    invoke-static {v1}, Lorg/bitspark/android/MacActivation;->access$002(Z)Z

    .line 51
    iget-object v1, p0, Lorg/bitspark/android/MacActivation$Poller;->spark:Lorg/bitspark/android/Spark;

    new-instance v2, Lorg/bitspark/android/MacActivation$Poller$1;

    invoke-direct {v2, p0, v0}, Lorg/bitspark/android/MacActivation$Poller$1;-><init>(Lorg/bitspark/android/MacActivation$Poller;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lorg/bitspark/android/Spark;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 57
    return-void

    .line 60
    :cond_22
    const-wide/16 v0, 0x1388

    :try_start_24
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_27
    .catch Ljava/lang/InterruptedException; {:try_start_24 .. :try_end_27} :catch_29

    .line 64
    nop

    .line 65
    goto :goto_1

    .line 61
    :catch_29
    move-exception v0

    .line 62
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 63
    return-void

    .line 66
    :cond_32
    return-void
.end method
