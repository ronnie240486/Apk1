package android.support.v4.media;

import android.graphics.drawable.Icon;
import android.media.AudioDeviceCallback;
import android.media.MediaDrmResetException;
import android.os.Parcelable;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public abstract class AbstractC0107a {
    public static Icon m268g(Parcelable parcelable) {
        return (Icon) parcelable;
    }

    public static AudioDeviceCallback m269h(Object obj) {
        return (AudioDeviceCallback) obj;
    }

    public static ThemedSpinnerAdapter m273l(SpinnerAdapter spinnerAdapter) {
        return (ThemedSpinnerAdapter) spinnerAdapter;
    }

    public static boolean m284w(Parcelable parcelable) {
        return parcelable instanceof Icon;
    }

    public static boolean m285x(SpinnerAdapter spinnerAdapter) {
        return spinnerAdapter instanceof ThemedSpinnerAdapter;
    }

    public static boolean m286y(Throwable th) {
        return th instanceof MediaDrmResetException;
    }
}
