package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.customview.view.AbsSavedState;
import androidx.media3.common.C0565C;
import com.alibaba.fastjson.asm.Opcodes;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p093j.InterfaceC2741b;
import p138n0.AbstractC3155s0;
import p187r4.AbstractC3612b;
import p206t0.AbstractC3788b;

public class SearchView extends LinearLayoutCompat implements InterfaceC2741b {

    public static final C0176a3 f716h0;

    public final Rect f717A;

    public final int[] f718B;

    public final int[] f719C;

    public final ImageView f720D;

    public final Drawable f721E;

    public final int f722F;

    public final int f723G;

    public final Intent f724H;

    public final Intent f725I;

    public final CharSequence f726J;

    public View.OnFocusChangeListener f727K;

    public View.OnClickListener f728L;

    public boolean f729M;

    public boolean f730N;

    public AbstractC3788b f731O;

    public boolean f732P;

    public CharSequence f733Q;

    public boolean f734R;

    public boolean f735S;

    public int f736T;

    public boolean f737U;

    public CharSequence f738V;

    public boolean f739W;

    public int f740b0;

    public SearchableInfo f741c0;

    public Bundle f742d0;

    public final RunnableC0258q2 f743e0;

    public final RunnableC0258q2 f744f0;

    public final WeakHashMap f745g0;

    public final SearchAutoComplete f746p;

    public final View f747q;

    public final View f748r;

    public final View f749s;

    public final ImageView f750t;

    public final ImageView f751u;

    public final ImageView f752v;

    public final ImageView f753w;

    public final View f754x;

    public C0194d3 f755y;

    public final Rect f756z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0182b3();

        public boolean f757c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f757c = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f757c + "}";
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeValue(Boolean.valueOf(this.f757c));
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        public int f758e;

        public SearchView f759f;

        public boolean f760g;

