.class public final Lea/k;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Landroidx/lifecycle/e0;
.implements Lsa/f;
.implements Lfa/o0;
.implements Lcom/tvbus/engine/TVListener;


# instance fields
.field public final synthetic a:I

.field public final synthetic b:Lorg/bitspark/android/Spark;


# direct methods
.method public synthetic constructor <init>(Lorg/bitspark/android/Spark;I)V
    .locals 0

    .line 1
    iput p2, p0, Lea/k;->a:I

    .line 2
    .line 3
    iput-object p1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
.end method


# virtual methods
.method public a(ILandroid/view/View;)V
    .locals 7

    .line 1
    iget p2, p0, Lea/k;->a:I

    .line 2
    .line 3
    packed-switch p2, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    :pswitch_0
    iget-object p2, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 7
    .line 8
    iget-object v0, p2, Lorg/bitspark/android/Spark;->J1:Landroidx/media3/exoplayer/ExoPlayer;

    .line 9
    .line 10
    iget-object v1, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 11
    .line 12
    iget-object v1, v1, Lta/a;->y:Ljava/util/ArrayList;

    .line 13
    .line 14
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    check-cast v1, Lorg/bitspark/android/beans/SpeedBean;

    .line 19
    .line 20
    invoke-virtual {v1}, Lorg/bitspark/android/beans/SpeedBean;->getSpeed()F

    .line 21
    .line 22
    .line 23
    move-result v1

    .line 24
    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->setPlaybackSpeed(F)V

    .line 25
    .line 26
    .line 27
    iget-object v0, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 28
    .line 29
    iput p1, v0, Lta/a;->w:I

    .line 30
    .line 31
    iget-object p2, p2, Lorg/bitspark/android/Spark;->t0:Lfa/o1;

    .line 32
    .line 33
    iput p1, p2, Lfa/c;->e:I

    .line 34
    .line 35
    invoke-virtual {p2}, Landroidx/recyclerview/widget/k0;->notifyDataSetChanged()V

    .line 36
    .line 37
    .line 38
    return-void

    .line 39
    :pswitch_1
    iget-object p2, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 40
    .line 41
    iget-object v0, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 42
    .line 43
    iput p1, v0, Lta/a;->t:I

    .line 44
    .line 45
    iget-object v0, p2, Lorg/bitspark/android/Spark;->y0:Lfa/o1;

    .line 46
    .line 47
    iget-object v0, v0, Lfa/c;->h:Ljava/util/ArrayList;

    .line 48
    .line 49
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 50
    .line 51
    .line 52
    move-result v0

    .line 53
    add-int/lit8 v0, v0, -0x1

    .line 54
    .line 55
    if-ne p1, v0, :cond_0

    .line 56
    .line 57
    invoke-virtual {p2}, Lorg/bitspark/android/Spark;->U()V

    .line 58
    .line 59
    .line 60
    goto :goto_0

    .line 61
    :cond_0
    iget-object v0, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 62
    .line 63
    iget-object v0, v0, Lta/a;->B:Ljava/util/ArrayList;

    .line 64
    .line 65
    invoke-virtual {p2, p1, v0}, Lorg/bitspark/android/Spark;->r0(ILjava/util/ArrayList;)V

    .line 66
    .line 67
    .line 68
    :goto_0
    iget-object p2, p2, Lorg/bitspark/android/Spark;->y0:Lfa/o1;

    .line 69
    .line 70
    iput p1, p2, Lfa/c;->e:I

    .line 71
    .line 72
    invoke-virtual {p2}, Landroidx/recyclerview/widget/k0;->notifyDataSetChanged()V

    .line 73
    .line 74
    .line 75
    return-void

    .line 76
    :pswitch_2
    iget-object p2, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 77
    .line 78
    if-ltz p1, :cond_6

    .line 79
    .line 80
    iget-object v0, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 81
    .line 82
    iget-object v0, v0, Lta/a;->D:Ljava/util/ArrayList;

    .line 83
    .line 84
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 85
    .line 86
    .line 87
    move-result v0

    .line 88
    if-lt p1, v0, :cond_1

    .line 89
    .line 90
    goto :goto_3

    .line 91
    :cond_1
    iget-object v0, p2, Lorg/bitspark/android/Spark;->O1:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;

    .line 92
    .line 93
    invoke-virtual {v0}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->getCurrentMappedTrackInfo()Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;

    .line 94
    .line 95
    .line 96
    move-result-object v0

    .line 97
    iget-object v1, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 98
    .line 99
    iget-object v1, v1, Lta/a;->D:Ljava/util/ArrayList;

    .line 100
    .line 101
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 102
    .line 103
    .line 104
    move-result-object v1

    .line 105
    check-cast v1, Lorg/bitspark/android/beans/SubtitleMenu;

    .line 106
    .line 107
    iget-object v2, p2, Lorg/bitspark/android/Spark;->O1:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;

    .line 108
    .line 109
    invoke-virtual {v2}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->getCurrentMappedTrackInfo()Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;

    .line 110
    .line 111
    .line 112
    move-result-object v2

    .line 113
    const/4 v3, -0x1

    .line 114
    if-nez v2, :cond_3

    .line 115
    .line 116
    :cond_2
    const/4 v4, -0x1

    .line 117
    goto :goto_2

    .line 118
    :cond_3
    const/4 v4, 0x0

    .line 119
    :goto_1
    invoke-virtual {v2}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    .line 120
    .line 121
    .line 122
    move-result v5

    .line 123
    if-ge v4, v5, :cond_2

    .line 124
    .line 125
    invoke-virtual {v2, v4}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    .line 126
    .line 127
    .line 128
    move-result v5

    .line 129
    const/4 v6, 0x1

    .line 130
    if-ne v5, v6, :cond_4

    .line 131
    .line 132
    invoke-virtual {v2, v4}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    .line 133
    .line 134
    .line 135
    move-result-object v5

    .line 136
    if-eqz v5, :cond_4

    .line 137
    .line 138
    iget v5, v5, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    .line 139
    .line 140
    if-lez v5, :cond_4

    .line 141
    .line 142
    goto :goto_2

    .line 143
    :cond_4
    add-int/lit8 v4, v4, 0x1

    .line 144
    .line 145
    goto :goto_1

    .line 146
    :goto_2
    if-ne v4, v3, :cond_5

    .line 147
    .line 148
    goto :goto_3

    .line 149
    :cond_5
    invoke-virtual {v0, v4}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    .line 150
    .line 151
    .line 152
    move-result-object v0

    .line 153
    iget-object v2, p2, Lorg/bitspark/android/Spark;->O1:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;

    .line 154
    .line 155
    invoke-virtual {v2}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->buildUponParameters()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;

    .line 156
    .line 157
    .line 158
    move-result-object v3

    .line 159
    new-instance v5, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;

    .line 160
    .line 161
    invoke-virtual {v1}, Lorg/bitspark/android/beans/SubtitleMenu;->getGroupIndex()I

    .line 162
    .line 163
    .line 164
    move-result v6

    .line 165
    invoke-virtual {v1}, Lorg/bitspark/android/beans/SubtitleMenu;->getTrackIndex()I

    .line 166
    .line 167
    .line 168
    move-result v1

    .line 169
    filled-new-array {v1}, [I

    .line 170
    .line 171
    .line 172
    move-result-object v1

    .line 173
    invoke-direct {v5, v6, v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;-><init>(I[I)V

    .line 174
    .line 175
    .line 176
    invoke-virtual {v3, v4, v0, v5}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;->setSelectionOverride(ILandroidx/media3/exoplayer/source/TrackGroupArray;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;)Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;

    .line 177
    .line 178
    .line 179
    move-result-object v0

    .line 180
    invoke-virtual {v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;->build()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    .line 181
    .line 182
    .line 183
    move-result-object v0

    .line 184
    invoke-virtual {v2, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->setParameters(Landroidx/media3/common/TrackSelectionParameters;)V

    .line 185
    .line 186
    .line 187
    goto :goto_3

    .line 188
    :cond_6
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 189
    .line 190
    .line 191
    :goto_3
    iget-object v0, p2, Lorg/bitspark/android/Spark;->x0:Lfa/o1;

    .line 192
    .line 193
    iput p1, v0, Lfa/c;->e:I

    .line 194
    .line 195
    invoke-virtual {v0}, Landroidx/recyclerview/widget/k0;->notifyDataSetChanged()V

    .line 196
    .line 197
    .line 198
    iget-object p2, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 199
    .line 200
    iput p1, p2, Lta/a;->u:I

    .line 201
    .line 202
    return-void

    .line 203
    :pswitch_3
    iget-object p2, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 204
    .line 205
    iget-object p2, p2, Lorg/bitspark/android/Spark;->B0:Landroidx/leanback/widget/HorizontalGridView;

    .line 206
    .line 207
    invoke-static {p2, p1}, Lo9/d;->z(Landroidx/recyclerview/widget/RecyclerView;I)V

    .line 208
    .line 209
    .line 210
    return-void

    .line 211
    :pswitch_data_0
    .packed-switch 0xa
        :pswitch_3
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public b()V
    .locals 2

    .line 1
    const-string v0, "+hWVKhPd\n"

    .line 2
    .line 3
    const-string v1, "uEbYS3qzjDE=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    const-string v0, "Ps1gwrSyyR8mx0zDgr7FSnI=\n"

    .line 9
    .line 10
    const-string v1, "UqIBpubXpHA=\n"

    .line 11
    .line 12
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    iget-object v0, v0, Lorg/bitspark/android/utils/b;->m:Ljava/lang/String;

    .line 20
    .line 21
    :try_start_0
    iget-object v0, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 22
    .line 23
    new-instance v1, Lea/b0;

    .line 24
    .line 25
    invoke-direct {v1, p0}, Lea/b0;-><init>(Lea/k;)V

    .line 26
    .line 27
    .line 28
    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 29
    .line 30
    .line 31
    goto :goto_0

    .line 32
    :catch_0
    move-exception v0

    .line 33
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 34
    .line 35
    .line 36
    :goto_0
    return-void
.end method

.method public c(Ljava/lang/Object;)V
    .locals 7

    .line 1
    const/16 v0, 0x64

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    const/16 v2, 0x8

    .line 5
    .line 6
    const/4 v3, 0x1

    .line 7
    iget v4, p0, Lea/k;->a:I

    .line 8
    .line 9
    packed-switch v4, :pswitch_data_0

    .line 10
    .line 11
    .line 12
    check-cast p1, Lorg/bitspark/android/beans/ChannelBean;

    .line 13
    .line 14
    iget-object v0, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 15
    .line 16
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 17
    .line 18
    .line 19
    invoke-static {}, Lorg/bitspark/android/Spark;->Y()Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v4

    .line 23
    sget v5, Lorg/bitspark/android/R$drawable;->home_live_channel_not_uploaded_2x:I

    .line 24
    .line 25
    iget-object v6, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 26
    .line 27
    iget-object v6, v6, Lorg/bitspark/android/Spark;->C0:Landroid/widget/ImageView;

    .line 28
    .line 29
    invoke-virtual {v0, v4, v5, v6}, Lorg/bitspark/android/Spark;->h0(Ljava/lang/String;ILandroid/widget/ImageView;)V

    .line 30
    .line 31
    .line 32
    invoke-virtual {p1}, Lorg/bitspark/android/beans/ChannelBean;->getChid()I

    .line 33
    .line 34
    .line 35
    move-result v0

    .line 36
    invoke-virtual {p1}, Lorg/bitspark/android/beans/ChannelBean;->getLevel()I

    .line 37
    .line 38
    .line 39
    move-result p1

    .line 40
    const/16 v4, 0x12

    .line 41
    .line 42
    if-lt p1, v4, :cond_0

    .line 43
    .line 44
    iget-object p1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 45
    .line 46
    iget-object p1, p1, Lorg/bitspark/android/Spark;->q1:Landroid/widget/CheckBox;

    .line 47
    .line 48
    invoke-virtual {p1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 49
    .line 50
    .line 51
    goto :goto_0

    .line 52
    :cond_0
    iget-object p1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 53
    .line 54
    iget-object p1, p1, Lorg/bitspark/android/Spark;->q1:Landroid/widget/CheckBox;

    .line 55
    .line 56
    invoke-virtual {p1, v1}, Landroid/view/View;->setVisibility(I)V

    .line 57
    .line 58
    .line 59
    sget-object p1, Lga/d;->f:Ljava/util/HashSet;

    .line 60
    .line 61
    new-instance v2, Ljava/lang/StringBuilder;

    .line 62
    .line 63
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 64
    .line 65
    .line 66
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 67
    .line 68
    .line 69
    const-string v0, ""

    .line 70
    .line 71
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 72
    .line 73
    .line 74
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    invoke-virtual {p1, v0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    .line 79
    .line 80
    .line 81
    move-result p1

    .line 82
    if-eqz p1, :cond_1

    .line 83
    .line 84
    iget-object p1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 85
    .line 86
    iget-object p1, p1, Lorg/bitspark/android/Spark;->q1:Landroid/widget/CheckBox;

    .line 87
    .line 88
    invoke-virtual {p1, v3}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 89
    .line 90
    .line 91
    goto :goto_0

    .line 92
    :cond_1
    iget-object p1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 93
    .line 94
    iget-object p1, p1, Lorg/bitspark/android/Spark;->q1:Landroid/widget/CheckBox;

    .line 95
    .line 96
    invoke-virtual {p1, v1}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 97
    .line 98
    .line 99
    :goto_0
    iget-object p1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 100
    .line 101
    iget-object p1, p1, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 102
    .line 103
    iget-object p1, p1, Lta/a;->C:Ljava/util/ArrayList;

    .line 104
    .line 105
    invoke-virtual {p1}, Ljava/util/ArrayList;->clear()V

    .line 106
    .line 107
    .line 108
    return-void

    .line 109
    :pswitch_0
    check-cast p1, Ljava/lang/Integer;

    .line 110
    .line 111
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    .line 112
    .line 113
    .line 114
    move-result p1

    .line 115
    iget-object v1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 116
    .line 117
    if-eq p1, v3, :cond_c

    .line 118
    .line 119
    const/4 v2, 0x2

    .line 120
    if-eq p1, v2, :cond_a

    .line 121
    .line 122
    const/4 v2, 0x3

    .line 123
    if-eq p1, v2, :cond_7

    .line 124
    .line 125
    const/4 v0, 0x4

    .line 126
    if-eq p1, v0, :cond_6

    .line 127
    .line 128
    const/4 v0, 0x5

    .line 129
    if-eq p1, v0, :cond_5

    .line 130
    .line 131
    const/16 v2, 0x78

    .line 132
    .line 133
    if-eq p1, v2, :cond_2

    .line 134
    .line 135
    goto/16 :goto_1

    .line 136
    .line 137
    :cond_2
    iget-object p1, v1, Lorg/bitspark/android/Spark;->J:Lka/m0;

    .line 138
    .line 139
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 140
    .line 141
    .line 142
    const-string v1, "iEfE6F22cvqVZM7zdot46I5Whrx1vGn7oE3f6WifY+CLcNX7c60=\n"

    .line 143
    .line 144
    const-string v2, "5iK8nBvZEY8=\n"

    .line 145
    .line 146
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 147
    .line 148
    .line 149
    move-result-object v1

    .line 150
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 151
    .line 152
    sget-object v2, Lka/m0;->B0:Ljava/lang/String;

    .line 153
    .line 154
    invoke-static {v2, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    .line 156
    .line 157
    iget-boolean v1, p1, Lka/m0;->r0:Z

    .line 158
    .line 159
    if-eqz v1, :cond_3

    .line 160
    .line 161
    iget-object v1, p1, Lka/m0;->c0:Lfa/f1;

    .line 162
    .line 163
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 164
    .line 165
    .line 166
    move-result-object v0

    .line 167
    new-instance v2, La7/f;

    .line 168
    .line 169
    const/16 v3, 0x1d

    .line 170
    .line 171
    invoke-direct {v2, p1, v3, v0}, La7/f;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 172
    .line 173
    .line 174
    iput-object v2, v1, Lfa/p;->e:La7/f;

    .line 175
    .line 176
    goto/16 :goto_1

    .line 177
    .line 178
    :cond_3
    sget-boolean v0, Lka/m0;->G0:Z

    .line 179
    .line 180
    if-eqz v0, :cond_4

    .line 181
    .line 182
    iget-object p1, p1, Lka/m0;->j0:Landroid/widget/FrameLayout;

    .line 183
    .line 184
    invoke-static {p1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 185
    .line 186
    .line 187
    goto/16 :goto_1

    .line 188
    .line 189
    :cond_4
    iget-object p1, p1, Lka/m0;->X:Landroidx/recyclerview/widget/RecyclerView;

    .line 190
    .line 191
    invoke-static {p1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 192
    .line 193
    .line 194
    goto/16 :goto_1

    .line 195
    .line 196
    :cond_5
    iget-object p1, v1, Lorg/bitspark/android/Spark;->J:Lka/m0;

    .line 197
    .line 198
    iget-object p1, p1, Lka/m0;->V:Landroidx/recyclerview/widget/RecyclerView;

    .line 199
    .line 200
    invoke-static {p1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 201
    .line 202
    .line 203
    goto/16 :goto_1

    .line 204
    .line 205
    :cond_6
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 206
    .line 207
    .line 208
    const/4 p1, 0x0

    .line 209
    throw p1

    .line 210
    :cond_7
    iget-object p1, v1, Lorg/bitspark/android/Spark;->J:Lka/m0;

    .line 211
    .line 212
    iget-object p1, p1, Lka/m0;->d0:Lfa/x0;

    .line 213
    .line 214
    if-eqz p1, :cond_e

    .line 215
    .line 216
    iget-object v1, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    .line 217
    .line 218
    invoke-interface {v1}, Lra/a;->isPlaying()Z

    .line 219
    .line 220
    .line 221
    move-result v1

    .line 222
    sget-boolean v2, Lorg/bitspark/android/Spark;->g2:Z

    .line 223
    .line 224
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 225
    .line 226
    .line 227
    if-eqz v1, :cond_8

    .line 228
    .line 229
    if-eqz v2, :cond_8

    .line 230
    .line 231
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 232
    .line 233
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 234
    .line 235
    .line 236
    goto :goto_1

    .line 237
    :cond_8
    iget v0, p1, Lfa/o;->b:I

    .line 238
    .line 239
    if-gtz v0, :cond_9

    .line 240
    .line 241
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 242
    .line 243
    const/16 v0, 0x90

    .line 244
    .line 245
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 246
    .line 247
    .line 248
    goto :goto_1

    .line 249
    :cond_9
    iget-object v0, p1, Lfa/o;->e:Landroidx/recyclerview/widget/RecyclerView;

    .line 250
    .line 251
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->getLayoutManager()Landroidx/recyclerview/widget/x0;

    .line 252
    .line 253
    .line 254
    iget v0, p1, Lfa/o;->b:I

    .line 255
    .line 256
    neg-int v0, v0

    .line 257
    invoke-virtual {p1, v0}, Lfa/o;->a(I)Z

    .line 258
    .line 259
    .line 260
    goto :goto_1

    .line 261
    :cond_a
    iget-object p1, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    .line 262
    .line 263
    invoke-interface {p1}, Lra/a;->isPlaying()Z

    .line 264
    .line 265
    .line 266
    move-result p1

    .line 267
    if-eqz p1, :cond_b

    .line 268
    .line 269
    sget-boolean p1, Lorg/bitspark/android/Spark;->g2:Z

    .line 270
    .line 271
    if-eqz p1, :cond_b

    .line 272
    .line 273
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 274
    .line 275
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 276
    .line 277
    .line 278
    goto :goto_1

    .line 279
    :cond_b
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 280
    .line 281
    const/16 v0, 0x69

    .line 282
    .line 283
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 284
    .line 285
    .line 286
    goto :goto_1

    .line 287
    :cond_c
    iget-object p1, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    .line 288
    .line 289
    invoke-interface {p1}, Lra/a;->isPlaying()Z

    .line 290
    .line 291
    .line 292
    move-result p1

    .line 293
    if-eqz p1, :cond_d

    .line 294
    .line 295
    sget-boolean p1, Lorg/bitspark/android/Spark;->g2:Z

    .line 296
    .line 297
    if-eqz p1, :cond_d

    .line 298
    .line 299
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 300
    .line 301
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 302
    .line 303
    .line 304
    goto :goto_1

    .line 305
    :cond_d
    const-string p1, "ah05X69h\n"

    .line 306
    .line 307
    const-string v0, "KE50PsYPdzU=\n"

    .line 308
    .line 309
    invoke-static {p1, v0}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 310
    .line 311
    .line 312
    move-result-object p1

    .line 313
    const-string v0, "214SWNxvkM7sXxxD4n0=\n"

    .line 314
    .line 315
    const-string v2, "qDZ9L40a+bo=\n"

    .line 316
    .line 317
    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 318
    .line 319
    .line 320
    move-result-object v0

    .line 321
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 322
    .line 323
    invoke-static {p1, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 324
    .line 325
    .line 326
    invoke-static {v1}, Lorg/bitspark/android/utils/m;->p(Landroid/content/Context;)Ljava/lang/Boolean;

    .line 327
    .line 328
    .line 329
    :cond_e
    :goto_1
    return-void

    .line 330
    :pswitch_1
    check-cast p1, Ljava/lang/String;

    .line 331
    .line 332
    iget-object v0, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 333
    .line 334
    iget-object v0, v0, Lorg/bitspark/android/Spark;->s0:Landroidx/media3/ui/SubtitleView;

    .line 335
    .line 336
    new-instance v1, La3/c;

    .line 337
    .line 338
    const/16 v2, 0xd

    .line 339
    .line 340
    invoke-direct {v1, p0, v2, p1}, La3/c;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 341
    .line 342
    .line 343
    invoke-virtual {v0, v1}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 344
    .line 345
    .line 346
    return-void

    .line 347
    :pswitch_2
    check-cast p1, Ljava/lang/Integer;

    .line 348
    .line 349
    iget-object v0, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 350
    .line 351
    iget-object v1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 352
    .line 353
    invoke-virtual {v1}, Lta/a;->h()Z

    .line 354
    .line 355
    .line 356
    move-result v1

    .line 357
    if-nez v1, :cond_11

    .line 358
    .line 359
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    .line 360
    .line 361
    .line 362
    move-result p1

    .line 363
    if-nez p1, :cond_10

    .line 364
    .line 365
    invoke-virtual {v0}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    .line 366
    .line 367
    .line 368
    move-result-object p1

    .line 369
    if-eqz p1, :cond_f

    .line 370
    .line 371
    invoke-virtual {v0}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    .line 372
    .line 373
    .line 374
    move-result-object p1

    .line 375
    instance-of p1, p1, Landroid/widget/RadioButton;

    .line 376
    .line 377
    if-eqz p1, :cond_f

    .line 378
    .line 379
    invoke-virtual {v0, v3}, Lorg/bitspark/android/Spark;->k0(Z)V

    .line 380
    .line 381
    .line 382
    goto :goto_2

    .line 383
    :cond_f
    invoke-virtual {v0, v3}, Lorg/bitspark/android/Spark;->T(Z)V

    .line 384
    .line 385
    .line 386
    goto :goto_2

    .line 387
    :cond_10
    invoke-virtual {v0, v3}, Lorg/bitspark/android/Spark;->k0(Z)V

    .line 388
    .line 389
    .line 390
    :cond_11
    :goto_2
    return-void

    .line 391
    :pswitch_3
    check-cast p1, Ljava/lang/Integer;

    .line 392
    .line 393
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    .line 394
    .line 395
    .line 396
    move-result p1

    .line 397
    iget-object v0, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 398
    .line 399
    if-ne p1, v3, :cond_13

    .line 400
    .line 401
    iget-object p1, v0, Lorg/bitspark/android/Spark;->I:Lka/r;

    .line 402
    .line 403
    iget-object p1, p1, Lka/r;->W:Landroidx/leanback/widget/VerticalGridView;

    .line 404
    .line 405
    if-eqz p1, :cond_12

    .line 406
    .line 407
    invoke-virtual {p1, v3}, Landroidx/leanback/widget/j;->setFocusScrollStrategy(I)V

    .line 408
    .line 409
    .line 410
    :cond_12
    iget-object p1, v0, Lorg/bitspark/android/Spark;->r0:Landroid/widget/ImageView;

    .line 411
    .line 412
    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 413
    .line 414
    .line 415
    invoke-virtual {v0, v3}, Lorg/bitspark/android/Spark;->k0(Z)V

    .line 416
    .line 417
    .line 418
    goto :goto_3

    .line 419
    :cond_13
    iget-object p1, v0, Lorg/bitspark/android/Spark;->r0:Landroid/widget/ImageView;

    .line 420
    .line 421
    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 422
    .line 423
    .line 424
    invoke-virtual {v0}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    .line 425
    .line 426
    .line 427
    move-result-object p1

    .line 428
    if-eqz p1, :cond_14

    .line 429
    .line 430
    invoke-virtual {v0}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    .line 431
    .line 432
    .line 433
    move-result-object p1

    .line 434
    instance-of p1, p1, Landroid/widget/RadioButton;

    .line 435
    .line 436
    if-eqz p1, :cond_14

    .line 437
    .line 438
    sget-object p1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 439
    .line 440
    invoke-virtual {v0, p1}, Lorg/bitspark/android/Spark;->x0(Ljava/lang/Boolean;)V

    .line 441
    .line 442
    .line 443
    goto :goto_3

    .line 444
    :cond_14
    sget-object p1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .line 445
    .line 446
    invoke-virtual {v0, p1}, Lorg/bitspark/android/Spark;->x0(Ljava/lang/Boolean;)V

    .line 447
    .line 448
    .line 449
    :goto_3
    return-void

    .line 450
    nop

    .line 451
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public d(ILjava/lang/Object;)V
    .locals 5

    .line 1
    iget v0, p0, Lea/k;->a:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    check-cast p2, Lorg/bitspark/android/beans/SeasonMenu;

    .line 7
    .line 8
    iget-object p2, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 9
    .line 10
    iget-object v0, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 11
    .line 12
    iput p1, v0, Lta/a;->s:I

    .line 13
    .line 14
    invoke-virtual {v0, p1}, Lta/a;->m(I)V

    .line 15
    .line 16
    .line 17
    iget-object p1, p2, Lorg/bitspark/android/Spark;->v0:Lfa/b1;

    .line 18
    .line 19
    iget-object v0, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 20
    .line 21
    const/4 v1, -0x1

    .line 22
    invoke-virtual {v0, v1}, Lta/a;->d(I)I

    .line 23
    .line 24
    .line 25
    move-result v0

    .line 26
    iput v0, p1, Lfa/c;->e:I

    .line 27
    .line 28
    iget-object p1, p2, Lorg/bitspark/android/Spark;->v0:Lfa/b1;

    .line 29
    .line 30
    iget-object v0, p2, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 31
    .line 32
    iget-object v0, v0, Lta/a;->A:Ljava/util/ArrayList;

    .line 33
    .line 34
    invoke-virtual {p1, v0}, Lfa/c;->a(Ljava/util/List;)V

    .line 35
    .line 36
    .line 37
    iget-object p1, p2, Lorg/bitspark/android/Spark;->v0:Lfa/b1;

    .line 38
    .line 39
    invoke-virtual {p1}, Landroidx/recyclerview/widget/k0;->notifyDataSetChanged()V

    .line 40
    .line 41
    .line 42
    sget-object p1, Lka/m0;->E0:Landroidx/mediarouter/app/c;

    .line 43
    .line 44
    new-instance p2, La/f;

    .line 45
    .line 46
    const/16 v0, 0xf

    .line 47
    .line 48
    invoke-direct {p2, v0, p0}, La/f;-><init>(ILjava/lang/Object;)V

    .line 49
    .line 50
    .line 51
    const-wide/16 v0, 0x64

    .line 52
    .line 53
    invoke-virtual {p1, p2, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 54
    .line 55
    .line 56
    return-void

    .line 57
    :pswitch_0
    check-cast p2, Lorg/bitspark/android/beans/VodMenu;

    .line 58
    .line 59
    iget-object v0, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 60
    .line 61
    iget-object v1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 62
    .line 63
    iput p1, v1, Lta/a;->x:I

    .line 64
    .line 65
    iget-object v1, v0, Lorg/bitspark/android/Spark;->u0:Lfa/m1;

    .line 66
    .line 67
    iput p1, v1, Lfa/c;->e:I

    .line 68
    .line 69
    iget-object p1, v0, Lorg/bitspark/android/Spark;->A0:Landroidx/leanback/widget/HorizontalGridView;

    .line 70
    .line 71
    const/4 v1, 0x0

    .line 72
    invoke-virtual {p1, v1}, Landroid/view/View;->setVisibility(I)V

    .line 73
    .line 74
    .line 75
    invoke-virtual {p2}, Lorg/bitspark/android/beans/VodMenu;->getName()Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object p1

    .line 79
    sget-object v2, Lea/e;->b:Lea/e;

    .line 80
    .line 81
    invoke-virtual {v2}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 82
    .line 83
    .line 84
    move-result-object v2

    .line 85
    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 86
    .line 87
    .line 88
    move-result p1

    .line 89
    const/16 v2, 0x8

    .line 90
    .line 91
    if-eqz p1, :cond_4

    .line 92
    .line 93
    iget-object p1, v0, Lorg/bitspark/android/Spark;->w0:Lfa/o1;

    .line 94
    .line 95
    iget-object p2, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 96
    .line 97
    iget-object p2, p2, Lta/a;->z:Ljava/util/ArrayList;

    .line 98
    .line 99
    invoke-virtual {p1, p2}, Lfa/c;->a(Ljava/util/List;)V

    .line 100
    .line 101
    .line 102
    iget-object p1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 103
    .line 104
    iget-object p1, p1, Lta/a;->z:Ljava/util/ArrayList;

    .line 105
    .line 106
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 107
    .line 108
    .line 109
    move-result p1

    .line 110
    const/4 p2, 0x1

    .line 111
    if-gt p1, p2, :cond_0

    .line 112
    .line 113
    iget-object p1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 114
    .line 115
    iget-object p1, p1, Lta/a;->A:Ljava/util/ArrayList;

    .line 116
    .line 117
    invoke-virtual {p1}, Ljava/util/ArrayList;->clear()V

    .line 118
    .line 119
    .line 120
    iget-object p1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 121
    .line 122
    iget-object v3, p1, Lta/a;->A:Ljava/util/ArrayList;

    .line 123
    .line 124
    iget-object p1, p1, Lta/a;->q:Lorg/bitspark/android/beans/ChannelBean;

    .line 125
    .line 126
    invoke-virtual {p1}, Lorg/bitspark/android/beans/ChannelBean;->getSources()Ljava/util/List;

    .line 127
    .line 128
    .line 129
    move-result-object p1

    .line 130
    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 131
    .line 132
    .line 133
    goto :goto_0

    .line 134
    :cond_0
    iget-object p1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 135
    .line 136
    iget-object p1, p1, Lta/a;->z:Ljava/util/ArrayList;

    .line 137
    .line 138
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 139
    .line 140
    .line 141
    move-result p1

    .line 142
    if-le p1, p2, :cond_1

    .line 143
    .line 144
    iget-object p1, v0, Lorg/bitspark/android/Spark;->w0:Lfa/o1;

    .line 145
    .line 146
    iget-object v3, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 147
    .line 148
    iget v4, v3, Lta/a;->s:I

    .line 149
    .line 150
    iput v4, p1, Lfa/c;->e:I

    .line 151
    .line 152
    invoke-virtual {v3, v4}, Lta/a;->m(I)V

    .line 153
    .line 154
    .line 155
    :cond_1
    :goto_0
    iget-object p1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 156
    .line 157
    iget-object p1, p1, Lta/a;->A:Ljava/util/ArrayList;

    .line 158
    .line 159
    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    .line 160
    .line 161
    .line 162
    move-result p1

    .line 163
    if-nez p1, :cond_2

    .line 164
    .line 165
    iget-object p1, v0, Lorg/bitspark/android/Spark;->v0:Lfa/b1;

    .line 166
    .line 167
    iget-object v3, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 168
    .line 169
    iget-object v3, v3, Lta/a;->A:Ljava/util/ArrayList;

    .line 170
    .line 171
    invoke-virtual {p1, v3}, Lfa/c;->a(Ljava/util/List;)V

    .line 172
    .line 173
    .line 174
    iget-object p1, v0, Lorg/bitspark/android/Spark;->v0:Lfa/b1;

    .line 175
    .line 176
    iget-object v3, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 177
    .line 178
    const/4 v4, -0x1

    .line 179
    invoke-virtual {v3, v4}, Lta/a;->d(I)I

    .line 180
    .line 181
    .line 182
    move-result v3

    .line 183
    iput v3, p1, Lfa/c;->e:I

    .line 184
    .line 185
    :cond_2
    iget-object p1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 186
    .line 187
    iget-object p1, p1, Lta/a;->z:Ljava/util/ArrayList;

    .line 188
    .line 189
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 190
    .line 191
    .line 192
    move-result p1

    .line 193
    if-gt p1, p2, :cond_3

    .line 194
    .line 195
    iget-object p1, v0, Lorg/bitspark/android/Spark;->B0:Landroidx/leanback/widget/HorizontalGridView;

    .line 196
    .line 197
    invoke-virtual {p1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 198
    .line 199
    .line 200
    goto :goto_1

    .line 201
    :cond_3
    iget-object p1, v0, Lorg/bitspark/android/Spark;->B0:Landroidx/leanback/widget/HorizontalGridView;

    .line 202
    .line 203
    iget-object p2, v0, Lorg/bitspark/android/Spark;->w0:Lfa/o1;

    .line 204
    .line 205
    invoke-virtual {p1, p2}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/k0;)V

    .line 206
    .line 207
    .line 208
    iget-object p1, v0, Lorg/bitspark/android/Spark;->B0:Landroidx/leanback/widget/HorizontalGridView;

    .line 209
    .line 210
    invoke-virtual {p1, v1}, Landroid/view/View;->setVisibility(I)V

    .line 211
    .line 212
    .line 213
    iget-object p1, v0, Lorg/bitspark/android/Spark;->w0:Lfa/o1;

    .line 214
    .line 215
    invoke-virtual {p1}, Landroidx/recyclerview/widget/k0;->notifyDataSetChanged()V

    .line 216
    .line 217
    .line 218
    :goto_1
    iget-object p1, v0, Lorg/bitspark/android/Spark;->A0:Landroidx/leanback/widget/HorizontalGridView;

    .line 219
    .line 220
    iget-object p2, v0, Lorg/bitspark/android/Spark;->v0:Lfa/b1;

    .line 221
    .line 222
    invoke-virtual {p1, p2}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/k0;)V

    .line 223
    .line 224
    .line 225
    iget-object p1, v0, Lorg/bitspark/android/Spark;->v0:Lfa/b1;

    .line 226
    .line 227
    invoke-virtual {p1}, Landroidx/recyclerview/widget/k0;->notifyDataSetChanged()V

    .line 228
    .line 229
    .line 230
    iget-object p1, v0, Lorg/bitspark/android/Spark;->A0:Landroidx/leanback/widget/HorizontalGridView;

    .line 231
    .line 232
    invoke-virtual {p1, v1}, Landroid/view/View;->setVisibility(I)V

    .line 233
    .line 234
    .line 235
    iget-object p1, v0, Lorg/bitspark/android/Spark;->A0:Landroidx/leanback/widget/HorizontalGridView;

    .line 236
    .line 237
    iget-object p2, v0, Lorg/bitspark/android/Spark;->v0:Lfa/b1;

    .line 238
    .line 239
    iget p2, p2, Lfa/c;->e:I

    .line 240
    .line 241
    invoke-virtual {p1, p2}, Landroidx/leanback/widget/j;->smoothScrollToPosition(I)V

    .line 242
    .line 243
    .line 244
    goto/16 :goto_2

    .line 245
    .line 246
    :cond_4
    invoke-virtual {p2}, Lorg/bitspark/android/beans/VodMenu;->getName()Ljava/lang/String;

    .line 247
    .line 248
    .line 249
    move-result-object p1

    .line 250
    sget-object v1, Lea/e;->c:Lea/e;

    .line 251
    .line 252
    invoke-virtual {v1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 253
    .line 254
    .line 255
    move-result-object v1

    .line 256
    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 257
    .line 258
    .line 259
    move-result p1

    .line 260
    if-eqz p1, :cond_5

    .line 261
    .line 262
    iget-object p1, v0, Lorg/bitspark/android/Spark;->x0:Lfa/o1;

    .line 263
    .line 264
    iget-object p2, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 265
    .line 266
    iget-object p2, p2, Lta/a;->D:Ljava/util/ArrayList;

    .line 267
    .line 268
    invoke-virtual {p1, p2}, Lfa/c;->a(Ljava/util/List;)V

    .line 269
    .line 270
    .line 271
    iget-object p1, v0, Lorg/bitspark/android/Spark;->x0:Lfa/o1;

    .line 272
    .line 273
    iget-object p2, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 274
    .line 275
    iget p2, p2, Lta/a;->u:I

    .line 276
    .line 277
    iput p2, p1, Lfa/c;->e:I

    .line 278
    .line 279
    iget-object p2, v0, Lorg/bitspark/android/Spark;->A0:Landroidx/leanback/widget/HorizontalGridView;

    .line 280
    .line 281
    invoke-virtual {p2, p1}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/k0;)V

    .line 282
    .line 283
    .line 284
    iget-object p1, v0, Lorg/bitspark/android/Spark;->B0:Landroidx/leanback/widget/HorizontalGridView;

    .line 285
    .line 286
    invoke-virtual {p1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 287
    .line 288
    .line 289
    goto :goto_2

    .line 290
    :cond_5
    invoke-virtual {p2}, Lorg/bitspark/android/beans/VodMenu;->getName()Ljava/lang/String;

    .line 291
    .line 292
    .line 293
    move-result-object p1

    .line 294
    sget-object v1, Lea/e;->d:Lea/e;

    .line 295
    .line 296
    invoke-virtual {v1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 297
    .line 298
    .line 299
    move-result-object v1

    .line 300
    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 301
    .line 302
    .line 303
    move-result p1

    .line 304
    if-eqz p1, :cond_6

    .line 305
    .line 306
    iget-object p1, v0, Lorg/bitspark/android/Spark;->y0:Lfa/o1;

    .line 307
    .line 308
    iget-object p2, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 309
    .line 310
    iget-object p2, p2, Lta/a;->B:Ljava/util/ArrayList;

    .line 311
    .line 312
    invoke-virtual {p1, p2}, Lfa/c;->a(Ljava/util/List;)V

    .line 313
    .line 314
    .line 315
    iget-object p1, v0, Lorg/bitspark/android/Spark;->y0:Lfa/o1;

    .line 316
    .line 317
    iget-object p2, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 318
    .line 319
    iget p2, p2, Lta/a;->t:I

    .line 320
    .line 321
    iput p2, p1, Lfa/c;->e:I

    .line 322
    .line 323
    iget-object p2, v0, Lorg/bitspark/android/Spark;->A0:Landroidx/leanback/widget/HorizontalGridView;

    .line 324
    .line 325
    invoke-virtual {p2, p1}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/k0;)V

    .line 326
    .line 327
    .line 328
    iget-object p1, v0, Lorg/bitspark/android/Spark;->B0:Landroidx/leanback/widget/HorizontalGridView;

    .line 329
    .line 330
    invoke-virtual {p1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 331
    .line 332
    .line 333
    goto :goto_2

    .line 334
    :cond_6
    invoke-virtual {p2}, Lorg/bitspark/android/beans/VodMenu;->getName()Ljava/lang/String;

    .line 335
    .line 336
    .line 337
    move-result-object p1

    .line 338
    sget-object p2, Lea/e;->e:Lea/e;

    .line 339
    .line 340
    invoke-virtual {p2}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 341
    .line 342
    .line 343
    move-result-object p2

    .line 344
    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 345
    .line 346
    .line 347
    move-result p1

    .line 348
    if-eqz p1, :cond_7

    .line 349
    .line 350
    iget-object p1, v0, Lorg/bitspark/android/Spark;->t0:Lfa/o1;

    .line 351
    .line 352
    iget-object p2, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 353
    .line 354
    iget-object p2, p2, Lta/a;->y:Ljava/util/ArrayList;

    .line 355
    .line 356
    invoke-virtual {p1, p2}, Lfa/c;->a(Ljava/util/List;)V

    .line 357
    .line 358
    .line 359
    iget-object p1, v0, Lorg/bitspark/android/Spark;->t0:Lfa/o1;

    .line 360
    .line 361
    iget-object p2, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 362
    .line 363
    iget p2, p2, Lta/a;->w:I

    .line 364
    .line 365
    iput p2, p1, Lfa/c;->e:I

    .line 366
    .line 367
    iget-object p2, v0, Lorg/bitspark/android/Spark;->A0:Landroidx/leanback/widget/HorizontalGridView;

    .line 368
    .line 369
    invoke-virtual {p2, p1}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/k0;)V

    .line 370
    .line 371
    .line 372
    iget-object p1, v0, Lorg/bitspark/android/Spark;->B0:Landroidx/leanback/widget/HorizontalGridView;

    .line 373
    .line 374
    invoke-virtual {p1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 375
    .line 376
    .line 377
    :cond_7
    :goto_2
    return-void

    .line 378
    nop

    .line 379
    :pswitch_data_0
    .packed-switch 0x9
        :pswitch_0
    .end packed-switch
.end method

.method public onInfo(Ljava/lang/String;)V
    .locals 2

    .line 1
    const-string v0, "l1VaMHDy\n"

    .line 2
    .line 3
    const-string v1, "1QYXURmcG0U=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    const-string v0, "T6OPkzCt91R1vKKaLej5FTXV\n"

    .line 9
    .line 10
    const-string v1, "G/XM/ELI1zs=\n"

    .line 11
    .line 12
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    const-string v0, "JHyEHP1L\n"

    .line 16
    .line 17
    const-string v1, "SxLNcpskaeg=\n"

    .line 18
    .line 19
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    iget-object v1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 24
    .line 25
    invoke-static {v1, v0, p1}, Lorg/bitspark/android/Spark;->Q(Lorg/bitspark/android/Spark;Ljava/lang/String;Ljava/lang/String;)Z

    .line 26
    .line 27
    .line 28
    move-result p1

    .line 29
    if-eqz p1, :cond_0

    .line 30
    .line 31
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 32
    .line 33
    const/16 v0, 0x47

    .line 34
    .line 35
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 36
    .line 37
    .line 38
    :cond_0
    sget-object p1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 39
    .line 40
    const/16 v0, 0xc9

    .line 41
    .line 42
    invoke-virtual {p1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 43
    .line 44
    .line 45
    return-void
.end method

.method public onInited(Ljava/lang/String;)V
    .locals 4

    .line 1
    const-string v0, "5fmGQQpu\n"

    .line 2
    .line 3
    const-string v1, "p6rLIGMAQPw=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    new-instance v1, Ljava/lang/StringBuilder;

    .line 10
    .line 11
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 12
    .line 13
    .line 14
    const-string v2, "9Gpj+tHX2KLTHEn7ysadr4ASDruD\n"

    .line 15
    .line 16
    const-string v3, "oDwglaOy+Ms=\n"

    .line 17
    .line 18
    invoke-static {v2, v3, v1, p1}, Lea/q;->j(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 23
    .line 24
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    const-string v0, "RPgMe/oj\n"

    .line 28
    .line 29
    const-string v1, "BqtBGpNNdWw=\n"

    .line 30
    .line 31
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    new-instance v1, Ljava/lang/StringBuilder;

    .line 36
    .line 37
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 38
    .line 39
    .line 40
    const-string v2, "lAGpdnyhqZqPFK5wfLv51t5J9T0xv+fW3kn1PTG/0w==\n"

    .line 41
    .line 42
    const-string v3, "4HfLAw+B2eg=\n"

    .line 43
    .line 44
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 45
    .line 46
    .line 47
    move-result-object v2

    .line 48
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 49
    .line 50
    .line 51
    invoke-static {}, Lcom/tvbus/engine/TVCore;->getInstance()Lcom/tvbus/engine/TVCore;

    .line 52
    .line 53
    .line 54
    move-result-object v2

    .line 55
    const/16 v3, 0x7ea

    .line 56
    .line 57
    invoke-virtual {v2, v3}, Lcom/tvbus/engine/TVCore;->getVersion(I)Ljava/lang/String;

    .line 58
    .line 59
    .line 60
    move-result-object v2

    .line 61
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 62
    .line 63
    .line 64
    const-string v2, "YldQZofIB6ZUV1Bmh8gHplRXUFA=\n"

    .line 65
    .line 66
    const-string v3, "aGtsWrv0O5o=\n"

    .line 67
    .line 68
    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 69
    .line 70
    .line 71
    move-result-object v2

    .line 72
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 73
    .line 74
    .line 75
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object v1

    .line 79
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    .line 81
    .line 82
    const-string v0, "UxQXggnFiBQ=\n"

    .line 83
    .line 84
    const-string v1, "PHpe7GCx7XA=\n"

    .line 85
    .line 86
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 87
    .line 88
    .line 89
    move-result-object v0

    .line 90
    iget-object v1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 91
    .line 92
    invoke-static {v1, v0, p1}, Lorg/bitspark/android/Spark;->Q(Lorg/bitspark/android/Spark;Ljava/lang/String;Ljava/lang/String;)Z

    .line 93
    .line 94
    .line 95
    return-void
.end method

.method public onPrepared(Ljava/lang/String;)V
    .locals 4

    .line 1
    const-string v0, "7OTWahAf\n"

    .line 2
    .line 3
    const-string v1, "rrebC3lxFyg=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    new-instance v1, Ljava/lang/StringBuilder;

    .line 10
    .line 11
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 12
    .line 13
    .line 14
    const-string v2, "zTNihETdSlX3NVOORtkYX/1FD8UYmA==\n"

    .line 15
    .line 16
    const-string v3, "mWUh6za4ajo=\n"

    .line 17
    .line 18
    invoke-static {v2, v3, v1, p1}, Lea/q;->j(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 23
    .line 24
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    const-string v0, "1m5G02MWW4DcZA==\n"

    .line 28
    .line 29
    const-string v1, "uQAWoQZmOvI=\n"

    .line 30
    .line 31
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    iget-object v1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 36
    .line 37
    invoke-static {v1, v0, p1}, Lorg/bitspark/android/Spark;->Q(Lorg/bitspark/android/Spark;Ljava/lang/String;Ljava/lang/String;)Z

    .line 38
    .line 39
    .line 40
    move-result p1

    .line 41
    invoke-virtual {v1}, Lorg/bitspark/android/Spark;->c0()Z

    .line 42
    .line 43
    .line 44
    move-result v0

    .line 45
    if-eqz v0, :cond_0

    .line 46
    .line 47
    sget-object v0, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 48
    .line 49
    new-instance v1, Lb1/l;

    .line 50
    .line 51
    const/4 v2, 0x3

    .line 52
    invoke-direct {v1, v2}, Lb1/l;-><init>(I)V

    .line 53
    .line 54
    .line 55
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 56
    .line 57
    .line 58
    :cond_0
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 59
    .line 60
    .line 61
    move-result-object v0

    .line 62
    iget-boolean v0, v0, Lorg/bitspark/android/utils/b;->b:Z

    .line 63
    .line 64
    if-eqz v0, :cond_1

    .line 65
    .line 66
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    .line 67
    .line 68
    .line 69
    move-result-object p1

    .line 70
    iget-object p1, p1, Lorg/bitspark/android/utils/b;->a:Lea/k;

    .line 71
    .line 72
    invoke-virtual {p1}, Lea/k;->b()V

    .line 73
    .line 74
    .line 75
    return-void

    .line 76
    :cond_1
    if-eqz p1, :cond_2

    .line 77
    .line 78
    new-instance p1, Landroid/os/Message;

    .line 79
    .line 80
    invoke-direct {p1}, Landroid/os/Message;-><init>()V

    .line 81
    .line 82
    .line 83
    new-instance v0, Landroid/os/Bundle;

    .line 84
    .line 85
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 86
    .line 87
    .line 88
    const-string v1, "AAC9Fg3Y6Coe\n"

    .line 89
    .line 90
    const-string v2, "dmnZc2KIiV4=\n"

    .line 91
    .line 92
    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 93
    .line 94
    .line 95
    move-result-object v1

    .line 96
    sget-object v2, Lorg/bitspark/android/Spark;->h2:Ljava/lang/String;

    .line 97
    .line 98
    invoke-virtual {v0, v1, v2}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    .line 100
    .line 101
    const/16 v1, 0x51

    .line 102
    .line 103
    iput v1, p1, Landroid/os/Message;->what:I

    .line 104
    .line 105
    invoke-virtual {p1, v0}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 106
    .line 107
    .line 108
    sget-object v0, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 109
    .line 110
    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 111
    .line 112
    .line 113
    const/4 p1, 0x0

    .line 114
    sput-boolean p1, Lorg/bitspark/android/Spark;->j2:Z

    .line 115
    .line 116
    sget-object p1, Lea/h;->a:Ljava/lang/String;

    .line 117
    .line 118
    :cond_2
    return-void
.end method

.method public onQuit(Ljava/lang/String;)V
    .locals 4

    .line 1
    const-string v0, "zSDkvOBl\n"

    .line 2
    .line 3
    const-string v1, "j3Op3YkLuzY=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    new-instance v1, Ljava/lang/StringBuilder;

    .line 10
    .line 11
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 12
    .line 13
    .line 14
    const-string v2, "ibqTyn8m0j6zvaXMeWPcf/PM\n"

    .line 15
    .line 16
    const-string v3, "3ezQpQ1D8lE=\n"

    .line 17
    .line 18
    invoke-static {v2, v3, v1, p1}, Lea/q;->j(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object p1

    .line 22
    sget-boolean v1, Lorg/bitspark/android/utils/m;->b:Z

    .line 23
    .line 24
    invoke-static {v0, p1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    return-void
.end method

.method public onStart(Ljava/lang/String;)V
    .locals 4

    .line 1
    const-string v0, "l6Mk2b5e\n"

    .line 2
    .line 3
    const-string v1, "1fBpuNcwaPE=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    new-instance v1, Ljava/lang/StringBuilder;

    .line 10
    .line 11
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 12
    .line 13
    .line 14
    const-string v2, "eTUg3FBSab5DMBfSUENp/wNNQw==\n"

    .line 15
    .line 16
    const-string v3, "LWNjsyI3SdE=\n"

    .line 17
    .line 18
    invoke-static {v2, v3, v1, p1}, Lea/q;->j(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 23
    .line 24
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    const-string v0, "/MJTpFAM3w==\n"

    .line 28
    .line 29
    const-string v1, "k6wA0DF+qzc=\n"

    .line 30
    .line 31
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    iget-object v1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 36
    .line 37
    invoke-static {v1, v0, p1}, Lorg/bitspark/android/Spark;->Q(Lorg/bitspark/android/Spark;Ljava/lang/String;Ljava/lang/String;)Z

    .line 38
    .line 39
    .line 40
    sget-boolean p1, Lorg/bitspark/android/Spark;->g2:Z

    .line 41
    .line 42
    if-eqz p1, :cond_0

    .line 43
    .line 44
    const p1, 0x3f666666    # 0.9f

    .line 45
    .line 46
    .line 47
    invoke-virtual {v1, p1}, Lorg/bitspark/android/Spark;->D0(F)V

    .line 48
    .line 49
    .line 50
    goto :goto_0

    .line 51
    :cond_0
    iget-object p1, v1, Lorg/bitspark/android/Spark;->b0:Landroid/widget/ImageView;

    .line 52
    .line 53
    new-instance v0, Lea/v;

    .line 54
    .line 55
    const/4 v2, 0x0

    .line 56
    invoke-direct {v0, v1, v2}, Lea/v;-><init>(Lorg/bitspark/android/Spark;I)V

    .line 57
    .line 58
    .line 59
    invoke-virtual {p1, v0}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 60
    .line 61
    .line 62
    :goto_0
    return-void
.end method

.method public onStop(Ljava/lang/String;)V
    .locals 4

    .line 1
    const-string v0, "MmXd2RhY\n"

    .line 2
    .line 3
    const-string v1, "cDaQuHE2Mx4=\n"

    .line 4
    .line 5
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    new-instance v1, Ljava/lang/StringBuilder;

    .line 10
    .line 11
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 12
    .line 13
    .line 14
    const-string v2, "nO8vz9Z7Rzam6hjP1D5Jd+aZ\n"

    .line 15
    .line 16
    const-string v3, "yLlsoKQeZ1k=\n"

    .line 17
    .line 18
    invoke-static {v2, v3, v1, p1}, Lea/q;->j(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 23
    .line 24
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    const-string v0, "uZQYHPly\n"

    .line 28
    .line 29
    const-string v1, "1vpLaJYCecs=\n"

    .line 30
    .line 31
    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    iget-object v1, p0, Lea/k;->b:Lorg/bitspark/android/Spark;

    .line 36
    .line 37
    invoke-static {v1, v0, p1}, Lorg/bitspark/android/Spark;->Q(Lorg/bitspark/android/Spark;Ljava/lang/String;Ljava/lang/String;)Z

    .line 38
    .line 39
    .line 40
    return-void
.end method
