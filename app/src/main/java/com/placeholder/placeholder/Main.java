package com.placeholder.placeholder;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main implements IXposedHookLoadPackage {
    public static final String TAG = "PatchViber";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (! loadPackageParam.packageName.equals("placeholder package name")){
            return;
        }
        XposedBridge.log(TAG + ": start hook " + loadPackageParam.packageName);
        ClassLoader classLoader = loadPackageParam.classLoader;
        XposedHelpers.findAndHookMethod("placeholder iyue", classLoader, "placeholder iyue", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log(TAG + ": replace placeholder return false");
                return false;
            }
        });

    }
}
