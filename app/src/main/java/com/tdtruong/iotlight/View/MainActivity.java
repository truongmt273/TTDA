package com.tdtruong.iotlight.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.tdtruong.iotlight.Model.AdjustOutputDevice;
import com.tdtruong.iotlight.Model.Device;
import com.tdtruong.iotlight.Model.MQTTHelper;
import com.tdtruong.iotlight.Model.SplitData;
import com.tdtruong.iotlight.R;
import com.tdtruong.iotlight.adapter.DeviceAdapter;
import com.tdtruong.iotlight.adapter.TabMainScreen;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MQTTHelper mqttHelper;
    String dataInput="None";
    private static RecyclerView rvListDevice;
    private static ArrayList<Device> mDevices;
    private static DeviceAdapter mDeviceAdapter;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_main);

//        mDevices = new ArrayList<>();

//        startMQTT();
        addControls();

        addEvents();
=======
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.device_activity);

        //addControls();
        //addEvents();
        Log.w("go inside","a");
        startMQTT();
>>>>>>> 3ab82be66870b6f2c9b9f658bc93716379c76756
    }

    private void addControls() {
        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.viewpager);
        TabMainScreen adapterViewPager=new TabMainScreen(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);

//        rvListDevice = findViewById(R.id.recyclerview_device);




//        creatDeviceList();
//        mDeviceAdapter = new DeviceAdapter(MainActivity.this,mDevices);
//        rvListDevice.setAdapter(mDeviceAdapter);
//        rvListDevice.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private void creatDeviceList() {
        Device mDevice1 = new Device("Device1",25,30);
        Device mDevice2 = new Device("Device2",35,40);
        mDevices.add(mDevice1);
        mDevices.add(mDevice2);
    }

    private void addEvents() {

    }

    private void startMQTT(){
        final Timer aTimer = new Timer();
        TimerTask aTask = new TimerTask() {
            @Override
            public void run() {
                mqttHelper = new MQTTHelper(getApplicationContext());
                mqttHelper.setCallback(new MqttCallbackExtended() {
                    @Override
                    public void connectComplete(boolean b, String s) {
                        Log.d("mqtt data", "complete");
                    }

                    @Override
                    public void connectionLost(Throwable throwable) {
                        Log.d("mqtt data", "lost");
                    }

                    @Override
                    public void messageArrived(String topic, MqttMessage mqttMessage)
                            throws Exception {
    /*
                    JSONArray jsonArray = new JSONArray(mqttMessage.toString());
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String device_id = jsonObject.getString("device_id");
                    String temp_humi = jsonObject.getString("values");

                    JSONArray arr_value = new JSONArray(temp_humi);
                    String str_temp = arr_value.getString(0);
                    String str_humi = arr_value.getString(1);
                    float temperature = Float.parseFloat(str_temp);
                    float humidity = Float.parseFloat(str_humi);

                    Log.d(TAG, "messageArrived: DeviceInfo" + " " + device_id + " " + temperature + " " + humidity);
    */
                        Log.w("Debug mqtt", mqttMessage.toString());
//                        dataInput = mqttMessage.toString();
//                        SplitData data = new SplitData();
//                        data.setData(dataInput);
//                        DeviceActivity deviceActivity = new DeviceActivity();
//                        deviceActivity.getData(data);
//
//                        AdjustOutputDevice dataOutput = new AdjustOutputDevice();
//                        dataOutput.modify(data.getTemp(), data.getHumi());
//
//                        sendDataToMQTT(dataOutput);
//
//                        mDevices = new ArrayList<>();
//
//
//
//                        mDeviceAdapter = new DeviceAdapter(MainActivity.this,mDevices);
//                        rvListDevice.setAdapter(mDeviceAdapter);
//                        rvListDevice.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        JSONArray jsonArray = new JSONArray(mqttMessage.toString());
                        for(int i = 0; i< jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String device_id = jsonObject.getString("device_id");
                            String values = jsonObject.getString("value");

                            JSONArray arr_value = new JSONArray(values);
                            String str_temp = arr_value.getString(0);
                            String str_humi = arr_value.getString(1);
                            float temperature = Float.parseFloat(str_temp);
                            float humidity = Float.parseFloat(str_humi);

                            mDevices.add(new Device(device_id,temperature,humidity));
                        }

                        //dataReceived.setText("Receive: " + dataInput);

                        // Handle data

                        // Load Device

                    }

                    @Override
                    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    }
                });
            }
        };
        aTimer.schedule(aTask, 5000, 5000);
    }

    private void sendDataToMQTT(AdjustOutputDevice dataOutput){

        MqttMessage msgToSpeaker = new MqttMessage();
        msgToSpeaker.setId(1234);
        msgToSpeaker.setQos(0);
        msgToSpeaker.setRetained(true);

        boolean alert;
        int onOff;
        int volume;

        alert = dataOutput.getAlert();

        if (dataOutput.getStatus())
            onOff = 1;
        else
            onOff = 0;

        volume = dataOutput.getVolume();

        msgToSpeaker.setPayload(new byte[]{Byte.parseByte(String.valueOf(onOff)), Byte.parseByte(String.valueOf(volume))});

        Log.w("checkSendB", msgToSpeaker.toString());

        try {
            mqttHelper.mqttAndroidClient.publish("Topic/Speaker", msgToSpeaker);

        }catch (MqttException e){

        }
    }

}
