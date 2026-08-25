package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2797j;

public final class Handshake$Companion$get$1 extends AbstractC2797j implements InterfaceC2713a {
    final List<Certificate> $peerCertificatesCopy;

    public Handshake$Companion$get$1(List<? extends Certificate> list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override
    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
