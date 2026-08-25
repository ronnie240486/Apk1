.class public final La3/c;
.super Ljava/lang/Object;
.source "MyApplication"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic a:I

.field public final b:Ljava/lang/Object;

.field public final synthetic c:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;Ljava/lang/Object;Z)V
    .locals 0

    .line 1
    iput p1, p0, La3/c;->a:I

    iput-object p2, p0, La3/c;->b:Ljava/lang/Object;

    iput-object p3, p0, La3/c;->c:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Lcom/google/android/material/behavior/SwipeDismissBehavior;Landroid/view/View;Z)V
    .locals 0

    const/4 p3, 0x1

    iput p3, p0, La3/c;->a:I

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La3/c;->c:Ljava/lang/Object;

    .line 4
    iput-object p2, p0, La3/c;->b:Ljava/lang/Object;

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 0

    .line 2
    iput p2, p0, La3/c;->a:I

    iput-object p1, p0, La3/c;->c:Ljava/lang/Object;

    iput-object p3, p0, La3/c;->b:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final a()V
    .locals 6

    .line 1
    :try_start_0
    invoke-static {}, Lcom/tencent/bugly/proguard/aq;->b()Lcom/tencent/bugly/proguard/aq;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    const-string v1, "Register broadcast receiver of Bugly."

    .line 10
    .line 11
    const/4 v2, 0x0

    .line 12
    new-array v2, v2, [Ljava/lang/Object;

    .line 13
    .line 14
    invoke-static {v0, v1, v2}, Lcom/tencent/bugly/proguard/al;->a(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Z

    .line 15
    .line 16
    .line 17
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    .line 18
    .line 19
    check-cast v0, Lcom/tencent/bugly/proguard/aq;

    .line 20
    .line 21
    monitor-enter v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 22
    :try_start_1
    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    .line 23
    .line 24
    check-cast v1, Lcom/tencent/bugly/proguard/aq;

    .line 25
    .line 26
    invoke-static {v1}, Lcom/tencent/bugly/proguard/aq;->b(Lcom/tencent/bugly/proguard/aq;)Landroid/content/Context;

    .line 27
    .line 28
    .line 29
    move-result-object v1

    .line 30
    invoke-static {}, Lcom/tencent/bugly/proguard/aq;->b()Lcom/tencent/bugly/proguard/aq;

    .line 31
    .line 32
    .line 33
    move-result-object v2

    .line 34
    iget-object v3, p0, La3/c;->c:Ljava/lang/Object;

    .line 35
    .line 36
    check-cast v3, Lcom/tencent/bugly/proguard/aq;

    .line 37
    .line 38
    invoke-static {v3}, Lcom/tencent/bugly/proguard/aq;->a(Lcom/tencent/bugly/proguard/aq;)Landroid/content/IntentFilter;

    .line 39
    .line 40
    .line 41
    move-result-object v3

    .line 42
    const-string v4, "com.tencent.bugly.BuglyBroadcastReceiver.permission"

    .line 43
    .line 44
    const/4 v5, 0x0

    .line 45
    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 46
    .line 47
    .line 48
    monitor-exit v0

    .line 49
    return-void

    .line 50
    :catchall_0
    move-exception v1

    .line 51
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 52
    :try_start_2
    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 53
    :catchall_1
    move-exception v0

    .line 54
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 55
    .line 56
    .line 57
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 13

    const/4 v0, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    iget v3, p0, La3/c;->a:I

    packed-switch v3, :pswitch_data_0

    .line 1
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lu4/d;

    iget-object v0, v0, Lu4/d;->b:Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;

    sget v1, Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;->n0:I

    .line 2
    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Lr4/f;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;->r(Lr4/f;)V

    return-void

    .line 3
    :pswitch_0
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lsa/p;

    iget-object v0, v0, Lsa/p;->m0:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 4
    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_0
    return-void

    .line 5
    :pswitch_1
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v1

    .line 6
    iget-object v3, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v3, Lsa/l;

    invoke-virtual {v3}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    move-result-object v4

    const/16 v5, 0x54

    invoke-static {v4, v5}, Ln5/d;->q(Landroid/content/Context;I)I

    move-result v4

    int-to-float v4, v4

    int-to-float v1, v1

    div-float/2addr v1, v4

    const/high16 v4, 0x40e00000    # 7.0f

    cmpl-float v4, v1, v4

    if-ltz v4, :cond_1

    const/4 v1, 0x7

    .line 7
    iput v1, v3, Lsa/l;->W:I

    goto :goto_0

    :cond_1
    float-to-int v1, v1

    .line 8
    iput v1, v3, Lsa/l;->W:I

    .line 9
    :goto_0
    iget v1, v3, Lsa/l;->W:I

    if-eqz v1, :cond_3

    .line 10
    iget-object v1, v3, Lsa/l;->V:Lta/a;

    invoke-virtual {v1}, Lta/a;->h()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 11
    new-instance v1, Landroidx/recyclerview/widget/GridLayoutManager;

    iget v4, v3, Lsa/l;->W:I

    invoke-direct {v1, v4}, Landroidx/recyclerview/widget/GridLayoutManager;-><init>(I)V

    .line 12
    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/x0;)V

    goto :goto_1

    .line 13
    :cond_2
    check-cast v0, Landroidx/leanback/widget/VerticalGridView;

    iget v1, v3, Lsa/l;->W:I

    invoke-virtual {v0, v1}, Landroidx/leanback/widget/VerticalGridView;->setNumColumns(I)V

    .line 14
    :cond_3
    :goto_1
    iget-object v0, v3, Lsa/l;->U:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    return-void

    .line 15
    :pswitch_2
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lp8/g;

    iget-object v0, v0, Lp8/a;->j:Lo9/d;

    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Lp8/f;

    invoke-virtual {v0, v1}, Lo9/d;->F(Li8/c;)V

    return-void

    .line 16
    :pswitch_3
    iget-object v3, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v3, Lp4/n;

    iget-object v3, v3, Lp4/n;->d:Lp4/o;

    sget-object v4, Lp4/o;->F:Lv4/b;

    .line 17
    iget-object v4, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v4, Lcom/google/android/gms/cast/internal/zza;

    iget-object v4, v4, Lcom/google/android/gms/cast/internal/zza;->a:Ljava/lang/String;

    .line 18
    iget-object v5, v3, Lp4/o;->t:Ljava/lang/String;

    .line 19
    invoke-static {v4, v5}, Lv4/a;->e(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_4

    iput-object v4, v3, Lp4/o;->t:Ljava/lang/String;

    const/4 v4, 0x1

    goto :goto_2

    :cond_4
    const/4 v4, 0x0

    .line 20
    :goto_2
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iget-boolean v6, v3, Lp4/o;->m:Z

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    new-array v0, v0, [Ljava/lang/Object;

    aput-object v5, v0, v2

    aput-object v6, v0, v1

    const-string v1, "hasChanged=%b, mFirstApplicationStatusUpdate=%b"

    .line 21
    sget-object v5, Lp4/o;->F:Lv4/b;

    invoke-virtual {v5, v1, v0}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, v3, Lp4/o;->C:Lcom/google/android/gms/internal/cast/k0;

    if-eqz v0, :cond_6

    if-nez v4, :cond_5

    iget-boolean v1, v3, Lp4/o;->m:Z

    if-eqz v1, :cond_6

    .line 22
    :cond_5
    invoke-virtual {v0}, Lcom/google/android/gms/internal/cast/k0;->g()V

    :cond_6
    iput-boolean v2, v3, Lp4/o;->m:Z

    return-void

    .line 23
    :pswitch_4
    iget-object v3, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v3, Lp4/n;

    iget-object v3, v3, Lp4/n;->d:Lp4/o;

    sget-object v4, Lp4/o;->F:Lv4/b;

    .line 24
    iget-object v4, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v4, Lcom/google/android/gms/cast/internal/zzac;

    iget-object v5, v4, Lcom/google/android/gms/cast/internal/zzac;->d:Lcom/google/android/gms/cast/ApplicationMetadata;

    .line 25
    iget-object v6, v3, Lp4/o;->s:Lcom/google/android/gms/cast/ApplicationMetadata;

    .line 26
    invoke-static {v5, v6}, Lv4/a;->e(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v6

    iget-object v7, v3, Lp4/o;->C:Lcom/google/android/gms/internal/cast/k0;

    if-nez v6, :cond_7

    iput-object v5, v3, Lp4/o;->s:Lcom/google/android/gms/cast/ApplicationMetadata;

    .line 27
    invoke-virtual {v7, v5}, Lcom/google/android/gms/internal/cast/k0;->e(Lcom/google/android/gms/cast/ApplicationMetadata;)V

    .line 28
    :cond_7
    iget-wide v5, v4, Lcom/google/android/gms/cast/internal/zzac;->a:D

    invoke-static {v5, v6}, Ljava/lang/Double;->isNaN(D)Z

    move-result v8

    if-nez v8, :cond_8

    iget-wide v8, v3, Lp4/o;->u:D

    sub-double v8, v5, v8

    invoke-static {v8, v9}, Ljava/lang/Math;->abs(D)D

    move-result-wide v8

    const-wide v10, 0x3e7ad7f29abcaf48L    # 1.0E-7

    cmpl-double v12, v8, v10

    if-lez v12, :cond_8

    iput-wide v5, v3, Lp4/o;->u:D

    const/4 v5, 0x1

    goto :goto_3

    :cond_8
    const/4 v5, 0x0

    .line 29
    :goto_3
    iget-boolean v6, v3, Lp4/o;->v:Z

    iget-boolean v8, v4, Lcom/google/android/gms/cast/internal/zzac;->b:Z

    if-eq v8, v6, :cond_9

    iput-boolean v8, v3, Lp4/o;->v:Z

    const/4 v5, 0x1

    .line 30
    :cond_9
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    iget-boolean v8, v3, Lp4/o;->l:Z

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    new-array v9, v0, [Ljava/lang/Object;

    aput-object v6, v9, v2

    aput-object v8, v9, v1

    .line 31
    sget-object v6, Lp4/o;->F:Lv4/b;

    const-string v8, "hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b"

    invoke-virtual {v6, v8, v9}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    if-eqz v7, :cond_b

    if-nez v5, :cond_a

    iget-boolean v5, v3, Lp4/o;->l:Z

    if-eqz v5, :cond_b

    .line 32
    :cond_a
    invoke-virtual {v7}, Lcom/google/android/gms/internal/cast/k0;->l()V

    .line 33
    :cond_b
    iget-wide v8, v4, Lcom/google/android/gms/cast/internal/zzac;->g:D

    invoke-static {v8, v9}, Ljava/lang/Double;->isNaN(D)Z

    .line 34
    iget v5, v3, Lp4/o;->w:I

    iget v8, v4, Lcom/google/android/gms/cast/internal/zzac;->c:I

    if-eq v8, v5, :cond_c

    iput v8, v3, Lp4/o;->w:I

    const/4 v5, 0x1

    goto :goto_4

    :cond_c
    const/4 v5, 0x0

    .line 35
    :goto_4
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    iget-boolean v9, v3, Lp4/o;->l:Z

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    new-array v10, v0, [Ljava/lang/Object;

    aput-object v8, v10, v2

    aput-object v9, v10, v1

    const-string v8, "hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b"

    .line 36
    invoke-virtual {v6, v8, v10}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    if-eqz v7, :cond_e

    if-nez v5, :cond_d

    iget-boolean v5, v3, Lp4/o;->l:Z

    if-eqz v5, :cond_e

    :cond_d
    iget v5, v3, Lp4/o;->w:I

    .line 37
    invoke-virtual {v7, v5}, Lcom/google/android/gms/internal/cast/k0;->a(I)V

    .line 38
    :cond_e
    iget v5, v3, Lp4/o;->x:I

    iget v8, v4, Lcom/google/android/gms/cast/internal/zzac;->e:I

    if-eq v8, v5, :cond_f

    iput v8, v3, Lp4/o;->x:I

    const/4 v5, 0x1

    goto :goto_5

    :cond_f
    const/4 v5, 0x0

    .line 39
    :goto_5
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    iget-boolean v9, v3, Lp4/o;->l:Z

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    new-array v0, v0, [Ljava/lang/Object;

    aput-object v8, v0, v2

    aput-object v9, v0, v1

    const-string v1, "hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b"

    .line 40
    invoke-virtual {v6, v1, v0}, Lv4/b;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    if-eqz v7, :cond_11

    if-nez v5, :cond_10

    iget-boolean v0, v3, Lp4/o;->l:Z

    if-eqz v0, :cond_11

    :cond_10
    iget v0, v3, Lp4/o;->x:I

    .line 41
    invoke-virtual {v7, v0}, Lcom/google/android/gms/internal/cast/k0;->j(I)V

    :cond_11
    iget-object v0, v3, Lp4/o;->y:Lcom/google/android/gms/cast/zzat;

    .line 42
    iget-object v1, v4, Lcom/google/android/gms/cast/internal/zzac;->f:Lcom/google/android/gms/cast/zzat;

    invoke-static {v0, v1}, Lv4/a;->e(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_12

    .line 43
    iput-object v1, v3, Lp4/o;->y:Lcom/google/android/gms/cast/zzat;

    :cond_12
    iput-boolean v2, v3, Lp4/o;->l:Z

    return-void

    .line 44
    :pswitch_5
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lfa/j0;

    iget-object v2, v0, Lfa/j0;->d:Landroidx/recyclerview/widget/k0;

    check-cast v2, Lma/a;

    iput-boolean v1, v2, Lma/a;->l:Z

    .line 45
    iget-object v2, v2, Lma/a;->f:Lna/a;

    if-eqz v2, :cond_13

    .line 46
    iget-object v3, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v3, Landroid/view/View;

    iget v0, v0, Lfa/j0;->b:I

    invoke-virtual {v2, v3, v0, v1}, Lna/a;->a(Landroid/view/View;IZ)V

    :cond_13
    return-void

    .line 47
    :pswitch_6
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;

    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v1, Lka/m0;

    invoke-static {v1, v0, v2, v2}, Lka/m0;->Q(Lka/m0;Landroidx/recyclerview/widget/RecyclerView;II)V

    return-void

    .line 48
    :pswitch_7
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lka/i0;

    iget-object v1, v0, Lka/i0;->g0:Landroidx/recyclerview/widget/RecyclerView;

    if-eqz v1, :cond_15

    .line 49
    iget-object v1, v0, Lka/i0;->U:Lta/a;

    .line 50
    iget-object v3, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v3, Lfa/m0;

    iget-object v3, v3, Lfa/m0;->d:Ljava/util/ArrayList;

    .line 51
    invoke-virtual {v1, v3}, Lta/a;->e(Ljava/util/ArrayList;)I

    move-result v1

    const/4 v3, -0x1

    if-ne v1, v3, :cond_14

    .line 52
    iget-object v0, v0, Lka/i0;->g0:Landroidx/recyclerview/widget/RecyclerView;

    .line 53
    invoke-static {v0, v2}, Lo9/d;->z(Landroidx/recyclerview/widget/RecyclerView;I)V

    goto :goto_6

    .line 54
    :cond_14
    iget-object v0, v0, Lka/i0;->g0:Landroidx/recyclerview/widget/RecyclerView;

    .line 55
    invoke-static {v0, v1}, Lo9/d;->z(Landroidx/recyclerview/widget/RecyclerView;I)V

    :cond_15
    :goto_6
    return-void

    .line 56
    :pswitch_8
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lka/f0;

    iget-object v1, v0, Lka/f0;->a:Lka/i0;

    invoke-virtual {v1}, Landroidx/fragment/app/s;->h()Landroidx/fragment/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/fragment/app/FragmentActivity;->k()Landroidx/fragment/app/k0;

    move-result-object v1

    iget-object v2, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroidx/fragment/app/j0;->z(Ljava/lang/String;)Landroidx/fragment/app/s;

    move-result-object v1

    check-cast v1, Lsa/l;

    if-eqz v1, :cond_16

    .line 57
    iget-object v0, v0, Lka/f0;->a:Lka/i0;

    invoke-virtual {v0, v2}, Lka/i0;->R(Ljava/lang/String;)V

    goto :goto_7

    .line 58
    :cond_16
    const-string v0, "2z/SOSdSnoDhFsQcJUuah/k=\n"

    const-string v1, "jVC2fUIm/+k=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "dROu8HErNefh/m8u6Xlt1r0=\n"

    const-string v2, "B2bAylHDin8=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 59
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_7
    return-void

    .line 60
    :pswitch_9
    invoke-static {}, Le3/v;->a()Le3/v;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 61
    invoke-static {}, Lr3/n;->a()V

    .line 62
    iget-object v0, v0, Le3/v;->d:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 63
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lk3/d;

    iget-object v0, v0, Lk3/d;->b:Lk3/e;

    iput-boolean v1, v0, Lk3/e;->b:Z

    .line 64
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lk3/d;

    iget-object v0, v0, Lk3/d;->a:Landroid/view/View;

    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Lk3/d;

    .line 65
    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 66
    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->removeOnDrawListener(Landroid/view/ViewTreeObserver$OnDrawListener;)V

    .line 67
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lk3/d;

    iget-object v0, v0, Lk3/d;->b:Lk3/e;

    iget-object v0, v0, Lk3/e;->a:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    return-void

    .line 68
    :pswitch_a
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Lk0/d;

    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Lk0/d;->accept(Ljava/lang/Object;)V

    return-void

    .line 69
    :pswitch_b
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, La0/b;

    iget-object v0, v0, La0/b;->b:Ljava/lang/Object;

    check-cast v0, Le0/b;

    if-eqz v0, :cond_17

    .line 70
    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v1, Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Le0/b;->j(Landroid/graphics/Typeface;)V

    :cond_17
    return-void

    .line 71
    :pswitch_c
    sget-object v0, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 72
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lorg/bitspark/android/Spark;

    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->l0(Landroid/os/Bundle;)V

    return-void

    .line 73
    :goto_8
    :pswitch_d
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lorg/bitspark/android/Spark;

    iget-object v3, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    iget-object v3, v3, Lta/a;->E:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v2, v3, :cond_19

    .line 74
    iget-object v3, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    iget-object v3, v3, Lta/a;->E:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/bitspark/android/beans/VodMenu;

    invoke-virtual {v3}, Lorg/bitspark/android/beans/VodMenu;->getName()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_18

    .line 75
    iget-object v1, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 76
    iput v2, v1, Lta/a;->x:I

    goto :goto_9

    :cond_18
    add-int/2addr v2, v1

    goto :goto_8

    .line 77
    :cond_19
    :goto_9
    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->d0()Z

    move-result v1

    if-eqz v1, :cond_1a

    .line 78
    iget-object v1, v0, Lorg/bitspark/android/Spark;->z0:Landroidx/leanback/widget/HorizontalGridView;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->i0:Lta/a;

    .line 79
    iget v0, v0, Lta/a;->x:I

    .line 80
    invoke-static {v1, v0}, Lo9/d;->z(Landroidx/recyclerview/widget/RecyclerView;I)V

    :cond_1a
    return-void

    .line 81
    :pswitch_e
    invoke-static {}, Lra/f;->b()Lra/f;

    move-result-object v0

    .line 82
    iget-object v0, v0, Lra/f;->e:Lorg/bitspark/android/beans/ChannelBean;

    .line 83
    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v1, Lorg/bitspark/android/Spark;

    if-eqz v0, :cond_1b

    invoke-virtual {v0}, Lorg/bitspark/android/beans/ChannelBean;->getLevel()I

    move-result v0

    const/16 v2, 0x12

    if-lt v0, v2, :cond_1b

    .line 84
    iget-object v0, v1, Lorg/bitspark/android/Spark;->r1:Landroid/widget/ProgressBar;

    const/16 v2, 0x64

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 85
    iget-object v0, v1, Lorg/bitspark/android/Spark;->r1:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setProgress(I)V

    goto :goto_a

    .line 86
    :cond_1b
    iget-object v0, v1, Lorg/bitspark/android/Spark;->r1:Landroid/widget/ProgressBar;

    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Long;

    invoke-static {v1}, Lorg/bitspark/android/utils/m;->j(Ljava/lang/Long;)J

    move-result-wide v1

    long-to-int v2, v1

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 87
    :goto_a
    sget-object v0, Lka/m0;->E0:Landroidx/mediarouter/app/c;

    const-wide/16 v1, 0x3e8

    invoke-virtual {v0, p0, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    .line 88
    :pswitch_f
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lea/k;

    iget-object v1, v0, Lea/k;->b:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->s0:Landroidx/media3/ui/SubtitleView;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout$LayoutParams;

    .line 89
    iget-object v2, v0, Lea/k;->b:Lorg/bitspark/android/Spark;

    const v3, 0x7f120025

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1c

    const/16 v2, 0x30

    .line 90
    iput v2, v1, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    goto :goto_b

    :cond_1c
    const/16 v2, 0x50

    .line 91
    iput v2, v1, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 92
    :goto_b
    iget-object v0, v0, Lea/k;->b:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->s0:Landroidx/media3/ui/SubtitleView;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    return-void

    .line 93
    :pswitch_10
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Landroid/content/Context;

    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v1, Lcom/tencent/bugly/BuglyStrategy;

    invoke-static {v0, v1}, Lcom/tencent/bugly/proguard/s;->b(Landroid/content/Context;Lcom/tencent/bugly/BuglyStrategy;)V

    return-void

    .line 94
    :pswitch_11
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lcom/tencent/bugly/proguard/k0;

    iget-object v0, v0, Lcom/tencent/bugly/proguard/k0;->b:Lcom/tencent/bugly/proguard/ay;

    iget-object v3, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v3, Ljava/lang/String;

    .line 95
    invoke-virtual {v0, v1}, Lcom/tencent/bugly/proguard/ay;->a(Z)Z

    move-result v4

    if-eqz v4, :cond_21

    .line 96
    :try_start_0
    const-string v4, "read trace first dump for create time!"

    new-array v5, v2, [Ljava/lang/Object;

    invoke-static {v4, v5}, Lcom/tencent/bugly/proguard/al;->c(Ljava/lang/String;[Ljava/lang/Object;)Z

    .line 97
    invoke-static {v3, v2}, Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper;->readFirstDumpInfo(Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;

    move-result-object v4

    const-wide/16 v5, -0x1

    if-eqz v4, :cond_1d

    .line 98
    iget-wide v7, v4, Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;->c:J

    goto :goto_c

    :catchall_0
    move-exception v0

    goto :goto_d

    :cond_1d
    move-wide v7, v5

    :goto_c
    cmp-long v4, v7, v5

    if-nez v4, :cond_1e

    .line 99
    const-string v4, "trace dump fail could not get time!"

    new-array v5, v2, [Ljava/lang/Object;

    invoke-static {v4, v5}, Lcom/tencent/bugly/proguard/al;->d(Ljava/lang/String;[Ljava/lang/Object;)Z

    .line 100
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    .line 101
    :cond_1e
    invoke-virtual {v0, v7, v8}, Lcom/tencent/bugly/proguard/ay;->a(J)Z

    move-result v4

    if-eqz v4, :cond_1f

    goto :goto_e

    .line 102
    :cond_1f
    invoke-virtual {v0, v7, v8, v3}, Lcom/tencent/bugly/proguard/ay;->a(JLjava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_e

    .line 103
    :goto_d
    invoke-static {v0}, Lcom/tencent/bugly/proguard/al;->a(Ljava/lang/Throwable;)Z

    move-result v3

    if-nez v3, :cond_20

    .line 104
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 105
    :cond_20
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->toString()Ljava/lang/String;

    move-result-object v0

    new-array v1, v1, [Ljava/lang/Object;

    aput-object v0, v1, v2

    const-string v0, "handle anr error %s"

    invoke-static {v0, v1}, Lcom/tencent/bugly/proguard/al;->e(Ljava/lang/String;[Ljava/lang/Object;)Z

    :cond_21
    :goto_e
    return-void

    .line 106
    :pswitch_12
    invoke-direct {p0}, La3/c;->a()V

    return-void

    .line 107
    :pswitch_13
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 108
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lcom/tencent/bugly/proguard/ai;

    invoke-static {v0}, Lcom/tencent/bugly/proguard/ai;->a(Lcom/tencent/bugly/proguard/ai;)Ljava/lang/Object;

    move-result-object v0

    monitor-enter v0

    .line 109
    :try_start_1
    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v1, Lcom/tencent/bugly/proguard/ai;

    invoke-static {v1}, Lcom/tencent/bugly/proguard/ai;->b(Lcom/tencent/bugly/proguard/ai;)I

    .line 110
    monitor-exit v0

    return-void

    :catchall_1
    move-exception v1

    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v1

    .line 111
    :pswitch_14
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/material/textfield/b;

    iget-object v0, v0, Lcom/google/android/material/textfield/b;->b:Lcom/google/android/material/textfield/n;

    check-cast v0, Lcom/google/android/material/textfield/q;

    .line 112
    iget-object v0, v0, Lcom/google/android/material/textfield/q;->e:Lcom/google/android/material/textfield/i;

    .line 113
    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    return-void

    .line 114
    :pswitch_15
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/material/textfield/b;

    iget-object v0, v0, Lcom/google/android/material/textfield/b;->b:Lcom/google/android/material/textfield/n;

    check-cast v0, Lcom/google/android/material/textfield/m;

    .line 115
    iget-object v0, v0, Lcom/google/android/material/textfield/m;->e:Lcom/google/android/material/textfield/i;

    .line 116
    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    return-void

    .line 117
    :pswitch_16
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->isPopupShowing()Z

    move-result v0

    .line 118
    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v1, Lcom/google/android/material/textfield/i;

    iget-object v2, v1, Lcom/google/android/material/textfield/i;->b:Lcom/google/android/material/textfield/n;

    check-cast v2, Lcom/google/android/material/textfield/m;

    .line 119
    invoke-virtual {v2, v0}, Lcom/google/android/material/textfield/m;->i(Z)V

    .line 120
    iget-object v1, v1, Lcom/google/android/material/textfield/i;->b:Lcom/google/android/material/textfield/n;

    check-cast v1, Lcom/google/android/material/textfield/m;

    .line 121
    iput-boolean v0, v1, Lcom/google/android/material/textfield/m;->l:Z

    return-void

    .line 122
    :pswitch_17
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/material/textfield/b;

    iget-object v2, v0, Lcom/google/android/material/textfield/b;->b:Lcom/google/android/material/textfield/n;

    check-cast v2, Lcom/google/android/material/textfield/e;

    .line 123
    iget-object v2, v2, Lcom/google/android/material/textfield/e;->e:Landroidx/appcompat/widget/p2;

    .line 124
    iget-object v3, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v3, Landroid/widget/EditText;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 125
    iget-object v0, v0, Lcom/google/android/material/textfield/b;->b:Lcom/google/android/material/textfield/n;

    check-cast v0, Lcom/google/android/material/textfield/e;

    invoke-virtual {v0, v1}, Lcom/google/android/material/textfield/e;->e(Z)V

    return-void

    .line 126
    :pswitch_18
    :try_start_2
    sget-object v3, Landroidx/core/app/e;->d:Ljava/lang/reflect/Method;
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    iget-object v4, p0, La3/c;->c:Ljava/lang/Object;

    iget-object v5, p0, La3/c;->b:Ljava/lang/Object;

    if-eqz v3, :cond_22

    const/4 v6, 0x3

    .line 127
    :try_start_3
    new-array v6, v6, [Ljava/lang/Object;

    aput-object v4, v6, v2

    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    aput-object v2, v6, v1

    const-string v1, "AppCompat recreation"

    aput-object v1, v6, v0

    .line 128
    invoke-virtual {v3, v5, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_11

    :catchall_2
    move-exception v0

    goto :goto_f

    :catch_0
    move-exception v0

    goto :goto_10

    .line 129
    :cond_22
    sget-object v3, Landroidx/core/app/e;->e:Ljava/lang/reflect/Method;

    .line 130
    new-array v0, v0, [Ljava/lang/Object;

    aput-object v4, v0, v2

    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    aput-object v2, v0, v1

    .line 131
    invoke-virtual {v3, v5, v0}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    goto :goto_11

    .line 132
    :goto_f
    const-string v1, "ActivityRecreator"

    const-string v2, "Exception while invoking performStopActivity"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_11

    .line 133
    :goto_10
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Ljava/lang/RuntimeException;

    if-ne v1, v2, :cond_24

    .line 134
    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_24

    .line 135
    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to stop"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_23

    goto :goto_11

    .line 136
    :cond_23
    throw v0

    :cond_24
    :goto_11
    return-void

    .line 137
    :pswitch_19
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Landroid/app/Application;

    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v1, Landroidx/core/app/d;

    invoke-virtual {v0, v1}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    return-void

    .line 138
    :pswitch_1a
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Landroidx/core/app/d;

    iget-object v1, p0, La3/c;->c:Ljava/lang/Object;

    iput-object v1, v0, Landroidx/core/app/d;->a:Ljava/lang/Object;

    return-void

    .line 139
    :pswitch_1b
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/material/behavior/SwipeDismissBehavior;

    iget-object v0, v0, Lcom/google/android/material/behavior/SwipeDismissBehavior;->a:Lv0/d;

    if-eqz v0, :cond_25

    invoke-virtual {v0}, Lv0/d;->g()Z

    move-result v0

    if-eqz v0, :cond_25

    .line 140
    sget-object v0, Ln0/s0;->a:Ljava/util/WeakHashMap;

    .line 141
    iget-object v0, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->postOnAnimation(Ljava/lang/Runnable;)V

    :cond_25
    return-void

    .line 142
    :pswitch_1c
    iget-object v0, p0, La3/c;->c:Ljava/lang/Object;

    check-cast v0, La3/d;

    iget-boolean v1, v0, La3/d;->d:Z

    if-eqz v1, :cond_26

    .line 143
    new-instance v1, Landroid/os/StrictMode$ThreadPolicy$Builder;

    invoke-direct {v1}, Landroid/os/StrictMode$ThreadPolicy$Builder;-><init>()V

    .line 144
    invoke-virtual {v1}, Landroid/os/StrictMode$ThreadPolicy$Builder;->detectNetwork()Landroid/os/StrictMode$ThreadPolicy$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/StrictMode$ThreadPolicy$Builder;->penaltyDeath()Landroid/os/StrictMode$ThreadPolicy$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/StrictMode$ThreadPolicy$Builder;->build()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v1

    .line 145
    invoke-static {v1}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    .line 146
    :cond_26
    :try_start_4
    iget-object v1, p0, La3/c;->b:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    goto :goto_12

    :catchall_3
    move-exception v1

    .line 147
    iget-object v0, v0, La3/d;->c:La3/e;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v0, 0x6

    .line 148
    const-string v2, "GlideExecutor"

    invoke-static {v2, v0}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_27

    .line 149
    const-string v0, "Request threw uncaught throwable"

    invoke-static {v2, v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_27
    :goto_12
    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
