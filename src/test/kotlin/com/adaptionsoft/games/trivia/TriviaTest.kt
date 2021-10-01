package com.adaptionsoft.games.trivia

import com.adaptionsoft.games.trivia.runner.main
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class TriviaTest {

    @Test
    fun `Trivia should print game result`() {
        val output = ClassLoader.getSystemResource("output.txt").readText()

        main()

        assertThat(output).isEqualTo(outputStreamCaptor)
    }

    val outputStreamCaptor = ""

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        val standardOut = null
        System.setOut(standardOut)
    }
}
