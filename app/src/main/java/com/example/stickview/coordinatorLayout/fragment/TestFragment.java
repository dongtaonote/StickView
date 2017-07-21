package com.example.stickview.coordinatorLayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stickview.R;
import com.example.stickview.coordinatorLayout.adapter.MyRecycleAdapter;
import com.example.stickview.commonview.FullLinearLayout;

public class TestFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragmentcontent, null, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleview);

        LinearLayoutManager fullLinearLayout = new FullLinearLayout(getContext(), FullLinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(fullLinearLayout);
        recyclerView.getLayoutManager().setAutoMeasureEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);

        MyRecycleAdapter adapter = new MyRecycleAdapter(getContext());
        recyclerView.setAdapter(adapter);

        return rootView;
    }


    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

}
