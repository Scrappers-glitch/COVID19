package com.scrappers.covid19_guide;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import static com.scrappers.covid19_guide.MainActivity.btn;

public class lists extends AppCompatActivity {
    CollapsingToolbarLayout toolbar;
    TextToSpeech ttsEngine;
    int SPEAK_STATE=1;
    ArrayList<String> text=new ArrayList<>();


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);
       toolbar=findViewById(R.id.introtext);
            check_For_OnClick();
        ttsEngine=null;

//        display();
    }

    public void display(){
//        VideoView videoView =findViewById(R.id.videoView2);
//
//        //Creating MediaController
//        MediaController mediaController= new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.trial22));
//
//        //Setting MediaController and URI, then starting the videoView
//        videoView.requestFocus();
//        videoView.start();


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            ttsEngine.shutdown();
            ttsEngine.stop();
                finish();
                Runtime.getRuntime().freeMemory();
                System.gc();
        }catch (Exception error){
            error.printStackTrace();
            finish();

            Runtime.getRuntime().freeMemory();
            System.gc();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            ttsEngine.shutdown();
            ttsEngine.stop();
            finish();
            Runtime.getRuntime().freeMemory();
            System.gc();
        }catch (Exception error){
            error.printStackTrace();
            finish();

            Runtime.getRuntime().freeMemory();
            System.gc();
        }
    }



    public void SpeakOut() {
        String TextToSpeak = "";

        for(int x=0; x<=text.size()-1;x++){
            TextToSpeak+=text.get(x);
        }

        ttsEngine.speak("Research powered by Scrappers "+Html.fromHtml(TextToSpeak).toString(), TextToSpeech.QUEUE_ADD, null);



    }
    public void read_aLoud(View view){
        try {
            FloatingActionButton btn=findViewById(R.id.playText);
            switch (SPEAK_STATE) {
                case 1:
                    ttsEngine = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if ( status == TextToSpeech.SUCCESS ){
                                int result = ttsEngine.setLanguage(Locale.CANADA);
                                if ( result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED ){
                                    Log.e("TTS", "Bad Format");
                                } else {
                                    SpeakOut();
                                }
                            }
                        }
                    });
                    SPEAK_STATE = 2;
                    btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_off_black_24dp));

                    break;
                case 2:
                    ttsEngine.shutdown();
                    ttsEngine.stop();
                    btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_account_voice));
                    SPEAK_STATE = 1;
                    break;
            }
        } catch (Exception error) {
            ttsEngine.stop();
            ttsEngine.shutdown();
        }
    }
    public void setIntroImg(String file,String title,Integer color){
        ImageView imgv=findViewById(R.id.introimg);
        imgv.setImageDrawable(add_From_Drawable(file));

        CollapsingToolbarLayout textView=findViewById(R.id.introtext);
        textView.setTitle(title);
        toolbar.setExpandedTitleColor(color);

    }
    public void define_List1(){

        setIntroImg("epidemiologyintro.png","Epidemiology",Color.WHITE);
        //all the data goes here
        text.add("<h1>Geographic distribution<h1/>" +

                "<br>Since the first reports of cases from Wuhan, a city in the Hubei Province of China, at the end of 2019, more than 80,000 COVID-19 cases have been reported in China; <br/>" +

                "<br>these include all laboratory-confirmed cases as well as clinically diagnosed cases in the Hubei Province.<br/>" +

                " <br>A joint World Health Organization (WHO)-China fact-finding mission estimated that the epidemic in China peaked between late January and early February 2020 .<br/>");


        text.add("<h1>Transmission<h1/> "
                 +
                "<br>Epidemiological investigation in Wuhan at the beginning of the outbreak identified an initial association with a seafood market (WetMarket)that sold live animals, where most patients had worked or visited and which was subsequently closed for disinfection .<br/>" +

                "<br>However, as the outbreak progressed, person-to-person spread became the main mode of transmission.<br/>" +

                "<br>Person-to-person spread of severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2) is thought to occur mainly via respiratory droplets, resembling the spread of influenza.<br/>" +

                "<br>With droplet transmission, virus released in the respiratory secretions when a person with infection coughs, sneezes, or talks can infect another person if it makes direct contact with the mucous membranes; infection can also occur if a person touches an infected surface and then touches his or her eyes, nose, or mouth.<br/>" +

                "<br>Droplets typically do not travel more than six feet (about two meters) and do not linger in the air.<br/>" +

                "<br>However, given the current uncertainty regarding transmission mechanisms, airborne precautions are recommended routinely in some countries and in the setting of certain high-risk procedures in others.<br/>" +

                "<br>Viral RNA levels appear to be higher soon after symptom onset compared with later in the illness , this raises the possibility that transmission might be more likely in the earlier stage of infection, but additional data are needed to confirm this hypothesis.<br/>" +

                "<br>SARS-CoV-2 RNA has been detected in blood and stool specimens . Live virus has been cultured from stool in some cases , but according to a joint WHO-China report, fecal-oral transmission did not appear to be a significant factor in the spread of infection.<br/>");


        text.add("<h1>VIROLOGY<h1/>" +

                "<br>Full-genome sequencing and phylogenic analysis indicated that the coronavirus that causes COVID-19 is a betacoronavirus in the same subgenus as the severe acute respiratory syndrome (SARS) virus (as well as several bat coronaviruses), but in a different clade.<br/>" +

                "<br>The structure of the receptor-binding gene region is very similar to that of the SARS coronavirus, and the virus has been shown to use the same receptor, the angiotensin-converting enzyme 2 (ACE2), for cell entry .<br/>" +

                "<br>The Coronavirus Study Group of the International Committee on Taxonomy of Viruses has proposed that this virus be designated severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2) .<br/>" +

                "<br>The Middle East respiratory syndrome (MERS) virus, another betacoronavirus, appears more distantly related .<br/>" +

                "<br>The closest RNA sequence similarity is to two bat coronaviruses, and it appears likely that bats are the primary source; whether COVID-19 virus is transmitted directly from bats or through some other mechanism (eg, through an intermediate host) is unknown .<br/>");
        //all the illustrating images for the data goes here
        ArrayList<Drawable> imgls=new ArrayList<>();


        imgls.add(add_From_Drawable("epi1.jpg"));
        imgls.add(add_From_Drawable("transmission.jpg"));
        imgls.add(add_From_Drawable("Virology.png"));





        ArrayList<Uri> viduri=new ArrayList<>();
        //if you wanna add a video do it -> no errors if you don't
        // method of adding : just put the vid file in the Raw folder then play it via this code
        //        viduri.add(Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.trial22));
        //definers
        CustomListAdapter cstmls=new CustomListAdapter(this,text,imgls,viduri);
        ListView ls=findViewById(R.id.listview);
        ls.setAdapter(cstmls);
    }

    public void define_List2(){

        setIntroImg("coranvirussymptoms.png","Symptoms",Color.BLACK);

        //all the data goes here
        text.add("<h1>Watch for symptoms</h1>" +
                "<br>Reported illnesses have ranged from mild symptoms to severe illness and death for confirmed coronavirus disease 2019 (COVID-19) cases.</br>");

        text.add("<h1>These symptoms may appear 2-14 days after exposure (based on the incubation period of MERS-CoV viruses).</h1>" +
                "<br>-Fever</br>" +
                "<br>-Cough</br>" +
                "<br>-Shortness of breath</br>");

        text.add("<h1>Emergency Symptoms</h1>"+
                "<br>If you develop emergency warning signs for COVID-19 get medical attention immediately. Emergency warning signs include*:</br>" +
                "<br>->Trouble breathing</br>" +
                "<br>->Persistent pain or pressure in the chest</br>" +
                "<br>->New confusion or inability to arouse</br>" +
                "<br>->Bluish lips or face</br>" +
                "<br>*This list is not all inclusive. Please consult your medical provider for any other symptoms that are severe or concerning.</br>");

       text.add("<h1>What To Do if You Are Sick..?</h1>"
       +"<br><h4>Stay home except to get medical care</h4>" +
               "<ul>" +
               "<li><u>Stay home</u></li>" +
               "<li><u>Stay in touch with your doctor</u></li>" +
               "<li><u>Avoid public transportation</u></li>" +
               "</ul>" +
               "</br>"
       +"<br><h4>Separate yourself from other people in your home, this is known as home isolation</h4>" +
               "<ul>" +
               "<li><u>Limit contact with pets & animals</u></li>" +
               "<li><u>Wear a facemask if you are sick</u></li>" +
               "</ul>" +
               "</br>" +
       "<br><h4>Cover your coughs and sneezes</h4>" +
       "<ul>" +
       "<li><u>Cover</u></li>" +
       "<li><u>Dispose</u></li>" +
       "<li><u>Wash your hands</u></li>" +
       "</ul>" +
       "</br>" +

       "<br><h4>Clean your hands often</h4>" +
       "<ul>" +
       "<li><u>Wash hands</u></li>" +
       "<li><u>using Hand sanitizer</u></li>" +
       "<li><u>using Soap and water</u></li>" +
       "<li><u>Avoid Touching your T-Zone</u></li>" +
       "</ul>" +
       "</br>" +

       "<br><h4>Avoid sharing personal household items</h4>" +
       "<ul>" +
       "<li><u>Wash thoroughly after use:</u></li>" +
       "</ul>" +
       "</br>"       );


       text.add("<h1>How to discontinue home isolation</h1>" +
               "<br>People with COVID-19 who have " +
               "stayed home (home isolated) can stop home isolation under the following conditions :</br>" +
               "<ul>" +

       "<li><h4>If you will not have a test to determine if you are still contagious, you can leave home after these three things have happened</h4></li>" +
               "<ol>" +
               "<li>You have had no fever for at least 72 hours " +
               "(that is three full days of no fever without the use medicine that reduces fevers)</li>" +
               "<li>other symptoms have improved (for example, when your cough or shortness of breath have improved)</li>" +
               "<li>at least 7 days have passed since your symptoms first appeared</li>" +
               "</ol>" +
       "<li><h4>If you will be tested to determine if you are still contagious, you can leave home after these three things have happened</h4></li>" +
               "<ol>" +
               "<li>You no longer have a fever (without the use medicine that reduces fevers)</li>" +
               "<li>other symptoms have improved (for example, when your cough or shortness of breath have improved)</li>" +
               "<li>you received two negative tests in a row, 24 hours apart. Your doctor will follow CDC guidelines.</li>" +
               "</ol>" +

               "</ul>");
        //all the illustrating images for the data goes here
        ArrayList<Drawable> imgls=new ArrayList<>();
        imgls.add(add_From_Drawable("symptoms1.png"));
        imgls.add(add_From_Drawable("symptoms2.png"));
        imgls.add(add_From_Drawable("emergencysymptom.png"));
        imgls.add(add_From_Drawable("symptoms5.png"));
        imgls.add(add_From_Drawable("home.png"));
        //definers

        ArrayList<Uri> viduri=new ArrayList<>();
        //if you wanna add a video do it -> no errors if you don't
        // method of adding : just put the vid file in the Raw folder then play it via this code
        //        viduri.add(Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.trial22));
        CustomListAdapter cstmls=new CustomListAdapter(this,text,imgls,viduri);
        ListView ls=findViewById(R.id.listview);
        ls.setAdapter(cstmls);
    }
    public void define_List3(){

        setIntroImg("Coronavirus-drugs.jpg","Clinical Stuff",Color.BLACK);
        //all the data goes here
        text.add("<h1>Diagnosis</h1>" +
                "<br>There are laboratory tests that can identify the virus that causes COVID-19 in respiratory specimens(Sputum/Aspirate/Serology or using Naso/OroPharyngeal Swab)." +
                " State and local public health departments have received tests from CDC while medical providers are getting tests developed by commercial manufacturers. " +
                "All of these tests are <span style=\"background-color:#FFFF00\">Real-Time Reverse Transcriptase (RT)-PCR Diagnostic Panels</span>, that can provide results in 4 to 6 hours.</br>"

                +"<h4>Who should be tested</h4>" +
                "<br>Not everyone needs to be tested for COVID-19. Here is some information that might help in making decisions about seeking care or testing.</br>" +

                "<ul>" +
                "<li><u>Most people have mild illness and are able to recover at home.</u></li>" +
                "<li><u>Testing results may be helpful to inform decision-making about who you come in contact with.</u></li>" +
                "<li><u>There is no treatment specifically approved for this virus.</u></li>" +
                "</ul>" +


                "<h4>CDC has guidance for who should be tested, but decisions about testing are at the discretion of state and local health departments and/or individual clinicians.</h4>" +

                "<br>Clinicians should work with their state and local health departments to coordinate testing through public health laboratories, or work with clinical or commercial laboratories.</br>" +
                "" +
                "<h4>How to get tested</h4>" +
                "<br>If you have symptoms of COVID-19 and want to get tested, try calling your state or local health department or a medical provider. While supplies of these tests are increasing, it may still be difficult to find a place to get tested.</br>" +

                "<h4>What to do after you are tested</h4>" +
                "<br> <span style=\"background-color:#ff0000\"> <b>If you test positive for COVID-19</b> </span>, see If You Are Sick or Caring for Someone.</br>" +
                "<br> <span style=\"background-color:#00FF00\"> <b>If you test negative for COVID-19</b></span>, you probably were not infected at the time your specimen was collected. However, that does not mean you will not get sick. It is possible that you were very early in your infection at the time of your specimen collection and that you could test positive later, or you could be exposed later and then develop illness.</br>" +
                "<br>In other words, a negative test result does not rule out getting sick later.</br>");
        text.add("<h1>Other Imaging Techniques(They are not specific to COVID19)</h1>" +
                "Chest X-Ray" +
                "<h4>Showing</h4>" +
                "<ul>" +
                "<li>Ground Glass Opacity due to Pneumonia & Interstitial Fluid Edema</li>" +
                "</ul>");
        text.add("<h1>Chest CT Scan(not specific for COVID19)</h1>" +
                "<br><ul>" +
                "<h4>Showing</h4>" +
                "<li>Ground Glass Opacity</li>" +
                "<li>Consolidations</li>" +
                "<li>Crazy Paving Pattern</li>" +
                "<ul></br>");
        text.add("<h1>US Chest Scan(UltraSonic)</h1>" +
                "<h4>Showing</h4>" +
                "<br><ul>" +
                "<li>Pleural line Thickening</li>" +
                "<li>B-Lines</li>" +
                "<li>Consolidation</li>" +
                "<ul></br>");
        text.add("<h1>Treatment of COVID19</h1>" +
                "<h6><span style=\"background-color:#ff0000\">*Currently there's no particular treatment or vaccine*</span></h6>" +
                "<br>There are Drugs that are used to relieve some symptoms in addition to the supportive care:</br>" +
                "<br><ul>" +
                "<li><u>Remdesivir</u>(interferes with the action of viral RNA polymerase and evades proofreading by viral exoribonuclease (ExoN), causing a decrease in viral RNA production.)</Li>" +
                "<li><u>Tylenol</u>(reducing pain, reducing fever, and relieving the symptoms of allergies, cold, cough, headache)</li>" +
                "<li><u>Chloroquine</u>(inhibit viral entry as endosome)</li>" +
                "<li><u>Ritonavir</u>(Protease inhibitor so Covid19 cannot make his own spike & membrane protein)</li>" +
                "<li><u>Tocilizumab</u>(decrease inflammatory mediators)</li>" +
                "<li><u>Corticosteroids</u>(be careful using those)</li>" +
                "<ul></br>" +
                "<h4>Mechanical Ventilation & Clinical Management is very important in patients with ARDS</h4>");
        //all the illustrating images for the data goes here
        ArrayList<Drawable> imgls=new ArrayList<>();
        imgls.add(add_From_Drawable("RtPcR.jpg"));
        imgls.add(add_From_Drawable("xray covid.png"));
        imgls.add(add_From_Drawable("CT scan unscaled.png"));
        imgls.add(add_From_Drawable("US chest scan.png"));
        imgls.add(add_From_Drawable("drugs covid.png"));

        //definers

        ArrayList<Uri> viduri=new ArrayList<>();
        //if you wanna add a video do it -> no errors if you don't
        // method of adding : just put the vid file in the Raw folder then play it via this code
        //        viduri.add(Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.trial22));
        CustomListAdapter cstmls=new CustomListAdapter(this,text,imgls,viduri);
        ListView ls=findViewById(R.id.listview);
        ls.setAdapter(cstmls);
    }
    public void define_List4(){

        setIntroImg("coronavirus.png","Pathogenesis",Color.BLACK);

        //all the data goes here
        text.add("<h1>So what will corona do after reaching your respiratory system ?<h1/>" +
                "<br>Well … it will go directly to the alveoli (at the end of respiratory tract) to attack specifically “Type 2 Pneumocytes” which is responsible for producing surfactant that protects the alveoli from collapsing and impairment and attaches to it.<br/>" +
                "<br>Once attached to the cell , corona uses the cell machinery to produce many corona viruses and cause havoc on the respiratory system but how ?<br/>");


        text.add("<h1>We must take in mind that viruses are composed of:<h1/>" +
                "<br>1) The nucleic acid(+ve ssRNA) which carries information about virus<br/>" +
                "<br>2) A capsule or envelope containing the nucleic acid<br/>"+
                "<br>If we had a look on the virus structure we will notice it has spikes on it" +
                ",these are in fact proteins that help the virus to attach to the pneumocytes.<br/>");

        text.add("<h1>(A) Schematic of the SARS-CoV virion.<h1/>" +
                "<br>The virus genome is associated with the nucleocapsid protein and is contained within a lipid bilayer\n" +
                "containing at least five structural proteins (membrane (M), spike (S), envelope (E), ORF 3a, and ORF 7a)<br/>");


        text.add("<h1>(C) Schematics of the SARS Spike (S) glycoprotein domain organization.<h1/>" +
                "<br>Like gp160 of HIV," +
                "hemagglutinin of influenza, F protein of paramyxovirus, and glycoprotein of Ebola virus, the spike (S)" +
                "glycoprotein protein of coronavirus is a class I viral fusion protein that mediates virus binding and fusion" +
                "allowing the virus to enter the host cell<br/>");



        text.add("<h1>(D) Linear layout (N-terminal to C-terminal) of the S protein domains.<h1/>" +
                "<br>"+
                "Like other class I fusion proteins, the SARS S glycoprotein contains two functional domains, S1 and S2,\n" +
                "joined by a protease cleavage site. The S1 domain (17-756aa) contains the receptor binding domain (RBD)\n" +
                "(318-510aa) while the S2 region (757-1225aa) contains the two heptad repeat (HR) regions that facilitate\n" +
                "viral fusion and a transmembrane domain (1189-1227aa) that anchors spike to the viral envelope.<br/>");


        text.add("<h1>How it works !<h1/>"+
                "<br>The corona virus carries <b><u>+SSRNA (Positive Sense – Single stranded RNA)</u></b> " +
                "     which corona releases it into the cytoplasm of the pneumocyte.<br/>"
                );

        text.add("<br>Once released it uses the ribosomes in the pneumocyte to translate RNA and convert it into specific protein molecules … "+
                "then these protein molecules make up the structure (capsule) of the virus using enzyme called “Proteinases”.<br/>"+
                "<br>On the other hand … the +SSRNA itself uses an enzyme called “RNA Dependant RNA Polymerase” to produce many copies of it . Having structures made and RNA copied "+
                ",every copy of RNA enters into one capsule producing many viruses in the cell and of course … destroying the pneumocytes to attack other cells .<br/>"
                );

        text.add("<br><b>As</b> pneumocytes are being damaged they release inflammatory mediators which stimulates the macrophages in this area of alveoli and make it release the cytokines (IL-1, IL-6, TNF-α)" +
                " that causes the vasodilation of blood vessels surrounding alveoli and increasing of capillary permeability of them causing the plasma of blood to leak into interstitial spaces and compressing the alveoli from outside.<br/>");

        text.add("<br><b>The fluid</b> will enter also the alveoli itself making alveolar edema and accumulation of fluids inside will drown out the surfactant we talked about previously causing finally … Collapsing of alveoli which leads to impairment in gas exchange from alveolar membrane causing" +
                " “Hypoxemia” which means low oxygen is entering the blood and" +
                " increasing work of breathing to overcome the edema and collapsing power .<br/>");

        text.add("<h1> Systemic Manifestations </h1>"+
                  "<br> May take place due to the release of chemical mediators including:</br>"+
                "<br>-Hypotension</br>"+
                "<br>-SARS(Severe Acute Respiratory Syndrome)</br>" +
                "<br>-SIRS(Systemic Inflammatory Response Syndrome)</br>" +
                "<br>-MOF(Multiple Organ Failure)in severe Cases</br>" +
                "<br>-ARDS(Acute Respiratory Distress Syndrome)</br>" +
                "<br>-Septic Shock</br>"    );
        //all the illustrating images for the data goes here
        ArrayList<Drawable> imgls=new ArrayList<>();
        imgls.add(add_From_Drawable("patho2.png"));
        imgls.add(add_From_Drawable("patho1.jpg"));
        imgls.add(add_From_Drawable("SARS cov ultra.png"));
        imgls.add(add_From_Drawable("Spike protein.png"));
        imgls.add(add_From_Drawable("s spike layout.png"));

        imgls.add(add_From_Drawable("patho3.png"));
        imgls.add(add_From_Drawable("patho4.jpg"));

        imgls.add(add_From_Drawable("ARDS_David-Darling_tg.jpg"));
        imgls.add(add_From_Drawable("pulmonary edema.jpeg"));
        imgls.add(add_From_Drawable("sys mani.jpg"));
        //definers

        ArrayList<Uri> viduri=new ArrayList<>();
        //if you wanna add a video do it -> no errors if you don't
        // method of adding : just put the vid file in the Raw folder then play it via this code

//        viduri.add(Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.osce));

        CustomListAdapter cstmls=new CustomListAdapter(this,text,imgls,viduri);
        ListView ls=findViewById(R.id.listview);
        ls.setAdapter(cstmls);
    }


    public void check_For_OnClick(){
        switch (btn){
            case 1:
                define_List1();
                break;
            case 2:
                define_List2();
                break;
            case 3:
                define_List3();
                break;
            case 4:
                define_List4();
                break;

                default:
                    break;
        }
    }

    public Drawable add_From_Drawable(String fileName){
       Drawable drawable=null;
        try {
            // get input stream
            InputStream ims = getAssets().open(fileName);
            // load image as Drawable
             drawable = Drawable.createFromStream(ims, null);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return drawable;
    }
}