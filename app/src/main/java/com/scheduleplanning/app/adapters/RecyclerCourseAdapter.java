package com.scheduleplanning.app.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scheduleplanning.model.Course;
import com.scheduleplanning.scheduleplanning.R;

import java.util.List;

public class RecyclerCourseAdapter extends RecyclerView.Adapter<RecyclerCourseAdapter.CourseViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Course course);
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView courseName;
        TextView instructor;

        CourseViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.course_item_cv);
            courseName = itemView.findViewById(R.id.courseName_textView);
            instructor = itemView.findViewById(R.id.instructor_textView);
        }
    }

    List<Course> courses;
    private final OnItemClickListener listener;

    public RecyclerCourseAdapter(List<Course> courses, OnItemClickListener listener) {
        this.courses = courses;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_course_recycler_item, viewGroup, false);
        return new RecyclerCourseAdapter.CourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder courseViewHolder, int i) {
        final Course course = courses.get(i);
        courseViewHolder.courseName.setText(course.getTitle());
        courseViewHolder.instructor.setText(course.getInstructors().get(0).getName());
        courseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(course);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
