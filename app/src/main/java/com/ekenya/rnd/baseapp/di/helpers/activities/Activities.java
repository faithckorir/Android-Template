package com.ekenya.rnd.baseapp.di.helpers.activities;


import com.ekenya.rnd.common.Constants;

// Activities.java
public final class Activities {

    public static final Activities INSTANCE;

    private Activities() {
    }

    static {
        Activities var0 = new Activities();
        INSTANCE = var0;
    }

    public static final class FeaturePaybills implements AddressableActivity {

        private static final String className;

        public static final FeaturePaybills INSTANCE;

        public String getClassName() {
            return className;
        }

        private FeaturePaybills() {
        }

        static {
            FeaturePaybills var0 = new FeaturePaybills();
            INSTANCE = var0;
            className = Constants.BASE_PACKAGE_NAME +".paybills.MainActivity";
        }
    }

    public static final class FeatureLoans implements AddressableActivity {

        private static final String className;

        public static final FeatureLoans INSTANCE;


        public String getClassName() {
            return className;
        }

        private FeatureLoans() {
        }

        static {
            FeatureLoans var0 = new FeatureLoans();
            INSTANCE = var0;
            //
            className = Constants.BASE_PACKAGE_NAME +".loans.MainActivity";
        }
    }

    public static final class FeatureAccounts implements AddressableActivity {

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
            //
            className = Constants.BASE_PACKAGE_NAME +".accounts.LoginActivity";
        }
    }
}
