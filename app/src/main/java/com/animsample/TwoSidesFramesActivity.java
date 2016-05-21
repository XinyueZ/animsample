package com.animsample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animsample.databinding.FrameBinding;
import com.animsample.databinding.MainBinding;


public final class TwoSidesFramesActivity extends AppCompatActivity {
	private static final String TAG = TwoSidesFramesActivity.class.getName();
	private static final @LayoutRes int LAYOUT = R.layout.activity_two_side_frames;
	private static final int DURATION = 1000;
	private static final @IdRes int LAYOUT_CONTAINER_LEFT_FRAGMENT = R.id.main_container_left;
	private static final @ColorRes int LEFT_COLOR = R.color.colorPrimaryDark;
	private static final @StringRes int LEFT_TEXT = R.string.left;
	private MainBinding mBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, LAYOUT);

		//Animates
		final ScreenSize sz = getScreenSize(this, 0);
		final double lPerc = sz.Width * 0.4;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			//Right
			ObjectAnimator animator = ObjectAnimator.ofInt(mBinding.mainContainerRight, "left", (int) lPerc)
			                                        .setDuration(DURATION);
			animator.addListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					super.onAnimationEnd(animation);
					mBinding.mainContainerRight.getLayoutParams().width = (int) (sz.Width - lPerc);
				}
			});
			animator.start();
		}
		//Show fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
		               .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_in_left)
		               .replace(LAYOUT_CONTAINER_LEFT_FRAGMENT, FrameFragment.newInstance(getApplicationContext(), LEFT_TEXT, LEFT_COLOR))
		               .commit();
		fragmentManager.executePendingTransactions();
	}


	private static ScreenSize getScreenSize(Context cxt, int displayIndex) {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		Display[] displays = DisplayManagerCompat.getInstance(cxt)
		                                         .getDisplays();
		Display display = displays[displayIndex];
		display.getMetrics(displaymetrics);
		return new ScreenSize(displaymetrics.widthPixels, displaymetrics.heightPixels);
	}

	private final static class ScreenSize {
		public final int Width;
		public final int Height;

		public ScreenSize(int _width, int _height) {
			Width = _width;
			Height = _height;
		}
	}


	public final static class FrameFragment extends Fragment {
		private static final String EXTRAS_BACKGROUND_COLOR = FrameFragment.class.getName() + ".EXTRAS.background_color";
		private static final String EXTRAS_TEXT = FrameFragment.class.getName() + ".EXTRAS.text";
		private static final @LayoutRes int LAYOUT = R.layout.fragment_frame;
		private FrameBinding mBinding;

		public static Fragment newInstance(Context cxt, @StringRes int text, @ColorRes int backgroundColor) {
			Bundle args = new Bundle(2);
			args.putInt(EXTRAS_TEXT, text);
			args.putInt(EXTRAS_BACKGROUND_COLOR, backgroundColor);
			return Fragment.instantiate(cxt, FrameFragment.class.getName(), args);
		}

		@Nullable
		@Override
		public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
			mBinding = DataBindingUtil.inflate(inflater, LAYOUT, container, false);
			return mBinding.getRoot();
		}

		@Override
		public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
			super.onViewCreated(view, savedInstanceState);
			Bundle args = getArguments();
			mBinding.setText(getString(args.getInt(EXTRAS_TEXT)));
			int color = ResourcesCompat.getColor(getResources(), args.getInt(EXTRAS_BACKGROUND_COLOR), null);
			view.setBackgroundColor(color);
		}
	}
}
