package com.hzxm.easyloan.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.home.LoanStagingModel;

import java.util.List;

/**
 * 作者：LMZ on 2017/1/13 0013 14:54
 */
public class LoanStagingAdapter extends BaseQuickAdapter<LoanStagingModel.DataEntity, BaseViewHolder> {
    public LoanStagingAdapter(List<LoanStagingModel.DataEntity> data) {
        super(R.layout.item_rv_staging, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, LoanStagingModel.DataEntity dataEntity) {
        baseViewHolder.setText(R.id.tv_num, dataEntity.getNumber() + "")
                .setText(R.id.tv_money, "￥" + dataEntity.getRepay_money())
                .setText(R.id.tv_interest, "￥" + dataEntity.getAll_salary_money() + "");
    }

}
