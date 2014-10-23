package com.example.theloanranger;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		
		
		//Receive the intent and fetch the values passed from the other activity
		Intent intent = getIntent();
		double amount = intent.getDoubleExtra("AMOUNT", 0.0);
		double interest = intent.getDoubleExtra("INTEREST", 0.0);
		
		
		//Find the TextViews in the XML where we will display our values
		TextView amountView = (TextView) findViewById(R.id.amount_display);
		TextView interestView = (TextView) findViewById(R.id.interest_display);
		
		//Set the text of them
		amountView.setText("" + amount);
		interestView.setText("" + interest);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
