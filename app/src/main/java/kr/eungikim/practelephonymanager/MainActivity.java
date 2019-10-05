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
    private static final String TAG = "MYTAG";

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
            sb.append("\nContry Code").append(mTelephonyManager.getSimCountryIso());
            sb.append("\nContry Code").append(mTelephonyManager.getSimCountryIso());
            sb.append("\nContry Code").append(mTelephonyManager.getSimCountryIso());

            Log.d(TAG, "음성통화 상태 : [ getCallState ] >>> "+mTelephonyManager.getCallState());
            Log.d(TAG, "데이터통신 상태 : [ getDataState ] >>> "+mTelephonyManager.getDataState());
            Log.d(TAG, "IMEI : [ getDeviceId ] >>>"+mTelephonyManager.getDeviceId());
            Log.d(TAG, "전화번호 : [ getLine1Number ] >>> "+mTelephonyManager.getLine1Number());
            Log.d(TAG, "통신사 ISO 국가코드 : [ getNetworkCountryIso ] >>> "+mTelephonyManager.getNetworkCountryIso());
            Log.d(TAG, "통신사 ISO 국가코드 : [ getSimCountryIso ] >>> "+mTelephonyManager.getSimCountryIso());
            Log.d(TAG, "망사업자 MCC+MNC : [ getNetworkOperator ] >>> "+mTelephonyManager.getNetworkOperator());
            Log.d(TAG, "망사업자 MCC+MNC : [ getSimOperator ] >>> "+mTelephonyManager.getSimOperator());
            Log.d(TAG, "망사업자명 : [ getNetworkOperatorName ] >>> "+mTelephonyManager.getNetworkOperatorName());
            Log.d(TAG, "망사업자명 : [ getSimOperatorName ] >>> "+mTelephonyManager.getSimOperatorName());
            Log.d(TAG, "SIM 카드 시리얼넘버 : [ getSimSerialNumber ] >>> "+mTelephonyManager.getSimSerialNumber());
            Log.d(TAG, "SIM 카드 상태 : [ getSimState ] >>> "+mTelephonyManager.getSimState());
            Log.d(TAG, "소프트웨어 버전넘버 : [ getDeviceSoftwareVersion ] >>> "+mTelephonyManager.getDeviceSoftwareVersion());

            /*
            휴대폰 정보 가져오기: 데이터통화 상태 : [ getDataState ] >>> 0
            휴대폰 정보 가져오기: IMEI : [ getDeviceId ] >>>996156449799883
            휴대폰 정보 가져오기: 전화번호 : [ getLine1Number ] >>>
            휴대폰 정보 가져오기: 통신사 ISO 국가코드 : [ getNetworkCountryIso ] >>> kr
            휴대폰 정보 가져오기: 통신사 ISO 국가코드 : [ getSimCountryIso ] >>> kr
            휴대폰 정보 가져오기: 망사업자 MCC+MNC : [ getNetworkOperator ] >>> 45008
            휴대폰 정보 가져오기: 망사업자 MCC+MNC : [ getSimOperator ] >>> 45008
            휴대폰 정보 가져오기: 망사업자명 : [ getNetworkOperatorName ] >>> olleh
            휴대폰 정보 가져오기: 망사업자명 : [ getSimOperatorName ] >>> olleh
            휴대폰 정보 가져오기: SIM 카드 시리얼넘버 : [ getSimSerialNumber ] >>> 63700730264853815421
            휴대폰 정보 가져오기: SIM 카드 상태 : [ getSimState ] >>> 5
            휴대폰 정보 가져오기: 소프트웨어 버전넘버 : [ getDeviceSoftwareVersion ] >>> 01
            휴대폰 정보 가져오기: Android_ID >>> 7c982859265551f2
             */
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
