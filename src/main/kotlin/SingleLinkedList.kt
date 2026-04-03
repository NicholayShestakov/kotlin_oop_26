package org.example

import kotlin.also

class SingleLinkedList : CustomList {

    class Node {
        var value : Int = 0
        var next : Node? = null
    }

    var begin : Node? = null

    override val size: Int
        get() {
            var cur = begin
            var count = 0
            while (cur != null) {
                cur = cur.next
                count++
            }
            return count
        }

    override fun add(element: Int) {
        val new = Node().also {
            it.value = element
            it.next = null
        }
        var cur = begin
        if (cur == null) {
            begin = new
            return
        }
        while (cur?.next != null) {
            cur = cur.next
        }
        cur?.next = new
    }

    fun getNode(index: Int): Node? {
        var cur : Node? = begin ?: return null
        if (index < 0) {
            return null
        }
        for (i in 0 until index) {
            cur = cur?.next
        }
        return cur
    }

    override operator fun set(index: Int, value: Int) {
        val cur = getNode(index) ?: throw IndexOutOfBoundsException()
        cur.value = value
    }

    override fun addFirst(element: Int) {
        val cur = Node().also {
            it.value = element
            it.next = begin
        }
        begin = cur
    }

    override operator fun get(index: Int): Int {
        return getNode(index)?.value ?: throw IndexOutOfBoundsException()
    }

    override fun indexOf(element: Int): Int {
        var cur = begin
        var index = 0
        while (cur?.next != null) {
            if (cur.value == element) {
                return index
            }
            cur = cur.next
            index++
        }
        return -1
    }

    override fun remove(element: Int): Boolean {
        var cur : Node? = begin ?: return false
        if (cur?.value == element) {
            begin = cur.next
            return true
        }
        while (cur?.next != null) {
            if (cur.next?.value == element) {
                cur.next = cur.next?.next
                return true
            }
            cur = cur.next
        }
        return false
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var cur = begin

            override fun hasNext(): Boolean {
                return cur != null
            }

            override fun next(): Int {
                val ret = cur ?: throw IndexOutOfBoundsException()
                cur = cur?.next
                return ret.value
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also{ it.add(item) }
            }
    }
}