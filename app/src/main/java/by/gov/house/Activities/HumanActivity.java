package by.gov.house.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import by.gov.house.InformationModel.Information;
import by.gov.house.R;

import static by.gov.house.Activities.SplashActivity.deputatsDictionary;
import static by.gov.house.Activities.SplashActivity.republicsDictionary;

public class HumanActivity extends AppCompatActivity {

    int check, StreetId, CityId, DistrictId, AreaId, id;
    Information information;
    TextView name1, name2, name3, okrug, phone, email, site, bio, helper;
    ImageButton vk, facebook, instagram, twitter, ok, youtube, telegram;
    ImageView photo, Iphone, Iemail, Iweb;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_home_24);

        Bundle arguments = getIntent().getExtras();
        check = arguments.getInt("Check");
        id = arguments.getInt("Position");
        AreaId = arguments.getInt("AreaId");
        DistrictId = arguments.getInt("DistrictId");
        CityId = arguments.getInt("CityId");
        StreetId = arguments.getInt("StreetId");

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
        okrug = findViewById(R.id.okrug);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        site = findViewById(R.id.site);
        bio = findViewById(R.id.bio);
        photo = findViewById(R.id.photo);
        helper = findViewById(R.id.helper);
        vk = findViewById(R.id.vk);
        facebook = findViewById(R.id.facebook);
        instagram = findViewById(R.id.instagram);
        twitter = findViewById(R.id.twitter);
        ok = findViewById(R.id.ok);
        youtube = findViewById(R.id.youtube);
        telegram = findViewById(R.id.telegram);
        Iphone = findViewById(R.id.iphone);
        Iemail = findViewById(R.id.iemail);
        Iweb = findViewById(R.id.isite);
        if(arguments.getBoolean("bool")) {
            information = deputatsDictionary.get(arguments.getString("id"));
            setTitle(R.string.title_dashboard);
        }
        else {
            information = republicsDictionary.get(arguments.getString("id"));
            setTitle(R.string.title_home);
        }
        photo.setImageResource(getResources().getIdentifier("drawable/"+information.image, null, getPackageName()));
        okrug.setText(information.okrug);
        name1.setText(information.name1);
        name2.setText(information.name2);
        name3.setText(information.name3);
        if (information.phone == null && information.email == null && information.site == null)
        {
            CardView contacs = findViewById(R.id.contacts);
            contacs.setVisibility(View.GONE);
        }
        else
        {
            if (information.phone != null)
                phone.setText(information.phone);
            else
            {
                phone.setVisibility(View.GONE);
                Iphone.setVisibility(View.GONE);
            }
            if (information.email != null)
                email.setText(information.email);
            else
            {
                email.setVisibility(View.GONE);
                Iemail.setVisibility(View.GONE);
            }
            if (information.site != null)
                site.setText(information.site);
            else
            {
                site.setVisibility(View.GONE);
                Iweb.setVisibility(View.GONE);
            }
        }
        if (information.helper == null)
        {
            CardView helpers = findViewById(R.id.helpers);
            helpers.setVisibility(View.GONE);
        }
        else
            helper.setText(information.helper);

        bio.setText(information.bio);
        if (information.vk == null && information.facebook == null && information.instagram == null && information.twitter == null && information.ok == null && information.youtube == null && information.telegram == null)
        {
            CardView social = findViewById(R.id.social);
            social.setVisibility(View.GONE);
        }
        else
        {
            if (information.vk == null)
                vk.setVisibility(View.GONE);

            if (information.facebook == null)
                facebook.setVisibility(View.GONE);

            if (information.instagram == null)
                instagram.setVisibility(View.GONE);

            if (information.twitter == null)
                twitter.setVisibility(View.GONE);

            if (information.ok == null)
                ok.setVisibility(View.GONE);

            if (information.youtube == null)
                youtube.setVisibility(View.GONE);

            if (information.telegram == null)
                telegram.setVisibility(View.GONE);
        }

        vk.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + information.vk));
            startActivity(intent);
        });

        telegram.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + information.telegram));
            startActivity(intent);
        });

        instagram.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + information.instagram));
            startActivity(intent);
        });

        facebook.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + information.facebook));
            startActivity(intent);
        });

        twitter.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + information.twitter));
            startActivity(intent);
        });

        ok.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + information.ok));
            startActivity(intent);
        });

        youtube.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + information.youtube));
            startActivity(intent);
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (check == 1)
        {
            Intent intent = new Intent (this, CityActivity.class);
            intent.putExtra("DistrictId", DistrictId);
            intent.putExtra("AreaId", AreaId);
            startActivity(intent);
        }
        else if (check == 2)
        {
            Intent intent = new Intent (this, HouseActivity.class);
            intent.putExtra("StreetId", StreetId);
            intent.putExtra("CityId", CityId);
            intent.putExtra("DistrictId", DistrictId);
            intent.putExtra("AreaId", AreaId);
            startActivity(intent);
        }
        else if(check == 3)
        {
            Intent intent = new Intent(this, SovietFindPage2.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);
        }
        this.finish();
    }
}