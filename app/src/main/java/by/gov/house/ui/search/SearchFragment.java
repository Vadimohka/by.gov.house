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
import by.gov.house.Activities.SplashActivity;
import by.gov.house.R;

public class SearchFragment extends Fragment {

    Button find;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        find = root.findViewById(R.id.find);
        if(!SplashActivity.json)
        {
            find.setVisibility(View.GONE);
            Runnable runnable = new Runnable() {
                public void run() {
                    while (!SplashActivity.json){
                    }
                    find.post(new Runnable() {
                        @Override
                        public void run() {
                            find.setVisibility(View.VISIBLE);
                        }
                    });
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }

        find = root.findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegionActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return root;
    }
}