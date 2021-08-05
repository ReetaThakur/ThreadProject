package com.example.threadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button task1;
    private Button task2;
    private static final String Tag=MainActivity.class.getName();
    private WorkerThread workerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerThread=new WorkerThread();
        workerThread.start();
       task1=findViewById(R.id.btnone);
       task2=findViewById(R.id.btntwo);
       task1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               workerThread.addTaskToMesssageQueue(taskone);

           }
       });
       task2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               workerThread.addTaskToMesssageQueue(taskTwo);

           }
       });

    }
    private Runnable taskone=new Runnable() {
        @Override
        public void run() {
            Log.d(Tag,"Task one"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable taskTwo=new Runnable() {
        @Override
        public void run() {
            Log.d(Tag,"Task two"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}