package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.graphics.drawable.Icon;

public abstract class AbstractC0366z {
    public static Notification.CallStyle m1070a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
    }

    public static Notification.CallStyle m1071b(Person person, PendingIntent pendingIntent) {
        return Notification.CallStyle.forOngoingCall(person, pendingIntent);
    }

    public static Notification.CallStyle m1072c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
    }

    public static Notification.CallStyle m1073d(Notification.CallStyle callStyle, int i6) {
        return callStyle.setAnswerButtonColorHint(i6);
    }

    public static Notification.Action.Builder m1074e(Notification.Action.Builder builder, boolean z7) {
        return builder.setAuthenticationRequired(z7);
    }

    public static Notification.CallStyle m1075f(Notification.CallStyle callStyle, int i6) {
        return callStyle.setDeclineButtonColorHint(i6);
    }

    public static Notification.CallStyle m1076g(Notification.CallStyle callStyle, boolean z7) {
        return callStyle.setIsVideo(z7);
    }

    public static Notification.CallStyle m1077h(Notification.CallStyle callStyle, Icon icon) {
        return callStyle.setVerificationIcon(icon);
    }

    public static Notification.CallStyle m1078i(Notification.CallStyle callStyle, CharSequence charSequence) {
        return callStyle.setVerificationText(charSequence);
    }
}
