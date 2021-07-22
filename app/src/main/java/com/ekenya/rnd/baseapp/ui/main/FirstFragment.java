package com.ekenya.rnd.baseapp.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ekenya.rnd.baseapp.DemoApplication;
import com.ekenya.rnd.baseapp.R;
import com.ekenya.rnd.baseapp.databinding.FragmentFirstBinding;
import com.ekenya.rnd.baseapp.di.helpers.activities.Activities;
import com.ekenya.rnd.baseapp.di.helpers.activities.ActivityHelperKt;
import com.ekenya.rnd.baseapp.di.helpers.activities.AddressableActivity;
import com.ekenya.rnd.baseapp.di.helpers.features.FeatureModule;
import com.ekenya.rnd.baseapp.di.helpers.features.Modules;
import com.ekenya.rnd.baseapp.di.helpers.fragments.FragmentHelperKt;
import com.ekenya.rnd.baseapp.di.helpers.fragments.Fragments;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;


public class FirstFragment extends Fragment {

    private DemoApplication mApp;

    private SplitInstallManager splitInstallManager;

    private FragmentFirstBinding binding;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;


    private SplitInstallStateUpdatedListener listener = new SplitInstallStateUpdatedListener() {
        @Override
        public void onStateUpdate(@NonNull @NotNull SplitInstallSessionState state) {
            switch (state.status()){
                case SplitInstallSessionStatus.DOWNLOADING:
                    //
                    setStatus("DOWNLOADING");
                    break;
                case SplitInstallSessionStatus.INSTALLING:
                    //
                    setStatus("INSTALLING");
                    break;
                case SplitInstallSessionStatus.INSTALLED :
                    //
                    // Enable module immediately
                    SplitCompat.install(getActivity());

                    setStatus("INSTALLED");
                    navigateModule(state.moduleNames().get(0),true);
                    break;
                case SplitInstallSessionStatus.FAILED :
                    //
                    setStatus("FAILED");
                    break;
            }
        }
    };

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        splitInstallManager =  SplitInstallManagerFactory.create(getActivity());
        //
        mApp = (DemoApplication) getActivity().getApplication();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                //Push To Paybills
                loadModule(Modules.FeatureAccounts.INSTANCE,true);
            }
        });
        binding.buttonAccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadModule(Modules.FeatureAccounts.INSTANCE,false);
            }
        });

        binding.buttonLoans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Push To Paybills
                loadModule(Modules.FeatureLoans.INSTANCE,false);
            }
        });

        binding.buttonPaybills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Push To Paybills
                loadModule(Modules.FeaturePaybills.INSTANCE,false);
            }
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        splitInstallManager.registerListener(listener);
    }

    @Override
    public void onPause() {
        splitInstallManager.unregisterListener(listener);
        super.onPause();
    }
    private void setStatus(String label){
        //
        binding.moduleStatus.setText(label);
        //
        int SPLASH_DISPLAY_LENGTH = 20000;
        new Handler().postDelayed(() -> binding.moduleStatus.setText("~"), SPLASH_DISPLAY_LENGTH);
    }

    private void loadModule(FeatureModule module,boolean lauchFragment ) {
        //
        if (splitInstallManager.getInstalledModules().contains(module.getName())) {
            Log.d("",module.getName()+" already installed");
            setStatus(module.getName()+" already installed");
            navigateModule(module.getName(),lauchFragment);
            return;
        }
        //
        SplitInstallRequest request = SplitInstallRequest
                .newBuilder()
                .addModule(module.getName())
                .build();
        //
        splitInstallManager.startInstall(request);
        Log.d("","Start install for "+module.getName());
        setStatus("Start install for "+module.getName());
    }
    /**
     * Method opens the Support Module from main app
     *
     * @param moduleName the class declaration for the Activity Class of the module
     */
    private void navigateModule(String moduleName,boolean launchFragment) {
        try {

            FeatureModule module = Modules.INSTANCE.getModuleFromName(moduleName);

            //Inject
            mApp.addModuleInjector(module);
            //
            if(module.getName().equalsIgnoreCase(Modules.FeatureLoans.INSTANCE.getName())){
                //
                this.startActivity(ActivityHelperKt.intentTo(getActivity(),(AddressableActivity) Activities.FeatureLoans.INSTANCE));
                //finish();
            }else if(module.getName().equalsIgnoreCase(Modules.FeaturePaybills.INSTANCE.getName())){
                //
                this.startActivity(ActivityHelperKt.intentTo(getActivity(),(AddressableActivity) Activities.FeaturePaybills.INSTANCE));
                //finish();
            }else if(launchFragment) {
                //
                Fragment fragment = FragmentHelperKt.newFragment(Fragments.FeatureAccounts.INSTANCE);
                //
                if (fragment instanceof BottomSheetDialogFragment) {
                    BottomSheetDialogFragment dialogFragment = (BottomSheetDialogFragment) fragment;
                    dialogFragment.show(getChildFragmentManager(), "loginFragment");
                } else {
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                }
            }else{
                this.startActivity(ActivityHelperKt.intentTo(getActivity(),(AddressableActivity) Activities.FeatureAccounts.INSTANCE));
                //finish();

            }
        } catch (Exception e) {
            Log.d("SplashActivity", e.getMessage());
        }

    }
}