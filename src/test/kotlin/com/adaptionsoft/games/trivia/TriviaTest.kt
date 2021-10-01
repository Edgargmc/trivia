package com.adaptionsoft.games.trivia

import com.adaptionsoft.games.trivia.runner.playGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*


class TriviaTest {
    @Test
    fun `should print game result`() {
        val output = ClassLoader.getSystemResource("output.txt").readText()

        val randomRecorder = FixedRandom()
        playGame(randomRecorder)

        val gameOutput = addInvertedCommas()

        assertThat(output).isEqualTo(gameOutput.toString())
    }

    private fun addInvertedCommas(): StringBuilder {
        val builder = StringBuilder()
        builder.append("")
            .append(outputStreamCaptor)
            .append("")
        return builder
    }

    private val outputStreamCaptor = ByteArrayOutputStream()

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

class FixedRandom: Random() {
    private val numbers = mutableListOf(0, 7, 0, 2, 3, 4, 0, 7, 1, 5, 1, 0, 2, 8, 0, 4, 4, 6, 4, 5, 4, 0, 3, 4, 1, 2, 3, 1, 4, 8, 3, 2, 0, 1)

    override fun nextInt(bound: Int): Int {
        val number = numbers[0]
        numbers.removeFirst()
        return number
    }
}

class RandomRecorder: Random() {
    val randomNumberList = mutableListOf<Int>()

    override fun nextInt(bound: Int): Int {
        val number = super.nextInt(bound)
        randomNumberList.add(number)
        return number
    }
}
