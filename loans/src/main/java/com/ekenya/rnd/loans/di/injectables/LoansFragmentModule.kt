package com.ekenya.rnd.loans.di.injectables

import androidx.lifecycle.ViewModel
import com.ekenya.rnd.baseapp.di.ViewModelKey
import com.ekenya.rnd.loans.main.PageViewModel
import com.ekenya.rnd.loans.main.PlaceholderFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class LoansFragmentModule {

    @ContributesAndroidInjector(modules = [LoansPlaceholderFragmentModule::class])
    abstract fun contributeLoansPlaceholderFragment(): PlaceholderFragment

    @Module
    abstract class LoansPlaceholderFragmentModule {
        @Binds
        @IntoMap
        @ViewModelKey(PageViewModel::class)
        abstract fun bindPageViewModel(viewModel: PageViewModel): ViewModel
    }

    //LIST THE OTHER INJECTABLE FRAGMENTS AS ABOVE
}
