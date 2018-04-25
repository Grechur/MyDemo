package com.clock.zc.mydemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clock.zc.mydemo.R;

import java.util.ArrayList;

/**
 * Created by Zc on 2017/10/23.
 */

public class ZoomRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;
    private ArrayList<String> mDatas;
    private Context context;
    private OnItemClickLitener mOnItemClickLitener;
    private View mHeadView;
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    public ZoomRecycleAdapter(Context context, ArrayList<String> datas)
    {
        this.context = context;
        this.mDatas = datas;

    }
    public ZoomRecycleAdapter(Context context, ArrayList<String> datas,View headView)
    {
        this.context = context;
        this.mDatas = datas;
        this.mHeadView = headView;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if(viewType == VIEW_TYPE_ITEM){
            RecyclerView.ViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_layout, parent,
                    false));
            return holder;
        }else{
            return new HeaderViewHolder(mHeadView);
        }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position)
    {
        int pos = 0;
        if(mHeadView == null) pos = position;
        else pos = position-1;
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder)holder).tv.setText(mDatas.get(pos));
        }
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    removeData(pos);
                    return false;
                }
            });
        }
    }
    public void removeData(int position)
    {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeadView == null){
            return VIEW_TYPE_ITEM;
        }else{
            return (position == 0) ? VIEW_TYPE_HEADER : VIEW_TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount()
    {
        if(mHeadView!=null) return mDatas.size()+1;
        else return mDatas.size();
    }
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.text);
        }
    }
}
