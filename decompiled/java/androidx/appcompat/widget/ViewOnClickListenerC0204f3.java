package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.p2serv.android.p032ds.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p034d0.AbstractC2115a;
import p206t0.AbstractC3788b;
import p206t0.C3787a;

public final class ViewOnClickListenerC0204f3 extends AbstractC3788b implements View.OnClickListener {

    public static final int f904x = 0;

    public final int f905h;

    public final int f906i;

    public final LayoutInflater f907j;

    public final SearchView f908k;

    public final SearchableInfo f909l;

    public final Context f910m;

    public final WeakHashMap f911n;

    public final int f912o;

    public int f913p;

    public ColorStateList f914q;

    public int f915r;

    public int f916s;

    public int f917t;

    public int f918u;

    public int f919v;

    public int f920w;

    public ViewOnClickListenerC0204f3(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f12751b = true;
        this.f12752c = null;
        this.f12750a = false;
        this.f12753d = -1;
        this.f12754e = new C3787a(this);
        this.f12755f = new C0175a2(2, this);
        this.f906i = suggestionRowLayout;
        this.f905h = suggestionRowLayout;
        this.f907j = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f913p = 1;
        this.f915r = -1;
        this.f916s = -1;
        this.f917t = -1;
        this.f918u = -1;
        this.f919v = -1;
        this.f920w = -1;
        this.f908k = searchView;
        this.f909l = searchableInfo;
        this.f912o = searchView.getSuggestionCommitIconResId();
        this.f910m = context;
        this.f911n = weakHashMap;
    }

