package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.bumptech.glide.AbstractC1465c;

public final class AsyncTaskC1076a extends AsyncTask {

    public final int f3175a;

    public final Context f3176b;

    public final MediaRouteButton f3177c;

    public AsyncTaskC1076a(MediaRouteButton mediaRouteButton, int i6, Context context) {
        this.f3177c = mediaRouteButton;
        this.f3175a = i6;
        this.f3176b = context;
    }

    @Override
    public final Object doInBackground(Object[] objArr) {
        SparseArray sparseArray = MediaRouteButton.f3145p;
        int i6 = this.f3175a;
        if (((Drawable.ConstantState) sparseArray.get(i6)) == null) {
            return AbstractC1465c.m3473h(this.f3176b, i6);
        }
        return null;
    }

    @Override
    public final void onCancelled(Object obj) {
        Drawable drawable = (Drawable) obj;
        if (drawable != null) {
            MediaRouteButton.f3145p.put(this.f3175a, drawable.getConstantState());
        }
        this.f3177c.f3154g = null;
    }

    @Override
    public final void onPostExecute(Object obj) {
        Drawable drawableNewDrawable = (Drawable) obj;
        int i6 = this.f3175a;
        MediaRouteButton mediaRouteButton = this.f3177c;
        if (drawableNewDrawable != null) {
            MediaRouteButton.f3145p.put(i6, drawableNewDrawable.getConstantState());
            mediaRouteButton.f3154g = null;
        } else {
            Drawable.ConstantState constantState = (Drawable.ConstantState) MediaRouteButton.f3145p.get(i6);
            if (constantState != null) {
                drawableNewDrawable = constantState.newDrawable();
            }
            mediaRouteButton.f3154g = null;
        }
        mediaRouteButton.setRemoteIndicatorDrawableInternal(drawableNewDrawable);
    }
}
