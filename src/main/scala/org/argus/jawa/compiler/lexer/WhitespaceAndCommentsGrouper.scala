/*
 * Copyright (c) 2016. Fengguo Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.jawa.compiler.lexer

import org.argus.jawa.compiler.lexer.Tokens._
import scala.collection.mutable.ListBuffer

class WhitespaceAndCommentsGrouper(lexer: JawaLexer) extends Iterator[Token] {

  private var nextToken = lexer.next()

  private var ended = false

  private var hiddenTokens: HiddenTokens = _

  def getHiddenTokens = hiddenTokens

  def hasNext = !ended

  private[lexer] def text = lexer.text

  def next() = {
    require(hasNext)
    hiddenTokens = readHiddenTokens()
    val resultToken = nextToken
    resultToken.associatedWhitespaceAndComments_ = hiddenTokens
    if (nextToken.tokenType == EOF)
      ended = true
    nextToken = lexer.next()
    resultToken
  }

  private def readHiddenTokens(): HiddenTokens = {
    val hiddenTokens = new ListBuffer[HiddenToken]
    while (isCommentOrWhitespace(nextToken)) {
      hiddenTokens += makeHiddenToken(nextToken)
      nextToken = lexer.next()
    }
    new HiddenTokens(hiddenTokens.toList)
  }

  private def isCommentOrWhitespace(token: Token) = token.tokenType match {
    case WS | LINE_COMMENT | MULTILINE_COMMENT | DOC_COMMENT => true
    case _                                                   => false
  }

  private def makeHiddenToken(token: Token) = token.tokenType match {
    case LINE_COMMENT => SingleLineComment(token)
    case MULTILINE_COMMENT => MultiLineComment(token)
    case DOC_COMMENT => DocComment(token)
    case WS => Whitespace(token)
  }

}
