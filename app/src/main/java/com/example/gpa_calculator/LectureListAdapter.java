package com.example.gpa_calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gpa_calculator.model_package.Lecture;

import java.util.ArrayList;
import java.util.List;

public class LectureListAdapter extends ArrayAdapter<Lecture> {
    private Context context;
    int mResource;

    public LectureListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Lecture> objects) {
        super(context, resource, objects);
        this.context = context;
        mResource = resource;
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String className = getItem(position).getName();
        double classGPA = getItem(position).getGpa();
        int classWeight = getItem(position).getWeight();

        Lecture lecture = new Lecture(className, classWeight, classGPA);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.className);
        TextView tvGPA = (TextView) convertView.findViewById(R.id.classGPA);

        tvName.setText(className);
        tvGPA.setText(String.format("%.2f",classGPA));

        return convertView;

    }
}
