package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mtopButton;
    Button mbottomButton;
    int mIndex = 1;
    boolean mBootomTopPressed = false;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mtopButton = (Button) findViewById(R.id.buttonTop);
        mbottomButton = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mtopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Top Button pressed",Toast.LENGTH_SHORT).show();
                mBootomTopPressed = true;
                nextStory();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mbottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Bottom Button pressed",Toast.LENGTH_SHORT).show();
                nextStory();
            }
        });

    }
    public void nextStory(){
        switch (mIndex){
            case 1:{
                if(mBootomTopPressed){
                    mIndex=3;
                    mStoryTextView.setText(R.string.T3_Story);
                    mtopButton.setText(R.string.T3_Ans1);
                    mbottomButton.setText(R.string.T3_Ans2);
                    break;
                }else{
                    mIndex=2;
                    mStoryTextView.setText(R.string.T2_Story);
                    mtopButton.setText(R.string.T2_Ans1);
                    mbottomButton.setText(R.string.T2_Ans2);
                    break;
                }
            }
            case 2:{
                if(mBootomTopPressed){
                    mIndex=3;
                    mStoryTextView.setText(R.string.T3_Story);
                    mtopButton.setText(R.string.T3_Ans1);
                    mbottomButton.setText(R.string.T3_Ans2);
                    break;
                }else{
                    mStoryTextView.setText(R.string.T4_End);
                    mtopButton.setVisibility(View.GONE);
                    mbottomButton.setVisibility(View.GONE);
                    break;
                }

            }
            case 3:{
                if(mBootomTopPressed){
                    mStoryTextView.setText(R.string.T6_End);
                    mtopButton.setVisibility(View.GONE);
                    mbottomButton.setVisibility(View.GONE);
                }else{
                    mStoryTextView.setText(R.string.T5_End);
                    mtopButton.setVisibility(View.GONE);
                    mbottomButton.setVisibility(View.GONE);
                }
            }
        }
    }
}
