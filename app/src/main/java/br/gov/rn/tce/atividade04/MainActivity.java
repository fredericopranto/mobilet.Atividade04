package br.gov.rn.tce.atividade04;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import br.gov.rn.tce.atividade04.dialogs.ExitDialog;
import br.gov.rn.tce.atividade04.fragments.DatePicker;
import br.gov.rn.tce.atividade04.fragments.TimePicker;

public class MainActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, ExitDialog.ExitListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDate(View view) {
        DatePicker datePicker = new DatePicker();
        datePicker.show(getSupportFragmentManager(),"dataPicker");
    }

    public void openTime(View view) {
        TimePicker timePicker = new TimePicker();
        timePicker.show(getSupportFragmentManager(),"timePicker");
    }

    public void go(View view) {
        Intent intent = new Intent(this, MainActivityListView.class);
        startActivity(intent);
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        String msg = "Data: "+dayOfMonth+ "/"+(month+1)+"/"+year;
        ((TextView)view.findViewById(R.id.txt)).setText(msg);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Deseja sair?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Não", null)
                .show();
    }

    @Override
    public void onExit() {
        finish();
    }
}