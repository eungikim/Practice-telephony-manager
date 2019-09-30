package kr.eungikim.practelephonymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int BUTTON_CNT = 2;
    private static int sButtonSeq = 0;

    TelephonyManager mTelephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //the layout on which you are working
        LinearLayout layout = findViewById(R.id.main_layout);
        for (int i = 0; i < BUTTON_CNT; i++) {
            addButton(layout);
        }
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 0);
        mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    }

    private StringBuilder getTelephonyManagerData() {
        StringBuilder sb = new StringBuilder();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            sb.append("Imei: ").append(mTelephonyManager.getImei());
            sb.append("\nsubscriberId: ").append(mTelephonyManager.getSubscriberId());
            sb.append("\nNetwork country iso").append(mTelephonyManager.getNetworkCountryIso());
            sb.append("\nNetwork type").append(mTelephonyManager.getNetworkType());
            sb.append("\nPhone type").append(mTelephonyManager.getPhoneType());
        }

        return sb;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 0:
                log(getTelephonyManagerData().toString());
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private void log(String log) {
        Log.d("MyTag", log);
    }


    private void addButton(ViewGroup layout) {
        Button btnTag = new Button(this);
        String buttonText = "B" + sButtonSeq;
        btnTag.setText(buttonText);
        btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btnTag.setId(sButtonSeq);
        btnTag.setOnClickListener(this);
        sButtonSeq++;
        layout.addView(btnTag);
    }
}
