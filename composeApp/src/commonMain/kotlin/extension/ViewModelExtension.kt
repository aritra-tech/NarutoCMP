package extension

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

fun ViewModel.runIO(function: suspend CoroutineScope.() -> Unit) =
    viewModelScope.launch(Dispatchers.IO) { function() }