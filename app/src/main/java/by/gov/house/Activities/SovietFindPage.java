package by.gov.house.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import by.gov.house.R;

public class SovietFindPage extends AppCompatActivity {

    ArrayList<String> area = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soviet_find_page);
        setTitle("Выбор области");

        insertArea();

        ListView lv = findViewById(R.id.findsoviet);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, area);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((parent, v, position, id) ->{
            Intent intent = new Intent(this, SovietFindPage2.class);
            intent.putExtra("id", position);
            startActivity(intent);
            finish();
        });

    }

    private void insertArea()
    {
        area.add("Брестская");
        area.add("Витебская");
        area.add("Гомельская");
        area.add("Гродненская");
        area.add("Могилёвская");
        area.add("Минская");
        area.add("Минск");
        area.add("Назначены президентом Республики Белараусь");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}