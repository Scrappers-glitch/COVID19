package com.scrappers.covid19_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static int btn=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE},
                1);
    }


    public void epidemiology_btn(View view){

        btn=1;
        startActivity(new Intent(this,lists.class));
    }
    public void symptoms_btn(View view){

        btn=2;
        startActivity(new Intent(this,lists.class));

    }
    public void treatment_btn(View view){

        btn=3;
        startActivity(new Intent(this,lists.class));

    }

    public void pathogensis_btn(View view){

        btn=4;
        startActivity(new Intent(this,lists.class));

    }

    public void map_btn(View view){

        startActivity(new Intent(this,COVID19_Maps.class));

    }

    public void about_btn(View view){

            startActivity(new Intent(this,aboutActivity.class));



    }

    public void callUser(String phoneNum) {

        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNum));//change the number
            startActivity(callIntent);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Please Enable Phone Calls Permission !",Toast.LENGTH_LONG).show();
        }

    }
    public void emergency_btn(View view){

        DB();

    }

    public void DB() {
        //defining an alertDialog builder instance in this context
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        //defining a layoutinflater instance to to inflate a view that has that custom layout w/in the inside
        //Deep:- final is a keyword -> Immutable & accessing data from an inner class (View class)
        final LayoutInflater inflater = this.getLayoutInflater();
        //defining a View instance/obj & inflating the custom layout
        final View layout = inflater.inflate(R.layout.emergency_list_design, null);
        //setting that badBoy(view)to the current builder
        builder.setView(layout);


        ArrayList maintitile=new ArrayList();

        maintitile.add("ALGERIA");
        maintitile.add("AUSTRALIA");
        maintitile.add("BRAZIL");
        maintitile.add("CHINA");
        maintitile.add("EGYPT");
        maintitile.add("ETHIOPIA");
        maintitile.add("GREECE");
        maintitile.add("INDIA");
        maintitile.add("ISRAEL");
        maintitile.add("IRAQ");
        maintitile.add("IRAN");
        maintitile.add("ITALY");
        maintitile.add("JAPAN");
        maintitile.add("JORDAN");
        maintitile.add("KOREA");
        maintitile.add("KUWAIT");
        maintitile.add("LEBANON");
        maintitile.add("MEXICO");
        maintitile.add("NEW ZEALAND");
        maintitile.add("NIGERIA");
        maintitile.add("PHILIPPINES");
        maintitile.add("QATAR");
        maintitile.add("RUSSIA");
        maintitile.add("SAUDI ARABIA");
        maintitile.add("SOUTH AFRICA");
        maintitile.add("TURKEY");
        maintitile.add("TUNISIA");
        maintitile.add("UKRAINE");
        maintitile.add("UE");
        maintitile.add("UK");
        maintitile.add("US/CANADA");
        maintitile.add("UAE");
        maintitile.add("VIETNAM");
        maintitile.add("YEMEN");




        final ArrayList subtitle=new ArrayList();
        subtitle.add("14");
        subtitle.add("000");
        subtitle.add("192");
        subtitle.add("119");
        subtitle.add("105");
        subtitle.add("907");
        subtitle.add("166");
        subtitle.add("112");
        subtitle.add("101");
        subtitle.add("122");
        subtitle.add("115");
        subtitle.add("118");
        subtitle.add("119");
        subtitle.add("911");
        subtitle.add("119");
        subtitle.add("112");
        subtitle.add("140");
        subtitle.add("911");
        subtitle.add("111");
        subtitle.add("112");
        subtitle.add("911");
        subtitle.add("999");
        subtitle.add("103");
        subtitle.add("997");
        subtitle.add("10177");
        subtitle.add("112");
        subtitle.add("198");
        subtitle.add("103");
        subtitle.add("112");
        subtitle.add("999");
        subtitle.add("911");
        subtitle.add("998");
        subtitle.add("115");
        subtitle.add("191");

        final EmergencyNumber_Adapter emergency_adapter=new EmergencyNumber_Adapter(this,maintitile,subtitle);
        ListView lsviewEmerg=layout.findViewById(R.id.emergencylistview);
        lsviewEmerg.setAdapter(emergency_adapter);




        final AlertDialog.Builder call_procedure_builder =
                new AlertDialog.Builder(this);

        lsviewEmerg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                //set The Message for that Builder(Hint!!!-> Revise getters & setters in java)
                call_procedure_builder.setMessage("Are you Sure you want to get help?")
                        //setting the positive btn
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            //abstraction & Interfaces Applied
                            public void onClick(DialogInterface dialog, int id) {

                                callUser(subtitle.get(position).toString());

                            }
                        })

                        //setting up the -'ve btn to No & its onclick listener
                        //->NB(Deep Knowledge) -> its click Listener calls the d2.dismiss(); spontaneously/Automatically
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //->NB(Deep Knowledge) -> -'ve btn click Listener calls the d2.dismiss(); spontaneously/Automatically
                            }
                        })
                        //setting the cancelable() function to false -> you cannot cancel it by any action(eg:-pressing on white Surrounding screen) except the -ve btn
                        .setCancelable(true);
                //creating an AlertDialog instance and adding it to the builder that we 've configured its properties
                AlertDialog d2 = call_procedure_builder.create();
                //showing that dialog onto the screen
                d2.show();

            }
        });



        //creating an alertDialog instance and adding it to the builder
        AlertDialog alrt = builder.create();
        //setting the window gravity to buttom
        alrt.getWindow().setGravity(Gravity.CENTER);
//        //running the animations on the alertDialog from styles.xml
//        alrt.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation1;
        //showing that alertDialog
        alrt.show();
    }
}
