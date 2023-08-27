package com.example.todocopy;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TextItemViewHolder extends RecyclerView.ViewHolder{
    private TextView textView;

    public TextItemViewHolder(View itemView){
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.list_item1);

    }
    public void bind(String text) {
        textView.setText(text);
    }
}
