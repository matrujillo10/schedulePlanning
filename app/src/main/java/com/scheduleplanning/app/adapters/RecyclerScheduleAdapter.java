package com.scheduleplanning.app.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scheduleplanning.proxy.ScheduleProxy;
import com.scheduleplanning.scheduleplanning.R;

import java.util.List;

public class RecyclerScheduleAdapter extends RecyclerView.Adapter<RecyclerScheduleAdapter.ScheduleViewHolder> {

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView hours;
        TextView courseName;
        TextView instructor;
        TextView classroom;

        ScheduleViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.schedule_item_cv);
            hours = itemView.findViewById(R.id.day_hour_textView);
            courseName = itemView.findViewById(R.id.schedule_courseName_textView);
            classroom = itemView.findViewById(R.id.classroom_textView);
            instructor = itemView.findViewById(R.id.schedule_instructor_textView);
        }
    }

    List<ScheduleProxy> schedules;

    public RecyclerScheduleAdapter(List<ScheduleProxy> schedules) {
        this.schedules = schedules;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_schedule_recycler_item, viewGroup, false);
        return new ScheduleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder scheduleViewHolder, int i) {
        ScheduleProxy schedule = schedules.get(i);
        scheduleViewHolder.hours.setText(new StringBuilder()
                .append(schedule.getSchedule().getTimeIni())
                .append(" - ").append(schedule.getSchedule().getTimeFin())
                .append(" | ")
                .append(schedule.getSchedule().getL() != null ? "Lunes " : "")
                .append(schedule.getSchedule().getM() != null ? "Martes " : "")
                .append(schedule.getSchedule().getI() != null ? "Miercoles " : "")
                .append(schedule.getSchedule().getJ() != null ? "Jueves " : "")
                .append(schedule.getSchedule().getV() != null ? "Viernes " : "")
                .append(schedule.getSchedule().getS() != null ? "Sábado " : "")
                .append(schedule.getSchedule().getD() != null ? "Domingo" : "")
                .toString());
        scheduleViewHolder.courseName.setText(schedule.getName());
        scheduleViewHolder.classroom.setText(schedule.getSchedule().getClassroom());
        scheduleViewHolder.instructor.setText(schedule.getInstructor());
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }
}
