package com.example.todocopy;
//package com.journaldev.tablayoutviewpager;


//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;

import static android.content.Intent.*;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Vector;

public class FragmentAll extends Fragment {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter = new RecyclerViewAdapter();
    ListView list;

    public FragmentAll(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle dataOfTask = getActivity().getIntent().getExtras();
        String dataInTask ="";
        if (dataOfTask != null) {
            dataInTask = dataOfTask.getString("DataOfTask");
        }
        Log.d("$$$$$",dataInTask);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        return rootView;





    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Vector<String> vec = new Vector<String>();
//        String strtext = getArguments().getString("message");
//        TaskData taskData = new TaskData();
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
//            taskData = (TaskData) getArguments().getSerializable("massageObj",taskData);
//        }
//        vec.add(task);
//        for(int i = 0; i<this.adapter.vec.size(); ++i){
//            vec.add(this.adapter.vec.get(i));
//        }
        this.adapter.vec = vec;
        String[] items = getResources().getStringArray(R.array.ALL);
        for(int i = 0; i<items.length; ++i){
            vec.add(items[i]);
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(vec);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
