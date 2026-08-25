package androidx.leanback.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.p2serv.android.p032ds.R;

public class SearchBar extends RelativeLayout {

    public static final int f2223x = 0;

    public SearchEditText f2224a;

    public SpeechOrbView f2225b;

    public ImageView f2226c;

    public String f2227d;

    public String f2228e;

    public String f2229f;

    public Drawable f2230g;

    public final Handler f2231h;

    public final InputMethodManager f2232i;

    public boolean f2233j;

    public Drawable f2234k;

    public final int f2235l;

    public final int f2236m;

    public final int f2237n;

    public final int f2238o;

    public final int f2239p;

    public final int f2240q;

    public SpeechRecognizer f2241r;

    public boolean f2242s;

    public SoundPool f2243t;

    public final SparseIntArray f2244u;

    public boolean f2245v;

    public final Context f2246w;

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m1395a() {
        if (this.f2245v) {
            return;
        }
        if (!hasFocus()) {
            requestFocus();
        }
        if (this.f2241r == null) {
            return;
        }
        if (getContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            throw new IllegalStateException("android.permission.RECORD_AUDIO required for search");
        }
        this.f2245v = true;
        this.f2224a.setText("");
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        this.f2241r.setRecognitionListener(new C0497t0(this));
        this.f2242s = true;
        this.f2241r.startListening(intent);
    }

    public final void m1396b() {
        if (this.f2245v) {
            this.f2224a.setText(this.f2227d);
            this.f2224a.setHint(this.f2228e);
            this.f2245v = false;
            if (this.f2241r == null) {
                return;
            }
            this.f2225b.m1402c();
            if (this.f2242s) {
                this.f2241r.cancel();
                this.f2242s = false;
            }
            this.f2241r.setRecognitionListener(null);
        }
    }

    public final void m1397c() {
        String string = getResources().getString(R.string.lb_search_bar_hint);
        if (!TextUtils.isEmpty(this.f2229f)) {
            string = this.f2225b.isFocused() ? getResources().getString(R.string.lb_search_bar_hint_with_title_speech, this.f2229f) : getResources().getString(R.string.lb_search_bar_hint_with_title, this.f2229f);
        } else if (this.f2225b.isFocused()) {
            string = getResources().getString(R.string.lb_search_bar_hint_speech);
        }
        this.f2228e = string;
        SearchEditText searchEditText = this.f2224a;
        if (searchEditText != null) {
            searchEditText.setHint(string);
        }
    }

    public final void m1398d(boolean z7) {
        if (z7) {
            this.f2234k.setAlpha(this.f2240q);
            boolean zIsFocused = this.f2225b.isFocused();
            int i6 = this.f2238o;
            if (zIsFocused) {
                this.f2224a.setTextColor(i6);
                this.f2224a.setHintTextColor(i6);
            } else {
                this.f2224a.setTextColor(this.f2236m);
                this.f2224a.setHintTextColor(i6);
            }
        } else {
            this.f2234k.setAlpha(this.f2239p);
            this.f2224a.setTextColor(this.f2235l);
            this.f2224a.setHintTextColor(this.f2237n);
        }
        m1397c();
    }

    public Drawable getBadgeDrawable() {
        return this.f2230g;
    }

    public CharSequence getHint() {
        return this.f2228e;
    }

