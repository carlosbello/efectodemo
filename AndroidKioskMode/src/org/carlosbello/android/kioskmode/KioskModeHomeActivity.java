package org.carlosbello.android.kioskmode;

import java.util.Iterator;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

/**
 * Base activity to create a replacement for the "home screen" of the phone.
 * @author Carlos Bello Pauste
 */
public class KioskModeHomeActivity extends KioskModeActivity {
	/**
	 * Initializes the activity, blocking the back button.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		blockBackButton = true;
	}	
	
	/**
	 * Finalizes the main activity and the application, after that, launch a different 
	 * "home" activity, preventing this activity to be reloaded.
	 */
	public void closeApp() {
		finish();
		startActivity(getFirstExternalHomeIntent());
	}
	
	/**
	 * Retrieves the intent related to a "home" activity, given it's class and package.
	 * 
	 * @param packageName Package name. 
	 * @param name		  Activity class name.
	 * @return			  Intent through which could be launched the home screen.
	 */	
	private Intent getHomeIntent(String packageName, String name) {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
	                Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		intent.setComponent(new ComponentName(packageName, name));
		return intent;
	}
	
	/**
	 * Retrieve the information to execute a "home" activity distinct to the current.
	 * <p>
	 * If in the system there is no extra "home" activity, except the current one,
	 * the Android launcher should be retrieved. If there are other "home" activities,
	 * should be retrieved the first different from the current one. 
	 * 
	 * @return Intent to execute the identified "home" activity.
	 * @
	 */
	private Intent getFirstExternalHomeIntent() {
		Intent intent = null;
		final PackageManager packageManager = getPackageManager();
		Iterator<ResolveInfo> resInfoIterator = packageManager.queryIntentActivities(
				new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME),
				PackageManager.MATCH_DEFAULT_ONLY).iterator();
		while (intent == null && resInfoIterator.hasNext()) {
			ResolveInfo resolveInfo = resInfoIterator.next();
			if (!getPackageName().equals(resolveInfo.activityInfo.packageName)) {
				intent = getHomeIntent(resolveInfo.activityInfo.applicationInfo.packageName,
						resolveInfo.activityInfo.name);
			}
		}
		return intent;
	}
}
