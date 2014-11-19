package me.alexrs.wavedrawable.demo.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import me.alexrs.wavedrawable.WaveDrawable;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private String[] interpolatorsList = {"LinearInterpolator", "AccelerateDecelerateInterpolator",
            "AccelerateInterpolator", "AnticipateInterpolator", "AnticipateOvershootInterpolator",
            "BounceInterpolator", "CycleInterpolator", "DecelerateInterpolator", "OvershootInterpolator"};
    private WaveDrawable waveDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, interpolatorsList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        waveDrawable = new WaveDrawable(Color.parseColor("#8e44ad"), 500);
        imageView.setBackgroundDrawable(waveDrawable);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Interpolator interpolator;

        switch (position) {
            case 0:
                interpolator = new LinearInterpolator();
                break;
            case 1:
                interpolator = new AccelerateDecelerateInterpolator();
                break;
            case 2:
                interpolator = new AccelerateInterpolator();
                break;
            case 3:
                interpolator = new AnticipateInterpolator();
                break;
            case 4:
                interpolator = new AnticipateOvershootInterpolator();
                break;
            case 5:
                interpolator = new BounceInterpolator();
                break;
            case 6:
                interpolator = new CycleInterpolator(3);
                break;
            case 7:
                interpolator = new DecelerateInterpolator();
                break;
            case 8:
                interpolator = new OvershootInterpolator();
                break;
            default:
                interpolator = new LinearInterpolator();
                break;
        }
        waveDrawable.setWaveInterpolator(interpolator);
        waveDrawable.startAnimation();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
