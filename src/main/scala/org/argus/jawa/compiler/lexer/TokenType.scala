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

case class TokenType(name: String) {

//  def isNewline = this == Tokens.NEWLINE || this == Tokens.NEWLINES

  def isKeyword = Tokens.KEYWORDS contains this

  def isComment = Tokens.COMMENTS contains this

  def isId = Tokens.IDS contains this

  def isLiteral = Tokens.LITERALS contains this

  override lazy val toString = name

}
