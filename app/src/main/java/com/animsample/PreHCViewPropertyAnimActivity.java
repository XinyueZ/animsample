package com.animsample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

/**
 * Demo, play the View Property Animations pre 3.1.
 */
public final class PreHCViewPropertyAnimActivity extends AppCompatActivity {

	public static final int LAYOUT = R.layout.activity_vpa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(LAYOUT);
		registerReceiver(mUpdateAplhaReceiver, mUpdateAplhaFilter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mUpdateAplhaReceiver);
	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	public void rotateMe(final View v) {
		v.setEnabled(false);
		ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
		animator.rotation(360).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				ViewHelper.setRotation(v, 0);
				v.setEnabled(true);
			}
		}).start();
	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	public void rotateXMe(final View v) {
		v.setEnabled(false);
		ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
		animator.rotationX(360).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				ViewHelper.setRotationX(v, 0);
				v.setEnabled(true);
			}
		}).start();
	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	public void rotateYMe(final View v) {
		v.setEnabled(false);
		ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
		animator.rotationY(360).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				ViewHelper.setRotationY(v, 0);
				v.setEnabled(true);
			}
		}).start();
	}


	/**
	 * Change translation of {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to change.
	 */
	public void changeTranslation(final View v) {
		final float initTranX = ViewHelper.getTranslationX(v);
		final float initTranY = ViewHelper.getTranslationY(v);
		v.setEnabled(false);
		ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
		animator.translationX(400).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
				animator.translationY(400).setDuration(2000).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
						animator.translationX(initTranX).translationY(initTranY).setDuration(2000).setListener(
								new AnimatorListenerAdapter() {
									@Override
									public void onAnimationEnd(Animator animation) {
										super.onAnimationEnd(animation);
										v.setEnabled(true);
									}
								}).start();
					}
				}).start();
			}
		});
	}

	/**
	 * Scale {@code v} on x-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	public void scaleXme(final View v) {
		v.setEnabled(false);
		final float init = ViewHelper.getScaleX(v);
		ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
		animator.scaleX(10f).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
				animator.scaleX(init).setDuration(2000).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						v.setEnabled(true);
					}
				}).start();
			}
		}).start();
	}

	/**
	 * Scale {@code v} on y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	public void scaleYme(final View v) {
		v.setEnabled(false);
		final float init = ViewHelper.getScaleY(v);
		ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
		animator.scaleY(10f).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
				animator.scaleY(init).setDuration(2000).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						v.setEnabled(true);
					}
				}).start();
			}
		}).start();
	}

	/**
	 * Scale {@code v} on x-y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	public void scaleMe(final View v) {
		v.setEnabled(false);
		final float initX = ViewHelper.getScaleX(v);
		final float initY = ViewHelper.getScaleY(v);
		ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
		animator.scaleX(10f).scaleY(10f).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
				animator.scaleX(initX).scaleY(initY).setDuration(2000).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						v.setEnabled(true);
					}
				}).start();
			}
		}).start();
	}

	/**
	 * Simulate click and zoom to remove. It is only a scale-animation.
	 *
	 * @param v
	 * 		{@link android.view.View} to remove.
	 */
	public void clickToRemove(final View v) {
		v.setEnabled(false);
		ViewPropertyAnimator animator = ViewPropertyAnimator.animate(v);
		animator.scaleX(0).scaleY(0).setDuration(1000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setVisibility(View.GONE);
			}
		}).start();
	}


	/**
	 * Play aplha(transparency) on {@code v}. 1 no transparent，0 full transparent.
	 *
	 * @param v
	 * 		{@link android.view.View} to be transparent.
	 */
	public void playAplha(final View v) {
		if(v != null) {
			mAplhaV = v;
			mAplhaV.setEnabled(false);
			ViewPropertyAnimator animator = ViewPropertyAnimator.animate(mAplhaV);
			animator.alpha(mCurrentAlpha).setDuration(500).setListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					super.onAnimationEnd(animation);
					sendBroadcast(new Intent(ACTION_UPDATE_APLHA));
				}
			}).start();
		}
	}


	private static final String ACTION_UPDATE_APLHA = "update.aplha.action";
	private float mCurrentAlpha = 0;
	private View mAplhaV;
	private IntentFilter mUpdateAplhaFilter = new IntentFilter(ACTION_UPDATE_APLHA);
	private BroadcastReceiver mUpdateAplhaReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			mCurrentAlpha = mCurrentAlpha == 0 ? 1 : 0;
			playAplha(mAplhaV);
		}
	};
}
