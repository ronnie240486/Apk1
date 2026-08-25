package com.google.android.material.datepicker;

import java.util.ArrayList;
import java.util.Iterator;

public final class C1780d implements InterfaceC1786g {
    @Override
    public final boolean mo4191a(ArrayList arrayList, long j10) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
            if (dateValidator != null && dateValidator.mo4169d(j10)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final int getId() {
        return 1;
    }
}
