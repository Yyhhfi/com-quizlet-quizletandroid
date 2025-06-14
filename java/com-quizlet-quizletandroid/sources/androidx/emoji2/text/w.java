package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class w implements TextWatcher, SpanWatcher {
    public final Object a;
    public final AtomicInteger b = new AtomicInteger(0);

    public w(Object obj) {
        this.a = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.a).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.a).beforeTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        if (this.b.get() <= 0 || !(obj instanceof z)) {
            ((SpanWatcher) this.a).onSpanAdded(spannable, obj, i, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[PHI: r11
  0x001c: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0011, B:12:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.text.SpanWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSpanChanged(android.text.Spannable r9, java.lang.Object r10, int r11, int r12, int r13, int r14) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r8.b
            int r0 = r0.get()
            if (r0 <= 0) goto Ld
            boolean r0 = r10 instanceof androidx.emoji2.text.z
            if (r0 == 0) goto Ld
            return
        Ld:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L1c
            r0 = 0
            if (r11 <= r12) goto L17
            r11 = r0
        L17:
            if (r13 <= r14) goto L1c
            r4 = r11
            r6 = r0
            goto L1e
        L1c:
            r4 = r11
            r6 = r13
        L1e:
            java.lang.Object r11 = r8.a
            r1 = r11
            android.text.SpanWatcher r1 = (android.text.SpanWatcher) r1
            r2 = r9
            r3 = r10
            r5 = r12
            r7 = r14
            r1.onSpanChanged(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.w.onSpanChanged(android.text.Spannable, java.lang.Object, int, int, int, int):void");
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        if (this.b.get() <= 0 || !(obj instanceof z)) {
            ((SpanWatcher) this.a).onSpanRemoved(spannable, obj, i, i2);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.a).onTextChanged(charSequence, i, i2, i3);
    }
}
