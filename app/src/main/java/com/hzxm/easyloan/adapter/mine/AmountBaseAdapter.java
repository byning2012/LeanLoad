package com.hzxm.easyloan.adapter.mine;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.mine.AmountCreateModel;

import java.util.List;

/**
 * 作者：LMZ on 2016/12/29 0029 18:07
 */
public class AmountBaseAdapter extends BaseQuickAdapter<AmountCreateModel.DataEntity.BaseMenuEntity, BaseViewHolder> {
    public AmountBaseAdapter(List<AmountCreateModel.DataEntity.BaseMenuEntity> data) {
        super(R.layout.item_rv_base_amount, data);
    }



    @Override
    protected void convert(BaseViewHolder baseViewHolder, AmountCreateModel.DataEntity.BaseMenuEntity baceMenuEntity) {
        baseViewHolder.setText(R.id.tv_type, baceMenuEntity.getRemark());
        if (baceMenuEntity.getUp_type() == 0) {
            baseViewHolder.setText(R.id.tv_name, mContext.getResources().getString(R.string.not_verified));
        } else if (baceMenuEntity.getUp_type() == 1) {
            baseViewHolder.setText(R.id.tv_name, mContext.getResources().getString(R.string.already_verified));
        } else if (baceMenuEntity.getUp_type() == 2) {
            baseViewHolder.setText(R.id.tv_name, mContext.getResources().getString(R.string.verifieding));
        }
    }
}
