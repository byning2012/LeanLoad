package com.hzxm.easyloan.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.home.StagingDetailModel;

import java.util.List;

/**
 * 作者：LMZ on 2017/1/13 0013 14:54
 */
public class StagingAdapter extends BaseQuickAdapter<StagingDetailModel, BaseViewHolder> {
    public StagingAdapter(List<StagingDetailModel> data) {
        super(R.layout.item_rv_staging, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, StagingDetailModel stagingDetailModel) {
        baseViewHolder.setText(R.id.tv_num, stagingDetailModel.getId()+1+"")
                .setText(R.id.tv_money, "￥"+stagingDetailModel.getPeriodsMoney() )
                .setText(R.id.tv_interest, "￥"+stagingDetailModel.getInterestMoney() + "");
    }
}
