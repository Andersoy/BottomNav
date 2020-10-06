package com.example.bottomnav;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MeetingFragment extends ListFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //return inflater.inflate(R.layout.fragment_meetings, container, false);

        View rootView = inflater.inflate(R.layout.fragment_meetings, container,
                false);

       // ArrayList<Array> values = 1 ;
        //ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getActivity(),
         //       android.R.layout.simple_list_item_1, values);
        //setListAdapter(adapter);
        return rootView;


    }
}
