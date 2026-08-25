.class public final Lea/u;
.super Landroid/os/Handler;
.source "MyApplication"


# instance fields
.field public final synthetic a:Lorg/bitspark/android/Spark;


# direct methods
.method public constructor <init>(Lorg/bitspark/android/Spark;Landroid/os/Looper;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 2
    .line 3
    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 4
    .line 5
    .line 6
    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 14

    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 1
    iget v2, p1, Landroid/os/Message;->what:I

    const/16 v3, 0x3c

    if-eq v2, v3, :cond_34

    const/16 v3, 0x3d

    if-eq v2, v3, :cond_33

    const/16 v3, 0x47

    if-eq v2, v3, :cond_32

    const/16 v3, 0x48

    if-eq v2, v3, :cond_31

    const/16 v3, 0x50

    if-eq v2, v3, :cond_30

    const/16 v3, 0x51

    if-eq v2, v3, :cond_2f

    const/16 v3, 0x5d

    const-wide/16 v4, 0x0

    if-eq v2, v3, :cond_2d

    const/16 v3, 0x5e

    if-eq v2, v3, :cond_2c

    const/16 v3, 0x82

    if-eq v2, v3, :cond_2a

    const/16 v3, 0x83

    if-eq v2, v3, :cond_27

    const/16 v3, 0xc9

    if-eq v2, v3, :cond_26

    const/16 v3, 0xca

    if-eq v2, v3, :cond_24

    const/16 v3, 0x270e

    if-eq v2, v3, :cond_23

    const/16 v3, 0x270f

    if-eq v2, v3, :cond_22

    packed-switch v2, :pswitch_data_0

    const-string v3, "o4CV5u23Dh8=\n"

    const-string v6, "z+/yj4M=\n"

    const-wide/16 v7, 0xa

    const-wide/16 v9, 0x64

    const/16 v11, 0x8c

    const/4 v12, -0x1

    const/16 v13, 0x8

    sparse-switch v2, :sswitch_data_0

    packed-switch v2, :pswitch_data_1

    packed-switch v2, :pswitch_data_2

    packed-switch v2, :pswitch_data_3

    packed-switch v2, :pswitch_data_4

    packed-switch v2, :pswitch_data_5

    packed-switch v2, :pswitch_data_6

    packed-switch v2, :pswitch_data_7

    goto/16 :goto_a

    .line 2
    :pswitch_0
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 3
    sget-object v0, Lorg/bitspark/android/Spark;->Y1:Lga/i;

    if-eqz v0, :cond_0

    .line 4
    sget-object v0, Lga/i;->e:Lorg/bitspark/android/utils/LimitQueue;

    invoke-virtual {v0}, Lorg/bitspark/android/utils/LimitQueue;->toArray()[Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lga/i;->c([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 5
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lorg/bitspark/android/Spark;->Y1:Lga/i;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 6
    sget-object v0, Lga/i;->f:Lorg/bitspark/android/utils/LimitQueue;

    invoke-virtual {v0}, Lorg/bitspark/android/utils/LimitQueue;->toArray()[Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lga/i;->c([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 7
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 8
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->D:Landroid/widget/RadioButton;

    const v1, 0x7f0b035b

    invoke-virtual {v0, v1}, Landroid/view/View;->setNextFocusRightId(I)V

    goto/16 :goto_a

    .line 9
    :cond_0
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->D:Landroid/widget/RadioButton;

    invoke-virtual {v0, v12}, Landroid/view/View;->setNextFocusRightId(I)V

    goto/16 :goto_a

    .line 10
    :pswitch_1
    const-string v1, "7j1CnrMv\n"

    const-string v2, "rG4P/9pBYa8=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "pxAuATmYUAfKMAs3Fqtqe6U2CCEHrHBpvjwTNQe9YGm+OhM=\n"

    const-string v3, "6nVdclj/NT0=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 11
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 12
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lorg/bitspark/android/Spark;->x0(Ljava/lang/Boolean;)V

    .line 13
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->G:Landroid/widget/RadioButton;

    invoke-static {v1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 14
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->G:Landroid/widget/RadioButton;

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    goto/16 :goto_a

    .line 15
    :pswitch_2
    const-string v1, "/FnMaYU7\n"

    const-string v2, "vgqBCOxVtUs=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "XQVIkAJ61jwwJW2mLUnsQF8jbrA8VfpVRC9pujxf5lJEL3U=\n"

    const-string v3, "EGA742MdswY=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 16
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lorg/bitspark/android/Spark;->x0(Ljava/lang/Boolean;)V

    .line 18
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->D:Landroid/widget/RadioButton;

    invoke-static {v1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 19
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->D:Landroid/widget/RadioButton;

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    goto/16 :goto_a

    .line 20
    :pswitch_3
    const-string v1, "JT3NymSi\n"

    const-string v2, "Z26Aqw3Mf/U=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "sEWSjKZrHnrdZbe6iVgkBrJjtKyYQDIWuH+jqpNYNA4=\n"

    const-string v3, "/SDh/8cMe0A=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 21
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->B:Landroid/widget/RadioButton;

    invoke-static {v1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 23
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->B:Landroid/widget/RadioButton;

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    goto/16 :goto_a

    .line 24
    :pswitch_4
    const-string v2, "RxxOdX1R\n"

    const-string v3, "BU8DFBQ/u10=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "NaiOuZFdZpRYiKuPvm5c6DeOqJmvfkboOZixnq93RuAt\n"

    const-string v4, "eM39yvA6A64=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-boolean v4, Lorg/bitspark/android/utils/m;->b:Z

    .line 25
    invoke-static {v2, v3}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    sput-boolean v0, Lorg/bitspark/android/Spark;->a2:Z

    .line 27
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 28
    iget-object v2, v2, Lorg/bitspark/android/Spark;->c0:Landroid/widget/TextView;

    .line 29
    invoke-virtual {v2, v13}, Landroid/view/View;->setVisibility(I)V

    .line 30
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 31
    invoke-virtual {v2}, Lorg/bitspark/android/Spark;->W()V

    .line 32
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v2, v2, Lorg/bitspark/android/Spark;->N:Lka/j;

    if-eqz v2, :cond_2

    .line 33
    iget-object v3, v2, Lka/j;->U:Landroid/view/View;

    if-nez v3, :cond_1

    goto :goto_0

    :cond_1
    const v4, 0x7f0b01e9

    .line 34
    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v13}, Landroid/view/View;->setVisibility(I)V

    .line 35
    iget-object v3, v2, Lka/j;->V:Lcom/youth/banner/Banner;

    invoke-virtual {v3, v0}, Landroid/view/View;->setFocusable(Z)V

    .line 36
    iget-object v2, v2, Lka/j;->V:Lcom/youth/banner/Banner;

    invoke-virtual {v2, v0}, Landroid/view/View;->setFocusableInTouchMode(Z)V

    .line 37
    :cond_2
    :goto_0
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 38
    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->g0(I)V

    goto/16 :goto_a

    .line 39
    :pswitch_5
    const-string v0, "RePDENMC\n"

    const-string v1, "B7COcbpsv1U=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "1tbmeUbXXqW79sNPaeRk2dTwwFl4437eyfDdVWXkdQ==\n"

    const-string v2, "m7OVCiewO58=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 40
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->o0()V

    goto/16 :goto_a

    .line 42
    :pswitch_6
    const-string v0, "RI4XagS0\n"

    const-string v1, "Bt1aC23aKfg=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "6EK6N75LSTmFYp8BkXhzRepknBeAf2lC92SBG5p4\n"

    const-string v2, "pSfJRN8sLAM=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 43
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->J:Lka/m0;

    iget-object v1, v0, Lka/m0;->W:Landroidx/recyclerview/widget/RecyclerView;

    if-eqz v1, :cond_35

    sget-boolean v1, Lka/m0;->G0:Z

    if-eqz v1, :cond_35

    .line 45
    iget-object v0, v0, Lka/m0;->m0:Landroid/widget/ImageButton;

    invoke-static {v0}, Lo9/d;->y(Landroid/view/View;)Z

    goto/16 :goto_a

    .line 46
    :pswitch_7
    const-string v1, "2+TKvdWN\n"

    const-string v2, "mbeH3LzjRW4=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "pkyIzkIuf9PLbK34bR1Fr6Rqru58CEq5uHa56HcdVac=\n"

    const-string v3, "6yn7vSNJGuk=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 47
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->F:Landroid/widget/RadioButton;

    invoke-static {v1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 49
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->F:Landroid/widget/RadioButton;

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    goto/16 :goto_a

    .line 50
    :pswitch_8
    const-string v1, "q+n7ys7s\n"

    const-string v2, "6bq2q6eCPMQ=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "2t/OiDCSJl+3/+u+H6EcI9j56KgOowwhyPjorwW6DQ==\n"

    const-string v3, "l7q9+1H1Q2U=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 51
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lorg/bitspark/android/Spark;->x0(Ljava/lang/Boolean;)V

    .line 53
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->C:Landroid/widget/RadioButton;

    invoke-static {v1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 54
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->C:Landroid/widget/RadioButton;

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    goto/16 :goto_a

    .line 55
    :pswitch_9
    const-string v1, "tu/EJ7oQ\n"

    const-string v2, "9LyJRtN+yUQ=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "kuvp/Y7vjeT/y8zLody3jZfBzdGizaaL\n"

    const-string v3, "346aju+I6N4=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 56
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v2, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 58
    invoke-virtual {v1, v0}, Lorg/bitspark/android/Spark;->M0(Z)V

    goto/16 :goto_a

    .line 59
    :pswitch_a
    const-string v0, "jQvDNG/r\n"

    const-string v2, "z1iOVQaFl2s=\n"

    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "uaMBPmuLqV7UgyQIRLiTLL2CNxJHqYIx\n"

    const-string v3, "9MZyTQrszGQ=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 60
    invoke-static {v0, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 62
    iget-object v0, v0, Lorg/bitspark/android/Spark;->p1:Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 63
    invoke-virtual {v0}, Landroid/view/View;->isShown()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 64
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->Z()V

    .line 65
    :cond_3
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 66
    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->M0(Z)V

    goto/16 :goto_a

    .line 67
    :pswitch_b
    const-string v2, "T3miKwFP\n"

    const-string v3, "DSrvSmghRTU=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "Id4jw9+sBHNM/gb18J8+GiT0B+/7mTMGPg==\n"

    const-string v4, "bLtQsL7LYUk=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-boolean v4, Lorg/bitspark/android/utils/m;->b:Z

    .line 68
    invoke-static {v2, v3}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v2}, Lorg/bitspark/android/Spark;->c0()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 70
    invoke-static {}, Lra/f;->b()Lra/f;

    move-result-object v2

    invoke-virtual {v2}, Lra/f;->c()Z

    move-result v2

    if-eqz v2, :cond_6

    sget-boolean v2, Lorg/bitspark/android/Spark;->g2:Z

    if-nez v2, :cond_6

    .line 71
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v2}, Lorg/bitspark/android/Spark;->Z()V

    .line 72
    invoke-static {}, Lra/f;->b()Lra/f;

    move-result-object v2

    invoke-virtual {v2}, Lra/f;->d()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 73
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->N(Lorg/bitspark/android/Spark;I)V

    .line 74
    invoke-static {}, Lra/f;->b()Lra/f;

    move-result-object v0

    invoke-virtual {v0}, Lra/f;->a()V

    goto/16 :goto_a

    .line 75
    :cond_4
    invoke-static {}, Lra/f;->b()Lra/f;

    move-result-object v2

    .line 76
    iget-object v3, v2, Lra/f;->e:Lorg/bitspark/android/beans/ChannelBean;

    if-eqz v3, :cond_35

    .line 77
    invoke-virtual {v2}, Lra/f;->d()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 78
    iput v1, v2, Lra/f;->f:I

    goto :goto_1

    .line 79
    :cond_5
    iget v1, v2, Lra/f;->f:I

    add-int/2addr v1, v0

    iput v1, v2, Lra/f;->f:I

    .line 80
    :goto_1
    iget-object v0, v2, Lra/f;->e:Lorg/bitspark/android/beans/ChannelBean;

    iget-boolean v1, v2, Lra/f;->g:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iget v3, v2, Lra/f;->f:I

    iget-object v4, v2, Lra/f;->l:Ljava/lang/String;

    invoke-virtual {v2, v0, v1, v3, v4}, Lra/f;->f(Lorg/bitspark/android/beans/ChannelBean;Ljava/lang/Boolean;ILjava/lang/String;)V

    goto/16 :goto_a

    .line 81
    :cond_6
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->N(Lorg/bitspark/android/Spark;I)V

    goto/16 :goto_a

    .line 82
    :cond_7
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->N(Lorg/bitspark/android/Spark;I)V

    goto/16 :goto_a

    .line 83
    :pswitch_c
    const-string v0, "nPDn1LHf\n"

    const-string v1, "3qOqtdixa6M=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "y1uhhgcFxoume4SwKDb84cp/i7A0PeD+y26esDIr7P8=\n"

    const-string v2, "hj7S9WZio7E=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 84
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 85
    :pswitch_d
    const-string v0, "eunFKR4v\n"

    const-string v1, "OLqISHdB/YY=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "vy6PQccS+YDSDqp36CHD6r4KpXf0Ks/usx+pYfk21Pu8DLl2\n"

    const-string v2, "8kv8MqZ1nLo=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 86
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 87
    :pswitch_e
    const-string v0, "5AtdjgK4\n"

    const-string v1, "plgQ72vWo80=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "ILtcEXCqxwJNm3knX5n9cCSaaj1Bn+17KI18PVOM8A==\n"

    const-string v2, "bd4vYhHNojg=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 88
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->Z()V

    goto/16 :goto_a

    .line 90
    :pswitch_f
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "0kUMsZupUHI=\n"

    const-string v3, "vyBixM/QIBc=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lea/d;->valueOf(Ljava/lang/String;)Lea/d;

    move-result-object v1

    iput-object v1, v0, Lorg/bitspark/android/Spark;->J0:Lea/d;

    goto/16 :goto_a

    .line 91
    :pswitch_10
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 92
    iget-object v2, v0, Lorg/bitspark/android/Spark;->b0:Landroid/widget/ImageView;

    .line 93
    new-instance v3, Lea/v;

    invoke-direct {v3, v0, v1}, Lea/v;-><init>(Lorg/bitspark/android/Spark;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 94
    const-string v0, "PzsPqOPW\n"

    const-string v1, "fWhCyYq4nC0=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "REeAz7//DmwpZ6X5kMw0BkVjquON3TkfTHE=\n"

    const-string v2, "CSLzvN6Ya1Y=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 95
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    .line 97
    iput-object v1, v0, Lorg/bitspark/android/Spark;->Y:Landroid/os/Bundle;

    .line 98
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 99
    iget-object v1, v0, Lorg/bitspark/android/Spark;->Y:Landroid/os/Bundle;

    .line 100
    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->F(Lorg/bitspark/android/Spark;Landroid/os/Bundle;)Z

    goto/16 :goto_a

    .line 101
    :pswitch_11
    const-string v1, "2w0x0Pzd\n"

    const-string v2, "mV58sZWz+Wc=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "C3LRNe5wOB1mUvQDwUMCdQNE9wvKSA1mCk7nFA==\n"

    const-string v3, "RheiRo8XXSc=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 102
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v6, 0xfa0

    add-long/2addr v2, v6

    .line 104
    iput-wide v2, v1, Lorg/bitspark/android/Spark;->i1:J

    .line 105
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 106
    sget v2, Lorg/bitspark/android/Spark;->m2:I

    .line 107
    iget-object v3, v1, Lorg/bitspark/android/Spark;->x:Ljava/lang/String;

    if-nez v2, :cond_9

    .line 108
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "E7LKaYozSv4ArtxuxyVj4UG+ymyLN2P7D7CD\n"

    const-string v6, "Yde5HOdWGpI=\n"

    invoke-static {v2, v6}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v2}, Lra/a;->isPlaying()Z

    move-result v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 109
    invoke-static {v3, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    iget-object v0, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v0}, Lra/a;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 111
    iget-object v0, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v0}, Lra/a;->c()V

    .line 112
    :cond_8
    iget-object v0, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    iget-object v2, v1, Lorg/bitspark/android/Spark;->Z:Ljava/lang/String;

    invoke-interface {v0, v2}, Lra/a;->h(Ljava/lang/String;)V

    .line 113
    iget-object v0, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v0}, Lra/a;->start()V

    .line 114
    iget-wide v6, v1, Lorg/bitspark/android/Spark;->G1:J

    cmp-long v0, v6, v4

    if-lez v0, :cond_35

    .line 115
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "k+sgNv0QZQWA9zYxsAZMGsH9Nib7VUEG2w==\n"

    const-string v4, "4Y5TQ5B1NWk=\n"

    invoke-static {v2, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v4, v1, Lorg/bitspark/android/Spark;->G1:J

    invoke-virtual {v0, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 116
    invoke-static {v3, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    iget-object v0, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    iget-wide v1, v1, Lorg/bitspark/android/Spark;->G1:J

    invoke-interface {v0, v1, v2}, Lra/a;->seekTo(J)V

    goto/16 :goto_a

    .line 118
    :cond_9
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "ZnAOoFtnwwd1bBinFmfrBDR8DqVaY+oCenJH\n"

    const-string v5, "FBV91TYCk2s=\n"

    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v4}, Lra/a;->isPlaying()Z

    move-result v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 119
    invoke-static {v3, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    iget-object v2, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v2, v0}, Lra/a;->setPlayWhenReady(Z)V

    .line 121
    invoke-virtual {v1, v0}, Lorg/bitspark/android/Spark;->j0(Z)V

    .line 122
    iget-object v0, v1, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v0}, Lra/a;->b()V

    goto/16 :goto_a

    .line 123
    :pswitch_12
    const-string v1, "qDG+zlZk\n"

    const-string v2, "6mLzrz8K9rU=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "4H53qlq3oWaNXlKcdYSbD/lUVIZrkYgF6Ek=\n"

    const-string v3, "rRsE2TvQxFw=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 124
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v1}, Lorg/bitspark/android/Spark;->t(Lorg/bitspark/android/Spark;)V

    .line 126
    sget-boolean v1, Lorg/bitspark/android/Spark;->a2:Z

    if-eqz v1, :cond_35

    .line 127
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 128
    invoke-virtual {v1, v0}, Lorg/bitspark/android/Spark;->M0(Z)V

    goto/16 :goto_a

    .line 129
    :pswitch_13
    const-string v0, "nm5SxiBu\n"

    const-string v1, "3D0fp0kAp8o=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "rkj/jbAULdLDaNq7nycXvqxp072ZMgampmHTup49DQ==\n"

    const-string v2, "4y2M/tFzSOg=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 130
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->e0()Z

    .line 132
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->J:Lka/m0;

    invoke-virtual {v0}, Lka/m0;->X()V

    .line 133
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v0, Lorg/bitspark/android/Spark;->J:Lka/m0;

    sget-object v1, Lea/d;->d:Lea/d;

    sput-object v1, Lka/m0;->F0:Lea/d;

    .line 134
    invoke-static {v0}, Lorg/bitspark/android/Spark;->B(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 135
    :pswitch_14
    const-string v0, "5LXB/m1D\n"

    const-string v2, "puaMnwQt4fE=\n"

    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "xx0Z70LvcbeqPTzZbdxLzsI5JNJmxEvI2Co=\n"

    const-string v3, "inhqnCOIFI0=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 136
    invoke-static {v0, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    const-string v2, "9oiU45k4P0ffiIzjljktXZGIkrGVIn8=\n"

    const-string v3, "se3gw/pQXik=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/bitspark/android/Spark;->I0(ILjava/lang/String;)V

    goto/16 :goto_a

    .line 138
    :pswitch_15
    sget-object v0, Lorg/bitspark/android/Spark;->Y1:Lga/i;

    if-nez v0, :cond_d

    .line 139
    new-instance v0, Lga/i;

    .line 140
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 141
    sget-object v2, Lorg/bitspark/android/Spark;->d2:Lda/c;

    const-string v3, "YU+gmojkihd5SaSGiPrS\n"

    const-string v4, "DSbW/9eM42Q=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lda/c;->b(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_a

    .line 142
    check-cast v2, Lorg/bitspark/android/utils/LimitQueue;

    sput-object v2, Lga/i;->e:Lorg/bitspark/android/utils/LimitQueue;

    goto :goto_2

    .line 143
    :cond_a
    new-instance v2, Lorg/bitspark/android/utils/LimitQueue;

    const/16 v3, 0x14

    invoke-direct {v2, v3}, Lorg/bitspark/android/utils/LimitQueue;-><init>(I)V

    sput-object v2, Lga/i;->e:Lorg/bitspark/android/utils/LimitQueue;

    .line 144
    :goto_2
    sget-object v2, Lorg/bitspark/android/Spark;->d2:Lda/c;

    const-string v3, "PqEHuzT8oxwnvBq7KqQ=\n"

    const-string v4, "SM5j5FyV0Gg=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lda/c;->b(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_b

    .line 145
    check-cast v2, Lorg/bitspark/android/utils/LimitQueue;

    sput-object v2, Lga/i;->f:Lorg/bitspark/android/utils/LimitQueue;

    goto :goto_3

    .line 146
    :cond_b
    new-instance v2, Lorg/bitspark/android/utils/LimitQueue;

    const/16 v3, 0x32

    invoke-direct {v2, v3}, Lorg/bitspark/android/utils/LimitQueue;-><init>(I)V

    sput-object v2, Lga/i;->f:Lorg/bitspark/android/utils/LimitQueue;

    .line 147
    :goto_3
    sget-object v2, Lorg/bitspark/android/Spark;->d2:Lda/c;

    const-string v3, "9U1Q7JXnBbb8Xl/si78=\n"

    const-string v4, "kywms/2OdsI=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lda/c;->b(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_c

    .line 148
    check-cast v2, Lorg/bitspark/android/utils/LimitQueue;

    sput-object v2, Lga/i;->g:Lorg/bitspark/android/utils/LimitQueue;

    goto :goto_4

    .line 149
    :cond_c
    new-instance v2, Lorg/bitspark/android/utils/LimitQueue;

    const/16 v3, 0x64

    invoke-direct {v2, v3}, Lorg/bitspark/android/utils/LimitQueue;-><init>(I)V

    sput-object v2, Lga/i;->g:Lorg/bitspark/android/utils/LimitQueue;

    .line 150
    :goto_4
    sput-object v0, Lorg/bitspark/android/Spark;->Y1:Lga/i;

    .line 151
    :cond_d
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->K:Lka/e;

    invoke-virtual {v0}, Lka/e;->Q()V

    .line 152
    const-string v0, "tMBmHe4W\n"

    const-string v2, "9pMrfId4/qY=\n"

    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "k82s3GqSIEP+7YnqRaEaOpbpkeFOuRo9keaa\n"

    const-string v3, "3qjfrwv1RXk=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 153
    invoke-static {v0, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    sput-boolean v1, Lorg/bitspark/android/Spark;->f2:Z

    .line 155
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->z(Lorg/bitspark/android/Spark;)V

    .line 156
    sget-object v0, Lorg/bitspark/android/Spark;->X1:Lea/u;

    const/16 v1, 0x13

    invoke-virtual {v0, v1, v7, v8}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 157
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->e0()Z

    goto/16 :goto_a

    .line 158
    :pswitch_16
    const-string v0, "zUs90Mzj\n"

    const-string v1, "jxhwsaWNiks=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "ao7pSWFYmpoHrsx/Tmug9mivxXlIfrHuYqfFfUVr\n"

    const-string v2, "J+uaOgA//6A=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 159
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    sget-boolean v0, Lea/h;->j:Z

    if-eqz v0, :cond_e

    sget-object v0, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    if-eqz v0, :cond_e

    iget-object v0, v0, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    if-eqz v0, :cond_e

    iget-boolean v0, v0, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->enabledVoD:Z

    if-eqz v0, :cond_e

    .line 161
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->A(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 162
    :cond_e
    sget-boolean v0, Lorg/bitspark/android/Spark;->f2:Z

    if-nez v0, :cond_35

    .line 163
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->B(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 164
    :pswitch_17
    const-string v0, "3a4ku9sv\n"

    const-string v2, "n/1p2rJBM6U=\n"

    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "2a1rKCl2Zji0jU4eBkVcQdyJVhUNXVxF0Zw=\n"

    const-string v3, "lMgYW0gRAwI=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 165
    invoke-static {v0, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->y(Lorg/bitspark/android/Spark;)V

    .line 167
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 168
    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->g0(I)V

    goto/16 :goto_a

    .line 169
    :pswitch_18
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0, p1}, Lorg/bitspark/android/Spark;->O0(Landroid/os/Message;)V

    goto/16 :goto_a

    .line 170
    :pswitch_19
    const-string v1, "fAk01xxn\n"

    const-string v2, "Plp5tnUJww4=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "LM7fa+TGrbZB7vpdy/WX2ijv6Vfa8ofeNeLiX9rigM0v7Olc\n"

    const-string v3, "YausGIWhyIw=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 171
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 172
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->J:Lka/m0;

    iget v2, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v1, v2}, Lka/m0;->e0(I)V

    .line 173
    sget-object v1, Lka/m0;->H0:Lc7/o;

    .line 174
    iget-object v1, v1, Lc7/o;->a:Lc7/b0;

    .line 175
    invoke-virtual {v1}, Lc7/b0;->clear()V

    .line 176
    sget-object v1, Lka/m0;->E0:Landroidx/mediarouter/app/c;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_a

    .line 177
    :pswitch_1a
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->N:Lka/j;

    .line 178
    iget-object v1, v0, Lka/j;->V:Lcom/youth/banner/Banner;

    if-eqz v1, :cond_f

    .line 179
    invoke-virtual {v0}, Lka/j;->S()V

    .line 180
    sget-object v0, Lea/h;->a:Ljava/lang/String;

    goto/16 :goto_a

    .line 181
    :cond_f
    sget-object v0, Lorg/bitspark/android/Spark;->X1:Lea/u;

    invoke-virtual {v0, v11, v9, v10}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_a

    .line 182
    :pswitch_1b
    const-string v0, "5UP1cqup\n"

    const-string v1, "pxC4E8LHa04=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "qh8saDaLffTHPwleGbhHiqI2HkIIpFGKoiUTVBmrR561PwxIEqhHnrU1GEkSv0uRsyw=\n"

    const-string v2, "53pfG1fsGM4=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 183
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 185
    iget-object v1, v0, Lorg/bitspark/android/Spark;->H1:Lea/g0;

    .line 186
    invoke-virtual {v1}, Lea/g0;->a()Z

    move-result v1

    if-eqz v1, :cond_10

    goto/16 :goto_a

    .line 187
    :cond_10
    iget-object v0, v0, Lorg/bitspark/android/Spark;->B1:Landroid/widget/TextView;

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_a

    .line 188
    :pswitch_1c
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->J:Lka/m0;

    invoke-virtual {v0}, Lka/m0;->c0()V

    goto/16 :goto_a

    .line 189
    :pswitch_1d
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v2, v1, Lorg/bitspark/android/Spark;->J:Lka/m0;

    iget-boolean v3, v2, Lka/m0;->r0:Z

    if-eqz v3, :cond_11

    .line 190
    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lorg/bitspark/android/Spark;->x0(Ljava/lang/Boolean;)V

    .line 191
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->C:Landroid/widget/RadioButton;

    invoke-static {v1}, Lo9/d;->y(Landroid/view/View;)Z

    .line 192
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v1, v1, Lorg/bitspark/android/Spark;->C:Landroid/widget/RadioButton;

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    goto/16 :goto_a

    .line 193
    :cond_11
    sget-boolean v0, Lka/m0;->G0:Z

    if-eqz v0, :cond_12

    .line 194
    iget-object v0, v2, Lka/m0;->j0:Landroid/widget/FrameLayout;

    invoke-static {v0}, Lo9/d;->y(Landroid/view/View;)Z

    goto/16 :goto_a

    .line 195
    :cond_12
    iget-object v0, v2, Lka/m0;->X:Landroidx/recyclerview/widget/RecyclerView;

    invoke-static {v0}, Lo9/d;->y(Landroid/view/View;)Z

    goto/16 :goto_a

    .line 196
    :sswitch_0
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 197
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 198
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/tvbus/engine/TVService;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Landroid/content/Context;->stopService(Landroid/content/Intent;)Z

    .line 199
    sget-boolean v0, Lea/h;->j:Z

    if-eqz v0, :cond_35

    .line 200
    invoke-static {}, Lio/binstream/libtvcar/Libtvcar;->release()V

    goto/16 :goto_a

    .line 201
    :sswitch_1
    const-string v1, "fZm+Mevy\n"

    const-string v2, "P8rzUIKc1UY=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ix2eWCAorYROK7lkERCY8i8hqHkeAIbhKyC9YhMK\n"

    const-string v3, "bnjtK0FPyL4=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 202
    invoke-static {v1, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v2, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 204
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 205
    new-instance v2, Lsa/k;

    invoke-direct {v2, v1}, Lsa/k;-><init>(Landroid/content/Context;)V

    const v3, 0x7f1200ea

    .line 206
    invoke-virtual {v1, v3}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    iput-object v3, v2, Lsa/k;->b:Ljava/lang/String;

    .line 207
    const-string v3, "Xs9GM+kTwXs=\n"

    const-string v4, "LKorWod3pAk=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 208
    iput-object v3, v2, Lsa/k;->c:Ljava/lang/String;

    const v3, 0x7f0f0016

    .line 209
    iput v3, v2, Lsa/k;->g:I

    .line 210
    invoke-virtual {v1}, Lorg/bitspark/android/Spark;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f1200f6

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 211
    invoke-virtual {v1}, Lorg/bitspark/android/Spark;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f1201d4

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 212
    new-instance v5, Lea/r;

    .line 213
    invoke-direct {v5, v0}, Lea/r;-><init>(I)V

    .line 214
    iput-object v3, v2, Lsa/k;->d:Ljava/lang/String;

    .line 215
    iput-object v5, v2, Lsa/k;->h:Landroid/content/DialogInterface$OnClickListener;

    .line 216
    new-instance v3, Lea/l;

    invoke-direct {v3, v1, v0}, Lea/l;-><init>(Lorg/bitspark/android/Spark;I)V

    .line 217
    iput-object v4, v2, Lsa/k;->e:Ljava/lang/String;

    .line 218
    iput-object v3, v2, Lsa/k;->i:Landroid/content/DialogInterface$OnClickListener;

    .line 219
    invoke-virtual {v2}, Lsa/k;->a()Lsa/e;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    goto/16 :goto_a

    .line 220
    :sswitch_2
    const-string v0, "KpuIf50a\n"

    const-string v1, "aMjFHvR0fNs=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "ke++sZYtRo/8z5uHuR58+JnZnoOwD3zwjtg=\n"

    const-string v2, "3IrNwvdKI7U=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 221
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 223
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 224
    new-instance v0, Lga/k;

    .line 225
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 226
    invoke-static {v6, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lga/k;->a(Ljava/lang/String;)V

    goto/16 :goto_a

    .line 227
    :sswitch_3
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->I:Lka/r;

    iget-object v0, v0, Lka/r;->Y:Lfa/d0;

    if-eqz v0, :cond_35

    .line 228
    iget-object v1, v0, Lfa/d0;->e:Landroid/view/View;

    if-eqz v1, :cond_35

    .line 229
    iget-object v0, v0, Lfa/d0;->d:Ljava/util/ArrayList;

    invoke-virtual {v1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 230
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v2, v2, Lorg/bitspark/android/Spark;->I:Lka/r;

    iget-object v2, v2, Lka/r;->Y:Lfa/d0;

    invoke-virtual {v2}, Landroidx/recyclerview/widget/k0;->notifyDataSetChanged()V

    .line 231
    new-instance v2, Landroidx/appcompat/widget/r0;

    const/4 v3, 0x5

    invoke-direct {v2, p0, v0, v1, v3}, Landroidx/appcompat/widget/r0;-><init>(Ljava/lang/Object;ILjava/lang/Object;I)V

    const-wide/16 v0, 0x1f4

    invoke-virtual {p0, v2, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_a

    .line 232
    :sswitch_4
    const-string v0, "qVqIOqZY\n"

    const-string v1, "6wnFW8825KQ=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "AsTKNlSd6QJv5O8Ae67Taxjo7QZ9pd9tDfXwEXm/\n"

    const-string v2, "T6G5RTX6jDg=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 233
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 234
    :sswitch_5
    const-string v0, "bnlg/OxJ\n"

    const-string v1, "LCotnYUnSys=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "Ka6iI2MGR8xEjocVTDV9tSiOkAJdNkOfEKK/N0UOVpk+rqM/Ug5RnxCivj4=\n"

    const-string v2, "ZMvRUAJhIvY=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 235
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 236
    :sswitch_6
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_35

    .line 237
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "GmH6sg==\n"

    const-string v2, "bgSCxgK8XVc=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 238
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_35

    .line 239
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget v2, p1, Landroid/os/Message;->arg2:I

    invoke-virtual {v1, v2, v0}, Lorg/bitspark/android/Spark;->I0(ILjava/lang/String;)V

    .line 240
    const-string v1, "fQs/jC6e\n"

    const-string v2, "P1hy7UfwH1c=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "OgIAWjcfUn5XIiVsGCxoEDgmIH0JNXIXJCY0bHZVFw==\n"

    const-string v4, "d2dzKVZ4N0Q=\n"

    .line 241
    invoke-static {v3, v4, v2, v0}, Lea/q;->j(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 242
    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 243
    invoke-static {v1, v0}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 244
    :sswitch_7
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->J:Lka/m0;

    iget-boolean v1, v0, Lka/m0;->r0:Z

    if-eqz v1, :cond_13

    .line 245
    iget-object v0, v0, Lka/m0;->W:Landroidx/recyclerview/widget/RecyclerView;

    invoke-static {v0}, Lo9/d;->y(Landroid/view/View;)Z

    goto/16 :goto_a

    .line 246
    :cond_13
    iget-object v0, v0, Lka/m0;->Y:Landroidx/recyclerview/widget/RecyclerView;

    invoke-static {v0}, Lo9/d;->y(Landroid/view/View;)Z

    goto/16 :goto_a

    .line 247
    :sswitch_8
    const-string v2, "0vguqzAD\n"

    const-string v3, "kKtjylltwgo=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "o1s3GTFKJtnOexIvHnkcsatyCysUchC6vWoBJw9vGry7bQE4\n"

    const-string v4, "7j5EalAtQ+M=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-boolean v4, Lorg/bitspark/android/utils/m;->b:Z

    .line 248
    invoke-static {v2, v3}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v2}, Lorg/bitspark/android/Spark;->t(Lorg/bitspark/android/Spark;)V

    .line 250
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 251
    invoke-virtual {v2, v0}, Lorg/bitspark/android/Spark;->M0(Z)V

    .line 252
    sput-boolean v1, Lorg/bitspark/android/Spark;->a2:Z

    .line 253
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->S()V

    goto/16 :goto_a

    .line 254
    :sswitch_9
    const-string v0, "qnYVb+WW\n"

    const-string v1, "6CVYDoz4la4=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "HMUDkfPciXhx5San3O+zDxTzI6PV/rMGHu41\n"

    const-string v2, "UaBw4pK77EI=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 255
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 257
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 258
    new-instance v0, Lga/k;

    .line 259
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 260
    invoke-static {v6, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lga/k;->a(Ljava/lang/String;)V

    goto/16 :goto_a

    .line 261
    :sswitch_a
    const-string v1, "c59ACCf5\n"

    const-string v2, "McwNaU6XFII=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ydi2gGA6riMM+JO2TwmUXHz6mqFEGo5N\n"

    const-string v3, "LL3F8wFdyxk=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    sput-boolean v0, Lorg/bitspark/android/Spark;->f2:Z

    .line 263
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->z(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 264
    :sswitch_b
    const-string v0, "Ng6x3yz0\n"

    const-string v2, "dF38vkWaexY=\n"

    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "D0lo1VO3BK5iaU3jfIQ+0RJrROJ9niQ=\n"

    const-string v3, "QiwbpjLQYZQ=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->e0()Z

    .line 266
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 267
    iget-object v0, v0, Lorg/bitspark/android/Spark;->P:Landroid/widget/FrameLayout;

    .line 268
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 269
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->I:Lka/r;

    invoke-virtual {v0}, Lka/r;->Z()V

    .line 270
    sget-boolean v0, Lorg/bitspark/android/Spark;->a2:Z

    if-nez v0, :cond_35

    .line 271
    sget-object v0, Lorg/bitspark/android/Spark;->X1:Lea/u;

    const/16 v1, 0x6e

    invoke-virtual {v0, v1, v7, v8}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_a

    .line 272
    :sswitch_c
    sput-boolean v1, Lorg/bitspark/android/Spark;->a2:Z

    .line 273
    const-string v2, "a1S2GMFe\n"

    const-string v3, "KQf7eagwDcM=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "+LMJx5+6TluVkyzxsIl0LfqRM/qhmWQv8A==\n"

    const-string v4, "tdZ6tP7dK2E=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    const-string v2, "5k7ZblEy/NTmV8JjWjfr\n"

    const-string v3, "tR6GJhh2uYs=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v12, v2}, Lorg/bitspark/android/utils/m;->f(ILjava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    if-ne v2, v12, :cond_15

    .line 275
    sget-boolean v2, Lea/h;->O:Z

    if-eqz v2, :cond_14

    const/4 v2, 0x0

    goto :goto_5

    :cond_14
    const/4 v2, 0x1

    .line 276
    :cond_15
    :goto_5
    const-string v3, "ZfcriSrooJRz+CCUP/s=\n"

    const-string v4, "Nqd0zW++6dc=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v12, v3}, Lorg/bitspark/android/utils/m;->f(ILjava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    .line 277
    iget-object v4, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v4, v4, Lorg/bitspark/android/Spark;->i0:Lta/a;

    iget-object v4, v4, Lta/a;->d:Landroidx/lifecycle/d0;

    invoke-virtual {v4, v3}, Landroidx/lifecycle/d0;->h(Ljava/lang/Object;)V

    .line 278
    iget-object v3, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v3, v3, Lorg/bitspark/android/Spark;->i0:Lta/a;

    iget-object v3, v3, Lta/a;->e:Landroidx/lifecycle/d0;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v2}, Landroidx/lifecycle/d0;->j(Ljava/lang/Object;)V

    .line 279
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v2}, Lorg/bitspark/android/Spark;->v(Lorg/bitspark/android/Spark;)V

    .line 280
    sget-boolean v2, Lea/h;->j:Z

    if-eqz v2, :cond_16

    .line 281
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v2}, Lorg/bitspark/android/Spark;->J0()V

    .line 282
    :cond_16
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v2, v1}, Lorg/bitspark/android/Spark;->k0(Z)V

    .line 283
    const-string v2, "DUUeLals\n"

    const-string v3, "TxZTTMAC5z0=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "false "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v4}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v4

    iget-object v4, v4, Lka/z;->X:Lorg/bitspark/android/view/MyViewPager;

    if-eqz v4, :cond_17

    goto :goto_6

    :cond_17
    const/4 v0, 0x0

    :goto_6
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 284
    sget-boolean v0, Lea/h;->H:Z

    if-eqz v0, :cond_19

    .line 285
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 286
    iget-object v0, v0, Lorg/bitspark/android/Spark;->P:Landroid/widget/FrameLayout;

    .line 287
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 288
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->y:Lorg/bitspark/android/view/MyViewPager;

    sget v2, Lea/g;->m:I

    invoke-virtual {v0, v2, v1}, Landroidx/viewpager/widget/ViewPager;->u(IZ)V

    .line 289
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->H:Landroid/widget/RadioButton;

    invoke-static {v0}, Lo9/d;->y(Landroid/view/View;)Z

    .line 290
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->N:Lka/j;

    .line 291
    iget-object v2, v0, Lka/j;->V:Lcom/youth/banner/Banner;

    if-eqz v2, :cond_18

    .line 292
    invoke-virtual {v0}, Lka/j;->S()V

    goto :goto_7

    .line 293
    :cond_18
    sget-object v0, Lorg/bitspark/android/Spark;->X1:Lea/u;

    invoke-virtual {v0, v11, v9, v10}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 294
    :cond_19
    :goto_7
    sget-object v0, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    if-eqz v0, :cond_1d

    iget-object v0, v0, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    if-eqz v0, :cond_1d

    .line 295
    iget-boolean v0, v0, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->enabledLive:Z

    if-nez v0, :cond_1a

    .line 296
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->B:Landroid/widget/RadioButton;

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    .line 297
    :cond_1a
    sget-object v0, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    iget-object v0, v0, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    iget-boolean v0, v0, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->enabledVoD:Z

    if-nez v0, :cond_1b

    .line 298
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->C:Landroid/widget/RadioButton;

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    .line 299
    :cond_1b
    sget-boolean v0, Lea/h;->B:Z

    if-eqz v0, :cond_1c

    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->D:Landroid/widget/RadioButton;

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    .line 300
    :cond_1c
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v2, Lga/m;->e:Lorg/bitspark/android/beans/AuthInfo;

    iget-object v2, v2, Lorg/bitspark/android/beans/AuthInfo;->service:Lorg/bitspark/android/beans/AuthInfo$ServiceBean;

    iget-object v2, v2, Lorg/bitspark/android/beans/AuthInfo$ServiceBean;->logo:Ljava/lang/String;

    invoke-static {v0, v2}, Lorg/bitspark/android/Spark;->w(Lorg/bitspark/android/Spark;Ljava/lang/String;)V

    .line 301
    sget-object v0, Lga/l;->k:Lga/l;

    invoke-static {v0}, Lga/m;->h(Lga/l;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1d

    .line 302
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1d

    .line 303
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v2, v0}, Lorg/bitspark/android/Spark;->x(Lorg/bitspark/android/Spark;Ljava/lang/String;)V

    .line 304
    :cond_1d
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->y(Lorg/bitspark/android/Spark;)V

    .line 305
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 306
    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->g0(I)V

    goto/16 :goto_a

    .line 307
    :pswitch_1e
    const-string v0, "R7mrK9c4\n"

    const-string v1, "BermSr5WrLc=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "+v+J0ShrGeOX36znB1gjiuLYt+sdUymK8si04wRJI4n2yan1Bl44\n"

    const-string v2, "t5r6okkMfNk=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->r(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 309
    :pswitch_1f
    const-string v0, "TZ0SvQjf\n"

    const-string v1, "D85f3GGxBu4=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "9hHK9bV4l1qbMe/DmkutMv4z8NWAWqA//zHvz5dauyTkMevU\n"

    const-string v2, "u3S5htQf8mA=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 310
    :pswitch_20
    const-string v0, "eBye+b+D\n"

    const-string v1, "Ok/TmNbtjUI=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "+KBj1QamIdOVgEbjKZUbu/CCWfUzhBa28YBG7ySEDa3qgV/oIg==\n"

    const-string v2, "tcUQpmfBROk=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 311
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->r(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 312
    :pswitch_21
    sput-boolean v0, Lorg/bitspark/android/Spark;->a2:Z

    .line 313
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 314
    iget-object v2, v2, Lorg/bitspark/android/Spark;->P:Landroid/widget/FrameLayout;

    .line 315
    invoke-virtual {v2, v1}, Landroid/view/View;->setVisibility(I)V

    .line 316
    const-string v2, "dUMY2yBA\n"

    const-string v3, "NxBVukkuoyE=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "IOY8/0JXMelNxhnJbWQLlCLXANN2eQufIsQGwg==\n"

    const-string v4, "bYNPjCMwVNM=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 317
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v2, v2, Lorg/bitspark/android/Spark;->y:Lorg/bitspark/android/view/MyViewPager;

    sget v3, Lea/g;->j:I

    invoke-virtual {v2, v3, v1}, Landroidx/viewpager/widget/ViewPager;->u(IZ)V

    .line 318
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v2, v2, Lorg/bitspark/android/Spark;->E:Landroid/widget/RadioButton;

    if-eqz v2, :cond_1e

    .line 319
    invoke-virtual {v2, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 320
    :cond_1e
    const-string v2, "8ppI7x1V\n"

    const-string v3, "sMkFjnQ7Y4Y=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "qbtnJfFikgqxrWwjmWWACK6eazLAQJIKubojatllnwH85Tx3\n"

    const-string v5, "3MgCV7cQ820=\n"

    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v4}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v4

    iget-object v4, v4, Lka/z;->X:Lorg/bitspark/android/view/MyViewPager;

    if-eqz v4, :cond_1f

    const/4 v4, 0x1

    goto :goto_8

    :cond_1f
    const/4 v4, 0x0

    :goto_8
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 321
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v2}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v2

    iget-object v2, v2, Lka/z;->X:Lorg/bitspark/android/view/MyViewPager;

    if-eqz v2, :cond_35

    .line 322
    sget-object v2, Lea/g;->a:Ljava/lang/String;

    const v3, -0xffff

    invoke-static {v3, v2}, Lorg/bitspark/android/utils/m;->f(ILjava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/16 v5, -0xc

    if-ne v4, v5, :cond_20

    .line 323
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v1}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v1

    iget-object v1, v1, Lka/z;->X:Lorg/bitspark/android/view/MyViewPager;

    invoke-virtual {v1, v0}, Landroidx/viewpager/widget/ViewPager;->setCurrentItem(I)V

    goto/16 :goto_a

    .line 324
    :cond_20
    invoke-static {v3, v2}, Lorg/bitspark/android/utils/m;->f(ILjava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-eqz v0, :cond_35

    .line 325
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v0

    iget-object v0, v0, Lka/z;->X:Lorg/bitspark/android/view/MyViewPager;

    invoke-virtual {v0, v1}, Landroidx/viewpager/widget/ViewPager;->setCurrentItem(I)V

    .line 326
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v0

    iget-object v0, v0, Lka/z;->V:Lla/d;

    invoke-virtual {v0}, Lla/d;->Q()V

    .line 327
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v0

    iget-object v0, v0, Lka/z;->V:Lla/d;

    invoke-virtual {v0}, Lla/d;->S()V

    .line 328
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v0

    iget-object v0, v0, Lka/z;->V:Lla/d;

    invoke-virtual {v0}, Lla/d;->R()V

    goto/16 :goto_a

    .line 329
    :pswitch_22
    const-string v0, "pWq2g3eI\n"

    const-string v1, "5zn74h7mVao=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "EiZF24jlsY9/BmDtp9aL5xoEf/u9x4bqGwZg4arH\n"

    const-string v2, "X0M2qOmC1LU=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 330
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 331
    iget-object v1, v0, Lorg/bitspark/android/Spark;->T:Lga/m;

    if-nez v1, :cond_21

    .line 332
    new-instance v1, Lga/m;

    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-direct {v1, v2}, Lga/m;-><init>(Landroid/content/Context;)V

    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->q(Lorg/bitspark/android/Spark;Lga/m;)V

    .line 333
    :cond_21
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 334
    iget-object v0, v0, Lorg/bitspark/android/Spark;->T:Lga/m;

    .line 335
    invoke-virtual {v0}, Lga/m;->g()V

    goto/16 :goto_a

    .line 336
    :pswitch_23
    const-string v0, "fiBiGdGf\n"

    const-string v1, "PHMveLjxFvk=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "I/QI+XgGRBJO1C3PVzV+aybUOMFGL2R8Od4pwUYlbmYr\n"

    const-string v2, "bpF7ihlhISg=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 337
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->r(Lorg/bitspark/android/Spark;)V

    .line 338
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->s(Lorg/bitspark/android/Spark;)V

    .line 339
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->e0()Z

    goto/16 :goto_a

    .line 340
    :pswitch_24
    const-string v0, "fPVC5RYM\n"

    const-string v1, "PqYPhH9iZ04=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "Sp1Zk3FWN0AnvXylXmUNOU+9aatPfxcuULd4qw==\n"

    const-string v2, "B/gq4BAxUno=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 341
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->S()V

    goto/16 :goto_a

    .line 342
    :cond_22
    const-string v0, "Uvw8KRzv\n"

    const-string v1, "EK9xSHWBdvg=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "vURvUvJmg+7QZERox161jaN1WWw=\n"

    const-string v2, "8CEcIZMB5tQ=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-boolean v2, Lorg/bitspark/android/utils/m;->b:Z

    .line 343
    invoke-static {v0, v1}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 344
    invoke-static {}, Lra/f;->b()Lra/f;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 345
    new-instance v1, Ll7/k;

    invoke-direct {v1}, Ll7/k;-><init>()V

    iget-object v2, v0, Lra/f;->c:Ljava/util/HashMap;

    invoke-virtual {v1, v2}, Ll7/k;->e(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 346
    iget-object v0, v0, Lra/f;->a:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->n(Ljava/lang/String;Ljava/lang/String;)V

    .line 347
    invoke-static {}, Lra/f;->b()Lra/f;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 348
    new-instance v1, Ll7/k;

    invoke-direct {v1}, Ll7/k;-><init>()V

    iget-object v2, v0, Lra/f;->d:Ljava/util/HashMap;

    invoke-virtual {v1, v2}, Ll7/k;->e(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 349
    iget-object v0, v0, Lra/f;->b:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->n(Ljava/lang/String;Ljava/lang/String;)V

    .line 350
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    sget-object v1, Lorg/bitspark/android/Spark;->X1:Lea/u;

    .line 351
    invoke-virtual {v0}, Lorg/bitspark/android/Spark;->m0()V

    goto/16 :goto_a

    .line 352
    :cond_23
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "GnOR7/M53g==\n"

    const-string v3, "dxbinJJeu1U=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 353
    new-instance v2, Lsa/d;

    iget-object v3, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-direct {v2, v3}, Lsa/d;-><init>(Landroid/content/Context;)V

    .line 354
    iput-object v0, v2, Lsa/d;->b:Ljava/lang/String;

    .line 355
    invoke-virtual {v3}, Lorg/bitspark/android/Spark;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f1201c4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 356
    new-instance v4, Lea/r;

    .line 357
    invoke-direct {v4, v1}, Lea/r;-><init>(I)V

    .line 358
    iput-object v3, v2, Lsa/d;->c:Ljava/lang/String;

    .line 359
    iput-object v4, v2, Lsa/d;->f:Landroid/content/DialogInterface$OnClickListener;

    .line 360
    invoke-virtual {v2}, Lsa/d;->a()Lsa/e;

    move-result-object v3

    .line 361
    invoke-virtual {v3}, Landroid/app/Dialog;->show()V

    .line 362
    new-instance v4, Lea/s;

    invoke-direct {v4, v0, v2, v3}, Lea/s;-><init>(Ljava/lang/String;Lsa/d;Lsa/e;)V

    .line 363
    invoke-virtual {v4}, Landroid/os/CountDownTimer;->start()Landroid/os/CountDownTimer;

    .line 364
    new-instance v0, Lea/t;

    invoke-direct {v0, v1, v4}, Lea/t;-><init>(ILjava/lang/Object;)V

    invoke-virtual {v3, v0}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    goto/16 :goto_a

    .line 365
    :cond_24
    const-string v0, "wR/RQeYR\n"

    const-string v2, "g0ycII9/ibs=\n"

    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "Z/IIYF4L0ugK0i1WcTjohmXIK19+NeiBY9MkUHct+Zxv2w==\n"

    const-string v3, "Kpd7Ez9st9I=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-boolean v3, Lorg/bitspark/android/utils/m;->b:Z

    .line 366
    invoke-static {v0, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 367
    const-string v0, "yXAw8XmO\n"

    const-string v2, "iyN9kBDgyoE=\n"

    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "odeNi0eGkBCm0cnB\n"

    const-string v4, "1bit+yvn6TA=\n"

    invoke-static {v3, v4}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget v3, v3, Lorg/bitspark/android/Spark;->d0:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 368
    invoke-static {v0, v2}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 369
    sget-object v0, Lga/d;->e:Ljava/util/HashMap;

    if-eqz v0, :cond_35

    .line 370
    sget-object v0, Lga/d;->e:Ljava/util/HashMap;

    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget v2, v2, Lorg/bitspark/android/Spark;->d0:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/bitspark/android/beans/ChannelBean;

    if-eqz v0, :cond_25

    .line 371
    const-string v2, "01Xwtgm9\n"

    const-string v3, "kQa912DT354=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "SRxlFA==\n"

    const-string v5, "OnUBLtDEy0g=\n"

    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget v4, v4, Lorg/bitspark/android/Spark;->d0:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v4, "mC7/08kCVWrWZ/KOgQVUcd1v6A==\n"

    const-string v5, "uAPS7elkOh8=\n"

    invoke-static {v4, v5}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Lorg/bitspark/android/beans/ChannelBean;->getChid()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 372
    invoke-static {v2, v3}, Lcom/tencent/mars/xlog/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 373
    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v2, v2, Lorg/bitspark/android/Spark;->I:Lka/r;

    invoke-virtual {v2, v0}, Lka/r;->b0(Lorg/bitspark/android/beans/ChannelBean;)V

    .line 374
    :cond_25
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iput v1, v0, Lorg/bitspark/android/Spark;->d0:I

    goto/16 :goto_a

    .line 375
    :cond_26
    const-string v0, "MHceV+Jv\n"

    const-string v1, "ciRTNosBIe0=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    const-string v0, "tGkxY1MbrrLZSRRVfCiUy7FJAVttLIfJoEkQ\n"

    const-string v1, "+QxCEDJ8y4g=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 376
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->C(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 377
    :cond_27
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->J:Lka/m0;

    if-eqz v0, :cond_29

    .line 378
    iget v2, p1, Landroid/os/Message;->arg1:I

    .line 379
    sget-boolean v3, Lka/m0;->G0:Z

    if-eqz v3, :cond_28

    .line 380
    invoke-virtual {v0}, Lka/m0;->S()V

    .line 381
    :cond_28
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->J:Lka/m0;

    invoke-virtual {v0, v2}, Lka/m0;->U(I)V

    .line 382
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v2, v0, Lorg/bitspark/android/Spark;->C:Landroid/widget/RadioButton;

    invoke-virtual {v0, v2}, Lorg/bitspark/android/Spark;->A0(Landroid/widget/RadioButton;)V

    .line 383
    :cond_29
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 384
    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->g0(I)V

    goto/16 :goto_a

    .line 385
    :cond_2a
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->I:Lka/r;

    if-eqz v0, :cond_2b

    .line 386
    iget v2, p1, Landroid/os/Message;->arg1:I

    .line 387
    invoke-virtual {v0, v2}, Lka/r;->V(I)V

    .line 388
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v2, v0, Lorg/bitspark/android/Spark;->B:Landroid/widget/RadioButton;

    invoke-virtual {v0, v2}, Lorg/bitspark/android/Spark;->A0(Landroid/widget/RadioButton;)V

    .line 389
    :cond_2b
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 390
    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->g0(I)V

    goto/16 :goto_a

    .line 391
    :cond_2c
    const-string v0, "4t2E22U5\n"

    const-string v1, "oI7JugxX6zk=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "BqHyFGlhubJrgdciRlKDzgqAxChdUoPBBYLO\n"

    const-string v2, "S8SBZwgG3Ig=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 392
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->O(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 393
    :cond_2d
    const-string v0, "CsnESfJK\n"

    const-string v1, "SJqJKJskuLI=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "xmvcHEWV+uyrS/kqaqbAhc5L5DtrrduTx1ru\n"

    const-string v2, "iw6vbyTyn9Y=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 394
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v0}, Lra/a;->getCurrentPosition()J

    move-result-wide v0

    iget v2, p1, Landroid/os/Message;->arg1:I

    mul-int/lit16 v2, v2, 0x3e8

    int-to-long v2, v2

    add-long/2addr v0, v2

    cmp-long v2, v0, v4

    if-gez v2, :cond_2e

    goto :goto_9

    :cond_2e
    move-wide v4, v0

    .line 395
    :goto_9
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    iget-object v0, v0, Lorg/bitspark/android/Spark;->L1:Lra/a;

    invoke-interface {v0, v4, v5}, Lra/a;->seekTo(J)V

    .line 396
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->P(Lorg/bitspark/android/Spark;)V

    goto/16 :goto_a

    .line 397
    :cond_2f
    const-string v0, "dFWY04t5\n"

    const-string v1, "NgbVsuIXTGw=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "8oQrx/n3niCfpA7x1sSkSfq1B+LR1L5V4LEZ4NDPr1XgsRT1wdWp\n"

    const-string v2, "v+FYtJiQ+xo=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 398
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "3vLQharzEvrA\n"

    const-string v3, "qJu04MWjc44=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->G(Lorg/bitspark/android/Spark;Ljava/lang/String;)V

    .line 399
    const-string v0, "76nbyB2A\n"

    const-string v1, "rfqWqXTuddc=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "c0qRwmcBsEN5W4bfUg6wfSo=\n"

    const-string v3, "ED/jsAJvxBU=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 400
    iget-object v2, v2, Lorg/bitspark/android/Spark;->Z:Ljava/lang/String;

    .line 401
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 402
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 403
    iget-object v1, v0, Lorg/bitspark/android/Spark;->Z:Ljava/lang/String;

    .line 404
    invoke-static {v0, v1}, Lorg/bitspark/android/Spark;->H(Lorg/bitspark/android/Spark;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 405
    :cond_30
    invoke-static {}, Lorg/bitspark/android/utils/b;->d()Lorg/bitspark/android/utils/b;

    move-result-object v0

    invoke-virtual {v0}, Lorg/bitspark/android/utils/b;->f()V

    .line 406
    const-string v0, "tGEgDJmt\n"

    const-string v2, "9jJtbfDDsyI=\n"

    invoke-static {v0, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "rHfEexz9QBnBV+FNM856c61T7lcr02Fmrg==\n"

    const-string v3, "4RK3CH2aJSM=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 407
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    const/4 v2, 0x0

    .line 408
    iput-object v2, v0, Lorg/bitspark/android/Spark;->Y:Landroid/os/Bundle;

    .line 409
    iput-boolean v1, v0, Lorg/bitspark/android/Spark;->G0:Z

    .line 410
    iget-object v2, v0, Lorg/bitspark/android/Spark;->b0:Landroid/widget/ImageView;

    new-instance v3, Lea/v;

    invoke-direct {v3, v0, v1}, Lea/v;-><init>(Lorg/bitspark/android/Spark;I)V

    invoke-virtual {v2, v3}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 411
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    invoke-static {v0, v2}, Lorg/bitspark/android/Spark;->E(Lorg/bitspark/android/Spark;Landroid/os/Bundle;)V

    .line 412
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 413
    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->g0(I)V

    goto/16 :goto_a

    .line 414
    :cond_31
    const-string v0, "cOOWjl5h\n"

    const-string v1, "MrDb7zcP86o=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "qevssx1o7b/Ey8mFMlvX0LTK3pQ5UMzKs8DTjz1L19el2to=\n"

    const-string v2, "5I6fwHwPiIU=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 415
    iget v0, p1, Landroid/os/Message;->arg1:I

    .line 416
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v1}, Lorg/bitspark/android/Spark;->M(Lorg/bitspark/android/Spark;)Lorg/bitspark/android/Constants$VIDEO_TYPE;

    move-result-object v1

    sget-object v2, Lorg/bitspark/android/Constants$VIDEO_TYPE;->STATIC:Lorg/bitspark/android/Constants$VIDEO_TYPE;

    if-ne v1, v2, :cond_35

    .line 417
    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    int-to-long v2, v0

    invoke-static {v2, v3}, Lorg/bitspark/android/utils/m;->b(J)Ljava/lang/String;

    move-result-object v0

    .line 418
    invoke-virtual {v1, v0}, Lorg/bitspark/android/Spark;->u0(Ljava/lang/String;)V

    goto/16 :goto_a

    .line 419
    :cond_32
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->I(Lorg/bitspark/android/Spark;)Landroid/widget/SeekBar;

    move-result-object v0

    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 420
    iget v1, v1, Lorg/bitspark/android/Spark;->e1:I

    .line 421
    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 422
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->J(Lorg/bitspark/android/Spark;)Landroid/widget/SeekBar;

    move-result-object v0

    iget-object v1, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 423
    iget v1, v1, Lorg/bitspark/android/Spark;->e1:I

    .line 424
    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 425
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->K(Lorg/bitspark/android/Spark;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    .line 426
    iget v2, v2, Lorg/bitspark/android/Spark;->e1:I

    .line 427
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, "InfpBw==\n"

    const-string v3, "DUbZN7XgE4s=\n"

    invoke-static {v2, v3}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 428
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->L(Lorg/bitspark/android/Spark;)I

    move-result v1

    int-to-long v1, v1

    invoke-static {v1, v2}, Lorg/bitspark/android/utils/m;->b(J)Ljava/lang/String;

    move-result-object v1

    .line 429
    invoke-virtual {v0, v1}, Lorg/bitspark/android/Spark;->u0(Ljava/lang/String;)V

    goto :goto_a

    .line 430
    :cond_33
    const-string v0, "8KZO1+dB\n"

    const-string v1, "svUDto4vvhM=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "YV/fN7bVl/YMf/oBmeatmXx+7RCS7beefg==\n"

    const-string v2, "LDqsRNey8sw=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 431
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v0

    iget-object v0, v0, Lka/z;->W:Lla/e;

    if-eqz v0, :cond_35

    .line 432
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v0

    iget-object v0, v0, Lka/z;->W:Lla/e;

    invoke-virtual {v0}, Lla/e;->Q()V

    goto :goto_a

    .line 433
    :cond_34
    const-string v0, "lva7xpgv\n"

    const-string v1, "1KX2p/FB6GA=\n"

    invoke-static {v0, v1}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "x5g3FbhDCXequBIjl3AzGNq5BTKceygCxLg=\n"

    const-string v2, "iv1EZtkkbE0=\n"

    invoke-static {v1, v2}, La2/a;->s(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/bitspark/android/utils/m;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 434
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->D(Lorg/bitspark/android/Spark;)V

    .line 435
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v0

    iget-object v0, v0, Lka/z;->W:Lla/e;

    if-eqz v0, :cond_35

    .line 436
    iget-object v0, p0, Lea/u;->a:Lorg/bitspark/android/Spark;

    invoke-static {v0}, Lorg/bitspark/android/Spark;->u(Lorg/bitspark/android/Spark;)Lka/z;

    move-result-object v0

    iget-object v0, v0, Lka/z;->W:Lla/e;

    invoke-virtual {v0}, Lla/e;->Q()V

    .line 437
    :cond_35
    :goto_a
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x7
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
    .end packed-switch

    :sswitch_data_0
    .sparse-switch
        0xf -> :sswitch_c
        0x1e -> :sswitch_b
        0x20 -> :sswitch_a
        0x32 -> :sswitch_9
        0x4b -> :sswitch_8
        0x90 -> :sswitch_7
        0xfa -> :sswitch_6
        0x104 -> :sswitch_5
        0x10e -> :sswitch_4
        0x12d -> :sswitch_3
        0x28b -> :sswitch_2
        0x3e8 -> :sswitch_1
        0x2706 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x78
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x8c
        :pswitch_1a
        :pswitch_19
        :pswitch_18
    .end packed-switch

    :pswitch_data_3
    .packed-switch 0x12
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
    .end packed-switch

    :pswitch_data_4
    .packed-switch 0x53
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
    .end packed-switch

    :pswitch_data_5
    .packed-switch 0x60
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
    .end packed-switch

    :pswitch_data_6
    .packed-switch 0x69
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
    .end packed-switch

    :pswitch_data_7
    .packed-switch 0x6e
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
