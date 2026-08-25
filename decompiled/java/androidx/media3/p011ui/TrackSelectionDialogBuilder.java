package androidx.media3.p011ui;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.C0138i;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.AbstractC2331z1;
import p041d7.C2215h5;

@UnstableApi
public final class TrackSelectionDialogBuilder {
    private boolean allowAdaptiveSelections;
    private boolean allowMultipleOverrides;
    private final DialogCallback callback;
    private final Context context;
    private boolean isDisabled;
    private AbstractC2331z1 overrides;
    private boolean showDisableOption;
    private int themeResId;
    private final CharSequence title;
    private Comparator<Format> trackFormatComparator;
    private final List<Tracks.Group> trackGroups;
    private TrackNameProvider trackNameProvider;

    public interface DialogCallback {
        void onTracksSelected(boolean z7, Map<TrackGroup, TrackSelectionOverride> map);
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, List<Tracks.Group> list, DialogCallback dialogCallback) {
        this.context = context;
        this.title = charSequence;
        this.trackGroups = AbstractC2301u1.m5272n(list);
        this.callback = dialogCallback;
        this.overrides = C2215h5.f7927g;
    }

    private Dialog buildForAndroidX() {
        try {
            Class cls = Integer.TYPE;
            Object objNewInstance = C0138i.class.getConstructor(Context.class, cls).newInstance(this.context, Integer.valueOf(this.themeResId));
            View viewInflate = LayoutInflater.from((Context) C0138i.class.getMethod("getContext", null).invoke(objNewInstance, null)).inflate(C1051R.layout.exo_track_selection_dialog, (ViewGroup) null);
            DialogInterface.OnClickListener upDialogView = setUpDialogView(viewInflate);
            C0138i.class.getMethod("setTitle", CharSequence.class).invoke(objNewInstance, this.title);
            C0138i.class.getMethod("setView", View.class).invoke(objNewInstance, viewInflate);
            C0138i.class.getMethod("setPositiveButton", cls, DialogInterface.OnClickListener.class).invoke(objNewInstance, Integer.valueOf(R.string.ok), upDialogView);
            C0138i.class.getMethod("setNegativeButton", cls, DialogInterface.OnClickListener.class).invoke(objNewInstance, Integer.valueOf(R.string.cancel), null);
            return (Dialog) C0138i.class.getMethod("create", null).invoke(objNewInstance, null);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    private Dialog buildForPlatform() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context, this.themeResId);
        View viewInflate = LayoutInflater.from(builder.getContext()).inflate(C1051R.layout.exo_track_selection_dialog, (ViewGroup) null);
        return builder.setTitle(this.title).setView(viewInflate).setPositiveButton(R.string.ok, setUpDialogView(viewInflate)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
    }

    public static void lambda$new$0(Player player, int i6, boolean z7, Map map) {
        if (player.isCommandAvailable(29)) {
            TrackSelectionParameters.Builder builderBuildUpon = player.getTrackSelectionParameters().buildUpon();
            builderBuildUpon.setTrackTypeDisabled(i6, z7);
            builderBuildUpon.clearOverridesOfType(i6);
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                builderBuildUpon.addOverride((TrackSelectionOverride) it.next());
            }
            player.setTrackSelectionParameters(builderBuildUpon.build());
        }
    }

    public void lambda$setUpDialogView$1(TrackSelectionView trackSelectionView, DialogInterface dialogInterface, int i6) {
        this.callback.onTracksSelected(trackSelectionView.getIsDisabled(), trackSelectionView.getOverrides());
    }

    private DialogInterface.OnClickListener setUpDialogView(View view) {
        final TrackSelectionView trackSelectionView = (TrackSelectionView) view.findViewById(C1051R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(this.allowMultipleOverrides);
        trackSelectionView.setAllowAdaptiveSelections(this.allowAdaptiveSelections);
        trackSelectionView.setShowDisableOption(this.showDisableOption);
        TrackNameProvider trackNameProvider = this.trackNameProvider;
        if (trackNameProvider != null) {
            trackSelectionView.setTrackNameProvider(trackNameProvider);
        }
        trackSelectionView.init(this.trackGroups, this.isDisabled, this.overrides, this.trackFormatComparator, null);
        return new DialogInterface.OnClickListener() {
            @Override
            public final void onClick(DialogInterface dialogInterface, int i6) {
                this.f3140a.lambda$setUpDialogView$1(trackSelectionView, dialogInterface, i6);
            }
        };
    }

    public Dialog build() {
        Dialog dialogBuildForAndroidX = buildForAndroidX();
        return dialogBuildForAndroidX == null ? buildForPlatform() : dialogBuildForAndroidX;
    }

    public TrackSelectionDialogBuilder setAllowAdaptiveSelections(boolean z7) {
        this.allowAdaptiveSelections = z7;
        return this;
    }

    public TrackSelectionDialogBuilder setAllowMultipleOverrides(boolean z7) {
        this.allowMultipleOverrides = z7;
        return this;
    }

    public TrackSelectionDialogBuilder setIsDisabled(boolean z7) {
        this.isDisabled = z7;
        return this;
    }

    public TrackSelectionDialogBuilder setOverride(TrackSelectionOverride trackSelectionOverride) {
        Map<TrackGroup, TrackSelectionOverride> mapM5205g;
        if (trackSelectionOverride == null) {
            mapM5205g = Collections.emptyMap();
        } else {
            TrackGroup trackGroup = trackSelectionOverride.mediaTrackGroup;
            AbstractC2182d0.m5140c(trackGroup, trackSelectionOverride);
            mapM5205g = C2215h5.m5205g(1, new Object[]{trackGroup, trackSelectionOverride}, null);
        }
        return setOverrides(mapM5205g);
    }

    public TrackSelectionDialogBuilder setOverrides(Map<TrackGroup, TrackSelectionOverride> map) {
        this.overrides = AbstractC2331z1.m5296b(map);
        return this;
    }

    public TrackSelectionDialogBuilder setShowDisableOption(boolean z7) {
        this.showDisableOption = z7;
        return this;
    }

    public TrackSelectionDialogBuilder setTheme(int i6) {
        this.themeResId = i6;
        return this;
    }

    public void setTrackFormatComparator(Comparator<Format> comparator) {
        this.trackFormatComparator = comparator;
    }

    public TrackSelectionDialogBuilder setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.trackNameProvider = trackNameProvider;
        return this;
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, final Player player, final int i6) {
        this.context = context;
        this.title = charSequence;
        AbstractC2301u1 groups = (player.isCommandAvailable(30) ? player.getCurrentTracks() : Tracks.EMPTY).getGroups();
        this.trackGroups = new ArrayList();
        for (int i10 = 0; i10 < groups.size(); i10++) {
            Tracks.Group group = (Tracks.Group) groups.get(i10);
            if (group.getType() == i6) {
                this.trackGroups.add(group);
            }
        }
        this.overrides = player.getTrackSelectionParameters().overrides;
        this.callback = new DialogCallback() {
            @Override
            public final void onTracksSelected(boolean z7, Map map) {
                TrackSelectionDialogBuilder.lambda$new$0(player, i6, z7, map);
            }
        };
    }
}
