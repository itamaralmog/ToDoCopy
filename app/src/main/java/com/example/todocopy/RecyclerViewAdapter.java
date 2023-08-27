package com.example.todocopy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class RecyclerViewAdapter extends RecyclerView.Adapter<TextItemViewHolder> {

    String[] items;
    Vector<String> vec = new Vector<String>();

    public RecyclerViewAdapter(Vector<String> vec)
    {this.vec = vec;}
    public RecyclerViewAdapter()
    {
        this.vec = new Vector<String>();
        this.items = null;
    }
    public RecyclerViewAdapter(String[] items)
    {this.items = items;}
    @NonNull
    @Override
    public TextItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_list_item,parent,false);

        return new TextItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextItemViewHolder holder, int position) {
        holder.bind(items[position]);
//        holder.bind(vec.elementAt(position));
    }

    @Override
    public int getItemCount() {
        if(items == null){
            return 0;
        }
        return items.length;
    }

    @Override
    public long getItemId(int position){
        return position;
    }
}
