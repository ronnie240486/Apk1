package com.lzy.okgo.p031db;

import android.content.ContentValues;
import android.database.Cursor;
import com.lzy.okgo.model.Progress;
import java.util.List;

public class UploadManager extends BaseDao<Progress> {

    public static class UploadManagerHolder {
        private static final UploadManager instance = new UploadManager();

        private UploadManagerHolder() {
        }
    }

    public static UploadManager getInstance() {
        return UploadManagerHolder.instance;
    }

    public boolean clear() {
        return deleteAll();
    }

    public void delete(String str) {
        delete("tag=?", new String[]{str});
    }

    public Progress get(String str) {
        return queryOne("tag=?", new String[]{str});
    }

    public List<Progress> getAll() {
        return query(null, null, null, null, null, "date ASC", null);
    }

    public List<Progress> getFinished() {
        return query(null, "status=?", new String[]{"5"}, null, null, "date ASC", null);
    }

    @Override
    public String getTableName() {
        return "upload";
    }

    public List<Progress> getUploading() {
        return query(null, "status not in(?)", new String[]{"5"}, null, null, "date ASC", null);
    }

    public boolean update(Progress progress) {
        return update(progress, "tag=?", new String[]{progress.tag});
    }

    private UploadManager() {
        super(new DBHelper());
    }

    @Override
    public ContentValues getContentValues(Progress progress) {
        return Progress.buildContentValues(progress);
    }

    @Override
    public Progress parseCursorToBean(Cursor cursor) {
        return Progress.parseCursorToBean(cursor);
    }

    public boolean update(ContentValues contentValues, String str) {
        return update(contentValues, "tag=?", new String[]{str});
    }

    @Override
    public void unInit() {
    }
}
