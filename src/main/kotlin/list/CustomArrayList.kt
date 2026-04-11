package org.example.list

import kotlin.concurrent.thread

open class CustomArrayList(startSize: Int): CustomList {
    var inner = IntArray(startSize)
    var listSize = startSize
    var listUsed = 0

    override val size: Int
        get() {
            return listUsed
        }

    override fun add(element: Int) {
        if (listUsed == listSize) {
            resize(if (listSize == 0) 1 else listSize * 2)
        }
        inner[listUsed++] = element
    }

    override fun addFirst(element: Int) {
        if (listUsed == listSize) {
            resize(if (listSize == 0) 1 else listSize * 2)
        }
        for (i in listUsed downTo 1) {
            inner[i] = inner[i - 1]
        }
        inner[0] = element
        listUsed++
    }

    override fun set(index: Int, value: Int) {
        if (index >= listUsed) {
            throw IndexOutOfBoundsException()
        }
        inner[index] = value
    }

    override fun get(index: Int): Int {
        if (index >= listUsed) {
            throw IndexOutOfBoundsException()
        }
        return inner[index]
    }

    fun contains(element: Int): Boolean {
        for (i in 0 until listUsed) {
            if (inner[i] == element) {
                return true
            }
        }
        return false
    }

    override fun remove(element: Int): Boolean {
        for (i in 0 until listUsed) {
            if (inner[i] == element) {
                if (i == listUsed - 1) {
                    listUsed--
                    return true
                }
                for (j in i until (listUsed - 1)) {
                    inner[i] = inner[i + 1]
                }
                listUsed--
                return true
            }
        }
        return false
    }

    override fun iterator(): Iterator<Int> {
        val iterInner = IntArray(listUsed)
        for (i in 0 until listUsed) {
            iterInner[i] = inner[i]
        }
        return iterInner.iterator()
    }

    override fun indexOf(element: Int): Int {
        for (i in 0 until listUsed) {
            if (inner[i] == element) {
                return i
            }
        }
        return -1
    }

    private fun resize(newSize: Int) {
        val newInner = IntArray(newSize)
        for (i in 0 until listUsed) {
            newInner[i] = inner[i]
        }
        inner = newInner
        listSize = newSize
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}