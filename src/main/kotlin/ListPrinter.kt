package org.example

import org.example.list.CustomArrayList
import org.example.list.CustomList

object ListPrinter {
    fun printList(list: CustomList) {
        for (element in list) {
            print("$element ")
        }
        println()
    }
}