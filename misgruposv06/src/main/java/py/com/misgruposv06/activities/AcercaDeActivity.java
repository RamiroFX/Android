package py.com.misgruposv06.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import py.com.misgruposv06.R;


public class AcercaDeActivity extends Activity {
	private String tag = "AppMisGrupos";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(tag, "Inicia metodo en AcercaDeActivity.onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acerca_de);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		return true;
	}
}
