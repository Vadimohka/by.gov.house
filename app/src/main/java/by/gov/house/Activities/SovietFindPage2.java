package by.gov.house.Activities;

import androidx.appcompat.app.AppCompatActivity;

import by.gov.house.Adapters.SovietHumanAdapter;
import by.gov.house.Models.Human;
import by.gov.house.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SovietFindPage2 extends AppCompatActivity {

    ArrayList<Human> humans = new ArrayList<>();
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soviet_find_page2);
        setTitle("Члены Совета Республики");

        Bundle arguments = getIntent().getExtras();
        pos = arguments.getInt("id");
        InsertHuman(pos);

        ListView lv = findViewById(R.id.findsoviet2);
        SovietHumanAdapter adapter = new SovietHumanAdapter(this, humans);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, v, position, id) ->{
            Intent intent = new Intent(this, HumanActivity.class);
            intent.putExtra("Position", pos);
            intent.putExtra("id", adapter.getItem(position).id);
            intent.putExtra("Check", 3);
            startActivity(intent);
            this.finish();
        });
    }

    private void InsertHuman(int id)
    {
        humans.clear();
        switch (id)
        {
            case 0:
                humans.add(SplashActivity.republicsNameList.get(19));
                humans.add(SplashActivity.republicsNameList.get(28));
                humans.add(SplashActivity.republicsNameList.get(30));
                humans.add(SplashActivity.republicsNameList.get(36));
                humans.add(SplashActivity.republicsNameList.get(43));
                humans.add(SplashActivity.republicsNameList.get(50));
                humans.add(SplashActivity.republicsNameList.get(52));
                humans.add(SplashActivity.republicsNameList.get(55));
                break;
            case 1:
                humans.add(SplashActivity.republicsNameList.get(9));
                humans.add(SplashActivity.republicsNameList.get(10));
                humans.add(SplashActivity.republicsNameList.get(13));
                humans.add(SplashActivity.republicsNameList.get(24));
                humans.add(SplashActivity.republicsNameList.get(29));
                humans.add(SplashActivity.republicsNameList.get(32));
                humans.add(SplashActivity.republicsNameList.get(34));
                humans.add(SplashActivity.republicsNameList.get(56));
                break;
            case 2:
                humans.add(SplashActivity.republicsNameList.get(0));
                humans.add(SplashActivity.republicsNameList.get(21));
                humans.add(SplashActivity.republicsNameList.get(27));
                humans.add(SplashActivity.republicsNameList.get(31));
                humans.add(SplashActivity.republicsNameList.get(46));
                humans.add(SplashActivity.republicsNameList.get(47));
                humans.add(SplashActivity.republicsNameList.get(53));
                humans.add(SplashActivity.republicsNameList.get(58));
                break;
            case 3:
                humans.add(SplashActivity.republicsNameList.get(3));
                humans.add(SplashActivity.republicsNameList.get(7));
                humans.add(SplashActivity.republicsNameList.get(25));
                humans.add(SplashActivity.republicsNameList.get(38));
                humans.add(SplashActivity.republicsNameList.get(44));
                humans.add(SplashActivity.republicsNameList.get(48));
                humans.add(SplashActivity.republicsNameList.get(54));
                break;
            case 4:
                humans.add(SplashActivity.republicsNameList.get(1));
                humans.add(SplashActivity.republicsNameList.get(2));
                humans.add(SplashActivity.republicsNameList.get(5));
                humans.add(SplashActivity.republicsNameList.get(12));
                humans.add(SplashActivity.republicsNameList.get(20));
                humans.add(SplashActivity.republicsNameList.get(23));
                humans.add(SplashActivity.republicsNameList.get(33));
                humans.add(SplashActivity.republicsNameList.get(35));
                break;
            case 5:
                humans.add(SplashActivity.republicsNameList.get(4));
                humans.add(SplashActivity.republicsNameList.get(6));
                humans.add(SplashActivity.republicsNameList.get(8));
                humans.add(SplashActivity.republicsNameList.get(14));
                humans.add(SplashActivity.republicsNameList.get(18));
                humans.add(SplashActivity.republicsNameList.get(26));
                humans.add(SplashActivity.republicsNameList.get(49));
                humans.add(SplashActivity.republicsNameList.get(57));
                break;
            case 6:
                humans.add(SplashActivity.republicsNameList.get(11));
                humans.add(SplashActivity.republicsNameList.get(15));
                humans.add(SplashActivity.republicsNameList.get(16));
                humans.add(SplashActivity.republicsNameList.get(39));
                humans.add(SplashActivity.republicsNameList.get(40));
                humans.add(SplashActivity.republicsNameList.get(41));
                humans.add(SplashActivity.republicsNameList.get(45));
                humans.add(SplashActivity.republicsNameList.get(51));
                break;
            case 7:
                humans.add(SplashActivity.republicsNameList.get(17));
                humans.add(SplashActivity.republicsNameList.get(22));
                humans.add(SplashActivity.republicsNameList.get(37));
                humans.add(SplashActivity.republicsNameList.get(42));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, SovietFindPage.class);
        startActivity(intent);
        finish();
    }
}