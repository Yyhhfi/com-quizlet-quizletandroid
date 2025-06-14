package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.quizlet.quizletandroid.R;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchPreference(@NonNull Context context, AttributeSet attributeSet) {
        int iB = androidx.core.content.res.b.b(context, R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle);
        super(context, attributeSet, iB);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j, iB, 0);
        if (typedArrayObtainStyledAttributes.getString(7) == null) {
            typedArrayObtainStyledAttributes.getString(0);
        }
        if (typedArrayObtainStyledAttributes.getString(6) == null) {
            typedArrayObtainStyledAttributes.getString(1);
        }
        if (typedArrayObtainStyledAttributes.getString(9) == null) {
            typedArrayObtainStyledAttributes.getString(3);
        }
        if (typedArrayObtainStyledAttributes.getString(8) == null) {
            typedArrayObtainStyledAttributes.getString(4);
        }
        typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public SwitchPreference(@NonNull Context context) {
        this(context, null);
    }
}
