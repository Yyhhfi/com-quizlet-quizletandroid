package com.comscore.util.crashreport;

/* loaded from: classes.dex */
public interface CrashReportFlusher {
    boolean flush(String str, CrashReportParser crashReportParser, CrashReport crashReport);
}
