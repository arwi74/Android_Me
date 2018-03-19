package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;

/**
 * Created by Arkadiusz Wilczek on 19.03.18.
 */

public class MasterListFragment extends Fragment {

    public MasterListFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_list,container,false);

        ArrayList<Integer> listIds = new ArrayList<>();
        listIds.addAll(AndroidImageAssets.getHeads());
        listIds.addAll(AndroidImageAssets.getBodies());
        listIds.addAll(AndroidImageAssets.getLegs());

        GridView gridView = (GridView) view.findViewById(R.id.master_list_grid);
        gridView.setAdapter(new MasterListAdapter(getActivity(), listIds));

        return view;
    }
}
