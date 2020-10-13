package com.example.recyclerviewtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitNo;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
            fruitNo =(TextView) view.findViewById(R.id.fruit_no);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        /**
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();

            }
        });
         **/
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final int position = holder.getAdapterPosition();
                //final int position = holder.getLayoutPosition();
                final Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "你点击了文字 " + fruit.getName(), Toast.LENGTH_SHORT).show();

                final EditText editText = new EditText(v.getContext());
                editText.setText(fruit.getName());
                new AlertDialog.Builder(v.getContext()).setTitle("请修改名称")

                        .setView(editText)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //按下确定键后的事件
                                Fruit fruit2 = mFruitList.get(mFruitList.indexOf(fruit));
                                fruit2.setName(editText.getText().toString());
                                mFruitList.set(mFruitList.indexOf(fruit),fruit2);
                                Toast.makeText(v.getContext(),"成功修改为："+editText.getText().toString(),Toast.LENGTH_SHORT).show();
                                //刷新View显示
                                notifyItemChanged(position);
                            }
                        }).setNegativeButton("取消",null).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.fruitNo.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}