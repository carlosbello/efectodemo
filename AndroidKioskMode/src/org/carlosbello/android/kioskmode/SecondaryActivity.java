package org.carlosbello.android.kioskmode;

import android.os.Bundle;

public class SecondaryActivity extends KioskModeActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
	}	
}