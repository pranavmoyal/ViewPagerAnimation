package com.example.baltech.viewpageranimation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{

    private ImageButton btnNext, btnFinish;
    private ViewPager intro_images;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private SlidingImageAdapter mAdapter;

    ZoomOutPageTransformer ZoomOutPageTransformer;
    DepthPageTransformer depthPageTransformer;
    CubeInTransformer cubeInTransformer;
    CubeOutTransformer cubeOutTransformer;
    FlipHorizontalTransformer flipHorizontalTransformer;

    private int[] mImageResources = {
            R.drawable.eagle,
            R.drawable.hollywood,
            R.drawable.movie,
            R.drawable.images,
            R.drawable.images4,
            R.drawable.images5
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle_zoom = getIntent().getExtras();
        assert bundle_zoom != null;
        final String zoom = bundle_zoom.getString("zoom");

        intro_images = (ViewPager) findViewById(R.id.pager_introduction);
        btnNext = (ImageButton) findViewById(R.id.btn_next);
        btnFinish = (ImageButton) findViewById(R.id.btn_finish);

        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        btnNext.setOnClickListener(this);
        btnFinish.setOnClickListener(this);

        mAdapter = new SlidingImageAdapter(MainActivity.this, mImageResources);
        intro_images.setAdapter(mAdapter);
        intro_images.setCurrentItem(0);
        intro_images.setOnPageChangeListener(this);
        setUiPageViewController();

        intro_images.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                assert zoom != null;
                if (zoom.equals("zoom")) {
                    ZoomOutPageTransformer = new ZoomOutPageTransformer();
                    ZoomOutPageTransformer.transformPage(page, position);
                }

                if (zoom.equals("depth")){
                        depthPageTransformer=new DepthPageTransformer();
                        depthPageTransformer.transformPage(page,position);
                    }

                if (zoom.equals("slide")){
                    cubeInTransformer=new CubeInTransformer();
                    cubeInTransformer.transformPage(page,position);

                }

                if (zoom.equals("cubeout")){
                    cubeOutTransformer=new CubeOutTransformer();
                    cubeOutTransformer.transformPage(page,position);

                }

                if (zoom.equals("fliphorizontal")){
                    flipHorizontalTransformer=new FlipHorizontalTransformer();
                    flipHorizontalTransformer.transformPage(page,position);

                }
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == dotsCount) {
            btnNext.setVisibility(View.GONE);
            btnFinish.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnFinish.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {

    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }
}
