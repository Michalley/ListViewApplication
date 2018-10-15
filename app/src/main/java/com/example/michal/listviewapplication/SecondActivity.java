package com.example.michal.listviewapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    boolean none = true;
    Button btn,btnC;
    ListView lv;
    Double SN;
    Double [] data = new Double[20];
    TextView tvXA,tvDA,tvNA,tvSNA;
    int i=0,j=1;
    Boolean tf;
    Double f;
    Double mh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvXA=(TextView)findViewById(R.id.tvXA);
        tvDA=(TextView)findViewById(R.id.tvDA);
        tvNA=(TextView)findViewById(R.id.tvNA);
        tvSNA=(TextView)findViewById(R.id.tvSNA);
        lv=(ListView)findViewById(R.id.lv);
        btn=(Button)findViewById(R.id.btn);
        btnC=(Button)findViewById(R.id.btnC);

        Intent gi = getIntent();
        tf = gi.getBooleanExtra("True/False",none);
        f=gi.getDoubleExtra("f",0);
        mh=gi.getDoubleExtra("mh",0);

        if (tf==false) {
            while (i < 20) {
                data[i] = f + (j - 1) * mh;
                i++;
                j++;
            }
        }
        if (tf==true){
            while (i<20){
                data[i]=f*(Math.pow(mh,j-1));
                j++;
                i++;
            }
        }

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<Double>adp = new ArrayAdapter<Double>(this, R.layout.support_simple_spinner_dropdown_item, data);
        lv.setAdapter(adp);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvXA.setText(data[position] + "");
        tvNA.setText((position+1)+"");
        tvDA.setText(mh + "");
        if (tf==false){
            SN=((position+1)*(2*f+((position+1)-1)*mh))/2;
            tvSNA.setText(SN+"");
        }
        if (tf==true){
            SN=(f*((Math.pow(mh,(position+1)))-1))/(mh-1);
            tvSNA.setText(SN+"");
        }
    }

    public void main(View view) {
        Intent t=new Intent (this,MainActivity.class);
        startActivity(t);
    }

    public void credit(View view) {
        Intent t=new Intent (this,ThirdActivity.class);
        startActivity(t);
    }
}




