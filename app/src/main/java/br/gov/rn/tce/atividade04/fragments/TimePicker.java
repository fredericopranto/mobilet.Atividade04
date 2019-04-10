package br.gov.rn.tce.atividade04.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class TimePicker extends DialogFragment
implements TimePickerDialog.OnTimeSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(),this, 13,29,true);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        String msg = hourOfDay+ ":"+minute;
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
