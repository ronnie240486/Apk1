package p035d1;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.nio.ByteBuffer;
import p014b1.C1232f;
import p014b1.C1235i;
import p024c1.C1378b;
import p249x4.C4112e;

public final class C2124b extends InputConnectionWrapper {

    public final EditText f7732a;

    public final C4112e f7733b;

    public C2124b(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        C4112e c4112e = new C4112e(7);
        super(inputConnection, false);
        this.f7732a = editText;
        this.f7733b = c4112e;
        if (C1235i.f3923j != null) {
            C1235i c1235iM3106a = C1235i.m3106a();
            if (c1235iM3106a.m3107b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            C1232f c1232f = c1235iM3106a.f3928e;
            c1232f.getClass();
            Bundle bundle = editorInfo.extras;
            C1378b c1378b = (C1378b) c1232f.f3921c.f44b;
            int iM3244a = c1378b.m3244a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iM3244a != 0 ? ((ByteBuffer) c1378b.f4194d).getInt(iM3244a + c1378b.f4191a) : 0);
            Bundle bundle2 = editorInfo.extras;
            c1232f.f3919a.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override
    public final boolean deleteSurroundingText(int i6, int i10) {
        Editable editableText = this.f7732a.getEditableText();
        this.f7733b.getClass();
        return C4112e.m8131q(this, editableText, i6, i10, false) || super.deleteSurroundingText(i6, i10);
    }

    @Override
    public final boolean deleteSurroundingTextInCodePoints(int i6, int i10) {
        Editable editableText = this.f7732a.getEditableText();
        this.f7733b.getClass();
        return C4112e.m8131q(this, editableText, i6, i10, true) || super.deleteSurroundingTextInCodePoints(i6, i10);
    }
}
