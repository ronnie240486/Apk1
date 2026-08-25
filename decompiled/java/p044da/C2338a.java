package p044da;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class C2338a extends Thread {

    public final String f8138a;

    public final String f8139b;

    public final C2340c f8140c;

    public C2338a(C2340c c2340c, String str, String str2) {
        this.f8140c = c2340c;
        this.f8138a = str;
        this.f8139b = str2;
    }

    @Override
    public final void run() throws Throwable {
        BufferedWriter bufferedWriter;
        Throwable th;
        IOException e5;
        C2340c c2340c = this.f8140c;
        File fileM5303c = c2340c.f8149b.m5303c(this.f8138a);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileM5303c), 1024);
            try {
                try {
                    bufferedWriter.write(this.f8139b);
                    try {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                } catch (IOException e11) {
                    e5 = e11;
                    e5.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                C2339b.m5301a(c2340c.f8149b, fileM5303c);
                throw th;
            }
        } catch (IOException e14) {
            bufferedWriter = null;
            e5 = e14;
        } catch (Throwable th3) {
            bufferedWriter = null;
            th = th3;
            if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            C2339b.m5301a(c2340c.f8149b, fileM5303c);
            throw th;
        }
        C2339b.m5301a(c2340c.f8149b, fileM5303c);
    }
}
