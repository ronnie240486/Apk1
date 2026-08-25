package com.trello.rxlifecycle.components.support;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import p042d8.EnumC2335a;
import p265ya.C4279a;

public class RxAppCompatActivity extends AppCompatActivity {

    public final C4279a f7717x = C4279a.m8342a();

    @Override
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7717x.m8343b(EnumC2335a.f8119a);
    }

    @Override
    public final void onDestroy() {
        this.f7717x.m8343b(EnumC2335a.f8124f);
        super.onDestroy();
    }

    @Override
    public final void onPause() {
        this.f7717x.m8343b(EnumC2335a.f8122d);
        super.onPause();
    }

    @Override
    public final void onResume() {
        super.onResume();
        this.f7717x.m8343b(EnumC2335a.f8121c);
    }

    @Override
    public final void onStart() throws IllegalAccessException {
        super.onStart();
        this.f7717x.m8343b(EnumC2335a.f8120b);
    }

    @Override
    public final void onStop() {
        this.f7717x.m8343b(EnumC2335a.f8123e);
        super.onStop();
    }
}
