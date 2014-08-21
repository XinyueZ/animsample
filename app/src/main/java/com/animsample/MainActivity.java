package com.animsample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Demo, play property animations.
 */
public class MainActivity extends ActionBarActivity {

	public static final int LAYOUT = R.layout.activity_main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(LAYOUT);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (android.os.Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
			new AlertDialog.Builder(this)
					.setMessage("Only pre 3.0 demo show available.")
					.setCancelable(false)
					.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Intent intent = new Intent(MainActivity.this, PreHCActivity.class);
							intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
							startActivity(intent);
						}
					}).create().show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_pre_hc:
				Intent intent = new Intent(this, PreHCActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent);
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void rotateMe(final View v) {
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", 0, Utils.getValueF(this,
				R.id.rotate_me_angle_et, 360f));
		objectAnimator.setRepeatCount(Utils.getValue(this, R.id.rotate_me_repeat_et, 2));
		objectAnimator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				v.setEnabled(false);
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setEnabled(true);
			}
		});
		objectAnimator.start();
	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void rotateXMe(final View v) {
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotationX", 0, Utils.getValueF(this,
				R.id.rotate_me_angle_et, 360f));
		objectAnimator.setRepeatCount(Utils.getValue(this, R.id.rotate_me_repeat_et, 2));
		objectAnimator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				v.setEnabled(false);
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setEnabled(true);
			}
		});
		objectAnimator.start();
	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void rotateYMe(final View v) {
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotationY", 0, Utils.getValueF(this,
				R.id.rotate_me_angle_et, 360f));
		objectAnimator.setRepeatCount(Utils.getValue(this, R.id.rotate_me_repeat_et, 2));
		objectAnimator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				v.setEnabled(false);
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setEnabled(true);
			}
		});
		objectAnimator.start();
	}


	/**
	 * Change translation of {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to change.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void changeTranslation(final View v) {
		float initTranX = v.getTranslationX();
		float initTranY = v.getTranslationY();
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playSequentially(
				ObjectAnimator.ofFloat(v, "translationX", Utils.getValueF(this, R.id.translation_start_et, 0f),
						Utils.getValueF(this, R.id.translation_value_et, 500f), initTranX).setDuration(2000),
				ObjectAnimator.ofFloat(v, "translationY", Utils.getValueF(this, R.id.translation_start_et, 0f),
						Utils.getValueF(this, R.id.translation_value_et, 500f), initTranY).setDuration(2000)
		);

//		float startX = v.getX();
//		float startY = v.getY();
//				ObjectAnimator.ofFloat(v, "x", startX).setDuration(2000),
//				ObjectAnimator.ofFloat(v, "y", startY).setDuration(2000));
		animatorSet.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				v.setEnabled(false);
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setEnabled(true);
			}
		});
		animatorSet.start();
	}

	/**
	 * Scale {@code v} on x-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void scaleXme(View v) {
		float initX = v.getScaleX();
		ObjectAnimator.ofFloat(v, "scaleX", Utils.getValueF(this, R.id.scale_start_et, 0f), Utils
				.getValueF(
						this, R.id.scale_value_et, 5f), initX).setDuration(2000).start();
	}

	/**
	 * Scale {@code v} on y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void scaleYme(View v) {
		float initY = v.getScaleY();
		ObjectAnimator.ofFloat(v, "scaleY", Utils.getValueF(this, R.id.scale_start_et, 0f), Utils
				.getValueF(
						this, R.id.scale_value_et, 5f), initY).setDuration(2000).start();
	}

	/**
	 * Scale {@code v} on x-y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void scaleMe(final View v) {
		float initX = v.getScaleX();
		float initY = v.getScaleY();
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(
				ObjectAnimator.ofFloat(v, "scaleX", Utils.getValueF(this, R.id.scale_start_et, 0f), Utils
						.getValueF(
								this, R.id.scale_value_et, 5f), initX).setDuration(2000),
				ObjectAnimator.ofFloat(v, "scaleY", Utils.getValueF(this, R.id.scale_start_et, 0f), Utils
						.getValueF(
								this, R.id.scale_value_et, 5f), initY).setDuration(2000)
		);
		animatorSet.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				v.setEnabled(false);
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setEnabled(true);
			}
		});
		animatorSet.start();
	}

	/**
	 * Simulate click and zoom to remove. It is only a scale-animation.
	 *
	 * @param v
	 * 		{@link android.view.View} to remove.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void clickToRemove(final View v) {
		float initX = v.getScaleX();
		float initY = v.getScaleY();
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(
				ObjectAnimator.ofFloat(v, "scaleX", initX, 0).setDuration(500),
				ObjectAnimator.ofFloat(v, "scaleY", initY, 0).setDuration(500)
		);
		animatorSet.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				v.setEnabled(false);
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setEnabled(true);
			}
		});
		animatorSet.start();
	}

	/**
	 * Play aplha(transparency) on {@code v}. 1 no transparent，0 full transparent.
	 *
	 * @param v
	 * 		{@link android.view.View} to be transparent.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void playAplha(final View v) {
		float initAplha = v.getAlpha();
		ObjectAnimator a = ObjectAnimator.ofFloat(v, Utils.ALPHA, initAplha, Utils.getValueF(this, R.id.aplha_value_et, 0f),
				0, initAplha)
				.setDuration(2000);
		a.setRepeatCount(ValueAnimator.INFINITE);
		a.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				v.setEnabled(false);
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setEnabled(true);
			}
		});
		a.start();
	}
}
