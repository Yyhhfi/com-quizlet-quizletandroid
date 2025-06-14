package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes2.dex */
public final class SessionLifecycleService extends Service {
    public final HandlerThread a = new HandlerThread("FirebaseSessions_HandlerThread");
    public c0 b;
    public Messenger c;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (intent != null) {
            intent.getAction();
            Messenger messenger = Build.VERSION.SDK_INT >= 33 ? (Messenger) intent.getParcelableExtra("ClientCallbackMessenger", Messenger.class) : (Messenger) intent.getParcelableExtra("ClientCallbackMessenger");
            if (messenger != null) {
                Message messageObtain = Message.obtain(null, 4, 0, 0);
                messageObtain.replyTo = messenger;
                c0 c0Var = this.b;
                if (c0Var != null) {
                    c0Var.sendMessage(messageObtain);
                }
            }
            Messenger messenger2 = this.c;
            if (messenger2 != null) {
                return messenger2.getBinder();
            }
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = this.a;
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "handlerThread.looper");
        this.b = new c0(looper);
        this.c = new Messenger(this.b);
        Process.myPid();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.a.quit();
    }
}
