package com.willian.textbreaker

object MainApp {

  case class UserInput(lineLength: Int, text: String)

  def processInput(args: Array[String]): Option[UserInput] =
    args match {
      case Array(lineLength, text) =>
        try {
          Some(UserInput(lineLength.toInt, text))
        } catch {
          case _: NumberFormatException => None
        }
      case _ => None
    }

  def generateOutput(userInput: UserInput): String =
    TextBreaker.breakTextInSpecifiedLengthOfCharactersLine(userInput.lineLength)(userInput.text).mkString("\n")

  //TODO - Needs to improve the way to feed the MainApp program - effect IO from command line arguments - to be a prompt approach and not args
  def main(args: Array[String]): Unit = {
    val result = processInput(args).map(generateOutput)

    result match {
      case Some(outputText) => println(outputText)
      case None => println("Please use parameters in that way: <application> <numberOfCharactersPerLine> <text>")
    }
  }

}
