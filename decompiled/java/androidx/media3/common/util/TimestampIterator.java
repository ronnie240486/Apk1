package androidx.media3.common.util;

@UnstableApi
public interface TimestampIterator {
    TimestampIterator copyOf();

    long getLastTimestampUs();

    boolean hasNext();

    long next();
}
