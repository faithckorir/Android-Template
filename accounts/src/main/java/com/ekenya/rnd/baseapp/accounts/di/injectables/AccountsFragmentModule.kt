package com.ekenya.rnd.baseapp.accounts.di.injectables

import androidx.lifecycle.ViewModel
import com.ekenya.rnd.baseapp.accounts.ui.LoginDialogFragment
import com.ekenya.rnd.baseapp.accounts.ui.LoginViewModel
import com.ekenya.rnd.baseapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class AccountsFragmentModule {

    @ContributesAndroidInjector(modules = [AccountsLoginDialogFragmentModule::class])
    abstract fun contributeLoginDialogFragment(): LoginDialogFragment

    @Module
    abstract class AccountsLoginDialogFragmentModule {
        @Binds
        @IntoMap
        @ViewModelKey(LoginViewModel::class)
        abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
    }


//    @ContributesAndroidInjector(modules = [AccountsAccountItemListFragmentModule::class])
//    abstract fun contributeAccountItemListFragment(): AccountItemListFragment
//
//    @Module
//    abstract class AccountsAccountItemListFragmentModule {
//        @Binds
//        @IntoMap
//        @ViewModelKey(AccountsViewModel::class)
//        abstract fun bindPageViewModel(viewModel: AccountsViewModel): ViewModel
//    }
    //LIST THE OTHER INJECTABLE FRAGMENTS AS ABOVE
}
