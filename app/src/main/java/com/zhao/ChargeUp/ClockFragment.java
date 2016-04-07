package com.zhao.ChargeUp;


import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.zhao.ChargeUp.unit.Unit;

import java.util.Date;


public class ClockFragment extends Fragment {
    private TimePicker timePicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_clock, container, false);
        timePicker = (TimePicker) view.findViewById(R.id.timePicker);
        timePicker.setIs24HourView(false);
        Date date = AddRecordFragment.getDate();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        timePicker.setCurrentHour(hours);
        timePicker.setCurrentMinute(minutes);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Unit.TAG("onTimeChanged++++++++++++");
                hourOfDay = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();
                AddRecordFragment.setTime(view.getCurrentHour(), view.getCurrentMinute());
            }
        });
        return view;
    }

}
