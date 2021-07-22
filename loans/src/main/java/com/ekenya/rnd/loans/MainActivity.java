package com.ekenya.rnd.loans;

import android.os.Bundle;

//import com.ekenya.android.lib.EncryptionService;
//import com.ekenya.android.lib.EncryptionServiceImpl;
import com.ekenya.rnd.common.abstractions.BaseActivity;
import com.ekenya.rnd.loans.databinding.ActivityLoansBinding;
import com.ekenya.rnd.loans.main.adapters.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;

import android.view.View;


public class MainActivity extends BaseActivity {

    private ActivityLoansBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoansBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        //EncryptionService encryptionService = new EncryptionServiceImpl();

        //.....

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}