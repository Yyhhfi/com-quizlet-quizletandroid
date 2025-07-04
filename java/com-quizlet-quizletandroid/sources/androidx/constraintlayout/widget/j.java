package androidx.constraintlayout.widget;

import android.view.ViewGroup;
import com.skydoves.balloon.internals.DefinitionKt;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class j {
    public int a;
    public final m b;
    public final l c;
    public final k d;
    public final n e;
    public HashMap f;
    public i g;

    public j() {
        m mVar = new m();
        mVar.a = false;
        mVar.b = 0;
        mVar.c = 0;
        mVar.d = 1.0f;
        mVar.e = Float.NaN;
        this.b = mVar;
        l lVar = new l();
        lVar.a = false;
        lVar.b = -1;
        lVar.c = 0;
        lVar.d = null;
        lVar.e = -1;
        lVar.f = 0;
        lVar.g = Float.NaN;
        lVar.h = Float.NaN;
        lVar.i = Float.NaN;
        lVar.j = -1;
        lVar.k = null;
        lVar.l = -3;
        lVar.m = -1;
        this.c = lVar;
        k kVar = new k();
        kVar.a = false;
        kVar.b = false;
        kVar.e = -1;
        kVar.f = -1;
        kVar.g = -1.0f;
        kVar.h = true;
        kVar.i = -1;
        kVar.j = -1;
        kVar.k = -1;
        kVar.l = -1;
        kVar.m = -1;
        kVar.n = -1;
        kVar.o = -1;
        kVar.p = -1;
        kVar.q = -1;
        kVar.r = -1;
        kVar.s = -1;
        kVar.t = -1;
        kVar.u = -1;
        kVar.v = -1;
        kVar.w = -1;
        kVar.x = 0.5f;
        kVar.y = 0.5f;
        kVar.z = null;
        kVar.A = -1;
        kVar.B = 0;
        kVar.C = DefinitionKt.NO_Float_VALUE;
        kVar.D = -1;
        kVar.E = -1;
        kVar.F = -1;
        kVar.G = 0;
        kVar.H = 0;
        kVar.I = 0;
        kVar.J = 0;
        kVar.K = 0;
        kVar.L = 0;
        kVar.M = 0;
        kVar.N = Integer.MIN_VALUE;
        kVar.O = Integer.MIN_VALUE;
        kVar.P = Integer.MIN_VALUE;
        kVar.Q = Integer.MIN_VALUE;
        kVar.R = Integer.MIN_VALUE;
        kVar.S = Integer.MIN_VALUE;
        kVar.T = Integer.MIN_VALUE;
        kVar.U = -1.0f;
        kVar.V = -1.0f;
        kVar.W = 0;
        kVar.X = 0;
        kVar.Y = 0;
        kVar.Z = 0;
        kVar.a0 = 0;
        kVar.b0 = 0;
        kVar.c0 = 0;
        kVar.d0 = 0;
        kVar.e0 = 1.0f;
        kVar.f0 = 1.0f;
        kVar.g0 = -1;
        kVar.h0 = 0;
        kVar.i0 = -1;
        kVar.m0 = false;
        kVar.n0 = false;
        kVar.o0 = true;
        kVar.p0 = 0;
        this.d = kVar;
        n nVar = new n();
        nVar.a = false;
        nVar.b = DefinitionKt.NO_Float_VALUE;
        nVar.c = DefinitionKt.NO_Float_VALUE;
        nVar.d = DefinitionKt.NO_Float_VALUE;
        nVar.e = 1.0f;
        nVar.f = 1.0f;
        nVar.g = Float.NaN;
        nVar.h = Float.NaN;
        nVar.i = -1;
        nVar.j = DefinitionKt.NO_Float_VALUE;
        nVar.k = DefinitionKt.NO_Float_VALUE;
        nVar.l = DefinitionKt.NO_Float_VALUE;
        nVar.m = false;
        nVar.n = DefinitionKt.NO_Float_VALUE;
        this.e = nVar;
        this.f = new HashMap();
    }

    public final void a(e eVar) {
        k kVar = this.d;
        eVar.e = kVar.i;
        eVar.f = kVar.j;
        eVar.g = kVar.k;
        eVar.h = kVar.l;
        eVar.i = kVar.m;
        eVar.j = kVar.n;
        eVar.k = kVar.o;
        eVar.l = kVar.p;
        eVar.m = kVar.q;
        eVar.n = kVar.r;
        eVar.o = kVar.s;
        eVar.s = kVar.t;
        eVar.t = kVar.u;
        eVar.u = kVar.v;
        eVar.v = kVar.w;
        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = kVar.G;
        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = kVar.H;
        ((ViewGroup.MarginLayoutParams) eVar).topMargin = kVar.I;
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = kVar.J;
        eVar.A = kVar.S;
        eVar.B = kVar.R;
        eVar.x = kVar.O;
        eVar.z = kVar.Q;
        eVar.E = kVar.x;
        eVar.F = kVar.y;
        eVar.p = kVar.A;
        eVar.q = kVar.B;
        eVar.r = kVar.C;
        eVar.G = kVar.z;
        eVar.T = kVar.D;
        eVar.U = kVar.E;
        eVar.I = kVar.U;
        eVar.H = kVar.V;
        eVar.K = kVar.X;
        eVar.J = kVar.W;
        eVar.W = kVar.m0;
        eVar.X = kVar.n0;
        eVar.L = kVar.Y;
        eVar.M = kVar.Z;
        eVar.P = kVar.a0;
        eVar.Q = kVar.b0;
        eVar.N = kVar.c0;
        eVar.O = kVar.d0;
        eVar.R = kVar.e0;
        eVar.S = kVar.f0;
        eVar.V = kVar.F;
        eVar.c = kVar.g;
        eVar.a = kVar.e;
        eVar.b = kVar.f;
        ((ViewGroup.MarginLayoutParams) eVar).width = kVar.c;
        ((ViewGroup.MarginLayoutParams) eVar).height = kVar.d;
        String str = kVar.l0;
        if (str != null) {
            eVar.Y = str;
        }
        eVar.Z = kVar.p0;
        eVar.setMarginStart(kVar.L);
        eVar.setMarginEnd(kVar.K);
        eVar.a();
    }

    public final void b(int i, e eVar) {
        this.a = i;
        int i2 = eVar.e;
        k kVar = this.d;
        kVar.i = i2;
        kVar.j = eVar.f;
        kVar.k = eVar.g;
        kVar.l = eVar.h;
        kVar.m = eVar.i;
        kVar.n = eVar.j;
        kVar.o = eVar.k;
        kVar.p = eVar.l;
        kVar.q = eVar.m;
        kVar.r = eVar.n;
        kVar.s = eVar.o;
        kVar.t = eVar.s;
        kVar.u = eVar.t;
        kVar.v = eVar.u;
        kVar.w = eVar.v;
        kVar.x = eVar.E;
        kVar.y = eVar.F;
        kVar.z = eVar.G;
        kVar.A = eVar.p;
        kVar.B = eVar.q;
        kVar.C = eVar.r;
        kVar.D = eVar.T;
        kVar.E = eVar.U;
        kVar.F = eVar.V;
        kVar.g = eVar.c;
        kVar.e = eVar.a;
        kVar.f = eVar.b;
        kVar.c = ((ViewGroup.MarginLayoutParams) eVar).width;
        kVar.d = ((ViewGroup.MarginLayoutParams) eVar).height;
        kVar.G = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        kVar.H = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        kVar.I = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        kVar.J = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
        kVar.M = eVar.D;
        kVar.U = eVar.I;
        kVar.V = eVar.H;
        kVar.X = eVar.K;
        kVar.W = eVar.J;
        kVar.m0 = eVar.W;
        kVar.n0 = eVar.X;
        kVar.Y = eVar.L;
        kVar.Z = eVar.M;
        kVar.a0 = eVar.P;
        kVar.b0 = eVar.Q;
        kVar.c0 = eVar.N;
        kVar.d0 = eVar.O;
        kVar.e0 = eVar.R;
        kVar.f0 = eVar.S;
        kVar.l0 = eVar.Y;
        kVar.O = eVar.x;
        kVar.Q = eVar.z;
        kVar.N = eVar.w;
        kVar.P = eVar.y;
        kVar.S = eVar.A;
        kVar.R = eVar.B;
        kVar.T = eVar.C;
        kVar.p0 = eVar.Z;
        kVar.K = eVar.getMarginEnd();
        kVar.L = eVar.getMarginStart();
    }

    public final void c(int i, p pVar) {
        b(i, pVar);
        this.b.d = pVar.r0;
        float f = pVar.u0;
        n nVar = this.e;
        nVar.b = f;
        nVar.c = pVar.v0;
        nVar.d = pVar.w0;
        nVar.e = pVar.x0;
        nVar.f = pVar.y0;
        nVar.g = pVar.z0;
        nVar.h = pVar.A0;
        nVar.j = pVar.B0;
        nVar.k = pVar.C0;
        nVar.l = pVar.D0;
        nVar.n = pVar.t0;
        nVar.m = pVar.s0;
    }

    public final Object clone() {
        j jVar = new j();
        k kVar = jVar.d;
        k kVar2 = this.d;
        kVar.getClass();
        kVar.a = kVar2.a;
        kVar.c = kVar2.c;
        kVar.b = kVar2.b;
        kVar.d = kVar2.d;
        kVar.e = kVar2.e;
        kVar.f = kVar2.f;
        kVar.g = kVar2.g;
        kVar.h = kVar2.h;
        kVar.i = kVar2.i;
        kVar.j = kVar2.j;
        kVar.k = kVar2.k;
        kVar.l = kVar2.l;
        kVar.m = kVar2.m;
        kVar.n = kVar2.n;
        kVar.o = kVar2.o;
        kVar.p = kVar2.p;
        kVar.q = kVar2.q;
        kVar.r = kVar2.r;
        kVar.s = kVar2.s;
        kVar.t = kVar2.t;
        kVar.u = kVar2.u;
        kVar.v = kVar2.v;
        kVar.w = kVar2.w;
        kVar.x = kVar2.x;
        kVar.y = kVar2.y;
        kVar.z = kVar2.z;
        kVar.A = kVar2.A;
        kVar.B = kVar2.B;
        kVar.C = kVar2.C;
        kVar.D = kVar2.D;
        kVar.E = kVar2.E;
        kVar.F = kVar2.F;
        kVar.G = kVar2.G;
        kVar.H = kVar2.H;
        kVar.I = kVar2.I;
        kVar.J = kVar2.J;
        kVar.K = kVar2.K;
        kVar.L = kVar2.L;
        kVar.M = kVar2.M;
        kVar.N = kVar2.N;
        kVar.O = kVar2.O;
        kVar.P = kVar2.P;
        kVar.Q = kVar2.Q;
        kVar.R = kVar2.R;
        kVar.S = kVar2.S;
        kVar.T = kVar2.T;
        kVar.U = kVar2.U;
        kVar.V = kVar2.V;
        kVar.W = kVar2.W;
        kVar.X = kVar2.X;
        kVar.Y = kVar2.Y;
        kVar.Z = kVar2.Z;
        kVar.a0 = kVar2.a0;
        kVar.b0 = kVar2.b0;
        kVar.c0 = kVar2.c0;
        kVar.d0 = kVar2.d0;
        kVar.e0 = kVar2.e0;
        kVar.f0 = kVar2.f0;
        kVar.g0 = kVar2.g0;
        kVar.h0 = kVar2.h0;
        kVar.i0 = kVar2.i0;
        kVar.l0 = kVar2.l0;
        int[] iArr = kVar2.j0;
        if (iArr == null || kVar2.k0 != null) {
            kVar.j0 = null;
        } else {
            kVar.j0 = Arrays.copyOf(iArr, iArr.length);
        }
        kVar.k0 = kVar2.k0;
        kVar.m0 = kVar2.m0;
        kVar.n0 = kVar2.n0;
        kVar.o0 = kVar2.o0;
        kVar.p0 = kVar2.p0;
        l lVar = jVar.c;
        l lVar2 = this.c;
        lVar.getClass();
        lVar.a = lVar2.a;
        lVar.b = lVar2.b;
        lVar.d = lVar2.d;
        lVar.e = lVar2.e;
        lVar.f = lVar2.f;
        lVar.h = lVar2.h;
        lVar.g = lVar2.g;
        m mVar = jVar.b;
        m mVar2 = this.b;
        mVar.a = mVar2.a;
        mVar.b = mVar2.b;
        mVar.d = mVar2.d;
        mVar.e = mVar2.e;
        mVar.c = mVar2.c;
        n nVar = jVar.e;
        n nVar2 = this.e;
        nVar.getClass();
        nVar.a = nVar2.a;
        nVar.b = nVar2.b;
        nVar.c = nVar2.c;
        nVar.d = nVar2.d;
        nVar.e = nVar2.e;
        nVar.f = nVar2.f;
        nVar.g = nVar2.g;
        nVar.h = nVar2.h;
        nVar.i = nVar2.i;
        nVar.j = nVar2.j;
        nVar.k = nVar2.k;
        nVar.l = nVar2.l;
        nVar.m = nVar2.m;
        nVar.n = nVar2.n;
        jVar.a = this.a;
        jVar.g = this.g;
        return jVar;
    }
}
