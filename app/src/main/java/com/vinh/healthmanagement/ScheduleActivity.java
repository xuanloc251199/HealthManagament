package com.vinh.healthmanagement;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.vinh.healthmanagement.Schedule.ScheduleAdapter;
import com.vinh.healthmanagement.Schedule.ScheduleModel;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {
    ListView listView;
    public static ArrayList<ScheduleModel> scheduleModels = new ArrayList<>();
    ScheduleAdapter scheduleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        listView = (ListView) findViewById(R.id.listViewSchedule);
        createDaySchdule();
        scheduleAdapter = new ScheduleAdapter(this, R.layout.item_schedule, scheduleModels);
        listView.setAdapter(scheduleAdapter);
    }
    void createDaySchdule(){
        scheduleModels.add(new ScheduleModel("Day 1", 80, R.drawable.dau1));
        scheduleModels.add(new ScheduleModel("Day 2", 20, R.drawable.dau2));
        scheduleModels.add(new ScheduleModel("Day 3", 10, R.drawable.dau3));
        scheduleModels.add(new ScheduleModel("Rest Day", 0, R.drawable.dau0));
        scheduleModels.add(new ScheduleModel("Day 4", 80, R.drawable.dau4));
        scheduleModels.add(new ScheduleModel("Day 5", 80, R.drawable.dau5));
        scheduleModels.add(new ScheduleModel("Day 6", 80, R.drawable.dau6));
        scheduleModels.add(new ScheduleModel("Day 7", 80, R.drawable.dau7));
        scheduleModels.add(new ScheduleModel("Rest Day", 80, R.drawable.dau0));
        scheduleModels.add(new ScheduleModel("Day 8", 80, R.drawable.dau8));
        scheduleModels.add(new ScheduleModel("Day 9", 80, R.drawable.dau9));
        scheduleModels.add(new ScheduleModel("Day 10", 80, R.drawable.dau10));
        scheduleModels.add(new ScheduleModel("Day 11", 80, R.drawable.dau11));
        scheduleModels.add(new ScheduleModel("Rest Day", 80, R.drawable.dau0));
        scheduleModels.add(new ScheduleModel("Day 12", 80, R.drawable.dau12));
    }
}