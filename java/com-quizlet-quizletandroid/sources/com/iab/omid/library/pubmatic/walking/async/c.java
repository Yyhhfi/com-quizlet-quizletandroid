package com.iab.omid.library.pubmatic.walking.async;

import com.iab.omid.library.pubmatic.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class c implements b.a {
    private final BlockingQueue<Runnable> a;
    private final ThreadPoolExecutor b;
    private final ArrayDeque<b> c = new ArrayDeque<>();
    private b d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.a = linkedBlockingQueue;
        this.b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b bVarPoll = this.c.poll();
        this.d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.a(this.b);
        }
    }

    public void b(b bVar) {
        bVar.a(this);
        this.c.add(bVar);
        if (this.d == null) {
            a();
        }
    }

    @Override // com.iab.omid.library.pubmatic.walking.async.b.a
    public void a(b bVar) {
        this.d = null;
        a();
    }
}
