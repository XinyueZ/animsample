package com.animsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * Demo, play the Property Animations on < 3.0
 */
public class PreHCActivity extends ActionBarActivity {

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
	public void changeTranslation(final View v) {
		float initTranX = ViewHelper.getTranslationX(v);
		float initTranY = ViewHelper.getTranslationY(v);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playSequentially(ObjectAnimator.ofFloat(v, "translationX", Utils.getValueF(this,
						R.id.translation_start_et, 0f), Utils.getValueF(this, R.id.translation_value_et, 500f),
				initTranX).setDuration(2000), ObjectAnimator.ofFloat(v, "translationY", Utils.getValueF(this,
						R.id.translation_start_et, 0f), Utils.getValueF(this, R.id.translation_value_et, 500f),
				initTranY).setDuration(2000));
 
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
	public void scaleXme(View v) {
		float initX = ViewHelper.getScaleX(v);
		ObjectAnimator.ofFloat(v, "scaleX", Utils.getValueF(this, R.id.scale_start_et, 0f), Utils.getValueF(this,
				R.id.scale_value_et, 5f), initX).setDuration(2000).start();
	}

	/**
	 * Scale {@code v} on y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	public void scaleYme(View v) {
		float initY = ViewHelper.getScaleY(v);
		ObjectAnimator.ofFloat(v, "scaleY", Utils.getValueF(this, R.id.scale_start_et, 0f), Utils.getValueF(this,
				R.id.scale_value_et, 5f), initY).setDuration(2000).start();
	}

	/**
	 * Scale {@code v} on x-y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	public void scaleMe(final View v) {
		float initX = ViewHelper.getScaleX(v);
		float initY = ViewHelper.getScaleY(v);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(ObjectAnimator.ofFloat(v, "scaleX", Utils.getValueF(this, R.id.scale_start_et, 0f),
						Utils.getValueF(this, R.id.scale_value_et, 5f), initX).setDuration(2000),
				ObjectAnimator.ofFloat(v, "scaleY", Utils.getValueF(this, R.id.scale_start_et, 0f), Utils.getValueF(
						this, R.id.scale_value_et, 5f), initY).setDuration(2000));
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
	public void clickToRemove(final View v) {
		float initX = ViewHelper.getScaleX(v);
		float initY = ViewHelper.getScaleY(v);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(ObjectAnimator.ofFloat(v, "scaleX", initX, 0).setDuration(500), ObjectAnimator.ofFloat(
				v, "scaleY", initY, 0).setDuration(500));
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
				v.setVisibility(View.GONE);
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
	public void playAplha(final View v) {
		float initAplha = ViewHelper.getAlpha(v);
		ObjectAnimator a = ObjectAnimator.ofFloat(v, Utils.ALPHA, initAplha, Utils.getValueF(this, R.id.aplha_value_et,
				0f), 0, initAplha).setDuration(2000);
		a.setRepeatCount(ObjectAnimator.INFINITE);
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
