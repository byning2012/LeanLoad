package com.hzxm.easyloan.adapter.mine;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.mine.RepaymentListModel;
import com.lmz.baselibrary.util.StringUtils;

import java.util.List;

/**
 * 作者：LMZ on 2017/1/16 0016 16:08
 */
public class RepaymentListAdapter extends BaseQuickAdapter<RepaymentListModel.DataEntity, BaseViewHolder> {
    public RepaymentListAdapter(List<RepaymentListModel.DataEntity> data) {
        super(R.layout.item_rv_bill, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RepaymentListModel.DataEntity dataEntity) {
        baseViewHolder.setText(R.id.tv_data, StringUtils.timeStamp2Date(dataEntity.getReturn_time(), "MM/dd HH:mm")
                + " " + StringUtils.getWeek(dataEntity.getReturn_time()))
                .setText(R.id.tv_money, "￥" + dataEntity.getRepay_money());

        if ("1".equals(dataEntity.getReturn_type())) {//分期借款
            baseViewHolder.setText(R.id.tv_loan_type, "分期还款");
        } else {
            baseViewHolder.setText(R.id.tv_loan_type, "正常还款");
        }
    }

}
