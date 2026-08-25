package com.trello.rxlifecycle.components;

import android.app.Activity;
import android.os.Bundle;
import p042d8.EnumC2335a;
import p265ya.C4279a;

public class RxActivity extends Activity {

    public final C4279a f7716a = C4279a.m8342a();

    @Override
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7716a.m8343b(EnumC2335a.f8119a);
    }

    @Override
    public final void onDestroy() {
        this.f7716a.m8343b(EnumC2335a.f8124f);
        super.onDestroy();
    }

    @Override
    public final void onPause() {
        this.f7716a.m8343b(EnumC2335a.f8122d);
        super.onPause();
    }

    @Override
    public final void onResume() {
        super.onResume();
        this.f7716a.m8343b(EnumC2335a.f8121c);
    }

    @Override
    public final void onStart() {
        super.onStart();
        this.f7716a.m8343b(EnumC2335a.f8120b);
    }

    @Override
    public final void onStop() {
        this.f7716a.m8343b(EnumC2335a.f8123e);
        super.onStop();
    }
}
