package org.jsoup.parser;

import com.google.android.gms.internal.mlkit_vision_camera.AbstractC3386r2;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class E implements Cloneable {
    public static final HashMap j = new HashMap();
    public static final String[] k;
    public static final String[] l;
    public static final String[] m;
    public static final String[] n;
    public static final String[] o;
    public static final String[] p;
    public String a;
    public final String b;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", com.pubmatic.sdk.common.base.c.CREATIVE_TYPE_VIDEO, "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center", "template", "dir", "applet", "marquee", "listing"};
        k = new String[]{"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", OTUXParamsKeys.OT_UX_SUMMARY, "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s", "strike", "nobr"};
        l = new String[]{"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
        m = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
        n = new String[]{"pre", "plaintext", "title", "textarea"};
        o = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        p = new String[]{"input", "keygen", "object", "select", "textarea"};
        for (int i = 0; i < 69; i++) {
            E e = new E(strArr[i]);
            j.put(e.a, e);
        }
        for (String str : k) {
            E e2 = new E(str);
            e2.c = false;
            e2.d = false;
            j.put(e2.a, e2);
        }
        for (String str2 : l) {
            E e3 = (E) j.get(str2);
            org.jsoup.helper.b.g(e3);
            e3.e = true;
        }
        for (String str3 : m) {
            E e4 = (E) j.get(str3);
            org.jsoup.helper.b.g(e4);
            e4.d = false;
        }
        for (String str4 : n) {
            E e5 = (E) j.get(str4);
            org.jsoup.helper.b.g(e5);
            e5.g = true;
        }
        for (String str5 : o) {
            E e6 = (E) j.get(str5);
            org.jsoup.helper.b.g(e6);
            e6.h = true;
        }
        for (String str6 : p) {
            E e7 = (E) j.get(str6);
            org.jsoup.helper.b.g(e7);
            e7.i = true;
        }
    }

    public E(String str) {
        this.a = str;
        this.b = AbstractC3386r2.c(str);
    }

    public static E c(String str, D d) {
        org.jsoup.helper.b.g(str);
        HashMap map = j;
        E e = (E) map.get(str);
        if (e != null) {
            return e;
        }
        String strB = d.b(str);
        org.jsoup.helper.b.e(strB);
        String strC = AbstractC3386r2.c(strB);
        E e2 = (E) map.get(strC);
        if (e2 == null) {
            E e3 = new E(strB);
            e3.c = false;
            return e3;
        }
        if (!d.a || strB.equals(strC)) {
            return e2;
        }
        E eClone = e2.clone();
        eClone.a = strB;
        return eClone;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final E clone() {
        try {
            return (E) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e = (E) obj;
        return this.a.equals(e.a) && this.e == e.e && this.d == e.d && this.c == e.c && this.g == e.g && this.f == e.f && this.h == e.h && this.i == e.i;
    }

    public final int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }

    public final String toString() {
        return this.a;
    }
}
