package com.example.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    View v;
    Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.homefragment,container,false );
        RecyclerView programmingList = (RecyclerView) v.findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(v.getContext()));
        String[] languages = {"A", "B", "C"};
        programmingList.setAdapter(new ProgrammingAdapter(languages));

/*
        btn=v.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddSlotFragment addSlotFragment=new AddSlotFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AddSlotFragment()).commit();

            }
        });
*/

        btn=(Button) v.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(getView().getContext());
                final BottomNavigationView bottomNavigationView = (BottomNavigationView) getActivity().findViewById(R.id.bottom_navigation);

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog);
                Button dialog_btn=dialog.findViewById(R.id.button);
                dialog_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentTransaction transaction=getFragmentManager().beginTransaction();
                        AddSlotFragment slotFragment= new AddSlotFragment();
                        transaction.replace(R.id.fragment_container, slotFragment).commit();

                        bottomNavigationView.setSelectedItemId(R.id.nav_add);
                        dialog.cancel();
                    }
                });

                dialog.show();

            }
        });




    return v;
    }

    public void showDialog()
    {

        Dialog dialog=new Dialog(getView().getContext());
        dialog.setContentView(R.layout.dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Button dialog_btn=dialog.findViewById(R.id.button);
        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new AddSlotFragment()).commit();
            }
        });

        dialog.show();
    }
}

