package com.example.modechange;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedActivity extends Activity {
	EditText et1,et2,et3;
	SharedPreferences sp;
	Button save;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		save=(Button)findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sp=getSharedPreferences("MyPreference",MODE_PRIVATE);
				String silent=et1.getText().toString().trim();
				String ring=et2.getText().toString().trim();
				String vibrate=et3.getText().toString().trim();
				SharedPreferences.Editor ed=sp.edit();
				ed.putString("silent", silent);
				ed.putString("ring", ring);
				ed.putString("vibrate", vibrate);
				ed.commit();
				
				Toast.makeText(getApplicationContext(), ""+silent+ring+vibrate, 1000).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_shared, menu);
		return true;
	}

}
