package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import com.quizlet.quizletandroid.R;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final ArrayAdapter j;

    public DropDownPreference(@NonNull Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    public final void b() {
        ArrayAdapter arrayAdapter = this.j;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public DropDownPreference(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item);
        this.j = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.h;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }
}
