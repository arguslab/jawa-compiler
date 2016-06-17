# jawa-compiler: Interactive Compiler for JAWA.
[![License](https://img.shields.io/badge/License-EPL%201.0-red.svg)](https://opensource.org/licenses/EPL-1.0) 
[![Download](https://api.bintray.com/packages/arguslab/maven/jawa-compiler/images/download.svg)](https://bintray.com/arguslab/maven/jawa-compiler/_latestVersion)
[![Build Status](https://travis-ci.org/arguslab/jawa-compiler.svg?branch=master)](https://travis-ci.org/arguslab/jawa-compiler)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7feccdaca19847759f75bd044ddbee28)](https://www.codacy.com/app/fgwei521/jawa-compiler?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=arguslab/jawa-compiler&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/7feccdaca19847759f75bd044ddbee28)](https://www.codacy.com/app/fgwei521/jawa-compiler?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=arguslab/jawa-compiler&amp;utm_campaign=Badge_Coverage)

## Obtaining

Depend on jawa-compiler by editing
`build.sbt`:

```
libraryDependencies += "com.github.arguslab" %% "jawa-compiler" % "0.0.2"
```

> If you use Maven or Gradle, you should translate it to corresponding format.

## Developing jawa-compiler

In order to take part in jawa-compiler development, you need to:

1. Install the following software:
    - IntelliJ IDEA 14 or higher with compatible version of Scala plugin

2. Fork this repository and clone it to your computer

  ```
  $ git clone https://github.com/arguslab/jawa-compiler.git
  ```

3. Open IntelliJ IDEA, select `File -> New -> Project from existing sources`
(if from initial window: `Import Project`), point to
the directory where Scala plugin repository is and then import it as SBT project.

4. When importing is finished, go to jawa-compiler repo directory and run

  ```
  $ git checkout .idea
  ```

  in order to get artifacts and run configurations for IDEA project.
  
5. If you want to build jawa-compiler from command line, go to jawa-compiler repo directory and run

   ```
   $ tools/bin/sbt clean compile test
   ```

## How to contribute

To contribute to the jawa-compiler, please send us a [pull request](https://help.github.com/articles/using-pull-requests/#fork--pull) from your fork of this repository!

For more information on building and developing jawa-compiler, please also check out our [guidelines for contributing](CONTRIBUTING.md). People who provided excellent ideas are listed in [contributor](CONTRIBUTOR.md).
