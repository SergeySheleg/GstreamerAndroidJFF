package org.untitled.sergey.untitled2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.freedesktop.gstreamer.GStreamer;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("gstreamer_android");
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            GStreamer.init(this);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText("Welcome to " + getGstreamerInfo() + " !");

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String getGstreamerInfo();
}
