package com.android.billingclient.api;

/* loaded from: classes.dex */
public abstract class A {
    public static final e A;
    public static final e B;
    public static final e C;
    public static final e D;
    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    public static final e f;
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public static final e k;
    public static final e l;
    public static final e m;
    public static final e n;
    public static final e o;
    public static final e p;
    public static final e q;
    public static final e r;
    public static final e s;
    public static final e t;
    public static final e u;
    public static final e v;
    public static final e w;
    public static final e x;
    public static final e y;
    public static final e z;

    static {
        d dVarA = e.a();
        dVarA.b = 3;
        dVarA.c = "Google Play In-app Billing API version is less than 3";
        a = dVarA.a();
        d dVarA2 = e.a();
        dVarA2.b = 3;
        dVarA2.c = "Google Play In-app Billing API version is less than 9";
        b = dVarA2.a();
        d dVarA3 = e.a();
        dVarA3.b = 3;
        dVarA3.c = "Billing service unavailable on device.";
        c = dVarA3.a();
        d dVarA4 = e.a();
        dVarA4.b = 2;
        dVarA4.c = "Billing service unavailable on device.";
        d = dVarA4.a();
        d dVarA5 = e.a();
        dVarA5.b = 5;
        dVarA5.c = "Client is already in the process of connecting to billing service.";
        e = dVarA5.a();
        d dVarA6 = e.a();
        dVarA6.b = 5;
        dVarA6.c = "The list of SKUs can't be empty.";
        dVarA6.a();
        d dVarA7 = e.a();
        dVarA7.b = 5;
        dVarA7.c = "SKU type can't be empty.";
        dVarA7.a();
        d dVarA8 = e.a();
        dVarA8.b = 5;
        dVarA8.c = "Product type can't be empty.";
        f = dVarA8.a();
        d dVarA9 = e.a();
        dVarA9.b = -2;
        dVarA9.c = "Client does not support extra params.";
        g = dVarA9.a();
        d dVarA10 = e.a();
        dVarA10.b = 5;
        dVarA10.c = "Invalid purchase token.";
        h = dVarA10.a();
        d dVarA11 = e.a();
        dVarA11.b = 6;
        dVarA11.c = "An internal error occurred.";
        i = dVarA11.a();
        d dVarA12 = e.a();
        dVarA12.b = 5;
        dVarA12.c = "SKU can't be null.";
        dVarA12.a();
        d dVarA13 = e.a();
        dVarA13.b = 0;
        j = dVarA13.a();
        d dVarA14 = e.a();
        dVarA14.b = -1;
        dVarA14.c = "Service connection is disconnected.";
        k = dVarA14.a();
        d dVarA15 = e.a();
        dVarA15.b = 2;
        dVarA15.c = "Timeout communicating with service.";
        l = dVarA15.a();
        d dVarA16 = e.a();
        dVarA16.b = -2;
        dVarA16.c = "Client does not support subscriptions.";
        m = dVarA16.a();
        d dVarA17 = e.a();
        dVarA17.b = -2;
        dVarA17.c = "Client does not support subscriptions update.";
        n = dVarA17.a();
        d dVarA18 = e.a();
        dVarA18.b = -2;
        dVarA18.c = "Client does not support get purchase history.";
        dVarA18.a();
        d dVarA19 = e.a();
        dVarA19.b = -2;
        dVarA19.c = "Client does not support price change confirmation.";
        o = dVarA19.a();
        d dVarA20 = e.a();
        dVarA20.b = -2;
        dVarA20.c = "Play Store version installed does not support cross selling products.";
        p = dVarA20.a();
        d dVarA21 = e.a();
        dVarA21.b = -2;
        dVarA21.c = "Client does not support multi-item purchases.";
        q = dVarA21.a();
        d dVarA22 = e.a();
        dVarA22.b = -2;
        dVarA22.c = "Client does not support offer_id_token.";
        r = dVarA22.a();
        d dVarA23 = e.a();
        dVarA23.b = -2;
        dVarA23.c = "Client does not support ProductDetails.";
        s = dVarA23.a();
        d dVarA24 = e.a();
        dVarA24.b = -2;
        dVarA24.c = "Client does not support in-app messages.";
        t = dVarA24.a();
        d dVarA25 = e.a();
        dVarA25.b = -2;
        dVarA25.c = "Client does not support user choice billing.";
        dVarA25.a();
        d dVarA26 = e.a();
        dVarA26.b = -2;
        dVarA26.c = "Play Store version installed does not support external offer.";
        u = dVarA26.a();
        d dVarA27 = e.a();
        dVarA27.b = -2;
        dVarA27.c = "Play Store version installed does not support multi-item purchases with season pass in one cart.";
        v = dVarA27.a();
        d dVarA28 = e.a();
        dVarA28.b = 5;
        dVarA28.c = "Unknown feature";
        w = dVarA28.a();
        d dVarA29 = e.a();
        dVarA29.b = -2;
        dVarA29.c = "Play Store version installed does not support get billing config.";
        x = dVarA29.a();
        d dVarA30 = e.a();
        dVarA30.b = -2;
        dVarA30.c = "Query product details with serialized docid is not supported.";
        y = dVarA30.a();
        d dVarA31 = e.a();
        dVarA31.b = 4;
        dVarA31.c = "Item is unavailable for purchase.";
        z = dVarA31.a();
        d dVarA32 = e.a();
        dVarA32.b = -2;
        dVarA32.c = "Query product details with developer specified account is not supported.";
        A = dVarA32.a();
        d dVarA33 = e.a();
        dVarA33.b = -2;
        dVarA33.c = "Play Store version installed does not support alternative billing only.";
        B = dVarA33.a();
        d dVarA34 = e.a();
        dVarA34.b = 5;
        dVarA34.c = "To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.";
        C = dVarA34.a();
        d dVarA35 = e.a();
        dVarA35.b = 6;
        dVarA35.c = "An error occurred while retrieving billing override.";
        D = dVarA35.a();
    }

    public static e a(int i2, String str) {
        d dVarA = e.a();
        dVarA.b = i2;
        dVarA.c = str;
        return dVarA.a();
    }
}
