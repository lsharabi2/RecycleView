package com.example.user.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class TaskListActivity extends ActionBarActivity {
    MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        adapter = new MyRecyclerAdapter(createMockList(), R.layout.item);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TaskListActivity.this, CreateTaskActivity.class);
                startActivityForResult(i, 177);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 177) {
            if (resultCode == RESULT_OK) {
                String description = data.getStringExtra("item_description");

                adapter.add(new ViewModel(4, description));
            }
        }
    }

    private List<ViewModel> createMockList() {
        List<ViewModel> mocks = new ArrayList<>();
        mocks.add(new ViewModel(1, "a"));
        mocks.add(new ViewModel(2, "b"));
        mocks.add(new ViewModel(3, "c"));
        mocks.add(new ViewModel(4, "d"));
        mocks.add(new ViewModel(5, "e"));
        return mocks;
    }
}