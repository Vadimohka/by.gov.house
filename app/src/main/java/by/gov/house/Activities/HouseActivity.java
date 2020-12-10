package by.gov.house.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import by.gov.house.R;

import java.util.ArrayList;


public class HouseActivity extends AppCompatActivity {

    ArrayList<String> houseList = new ArrayList<>();
    int AreaId, DistrictId, CityId, StreetId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        setTitle("Выберите номер дома");

        Bundle arguments = getIntent().getExtras();
        AreaId = arguments.getInt("AreaId");
        DistrictId = arguments.getInt("DistrictId");
        CityId = arguments.getInt("CityId");
        StreetId = arguments.getInt("StreetId");

        insertHouseList(AreaId, DistrictId, CityId, StreetId);
        GridView GList = findViewById(R.id.gridview_house);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.grid_item, houseList);
        GList.setAdapter(adapter);

        final Intent intent = new Intent(this, HumanActivity.class);
        GList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                intent.putExtra("id", SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.get(CityId).streetList.get(StreetId).houseList.get(position).deputatId);
                intent.putExtra("bool", true);
                intent.putExtra("CityId", CityId);
                intent.putExtra("DistrictId", DistrictId);
                intent.putExtra("AreaId", AreaId);
                intent.putExtra("StreetId", StreetId);
                intent.putExtra("Check", 2);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, StreetActivity.class);
        intent.putExtra("CityId", CityId);
        intent.putExtra("DistrictId", DistrictId);
        intent.putExtra("AreaId", AreaId);
        startActivity(intent);
        finish();
    }

    private void insertHouseList(int AreaId, int DistrictId, int CityId, int StreetId)
    {
        for(int i = 0; i < SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.get(CityId).streetList.get(StreetId).houseList.size(); i++)
        {
            houseList.add(SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.get(CityId).streetList.get(StreetId).houseList.get(i).houseNumber);
        }
    }
}
