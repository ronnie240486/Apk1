package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;

public abstract class AbstractC0315a1 {
    public static C0318b1 m945a(Person person) {
        CharSequence name = person.getName();
        IconCompat iconCompatM1085c = person.getIcon() != null ? IconCompat.m1085c(person.getIcon()) : null;
        String uri = person.getUri();
        String key = person.getKey();
        boolean zIsBot = person.isBot();
        boolean zIsImportant = person.isImportant();
        C0318b1 c0318b1 = new C0318b1();
        c0318b1.f1481a = name;
        c0318b1.f1482b = iconCompatM1085c;
        c0318b1.f1483c = uri;
        c0318b1.f1484d = key;
        c0318b1.f1485e = zIsBot;
        c0318b1.f1486f = zIsImportant;
        return c0318b1;
    }

    public static Person m946b(C0318b1 c0318b1) {
        Person.Builder name = new Person.Builder().setName(c0318b1.f1481a);
        IconCompat iconCompat = c0318b1.f1482b;
        return name.setIcon(iconCompat != null ? iconCompat.m1096n(null) : null).setUri(c0318b1.f1483c).setKey(c0318b1.f1484d).setBot(c0318b1.f1485e).setImportant(c0318b1.f1486f).build();
    }
}
