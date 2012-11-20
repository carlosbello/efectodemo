package org.carlosbello.android.kioskmode;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

/**
 * Base activity to create interfaces in kiosk-mode.
 * @author Carlos Bello Pauste
 */
public class KioskModeActivity extends Activity {
	/** Indicates if should or not deactivate the back button. */
	protected boolean blockBackButton = false;
	
	/**
	 * Sets the full screen mode to avoid an accidental exit through the title
	 * bar or any other interactive element outside of our own interface.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}
	
	/**
	 * Intercepts the key events to avoid the interaction with any element outside
	 * our interface, except the back-button, if it's enabled.
	 */	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
    	return !blockBackButton && keyCode == KeyEvent.KEYCODE_BACK
    		? super.onKeyDown(keyCode, event)
    		: true;
	}
}