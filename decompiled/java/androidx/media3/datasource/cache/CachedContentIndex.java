package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.AtomicFile;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p000a.AbstractC0004e;
import p041d7.AbstractC2233k2;
import p041d7.AbstractC2292s5;
import p055ea.AbstractC2460q;

class CachedContentIndex {
    static final String FILE_NAME_ATOMIC = "cached_content_index.exi";
    private static final int INCREMENTAL_METADATA_READ_LENGTH = 10485760;
    private final SparseArray<String> idToKey;
    private final HashMap<String, CachedContent> keyToContent;
    private final SparseBooleanArray newIds;
    private Storage previousStorage;
    private final SparseBooleanArray removedIds;
    private Storage storage;

    public static final class DatabaseStorage implements Storage {
        private static final String[] COLUMNS = {"id", "key", "metadata"};
        private static final String COLUMN_ID = "id";
        private static final int COLUMN_INDEX_ID = 0;
        private static final int COLUMN_INDEX_KEY = 1;
        private static final int COLUMN_INDEX_METADATA = 2;
        private static final String COLUMN_KEY = "key";
        private static final String COLUMN_METADATA = "metadata";
        private static final String TABLE_PREFIX = "ExoPlayerCacheIndex";
        private static final String TABLE_SCHEMA = "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)";
        private static final int TABLE_VERSION = 1;
        private static final String WHERE_ID_EQUALS = "id = ?";
        private final DatabaseProvider databaseProvider;
        private String hexUid;
        private final SparseArray<CachedContent> pendingUpdates = new SparseArray<>();
        private String tableName;

        public DatabaseStorage(DatabaseProvider databaseProvider) {
            this.databaseProvider = databaseProvider;
        }

        private void addOrUpdateRow(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.writeContentMetadata(cachedContent.getMetadata(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(cachedContent.f2670id));
            contentValues.put("key", cachedContent.key);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) Assertions.checkNotNull(this.tableName), null, contentValues);
        }

        public static void delete(DatabaseProvider databaseProvider, long j10) throws DatabaseIOException {
            delete(databaseProvider, Long.toHexString(j10));
        }

        private void deleteRow(SQLiteDatabase sQLiteDatabase, int i6) {
            sQLiteDatabase.delete((String) Assertions.checkNotNull(this.tableName), WHERE_ID_EQUALS, new String[]{Integer.toString(i6)});
        }

        private static void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor getCursor() {
            return this.databaseProvider.getReadableDatabase().query((String) Assertions.checkNotNull(this.tableName), COLUMNS, null, null, null, null, null);
        }

        private static String getTableName(String str) {
            return AbstractC2460q.m5501o(TABLE_PREFIX, str);
        }

        private void initializeTable(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.setVersion(sQLiteDatabase, 1, (String) Assertions.checkNotNull(this.hexUid), 1);
            dropTable(sQLiteDatabase, (String) Assertions.checkNotNull(this.tableName));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.tableName + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override
        public boolean exists() throws DatabaseIOException {
            try {
                return VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, (String) Assertions.checkNotNull(this.hexUid)) != -1;
            } catch (SQLException e5) {
                throw new DatabaseIOException(e5);
            }
        }

        @Override
        public void initialize(long j10) {
            String hexString = Long.toHexString(j10);
            this.hexUid = hexString;
            this.tableName = getTableName(hexString);
        }

        @Override
        public void load(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws IOException {
            Assertions.checkState(this.pendingUpdates.size() == 0);
            try {
                if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, (String) Assertions.checkNotNull(this.hexUid)) != 1) {
                    SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        initializeTable(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor cursor = getCursor();
                while (cursor.moveToNext()) {
                    try {
                        CachedContent cachedContent = new CachedContent(cursor.getInt(0), (String) Assertions.checkNotNull(cursor.getString(1)), CachedContentIndex.readContentMetadata(new DataInputStream(new ByteArrayInputStream(cursor.getBlob(2)))));
                        map.put(cachedContent.key, cachedContent);
                        sparseArray.put(cachedContent.f2670id, cachedContent.key);
                    } catch (Throwable th2) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
                cursor.close();
            } catch (SQLiteException e5) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e5);
            }
        }

        @Override
        public void onRemove(CachedContent cachedContent, boolean z7) {
            if (z7) {
                this.pendingUpdates.delete(cachedContent.f2670id);
            } else {
                this.pendingUpdates.put(cachedContent.f2670id, null);
            }
        }

        @Override
        public void onUpdate(CachedContent cachedContent) {
            this.pendingUpdates.put(cachedContent.f2670id, cachedContent);
        }

