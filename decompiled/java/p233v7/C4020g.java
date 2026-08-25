package p233v7;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ConcurrentLinkedQueue;
import p173q1.RunnableC3431n1;
import p187r4.C3624n;

public final class C4020g extends AbstractC4017d {
    @Override
    public final C4019f mo8006a(C3624n c3624n, String str, String str2) throws Throwable {
        C4015b c4015b = new C4015b((short) (Math.random() * 65535.0d), str2);
        byte[] bArrM8005a = c4015b.m8005a();
        InetAddress byName = InetAddress.getByName(str);
        DatagramSocket datagramSocket = null;
        try {
            DatagramSocket datagramSocket2 = new DatagramSocket();
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bArrM8005a, bArrM8005a.length, byName, 53);
                datagramSocket2.setSoTimeout(this.f13625c * 1000);
                ((ConcurrentLinkedQueue) c3624n.f12182b).add(new RunnableC3431n1(5, datagramSocket2));
                datagramSocket2.send(datagramPacket);
                DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1500], 1500);
                datagramSocket2.receive(datagramPacket2);
                C4019f c4019f = new C4019f(str, 4, c4015b, datagramPacket2.getData());
                datagramSocket2.close();
                return c4019f;
            } catch (Throwable th) {
                th = th;
                datagramSocket = datagramSocket2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
