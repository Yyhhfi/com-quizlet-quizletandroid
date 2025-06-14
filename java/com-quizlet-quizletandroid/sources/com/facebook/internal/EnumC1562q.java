package com.facebook.internal;

import android.R;
import com.amazon.device.ads.DtbDeviceDataRetriever;
import com.appsflyer.attribution.RequestError;
import com.comscore.streaming.EventType;

/* renamed from: com.facebook.internal.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC1562q {
    Unknown(-1),
    Core(0),
    AppEvents(65536),
    CodelessEvents(65792),
    CloudBridge(67584),
    RestrictiveDataFiltering(66048),
    AAM(66304),
    PrivacyProtection(66560),
    SuggestedEvents(66561),
    IntelligentIntegrity(66562),
    ModelRequest(66563),
    ProtectedMode(66564),
    MACARuleMatching(66565),
    BlocklistEvents(66566),
    FilterRedactedEvents(66567),
    FilterSensitiveParams(66568),
    StdParamEnforcement(R.attr.trimPathEnd),
    BannedParamFiltering(R.attr.trimPathOffset),
    EventDeactivation(66816),
    OnDeviceEventProcessing(67072),
    OnDevicePostInstallEventProcessing(67073),
    IapLogging(67328),
    IapLoggingLib2(67329),
    IapLoggingLib5To7(67330),
    AndroidManualImplicitPurchaseDedupe(67331),
    AndroidManualImplicitSubsDedupe(67332),
    AndroidIAPSubscriptionAutoLogging(67333),
    Instrument(131072),
    CrashReport(131328),
    CrashShield(131329),
    ThreadCheck(131330),
    ErrorReport(131584),
    AnrReport(131840),
    Monitoring(196608),
    ServiceUpdateCompliance(196864),
    /* JADX INFO: Fake field, exist only in values array */
    Megatron(262144),
    /* JADX INFO: Fake field, exist only in values array */
    Login(327680),
    GPSARATriggers(393216),
    GPSPACAProcessing(458752),
    GPSTopicsObservation(524288),
    /* JADX INFO: Fake field, exist only in values array */
    Login(16777216),
    ChromeCustomTabsPrefetching(R.attr.theme),
    IgnoreAppSwitchToLoggedOut(R.id.background),
    BypassAppSwitch(R.style.Animation),
    /* JADX INFO: Fake field, exist only in values array */
    Share(33554432);

    public final int a;

    EnumC1562q(int i) {
        this.a = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        switch (ordinal()) {
            case 1:
                return "CoreKit";
            case 2:
                return "AppEvents";
            case 3:
                return "CodelessEvents";
            case 4:
                return "AppEventsCloudbridge";
            case 5:
                return "RestrictiveDataFiltering";
            case 6:
                return "AAM";
            case 7:
                return "PrivacyProtection";
            case 8:
                return "SuggestedEvents";
            case 9:
                return "IntelligentIntegrity";
            case 10:
                return "ModelRequest";
            case 11:
                return "ProtectedMode";
            case 12:
                return "MACARuleMatching";
            case 13:
                return "BlocklistEvents";
            case 14:
                return "FilterRedactedEvents";
            case 15:
                return "FilterSensitiveParams";
            case 16:
                return "StdParamEnforcement";
            case 17:
                return "BannedParamFiltering";
            case 18:
                return "EventDeactivation";
            case 19:
                return "OnDeviceEventProcessing";
            case 20:
                return "OnDevicePostInstallEventProcessing";
            case 21:
                return "IAPLogging";
            case EventType.WINDOW_STATE /* 22 */:
                return "IAPLoggingLib2";
            case EventType.AUDIO /* 23 */:
                return "IAPLoggingLib5To7";
            case EventType.VIDEO /* 24 */:
                return "AndroidManualImplicitPurchaseDedupe";
            case EventType.SUBS /* 25 */:
                return "AndroidManualImplicitSubsDedupe";
            case EventType.CDN /* 26 */:
                return "AndroidIAPSubscriptionAutoLogging";
            case 27:
                return "Instrument";
            case 28:
                return "CrashReport";
            case 29:
                return "CrashShield";
            case 30:
                return "ThreadCheck";
            case 31:
                return "ErrorReport";
            case 32:
                return "AnrReport";
            case 33:
                return "Monitoring";
            case 34:
                return "ServiceUpdateCompliance";
            case 35:
                return "Megatron";
            case 36:
                return "Elora";
            case 37:
                return "GPSARATriggers";
            case 38:
                return "GPSPACAProcessing";
            case 39:
                return "GPSTopicsObservation";
            case RequestError.NETWORK_FAILURE /* 40 */:
                return "LoginKit";
            case RequestError.NO_DEV_KEY /* 41 */:
                return "ChromeCustomTabsPrefetching";
            case 42:
                return "IgnoreAppSwitchToLoggedOut";
            case 43:
                return "BypassAppSwitch";
            case 44:
                return "ShareKit";
            default:
                return DtbDeviceDataRetriever.ORIENTATION_UNKNOWN;
        }
    }
}
