package com.example.lab_3_s1listview;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvCourses;
    private Button btnCreate;
    private Button btnUpdate;
    private EditText etCourse;
    private ArrayList<String> arrCourses;
    private int indexCourse = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        arrCourses = new ArrayList<>();
        arrCourses.add("Android");
        arrCourses.add("PHP");
        arrCourses.add("iOS");
        arrCourses.add("Unity");
        arrCourses.add("ReactJS");

        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrCourses);
        lvCourses.setAdapter(adapter);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course = etCourse.getText().toString();
                arrCourses.add(course);
                Toast.makeText(MainActivity.this, "Create " + course + " successful!", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        });

        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                etCourse.setText(arrCourses.get(position));
                indexCourse = position;
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course = etCourse.getText().toString();
                arrCourses.set(indexCourse, course);
                Toast.makeText(MainActivity.this, "Update to " + course + " successful!", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        });

        lvCourses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Delete " + arrCourses.get(position) + " successful!", Toast.LENGTH_SHORT).show();
                arrCourses.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    private void mapping() {
        lvCourses = (ListView) findViewById(R.id.listview);
        btnCreate = (Button) findViewById(R.id.buttonadd);
        btnUpdate = (Button) findViewById(R.id.buttonupdate);
        etCourse = (EditText) findViewById(R.id.editmonhoc);
    }
}