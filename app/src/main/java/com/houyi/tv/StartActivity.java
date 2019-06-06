package com.houyi.tv;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ppm.ppcomon.base.view.activity.BaseActivity;
import com.ppm.ppcomon.widget.CommonStatusBar;

import butterknife.BindView;

public class StartActivity extends BaseActivity {

    @BindView(R.id.img_start)
    SimpleDraweeView rrdDraweeView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        super.initView();
        setSwipeBackEnable(false);
        DraweeController mController = Fresco.newDraweeControllerBuilder()
                .setUri(getUriFromDrawableRes(StartActivity.this, R.drawable.start))//设置uri
                .setAutoPlayAnimations(true)
                .build();
        rrdDraweeView.setController(mController);

        Handler handler = new Handler();
        handler.postDelayed(this::startMain, 1500);
    }

    private void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public Uri getUriFromDrawableRes(Context context, int id) {
        Resources resources = context.getResources();
        String path = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + resources.getResourcePackageName(id) + "/"
                + resources.getResourceTypeName(id) + "/"
                + resources.getResourceEntryName(id);
        return Uri.parse(path);
    }

    @Override
    protected void setStatusBar() {
        CommonStatusBar.setStatusBarByTransparent(this);
    }
}
