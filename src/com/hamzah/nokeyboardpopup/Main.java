package com.hamzah.nokeyboardpopup; 

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import android.app.Activity;
import android.view.inputmethod.EditorInfo;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
 
public class Main implements IXposedHookLoadPackage{

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		findAndHookMethod(Activity.class, "onResume", new XC_MethodHook(){
			@Override
			protected void afterHookedMethod(MethodHookParam param)
					throws Throwable {
				Activity a = (Activity) param.thisObject;
				a.getWindow().setSoftInputMode(EditorInfo.IME_ACTION_DONE);
			}
		});
	} 
 
}