.class Lorg/bitspark/android/MacActivation$Poller$1;
.super Ljava/lang/Object;
.source "MacActivation.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/bitspark/android/MacActivation$Poller;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/bitspark/android/MacActivation$Poller;

.field final synthetic val$playlist:Ljava/lang/String;


# direct methods
.method constructor <init>(Lorg/bitspark/android/MacActivation$Poller;Ljava/lang/String;)V
    .registers 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010,
            0x1010
        }
        names = {
            null,
            null
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 51
    iput-object p1, p0, Lorg/bitspark/android/MacActivation$Poller$1;->this$0:Lorg/bitspark/android/MacActivation$Poller;

    iput-object p2, p0, Lorg/bitspark/android/MacActivation$Poller$1;->val$playlist:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .line 53
    iget-object v0, p0, Lorg/bitspark/android/MacActivation$Poller$1;->this$0:Lorg/bitspark/android/MacActivation$Poller;

    # getter for: Lorg/bitspark/android/MacActivation$Poller;->spark:Lorg/bitspark/android/Spark;
    invoke-static {v0}, Lorg/bitspark/android/MacActivation$Poller;->access$100(Lorg/bitspark/android/MacActivation$Poller;)Lorg/bitspark/android/Spark;

    move-result-object v0

    iget-object v1, p0, Lorg/bitspark/android/MacActivation$Poller$1;->val$playlist:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->G(Lorg/bitspark/android/Spark;Ljava/lang/String;)V

    .line 54
    iget-object v0, p0, Lorg/bitspark/android/MacActivation$Poller$1;->this$0:Lorg/bitspark/android/MacActivation$Poller;

    # getter for: Lorg/bitspark/android/MacActivation$Poller;->spark:Lorg/bitspark/android/Spark;
    invoke-static {v0}, Lorg/bitspark/android/MacActivation$Poller;->access$100(Lorg/bitspark/android/MacActivation$Poller;)Lorg/bitspark/android/Spark;

    move-result-object v0

    iget-object v1, p0, Lorg/bitspark/android/MacActivation$Poller$1;->val$playlist:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->H(Lorg/bitspark/android/Spark;Ljava/lang/String;)V

    .line 55
    return-void
.end method
