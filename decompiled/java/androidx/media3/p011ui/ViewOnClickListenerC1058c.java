package androidx.media3.p011ui;

import android.view.View;

public final class ViewOnClickListenerC1058c implements View.OnClickListener {

    public final int f3119a;

    public final Object f3120b;

    public ViewOnClickListenerC1058c(int i6, Object obj) {
        this.f3119a = i6;
        this.f3120b = obj;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f3119a) {
            case 0:
                ((PlayerControlView.AudioTrackSelectionAdapter) this.f3120b).lambda$onBindViewHolderAtZeroPosition$0(view);
                break;
            case 1:
                ((PlayerControlView.SettingViewHolder) this.f3120b).lambda$new$0(view);
                break;
            case 2:
                ((PlayerControlView.TextTrackSelectionAdapter) this.f3120b).lambda$onBindViewHolderAtZeroPosition$0(view);
                break;
            case 3:
                ((PlayerControlViewLayoutManager) this.f3120b).onOverflowButtonClick(view);
                break;
            default:
                ((PlayerControlView) this.f3120b).onFullscreenButtonClicked(view);
                break;
        }
    }
}
