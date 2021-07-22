package com.ekenya.rnd.paybills.di

import com.ekenya.rnd.baseapp.di.AppComponent
import com.ekenya.rnd.baseapp.di.ModuleScope
import com.ekenya.rnd.baseapp.di.injectables.ViewModelModule
import com.ekenya.rnd.paybills.di.injectables.PaybillsActivityModule
import com.ekenya.rnd.paybills.di.injectables.PaybillsFragmentModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@ModuleScope
@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        AndroidSupportInjectionModule::class,
        PaybillsActivityModule::class,
        PaybillsFragmentModule::class,
        ViewModelModule::class
    ]
)
interface PaybillsComponent {
    fun inject(injector: PaybillsInjector)
}