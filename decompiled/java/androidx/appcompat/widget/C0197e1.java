package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.widget.TextView;

public final class C0197e1 extends C0192d1 {
    @Override
    public void mo651a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    @Override
    public boolean mo657b(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}
