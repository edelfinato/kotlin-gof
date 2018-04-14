package org.edelf.gof

import java.util.prefs.NodeChangeEvent


class Observable {
    private val map :HashMap<Any,(Any)->Unit> = HashMap();
    fun register(key:Any, event: (Any)->Unit ){
        map.put(key,event)
    }

    fun unregister(key:Any){
        map.remove(key)
    }

    fun sendEvent(event:Any){
        map.values.forEach { it(event)}
    }
}