        public final RunnableC0188c3 f761h;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i6 = configuration.screenWidthDp;
            int i10 = configuration.screenHeightDp;
            if (i6 >= 960 && i10 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i6 >= 600) {
                return 192;
            }
            if (i6 < 640 || i10 < 480) {
                return Opcodes.IF_ICMPNE;
            }
            return 192;
        }

        public final void m604a() {
            if (Build.VERSION.SDK_INT >= 29) {
                AbstractC0288w2.m811b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            C0176a3 c0176a3 = SearchView.f716h0;
            c0176a3.getClass();
            C0176a3.m638a();
            Method method = c0176a3.f867c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override
        public final boolean enoughToFilter() {
            return this.f758e <= 0 || super.enoughToFilter();
        }

        @Override
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f760g) {
                RunnableC0188c3 runnableC0188c3 = this.f761h;
                removeCallbacks(runnableC0188c3);
                post(runnableC0188c3);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override
        public final void onFocusChanged(boolean z7, int i6, Rect rect) {
            super.onFocusChanged(z7, i6, rect);
            SearchView searchView = this.f759f;
            searchView.m603y(searchView.f730N);
            searchView.post(searchView.f743e0);
            if (searchView.f746p.hasFocus()) {
                searchView.m592n();
            }
        }

        @Override
        public final boolean onKeyPreIme(int i6, KeyEvent keyEvent) {
            if (i6 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f759f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i6, keyEvent);
        }

        @Override
        public final void onWindowFocusChanged(boolean z7) {
            super.onWindowFocusChanged(z7);
            if (z7 && this.f759f.hasFocus() && getVisibility() == 0) {
                this.f760g = true;
                Context context = getContext();
                C0176a3 c0176a3 = SearchView.f716h0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    m604a();
                }
            }
        }

        public void setImeVisibility(boolean z7) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            RunnableC0188c3 runnableC0188c3 = this.f761h;
            if (!z7) {
                this.f760g = false;
                removeCallbacks(runnableC0188c3);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f760g = true;
                    return;
                }
                this.f760g = false;
                removeCallbacks(runnableC0188c3);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f759f = searchView;
        }

        @Override
        public void setThreshold(int i6) {
            super.setThreshold(i6);
            this.f758e = i6;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i6) {
            super(context, attributeSet, i6);
            this.f761h = new RunnableC0188c3(this);
            this.f758e = getThreshold();
        }

        @Override
        public final void performCompletion() {
        }

        @Override
        public final void replaceText(CharSequence charSequence) {
        }
    }

    static {
        C0176a3 c0176a3 = null;
        if (Build.VERSION.SDK_INT < 29) {
            C0176a3 c0176a4 = new C0176a3();
            c0176a4.f865a = null;
            c0176a4.f866b = null;
            c0176a4.f867c = null;
            C0176a3.m638a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                c0176a4.f865a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                c0176a4.f866b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                c0176a4.f867c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            c0176a3 = c0176a4;
        }
        f716h0 = c0176a3;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f746p;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override
    public final void mo588b() {
        if (this.f739W) {
            return;
        }
        this.f739W = true;
        SearchAutoComplete searchAutoComplete = this.f746p;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f740b0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override
    public final void clearFocus() {
        this.f735S = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f746p;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f735S = false;
    }

    @Override
    public final void mo589e() {
        SearchAutoComplete searchAutoComplete = this.f746p;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f738V = "";
        clearFocus();
        m603y(true);
        searchAutoComplete.setImeOptions(this.f740b0);
        this.f739W = false;
    }

    public int getImeOptions() {
        return this.f746p.getImeOptions();
    }

    public int getInputType() {
        return this.f746p.getInputType();
    }

    public int getMaxWidth() {
        return this.f736T;
    }

    public CharSequence getQuery() {
        return this.f746p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f733Q;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f741c0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f726J : getContext().getText(this.f741c0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f723G;
    }

    public int getSuggestionRowLayout() {
        return this.f722F;
    }

    public AbstractC3788b getSuggestionsAdapter() {
        return this.f731O;
    }

    public final Intent m590l(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f738V);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f742d0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f741c0.getSearchActivity());
        return intent;
    }

    public final Intent m591m(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f742d0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void m592n() {
        int i6 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f746p;
        if (i6 >= 29) {
            AbstractC0288w2.m810a(searchAutoComplete);
            return;
        }
        C0176a3 c0176a3 = f716h0;
        c0176a3.getClass();
        C0176a3.m638a();
        Method method = c0176a3.f865a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        c0176a3.getClass();
        C0176a3.m638a();
        Method method2 = c0176a3.f866b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void m593o() {
        SearchAutoComplete searchAutoComplete = this.f746p;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f729M) {
            clearFocus();
            m603y(true);
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f743e0);
        post(this.f744f0);
        super.onDetachedFromWindow();
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        if (z7) {
            int[] iArr = this.f718B;
            SearchAutoComplete searchAutoComplete = this.f746p;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f719C;
            getLocationInWindow(iArr2);
            int i13 = iArr[1] - iArr2[1];
            int i14 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i14;
            int height = searchAutoComplete.getHeight() + i13;
            Rect rect = this.f756z;
            rect.set(i14, i13, width, height);
            int i15 = rect.left;
            int i16 = rect.right;
            int i17 = i12 - i10;
            Rect rect2 = this.f717A;
            rect2.set(i15, 0, i16, i17);
            C0194d3 c0194d3 = this.f755y;
            if (c0194d3 == null) {
                C0194d3 c0194d4 = new C0194d3(rect2, rect, searchAutoComplete);
                this.f755y = c0194d4;
                setTouchDelegate(c0194d4);
            } else {
                c0194d3.f889b.set(rect2);
                Rect rect3 = c0194d3.f891d;
                rect3.set(rect2);
                int i18 = -c0194d3.f892e;
                rect3.inset(i18, i18);
                c0194d3.f890c.set(rect);
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int i11;
        if (this.f730N) {
            super.onMeasure(i6, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (mode == Integer.MIN_VALUE) {
            int i12 = this.f736T;
            size = i12 > 0 ? Math.min(i12, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f736T;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i11 = this.f736T) > 0) {
            size = Math.min(i11, size);
        }
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        m603y(savedState.f757c);
        requestLayout();
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f757c = this.f730N;
        return savedState;
    }

    @Override
    public final void onWindowFocusChanged(boolean z7) {
        super.onWindowFocusChanged(z7);
        post(this.f743e0);
    }

    public final void m594p(int i6) {
        int position;
        String strM662h;
        Cursor cursor = this.f731O.f12752c;
        if (cursor != null && cursor.moveToPosition(i6)) {
            Intent intentM590l = null;
            try {
                int i10 = ViewOnClickListenerC0204f3.f904x;
                String strM662h2 = ViewOnClickListenerC0204f3.m662h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strM662h2 == null) {
                    strM662h2 = this.f741c0.getSuggestIntentAction();
                }
                if (strM662h2 == null) {
                    strM662h2 = "android.intent.action.SEARCH";
                }
                String strM662h3 = ViewOnClickListenerC0204f3.m662h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strM662h3 == null) {
                    strM662h3 = this.f741c0.getSuggestIntentData();
                }
                if (strM662h3 != null && (strM662h = ViewOnClickListenerC0204f3.m662h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strM662h3 = strM662h3 + "/" + Uri.encode(strM662h);
                }
                intentM590l = m590l(strM662h2, strM662h3 == null ? null : Uri.parse(strM662h3), ViewOnClickListenerC0204f3.m662h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), ViewOnClickListenerC0204f3.m662h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e5) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e5);
            }
            if (intentM590l != null) {
                try {
                    getContext().startActivity(intentM590l);
                } catch (RuntimeException e10) {
                    Log.e("SearchView", "Failed launch activity: " + intentM590l, e10);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f746p;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void m595q(int i6) {
        Editable text = this.f746p.getText();
        Cursor cursor = this.f731O.f12752c;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i6)) {
            setQuery(text);
            return;
        }
        String strMo665c = this.f731O.mo665c(cursor);
        if (strMo665c != null) {
            setQuery(strMo665c);
        } else {
            setQuery(text);
        }
    }

    public final void m596r(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override
    public final boolean requestFocus(int i6, Rect rect) {
        if (this.f735S || !isFocusable()) {
            return false;
        }
        if (this.f730N) {
            return super.requestFocus(i6, rect);
        }
        boolean zRequestFocus = this.f746p.requestFocus(i6, rect);
        if (zRequestFocus) {
            m603y(false);
        }
        return zRequestFocus;
    }

    public final void m597s() {
        SearchAutoComplete searchAutoComplete = this.f746p;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f741c0 != null) {
            getContext().startActivity(m590l("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public void setAppSearchData(Bundle bundle) {
        this.f742d0 = bundle;
    }

    public void setIconified(boolean z7) {
        if (z7) {
            m593o();
            return;
        }
        m603y(false);
        SearchAutoComplete searchAutoComplete = this.f746p;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f728L;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z7) {
        if (this.f729M == z7) {
            return;
        }
        this.f729M = z7;
        m603y(z7);
        m600v();
    }

    public void setImeOptions(int i6) {
        this.f746p.setImeOptions(i6);
    }

    public void setInputType(int i6) {
        this.f746p.setInputType(i6);
    }

    public void setMaxWidth(int i6) {
        this.f736T = i6;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f727K = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f728L = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f733Q = charSequence;
        m600v();
    }

    public void setQueryRefinementEnabled(boolean z7) {
        this.f734R = z7;
        AbstractC3788b abstractC3788b = this.f731O;
        if (abstractC3788b instanceof ViewOnClickListenerC0204f3) {
            ((ViewOnClickListenerC0204f3) abstractC3788b).f913p = z7 ? 2 : 1;
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f741c0 = searchableInfo;
        Intent intent = null;
        SearchAutoComplete searchAutoComplete = this.f746p;
        if (searchableInfo != null) {
            searchAutoComplete.setThreshold(searchableInfo.getSuggestThreshold());
            searchAutoComplete.setImeOptions(this.f741c0.getImeOptions());
            int inputType = this.f741c0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.f741c0.getSuggestAuthority() != null) {
                    inputType |= 589824;
                }
            }
            searchAutoComplete.setInputType(inputType);
            AbstractC3788b abstractC3788b = this.f731O;
            if (abstractC3788b != null) {
                abstractC3788b.mo664b(null);
            }
            if (this.f741c0.getSuggestAuthority() != null) {
                ViewOnClickListenerC0204f3 viewOnClickListenerC0204f3 = new ViewOnClickListenerC0204f3(getContext(), this, this.f741c0, this.f745g0);
                this.f731O = viewOnClickListenerC0204f3;
                searchAutoComplete.setAdapter(viewOnClickListenerC0204f3);
                ((ViewOnClickListenerC0204f3) this.f731O).f913p = this.f734R ? 2 : 1;
            }
            m600v();
        }
        SearchableInfo searchableInfo2 = this.f741c0;
        boolean z7 = false;
        if (searchableInfo2 != null && searchableInfo2.getVoiceSearchEnabled()) {
            if (this.f741c0.getVoiceSearchLaunchWebSearch()) {
                intent = this.f724H;
            } else if (this.f741c0.getVoiceSearchLaunchRecognizer()) {
                intent = this.f725I;
            }
            if (intent != null) {
                z7 = getContext().getPackageManager().resolveActivity(intent, C0565C.DEFAULT_BUFFER_SEGMENT_SIZE) != null;
            }
        }
        this.f737U = z7;
        if (z7) {
            searchAutoComplete.setPrivateImeOptions("nm");
        }
        m603y(this.f730N);
    }

    public void setSubmitButtonEnabled(boolean z7) {
        this.f732P = z7;
        m603y(this.f730N);
    }

    public void setSuggestionsAdapter(AbstractC3788b abstractC3788b) {
        this.f731O = abstractC3788b;
        this.f746p.setAdapter(abstractC3788b);
    }

    public final void m598t() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f746p.getText());
        int i6 = (!zIsEmpty || (this.f729M && !this.f739W)) ? 0 : 8;
        ImageView imageView = this.f752v;
        imageView.setVisibility(i6);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void m599u() {
        int[] iArr = this.f746p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f748r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f749s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void m600v() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        boolean z7 = this.f729M;
        SearchAutoComplete searchAutoComplete = this.f746p;
        CharSequence charSequence2 = charSequence;
        if (z7 && (drawable = this.f721E) != null) {
            charSequence2 = charSequence;
            int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            charSequence2 = spannableStringBuilder;
        }
        charSequence2 = charSequence;
        searchAutoComplete.setHint(charSequence2);
    }

    public final void m601w() {
        this.f749s.setVisibility(((this.f732P || this.f737U) && !this.f730N && (this.f751u.getVisibility() == 0 || this.f753w.getVisibility() == 0)) ? 0 : 8);
    }

    public final void m602x(boolean z7) {
        boolean z10 = this.f732P;
        this.f751u.setVisibility((!z10 || !(z10 || this.f737U) || this.f730N || !hasFocus() || (!z7 && this.f737U)) ? 8 : 0);
    }

    public final void m603y(boolean z7) {
        this.f730N = z7;
        int i6 = 8;
        int i10 = z7 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f746p.getText());
        this.f750t.setVisibility(i10);
        m602x(!zIsEmpty);
        this.f747q.setVisibility(z7 ? 8 : 0);
        ImageView imageView = this.f720D;
        imageView.setVisibility((imageView.getDrawable() == null || this.f729M) ? 8 : 0);
        m598t();
        if (this.f737U && !this.f730N && zIsEmpty) {
            this.f751u.setVisibility(8);
            i6 = 0;
        }
        this.f753w.setVisibility(i6);
        m601w();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f756z = new Rect();
        this.f717A = new Rect();
        this.f718B = new int[2];
        this.f719C = new int[2];
        this.f743e0 = new RunnableC0258q2(this, 0);
        this.f744f0 = new RunnableC0258q2(this, 1);
        this.f745g0 = new WeakHashMap();
        ViewOnClickListenerC0273t2 viewOnClickListenerC0273t2 = new ViewOnClickListenerC0273t2(this);
        ViewOnKeyListenerC0278u2 viewOnKeyListenerC0278u2 = new ViewOnKeyListenerC0278u2(this);
        C0283v2 c0283v2 = new C0283v2(this);
        int i10 = 1;
        C0226k0 c0226k0 = new C0226k0(i10, this);
        C0287w1 c0287w1 = new C0287w1(i10, this);
        C0253p2 c0253p2 = new C0253p2(0, this);
        int[] iArr = AbstractC2341a.f8174v;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        layoutInflaterFrom.inflate(typedArray.getResourceId(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f746p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f747q = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.f748r = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.f749s = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f750t = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f751u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f752v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f753w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f720D = imageView5;
        viewFindViewById.setBackground(c0026bM111C.m140t(10));
        viewFindViewById2.setBackground(c0026bM111C.m140t(14));
        imageView.setImageDrawable(c0026bM111C.m140t(13));
        imageView2.setImageDrawable(c0026bM111C.m140t(7));
        imageView3.setImageDrawable(c0026bM111C.m140t(4));
        imageView4.setImageDrawable(c0026bM111C.m140t(16));
        imageView5.setImageDrawable(c0026bM111C.m140t(13));
        this.f721E = c0026bM111C.m140t(12);
        AbstractC3612b.m7256L(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f722F = typedArray.getResourceId(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.f723G = typedArray.getResourceId(5, 0);
        imageView.setOnClickListener(viewOnClickListenerC0273t2);
        imageView3.setOnClickListener(viewOnClickListenerC0273t2);
        imageView2.setOnClickListener(viewOnClickListenerC0273t2);
        imageView4.setOnClickListener(viewOnClickListenerC0273t2);
        searchAutoComplete.setOnClickListener(viewOnClickListenerC0273t2);
        searchAutoComplete.addTextChangedListener(c0253p2);
        searchAutoComplete.setOnEditorActionListener(c0283v2);
        searchAutoComplete.setOnItemClickListener(c0226k0);
        searchAutoComplete.setOnItemSelectedListener(c0287w1);
        searchAutoComplete.setOnKeyListener(viewOnKeyListenerC0278u2);
        searchAutoComplete.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0263r2(0, this));
        setIconifiedByDefault(typedArray.getBoolean(8, true));
        int dimensionPixelSize = typedArray.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f726J = typedArray.getText(6);
        this.f733Q = typedArray.getText(11);
        int i11 = typedArray.getInt(3, -1);
        if (i11 != -1) {
            setImeOptions(i11);
        }
        int i12 = typedArray.getInt(2, -1);
        if (i12 != -1) {
            setInputType(i12);
        }
        setFocusable(typedArray.getBoolean(0, true));
        c0026bM111C.m120F();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f724H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f725I = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f754x = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0268s2(0, this));
        }
        m603y(this.f729M);
        m600v();
    }

    public void setOnCloseListener(InterfaceC0293x2 interfaceC0293x2) {
    }

    public void setOnQueryTextListener(InterfaceC0298y2 interfaceC0298y2) {
    }

    public void setOnSuggestionListener(InterfaceC0303z2 interfaceC0303z2) {
    }
}
