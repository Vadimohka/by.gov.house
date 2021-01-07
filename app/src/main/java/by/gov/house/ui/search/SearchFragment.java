package by.gov.house.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import by.gov.house.Activities.RegionActivity;
import by.gov.house.Activities.SovietFindPage;
import by.gov.house.Activities.SplashActivity;
import by.gov.house.R;

public class SearchFragment extends Fragment {

    Button finddeputat, findsoviet;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        finddeputat = root.findViewById(R.id.find);
        findsoviet = root.findViewById(R.id.findsoviet);

        if(!SplashActivity.json)
        {
            finddeputat.setVisibility(View.GONE);
            Runnable runnable = () -> {
                while (!SplashActivity.json){}
                finddeputat.post(() -> finddeputat.setVisibility(View.VISIBLE));
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }

        findsoviet.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SovietFindPage.class);
            startActivity(intent);
            getActivity().finish();
        });

        finddeputat.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RegionActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        return root;
    }
}