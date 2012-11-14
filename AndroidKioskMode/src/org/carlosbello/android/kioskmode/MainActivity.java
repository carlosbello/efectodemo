package org.carlosbello.android.kioskmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Actividad principal que bloquar� todas las teclas de hardware para evitar
 * el cierre accidental de la aplicaci�n.
 * Esta actividad deber� ser declarada en el manifiesto como MAIN, LAUNCHER y HOME
 * de modo que, al presionar el bot�n "home" se muestre esta actividad, en lugar
 * de la pantalla de inicio predeterminada.   
 * 
 * @author Carlos Bello
 */
public class MainActivity extends KioskModeHomeActivity {
	
	/**
	 * Inicializa la actividad, estableciendo el bloqueo del bot�n de retroceso.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	}	
	
	/**
	 * Muestra la actividad secundaria.
	 */
	public void goToSecondary(View view) {
		startActivity(new Intent(MainActivity.this, SecondaryActivity.class));
	}
	
	/**
	 * Cerrar la aplicaci�n.
	 */
	public void closeApp(View view) {
		closeApp();
	}
}