    public static String m662h(Cursor cursor, int i6) {
        if (i6 == -1) {
            return null;
        }
        try {
            return cursor.getString(i6);
        } catch (Exception e5) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e5);
            return null;
        }
    }

    @Override
    public final void mo663a(View view, Cursor cursor) {
        int i6;
        Drawable drawableM668f;
        CharSequence charSequenceM662h;
        C0199e3 c0199e3 = (C0199e3) view.getTag();
        int i10 = this.f920w;
        int i11 = i10 != -1 ? cursor.getInt(i10) : 0;
        TextView textView = c0199e3.f898a;
        if (textView != null) {
            String strM662h = m662h(cursor, this.f915r);
            textView.setText(strM662h);
            if (TextUtils.isEmpty(strM662h)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
        Context context = this.f910m;
        TextView textView2 = c0199e3.f899b;
        if (textView2 != null) {
            String strM662h2 = m662h(cursor, this.f917t);
            if (strM662h2 != null) {
                if (this.f914q == null) {
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
                    this.f914q = context.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(strM662h2);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f914q, null), 0, strM662h2.length(), 33);
                charSequenceM662h = spannableString;
            } else {
                charSequenceM662h = m662h(cursor, this.f916s);
            }
            if (TextUtils.isEmpty(charSequenceM662h)) {
                if (textView != null) {
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                }
            } else if (textView != null) {
                textView.setSingleLine(true);
                textView.setMaxLines(1);
            }
            textView2.setText(charSequenceM662h);
            if (TextUtils.isEmpty(charSequenceM662h)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
        }
        ImageView imageView = c0199e3.f900c;
        if (imageView != null) {
            int i12 = this.f918u;
            if (i12 == -1) {
                drawableM668f = null;
            } else {
                drawableM668f = m668f(cursor.getString(i12));
                if (drawableM668f == null) {
                    ComponentName searchActivity = this.f909l.getSearchActivity();
                    String strFlattenToShortString = searchActivity.flattenToShortString();
                    WeakHashMap weakHashMap = this.f911n;
                    if (weakHashMap.containsKey(strFlattenToShortString)) {
                        Drawable.ConstantState constantState = (Drawable.ConstantState) weakHashMap.get(strFlattenToShortString);
                        drawableM668f = constantState == null ? null : constantState.newDrawable(context.getResources());
                    } else {
                        PackageManager packageManager = context.getPackageManager();
                        try {
                            ActivityInfo activityInfo = packageManager.getActivityInfo(searchActivity, 128);
                            int iconResource = activityInfo.getIconResource();
                            if (iconResource != 0) {
                                Drawable drawable = packageManager.getDrawable(searchActivity.getPackageName(), iconResource, activityInfo.applicationInfo);
                                if (drawable == null) {
                                    StringBuilder sbM27u = AbstractC0004e.m27u(iconResource, "Invalid icon resource ", " for ");
                                    sbM27u.append(searchActivity.flattenToShortString());
                                    Log.w("SuggestionsAdapter", sbM27u.toString());
                                    drawableM668f = null;
                                } else {
                                    drawableM668f = drawable;
                                }
                            } else {
                                drawableM668f = null;
                            }
                        } catch (PackageManager.NameNotFoundException e5) {
                            Log.w("SuggestionsAdapter", e5.toString());
                        }
                        weakHashMap.put(strFlattenToShortString, drawableM668f == null ? null : drawableM668f.getConstantState());
                    }
                    if (drawableM668f == null) {
                        drawableM668f = context.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            imageView.setImageDrawable(drawableM668f);
            if (drawableM668f == null) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
                drawableM668f.setVisible(false, false);
                drawableM668f.setVisible(true, false);
            }
        }
        ImageView imageView2 = c0199e3.f901d;
        if (imageView2 == null) {
            i6 = 1;
        } else {
            int i13 = this.f919v;
            Drawable drawableM668f2 = i13 == -1 ? null : m668f(cursor.getString(i13));
            imageView2.setImageDrawable(drawableM668f2);
            if (drawableM668f2 == null) {
                imageView2.setVisibility(8);
                i6 = 1;
            } else {
                imageView2.setVisibility(0);
                drawableM668f2.setVisible(false, false);
                i6 = 1;
                drawableM668f2.setVisible(true, false);
            }
        }
        int i14 = this.f913p;
        ImageView imageView3 = c0199e3.f902e;
        if (i14 != 2 && (i14 != i6 || (i11 & 1) == 0)) {
            imageView3.setVisibility(8);
            return;
        }
        imageView3.setVisibility(0);
        imageView3.setTag(textView.getText());
        imageView3.setOnClickListener(this);
    }

    @Override
    public final void mo664b(Cursor cursor) {
        try {
            super.mo664b(cursor);
            if (cursor != null) {
                this.f915r = cursor.getColumnIndex("suggest_text_1");
                this.f916s = cursor.getColumnIndex("suggest_text_2");
                this.f917t = cursor.getColumnIndex("suggest_text_2_url");
                this.f918u = cursor.getColumnIndex("suggest_icon_1");
                this.f919v = cursor.getColumnIndex("suggest_icon_2");
                this.f920w = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e5) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e5);
        }
    }

    @Override
    public final String mo665c(Cursor cursor) {
        String strM662h;
        String strM662h2;
        if (cursor == null) {
            return null;
        }
        String strM662h3 = m662h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (strM662h3 != null) {
            return strM662h3;
        }
        SearchableInfo searchableInfo = this.f909l;
        if (searchableInfo.shouldRewriteQueryFromData() && (strM662h2 = m662h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return strM662h2;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (strM662h = m662h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return strM662h;
    }

    @Override
    public final View mo666d(ViewGroup viewGroup) {
        View viewInflate = this.f907j.inflate(this.f905h, viewGroup, false);
        viewInflate.setTag(new C0199e3(viewInflate));
        ((ImageView) viewInflate.findViewById(R.id.edit_query)).setImageResource(this.f912o);
        return viewInflate;
    }

    public final Drawable m667e(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f910m.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public final Drawable m668f(String str) {
        WeakHashMap weakHashMap = this.f911n;
        Context context = this.f910m;
        Drawable drawableM667e = null;
        if (str != null && !str.isEmpty() && !SessionDescription.SUPPORTED_SDP_VERSION.equals(str)) {
            try {
                int i6 = Integer.parseInt(str);
                String str2 = "android.resource://" + context.getPackageName() + "/" + i6;
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakHashMap.get(str2);
                Drawable drawableNewDrawable = constantState == null ? null : constantState.newDrawable();
                if (drawableNewDrawable != null) {
                    return drawableNewDrawable;
                }
                Drawable drawableM5069b = AbstractC2115a.m5069b(context, i6);
                if (drawableM5069b != null) {
                    weakHashMap.put(str2, drawableM5069b.getConstantState());
                }
                return drawableM5069b;
            } catch (Resources.NotFoundException unused) {
                Log.w("SuggestionsAdapter", "Icon resource not found: ".concat(str));
                return null;
            } catch (NumberFormatException unused2) {
                Drawable.ConstantState constantState2 = (Drawable.ConstantState) weakHashMap.get(str);
                Drawable drawableNewDrawable2 = constantState2 == null ? null : constantState2.newDrawable();
                if (drawableNewDrawable2 != null) {
                    return drawableNewDrawable2;
                }
                Uri uri = Uri.parse(str);
                try {
                    if ("android.resource".equals(uri.getScheme())) {
                        try {
                            drawableM667e = m667e(uri);
                        } catch (Resources.NotFoundException unused3) {
                            throw new FileNotFoundException("Resource does not exist: " + uri);
                        }
                    } else {
                        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        if (inputStreamOpenInputStream == null) {
                            throw new FileNotFoundException("Failed to open " + uri);
                        }
                        try {
                            Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException e5) {
                                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e5);
                            }
                            drawableM667e = drawableCreateFromStream;
                        } catch (Throwable th) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException e10) {
                                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e10);
                            }
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e11) {
                    Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
                }
                if (drawableM667e != null) {
                    weakHashMap.put(str, drawableM667e.getConstantState());
                }
            }
        }
        return drawableM667e;
    }

    public final Cursor m669g(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        builderFragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f910m.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override
    public final View getDropDownView(int i6, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i6, view, viewGroup);
        } catch (RuntimeException e5) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e5);
            View viewInflate = this.f907j.inflate(this.f906i, viewGroup, false);
            if (viewInflate != null) {
                ((C0199e3) viewInflate.getTag()).f898a.setText(e5.toString());
            }
            return viewInflate;
        }
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i6, view, viewGroup);
        } catch (RuntimeException e5) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e5);
            View viewMo666d = mo666d(viewGroup);
            ((C0199e3) viewMo666d.getTag()).f898a.setText(e5.toString());
            return viewMo666d;
        }
    }

    @Override
    public final boolean hasStableIds() {
        return false;
    }

    @Override
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.f12752c;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f12752c;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f908k.m596r((CharSequence) tag);
        }
    }
}
