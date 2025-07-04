package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.appsflyer.AFLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFf1hSDK {
    private static AFf1hSDK getMonetizationNetwork;
    private final Map<String, String> getCurrencyIso4217Code = new HashMap<String, String>() { // from class: com.appsflyer.internal.AFf1hSDK.1
        {
            put("aa", "ro.arch");
            put("ab", "ro.chipname");
            put("ac", "ro.dalvik.vm.native.bridge");
            put("ad", "persist.sys.nativebridge");
            put("ae", "ro.enable.native.bridge.exec");
            put("af", "dalvik.vm.isa.x86.features");
            put("ag", "dalvik.vm.isa.x86.variant");
            put("ah", "ro.zygote");
            put("ai", "ro.allow.mock.location");
            put("aj", "ro.dalvik.vm.isa.arm");
            put("ak", "dalvik.vm.isa.arm.features");
            put("al", "dalvik.vm.isa.arm.variant");
            put("am", "dalvik.vm.isa.arm64.features");
            put("an", "dalvik.vm.isa.arm64.variant");
            put("ao", "vzw.os.rooted");
            put("ap", "ro.build.user");
            put("aq", "ro.kernel.qemu");
            put("ar", "ro.hardware");
            put("as", "ro.product.cpu.abi");
            put("at", "ro.product.cpu.abilist");
            put("au", "ro.product.cpu.abilist32");
            put("av", "ro.product.cpu.abilist64");
        }
    };

    public enum AFa1uSDK {
        XPOSED("xps"),
        FRIDA("frd");

        String getRevenue;

        AFa1uSDK(String str) {
            this.getRevenue = str;
        }
    }

    public enum AFa1vSDK {
        HOOKING("hk"),
        DEBUGGABLE("dbg");

        String AFAdRevenueData;

        AFa1vSDK(String str) {
            this.AFAdRevenueData = str;
        }
    }

    private AFf1hSDK() {
    }

    private AFg1dSDK AFAdRevenueData(Context context) {
        AFg1dSDK aFg1dSDK = new AFg1dSDK();
        try {
            aFg1dSDK.getCurrencyIso4217Code(AFa1vSDK.HOOKING.AFAdRevenueData, getRevenue());
            aFg1dSDK.getCurrencyIso4217Code(AFa1vSDK.DEBUGGABLE.AFAdRevenueData, Boolean.valueOf(getMonetizationNetwork(context)));
            return aFg1dSDK;
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("failed to perform analysis checks", th);
            return aFg1dSDK;
        }
    }

    public static AFf1hSDK getMediationNetwork() {
        if (getMonetizationNetwork == null) {
            getMonetizationNetwork = new AFf1hSDK();
        }
        return getMonetizationNetwork;
    }

    private static boolean getMonetizationNetwork(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    private static String getRevenue() {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = Thread.getAllStackTraces().entrySet().iterator();
            int i = 0;
            int i2 = 0;
            while (it2.hasNext()) {
                for (StackTraceElement stackTraceElement : it2.next().getValue()) {
                    if (stackTraceElement.toString().contains("de.robv.android.xposed") && i2 <= 2) {
                        i2++;
                        sb.append(AFa1uSDK.XPOSED.getRevenue);
                        if (stackTraceElement.getMethodName().equals("main")) {
                            sb.append("+a");
                        }
                        if (stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                            sb.append("+h");
                        }
                        sb.append(";");
                    }
                    if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit")) {
                        i++;
                    }
                }
            }
            if (i > 1) {
                sb.append("mz;");
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("hooking check error", th);
        }
        try {
            StringBuilder sb2 = new StringBuilder("/proc/");
            sb2.append(Process.myPid());
            sb2.append("/maps");
            if (getRevenue(sb2.toString(), "frida")) {
                sb.append(AFa1uSDK.FRIDA.getRevenue);
                if (Build.VERSION.SDK_INT < 29 && getRevenue("/proc/net/tcp", "69A2")) {
                    sb.append("+prt");
                }
            }
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("frida detection error", e);
            sb.append(e.getMessage().toLowerCase(Locale.getDefault()));
        }
        sb.append(";");
        return sb.toString();
    }

    public final Object getCurrencyIso4217Code(Context context, String str) throws Throwable {
        if (str != null) {
            try {
                str = getMediationNetwork(str) ? null : "invalid timestamp";
            } catch (Exception e) {
                AFLogger.afErrorLogForExcManagerOnly("could not get anti fraud data", e);
                return str;
            }
        }
        AFg1dSDK aFg1dSDK = new AFg1dSDK();
        aFg1dSDK.getCurrencyIso4217Code("pr", AFAdRevenueData());
        aFg1dSDK.getCurrencyIso4217Code("an", AFAdRevenueData(context));
        return aFg1dSDK;
    }

    @SuppressLint({"PrivateApi"})
    private static String getMonetizationNetwork(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("error in props rfl", e);
            return null;
        }
    }

    private static boolean getMediationNetwork(String str) {
        return str.matches("\\d+");
    }

    private AFg1dSDK AFAdRevenueData() throws Throwable {
        AFg1dSDK aFg1dSDK = new AFg1dSDK();
        try {
            for (Map.Entry<String, String> entry : this.getCurrencyIso4217Code.entrySet()) {
                String monetizationNetwork = getMonetizationNetwork(entry.getValue());
                if (monetizationNetwork != null && !monetizationNetwork.equals("")) {
                    aFg1dSDK.getCurrencyIso4217Code(entry.getKey(), monetizationNetwork);
                }
            }
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("failed to create props", e);
        }
        return aFg1dSDK;
    }

    private static boolean getRevenue(String str, String str2) throws Exception {
        String line;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, Charset.defaultCharset()));
            String lowerCase = str2.toLowerCase(Locale.getDefault());
            do {
                line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    fileInputStream.close();
                    return false;
                }
            } while (!new HashSet(Arrays.asList(line.toLowerCase(Locale.getDefault()).split("[\\s.,\\]\\-:/_\\[]"))).contains(lowerCase));
            bufferedReader.close();
            fileInputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            AFLogger.afErrorLogForExcManagerOnly("FNF", e);
            throw new Exception("FNF");
        } catch (IOException e2) {
            AFLogger.afErrorLogForExcManagerOnly("IOF", e2);
            throw new Exception("IOF");
        } catch (Exception e3) {
            AFLogger.afErrorLogForExcManagerOnly("GF", e3);
            throw new Exception("GF");
        }
    }
}
