package org.carlosbello.android.kioskmode;

import java.util.Iterator;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

/**
 * Actividad base para crear un remplazo de la pantalla "home" del tel�fono. 
 * @author Carlos Bello
 */
public class KioskModeHomeActivity extends KioskModeActivity {
	/**
	 * Inicializa la actividad, estableciendo el bloqueo del bot�n de retroceso.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		blockBackButton = true;
		//registerReceiver(new IncommingCallsReceiver(), new IntentFilter("android.intent.action.PHONE_STATE"));
	}	
	
	/**
	 * Finaliza la actividad principal y por tanto la aplicaci�n, luego de lo cual inicia
	 * una actividad "home" distinta a la actual para evitar que �sta se vuelva a cargar.
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
	 * @return			  Intent a trav�s del cual podr�a iniciarse la actividad
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
	 * Obtiene la informaci�n para ejecutar una palicaci�n home distinta de la actual.
	 * Si en el sistema no se ha instalado ninguna aplicaci�n "home", adem�s de la actual, 
	 * se recuperar� el launcher de Android. Si existiera alguna otra aplcaci�n "home", 
	 * se recuperar� la primera que se encuentre.
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
