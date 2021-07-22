package com.ekenya.rnd.baseapp.di.helpers.fragments;


import com.ekenya.rnd.common.Constants;

public final class Fragments {

    public static final Fragments INSTANCE;

    private Fragments() {
    }

    static {
        Fragments var0 = new Fragments();
        INSTANCE = var0;
    }
    public static final class FeatureAccounts implements AddressableFragment {

        private static final String className;

        public static final FeatureAccounts INSTANCE;


        public String getClassName() {
            return className;
        }

        private FeatureAccounts() {
        }

        static {
            FeatureAccounts var0 = new FeatureAccounts();
            INSTANCE = var0;
            className = Constants.BASE_PACKAGE_NAME +".accounts.ui.LoginDialogFragment";
        }
    }
}

