package org.carlosbello.android.kioskmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Main activity which will block all the hardware keys to avoid an accidental
 * application exit.
 * <p>
 * This activity should be declared in the manifest as MAIN, LAUNCHER and HOME
 * in order to show this activity -instead of the default home screen- when the
 * home-button is pressed.   
 * 
 * @author Carlos Bello Pauste
 */
public class MainActivity extends KioskModeHomeActivity {
	
	/**
	 * Initializes the activity, blocking the back button and loading
	 * the layout with navigational buttons
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	}	
	
	/**
	 * Shows the secondary activity.
	 */
	public void goToSecondary(View view) {
		startActivity(new Intent(MainActivity.this, SecondaryActivity.class));
	}
	
	/**
	 * Close the application.
	 */
	public void closeApp(View view) {
		closeApp();
	}
}