package com.example.municipalityandweather;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MunicipalityInfoActivity extends AppCompatActivity {
    TextView municipalityName;
    TextView residentsTotal;
    TextView politicalDistribution;
    TextView additionalInfo;
    TextView weatherDetails;
    Bundle intentExtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality_info);

        municipalityName = findViewById(R.id.municipalityName);
        residentsTotal = findViewById(R.id.residentsTotal);
        politicalDistribution = findViewById(R.id.politicalDistribution);
        additionalInfo = findViewById(R.id.additionalInfo);
        weatherDetails = findViewById(R.id.weatherDetails);

        intentExtras = getIntent().getExtras();

        if (intentExtras != null) {
            municipalityName.setText(intentExtras.getString("municipalityName"));
            residentsTotal.setText("Residents: " + intentExtras.getString("residentsTotal"));
            //politicalDistribution.setText(intentExtras.getString("politicalDistribution"));
            additionalInfo.setText(intentExtras.getString("additionalInfo"));
            weatherDetails.setText(intentExtras.getString("weatherDetails"));

        }

    }
}

