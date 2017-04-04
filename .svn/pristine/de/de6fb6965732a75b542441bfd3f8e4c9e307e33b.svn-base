package com.lmz.baselibrary.widget.springview.container;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lmz.baselibrary.R;


/**
 * 作者：LMZ on 2017/1/4 0004 10:22
 */
public class LoanHeader extends BaseHeader {
    private ImageView spaceshipImage;
    private static Animation mAnimation;
    private RelativeLayout mHeaderView;

    public LoanHeader() {
        mAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mAnimation.setFillAfter(true);
        mAnimation.setDuration(800);
        mAnimation.setRepeatCount(Integer.MAX_VALUE);
        mAnimation.setInterpolator(new LinearInterpolator());
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.loading_header, viewGroup, true);
        spaceshipImage = (ImageView) view.findViewById(R.id.iv_loading);
        mHeaderView = (RelativeLayout) view.findViewById(R.id.rl_loan_head);
        mHeaderView.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onPreDrag(View rootView) {
    }

//    @Override
//    public int getDragLimitHeight(View rootView) {
//        return rootView.getMeasuredHeight();
//    }

    @Override
    public void onDropAnim(View rootView, int dy) {
        float rota = 360 * dy / rootView.getMeasuredHeight();
        spaceshipImage.setRotation(rota);
    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
//        spaceshipImage.startAnimation(mAnimation);
    }

    @Override
    public void onStartAnim() {
        mHeaderView.setVisibility(View.VISIBLE);
        spaceshipImage.startAnimation(mAnimation);
    }

    @Override
    public void onFinishAnim() {
        mHeaderView.setVisibility(View.GONE);
        spaceshipImage.clearAnimation();
    }
}
