package com.vinh.healthmanagement.Schedule;

public class ScheduleModel {
    private String Day;
    private int process;
    private int image;

    public ScheduleModel(String day, int process, int image) {
        this.Day = day;
        this.process = process;
        this.image = image;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "SchduleModel{" +
                "Day='" + Day + '\'' +
                ", process=" + process +
                ", image=" + image +
                '}';
    }
}
