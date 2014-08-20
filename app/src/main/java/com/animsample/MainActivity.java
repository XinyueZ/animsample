package com.animsample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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


	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	public void rotateMe(View v) {
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", 0, Utils.getValueF(this,
				R.id.rotate_me_angle_et, 360f));
		objectAnimator.setRepeatCount(Utils.getValue(this, R.id.rotate_me_repeat_et, 2));
		objectAnimator.start();
	}

	/**
	 * Change translation of {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to change.
	 */
	public void changeTranslation(View v) {
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
		animatorSet.start();
	}

	/**
	 * Scale {@code v} on x-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
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
	public void scaleMe(View v) {
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
		animatorSet.start();
	}

	/**
	 * Simulate click and zoom to remove. It is only a scale-animation.
	 *
	 * @param v
	 * 		{@link android.view.View} to remove.
	 */
	public void clickToRemove(View v) {
		float initX = v.getScaleX();
		float initY = v.getScaleY();
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(
				ObjectAnimator.ofFloat(v, "scaleX", initX, 0).setDuration(500),
				ObjectAnimator.ofFloat(v, "scaleY", initY, 0).setDuration(500)
		);
		animatorSet.start();
	}

	/**
	 * Play aplha(transparency) on {@code v}. 1 no transparent，0 full transparent.
	 *
	 * @param v
	 * 		{@link android.view.View} to be transparent.
	 */
	public void playAplha(View v) {
		float initAplha = v.getAlpha();
		ObjectAnimator a = ObjectAnimator.ofFloat(v, "Alpha", initAplha, Utils.getValueF(this, R.id.aplha_value_et, 0f),
				0, initAplha)
				.setDuration(2000);
		a.setRepeatCount(ValueAnimator.INFINITE);
		a.start();
		v.setEnabled(false);
	}
}
