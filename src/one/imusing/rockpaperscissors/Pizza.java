package one.imusing.rockpaperscissors;


import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class Pizza extends ActionBarActivity {

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
	    switch (item.getItemId()) {
	 
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	       
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pizza);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		WebView it = (WebView)findViewById(R.id.webView1);
		
		it.getSettings().setJavaScriptEnabled(true);
		
		it.loadUrl("http://www.pizzahut.com");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		return true;
	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}
