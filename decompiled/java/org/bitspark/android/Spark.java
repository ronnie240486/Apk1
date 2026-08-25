package org.bitspark.android;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.leanback.widget.HorizontalGridView;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.p011ui.PlayerView;
import androidx.media3.p011ui.SubtitleView;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.RecyclerView;
import ba.C1371d;
import com.nmmedit.protect.NativeUtil;
import com.tvbus.engine.TVCore;
import ga.C2619b;
import ga.C2621d;
import ga.C2625h;
import ga.C2626i;
import ga.C2630m;
import ga.C2632o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.OkHttpClient;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.view.AutoLayoutRadioGroup;
import org.bitspark.android.view.CircularProgressBar;
import org.bitspark.android.view.MyViewPager;
import org.greenrobot.eventbus.ThreadMode;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p044da.C2340c;
import p055ea.AbstractC2442h;
import p055ea.C2441g0;
import p055ea.C2446j;
import p055ea.C2448k;
import p055ea.C2459p0;
import p055ea.C2463r0;
import p055ea.C2465s0;
import p055ea.C2467t0;
import p055ea.C2469u0;
import p055ea.C2471v0;
import p055ea.C2473w0;
import p055ea.EnumC2434d;
import p055ea.HandlerC2468u;
import p055ea.RunnableC2470v;
import p063fa.C2511b1;
import p063fa.C2544m1;
import p063fa.C2550o1;
import p063fa.C2568x;
import p063fa.C2570y;
import p116ka.ViewOnKeyListenerC2915e;
import p116ka.ViewOnKeyListenerC2925j;
import p116ka.ViewOnKeyListenerC2932m0;
import p116ka.ViewOnKeyListenerC2937r;
import p116ka.ViewOnKeyListenerC2944y;
import p116ka.ViewOnTouchListenerC2945z;
import p193ra.C3659b;
import p193ra.C3660c;
import p193ra.CountDownTimerC3662e;
import p193ra.InterfaceC3658a;
import p214ta.C3877a;
import qa.C3559g;
import ua.InterfaceC3949j;

@UnstableApi
public class Spark extends AppCompatActivity implements View.OnKeyListener, View.OnClickListener, View.OnTouchListener, View.OnFocusChangeListener {

    public static HandlerC2468u f11002X1;

    public static C2626i f11003Y1;

    public static DisplayMetrics f11004Z1;

    public static boolean f11005a2;

    public static int f11006b2;

    public static boolean f11007c2;

    public static C2340c f11008d2;

    public static boolean f11009e2;

    public static boolean f11010f2;

    public static boolean f11011g2;

    public static String f11012h2;

    public static int f11013i2;

    public static boolean f11014j2;

    public static VideoView f11015k2;

    public static int f11016l2;

    public static int f11017m2;

    public static final String f11018n2;

    public static final String f11019o2;

    public static final String f11020p2;

    public static final String f11021q2;

    public static final String f11022r2;

    public static final String f11023s2;

    public static final String f11024t2;

    public static final String f11025u2;

    public static final String f11026v2;

    public static final String f11027w2;

    public static final String f11028x2;

    public static C1371d f11029y2;

    public ArrayList f11030A;

    public HorizontalGridView f11031A0;

    public SeekBar f11032A1;

    public RadioButton f11033B;

    public HorizontalGridView f11034B0;

    public TextView f11035B1;

    public RadioButton f11036C;

    public ImageView f11037C0;

    public TextView f11038C1;

    public RadioButton f11039D;

    public ImageView f11040D0;

    public TextView f11041D1;

    public RadioButton f11042E;

    public MediaRouteButton f11043E0;

    public RadioButton f11045F;

    public RadioButton f11048G;

    public RadioButton f11051H;

    public ViewOnKeyListenerC2937r f11054I;

    public C3660c f11056I1;

    public ViewOnKeyListenerC2932m0 f11057J;

    public EnumC2434d f11058J0;

    public ExoPlayer f11059J1;

    public ViewOnKeyListenerC2915e f11060K;

    public PlayerView f11062K1;

    public ViewOnTouchListenerC2945z f11063L;

    public InterfaceC3658a f11065L1;

    public ViewOnKeyListenerC2944y f11066M;

    public ViewOnKeyListenerC2925j f11069N;

    public C3659b f11071N1;

    public C2570y f11072O;

    public DefaultTrackSelector f11074O1;

    public FrameLayout f11075P;

    public FrameLayout f11078Q;

    public ImageView f11081R;

    public ImageView f11084S;

    public boolean f11085S0;

    public C2630m f11087T;

    public AudioManager f11088T0;

    public MediaRouteButton f11089T1;

    public C2621d f11090U;

    public int f11091U0;

    public C2568x f11092U1;

    public C2632o f11093V;

    public int f11094V0;

    public RecyclerView f11095V1;

    public C2625h f11096W;

    public float f11097W0;

    public C2448k f11098W1;

    public C2619b f11099X;

    public float f11100X0;

    public Bundle f11101Y;

    public float f11102Y0;

