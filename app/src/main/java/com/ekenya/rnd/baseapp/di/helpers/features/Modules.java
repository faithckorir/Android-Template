package com.ekenya.rnd.baseapp.di.helpers.features;

import com.ekenya.rnd.common.Constants;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Modules {


    private static final List<FeatureModule> modules;

    public static final Modules INSTANCE;

    public final FeatureModule getModuleFromName(String moduleName) {

        Iterator var4 = modules.iterator();

        FeatureModule it;
        do {
            if (!var4.hasNext()) {
                throw new IllegalArgumentException(moduleName + " is not found");
            }
            Object element$iv = var4.next();
            it = (FeatureModule) element$iv;
        } while (!it.getName().equalsIgnoreCase(moduleName));

        return it;
    }

    private Modules() {
    }

    static {
        Modules var0 = new Modules();
        INSTANCE = var0;
        modules = Arrays.asList(new FeatureModule[]{(FeatureModule) FeatureLoans.INSTANCE,
                (FeatureModule) FeaturePaybills.INSTANCE,
                (FeatureModule) FeatureAccounts.INSTANCE}.clone()
        );
    }

    public static final class FeatureLoans implements FeatureModule {

        private static final String name;

        private static final String injectorName;

        public static final FeatureLoans INSTANCE;

        public String getName() {
            return name;
        }

        public String getInjectorName() {
            return injectorName;
        }

        private FeatureLoans() {
        }

        static {
            FeatureLoans var0 = new FeatureLoans();
            INSTANCE = var0;
            name = "loans";
            injectorName = Constants.BASE_PACKAGE_NAME+".loans.di.LoansInjector";
        }
    }

    public static final class FeaturePaybills implements FeatureModule {

        private static final String name;

        private static final String injectorName;

        public static final FeaturePaybills INSTANCE;

        public String getName() {
            return name;
        }

        public String getInjectorName() {
            return injectorName;
        }

        private FeaturePaybills() {
        }

        static {
            FeaturePaybills var0 = new FeaturePaybills();
            INSTANCE = var0;
            name = "paybills";
            injectorName = Constants.BASE_PACKAGE_NAME+".paybills.di.PaybillsInjector";
        }
    }

    public static final class FeatureAccounts implements FeatureModule {

        private static final String name;

        private static final String injectorName;

        public static final FeatureAccounts INSTANCE;

        public String getName() {
            return name;
        }

        public String getInjectorName() {
            return injectorName;
        }

        private FeatureAccounts() {
        }

        static {
            FeatureAccounts var0 = new FeatureAccounts();
            INSTANCE = var0;
            name = "accounts";
            injectorName = Constants.BASE_PACKAGE_NAME+".accounts.di.AccountsInjector";
        }
    }
}
