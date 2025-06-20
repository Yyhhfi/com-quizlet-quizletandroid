package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.AFLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class AFg1xSDK {

    @NotNull
    private final String getCurrencyIso4217Code;
    private final PackageManager getMediationNetwork;

    @NotNull
    private final Map<String, Object> getRevenue;

    public AFg1xSDK(@NotNull AFc1iSDK aFc1iSDK, @NotNull AFc1pSDK aFc1pSDK) {
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        this.getRevenue = new LinkedHashMap();
        Context context = aFc1iSDK.getMonetizationNetwork;
        this.getMediationNetwork = context != null ? context.getPackageManager() : null;
        String packageName = aFc1pSDK.getRevenue.getMonetizationNetwork.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        this.getCurrencyIso4217Code = packageName;
    }

    @NotNull
    public final Map<String, Object> getCurrencyIso4217Code() {
        InstallSourceInfo installSourceInfo;
        String installerPackageName;
        if (this.getRevenue.isEmpty()) {
            try {
                PackageManager packageManager = this.getMediationNetwork;
                if (packageManager != null && (installerPackageName = packageManager.getInstallerPackageName(this.getCurrencyIso4217Code)) != null) {
                    this.getRevenue.put("installer_package", installerPackageName);
                }
            } catch (Exception e) {
                AFLogger.afErrorLog("Exception while getting the app's installer package. ", e);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                Map<String, Object> map = this.getRevenue;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.getCurrencyIso4217Code;
                PackageManager packageManager2 = this.getMediationNetwork;
                if (packageManager2 != null && (installSourceInfo = packageManager2.getInstallSourceInfo(str)) != null) {
                    Intrinsics.checkNotNullExpressionValue(installSourceInfo, "");
                    linkedHashMap = new LinkedHashMap();
                    String initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                    if (initiatingPackageName != null) {
                        linkedHashMap.put("initiating_package", initiatingPackageName);
                    }
                    String installingPackageName = installSourceInfo.getInstallingPackageName();
                    if (installingPackageName != null) {
                        linkedHashMap.put("installing_package", installingPackageName);
                    }
                    String originatingPackageName = installSourceInfo.getOriginatingPackageName();
                    if (originatingPackageName != null) {
                        linkedHashMap.put("originating_package", originatingPackageName);
                    }
                }
                map.put("install_source_info", linkedHashMap);
            }
        }
        return this.getRevenue;
    }
}