    public ImageView f11106b0;

    public TextView f11108c0;

    public HistoryBean f11114f0;

    public int f11115f1;

    public ImageView f11116g0;

    public int f11117g1;

    public ImageView f11118h0;

    public int f11119h1;

    public C3877a f11120i0;

    public FrameLayout f11122j0;

    public TextView f11123j1;

    public RelativeLayout f11125k1;

    public TextView f11127l1;

    public TextView f11128m0;

    public RelativeLayout f11129m1;

    public RelativeLayout f11131n1;

    public boolean f11132o0;

    public RelativeLayout f11133o1;

    public ConstraintLayout f11135p1;

    public RunnableC0038c f11136q0;

    public CheckBox f11137q1;

    public ImageView f11138r0;

    public ProgressBar f11139r1;

    public SubtitleView f11140s0;

    public TextView f11141s1;

    public C2550o1 f11142t0;

    public TextView f11143t1;

    public C2544m1 f11144u0;

    public TextView f11145u1;

    public C2511b1 f11146v0;

    public TextView f11147v1;

    public C2550o1 f11148w0;

    public CircularProgressBar f11149w1;

    public C2550o1 f11151x0;

    public TextView f11152x1;

    public MyViewPager f11153y;

    public C2550o1 f11154y0;

    public TextView f11155y1;

    public AutoLayoutRadioGroup f11156z;

    public HorizontalGridView f11157z0;

    public SeekBar f11158z1;

    public final String f11150x = AbstractC0032a.m165s("hWhNfyvL\n", "xzsAHkKle3Y=\n");

    public String f11103Z = "";

    public int f11110d0 = 0;

