package com.ekenya.rnd.baseapp.di

import android.app.Activity
import androidx.fragment.app.Fragment
import com.ekenya.rnd.baseapp.DemoApplication
import dagger.android.DispatchingAndroidInjector

interface BaseModuleInjector {

    fun inject(app: DemoApplication)

    fun activityInjector(): DispatchingAndroidInjector<Activity>

    fun fragmentInjector(): DispatchingAndroidInjector<Fragment>
}
