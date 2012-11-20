package org.carlosbello.android.kioskmode;

import android.os.Bundle;

/**
 * Dummy activity: only for demonstration purposes. 
 * 
 * @author Carlos Bello Pauste
 *
 */
public class SecondaryActivity extends KioskModeActivity {
	
	/**
	 * Initializes the activity, loading the dummy layout.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
	}	
}