    public final List f11112e0 = Arrays.asList(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

    public int f11124k0 = 0;

    public int f11126l0 = 0;

    public float f11130n0 = 0.0f;

    public float f11134p0 = 0.0f;

    public boolean f11046F0 = false;

    public boolean f11049G0 = false;

    public CountDownTimerC3662e f11052H0 = null;

    public boolean f11055I0 = false;

    public boolean f11061K0 = false;

    public int f11064L0 = 0;

    public long f11067M0 = 0;

    public int f11070N0 = 0;

    public long f11073O0 = 0;

    public int f11076P0 = 0;

    public long f11079Q0 = 0;

    public RadioButton f11082R0 = null;

    public boolean f11104Z0 = true;

    public boolean f11105a1 = false;

    public TVCore f11107b1 = null;

    public int f11109c1 = 0;

    public int f11111d1 = 0;

    public int f11113e1 = 0;

    public long f11121i1 = 0;

    public Constants$VIDEO_TYPE f11044E1 = Constants$VIDEO_TYPE.BSLIVE;

    public int f11047F1 = 0;

    public long f11050G1 = 0;

    public C2441g0 f11053H1 = null;

    public final RunnableC2470v f11068M1 = new RunnableC2470v(this, 2);

    public C2459p0 f11077P1 = null;

    public OkHttpClient f11080Q1 = null;

    public C2446j f11083R1 = null;

    public C3559g f11086S1 = null;

    public static native void m6653A(Spark spark);

    public static native void m6654B(Spark spark);

    public static native void m6655C(Spark spark);

    public static native void m6656D(Spark spark);

    public static native boolean m6658F(Spark spark, Bundle bundle);

    public static native void m6660H(Spark spark, String str);

    public static native void m6666N(Spark spark, int i6);

    public static native void m6667O(Spark spark);

    public static native boolean m6669Q(Spark spark, String str, String str2);

    public static native void m6670R(int i6, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, ArrayList arrayList);

    public static native String m6671Y();

    public static native String m6672i0(Bundle bundle);

    public static native void m6674r(Spark spark);

    public static native void m6675s(Spark spark);

    public static native void m6676s0(int i6);

    public static native void m6677t(Spark spark);

    public static native void m6678t0(int i6, String str);

    public static native void m6680v(Spark spark);

    public static native void m6681w(Spark spark, String str);

    public static native void m6682x(Spark spark, String str);

    public static native void m6683y(Spark spark);

    public static native void m6684z(Spark spark);

    public final native void m6685A0(RadioButton radioButton);

    public final native void m6686B0();

    public final native void m6687C0(String str);

    public final native void m6688D0(float f);

    public final native void m6689E0();

    public final native void m6690F0();

    public final native void m6691G0(int i6);

    public final native void m6692H0();

    public final native void m6693I0(int i6, String str);

    public final native void m6694J0();

    public final native void m6695K0();

    public final native void m6696L0();

    public final native void m6697M0(boolean z7);

    public final native void m6698N0();

    public final native void m6699O0(Message message);

    public final native void m6700P0();

    public final native void m6701Q0();

    public final native boolean m6702R0(int i6, KeyEvent keyEvent);

    public final native void m6703S();

    public final native void m6704T(boolean z7);

    public final native void m6705U();

    public final native void m6706V(float f, float f3);

    public final native void m6707W();

    public final native void m6708X();

    public final native void m6709Z();

    public final native void m6710a0();

    @Override
    public final native void attachBaseContext(Context context);

    public final native void m6711b0();

    public final native boolean m6712c0();

    public final native boolean m6713d0();

    @Override
    public final native boolean dispatchKeyEvent(KeyEvent keyEvent);

    public final native boolean m6714e0();

    public final native boolean m6715f0();

    public final native void m6716g0(int i6);

    @Override
    public final native Resources getResources();

    public final native void m6717h0(String str, int i6, ImageView imageView);

    public final native void m6718j0(boolean z7);

    public final native void m6719k0(boolean z7);

    public final native void m6720l0(Bundle bundle);

    public final native void m6721m0();

    public final native void m6722n0();

    public final native void m6723o0();

    @Override
    public final native void onBackPressed();

    @Override
    public native void onClick(View view);

    @Override
    public final native void onCreate(Bundle bundle);

    @Override
    public final native void onDestroy();

    @Override
    public final native void onFocusChange(View view, boolean z7);

    @Override
    public final native boolean onKey(View view, int i6, KeyEvent keyEvent);

    @Override
    public final native boolean onKeyDown(int i6, KeyEvent keyEvent);

    @Override
    public final native boolean onKeyLongPress(int i6, KeyEvent keyEvent);

    @Override
    public final native boolean onKeyUp(int i6, KeyEvent keyEvent);

    @InterfaceC3949j(threadMode = ThreadMode.MAIN)
    public native void onMessageEvent(C2463r0 c2463r0);

    @InterfaceC3949j(threadMode = ThreadMode.MAIN)
    public native void onMessageEvent(C2465s0 c2465s0);

    @InterfaceC3949j(threadMode = ThreadMode.MAIN)
    public native void onMessageEvent(C2467t0 c2467t0);

    @InterfaceC3949j(threadMode = ThreadMode.MAIN)
    public native void onMessageEvent(C2469u0 c2469u0);

    @InterfaceC3949j(threadMode = ThreadMode.MAIN)
    public native void onMessageEvent(C2471v0 c2471v0);

    @InterfaceC3949j(threadMode = ThreadMode.MAIN)
    public native void onMessageEvent(C2473w0 c2473w0);

    @Override
    public final native void onPause();

    @Override
    public final native void onResume();

    @Override
    public final native void onStop();

    @Override
    public final native boolean onTouch(View view, MotionEvent motionEvent);

    @Override
    public final native boolean onTouchEvent(MotionEvent motionEvent);

    @Override
    public final native void onWindowFocusChanged(boolean z7);

    public final native void m6724p();

    public final native void m6725p0();

    public final native void m6726q0();

    public final native void m6727r0(int i6, ArrayList arrayList);

    public final native void m6728u0(String str);

    public final native void m6729v0();

    public final native void m6730w0();

    public final native void m6731x0(Boolean bool);

    public final native void m6732y0();

    public final native void m6733z0();

    static {
        NativeUtil.classesInit0(4);
        f11018n2 = AbstractC0032a.m165s("15kxR7vNnZ/fhi8EqoORm9OOFHme\n", "tulBK9Ku/Os=\n");
        f11019o2 = AbstractC0032a.m165s("AyL7QhiKgTULPeUBFYiTKUkq5kI=\n", "YlKLLnHp4EE=\n");
        f11020p2 = AbstractC0032a.m165s("I3rA+Cb8r0ArZd67OfGqGi95nec867wfOmfc\n", "QgqwlE+fzjQ=\n");
        f11021q2 = AbstractC0032a.m165s("aYJ0mX+1u9wr\n", "H+sQ/BCa1qw=\n");
        f11022r2 = AbstractC0032a.m165s("vkrw/QqGmbO6WA==\n", "3z+UlGWp9MM=\n");
        f11023s2 = AbstractC0032a.m165s("y9NIEStX/obf1w==\n", "vbosdER4ieM=\n");
        AbstractC0032a.m165s("xkv46DAs0f3FUw==\n", "pz6cgV8Dppg=\n");
        f11024t2 = AbstractC0032a.m165s("h9zFX6QiQfzDwQ==\n", "8bWhOssNLIw=\n");
        f11025u2 = AbstractC0032a.m165s("XWZ7hOjJHLldcA==\n", "PBMf7YfmetU=\n");
        f11026v2 = AbstractC0032a.m165s("Vt3/2O7n0XkDybbd4LzR\n", "N6ibsYHIvAk=\n");
        f11027w2 = AbstractC0032a.m165s("S9DX1klvSC5N\n", "KqWzvyZAJ0k=\n");
        f11028x2 = AbstractC0032a.m165s("R8Q8aWSmLuRTwg==\n", "JrFYAAuJQZQ=\n");
        f11005a2 = false;
        f11006b2 = 100;
        f11007c2 = false;
        f11009e2 = false;
        f11010f2 = false;
        f11011g2 = true;
        f11014j2 = true;
        f11016l2 = 0;
        f11017m2 = AbstractC2442h.f8617w;
        f11029y2 = null;
    }
}
