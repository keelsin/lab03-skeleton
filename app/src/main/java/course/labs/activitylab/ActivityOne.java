package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";

		// lifecycle counts
		//TODO: Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
			int createCount=0, startCount=0, resumeCount=0, pauseCount=0,
				stopCount=0, restartCount=0, destroyCount = 0;

			TextView createCounter, startCounter, resumeCounter, pauseCounter,
					stopCounter, destroyCounter, restartCounter;
		//TODO:  increment the variables' values when their corresponding lifecycle methods get called.
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);
			
			//Log cat print out
			Log.i(TAG, "onCreate called");
			//TODO: update the appropriate count variable & update the view

			if (savedInstanceState != null) {
				createCount = savedInstanceState.getInt("createCount");
				Log.i(TAG, "onRestoreInstance called ");
				startCount = savedInstanceState.getInt("startCount");
				resumeCount = savedInstanceState.getInt("resumeCount");
				pauseCount = savedInstanceState.getInt("pauseCount");
				stopCount = savedInstanceState.getInt("stopCount");
				destroyCount = savedInstanceState.getInt("destroyCount");
				restartCount = savedInstanceState.getInt("restartCount");
			}

			createCounter = (TextView) findViewById(R.id.createCounter);
			startCounter = (TextView) findViewById(R.id.startCounter);
			resumeCounter = (TextView) findViewById(R.id.resumeCounter);
			pauseCounter = (TextView) findViewById(R.id.pauseCounter);
			stopCounter = (TextView) findViewById(R.id.stopCounter);
			destroyCounter = (TextView) findViewById(R.id.destroyCounter);
			restartCounter = (TextView) findViewById(R.id.restartCounter);




			createCount++;
			createCounter.setText(Integer.toString(createCount));
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();
			
			//Log cat print out
			Log.i(TAG, "onStart called");
			
			//TODO:  update the appropriate count variable & update the view
			startCount++;
			startCounter.setText(Integer.toString(startCount));
		}

	// TODO: implement 5 missing lifecycle callback methods

		@Override
		public void onResume(){
			super.onResume();

			//Log cat print out
			Log.i(TAG, "onResume called");

			resumeCount++;
			resumeCounter.setText(Integer.toString(resumeCount));
		}

		@Override
		public void onPause(){
			super.onPause();

			//Log cat print out
			Log.i(TAG, "onPause called");

			pauseCount++;
			pauseCounter.setText(Integer.toString(pauseCount));
		}

		@Override
		public void onStop(){
			super.onStop();

			//Log cat print out
			Log.i(TAG, "onStop called");

			stopCount++;
			stopCounter.setText(Integer.toString(stopCount));
		}

		@Override
		public void onDestroy(){
			super.onDestroy();

			//Log cat print out
			Log.i(TAG, "onDestroy called");

			destroyCount++;
			destroyCounter.setText(Integer.toString(destroyCount));
		}

		@Override
		public void onRestart(){
			super.onRestart();

			//Log cat print out
			Log.i(TAG, "onRestart called");

			restartCount++;
			restartCounter.setText(Integer.toString(restartCount));
		}





		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			//TODO:  save state information with a collection of key-value pairs & save all  count variables
			super.onSaveInstanceState(savedInstanceState);
			Log.i(TAG, "onSaveInstance called");
			savedInstanceState.putInt("createCount", createCount);
			savedInstanceState.putInt("startCount", startCount);
			savedInstanceState.putInt("resumeCount", resumeCount);
			savedInstanceState.putInt("pauseCount", pauseCount);
			savedInstanceState.putInt("stopCount", stopCount);
			savedInstanceState.putInt("destroyCount", destroyCount);
			savedInstanceState.putInt("restartCount", restartCount);
		}

		/*public void onRestoreInstanceState(Bundle savedInstanceState){
			//Always call the superclass so it can restore the view hierarchy
			super.onRestoreInstanceState(savedInstanceState);

			createCount = savedInstanceState.getInt("createCount");
			Log.i(TAG, "onRestoreInstance called ");
			startCount = savedInstanceState.getInt("startCount");
			resumeCount = savedInstanceState.getInt("resumeCount");
			pauseCount = savedInstanceState.getInt("pauseCount");
			stopCount = savedInstanceState.getInt("stopCount");
			destroyCount = savedInstanceState.getInt("destroyCount");
			restartCount = savedInstanceState.getInt("restartCount");
		}*/


		public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}
		

}
