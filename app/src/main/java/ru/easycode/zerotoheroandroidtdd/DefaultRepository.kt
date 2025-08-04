package ru.easycode.zerotoheroandroidtdd

import javax.inject.Inject

class DefaultRepository @Inject constructor():Repository {
    override suspend fun load() {
        super.load()
    }
}