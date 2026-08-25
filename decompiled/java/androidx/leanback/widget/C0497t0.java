package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.regex.Matcher;

public final class C0497t0 implements RecognitionListener {

    public final SearchBar f2443a;

    public C0497t0(SearchBar searchBar) {
        this.f2443a = searchBar;
    }

    @Override
    public final void onError(int i6) {
        switch (i6) {
            case 1:
                int i10 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer network timeout");
                break;
            case 2:
                int i11 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer network error");
                break;
            case 3:
                int i12 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer audio error");
                break;
            case 4:
                int i13 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer server error");
                break;
            case 5:
                int i14 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer client error");
                break;
            case 6:
                int i15 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer speech timeout");
                break;
            case 7:
                int i16 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer no match");
                break;
            case 8:
                int i17 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer busy");
                break;
            case 9:
                int i18 = SearchBar.f2223x;
                Log.w("SearchBar", "recognizer insufficient permissions");
                break;
            default:
                int i19 = SearchBar.f2223x;
                Log.d("SearchBar", "recognizer other error");
                break;
        }
        SearchBar searchBar = this.f2443a;
        searchBar.m1396b();
        searchBar.f2231h.post(new RunnableC0485n0(R.raw.lb_voice_failure, 0, searchBar));
    }

    @Override
    public final void onPartialResults(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        if (stringArrayList == null || stringArrayList.size() == 0) {
            return;
        }
        String str = stringArrayList.get(0);
        String str2 = stringArrayList.size() > 1 ? stringArrayList.get(1) : null;
        SearchEditText searchEditText = this.f2443a.f2224a;
        searchEditText.getClass();
        if (str == null) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            Matcher matcher = StreamingTextView.f2287f.matcher(str2);
            while (matcher.find()) {
                int iStart = matcher.start() + length;
                spannableStringBuilder.setSpan(new C0467g1(searchEditText, str2.charAt(matcher.start()), iStart), iStart, matcher.end() + length, 33);
            }
        }
        searchEditText.f2292d = Math.max(str.length(), searchEditText.f2292d);
        searchEditText.setText(new SpannedString(spannableStringBuilder));
        searchEditText.bringPointIntoView(searchEditText.length());
        ObjectAnimator objectAnimator = searchEditText.f2293e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        int streamPosition = searchEditText.getStreamPosition();
        int length2 = searchEditText.length();
        int i6 = length2 - streamPosition;
        if (i6 > 0) {
            if (searchEditText.f2293e == null) {
                ObjectAnimator objectAnimator2 = new ObjectAnimator();
                searchEditText.f2293e = objectAnimator2;
                objectAnimator2.setTarget(searchEditText);
                searchEditText.f2293e.setProperty(StreamingTextView.f2288g);
            }
            searchEditText.f2293e.setIntValues(streamPosition, length2);
            searchEditText.f2293e.setDuration(((long) i6) * 50);
            searchEditText.f2293e.start();
        }
    }

    @Override
    public final void onReadyForSpeech(Bundle bundle) {
        SearchBar searchBar = this.f2443a;
        SpeechOrbView speechOrbView = searchBar.f2225b;
        speechOrbView.setOrbColors(speechOrbView.f2283u);
        speechOrbView.setOrbIcon(speechOrbView.getResources().getDrawable(R.drawable.lb_ic_search_mic));
        speechOrbView.m1399a(true);
        speechOrbView.f2261m = false;
        speechOrbView.m1400b();
        View view = speechOrbView.f2251c;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        speechOrbView.f2285w = 0;
        speechOrbView.f2286x = true;
        searchBar.f2231h.post(new RunnableC0485n0(R.raw.lb_voice_open, 0, searchBar));
    }

    @Override
    public final void onResults(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        SearchBar searchBar = this.f2443a;
        if (stringArrayList != null) {
            String str = stringArrayList.get(0);
            searchBar.f2227d = str;
            searchBar.f2224a.setText(str);
            TextUtils.isEmpty(searchBar.f2227d);
        }
        searchBar.m1396b();
        searchBar.f2231h.post(new RunnableC0485n0(R.raw.lb_voice_success, 0, searchBar));
    }

    @Override
    public final void onRmsChanged(float f) {
        this.f2443a.f2225b.setSoundLevel(f < 0.0f ? 0 : (int) (f * 10.0f));
    }

    @Override
    public final void onBeginningOfSpeech() {
    }

    @Override
    public final void onEndOfSpeech() {
    }

    @Override
    public final void onBufferReceived(byte[] bArr) {
    }

    @Override
    public final void onEvent(int i6, Bundle bundle) {
    }
}
