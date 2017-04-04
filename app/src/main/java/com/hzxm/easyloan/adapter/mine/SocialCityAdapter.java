package com.hzxm.easyloan.adapter.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.mine.SocialCityModel;

import java.util.List;

import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderAdapter;

/**
 * 作者：LMZ on 2017/1/23 0023 14:49
 */
public class SocialCityAdapter extends BaseQuickAdapter<SocialCityModel.DataEntityX.DataEntity, BaseViewHolder> implements
        StickyHeaderAdapter<SocialCityAdapter.HeaderHolder> {
    private char lastChar = '\u0000';
    private int DisplayIndex = 1;
    private List<SocialCityModel.DataEntityX.DataEntity> citys;
    private Context context;

    public SocialCityAdapter(Context context, List<SocialCityModel.DataEntityX.DataEntity> data) {
        super(R.layout.iitem_rv_social, data);
        citys = data;
        this.context = context;
    }

    //
//    @Override
//    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = mInfllater.inflate(R.layout.iitem_rv_social, parent, false);
//        return new BaseViewHolder(view);
//    }
    public void notifyData(List<SocialCityModel.DataEntityX.DataEntity> citys) {
        this.citys = citys;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, SocialCityModel.DataEntityX.DataEntity dataEntity) {
        baseViewHolder.setText(R.id.tv_area, citys.get(baseViewHolder.getPosition()).getAreaName());
    }

//    @Override
//    public void onBindViewHolder(SocialCityAdapter.ViewHolder holder, int position) {
//        if (position == 0) {
//            holder.item.setText("杭州");
//        } else {
//            holder.item.setText(citys.get(position - 1).getAreaName());
//        }
//    }

//    @Override
//    public int getItemCount() {
//        return 0;
//    }

    @Override
    public long getHeaderId(int position) {
        //这里面的是如果当前position与之前position重复（内部判断）  则不显示悬浮标题栏  如果不一样则显示标题栏
        char ch = citys.get(position).pinyin.charAt(0);

        if (lastChar == '\u0000') {

            lastChar = ch;

            return DisplayIndex;
        } else {

            if (lastChar == ch) {

                return DisplayIndex;

            } else {
                lastChar = ch;
                DisplayIndex++;
                return DisplayIndex;
            }

        }
    }

    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_area_head, parent, false);
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        //从A开始
        viewholder.head.setText(citys.get(position).pinyin.charAt(0) + "");
    }


//    static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView item;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            item = (TextView) itemView;
//        }
//    }


    /**
     * 悬浮头部
     */
    static class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView head;

        public HeaderHolder(View itemView) {
            super(itemView);
            head = (TextView) itemView;
        }
    }
}
