package org.spankinghead.scrumvoter;

import android.app.Activity;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class VoteViewer extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.vote_viewer);
        
        String score = (String)getIntent().getExtras().get(ScrumVoterActivity.SCORE_KEY);
        
        final TextView bigScoreView = (TextView) findViewById(R.id.bigScoreView);
        bigScoreView.setText(score);
        
        final Button revealButton = (Button) findViewById(R.id.revealButton);
        revealButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                revealButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                bigScoreView.setVisibility(View.VISIBLE);
                revealButton.setVisibility(View.INVISIBLE);
            }
        });

    }

}
