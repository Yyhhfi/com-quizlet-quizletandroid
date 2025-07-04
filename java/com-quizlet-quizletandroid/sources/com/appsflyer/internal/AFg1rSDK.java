package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class AFg1rSDK extends AFe1sSDK<Void> {
    private final Throwable component1;
    private final AFc1qSDK component3;
    private final AFd1aSDK<String> component4;

    public AFg1rSDK(AFf1uSDK aFf1uSDK, AFc1qSDK aFc1qSDK) {
        super(AFe1mSDK.GCDSDK, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, "GCD-CHECK");
        this.component1 = aFf1uSDK.component4();
        this.component4 = ((AFe1dSDK) aFf1uSDK).component1;
        this.component3 = aFc1qSDK;
    }

    private Map<String, Object> component3() {
        String strAFAdRevenueData = this.component3.AFAdRevenueData("attributionId", (String) null);
        if (strAFAdRevenueData == null) {
            return null;
        }
        try {
            new AFd1iSDK();
            return AFd1iSDK.getMediationNetwork(strAFAdRevenueData);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder("[GCD] Failed to parse GCD response: ");
            sb.append(e.getMessage());
            AFLogger.afErrorLog(sb.toString(), e);
            return null;
        }
    }

    @Override // com.appsflyer.internal.AFe1sSDK
    @NonNull
    public final AFe1rSDK getCurrencyIso4217Code() throws Exception {
        AFLogger.afDebugLog("[GCD-A01] Loading conversion data. Counter: ".concat(String.valueOf(this.component3.AFAdRevenueData("appsFlyerCount", 0))));
        long currencyIso4217Code = this.component3.getCurrencyIso4217Code("appsflyerConversionDataCacheExpiration", 0L);
        if (currencyIso4217Code != 0 && System.currentTimeMillis() - currencyIso4217Code > 5184000000L) {
            AFLogger.afDebugLog("[GCD-E02] Cached conversion data expired");
            this.component3.getCurrencyIso4217Code("sixtyDayConversionData", true);
            this.component3.getMediationNetwork("attributionId", (String) null);
            this.component3.getMonetizationNetwork("appsflyerConversionDataCacheExpiration", 0L);
        }
        Map<String, Object> mapComponent3 = component3();
        if (mapComponent3 != null) {
            try {
                if (!mapComponent3.containsKey("is_first_launch")) {
                    mapComponent3.put("is_first_launch", Boolean.FALSE);
                }
                AFg1nSDK.getMonetizationNetwork(mapComponent3);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("[GCD] Error executing conversion data callback: ");
                sb.append(e.getLocalizedMessage());
                AFLogger.afErrorLog(sb.toString(), e);
            }
            return AFe1rSDK.SUCCESS;
        }
        try {
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("[GCD] Error executing conversion data callback: ");
            sb2.append(e2.getLocalizedMessage());
            AFLogger.afErrorLog(sb2.toString(), e2);
        }
        if (this.component1 != null) {
            StringBuilder sb3 = new StringBuilder("Launch exception: ");
            sb3.append(this.component1.getMessage());
            AFg1nSDK.getMediationNetwork(sb3.toString());
            return AFe1rSDK.SUCCESS;
        }
        AFd1aSDK<String> aFd1aSDK = this.component4;
        if (aFd1aSDK != null && !aFd1aSDK.isSuccessful()) {
            StringBuilder sb4 = new StringBuilder("Launch status code: ");
            sb4.append(this.component4.getStatusCode());
            AFg1nSDK.getMediationNetwork(sb4.toString());
            return AFe1rSDK.SUCCESS;
        }
        return AFe1rSDK.FAILURE;
    }

    @Override // com.appsflyer.internal.AFe1sSDK
    public final boolean getMediationNetwork() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1sSDK
    public final long getMonetizationNetwork() {
        return 1000L;
    }
}
