package com.jorgecastilloprz.mirage.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import butterknife.InjectView;
import com.jorgecastilloprz.mirage.MirageApp;
import com.jorgecastilloprz.mirage.R;
import com.jorgecastilloprz.mirage.ui.components.SignInButtonBox;
import com.jorgecastilloprz.mirage.ui.components.TextureVideoView;
import com.jorgecastilloprz.mirage.di.component.DaggerMirageSignInActivityComponent;
import com.jorgecastilloprz.mirage.di.component.MirageSignInActivityComponent;
import com.jorgecastilloprz.mirage.di.modules.ActivityModule;
import com.jorgecastilloprz.mirage.ui.base.SignInActivity;

public class MirageSignInActivity extends SignInActivity {

  @InjectView(R.id.textureView) TextureVideoView textureView;
  @InjectView(R.id.root) FrameLayout root;
  @InjectView(R.id.signButton) FrameLayout signInButton;
  @InjectView(R.id.logoText) View logo;
  @InjectView(R.id.signInButtonBox) SignInButtonBox buttonBox;

  private MediaPlayer mMediaPlayer;
  private View mDecorView;

  private final int LOGO_FADE_IN_ANIM_DELAY = 1500;
  private final int LOGO_FADE_IN_DURATION = 1000;
  private final int SIGN_BUTTON_FADE_IN_DELAY = 2000;
  private final int SIGN_IN_FADE_DURATION = 1500;
  private final int LOGO_TRANSLATE_DELAY = 2000;
  private final int FADE_OUT_SIGN_BUTTON_DURATION = 400;

  private MirageSignInActivityComponent component;

  public MirageSignInActivityComponent component() {
    if (component == null) {
      component = DaggerMirageSignInActivityComponent.builder()
          .applicationComponent(((MirageApp) getApplication()).component())
          .activityModule(new ActivityModule(this))
          .build();
    }
    return component;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    jumpToMainActivityIfLogged();

    setContentView(R.layout.activity_signup);
    injectStuff();

    mDecorView = getWindow().getDecorView();
    setupGestureDetector();
    initBackgroundVideo();
    postLogoFadeInAnim();
    postSignInButtonFadeAnim();
    postLogoTranslateAnim();
  }

  private void injectStuff() {
    injectViews();
    component().inject(this);
  }

  @Override protected void onConnectionComplete() {
    jumpToMainActivity();
  }

  private void jumpToMainActivityIfLogged() {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    if (prefs.getBoolean("alreadyLogged", false)) {
      jumpToMainActivity();
    }
  }

  private void jumpToMainActivity() {
    Intent mainActivityIntent = new Intent(this, MainActivity.class);
    startActivity(mainActivityIntent);
    finish();
  }

  @Override public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      mDecorView.setSystemUiVisibility(
          View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
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
    mDecorView.setSystemUiVisibility(
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
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
    signInAnim.addListener(new Animator.AnimatorListener() {
      @Override public void onAnimationStart(Animator animator) {
      }

      @Override public void onAnimationEnd(Animator animator) {
        setSignInButtonListener();
      }

      @Override public void onAnimationCancel(Animator animator) {
      }

      @Override public void onAnimationRepeat(Animator animator) {
      }
    });
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
    ValueAnimator translateY =
        ObjectAnimator.ofFloat(logo, "translationY", 0, -logo.getHeight() / 1.5f);
    translateY.setDuration(SIGN_IN_FADE_DURATION);
    translateY.setInterpolator(new AccelerateDecelerateInterpolator());
    translateY.start();
  }

  private void setSignInButtonListener() {
    signInButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        playFadeOutAnim();
        attachSocialListeners();
      }
    });
  }

  private void playFadeOutAnim() {
    signInButton.animate()
        .alpha(0)
        .setDuration(FADE_OUT_SIGN_BUTTON_DURATION)
        .setInterpolator(new DecelerateInterpolator())
        .setListener(new Animator.AnimatorListener() {
          @Override public void onAnimationStart(Animator animator) {
            signInButton.setClickable(false);
          }

          @Override public void onAnimationEnd(Animator animator) {
            buttonBox.setY(signInButton.getY());
            buttonBox.show();
          }

          @Override public void onAnimationCancel(Animator animator) {

          }

          @Override public void onAnimationRepeat(Animator animator) {

          }
        })
        .start();
  }

  private void attachSocialListeners() {
    findViewById(R.id.sign_in_button).setOnClickListener(this);
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