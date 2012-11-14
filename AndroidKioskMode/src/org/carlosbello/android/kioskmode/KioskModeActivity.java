package org.carlosbello.android.kioskmode;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

/**
 * Actividad de base para crear interfaces en modo kiosko.
 * @author Carlos Bello
 */
public class KioskModeActivity extends Activity {
	/** Indica si deber� desactivarse el uso del bot�n de retroceso. */
	protected boolean blockBackButton = false;
	
	/**
	 * Establece la visualizaci�n a pantalla completa para evitar una salida 
	 * accidental a trav�s de la barra de t�tulo o cualquier otro elemento 
	 * interactivo que no sea nuestra propia interfaz.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}
	
	/**
	 * Intercepta los eventos del teclado para evitar la interacci�n con cualquier  
	 * elemento que no forme parte de nuestra interfaz, salvo la funcionalidad del
	 * bot�n de retroceso, si estuviera habilitado.
	 */	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
    	return !blockBackButton && keyCode == KeyEvent.KEYCODE_BACK
    		? super.onKeyDown(keyCode, event)
    		: true;
	}
}