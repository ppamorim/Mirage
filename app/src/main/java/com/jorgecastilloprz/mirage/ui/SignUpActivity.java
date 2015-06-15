package com.jorgecastilloprz.mirage.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import butterknife.InjectView;
import com.jorgecastilloprz.mirage.R;
import com.jorgecastilloprz.mirage.components.TextureVideoView;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SignUpActivity extends BaseActivity {

  @InjectView(R.id.textureView) TextureVideoView textureView;
  @InjectView(R.id.root) FrameLayout root;
  @InjectView(R.id.signButton) FrameLayout signInButton;
  @InjectView(R.id.logoText) View logo;

  private MediaPlayer mMediaPlayer;
  private View mDecorView;

  private final int LOGO_FADE_IN_ANIM_DELAY = 1000;
  private final int LOGO_FADE_IN_DURATION = 1000;
  private final int SIGN_BUTTON_FADE_IN_DELAY = 1500;
  private final int SIGN_IN_FADE_DURATION = 1000;
  private final int LOGO_TRANSLATE_DELAY = 1700;
  private final int FADE_OUT_SIGN_BUTTON_DURATION = 400;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);
    injectViews();
    mDecorView = getWindow().getDecorView();
    setupGestureDetector();
    initBackgroundVideo();
    postLogoFadeInAnim();
    postSignInButtonFadeAnim();
    postLogoTranslateAnim();
    setSignInButtonListener();
  }

  @Override protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  @Override public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
          | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
  }

  private void setupGestureDetector() {
    final GestureDetector clickDetector =
        new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
          @Override public boolean onSingleTapUp(MotionEvent e) {
            showSystemUI();
            return true;
          }
        });

    root.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View view, MotionEvent motionEvent) {
        return clickDetector.onTouchEvent(motionEvent);
      }
    });
  }

  @TargetApi(Build.VERSION_CODES.KITKAT) private void showSystemUI() {
    mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
  }

  private void initBackgroundVideo() {
    textureView.setScaleType(TextureVideoView.ScaleType.CENTER_CROP);
    textureView.setDataSource(this,
        Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mirage));
    textureView.setLooping(true);
    textureView.setListener(new TextureVideoView.MediaPlayerListener() {
      @Override public void onVideoPrepared() {
        textureView.play();
      }

      @Override public void onVideoEnd() {
      }
    });
  }

  private void postLogoFadeInAnim() {
    logo.postDelayed(new Runnable() {
      @Override public void run() {
        logo.animate().alpha(0.8f).setDuration(LOGO_FADE_IN_DURATION).start();
      }
    }, LOGO_FADE_IN_ANIM_DELAY);
  }

  private void postSignInButtonFadeAnim() {
    signInButton.postDelayed(new Runnable() {
      @Override public void run() {
        playSignInAppearAnim();
      }
    }, SIGN_BUTTON_FADE_IN_DELAY);
  }

  private void playSignInAppearAnim() {
    Interpolator decelerateInterpolator = new DecelerateInterpolator();

    ValueAnimator fadeIn = ObjectAnimator.ofFloat(signInButton, "alpha", 1);
    fadeIn.setInterpolator(decelerateInterpolator);

    ValueAnimator translateY =
        ObjectAnimator.ofFloat(signInButton, "translationY", signInButton.getHeight() * 4f,
            signInButton.getHeight() * 3f);
    translateY.setInterpolator(decelerateInterpolator);

    AnimatorSet signInAnim = new AnimatorSet();
    signInAnim.playTogether(fadeIn, translateY);
    signInAnim.setDuration(SIGN_IN_FADE_DURATION);
    signInAnim.start();
  }

  private void postLogoTranslateAnim() {
    signInButton.postDelayed(new Runnable() {
      @Override public void run() {
        playLogoTranslateYAnim();
      }
    }, LOGO_TRANSLATE_DELAY);
  }

  private void playLogoTranslateYAnim() {
    ValueAnimator translateY = ObjectAnimator.ofFloat(logo, "translationY", 0, -logo.getHeight());
    translateY.setDuration(SIGN_IN_FADE_DURATION);
    translateY.setInterpolator(new AccelerateDecelerateInterpolator());
    translateY.start();
  }

  private void setSignInButtonListener() {
    signInButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        playFadeOutAnim();
      }
    });
  }

  private void playFadeOutAnim() {
    signInButton.animate()
        .alpha(0)
        .setDuration(FADE_OUT_SIGN_BUTTON_DURATION)
        .setInterpolator(new DecelerateInterpolator())
        .start();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (mMediaPlayer != null) {
      mMediaPlayer.stop();
      mMediaPlayer.release();
      mMediaPlayer = null;
    }
  }
}