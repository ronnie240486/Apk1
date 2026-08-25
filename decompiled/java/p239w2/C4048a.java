package p239w2;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public final class C4048a implements InterfaceC4049b {

    public static final String[] f13708c = {"_data"};

    public static final String[] f13709d = {"_data"};

    public final int f13710a;

    public final ContentResolver f13711b;

    public C4048a(ContentResolver contentResolver, int i6) {
        this.f13710a = i6;
        this.f13711b = contentResolver;
    }

    @Override
    public final Cursor mo8053a(Uri uri) {
        switch (this.f13710a) {
            case 0:
                String lastPathSegment = uri.getLastPathSegment();
                return this.f13711b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f13708c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.f13711b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f13709d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}
