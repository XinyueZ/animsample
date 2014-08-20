package com.animsample;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Util for some methods to get property settings from UI.
 */
public final class Utils {
	/**
	 * Get {@link int} value from {@code uiResId} on {@link android.app.Activity}.
	 *
	 * @param act
	 * 		{@link android.app.Activity}.
	 * @param uiResId
	 * 		The resource id of UI to provide value.
	 * @param defaultValue
	 * 		The default value when no value is inputted UI.
	 *
	 * @return The value for demo.
	 */
	public static int getValue(Activity act, int uiResId, int defaultValue) {
		TextView tv = (TextView) act.findViewById(uiResId);
		if (!TextUtils.isEmpty(tv.getText())) {
			defaultValue = Integer.valueOf(tv.getText().toString());
		}
		return defaultValue;
	}

	/**
	 * Get {@link float} value from {@code uiResId} on {@link android.app.Activity}.
	 *
	 * @param act
	 * 		{@link android.app.Activity}.
	 * @param uiResId
	 * 		The resource id of UI to provide value.
	 * @param defaultValue
	 * 		The default value when no value is inputted UI.
	 *
	 * @return The value for demo.
	 */
	public static float getValueF(Activity act, int uiResId, float defaultValue) {
		TextView tv = (TextView) act.findViewById(uiResId);
		if (!TextUtils.isEmpty(tv.getText())) {
			defaultValue = Float.valueOf(tv.getText().toString());
		}
		return defaultValue;
	}
}
