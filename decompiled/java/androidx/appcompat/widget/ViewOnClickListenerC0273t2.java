package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public final class ViewOnClickListenerC0273t2 implements View.OnClickListener {

    public final SearchView f1066a;

    public ViewOnClickListenerC0273t2(SearchView searchView) {
        this.f1066a = searchView;
    }

    @Override
    public final void onClick(View view) {
        SearchView searchView = this.f1066a;
        ImageView imageView = searchView.f750t;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f746p;
        if (view == imageView) {
            searchView.m603y(false);
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
            View.OnClickListener onClickListener = searchView.f728L;
            if (onClickListener != null) {
                onClickListener.onClick(searchView);
                return;
            }
            return;
        }
        if (view == searchView.f752v) {
            searchView.m593o();
            return;
        }
        if (view == searchView.f751u) {
            searchView.m597s();
            return;
        }
        if (view != searchView.f753w) {
            if (view == searchAutoComplete) {
                searchView.m592n();
                return;
            }
            return;
        }
        SearchableInfo searchableInfo = searchView.f741c0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    searchView.getContext().startActivity(searchView.m591m(searchView.f725I, searchableInfo));
                }
            } else {
                Intent intent = new Intent(searchView.f724H);
                ComponentName searchActivity = searchableInfo.getSearchActivity();
                intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                searchView.getContext().startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }
}
