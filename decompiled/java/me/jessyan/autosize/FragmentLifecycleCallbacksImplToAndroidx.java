package me.jessyan.autosize;

import android.os.Bundle;
import androidx.fragment.app.AbstractC0404g0;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;

public class FragmentLifecycleCallbacksImplToAndroidx extends AbstractC0404g0 {
    private AutoAdaptStrategy mAutoAdaptStrategy;

    public FragmentLifecycleCallbacksImplToAndroidx(AutoAdaptStrategy autoAdaptStrategy) {
        this.mAutoAdaptStrategy = autoAdaptStrategy;
    }

    @Override
    public void onFragmentCreated(AbstractC0410j0 abstractC0410j0, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, Bundle bundle) {
        AutoAdaptStrategy autoAdaptStrategy = this.mAutoAdaptStrategy;
        if (autoAdaptStrategy != null) {
            autoAdaptStrategy.applyAdapt(abstractComponentCallbacksC0427s, abstractComponentCallbacksC0427s.m1319h());
        }
    }

    public void setAutoAdaptStrategy(AutoAdaptStrategy autoAdaptStrategy) {
        this.mAutoAdaptStrategy = autoAdaptStrategy;
    }
}
