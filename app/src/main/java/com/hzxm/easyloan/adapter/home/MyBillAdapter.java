package com.hzxm.easyloan.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.home.MyBillModel;
import com.lmz.baselibrary.util.StringUtils;

import java.util.List;

/**
 * 作者：LMZ on 2017/1/16 0016 16:08
 */
public class MyBillAdapter extends BaseQuickAdapter<MyBillModel.DataEntity, BaseViewHolder> {
    public MyBillAdapter(List<MyBillModel.DataEntity> data) {
        super(R.layout.item_rv_bill, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MyBillModel.DataEntity dataEntity) {
        baseViewHolder.setText(R.id.tv_data, StringUtils.timeStamp2Date(dataEntity.getCreate_time(), "MM/dd HH:mm")
                + " " + StringUtils.getWeek(dataEntity.getCreate_time()))
                .setText(R.id.tv_money, "￥" + dataEntity.getRepay_money());
        if ("1".equals(dataEntity.getReturn_type())) {//分期借款
            baseViewHolder.setText(R.id.tv_loan_type, "分期借款");
        } else {
            baseViewHolder.setText(R.id.tv_loan_type, "正常借款");
        }
    }

}
