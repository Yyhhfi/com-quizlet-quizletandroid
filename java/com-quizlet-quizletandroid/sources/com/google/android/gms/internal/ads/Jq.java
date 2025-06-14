package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum Jq {
    SIGNALS("signals"),
    REQUEST_PARCEL("request-parcel"),
    SERVER_TRANSACTION("server-transaction"),
    RENDERER("renderer"),
    GMS_SIGNALS("gms-signals"),
    /* JADX INFO: Fake field, exist only in values array */
    AD_REQUEST("ad_request"),
    BUILD_URL("build-url"),
    /* JADX INFO: Fake field, exist only in values array */
    PREPARE_HTTP_REQUEST("prepare-http-request"),
    HTTP("http"),
    /* JADX INFO: Fake field, exist only in values array */
    PROXY("proxy"),
    PRE_PROCESS("preprocess"),
    GET_SIGNALS("get-signals"),
    JS_SIGNALS("js-signals"),
    RENDER_CONFIG_INIT("render-config-init"),
    RENDER_CONFIG_WATERFALL("render-config-waterfall"),
    /* JADX INFO: Fake field, exist only in values array */
    RENDER_CONFIG_PARALLEL("render-config-parallel"),
    ADAPTER_LOAD_AD_SYN("adapter-load-ad-syn"),
    ADAPTER_LOAD_AD_ACK("adapter-load-ad-ack"),
    ADAPTER_WRAP_ADAPTER("wrap-adapter"),
    CUSTOM_RENDER_SYN("custom-render-syn"),
    CUSTOM_RENDER_ACK("custom-render-ack"),
    WEBVIEW_COOKIE("webview-cookie"),
    GENERATE_SIGNALS("generate-signals"),
    GET_CACHE_KEY("get-cache-key"),
    NOTIFY_CACHE_HIT("notify-cache-hit"),
    GET_URL_AND_CACHE_KEY("get-url-and-cache-key"),
    PRELOADED_LOADER("preloaded-loader");

    public final String a;

    Jq(String str) {
        this.a = str;
    }
}
