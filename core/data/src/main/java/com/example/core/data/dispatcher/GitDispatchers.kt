package com.example.core.data.dispatcher

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GitDispatchers @Inject constructor() {
    val ioDispatcher = Dispatchers.IO
    val mainDispatcher = Dispatchers.Main
}