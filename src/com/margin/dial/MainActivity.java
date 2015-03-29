package com.margin.dial;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private EditText et_number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_number = (EditText) findViewById(R.id.et_number);
		Button bt_dial = (Button) findViewById(R.id.bt_dial);
		
		bt_dial.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callPhone();
			}
		});
	}

	protected void callPhone() {
		String number = et_number.getText().toString();
		if(TextUtils.isEmpty(number)) {
			Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:" + number));
		startActivity(intent);
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
		return super.onOptionsItemSelected(item);
	}
}
