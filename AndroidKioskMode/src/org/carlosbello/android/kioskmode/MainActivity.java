package org.carlosbello.android.kioskmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Actividad principal que bloquará todas las teclas de hardware para evitar
 * el cierre accidental de la aplicación.
 * Esta actividad deberá ser declarada en el manifiesto como MAIN, LAUNCHER y HOME
 * de modo que, al presionar el botón "home" se muestre esta actividad, en lugar
 * de la pantalla de inicio predeterminada.   
 * 
 * @author Carlos Bello
 */
public class MainActivity extends KioskModeHomeActivity {
	
	/**
	 * Inicializa la actividad, estableciendo el bloqueo del botón de retroceso.
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
	 * Cerrar la aplicación.
	 */
	public void closeApp(View view) {
		closeApp();
	}
}