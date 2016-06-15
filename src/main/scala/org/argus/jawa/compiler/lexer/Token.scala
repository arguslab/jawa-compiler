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

import org.argus.jawa.core.io.{RangePosition, SourceFile}

/**
 * A token of Pilar source.
 *
 * @param tokenType Token type.
 * @param pos Position in the text.
 * @param rawtext -- the text associated with the token.
 */
case class Token(tokenType: TokenType, pos: RangePosition, rawtext: String) {

  private[lexer] var associatedWhitespaceAndComments_ : HiddenTokens = null

  private[lexer] var containsUnicodeEscape = false

  def associatedWhitespaceAndComments: HiddenTokens = associatedWhitespaceAndComments_
  
  def line: Int = pos.line
  
  def column: Int = pos.column
  
  def offset: Int = pos.point
  
  def length: Int = rawtext.length

  def lastCharacterOffset: Int = pos.point + length - 1
  
  def file: SourceFile = pos.source
  
  def range: Range = Range(pos.start, pos.end - pos.start + 1)
  
  def text: String = {
    tokenType match {
      case Tokens.STATIC_ID | Tokens.ID =>
        rawtext.replace("`", "")
      case _ => rawtext
    }
  }
  
  override def toString: String = {
    var txt = text
    if (txt != null) {
      txt = txt.replace("\n","\\n")
      txt = txt.replace("\r","\\r")
      txt = txt.replace("\t","\\t")
    }
    else {
      txt = "<no text>"
    }
    "["+txt+"',<"+tokenType+">"+"@"+pos+"]"
  }

}
