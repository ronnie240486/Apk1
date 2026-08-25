package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import com.p2serv.android.p032ds.R;
import p000a.RunnableC0005f;

class ChipTextInputComboView extends FrameLayout implements Checkable {

    public final Chip f6908a;

    public final EditText f6909b;

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final boolean isChecked() {
        return this.f6908a.isChecked();
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6909b.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override
    public final void setChecked(boolean z7) {
        Chip chip = this.f6908a;
        chip.setChecked(z7);
        int i6 = z7 ? 0 : 4;
        EditText editText = this.f6909b;
        editText.setVisibility(i6);
        chip.setVisibility(z7 ? 8 : 0);
        if (chip.isChecked()) {
            editText.requestFocus();
            editText.post(new RunnableC0005f(10, editText));
            if (TextUtils.isEmpty(editText.getText())) {
                return;
            }
            editText.setSelection(editText.getText().length());
        }
    }

    @Override
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f6908a.setOnClickListener(onClickListener);
    }

    @Override
    public final void setTag(int i6, Object obj) {
        this.f6908a.setTag(i6, obj);
    }

    @Override
    public final void toggle() {
        this.f6908a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f6908a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.f6909b = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new C1884a(this));
        if (Build.VERSION.SDK_INT >= 24) {
            editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
