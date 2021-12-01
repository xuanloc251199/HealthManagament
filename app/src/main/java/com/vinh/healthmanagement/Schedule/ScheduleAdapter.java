package com.vinh.healthmanagement.Schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vinh.healthmanagement.R;

import java.util.List;

public class ScheduleAdapter extends BaseAdapter {
    private final Context context;
    private final int layout;
    private final List<ScheduleModel> models;

    public ScheduleAdapter(Context context, int layout, List<ScheduleModel> personList) {
        this.context = context;
        this.layout = layout;
        this.models = personList;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        TextView textViewName = (TextView) convertView.findViewById(R.id.txtName);
        TextView textViewProcess = (TextView) convertView.findViewById(R.id.txtProcess);
        ScheduleModel scheduleModel = models.get(position);
        imageView.setImageResource(scheduleModel.getImage());
        textViewName.setText(scheduleModel.getDay());
        textViewProcess.setText(scheduleModel.getProcess()+" %");
        return convertView;
    }
}
