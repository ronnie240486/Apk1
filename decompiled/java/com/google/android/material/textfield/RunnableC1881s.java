package com.google.android.material.textfield;

public final class RunnableC1881s implements Runnable {

    public final int f6905a;

    public final TextInputLayout f6906b;

    public RunnableC1881s(TextInputLayout textInputLayout, int i6) {
        this.f6905a = i6;
        this.f6906b = textInputLayout;
    }

    @Override
    public final void run() {
        switch (this.f6905a) {
            case 0:
                TextInputLayout textInputLayout = this.f6906b;
                textInputLayout.f6781f0.performClick();
                textInputLayout.f6781f0.jumpDrawablesToCurrentState();
                break;
            default:
                this.f6906b.f6778e.requestLayout();
                break;
        }
    }
}
