package com.animsample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Demo, play the View Property Animations.
 */
public final class MainViewPropertyAnimActivity extends AppCompatActivity {

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

	@Override
	protected void onResume() {
		super.onResume();
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR1) {
			new AlertDialog.Builder(this).setMessage("Only pre 3.1 demo show available.").setCancelable(false)
					.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Intent intent = new Intent(MainViewPropertyAnimActivity.this, PreHCActivity.class);
							intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
							startActivity(intent);
						}
					}).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			}).create().show();
		}
	}


	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void rotateMe(final View v) {
		v.setEnabled(false);
		v.animate().rotation(360).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setRotation(0);
				v.setEnabled(true);
			}
		});
	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void rotateXMe(final View v) {
		v.setEnabled(false);
		v.animate().rotationX(360).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setRotationX(0);
				v.setEnabled(true);
			}
		});
	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void rotateYMe(final View v) {
		v.setEnabled(false);
		v.animate().rotationY(360).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setRotationY(0);
				v.setEnabled(true);
			}
		});
	}


	/**
	 * Change translation of {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to change.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void changeTranslation(final View v) {
		final float initTranX = v.getTranslationX();
		final float initTranY = v.getTranslationY();
		v.setEnabled(false);
		v.animate().translationX(400).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.animate().translationY(400).setDuration(2000).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						v.animate().translationX(initTranX).translationY(initTranY).setDuration(2000).setListener(
								new AnimatorListenerAdapter() {
									@Override
									public void onAnimationEnd(Animator animation) {
										super.onAnimationEnd(animation);
										v.setEnabled(true);
									}
								});
					}
				});
			}
		});
	}

	/**
	 * Scale {@code v} on x-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void scaleXme(final View v) {
		v.setEnabled(false);
		final float init = v.getScaleX();
		v.animate().scaleX(10f).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.animate().scaleX(init).setDuration(2000).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						v.setEnabled(true);
					}
				});
			}
		});
	}

	/**
	 * Scale {@code v} on y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void scaleYme(final View v) {
		v.setEnabled(false);
		final float init = v.getScaleY();
		v.animate().scaleY(10f).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.animate().scaleY(init).setDuration(2000).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						v.setEnabled(true);
					}
				});
			}
		});
	}

	/**
	 * Scale {@code v} on x-y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void scaleMe(final View v) {
		v.setEnabled(false);
		final float initX = v.getScaleX();
		final float initY = v.getScaleY();
		v.animate().scaleX(10f).scaleY(10f).setDuration(2000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.animate().scaleX(initX).scaleY(initY).setDuration(2000).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						v.setEnabled(true);
					}
				});
			}
		});
	}

	/**
	 * Simulate click and zoom to remove. It is only a scale-animation.
	 *
	 * @param v
	 * 		{@link android.view.View} to remove.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void clickToRemove(final View v) {
		v.setEnabled(false);
		v.animate().scaleX(0).scaleY(0).setDuration(1000).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				v.setVisibility(View.GONE);
			}
		});
	}


	/**
	 * Play aplha(transparency) on {@code v}. 1 no transparent，0 full transparent.
	 *
	 * @param v
	 * 		{@link android.view.View} to be transparent.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	public void playAplha(final View v) {
		if (v != null) {
			mAplhaV = v;
			mAplhaV.setEnabled(false);
			mAplhaV.animate().alpha(mCurrentAlpha).setDuration(500).setListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					super.onAnimationEnd(animation);
					sendBroadcast(new Intent(ACTION_UPDATE_APLHA));
				}
			});
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
