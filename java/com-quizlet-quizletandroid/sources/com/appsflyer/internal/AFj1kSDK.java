package com.appsflyer.internal;

import android.database.Cursor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class AFj1kSDK {
    public static final String P_(@NotNull Cursor cursor, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cursor, "");
        Intrinsics.checkNotNullParameter(str, "");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
