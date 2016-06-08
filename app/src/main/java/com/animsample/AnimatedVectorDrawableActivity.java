package com.animsample;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.animsample.databinding.AnimatedVectorDrawableBinding;


public class AnimatedVectorDrawableActivity extends AppCompatActivity {
	private static final @LayoutRes int LAYOUT = R.layout.activity_animated_vector_drawable;

	private AnimatedVectorDrawableBinding mBinding;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, LAYOUT);

		Drawable drawable = mBinding.animatedDrawableIv.getDrawable();
		if( drawable instanceof Animatable) {
			( (Animatable) drawable ).start();
		}
	}

}
