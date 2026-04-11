package org.example.stack

import org.example.list.CustomArrayList
import org.example.list.CustomList

class ArrayListStack(l: CustomArrayList = CustomArrayList(0)) : Stack, CustomList by l {

    override fun push(value: Int) {
        add(value)
    }

    override fun pop(): Int {
        try {
            val popped = get(size - 1)
            remove(get(size - 1))
            return popped
        } catch (_: ArrayIndexOutOfBoundsException) {
            throw NoSuchElementException()
        }
    }

    override fun peek(): Int {
        try {
            return get(size - 1)
        } catch (_: ArrayIndexOutOfBoundsException) {
            throw NoSuchElementException()
        }
    }

    override val isEmpty: Boolean
        get() {
            return size == 0
        }
}