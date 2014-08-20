package com.animsample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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

	/**
	 * Rotate {@code v}.
	 * @param v {@link android.view.View} to rotate.
	 */
	public void rotateMe(View v) {
		int repeatCount = 2;
		TextView repeatTv = (TextView) findViewById(R.id.rotate_me_repeat_et);
		if(!TextUtils.isEmpty(repeatTv.getText())) {
			repeatCount = Integer.valueOf(repeatTv.getText().toString());
		}
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", 0, 360f);
		objectAnimator.setRepeatCount(repeatCount);
		objectAnimator.start();
	}

	/**
	 * Move {@code v}.
	 * @param v {@link android.view.View} to move.
	 */
	public void moveMe(View v) {
		float startX = v.getX();
		float startY = v.getY();
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playSequentially(
				ObjectAnimator.ofFloat(v, "translationX", 0f, 400f).setDuration(2000),
				ObjectAnimator.ofFloat(v, "translationY", 0f, 400f).setDuration(2000),
				ObjectAnimator.ofFloat(v, "x", startX).setDuration(2000),
				ObjectAnimator.ofFloat(v, "y", startY).setDuration(2000));
		animatorSet.start();
	}
}
