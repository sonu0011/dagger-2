package com.sonu.dagger2example.example.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

private const val TAG = "ViewModelFactory"
class ViewModelFactory @Inject constructor(
    private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d(TAG, "create: $map")
        return map[modelClass] as T
    }
}

/*
    wer are using view model factory to create view model by ourself and passing the given dependencies
    in construction of viewModel . The problem with this approach ( viewModel + viewModelFactory )  is when we create view model we have to create
    the view model factory to satisfy all its dependencies and creation of viewModel is also done by ourself.  the problem with this approach is
    code is not maintainable for e.x : if wer are adding dependency in view model constructor then we also have to add in corresponding view model factory
    provider so we can create the view model by ourself we can ask dagger to inject view model in view model
    factory so we can delegate our work  to dagger. for this we have to use multi binding concept and we have to generalize the view model factory

Annotate view model class construct with @Inject so dagger can inject them . now whenever view
model provider ask view model factory to give view model object it will ask dagger to provide the
given view model we are delegation the creation of view model to dagger
 */