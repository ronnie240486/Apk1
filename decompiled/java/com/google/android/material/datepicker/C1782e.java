package com.google.android.material.datepicker;

import java.util.ArrayList;
import java.util.Iterator;

public final class C1782e implements InterfaceC1786g {
    @Override
    public final boolean mo4191a(ArrayList arrayList, long j10) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
            if (dateValidator != null && !dateValidator.mo4169d(j10)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final int getId() {
        return 2;
    }
}