    public String getTitle() {
        return this.f2229f;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2243t = new SoundPool(2, 1, 0);
        int[] iArr = {R.raw.lb_voice_failure, R.raw.lb_voice_open, R.raw.lb_voice_no_input, R.raw.lb_voice_success};
        for (int i6 = 0; i6 < 4; i6++) {
            int i10 = iArr[i6];
            this.f2244u.put(i10, this.f2243t.load(this.f2246w, i10, 1));
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        m1396b();
        this.f2243t.release();
        super.onDetachedFromWindow();
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2234k = ((RelativeLayout) findViewById(R.id.lb_search_bar_items)).getBackground();
        this.f2224a = (SearchEditText) findViewById(R.id.lb_search_text_editor);
        ImageView imageView = (ImageView) findViewById(R.id.lb_search_bar_badge);
        this.f2226c = imageView;
        Drawable drawable = this.f2230g;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.f2224a.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0487o0(this, 0));
        this.f2224a.addTextChangedListener(new C0491q0(this, new RunnableC0489p0(this, 0)));
        this.f2224a.setOnKeyboardDismissListener(new C0490q(this));
        this.f2224a.setOnEditorActionListener(new C0493r0(this));
        this.f2224a.setPrivateImeOptions("escapeNorth,voiceDismiss");
        SpeechOrbView speechOrbView = (SpeechOrbView) findViewById(R.id.lb_search_bar_speech_orb);
        this.f2225b = speechOrbView;
        speechOrbView.setOnOrbClickedListener(new ViewOnClickListenerC0495s0(this));
        this.f2225b.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0487o0(this, 1));
        m1398d(hasFocus());
        m1397c();
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.f2230g = drawable;
        ImageView imageView = this.f2226c;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            if (drawable != null) {
                this.f2226c.setVisibility(0);
            } else {
                this.f2226c.setVisibility(8);
            }
        }
    }

    @Override
    public void setNextFocusDownId(int i6) {
        this.f2225b.setNextFocusDownId(i6);
        this.f2224a.setNextFocusDownId(i6);
    }

    public void setSearchAffordanceColors(C0507y0 c0507y0) {
        SpeechOrbView speechOrbView = this.f2225b;
        if (speechOrbView != null) {
            speechOrbView.setNotListeningOrbColors(c0507y0);
        }
    }

    public void setSearchAffordanceColorsInListening(C0507y0 c0507y0) {
        SpeechOrbView speechOrbView = this.f2225b;
        if (speechOrbView != null) {
            speechOrbView.setListeningOrbColors(c0507y0);
        }
    }

    public void setSearchQuery(String str) {
        m1396b();
        this.f2224a.setText(str);
        setSearchQueryInternal(str);
    }

    public void setSearchQueryInternal(String str) {
        if (TextUtils.equals(this.f2227d, str)) {
            return;
        }
        this.f2227d = str;
    }

    public void setSpeechRecognizer(SpeechRecognizer speechRecognizer) {
        m1396b();
        SpeechRecognizer speechRecognizer2 = this.f2241r;
        if (speechRecognizer2 != null) {
            speechRecognizer2.setRecognitionListener(null);
            if (this.f2242s) {
                this.f2241r.cancel();
                this.f2242s = false;
            }
        }
        this.f2241r = speechRecognizer;
    }

    public void setTitle(String str) {
        this.f2229f = str;
        m1397c();
    }

    public SearchBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2231h = new Handler();
        this.f2233j = false;
        this.f2244u = new SparseIntArray();
        this.f2245v = false;
        this.f2246w = context;
        Resources resources = getResources();
        LayoutInflater.from(getContext()).inflate(R.layout.lb_search_bar, (ViewGroup) this, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.lb_search_bar_height));
        layoutParams.addRule(10, -1);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f2227d = "";
        this.f2232i = (InputMethodManager) context.getSystemService("input_method");
        this.f2236m = resources.getColor(R.color.lb_search_bar_text_speech_mode);
        this.f2235l = resources.getColor(R.color.lb_search_bar_text);
        this.f2240q = resources.getInteger(R.integer.lb_search_bar_speech_mode_background_alpha);
        this.f2239p = resources.getInteger(R.integer.lb_search_bar_text_mode_background_alpha);
        this.f2238o = resources.getColor(R.color.lb_search_bar_hint_speech_mode);
        this.f2237n = resources.getColor(R.color.lb_search_bar_hint);
    }

    public void setPermissionListener(InterfaceC0501v0 interfaceC0501v0) {
    }

    public void setSearchBarListener(InterfaceC0499u0 interfaceC0499u0) {
    }

    @Deprecated
    public void setSpeechRecognitionCallback(InterfaceC0455c1 interfaceC0455c1) {
    }
}
