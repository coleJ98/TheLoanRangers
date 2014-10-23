package com.example.theloanranger;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        
        //Trying to fix my repo with this comment
        
        
        setContentView(R.layout.activity_main);
        
        
        Button calculate = (Button) findViewById(R.id.calculate);
               calculate.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {

        				Intent openPage = new Intent(getBaseContext(), DisplayActivity.class);
        				
        				//Find the EditTexts from the XML layout
        				EditText amount_interest = (EditText) findViewById(R.id.amount_interest);
        				EditText amount_to_pay = (EditText) findViewById(R.id.amount_to_pay);
        				
        				//Fetch the values of them and convert them to doubles
        				double interest = Double.parseDouble(amount_interest.getText().toString());
        				double amount = Double.parseDouble(amount_to_pay.getText().toString());
        				
        				
        				
        				//Add the values to the intent
        				openPage.putExtra("INTEREST", interest);
        				openPage.putExtra("AMOUNT", amount);
        				
        				
        				//Start the new activity
        				startActivity(openPage);
        			}
        		});
     

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
