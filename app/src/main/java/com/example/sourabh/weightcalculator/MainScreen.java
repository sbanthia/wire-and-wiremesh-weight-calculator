package com.example.sourabh.weightcalculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.HashMap;

public class MainScreen extends AppCompatActivity {
    TextView result_kgsqft;
    TextView result_kgsqm;
//    TextView result_rollweight;
    EditText holesize;
//    EditText rollheight;
//    EditText rolllength;
    EditText wiredia;
    ToggleButton wiredia_unit;
    ToggleButton holesize_unit;
//    ToggleButton rollheight_unit;
//    ToggleButton rolllength_unit;
    Button calculate;


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
    double area_result_sqft;
    double area_result_sqm;
//    double rollweight_val;
    double holesize_val;
    double wiredia_val;
//    int rollheight_val;
//    int rolllength_val;
//    char hole_unit;
//    char height_unit;
//    char length_unit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        result_kgsqft = (TextView)findViewById(R.id.result_kgsqft);
        result_kgsqm = (TextView)findViewById(R.id.result_kgsqm);
//        result_rollweight =(TextView)findViewById(R.id.result_rollweight);

        holesize = (EditText)findViewById(R.id.holesize);
//        rollheight = (EditText)findViewById(R.id.rollheight);
//        rolllength = (EditText)findViewById(R.id.rolllength);
        wiredia = (EditText)findViewById(R.id.wiredia);

        wiredia_unit= (ToggleButton)findViewById(R.id.wiredia_unit);
        holesize_unit= (ToggleButton) findViewById(R.id.holesize_unit);
//        rollheight_unit= (ToggleButton)findViewById(R.id.rollheight_unit);
//        rolllength_unit = (ToggleButton)findViewById(R.id.rolllength_unit);

        calculate = (Button)findViewById(R.id.calculate);
        holesize_val = Integer.parseInt(holesize.getText().toString());
//        rollheight_val = Integer.parseInt(rollheight.getText().toString());
//        rolllength_val = Integer.parseInt(rolllength.getText().toString());
        wiredia_val = Integer.parseInt(wiredia.getText().toString());

        wiredia_unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wiredia_unit.isChecked()){

                }else{
                    HashMap<Integer, Double> dia = new HashMap<Integer, Double>();

                    /*Adding elements to HashMap*/
                    dia.put(16,1.6);
                    dia.put(14,2.0);
                    dia.put(12,2.5);
                    dia.put(11,2.8);
                    dia.put(10,3.0);
                    dia.put(9,3.5);
                    dia.put(8,4.0);
                    double mm_wiredia = wiredia_val;

                    wiredia_val=dia.get(mm_wiredia);



                }

            }
        });
        holesize_unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holesize_unit.isChecked()){

                }else{
                    double inch_holesize = holesize_val;

                    holesize_val = inch_holesize * 25.4;
                }
            }
        });



        calculate.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             area_result_sqft = (wiredia_val * wiredia_val * 1.29) / holesize_val;
                                             area_result_sqm = area_result_sqft / 0.092903;
                                             area_result_sqft = (double) Math.round(area_result_sqft * 100d) / 100d;
                                             area_result_sqm = (double) Math.round(area_result_sqm * 100d) / 100d;

                                             result_kgsqft.setText(String.valueOf(area_result_sqft));
                                             result_kgsqm.setText(String.valueOf(area_result_sqm));


                                         }
                                     });



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
