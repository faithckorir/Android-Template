package com.ekenya.rnd.loans.di

import com.ekenya.rnd.baseapp.di.AppComponent
import com.ekenya.rnd.baseapp.di.ModuleScope
import com.ekenya.rnd.baseapp.di.injectables.ViewModelModule
import com.ekenya.rnd.loans.di.injectables.LoansActivityModule
import com.ekenya.rnd.loans.di.injectables.LoansFragmentModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@ModuleScope
@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        AndroidSupportInjectionModule::class,
        LoansActivityModule::class,
        LoansFragmentModule::class,
        ViewModelModule::class
    ]
)
interface LoansComponent {
    fun inject(injector: LoansInjector)
}