package androidx.glance.appwidget;

/* loaded from: classes.dex */
public final class U extends kotlin.coroutines.jvm.internal.c {
    public X j;
    public Class k;
    public /* synthetic */ Object l;
    public final /* synthetic */ X m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(X x, kotlin.coroutines.jvm.internal.c cVar) {
        super(cVar);
        this.m = x;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= Integer.MIN_VALUE;
        return this.m.a(null, this);
    }
}
