package com.jorgecastilloprz.mirage;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.InjectView;
import com.jorgecastilloprz.mirage.components.TextureVideoView;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SignUpActivity extends BaseActivity {

  @InjectView(R.id.textureView) TextureVideoView textureView;
  @InjectView(R.id.root) FrameLayout root;

  private MediaPlayer mMediaPlayer;
  private View mDecorView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);
    injectViews();
    mDecorView = getWindow().getDecorView();
    setupGestureDetector();
    initBackgroundVideo();
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

  @Override protected void onDestroy() {
    super.onDestroy();
    if (mMediaPlayer != null) {
      mMediaPlayer.stop();
      mMediaPlayer.release();
      mMediaPlayer = null;
    }
  }
}