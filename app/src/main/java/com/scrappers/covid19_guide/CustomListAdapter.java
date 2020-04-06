package com.scrappers.covid19_guide;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.net.URI;
import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> implements Filterable {

    private Activity context;
    private ArrayList<String> maintitle;
    private ArrayList<Drawable> image;
    private ArrayList<Uri> vidUri;


    /// wooohooo warning critical fatal warning >>>this is the constructor should be the same name as the class name
    public CustomListAdapter(Activity context, ArrayList<String> maintitle, ArrayList<Drawable> image
            ,ArrayList<Uri> vidUri) {
        super(context, R.layout.list_of_info, maintitle);

        this.context = context;
        this.maintitle = maintitle;
        this.image = image;
        this.vidUri=vidUri;

    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        //define the layout inflater & the view to inflate a custom layout from a xml layout file
        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.list_of_info, null, true);

        //define your components

        HtmlTextView text=rowView.findViewById(R.id.data);

        ImageView imgview=rowView.findViewById(R.id.illustrator);


        VideoView videoView =rowView.findViewById(R.id.videoView);

        //Creating MediaController
        MediaController mediaController= new MediaController(context);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);



        try {
            text.setHtml(maintitle.get(position));
            imgview.setImageDrawable(image.get(position));
            videoView.setVideoURI(vidUri.get(position));
        }catch (Exception e){
            e.printStackTrace();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
            videoView.setLayoutParams(layoutParams);
            videoView.setVisibility(View.INVISIBLE);


        }

//        //List View Animation
//        Animation animation = AnimationUtils.loadAnimation(context,R.anim.fade_in);
//        rowView.startAnimation(animation);
//



        //specify the location of media file
//        Uri uri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/media/1.mp4");


        //finish your function by returning the custom view layout
        return rowView;

    }





}

