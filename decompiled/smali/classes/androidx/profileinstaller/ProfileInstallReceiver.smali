.class public Landroidx/profileinstaller/ProfileInstallReceiver;
.super Landroid/content/BroadcastReceiver;
.source "MyApplication"


# direct methods
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
.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5

    .line 1
    if-nez p2, :cond_0

    .line 2
    .line 3
    return-void

    .line 4
    :cond_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    const-string v1, "androidx.profileinstaller.action.INSTALL_PROFILE"

    .line 9
    .line 10
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 11
    .line 12
    .line 13
    move-result v1

    .line 14
    if-eqz v1, :cond_1

    .line 15
    .line 16
    new-instance p2, Landroidx/media3/exoplayer/hls/offline/a;

    .line 17
    .line 18
    invoke-direct {p2}, Ljava/lang/Object;-><init>()V

    .line 19
    .line 20
    .line 21
    new-instance v0, Lr4/n;

    .line 22
    .line 23
    const/4 v1, 0x3

    .line 24
    invoke-direct {v0, v1, p0}, Lr4/n;-><init>(ILjava/lang/Object;)V

    .line 25
    .line 26
    .line 27
    const/4 v1, 0x1

    .line 28
    invoke-static {p1, p2, v0, v1}, Lt1/d;->s(Landroid/content/Context;Ljava/util/concurrent/Executor;Lt1/c;Z)V

    .line 29
    .line 30
    .line 31
    goto/16 :goto_1

    .line 32
    .line 33
    :cond_1
    const-string v1, "androidx.profileinstaller.action.SKIP_FILE"

    .line 34
    .line 35
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 36
    .line 37
    .line 38
    move-result v1

    .line 39
    const/16 v2, 0xa

    .line 40
    .line 41
    const/4 v3, 0x0

    .line 42
    if-eqz v1, :cond_3

    .line 43
    .line 44
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    .line 45
    .line 46
    .line 47
    move-result-object p2

    .line 48
    if-eqz p2, :cond_a

    .line 49
    .line 50
    const-string v0, "EXTRA_SKIP_FILE_OPERATION"

    .line 51
    .line 52
    invoke-virtual {p2, v0}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    .line 53
    .line 54
    .line 55
    move-result-object p2

    .line 56
    const-string v0, "WRITE_SKIP_FILE"

    .line 57
    .line 58
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 59
    .line 60
    .line 61
    move-result v0

    .line 62
    if-eqz v0, :cond_2

    .line 63
    .line 64
    new-instance p2, Lr4/n;

    .line 65
    .line 66
    const/4 v0, 0x3

    .line 67
    invoke-direct {p2, v0, p0}, Lr4/n;-><init>(ILjava/lang/Object;)V

    .line 68
    .line 69
    .line 70
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    .line 71
    .line 72
    .line 73
    move-result-object v0

    .line 74
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 79
    .line 80
    .line 81
    move-result-object v1

    .line 82
    const/4 v4, 0x0

    .line 83
    :try_start_0
    invoke-virtual {v1, v0, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    .line 84
    .line 85
    .line 86
    move-result-object v0
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    .line 88
    .line 89
    .line 90
    move-result-object p1

    .line 91
    invoke-static {v0, p1}, Lt1/d;->e(Landroid/content/pm/PackageInfo;Ljava/io/File;)V

    .line 92
    .line 93
    .line 94
    invoke-virtual {p2, v2, v3}, Lr4/n;->b(ILjava/io/Serializable;)V

    .line 95
    .line 96
    .line 97
    goto/16 :goto_1

    .line 98
    .line 99
    :catch_0
    move-exception p1

    .line 100
    const/4 v0, 0x7

    .line 101
    invoke-virtual {p2, v0, p1}, Lr4/n;->b(ILjava/io/Serializable;)V

    .line 102
    .line 103
    .line 104
    goto/16 :goto_1

    .line 105
    .line 106
    :cond_2
    const-string v0, "DELETE_SKIP_FILE"

    .line 107
    .line 108
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 109
    .line 110
    .line 111
    move-result p2

    .line 112
    if-eqz p2, :cond_a

    .line 113
    .line 114
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    .line 115
    .line 116
    .line 117
    move-result-object p1

    .line 118
    new-instance p2, Ljava/io/File;

    .line 119
    .line 120
    const-string v0, "profileinstaller_profileWrittenFor_lastUpdateTime.dat"

    .line 121
    .line 122
    invoke-direct {p2, p1, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 123
    .line 124
    .line 125
    invoke-virtual {p2}, Ljava/io/File;->delete()Z

    .line 126
    .line 127
    .line 128
    const-string p1, "ProfileInstaller"

    .line 129
    .line 130
    const-string p2, "RESULT_DELETE_SKIP_FILE_SUCCESS"

    .line 131
    .line 132
    invoke-static {p1, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 133
    .line 134
    .line 135
    const/16 p1, 0xb

    .line 136
    .line 137
    invoke-virtual {p0, p1}, Landroid/content/BroadcastReceiver;->setResultCode(I)V

    .line 138
    .line 139
    .line 140
    goto/16 :goto_1

    .line 141
    .line 142
    :cond_3
    const-string v1, "androidx.profileinstaller.action.SAVE_PROFILE"

    .line 143
    .line 144
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 145
    .line 146
    .line 147
    move-result v1

    .line 148
    const/16 v4, 0x18

    .line 149
    .line 150
    if-eqz v1, :cond_5

    .line 151
    .line 152
    new-instance p1, Lr4/n;

    .line 153
    .line 154
    const/4 p2, 0x3

    .line 155
    invoke-direct {p1, p2, p0}, Lr4/n;-><init>(ILjava/lang/Object;)V

    .line 156
    .line 157
    .line 158
    sget p2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 159
    .line 160
    if-lt p2, v4, :cond_4

    .line 161
    .line 162
    invoke-static {}, Landroid/os/Process;->myPid()I

    .line 163
    .line 164
    .line 165
    move-result p2

    .line 166
    invoke-static {p2, v2}, Landroid/os/Process;->sendSignal(II)V

    .line 167
    .line 168
    .line 169
    const/16 p2, 0xc

    .line 170
    .line 171
    invoke-virtual {p1, p2, v3}, Lr4/n;->b(ILjava/io/Serializable;)V

    .line 172
    .line 173
    .line 174
    goto :goto_1

    .line 175
    :cond_4
    const/16 p2, 0xd

    .line 176
    .line 177
    invoke-virtual {p1, p2, v3}, Lr4/n;->b(ILjava/io/Serializable;)V

    .line 178
    .line 179
    .line 180
    goto :goto_1

    .line 181
    :cond_5
    const-string v1, "androidx.profileinstaller.action.BENCHMARK_OPERATION"

    .line 182
    .line 183
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 184
    .line 185
    .line 186
    move-result v0

    .line 187
    if-eqz v0, :cond_a

    .line 188
    .line 189
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    .line 190
    .line 191
    .line 192
    move-result-object p2

    .line 193
    if-eqz p2, :cond_a

    .line 194
    .line 195
    const-string v0, "EXTRA_BENCHMARK_OPERATION"

    .line 196
    .line 197
    invoke-virtual {p2, v0}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    .line 198
    .line 199
    .line 200
    move-result-object p2

    .line 201
    new-instance v0, Lr4/n;

    .line 202
    .line 203
    const/4 v1, 0x3

    .line 204
    invoke-direct {v0, v1, p0}, Lr4/n;-><init>(ILjava/lang/Object;)V

    .line 205
    .line 206
    .line 207
    const-string v1, "DROP_SHADER_CACHE"

    .line 208
    .line 209
    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 210
    .line 211
    .line 212
    move-result p2

    .line 213
    if-eqz p2, :cond_9

    .line 214
    .line 215
    sget p2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 216
    .line 217
    if-lt p2, v4, :cond_6

    .line 218
    .line 219
    invoke-static {p1}, Lk3/p;->b(Landroid/content/Context;)Landroid/content/Context;

    .line 220
    .line 221
    .line 222
    move-result-object p1

    .line 223
    invoke-virtual {p1}, Landroid/content/Context;->getCodeCacheDir()Ljava/io/File;

    .line 224
    .line 225
    .line 226
    move-result-object p1

    .line 227
    goto :goto_0

    .line 228
    :cond_6
    const/16 v1, 0x17

    .line 229
    .line 230
    if-lt p2, v1, :cond_7

    .line 231
    .line 232
    invoke-virtual {p1}, Landroid/content/Context;->getCodeCacheDir()Ljava/io/File;

    .line 233
    .line 234
    .line 235
    move-result-object p1

    .line 236
    goto :goto_0

    .line 237
    :cond_7
    invoke-virtual {p1}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    .line 238
    .line 239
    .line 240
    move-result-object p1

    .line 241
    :goto_0
    invoke-static {p1}, Lt1/d;->c(Ljava/io/File;)Z

    .line 242
    .line 243
    .line 244
    move-result p1

    .line 245
    if-eqz p1, :cond_8

    .line 246
    .line 247
    const/16 p1, 0xe

    .line 248
    .line 249
    invoke-virtual {v0, p1, v3}, Lr4/n;->b(ILjava/io/Serializable;)V

    .line 250
    .line 251
    .line 252
    goto :goto_1

    .line 253
    :cond_8
    const/16 p1, 0xf

    .line 254
    .line 255
    invoke-virtual {v0, p1, v3}, Lr4/n;->b(ILjava/io/Serializable;)V

    .line 256
    .line 257
    .line 258
    goto :goto_1

    .line 259
    :cond_9
    const/16 p1, 0x10

    .line 260
    .line 261
    invoke-virtual {v0, p1, v3}, Lr4/n;->b(ILjava/io/Serializable;)V

    .line 262
    .line 263
    .line 264
    :cond_a
    :goto_1
    return-void
.end method
