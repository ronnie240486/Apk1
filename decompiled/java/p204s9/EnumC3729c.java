package p204s9;

import java.util.concurrent.TimeUnit;

public enum EnumC3729c {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);


    public final TimeUnit f12496a;

    EnumC3729c(TimeUnit timeUnit) {
        this.f12496a = timeUnit;
    }
}
