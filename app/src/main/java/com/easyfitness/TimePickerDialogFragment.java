package com.easyfitness;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.widget.TimePicker;
import android.app.TimePickerDialog;

public class TimePickerDialogFragment extends DialogFragment {

    private final int Hours = 0;
    private final int Minutes = 0;
    private final int Seconds = 0;  // You may ignore seconds if not needed
    private TimePickerDialog.OnTimeSetListener onTimeSetListener;

    static public TimePickerDialogFragment newInstance(TimePickerDialog.OnTimeSetListener onTimeSetListener, int hour, int min, int sec) {
        TimePickerDialogFragment pickerFragment = new TimePickerDialogFragment();
        pickerFragment.setOnTimeSetListener(onTimeSetListener);

        // Pass the date in a bundle
        Bundle bundle = new Bundle();
        bundle.putInt("HOUR", hour);
        bundle.putInt("MINUTE", min);
        bundle.putInt("SECOND", sec);
        pickerFragment.setArguments(bundle);
        return pickerFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int hour = bundle.getInt("HOUR");
        int min = bundle.getInt("MINUTE");

        // Create and return the native TimePickerDialog
        return new TimePickerDialog(
                getActivity(),
                onTimeSetListener,
                hour,  // Initial hour
                min,   // Initial minute
                true    // 24-hour format (set false for 12-hour format)
        );
    }

    private void setOnTimeSetListener(TimePickerDialog.OnTimeSetListener listener) {
        this.onTimeSetListener = listener;
    }
}