        @Override
        public void storeFully(HashMap<String, CachedContent> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    initializeTable(writableDatabase);
                    Iterator<CachedContent> it = map.values().iterator();
                    while (it.hasNext()) {
                        addOrUpdateRow(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.pendingUpdates.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e5) {
                throw new DatabaseIOException(e5);
            }
        }

        @Override
        public void storeIncremental(HashMap<String, CachedContent> map) throws IOException {
            if (this.pendingUpdates.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i6 = 0; i6 < this.pendingUpdates.size(); i6++) {
                    try {
                        CachedContent cachedContentValueAt = this.pendingUpdates.valueAt(i6);
                        if (cachedContentValueAt == null) {
                            deleteRow(writableDatabase, this.pendingUpdates.keyAt(i6));
                        } else {
                            addOrUpdateRow(writableDatabase, cachedContentValueAt);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.pendingUpdates.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e5) {
                throw new DatabaseIOException(e5);
            }
        }

        @Override
        public void delete() throws DatabaseIOException {
            delete(this.databaseProvider, (String) Assertions.checkNotNull(this.hexUid));
        }

        private static void delete(DatabaseProvider databaseProvider, String str) throws DatabaseIOException {
            try {
                String tableName = getTableName(str);
                SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.removeVersion(writableDatabase, 1, str);
                    dropTable(writableDatabase, tableName);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e5) {
                throw new DatabaseIOException(e5);
            }
        }
    }

    public interface Storage {
        void delete() throws IOException;

        boolean exists() throws IOException;

        void initialize(long j10);

        void load(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws IOException;

        void onRemove(CachedContent cachedContent, boolean z7);

        void onUpdate(CachedContent cachedContent);

        void storeFully(HashMap<String, CachedContent> map) throws IOException;

        void storeIncremental(HashMap<String, CachedContent> map) throws IOException;
    }

    public CachedContentIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, null, null, false, false);
    }

    private CachedContent addNew(String str) {
        int newId = getNewId(this.idToKey);
        CachedContent cachedContent = new CachedContent(newId, str);
        this.keyToContent.put(str, cachedContent);
        this.idToKey.put(newId, str);
        this.newIds.put(newId, true);
        this.storage.onUpdate(cachedContent);
        return cachedContent;
    }

    public static void delete(DatabaseProvider databaseProvider, long j10) throws DatabaseIOException {
        DatabaseStorage.delete(databaseProvider, j10);
    }

    public static int getNewId(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i6 = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt >= 0) {
            return iKeyAt;
        }
        while (i6 < size && i6 == sparseArray.keyAt(i6)) {
            i6++;
        }
        return i6;
    }

    public static boolean isIndexFile(String str) {
        return str.startsWith(FILE_NAME_ATOMIC);
    }

