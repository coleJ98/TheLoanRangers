package com.example.theloanranger;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActionBar bar = getActionBar();
        //bar.setBackgroundDrawable(new ColorDrawable(R.color.off_white_background));
        //bar.setDisplayShowTitleEnabled(false);
        //bar.setDisplayShowTitleEnabled(true);

        
        setContentView(R.layout.activity_main);
        
        Button calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openPage = new Intent(getBaseContext(), DisplayActivity.class);
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
