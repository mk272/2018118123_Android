package com.example.final_task;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class MyAdapter<T> extends BaseAdapter {

        private Context mContext;
        private ArrayList<T> mData;
        private int mLayoutRes;

        public MyAdapter() {
        }

        public MyAdapter(ArrayList<T> mData, int mLayoutRes) {
            this.mData = mData; //存放传进来自定义类（memo）的列表
            this.mLayoutRes = mLayoutRes;//ListView的每一行的布局的xml文件
        }

        @Override
        public int getCount() {
            return mData != null ? mData.size() : 0;
        }

        @Override
        public T getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
            //return mData.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=ViewHolder.bind(parent.getContext(),convertView,parent,mLayoutRes,position);
            bindView(holder,getItem(position));
            return holder.getItemView();

        }
     public abstract void bindView(ViewHolder holder, T obj);

        //添加一个元素
        public void add(T data) {
            if (mData == null) {
                mData = new ArrayList<>();
            }
            mData.add(data);
            notifyDataSetChanged();
        }

        //往特定位置，添加一个元素
        public void add(int position,T data){
            if (mData == null) {
                mData = new ArrayList<>();
            }
            mData.add(position, data);
            notifyDataSetChanged();
        }

        public void remove(T data) {
            if(mData != null) {
                mData.remove(data);
            }
            notifyDataSetChanged();
        }

        public void remove(int position) {
            if(mData != null) {
                mData.remove(position);
            }
            notifyDataSetChanged();
        }

        public void clear() {
            if(mData != null) {
                mData.clear();
            }
            notifyDataSetChanged();
        }

        //12.8 add
    //public abstract void setDropDownViewResource(int simple_spinner_dropdown_item);

    public static  class ViewHolder{
            private SparseArray<View> mViews; //存储ListView的 item中的View
            private View item; //存放convertView
            private int position; //游标
            private Context context; //Context上下文

            private ViewHolder(Context context,ViewGroup parent ,int layoutRes){
                mViews=new SparseArray<>();
                this.context=context;
                View converView=LayoutInflater.from(context).inflate(layoutRes,parent,false);
                converView.setTag(this);//this含义未知
                item=converView;
            }
            TextView itme_title;
            TextView itme_content;

            public static ViewHolder bind(Context context, View convertView, ViewGroup parent,
                                          int layoutRes, int position) {
                ViewHolder holder;
                if(convertView == null) {
                    holder = new ViewHolder(context, parent, layoutRes);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                    holder.item = convertView;
                }
                holder.position = position;
                return holder;
            }
            @SuppressWarnings("unchecked")
            public <T extends View> T getView(int id) {
                T t = (T) mViews.get(id);
                if (t == null) {
                    t = (T) item.findViewById(id);
                    mViews.put(id, t);
                }
                return t;
            }

            /**
             * 获取当前条目
             */
            public View getItemView() {
                return item;
            }

            /**
             * 获取条目位置
             */
            public int getItemPosition() {
                return position;
            }

            /**
             * 设置文字
             */
            public ViewHolder setText(int id, CharSequence text) {
                View view = getView(id);
                if (view instanceof TextView) {
                    ((TextView) view).setText(text);
                }
                return this;
            }
            public ViewHolder setTextColor(int id, CharSequence text) {
                View view = getView(id);
                if (view instanceof TextView) {
                    ((TextView) view).setTextColor(Color.rgb(255, 255, 255));
                }
                return this;
            }

            public ViewHolder setTextPosition(int id, CharSequence text) {
                View view = getView(id);
                    ((TextView) view).setGravity(Gravity.CENTER);

                return this;
            }
            /**
             * 设置标签
             */
            public ViewHolder setTag(int id, Object obj) {
                getView(id).setTag(obj);
                return this;
            }
            /**
            * 设置图片
            */
            public ViewHolder setImageResource(int id,int drawableRes){
                View view =getView(id);
                if(view instanceof ImageView){
                    ((ImageView)view).setImageResource(drawableRes);
                }else{
                    view.setBackgroundResource(drawableRes);
                }
                return this;
            }

            //


        }


}
