package com.willian.textbreaker

object TextBreaker {
  def breakTextInSpecifiedLengthOfCharactersLine(numberOfCharacters: Int)(text: String): List[String] = {
    val words = text.split("\\s+").toList

    words.foldLeft(List.empty[String]) {
      case (Nil, word) => List(word)
      case (head :: tail, word) =>
        if ((head + " " + word).length <= numberOfCharacters) (head + " " + word) :: tail
        else word :: head :: tail
    }.reverse
  }
}
