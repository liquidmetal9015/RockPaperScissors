package one.imusing.rockpaperscissors;





import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private static int pChoice = 0;
	private static String pName = "";

	private static int aiChoice = 0;
	private static String aiName = "";

	private static String win = "";

	private static boolean end = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button rock = (Button) findViewById(R.id.button1);
		Button paper = (Button) findViewById(R.id.button2);
		Button scissors = (Button) findViewById(R.id.button3);
		Button pizza = (Button) findViewById(R.id.button5);


		pizza.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this, Pizza.class);
				startActivity(intent);

			}




		});



		//TextView status = (TextView) findViewById(R.id.textView3);

		rock.setOnClickListener(new View.OnClickListener() {
			TextView status = (TextView) findViewById(R.id.textView3);

			@Override
			public void onClick(View v) {

				//if (end == false) {
				pChoose(1);

				aiChoose();
				dWinner();
				status.setText(win);
				//}
			}

		});

		paper.setOnClickListener(new View.OnClickListener() {
			TextView status = (TextView) findViewById(R.id.textView3);

			@Override
			public void onClick(View v) {
				pChoose(2);
				aiChoose();
				dWinner();
				status.setText(win);

			}

		});

		scissors.setOnClickListener(new View.OnClickListener() {
			TextView status = (TextView) findViewById(R.id.textView3);

			@Override
			public void onClick(View v) {
				pChoose(3);
				aiChoose();
				dWinner();
				status.setText(win);

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

	public void aiChoose() {

		ImageView player = (ImageView) findViewById(R.id.imageView2);

		aiChoice = (int) Math.ceil(Math.random() * 3);

		switch (aiChoice) {
		case 1:
			aiName = "Rock";
			player.setImageResource(R.drawable.small);
			break;
		case 2:
			aiName = "Paper";
			player.setImageResource(R.drawable.paper);
			break;
		case 3:
			aiName = "Scissors";
			player.setImageResource(R.drawable.scissors);
			break;
		}

	}

	public void pChoose(int input) {

		ImageView player = (ImageView) findViewById(R.id.imageView1);

		pChoice = input;

		switch (input) {
		case 1:
			pName = "Rock";
			player.setImageResource(R.drawable.small);
			break;
		case 2:
			pName = "Paper";
			player.setImageResource(R.drawable.paper);
			break;
		case 3:
			pName = "Scissors";
			player.setImageResource(R.drawable.scissors);
			break;
		}

	}

	public void dWinner() {

		if ((pChoice == 1 && aiChoice == 3) || (pChoice == 2 && aiChoice == 1)
				|| (pChoice == 3 && aiChoice == 2)) {
			win = "Player wins!!!";

		} else if (pChoice == aiChoice) {
			win = "It was a Draw";

		} else {
			win = "The computer beat you!!!";

		}

		end = true;

	}

}
