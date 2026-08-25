package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.timepicker.C1891h;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p015b2.C1256h;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p221u6.C3901a;
import p221u6.C3912l;
import p221u6.C3913m;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialButtonToggleGroup extends LinearLayout {

    public static final int f6032k = 0;

    public final ArrayList f6033a;

    public final C0019b f6034b;

    public final LinkedHashSet f6035c;

    public final C1772d f6036d;

    public Integer[] f6037e;

    public boolean f6038f;

    public boolean f6039g;

    public boolean f6040h;

    public final int f6041i;

    public HashSet f6042j;

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (m4145c(i6)) {
                return i6;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (m4145c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i6 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof MaterialButton) && m4145c(i10)) {
                i6++;
            }
        }
        return i6;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            materialButton.setId(View.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f6034b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void m4143a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i6 = firstVisibleChildIndex + 1; i6 < getChildCount(); i6++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i6);
            int iMin = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i6 - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(-iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MaterialButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i6, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        m4144b(materialButton.getId(), materialButton.f6028n);
        C3913m shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f6033a.add(new C1773e(shapeAppearanceModel.f13168e, shapeAppearanceModel.f13171h, shapeAppearanceModel.f13169f, shapeAppearanceModel.f13170g));
        AbstractC3155s0.m6347q(materialButton, new C1256h(1, this));
    }

    public final void m4144b(int i6, boolean z7) {
        if (i6 == -1) {
            Log.e("MaterialButtonToggleGroup", "Button ID is not valid: " + i6);
            return;
        }
        HashSet hashSet = new HashSet(this.f6042j);
        if (z7 && !hashSet.contains(Integer.valueOf(i6))) {
            if (this.f6039g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i6));
        } else {
            if (z7 || !hashSet.contains(Integer.valueOf(i6))) {
                return;
            }
            if (!this.f6040h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i6));
            }
        }
        m4146d(hashSet);
    }

    public final boolean m4145c(int i6) {
        return getChildAt(i6).getVisibility() != 8;
    }

    public final void m4146d(Set set) {
        HashSet hashSet = this.f6042j;
        this.f6042j = new HashSet(set);
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            int id = ((MaterialButton) getChildAt(i6)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.f6038f = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.f6038f = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f6035c.iterator();
                while (it.hasNext()) {
                    ((C1891h) it.next()).m4412a();
                }
            }
        }
        invalidate();
    }

    @Override
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f6036d);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            treeMap.put((MaterialButton) getChildAt(i6), Integer.valueOf(i6));
        }
        this.f6037e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void m4147e() {
        C1773e c1773e;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i6 = 0; i6 < childCount; i6++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i6);
            if (materialButton.getVisibility() != 8) {
                C3912l c3912lM7826f = materialButton.getShapeAppearanceModel().m7826f();
                C1773e c1773e2 = (C1773e) this.f6033a.get(i6);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z7 = getOrientation() == 0;
                    C3901a c3901a = C1773e.f6065e;
                    if (i6 == firstVisibleChildIndex) {
                        c1773e = z7 ? AbstractC1811a0.m4249i(this) ? new C1773e(c3901a, c3901a, c1773e2.f6067b, c1773e2.f6068c) : new C1773e(c1773e2.f6066a, c1773e2.f6069d, c3901a, c3901a) : new C1773e(c1773e2.f6066a, c3901a, c1773e2.f6067b, c3901a);
                    } else if (i6 != lastVisibleChildIndex) {
                        c1773e2 = null;
                    } else if (z7) {
                        c1773e = AbstractC1811a0.m4249i(this) ? new C1773e(c1773e2.f6066a, c1773e2.f6069d, c3901a, c3901a) : new C1773e(c3901a, c3901a, c1773e2.f6067b, c1773e2.f6068c);
                    } else {
                        c1773e = new C1773e(c3901a, c1773e2.f6069d, c3901a, c1773e2.f6068c);
                    }
                    c1773e2 = c1773e;
                }
                if (c1773e2 == null) {
                    c3912lM7826f.m7820c(0.0f);
                } else {
                    c3912lM7826f.f13155e = c1773e2.f6066a;
                    c3912lM7826f.f13158h = c1773e2.f6069d;
                    c3912lM7826f.f13156f = c1773e2.f6067b;
                    c3912lM7826f.f13157g = c1773e2.f6068c;
                }
                materialButton.setShapeAppearanceModel(c3912lM7826f.m7819a());
            }
        }
    }

    public int getCheckedButtonId() {
        if (!this.f6039g || this.f6042j.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f6042j.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            int id = ((MaterialButton) getChildAt(i6)).getId();
            if (this.f6042j.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override
    public final int getChildDrawingOrder(int i6, int i10) {
        Integer[] numArr = this.f6037e;
        if (numArr != null && i10 < numArr.length) {
            return numArr[i10].intValue();
        }
        Log.w("MaterialButtonToggleGroup", "Child order wasn't updated");
        return i10;
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i6 = this.f6041i;
        if (i6 != -1) {
            m4146d(Collections.singleton(Integer.valueOf(i6)));
        }
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) C2782c.m5751x(1, getVisibleButtonCount(), this.f6039g ? 1 : 2, false).f9501b);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        m4147e();
        m4143a();
        super.onMeasure(i6, i10);
    }

    @Override
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f6033a.remove(iIndexOfChild);
        }
        m4147e();
        m4143a();
    }

    public void setSelectionRequired(boolean z7) {
        this.f6040h = z7;
    }

    public void setSingleSelection(boolean z7) {
        if (this.f6039g != z7) {
            this.f6039g = z7;
            m4146d(new HashSet());
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet, i6);
        this.f6033a = new ArrayList();
        this.f6034b = new C0019b(15, this);
        this.f6035c = new LinkedHashSet();
        this.f6036d = new C1772d(this);
        this.f6038f = false;
        this.f6042j = new HashSet();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(getContext(), attributeSet, AbstractC4121a.f14012z, i6, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayM4250j.getBoolean(2, false));
        this.f6041i = typedArrayM4250j.getResourceId(0, -1);
        this.f6040h = typedArrayM4250j.getBoolean(1, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayM4250j.recycle();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setImportantForAccessibility(1);
    }

    public void setSingleSelection(int i6) {
        setSingleSelection(getResources().getBoolean(i6));
    }
}
