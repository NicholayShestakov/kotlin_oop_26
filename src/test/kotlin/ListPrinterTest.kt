import org.example.ListPrinter.printList
import org.example.list.CustomArrayList
import org.example.list.SingleLinkedList
import org.example.stack.ArrayListStack
import org.example.stack.SingleLinkedStack
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ListPrinterTest {

    val originalOut: PrintStream? = System.out
    val testOut = ByteArrayOutputStream()

    @BeforeEach
    fun changeOutputStream() {
        System.setOut(PrintStream(testOut))
    }

    @Test
    fun `empty single linked list print`() {
        val list = SingleLinkedList()
        printList(list)
        assertEquals("\n", testOut.toString())
    }

    @Test
    fun `empty custom array list print`() {
        val list = CustomArrayList(0)
        printList(list)
        assertEquals("\n", testOut.toString())
    }

    @Test
    fun `empty single linked stack print`() {
        val stack = SingleLinkedStack()
        printList(stack)
        assertEquals("\n", testOut.toString())
    }

    @Test
    fun `empty array list stack print`() {
        val stack = ArrayListStack()
        printList(stack)
        assertEquals("\n", testOut.toString())
    }

    @Test
    fun `single linked list print`() {
        val list = SingleLinkedList()
        list.add(1)
        list.add(2)
        list.add(3)
        printList(list)
        assertEquals("1 2 3 \n", testOut.toString())
    }

    @Test
    fun `custom array list print`() {
        val list = CustomArrayList(0)
        list.add(1)
        list.add(2)
        list.add(3)
        printList(list)
        assertEquals("1 2 3 \n", testOut.toString())
    }

    @Test
    fun `single linked stack print`() {
        val stack = SingleLinkedStack()
        stack.add(1)
        stack.add(2)
        stack.add(3)
        printList(stack)
        assertEquals("1 2 3 \n", testOut.toString())
    }

    @Test
    fun `array list stack print`() {
        val stack = ArrayListStack()
        stack.add(1)
        stack.add(2)
        stack.add(3)
        printList(stack)
        assertEquals("1 2 3 \n", testOut.toString())
    }

    @AfterEach
    fun returnOriginalOutputStream() {
        System.setOut(originalOut)
    }
}