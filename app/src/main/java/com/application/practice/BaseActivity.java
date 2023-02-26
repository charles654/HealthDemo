package com.application.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.practice.bottomNavigationOne.BottomNavOne;
import com.application.practice.coinToss.PractiseActivity;
import com.application.practice.databinding.BaseActivityBinding;
import com.application.practice.databinding_Sqlite.addUser.AddUserDetailsActivity;
import com.application.practice.mvvmDemo.view.MainActivity;
import com.application.practice.sha_256.Sha_256;
import com.application.practice.xlsExport.XlsExportActivity;
import com.application.practice.xml_pdf.XmlToPdf;

/**
 * Created by Charles Raj I on 07/05/22.
 *
 * @author Charles Raj I
 */
public class BaseActivity extends AppCompatActivity {

    Activity activity;
    BaseActivityBinding baseActivityBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = BaseActivity.this;
        baseActivityBinding = BaseActivityBinding.inflate(getLayoutInflater());
        setContentView(baseActivityBinding.getRoot());


        baseActivityBinding.mvvmDemo.setOnClickListener(view -> {
            Intent tossIntent = new Intent(activity, MainActivity.class);
            startActivity(tossIntent);
        });

        baseActivityBinding.coinToss.setOnClickListener(view -> {
            Intent tossIntent = new Intent(activity, PractiseActivity.class);
            startActivity(tossIntent);
        });

        baseActivityBinding.bottomNavOne.setOnClickListener(view -> {
            Intent bottomOne = new Intent(activity, BottomNavOne.class);
            startActivity(bottomOne);
        });

        baseActivityBinding.sha256.setOnClickListener(view -> {
            Intent bottomOne = new Intent(activity, Sha_256.class);
            startActivity(bottomOne);
        });
        baseActivityBinding.xmlPdf.setOnClickListener(view -> {
            Intent xmlPdfIntent = new Intent(activity, XmlToPdf.class);
            startActivity(xmlPdfIntent);
        });
        baseActivityBinding.sqlDatabindingRxjava.setOnClickListener(view -> {
            Intent sqliteDataBinding = new Intent(activity, AddUserDetailsActivity.class);
            startActivity(sqliteDataBinding);
        });

        baseActivityBinding.xlsExport.setOnClickListener(view -> {
            Intent xlsIntent = new Intent(activity, XlsExportActivity.class);
            startActivity(xlsIntent);
        });

    }
}
