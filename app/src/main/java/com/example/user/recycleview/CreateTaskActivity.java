package com.example.user.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateTaskActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        Button btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateTaskActivity.this, TaskListActivity.class);
                EditText textDesc = (EditText) findViewById(R.id.textDesc);

                i.putExtra("item_description", textDesc.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}

