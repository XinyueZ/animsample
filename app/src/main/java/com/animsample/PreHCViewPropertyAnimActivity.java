package com.animsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Demo, play the View Property Animations.
 */
public class PreHCViewPropertyAnimActivity extends ActionBarActivity {

	public static final int LAYOUT = R.layout.activity_vpa;

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

	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	public void rotateXMe(final View v) {

	}

	/**
	 * Rotate {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to rotate.
	 */
	public void rotateYMe(final View v) {

	}


	/**
	 * Change translation of {@code v}.
	 *
	 * @param v
	 * 		{@link android.view.View} to change.
	 */
	public void changeTranslation(final View v) {

	}

	/**
	 * Scale {@code v} on x-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	public void scaleXme(View v) {

	}

	/**
	 * Scale {@code v} on y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	public void scaleYme(View v) {

	}

	/**
	 * Scale {@code v} on x-y-axis.
	 *
	 * @param v
	 * 		{@link android.view.View} to scale.
	 */
	public void scaleMe(final View v) {

	}

	/**
	 * Simulate click and zoom to remove. It is only a scale-animation.
	 *
	 * @param v
	 * 		{@link android.view.View} to remove.
	 */
	public void clickToRemove(final View v) {

	}

	/**
	 * Play aplha(transparency) on {@code v}. 1 no transparent，0 full transparent.
	 *
	 * @param v
	 * 		{@link android.view.View} to be transparent.
	 */
	public void playAplha(final View v) {

	}
}
