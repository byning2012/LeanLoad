package com.hzxm.easyloan.adapter.chamberlain;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.chamberlain.CommonProblemModel;
import com.hzxm.easyloan.widget.HorizontalDecoration;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.glide.GliderHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：LMZ on 2016/12/29 0029 14:20
 */
public class CommonProblemAdapte extends RecyclerView.Adapter<CommonProblemAdapte.ItemViewHolder> {
    private List<CommonProblemModel.DataEntity> list;
    private Context context;
    private boolean isClick = false;

    public CommonProblemAdapte(Context context, List<CommonProblemModel.DataEntity> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_problem, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        LogUtil.e(list.get(position).getName());
        holder.mProblemTv.setText(list.get(position).getName());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.addItemDecoration(new HorizontalDecoration(context, LinearLayoutManager.VERTICAL));
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setTag(position);
        GliderHelper.loadImage(list.get(position).getImg(), holder.mImageView, null);
        //如果子Rv的条目大于三条 那么直显示3条
        if (list.get(position).getContent().size() <= 3) {
            //不够三条 就添加
            List<CommonProblemModel.DataEntity.ContentEntity> mNewlist = new ArrayList<>();
            for (int i = 0; i < list.get(position).getContent().size(); i++) {
                mNewlist.add(list.get(position).getContent().get(i));
            }
            for (int i = mNewlist.size(); i < 3; i++) {
                mNewlist.add(new CommonProblemModel.DataEntity.ContentEntity("", "", ""));
            }
            CommonProItemAdapter commonProItemAdapter = new CommonProItemAdapter(context,mNewlist);
            holder.recyclerView.setAdapter(commonProItemAdapter);
        } else {
            List<CommonProblemModel.DataEntity.ContentEntity> mNewlist = new ArrayList<>();
            mNewlist.add(list.get(position).getContent().get(0));
            mNewlist.add(list.get(position).getContent().get(1));
            mNewlist.add(list.get(position).getContent().get(2));
            CommonProItemAdapter commonProItemAdapter = new CommonProItemAdapter(context, mNewlist);
            holder.recyclerView.setAdapter(commonProItemAdapter);
        }
        holder.mProblemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get((Integer) holder.recyclerView.getTag()).getContent().size() <= 3) {
                    return;
                }
                if (isClick) { //如果展开状态
                    List<CommonProblemModel.DataEntity.ContentEntity> mNewlist = new ArrayList<>();
                    mNewlist.add(list.get((Integer) holder.recyclerView.getTag()).getContent().get(0));
                    mNewlist.add(list.get((Integer) holder.recyclerView.getTag()).getContent().get(1));
                    mNewlist.add(list.get((Integer) holder.recyclerView.getTag()).getContent().get(2));
                    CommonProItemAdapter commonProItemAdapter = new CommonProItemAdapter(context, mNewlist);
                    holder.recyclerView.setAdapter(commonProItemAdapter);
                    isClick = false;
                } else {
                    CommonProItemAdapter commonProItemAdapter = new CommonProItemAdapter(context, list.get((Integer) holder.recyclerView.getTag()).getContent());
                    holder.recyclerView.setAdapter(commonProItemAdapter);
                    isClick = true;
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private ImageView mImageView;
        private TextView mProblemTv;
        private LinearLayout mProblemLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mProblemLayout = (LinearLayout) itemView.findViewById(R.id.ll_problem);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.item_recycle);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_logo);
            mProblemTv = (TextView) itemView.findViewById(R.id.tv_problem);
        }
    }

}

