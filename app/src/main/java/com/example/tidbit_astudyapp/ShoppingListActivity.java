package com.example.tidbit_astudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tidbit_astudyapp.Adapter.ToDoAdapter;
import com.example.tidbit_astudyapp.Model.ToDoModel;
import com.example.tidbit_astudyapp.Utils.DatabaseHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingListActivity extends AppCompatActivity implements DialogCloseListener{

    // Used https://www.youtube.com/playlist?list=PLzEWSvaHx_Z2MeyGNQeUCEktmnJBp8136 tutorial for tasks

    private RecyclerView tasksRecyclerView;
    private ToDoAdapter tasksAdapter;
    private FloatingActionButton fab;

    private List<ToDoModel> todoList;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        getSupportActionBar().hide();

        db = new DatabaseHandler(this);
        db.openDatabase();

        todoList = new ArrayList<>();

        tasksRecyclerView = findViewById(R.id.todoRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdapter(db, this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        fab = findViewById(R.id.fab);
        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecyclerItemTouchHelper(tasksAdapter));
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView);
        todoList = db.getAllTasks();
        Collections.reverse(todoList);
        tasksAdapter.setTasks(todoList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Example: ", "Add todo button clicked");
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });
    }

    @Override
    public void handleDialogClose(DialogInterface dialogInterface) {
        todoList = db.getAllTasks();
        Collections.reverse(todoList);
        tasksAdapter.setTasks(todoList);
        tasksAdapter.notifyDataSetChanged();
    }

    public void onBackPressed(View view) {
        Log.d("Example: ", "Clicked back");
        finish();
    }
}