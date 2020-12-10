package by.gov.house.ui.deputats;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import by.gov.house.Activities.HumanActivity;
import by.gov.house.Adapters.HumanAdapter;
import by.gov.house.R;
import by.gov.house.Activities.SplashActivity;


public class DeputatsFragment extends Fragment {

    EditText editText;
    HumanAdapter adapter;
    ImageButton clear;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_deputats, container, false);
        GridView GList = root.findViewById(R.id.gridview_deputats);
        adapter = new HumanAdapter(root.getContext(), SplashActivity.deputatsNameList);
        GList.setAdapter(adapter);

        GList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(root.getContext(), HumanActivity.class);
                intent.putExtra("id", adapter.getItem(position).id);
                intent.putExtra("bool", true);
                startActivity(intent);
                getActivity().finish();
            }
        });

        editText = root.findViewById(R.id.search_deputat);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                DeputatsFragment.this.adapter.getFilter().filter(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        clear = root.findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.setText("");
            }
        });

        return root;
    }

}