    public static DefaultContentMetadata readContentMetadata(DataInputStream dataInputStream) throws IOException {
        int i6 = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < i6; i10++) {
            String utf = dataInputStream.readUTF();
            int i11 = dataInputStream.readInt();
            if (i11 < 0) {
                throw new IOException(AbstractC0004e.m20n(i11, "Invalid value size: "));
            }
            int iMin = Math.min(i11, INCREMENTAL_METADATA_READ_LENGTH);
            byte[] bArrCopyOf = Util.EMPTY_BYTE_ARRAY;
            int i12 = 0;
            while (i12 != i11) {
                int i13 = i12 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i13);
                dataInputStream.readFully(bArrCopyOf, i12, iMin);
                iMin = Math.min(i11 - i13, INCREMENTAL_METADATA_READ_LENGTH);
                i12 = i13;
            }
            map.put(utf, bArrCopyOf);
        }
        return new DefaultContentMetadata(map);
    }

    public static void writeContentMetadata(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setEntrySet = defaultContentMetadata.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry<String, byte[]> entry : setEntrySet) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) {
        CachedContent orAdd = getOrAdd(str);
        if (orAdd.applyMetadataMutations(contentMetadataMutations)) {
            this.storage.onUpdate(orAdd);
        }
    }

    public int assignIdForKey(String str) {
        return getOrAdd(str).f2670id;
    }

    public CachedContent get(String str) {
        return this.keyToContent.get(str);
    }

    public Collection<CachedContent> getAll() {
        return Collections.unmodifiableCollection(this.keyToContent.values());
    }

    public ContentMetadata getContentMetadata(String str) {
        CachedContent cachedContent = get(str);
        return cachedContent != null ? cachedContent.getMetadata() : DefaultContentMetadata.EMPTY;
    }

    public String getKeyForId(int i6) {
        return this.idToKey.get(i6);
    }

    public Set<String> getKeys() {
        return this.keyToContent.keySet();
    }

    public CachedContent getOrAdd(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        return cachedContent == null ? addNew(str) : cachedContent;
    }

    public void initialize(long j10) throws IOException {
        Storage storage;
        this.storage.initialize(j10);
        Storage storage2 = this.previousStorage;
        if (storage2 != null) {
            storage2.initialize(j10);
        }
        if (this.storage.exists() || (storage = this.previousStorage) == null || !storage.exists()) {
            this.storage.load(this.keyToContent, this.idToKey);
        } else {
            this.previousStorage.load(this.keyToContent, this.idToKey);
            this.storage.storeFully(this.keyToContent);
        }
        Storage storage3 = this.previousStorage;
        if (storage3 != null) {
            storage3.delete();
            this.previousStorage = null;
        }
    }

    public void maybeRemove(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        if (cachedContent != null && cachedContent.isEmpty() && cachedContent.isFullyUnlocked()) {
            this.keyToContent.remove(str);
            int i6 = cachedContent.f2670id;
            boolean z7 = this.newIds.get(i6);
            this.storage.onRemove(cachedContent, z7);
            if (z7) {
                this.idToKey.remove(i6);
                this.newIds.delete(i6);
            } else {
                this.idToKey.put(i6, null);
                this.removedIds.put(i6, true);
            }
        }
    }

    public void removeEmpty() {
        AbstractC2292s5 it = AbstractC2233k2.m5236l(this.keyToContent.keySet()).iterator();
        while (it.hasNext()) {
            maybeRemove((String) it.next());
        }
    }

    public void store() throws IOException {
        this.storage.storeIncremental(this.keyToContent);
        int size = this.removedIds.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.idToKey.remove(this.removedIds.keyAt(i6));
        }
        this.removedIds.clear();
        this.newIds.clear();
    }

    public CachedContentIndex(DatabaseProvider databaseProvider, File file, byte[] bArr, boolean z7, boolean z10) {
        Assertions.checkState((databaseProvider == null && file == null) ? false : true);
        this.keyToContent = new HashMap<>();
        this.idToKey = new SparseArray<>();
        this.removedIds = new SparseBooleanArray();
        this.newIds = new SparseBooleanArray();
        DatabaseStorage databaseStorage = databaseProvider != null ? new DatabaseStorage(databaseProvider) : null;
        LegacyStorage legacyStorage = file != null ? new LegacyStorage(new File(file, FILE_NAME_ATOMIC), bArr, z7) : null;
        if (databaseStorage == null || (legacyStorage != null && z10)) {
            this.storage = (Storage) Util.castNonNull(legacyStorage);
            this.previousStorage = databaseStorage;
        } else {
            this.storage = databaseStorage;
            this.previousStorage = legacyStorage;
        }
    }

    public static class LegacyStorage implements Storage {
        private static final int FLAG_ENCRYPTED_INDEX = 1;
        private static final int VERSION = 2;
        private static final int VERSION_METADATA_INTRODUCED = 2;
        private final AtomicFile atomicFile;
        private ReusableBufferedOutputStream bufferedOutputStream;
        private boolean changed;
        private final Cipher cipher;
        private final boolean encrypt;
        private final SecureRandom random;
        private final SecretKeySpec secretKeySpec;

        public LegacyStorage(File file, byte[] bArr, boolean z7) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            Assertions.checkState((bArr == null && z7) ? false : true);
            if (bArr != null) {
                Assertions.checkArgument(bArr.length == 16);
                try {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e5) {
                    throw new IllegalStateException(e5);
                }
            } else {
                Assertions.checkArgument(!z7);
                cipher = null;
                secretKeySpec = null;
            }
            this.encrypt = z7;
            this.cipher = cipher;
            this.secretKeySpec = secretKeySpec;
            this.random = z7 ? new SecureRandom() : null;
            this.atomicFile = new AtomicFile(file);
        }

        private int hashCachedContent(CachedContent cachedContent, int i6) {
            int iHashCode = cachedContent.key.hashCode() + (cachedContent.f2670id * 31);
            if (i6 >= 2) {
                return (iHashCode * 31) + cachedContent.getMetadata().hashCode();
            }
            long jM1779a = AbstractC0645b.m1779a(cachedContent.getMetadata());
            return (iHashCode * 31) + ((int) (jM1779a ^ (jM1779a >>> 32)));
        }

        private CachedContent readCachedContent(int i6, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata contentMetadata;
            int i10 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i6 < 2) {
                long j10 = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.setContentLength(contentMetadataMutations, j10);
                contentMetadata = DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations);
            } else {
                contentMetadata = CachedContentIndex.readContentMetadata(dataInputStream);
            }
            return new CachedContent(i10, utf, contentMetadata);
        }

        private boolean readFile(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws Throwable {
            if (!this.atomicFile.exists()) {
                return true;
            }
            DataInputStream dataInputStream = null;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.atomicFile.openRead());
                DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                try {
                    int i6 = dataInputStream2.readInt();
                    if (i6 >= 0 && i6 <= 2) {
                        if ((dataInputStream2.readInt() & 1) != 0) {
                            if (this.cipher == null) {
                                Util.closeQuietly(dataInputStream2);
                                return false;
                            }
                            byte[] bArr = new byte[16];
                            dataInputStream2.readFully(bArr);
                            try {
                                this.cipher.init(2, (Key) Util.castNonNull(this.secretKeySpec), new IvParameterSpec(bArr));
                                dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.cipher));
                            } catch (InvalidAlgorithmParameterException e5) {
                                e = e5;
                                throw new IllegalStateException(e);
                            } catch (InvalidKeyException e10) {
                                e = e10;
                                throw new IllegalStateException(e);
                            }
                        } else if (this.encrypt) {
                            this.changed = true;
                        }
                        int i10 = dataInputStream2.readInt();
                        int iHashCachedContent = 0;
                        for (int i11 = 0; i11 < i10; i11++) {
                            CachedContent cachedContent = readCachedContent(i6, dataInputStream2);
                            map.put(cachedContent.key, cachedContent);
                            sparseArray.put(cachedContent.f2670id, cachedContent.key);
                            iHashCachedContent += hashCachedContent(cachedContent, i6);
                        }
                        int i12 = dataInputStream2.readInt();
                        boolean z7 = dataInputStream2.read() == -1;
                        if (i12 == iHashCachedContent && z7) {
                            Util.closeQuietly(dataInputStream2);
                            return true;
                        }
                        Util.closeQuietly(dataInputStream2);
                        return false;
                    }
                    Util.closeQuietly(dataInputStream2);
                    return false;
                } catch (IOException unused) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        Util.closeQuietly(dataInputStream);
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        Util.closeQuietly(dataInputStream);
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private void writeCachedContent(CachedContent cachedContent, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(cachedContent.f2670id);
            dataOutputStream.writeUTF(cachedContent.key);
            CachedContentIndex.writeContentMetadata(cachedContent.getMetadata(), dataOutputStream);
        }

        private void writeFile(HashMap<String, CachedContent> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamStartWrite = this.atomicFile.startWrite();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
                if (reusableBufferedOutputStream == null) {
                    this.bufferedOutputStream = new ReusableBufferedOutputStream(outputStreamStartWrite);
                } else {
                    reusableBufferedOutputStream.reset(outputStreamStartWrite);
                }
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.bufferedOutputStream;
                DataOutputStream dataOutputStream2 = new DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    int iHashCachedContent = 0;
                    dataOutputStream2.writeInt(this.encrypt ? 1 : 0);
                    if (this.encrypt) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) Util.castNonNull(this.random)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) Util.castNonNull(this.cipher)).init(1, (Key) Util.castNonNull(this.secretKeySpec), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream2, this.cipher));
                        } catch (InvalidAlgorithmParameterException e5) {
                            e = e5;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e10) {
                            e = e10;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(map.size());
                    for (CachedContent cachedContent : map.values()) {
                        writeCachedContent(cachedContent, dataOutputStream2);
                        iHashCachedContent += hashCachedContent(cachedContent, 2);
                    }
                    dataOutputStream2.writeInt(iHashCachedContent);
                    this.atomicFile.endWrite(dataOutputStream2);
                    Util.closeQuietly(null);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    Util.closeQuietly(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override
        public void delete() {
            this.atomicFile.delete();
        }

        @Override
        public boolean exists() {
            return this.atomicFile.exists();
        }

        @Override
        public void load(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) {
            Assertions.checkState(!this.changed);
            if (readFile(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.atomicFile.delete();
        }

        @Override
        public void onRemove(CachedContent cachedContent, boolean z7) {
            this.changed = true;
        }

        @Override
        public void onUpdate(CachedContent cachedContent) {
            this.changed = true;
        }

        @Override
        public void storeFully(HashMap<String, CachedContent> map) throws Throwable {
            writeFile(map);
            this.changed = false;
        }

        @Override
        public void storeIncremental(HashMap<String, CachedContent> map) throws Throwable {
            if (this.changed) {
                storeFully(map);
            }
        }

        @Override
        public void initialize(long j10) {
        }
    }
}
