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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;


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
               Spinner selectMonth = (Spinner)findViewById(R.id.month_spinner);
               String[] months = new String[]{"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
               ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);
               selectMonth.setAdapter(monthAdapter);
               
               Spinner selectYear = (Spinner)findViewById(R.id.year_spinner);
               //****TODO:     Fill in the rest of the years later - maybe 30 year max?
               String[] years = new String[]{"2014", "2015", "2016", "2017", "..."};
               ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
               selectYear.setAdapter(yearAdapter); 

    }
    
    //Select method used to gray-out radio button options
    public void select(View v)
    {
    	//boolean check = ((RadioButton) v).isChecked();
    	
    	//LinearLayout byDateOption = (LinearLayout) findViewById(R.id.spinner_section);
    	Spinner months = (Spinner)findViewById(R.id.month_spinner);
    	Spinner years = (Spinner)findViewById(R.id.year_spinner);
    	SeekBar byPaymentOption = (SeekBar)findViewById(R.id.slider_section);

    	
    	switch(v.getId())
    	{
    		case R.id.choose_monthly:		//Choose Date Option Selected
    			months.setEnabled(true);
    			years.setEnabled(true);
    			byPaymentOption.setEnabled(false);	//gray-out slider
    			break;
    			
    		case R.id.choose_date:		//Choose Date Option Selected
    			months.setEnabled(false);
    			years.setEnabled(false);
    			byPaymentOption.setEnabled(true);	//gray-out slider
    			break;
    			
    		default:					//Choose Month Option Selected
    			months.setEnabled(true);		//gray-out date-picker
				years.setEnabled(true);
    			byPaymentOption.setEnabled(true);
    			break;
    			
    	} 
    	
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
