package by.gov.house.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import by.gov.house.Adapters.CityAdapter;
import by.gov.house.SearchModel.City;
import by.gov.house.R;

public class CityActivity extends AppCompatActivity {

    ArrayAdapter<City> adapter;
    ListView listView;
    EditText editText;
    int AreaId, DistrictId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        setTitle("Выберите город");

        Bundle arguments = getIntent().getExtras();
        assert arguments != null;
        AreaId = arguments.getInt("AreaId");
        DistrictId = arguments.getInt("DistrictId");

        listView = findViewById(R.id.list_city);
        editText = findViewById(R.id.search_city);

        adapter = new CityAdapter(this, SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList);
        listView.setAdapter(adapter);


        final Intent intent = new Intent(this, StreetActivity.class);
        final Intent toHuman = new Intent(this, HumanActivity.class);

        listView.setOnItemClickListener((parent, v, position, id) -> {
            City value = adapter.getItem(position);
            for (int i = 0; i < SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.size(); i++) {
                assert value != null;
                if( (value.cityName + value.categoryName + value.cityCategory).equals(SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.get(i).cityName
                        + SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.get(i).categoryName
                        + SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.get(i).cityCategory) ) {
                    if (!(SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.get(i).deputatId == null)) {
                        toHuman.putExtra("bool", true);
                        toHuman.putExtra("id", SplashActivity.regionList.regionList.get(AreaId).districtList.get(DistrictId).cityList.get(i).deputatId);
                        toHuman.putExtra("Check", 1);
                        toHuman.putExtra("DistrictId", DistrictId);
                        toHuman.putExtra("AreaId", AreaId);
                        startActivity(toHuman);
                    }
                    else {
                        intent.putExtra("CityId", i);
                        intent.putExtra("DistrictId", DistrictId);
                        intent.putExtra("AreaId", AreaId);
                        startActivity(intent);
                    }
                    finish();
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CityActivity.this.adapter.getFilter().filter(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent city = new Intent(this, DistrictActivity.class);
        city.putExtra("AreaId", AreaId);
        startActivity(city);
        finish();
    }
}