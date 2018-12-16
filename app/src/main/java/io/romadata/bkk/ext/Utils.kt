/** This is extension functions */
@file:JvmName("Utils")
package io.romadata.bkk.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * see https://qiita.com/yuichi_araki/items/f9b0778f927bccdf08ca
 */
fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, androidx.lifecycle.Observer {
        it?.let(observer)
    })
}