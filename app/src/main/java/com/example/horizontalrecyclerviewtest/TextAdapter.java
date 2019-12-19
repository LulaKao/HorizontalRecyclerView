package com.example.horizontalrecyclerviewtest;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder> {
    private LinkedList<String> list;
    private TextView textView;
    private int oldPosition = 0;

    public TextAdapter(LinkedList<String> list) {
        this.list = list;
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
        // 如果 list == null 為 true 的話就執行（返回）0，false 的話就執行（返回）list.size()
    }

    @Override
    public void onBindViewHolder(@NonNull final TextViewHolder holder, final int position) {
        // 載入 list 的資料
        //holder.textView.setText(list.get(position));
        holder.textView.setText(list.get(position) + "");
        // 預設一載入時會在第 1 筆
        if (position == oldPosition) {
            textView = holder.textView;
            holder.textView.setTextColor(Color.parseColor("#000000")); // 變黑色
            holder.textView.setTypeface(null, Typeface.BOLD); // 變粗體字
        } else {
            holder.textView.setTextColor(Color.parseColor("#444444")); // 灰色
            holder.textView.setTypeface(null,Typeface.NORMAL); // 正常字型，未加粗
        }
        // 設定點擊時的事件
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView != null) {
                    textView.setTextColor(Color.parseColor("#444444")); // 灰色
                    textView.setTypeface(null,Typeface.NORMAL); // 正常字型，未加粗
                }
                holder.textView.setTextColor(Color.parseColor("#000000")); // 變黑色
                holder.textView.setTypeface(null, Typeface.BOLD); // 變粗體字
                Toast.makeText(view.getContext(),"你选择了："+list.get(position),Toast.LENGTH_SHORT).show();
                textView = holder.textView;
                oldPosition = position;
            }
        });
    }
}
