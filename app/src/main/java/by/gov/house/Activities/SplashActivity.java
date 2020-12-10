package by.gov.house.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import by.gov.house.InformationModel.Information;
import by.gov.house.SearchModel.RegionList;
import by.gov.house.Models.Human;
import by.gov.house.Models.HumanList;
import by.gov.house.R;

public class SplashActivity extends AppCompatActivity {

    public static RegionList regionList = new RegionList();
    public static boolean json = false;
    public static ArrayList<Human> republicsNameList = new ArrayList<>();
    public static ArrayList<Human> deputatsNameList = new ArrayList<>();
    public static HashMap<String, Information> deputatsDictionary;
    public static HashMap<String, Information> republicsDictionary;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    InputStream f = getAssets().open("NewJson.json");
                    int size = f.available();
                    byte[] buffer = new byte[size];
                    f.read(buffer);
                    f.close();
                    String JsonString = new String(buffer, StandardCharsets.UTF_8);
                    Gson gson = new Gson();
                    regionList = gson.fromJson(JsonString, RegionList.class);
                    json = true;
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            InputStream f = getAssets().open("SovetNameList.json");
            int size = 0;
            size = f.available();
            byte[] buffer = new byte[size];
            f.read(buffer);
            f.close();
            String JsonString = new String(buffer, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            republicsNameList = gson.fromJson(JsonString, HumanList.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream f = getAssets().open("DeputatNameList.json");
            int size = 0;
            size = f.available();
            byte[] buffer = new byte[size];
            f.read(buffer);
            f.close();
            String JsonString = new String(buffer, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            deputatsNameList = gson.fromJson(JsonString, HumanList.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream f = getAssets().open("DeputatList.json");
            int size = f.available();
            byte[] buffer = new byte[size];
            f.read(buffer);
            f.close();
            String JsonString = new String(buffer, StandardCharsets.UTF_8);
           deputatsDictionary = new Gson().fromJson(JsonString, new TypeToken<HashMap<String,Information>>(){}.getType());
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        try {
            InputStream f = getAssets().open("SovetList.json");
            int size = f.available();
            byte[] buffer = new byte[size];
            f.read(buffer);
            f.close();
            String JsonString = new String(buffer, StandardCharsets.UTF_8);
            republicsDictionary = new Gson().fromJson(JsonString, new TypeToken<HashMap<String,Information>>(){}.getType());
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}