package com.scrappers.covid19_guide;

import android.app.Activity;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
public class EmergencyNumber_Adapter  extends ArrayAdapter<String>  {


        private Activity context;
        private ArrayList<String> maintitle;
        private ArrayList<String> subtitle;
        public static TextView Subtxtview;


        /// wooohooo warning critical fatal warning >>>this is the constructor should be the same name as the class name
        public EmergencyNumber_Adapter(Activity context, ArrayList<String> maintitle,ArrayList<String> subtitle) {
            super(context, R.layout.emergency_number_adapter, maintitle);
            // TODO Auto-generated constructor stub

            this.context = context;
            this.maintitle = maintitle;
            this.subtitle = subtitle;


        }



        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            //define the layout inflater & the view to inflate a custom layout from a xml layout file
            LayoutInflater inflater = context.getLayoutInflater();
            final View rowView = inflater.inflate(R.layout.emergency_number_adapter, null, true);

            //define your components

            TextView Maintxtview=rowView.findViewById(R.id.mainTitleTxt);
            Subtxtview=rowView.findViewById(R.id.subTitleTxt);



            Maintxtview.setText(maintitle.get(position));

            Subtxtview.setText(subtitle.get(position));




            //finish your function by returning the custom view layout
            return rowView;

        }



    }



