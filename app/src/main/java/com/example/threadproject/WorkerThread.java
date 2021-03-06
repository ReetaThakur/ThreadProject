package com.example.threadproject;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class WorkerThread extends Thread{
    private Handler handler;
    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler=new Handler(Looper.myLooper());
        Looper.loop();

    }
    public void addTaskToMesssageQueue(Runnable task){
        if (handler!=null){
            handler.post(task);
        }

    }
}
