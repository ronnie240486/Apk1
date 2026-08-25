.class public final enum Lorg/bitspark/android/Constants$VIDEO_TYPE;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/bitspark/android/Constants$VIDEO_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/bitspark/android/Constants$VIDEO_TYPE;

.field public static final enum BSLIVE:Lorg/bitspark/android/Constants$VIDEO_TYPE;

.field public static final enum BSPALYBACK:Lorg/bitspark/android/Constants$VIDEO_TYPE;

.field public static final enum BSVOD:Lorg/bitspark/android/Constants$VIDEO_TYPE;

.field public static final enum STATIC:Lorg/bitspark/android/Constants$VIDEO_TYPE;


# direct methods
.method private static synthetic $values()[Lorg/bitspark/android/Constants$VIDEO_TYPE;
    .locals 3

    .line 1
    const/4 v0, 0x4

    .line 2
    new-array v0, v0, [Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 3
    .line 4
    sget-object v1, Lorg/bitspark/android/Constants$VIDEO_TYPE;->BSLIVE:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 5
    .line 6
    const/4 v2, 0x0

    .line 7
    aput-object v1, v0, v2

    .line 8
    .line 9
    sget-object v1, Lorg/bitspark/android/Constants$VIDEO_TYPE;->BSPALYBACK:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 10
    .line 11
    const/4 v2, 0x1

    .line 12
    aput-object v1, v0, v2

    .line 13
    .line 14
    sget-object v1, Lorg/bitspark/android/Constants$VIDEO_TYPE;->BSVOD:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 15
    .line 16
    const/4 v2, 0x2

    .line 17
    aput-object v1, v0, v2

    .line 18
    .line 19
    sget-object v1, Lorg/bitspark/android/Constants$VIDEO_TYPE;->STATIC:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 20
    .line 21
    const/4 v2, 0x3

    .line 22
    aput-object v1, v0, v2

    .line 23
    .line 24
    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 3

    const/16 v0, 0x36

    invoke-static {v0}, Lcom/nmmedit/protect/NativeUtil;->classesInit0(I)V

    .line 1
    .line 2
    new-instance v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 3
    .line 4
    const-string v1, "BDwf3UUN\n"

    .line 5
    .line 6
    const-string v2, "Rm9TlBNIJoo=\n"

    .line 7
    .line 8
    .line 9
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 10
    move-result-object v1

    .line 11
    const/4 v2, 0x0

    .line 12
    .line 13
    .line 14
    invoke-direct {v0, v1, v2}, Lorg/bitspark/android/Constants$VIDEO_TYPE;-><init>(Ljava/lang/String;I)V

    .line 15
    .line 16
    sput-object v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;->BSLIVE:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 17
    .line 18
    new-instance v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 19
    .line 20
    const-string v1, "h3vEQ5yS9h6GYw==\n"

    .line 21
    .line 22
    const-string v2, "xSiUAtDLtF8=\n"

    .line 23
    .line 24
    .line 25
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 26
    move-result-object v1

    .line 27
    const/4 v2, 0x1

    .line 28
    .line 29
    .line 30
    invoke-direct {v0, v1, v2}, Lorg/bitspark/android/Constants$VIDEO_TYPE;-><init>(Ljava/lang/String;I)V

    .line 31
    .line 32
    sput-object v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;->BSPALYBACK:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 33
    .line 34
    new-instance v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 35
    .line 36
    const-string v1, "seqph0I=\n"

    .line 37
    .line 38
    const-string v2, "87n/yAaOJVY=\n"

    .line 39
    .line 40
    .line 41
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 42
    move-result-object v1

    .line 43
    const/4 v2, 0x2

    .line 44
    .line 45
    .line 46
    invoke-direct {v0, v1, v2}, Lorg/bitspark/android/Constants$VIDEO_TYPE;-><init>(Ljava/lang/String;I)V

    .line 47
    .line 48
    sput-object v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;->BSVOD:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 49
    .line 50
    new-instance v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 51
    .line 52
    const-string v1, "gQsMcbqB\n"

    .line 53
    .line 54
    const-string v2, "0l9NJfPCi8M=\n"

    .line 55
    .line 56
    .line 57
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 58
    move-result-object v1

    .line 59
    const/4 v2, 0x3

    .line 60
    .line 61
    .line 62
    invoke-direct {v0, v1, v2}, Lorg/bitspark/android/Constants$VIDEO_TYPE;-><init>(Ljava/lang/String;I)V

    .line 63
    .line 64
    sput-object v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;->STATIC:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 65
    .line 66
    .line 67
    invoke-static {}, Lorg/bitspark/android/Constants$VIDEO_TYPE;->$values()[Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 68
    move-result-object v0

    .line 69
    .line 70
    sput-object v0, Lorg/bitspark/android/Constants$VIDEO_TYPE;->$VALUES:[Lorg/bitspark/android/Constants$VIDEO_TYPE;

    .line 71
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 2
    .line 3
    .line 4
    return-void
.end method

.method public static native valueOf(Ljava/lang/String;)Lorg/bitspark/android/Constants$VIDEO_TYPE;
.end method

.method public static native values()[Lorg/bitspark/android/Constants$VIDEO_TYPE;
.end method
