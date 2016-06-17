/*
 * Copyright (c) 2016. Fengguo Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.jawa.compiler.codegen

import org.scalatest._
import java.io.File
import java.io.PrintWriter
import java.lang.reflect.InvocationTargetException

import org.argus.jawa.compiler.lexer.JawaLexer
import org.argus.jawa.compiler.parser.JawaParser
import org.argus.jawa.compiler.util.ReadClassFile.CustomClassLoader
import org.argus.jawa.core.DefaultReporter
import org.argus.jawa.core.io.{FgSourceFile, PlainFile, SourceFile}

class JawaCodegenTest extends FlatSpec with ShouldMatchers {

  "Generate code" should "not throw an exception on ArrayAccess1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/array/ArrayAccess1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on ArrayAccess2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/array/ArrayAccess2.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on ArrayAccess3" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/array/ArrayAccess3.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on ArrayCopy" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/array/ArrayCopy.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on ArrayFill1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/array/ArrayFill1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on ArrayFill2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/array/ArrayFill2.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on ArrayLength1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/array/ArrayLength1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on Cmp1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/cmp/Cmp1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on Cmp2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/cmp/Cmp2.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on ConstClass1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/constclass/ConstClass1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on ConstClass2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/constclass/ConstClass2.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on DoubleLong1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/doublelong/DoubleLong1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on Exceptions1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/exception/Exceptions1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on Exceptions2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/exception/Exceptions2.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on Exceptions3" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/exception/Exceptions3.pilar")))
    genCode(jf)
  }

  "Generate code" should "throw an exception on Exceptions4" in {
    an [RuntimeException] should be thrownBy {
      val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/exception/Exceptions4.pilar")))
      genCode(jf)
    }
  }

  "Generate code" should "not throw an exception on FieldAccess1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/field/FieldAccess1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on FieldAccess2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/field/FieldAccess2.pilar")))
    genCode(jf)
  }

//  "Generate code" should "not throw an exception on StaticFieldAccess1" in {
//    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/field/StaticFieldAccess1.pilar")))
//    genCode(jf)
//  }


  "Generate code" should "not throw an exception on Instanceof1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/instance/Instanceof1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on Instanceof2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/instance/Instanceof2.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on IfJump1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/jump/IfJump1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on IfJump2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/jump/IfJump2.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on SwitchJump1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/jump/SwitchJump1.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on SwitchJump2" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/jump/SwitchJump2.pilar")))
    genCode(jf)
  }

  "Generate code" should "not throw an exception on Monitor1" in {
    val jf = new FgSourceFile(new PlainFile(new File("src/test/resources/monitor/Monitor1.pilar")))
    genCode(jf)
  }

  val reporter = new DefaultReporter
  private def parser(s: Either[String, SourceFile]) = new JawaParser(JawaLexer.tokenise(s, reporter).toArray, reporter)

  private def genCode(s: SourceFile) = {
    val newcode = s.code
    val cu = parser(Left(newcode)).compilationUnit(true)
    val css = new JavaByteCodeGenerator().generate(cu)
    val ccl: CustomClassLoader = new CustomClassLoader()
    val pw = new PrintWriter(System.out)
    css foreach {
      case (typ, bytecodes) =>
        JavaByteCodeGenerator.outputByteCodes(pw, bytecodes)
        try{
          val c = ccl.loadClass(typ.name, bytecodes)
          val r = c.getMethod("main").invoke(null)
          println("result: " + r)
        } catch {
          case ite: InvocationTargetException =>
            throw ite.getTargetException
          case ilv: java.lang.VerifyError =>
            throw new RuntimeException(ilv.getMessage)
        }
    }
  }
}
