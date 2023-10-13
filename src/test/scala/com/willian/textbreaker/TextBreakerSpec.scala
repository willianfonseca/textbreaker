package com.willian.textbreaker

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TextBreakerSpec extends AnyFlatSpec with Matchers {
  val charsLength = 40

  "breakTextInSpecifiedLengthOfCharactersLine" should "when function finds the limit of line should break the line and send the content to the next line" in {
    val text = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel. He wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."
    val result = TextBreaker.breakTextInSpecifiedLengthOfCharactersLine(charsLength)(text)
    result shouldBe List(
      "In 1991, while studying computer science",
      "at University of Helsinki, Linus",
      "Torvalds began a project that later",
      "became the Linux kernel. He wrote the",
      "program specifically for the hardware he",
      "was using and independent of an",
      "operating system because he wanted to",
      "use the functions of his new PC with an",
      "80386 processor. Development was done on",
      "MINIX using the GNU C Compiler."
    )

  }

  it should "when a word surpass the limit of characters per line then break the line sending the word the next line" in {
    val text = "This is an awesomenonexistingingrammarword that should make the function break the text to a new line."
    val result = TextBreaker.breakTextInSpecifiedLengthOfCharactersLine(charsLength)(text)
    result shouldBe List(
      "This is an",
      "awesomenonexistingingrammarword that",
      "should make the function break the text",
      "to a new line."
    )
  }

  it should "when text is empty should return an empty List with the string" in {
    val text = ""
    val result = TextBreaker.breakTextInSpecifiedLengthOfCharactersLine(charsLength)(text)
    result shouldBe List("")
  }

  it should "when the user writes a enormous word, that no fits inside the length expected do nothing, just return text" in {
    val text = "Thisisoneenormouswordwithoutanyspacesandwithmorethan40characters"
    val result = TextBreaker.breakTextInSpecifiedLengthOfCharactersLine(charsLength)(text)
    result shouldBe List("Thisisoneenormouswordwithoutanyspacesandwithmorethan40characters")
  }
}
