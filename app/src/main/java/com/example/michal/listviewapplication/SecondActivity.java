package com.example.michal.listviewapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnCreateContextMenuListener {

    EditText et1, et2;
    Button btn;
    Switch sw;
    LinearLayout myDialog;

    Boolean tf;
    Double f;
    Double mh;

    AlertDialog ad;

    boolean none = true;
    Button btn1, btnC;
    ListView lv;
    Double SN;
    Double[] data = new Double[20];
    TextView tvXA, tvDA, tvNA, tvSNA;
    int i = 0, j = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvXA = (TextView) findViewById(R.id.tvXA);
        tvDA = (TextView) findViewById(R.id.tvDA);
        tvNA = (TextView) findViewById(R.id.tvNA);
        tvSNA = (TextView) findViewById(R.id.tvSNA);
        lv = (ListView) findViewById(R.id.lv);
        btn1 = (Button) findViewById(R.id.btn1);

        myDialog = (LinearLayout) getLayoutInflater().inflate(R.layout.my_dialog, null);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn = (Button) findViewById(R.id.btn);
        sw = (Switch) findViewById(R.id.sw);

        AlertDialog.Builder adb;
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Chose:");
        ad = adb.create();
        adb.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        adb.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tf = false;
                f = 0.0;
                mh = 0.0;
            }
        });
        adb.setNeutralButton("set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str1 = et1.getText().toString();
                String str2 = et2.getText().toString();
                if ((str1 != "") || (str1 != ".") || (str1 != "-") || (str1 != "-.") || (str1 != ".-") || (str2 != "") || (str2 != ".") || (str2 != "-") || (str2 != "-.") || (str2 != ".-")) {
                    f = Double.parseDouble(str1);
                    mh = Double.parseDouble(str2);
                } else {
                    Toast.makeText(SecondActivity.this, "Wrong Input", Toast.LENGTH_SHORT).show();
                }
                if (sw.isChecked()) {
                    tf = true;
                } else {
                    tf = false;
                }

                if (tf == false) {
                    while (i < 20) {
                        data[i] = f + (j - 1) * mh;
                        i++;
                        j++;
                    }
                }
                if (tf == true) {
                    while (i < 20) {
                        data[i] = f * (Math.pow(mh, j - 1));
                        j++;
                        i++;
                    }
                }
            }
        });

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, R.layout.support_simple_spinner_dropdown_item, data);
        lv.setAdapter(adp);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvXA.setText(data[position] + "");
        tvNA.setText((position + 1) + "");
        tvDA.setText(mh + "");
        if (tf == false) {
            SN = ((position + 1) * (2 * f + ((position + 1) - 1) * mh)) / 2;
            tvSNA.setText(SN + "");
        }
        if (tf == true) {
            SN = (f * ((Math.pow(mh, (position + 1))) - 1)) / (mh - 1);
            tvSNA.setText(SN + "");
        }
    }

    public void main(View view) {
        ad.show();
    }

    public boolean onCreatOptionsMenu(Menu menu) {
        menu.add("Credits");
        return true;
    }

    public boolean OnOptionsItemSelected(MenuItem item) {
        String str = item.getTitle().toString();
        if (str.equals("Credits"))
            Toast.makeText(this, "Application By Michal", Toast.LENGTH_LONG);
        return true;
    }

}
//}




