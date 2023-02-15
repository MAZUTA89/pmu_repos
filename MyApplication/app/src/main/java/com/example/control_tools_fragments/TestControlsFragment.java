package com.example.control_tools_fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.LibraryFragment;
import com.example.myapplication.R;

import java.util.ArrayList;

public class TestControlsFragment extends LibraryFragment {
    CheckBox first;
    CheckBox second;
    Button button_CheckBox;

    RadioGroup radio_Group;

    RadioButton usa;
    RadioButton kanada;

    TextView selection;

    DatePicker datePicker;
    TextView date_selection;

    TimePicker timePicker;

    TextView time_selection;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tools_fragment_layout, container, false);
        first = view.findViewById(R.id.checkBox_first);
        second = view.findViewById(R.id.checkBox_second);
        button_CheckBox = view.findViewById(R.id.button_CheckBoxes);
        radio_Group = view.findViewById(R.id.radio_group_control);
        usa = view.findViewById(R.id.radioButton_first);
        kanada = view.findViewById(R.id.radioButton_second);
        selection = view.findViewById(R.id.text_selection);
        datePicker = view.findViewById(R.id.datePicker);
        date_selection = view.findViewById(R.id.text_date_selection);
        timePicker = view.findViewById(R.id.timePicker);
        time_selection = view.findViewById(R.id.text_time_selection);


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                time_selection.setText("Time :" + i + "-" + i1);
            }
        });


        datePicker.init(2021, 1, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                date_selection.setText("Date: " + datePicker.getDayOfMonth() + "." +
                        datePicker.getMonth() + "." + datePicker.getYear());
            }
        });

        radio_Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.radioButton_first:
                    {
                        selection.setText("USA");
                        break;
                    }
                    case R.id.radioButton_second:
                        selection.setText("Kanada");
                        break;
                }
            }
        });

        button_CheckBox.setOnClickListener(onCheckButton);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public String get_fragmentName() {
        return "Test controls fragment";
    }

    @Override
    public void onAttaching() {

    }

    View.OnClickListener onCheckButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String result = " ";
            ArrayList<String> list = new ArrayList<>();
            if(first.isChecked())
            {
                list.add("First box");
            }
            else
                list.add("not a first box");

            if(second.isChecked())
            {
                list.add("Second box");
            }
            else
            {
                list.add("not a second box");
            }

            for (String str :
                    list) {
                result += str + "\n";
            }
            Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
        }
    };

}
