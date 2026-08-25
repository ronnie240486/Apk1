package p103j9;

public final class C2803p {
    public static String m5795a(InterfaceC2794g interfaceC2794g) {
        String string = interfaceC2794g.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
