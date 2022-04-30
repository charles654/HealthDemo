package com.application.practice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;


import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.application.practice.adapter.DataAdapter;
import com.application.practice.databinding.ActivityMainBinding;
import com.application.practice.model.DataResponse;
import com.application.practice.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements LifecycleOwner{

    MainActivity context;
    ActivityMainBinding activityMainBinding;
    MainActivityViewModel mainActivityViewModel;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        dataAdapter = new DataAdapter(context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        activityMainBinding.mainRecyclerview.setLayoutManager(layoutManager);
        activityMainBinding.mainRecyclerview.setAdapter(dataAdapter);

        mainActivityViewModel = ViewModelProviders.of(context).get(MainActivityViewModel.class);
        mainActivityViewModel.getUserMutableLiveData().observe(context, userListUpdateObserver);
    }

    /*Observe the live data from the view model*/
    Observer<DataResponse> userListUpdateObserver = new Observer<DataResponse>() {
        @Override
        public void onChanged(DataResponse dataResponse) {
            dataAdapter.setDataResponse(dataResponse);
        }
    };
}