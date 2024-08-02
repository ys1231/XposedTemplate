package com.jgwl.patchviber;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main implements IXposedHookLoadPackage {
    public static final String TAG = "PatchViber";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (! loadPackageParam.packageName.equals("com.viber.voip")){
            return;
        }
        XposedBridge.log(TAG + ": start hook " + loadPackageParam.packageName);
        ClassLoader classLoader = loadPackageParam.classLoader;
        XposedHelpers.findAndHookMethod("fa.i", classLoader, "g", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log(TAG + ": replace fa.i.g return false");
                return false;
            }
        });

    }
}
