package com.ccut.asynctasktest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class ImageTest extends Activity {
	private ImageView imageView;
	private ProgressBar progressBar;
	private static String URL = "http://img.my.csdn.net/uploads/201504/12/1428806103_9476.png";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		imageView = (ImageView) findViewById(R.id.imageView);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		new MyAsyncTask().execute(URL);
	}

	class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressBar.setVisibility(View.VISIBLE);
		}

		@Override
		protected void onPostExecute(Bitmap bitmap) {
			super.onPostExecute(bitmap);
			progressBar.setVisibility(View.GONE);
			imageView.setImageBitmap(bitmap);
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			// 获取传递进来的参数，
			String url = params[0];
			Bitmap bitmap = null;
			URLConnection urlConnection;
			InputStream inputStream = null;
			try {
				// 耗时操作，必须在此完成
				urlConnection = new URL(url).openConnection();
				inputStream = urlConnection.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				Thread.sleep(2000);
				// 将输入流转换为bitmap，通过decodeStream解析
				bitmap = BitmapFactory.decodeStream(bis);
				inputStream.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bitmap;
		}
	}
}
