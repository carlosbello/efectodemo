package org.carlosbello.android.kioskmode;

import java.util.Iterator;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

/**
 * Base activity to create a replacement for the "home screen" of the phone.
 * @author Carlos Bello
 */
public class KioskModeHomeActivity extends KioskModeActivity {
	/**
	 * Initialize the activity, blocking the back button.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		blockBackButton = true;
	}	
	
	/**
	 * Finalize the main activity and the application, after that, launch a different 
	 * "home" activity, preventing this activity to be reloaded.
	 */
	public void closeApp() {
		finish();
		startActivity(getFirstExternalHomeIntent());
	}
	
	/**
	 * Recupera el Intent de una actividad "home", dada su clase y el paquete en el 
	 * que se encuentra.
	 * 
	 * @param packageName Nombre del paquete 
	 * @param name		  Nombre de la clase de la actividad
	 * @return			  Intent a través del cual podría iniciarse la actividad
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
	 * Obtiene la información para ejecutar una palicación home distinta de la actual.
	 * Si en el sistema no se ha instalado ninguna aplicación "home", además de la actual, 
	 * se recuperará el launcher de Android. Si existiera alguna otra aplcación "home", 
	 * se recuperará la primera que se encuentre.
	 * 
	 * @return Intent para ejecutar la actividad home recuperada
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
