/*
 * Copyright (C) 2015 Jorge Castillo Pérez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jorgecastilloprz.mirage.ui.components;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.jorgecastilloprz.mirage.R;

/**
 * @author Jorge Castillo Pérez
 */
public class SignInButtonBox extends FrameLayout {

  private final int ANIM_TRANSLATE_DURATION = 1500;

  public SignInButtonBox(Context context) {
    super(context);
    init();
  }

  public SignInButtonBox(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SignInButtonBox(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SignInButtonBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    inflate(getContext(), R.layout.signin_box, this);
  }

  public void show() {
    ValueAnimator fadeIn = ObjectAnimator.ofFloat(this, "alpha", 0, 1);
    ValueAnimator translateAnim =
        ObjectAnimator.ofFloat(this, "translationY", getY() + getHeight() / 2, getY());

    AnimatorSet set = new AnimatorSet();
    set.playTogether(fadeIn, translateAnim);
    set.setInterpolator(new DecelerateInterpolator());
    set.setDuration(ANIM_TRANSLATE_DURATION);
    set.start();
  }
}
