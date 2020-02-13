package edu.miracosta.cs134.sandiegomusicevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity
{
    // Wire up all the text views and one image view
    private ImageView eventImageView;
    private TextView eventArtistTextView;
    private TextView eventDateDayTextView;
    private TextView eventTimeTextView;
    private TextView eventVenueTextView;
    private TextView eventCityTextView;
    private TextView eventStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Wire up the views
        eventImageView = findViewById(R.id.eventImageView);
        eventArtistTextView = findViewById(R.id.eventArtistTextView);
        eventDateDayTextView = findViewById(R.id.eventDateDayTextView);
        eventTimeTextView = findViewById(R.id.eventTimeTextView);
        eventVenueTextView = findViewById(R.id.eventVenueTextView);
        eventCityTextView = findViewById(R.id.eventCityTextView);
        eventStateTextView = findViewById(R.id.eventStateTextView);

        // Extract the intent (from MainActivity)
        Intent intent = getIntent();
        String artist = intent.getStringExtra("Artist");
        String date = intent.getStringExtra("Date");
        String day = intent.getStringExtra("Day");
        String time = intent.getStringExtra("Time");
        String venue = intent.getStringExtra("Venue");
        String city = intent.getStringExtra("City");

        eventArtistTextView.setText(artist);
        eventDateDayTextView.setText(day + ",  " + date);
        eventTimeTextView.setText(time);
        eventVenueTextView.setText(venue);
        eventCityTextView.setText(city);
        eventStateTextView.setText("CA");

        AssetManager am = this.getAssets();
        try
        {
            InputStream stream = am.open(selectedEvent.getImageName());
            Drawable image = Drawable.createFromStream(stream, selectedEvent.getArtist());
            musicEventImageView.setImageDrawable(image);
        }
        catch (IOException e)
        {
            Log.e("SD Music Events", "Error Loading " + selectedEvent.getArtist(), e);
        }

    }
}
