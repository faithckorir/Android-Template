package com.ekenya.rnd.baseapp.accounts.di

import com.ekenya.rnd.baseapp.accounts.di.injectables.AccountsActivityModule
import com.ekenya.rnd.baseapp.accounts.di.injectables.AccountsFragmentModule
import com.ekenya.rnd.baseapp.di.AppComponent
import com.ekenya.rnd.baseapp.di.ModuleScope
import com.ekenya.rnd.baseapp.di.injectables.ViewModelModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@ModuleScope
@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        AndroidSupportInjectionModule::class,
        AccountsActivityModule::class,
        AccountsFragmentModule::class,
        ViewModelModule::class
    ]
)
interface AccountsComponent {
    fun inject(injector: AccountsInjector)
}