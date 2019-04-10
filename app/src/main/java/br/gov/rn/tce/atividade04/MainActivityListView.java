package br.gov.rn.tce.atividade04;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.gov.rn.tce.atividade04.dialogs.ExitDialog;


public class MainActivityListView extends ListActivity implements ExitDialog.ExitListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);

        List<String> listData = new ArrayList<String>();

        for(int item = 0 ; item <= 50; item++){
            listData.add(String.valueOf(item));
        }

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);

        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, "Você clicou no número" + item, Toast.LENGTH_SHORT).show();
    }

    public void go(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
