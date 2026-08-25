package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public interface DateSelector<S> extends Parcelable {
    String mo4170a(Context context);

    int mo4171b(Context context);

    ArrayList mo4172c();

    View mo4173e(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, C1803t c1803t);

    boolean mo4174f();

    ArrayList mo4175g();

    Object mo4176i();

    void mo4177k(long j10);
}
