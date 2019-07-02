package com.demo.thinr

import org.junit.Test

import org.junit.Assert.*
import java.util.regex.Pattern

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val REGEX_R_CLASS = ".*R\\\$.*\\.class|.*R\\.class"


    @Test
    fun addition_isCorrect() {
        println(isRClass("R$'fskafk'.class"))
    }

    private fun isRClass(classFilePath: String): Boolean {
        return Pattern.matches(REGEX_R_CLASS, classFilePath)
    }
}
