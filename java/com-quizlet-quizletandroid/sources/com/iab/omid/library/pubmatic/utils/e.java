package com.iab.omid.library.pubmatic.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.iab.omid.library.pubmatic.adsession.DeviceCategory;
import com.iab.omid.library.pubmatic.adsession.OutputDeviceStatus;

/* loaded from: classes2.dex */
public class e {
    private static OutputDeviceStatus a = OutputDeviceStatus.UNKNOWN;

    public class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            OutputDeviceStatus outputDeviceStatus;
            if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                if (intExtra == 0) {
                    outputDeviceStatus = OutputDeviceStatus.NOT_DETECTED;
                } else if (intExtra != 1) {
                    return;
                } else {
                    outputDeviceStatus = OutputDeviceStatus.UNKNOWN;
                }
                OutputDeviceStatus unused = e.a = outputDeviceStatus;
            }
        }
    }

    public static OutputDeviceStatus a() {
        return com.iab.omid.library.pubmatic.utils.a.a() != DeviceCategory.CTV ? OutputDeviceStatus.UNKNOWN : a;
    }

    public static void a(@NonNull Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }
}
