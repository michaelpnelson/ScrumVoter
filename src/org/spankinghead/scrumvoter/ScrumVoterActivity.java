package org.spankinghead.scrumvoter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ScrumVoterActivity extends Activity {
    
    public final static String SCORE_KEY = "org.spankinghead.scrumvoter.score";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // set up the Spinner
        final Spinner scoreSpinner = (Spinner) findViewById(R.id.scoreSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.scores_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scoreSpinner.setAdapter(adapter);

        // set up the Vote button
        Button voteButton = (Button) findViewById(R.id.voteButton);
        voteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), VoteViewer.class);
                i.putExtra(SCORE_KEY, scoreSpinner.getSelectedItem().toString());
                startActivity(i);
            }
        });
    }
}