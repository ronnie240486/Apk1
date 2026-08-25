.class public final Lorg/bitspark/android/MacId;
.super Ljava/lang/Object;
.source "MacId.java"

.method private constructor <init>()V
    .locals 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static get12(Landroid/content/Context;)Ljava/lang/String;
    .locals 6

    # Prefer the Wi-Fi MAC when the platform exposes it.
    :try_start_wifi
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "wifi"
    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/net/wifi/WifiManager;
    if-eqz v0, :try_end_wifi
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;
    move-result-object v0
    if-eqz v0, :try_end_wifi
    invoke-virtual {v0}, Landroid/net/wifi/WifiInfo;->getMacAddress()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, :try_end_wifi
    const-string v1, ":"
    const-string v2, ""
    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "-"
    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;
    invoke-virtual {v0, v1}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "020000000000"
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, :try_end_wifi
    invoke-virtual {v0}, Ljava/lang/String;->length()I
    move-result v1
    const/16 v2, 0xc
    if-ne v1, v2, :try_end_wifi
    return-object v0
    :try_end_wifi
    .catch Ljava/lang/Throwable; {:try_start_wifi .. :try_end_wifi} :fallback

    :fallback
    # Android 6+ may hide the hardware MAC; use the stable Android ID then.
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v0
    const-string v1, "android_id"
    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, :default_id
    const-string v1, "-"
    const-string v2, ""
    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v0
    const-string v1, ":"
    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;
    invoke-virtual {v0, v1}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual {v0}, Ljava/lang/String;->length()I
    move-result v1
    const/16 v2, 0xc
    if-lt v1, v2, :pad_id
    const/4 v1, 0x0
    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    move-result-object v0
    return-object v0

    :pad_id
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    :pad_loop
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I
    move-result v3
    if-lt v3, v2, :pad_append
    goto :pad_done
    :pad_append
    const-string v4, "0"
    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto :pad_loop
    :pad_done
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0

    :default_id
    const-string v0, "000000000000"
    return-object v0
.end method

.method public static getDisplay(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    invoke-static {p0}, Lorg/bitspark/android/MacId;->get12(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const/16 v2, 0x11
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V
    const/4 v2, 0x0
    :display_loop
    const/16 v3, 0xc
    if-ge v2, v3, :display_done
    if-lez v2, :display_no_separator
    rem-int/lit8 v3, v2, 0x2
    if-nez v3, :display_no_separator
    const-string v3, ":"
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :display_no_separator
    invoke-virtual {v0, v2}, Ljava/lang/String;->charAt(I)C
    move-result v3
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    add-int/lit8 v2, v2, 0x1
    goto :display_loop
    :display_done
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
