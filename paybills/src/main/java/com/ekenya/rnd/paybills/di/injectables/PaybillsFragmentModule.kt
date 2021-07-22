package com.ekenya.rnd.paybills.di.injectables

import androidx.lifecycle.ViewModel
import com.ekenya.rnd.baseapp.di.ViewModelKey
import com.ekenya.rnd.paybills.ui.dashboard.DashboardFragment
import com.ekenya.rnd.paybills.ui.dashboard.DashboardViewModel
import com.ekenya.rnd.paybills.ui.notifications.NotificationDetailFragment
import com.ekenya.rnd.paybills.ui.notifications.NotificationsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PaybillsFragmentModule {

    @ContributesAndroidInjector(modules = [PaybillsDashboardFragmentModule::class])
    abstract fun contributeDashboardFragment(): DashboardFragment

    @Module
    abstract class PaybillsDashboardFragmentModule {
        @Binds
        @IntoMap
        @ViewModelKey(DashboardViewModel::class)
        abstract fun bindDashboardViewModel(viewModel: DashboardViewModel): ViewModel
    }

    @ContributesAndroidInjector(modules = [PaybillsNotificationDetailFragmentModule::class])
    abstract fun contributeNotificationDetailFragment(): NotificationDetailFragment

    @Module
    abstract class PaybillsNotificationDetailFragmentModule {
        @Binds
        @IntoMap
        @ViewModelKey(NotificationsViewModel::class)
        abstract fun bindNotificationsViewModel(viewModel: NotificationsViewModel): ViewModel
    }

    //LIST THE OTHER INJECTABLE FRAGMENTS AS ABOVE
}
