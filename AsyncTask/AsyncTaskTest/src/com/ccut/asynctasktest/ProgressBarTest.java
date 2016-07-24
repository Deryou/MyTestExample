package com.ccut.asynctasktest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressBarTest extends Activity {

	private ProgressBar pg;
	private MyAsyncTask task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar);
		pg = (ProgressBar) findViewById(R.id.progressBar1);
		task = new MyAsyncTask();
		task.execute();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(task != null& task.getStatus() == AsyncTask.Status.RUNNING){
			task.cancel(true);
		}
	}
	
	class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
		
		@Override
		protected Void doInBackground(Void... params) {
			for (int i = 0; i < 100; i++) {
				if(isCancelled()){
					break;
				}
				publishProgress(i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			if(isCancelled()){
				return ;
			}
			pg.setProgress(values[0]);
		}
	}
}
