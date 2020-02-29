# Java Fundamentals

## Getting started

1. Install [JDK](https://openjdk.java.net/).
1. Open [command-line interface](https://en.wikipedia.org/wiki/Command-line_interface#Operating_system_command-line_interfaces).
1. Execute: `javac src/org/fundamentals/Main.java`. You can find more information about Java programming language compiler
[here](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html).
1. Check that a new file named `Main.class` was created in `src/org/fundamentals`.
1. Open the file, it is a [byte code](https://en.wikipedia.org/wiki/Java_bytecode).
1. Execute: `java -cp src org.fundamentals.Main`. You can find more information about Java applications runner
[here](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/java.html).
1. Check the CLI (Command-line interface) output - it should be `Hello, World!`. 
_Notice that result text contains comma and sometimes exclamation mark._

## Exploring Java Objects

1. Try to execute: `javac src/org/fundamentals/example/Main2.java`.
1. Check the CLI output - read the error, why do you think it happened?
1. Execute: `javac src/org/fundamentals/example/*.java`.
1. Check that new files `Main2.class` and other were created in `src/org/fundamentals/example`.
1. Execute: `java -cp .\src org.fundamentals.example.Main2 js`. You can find more information about Java applications runner's
command line arguments [here](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/java.html).
`-cp` is short version of `-classpath` and it _specifies a list of directories, JAR files, 
and ZIP archives to search for class files._ Because we are using dependency from `Main2` to `Language` - we should
provide a path for dependencies' `*.class` files.
1. Check the CLI output - try another arguments as inputs.
1. Using this application as example create your own application about pets. Every animal should produce its own sound
and make different actions. Your application should take first argument as a name of pet and print its description.
For example, cat says 'meow' and catch mice. Dog says 'woof' and protect house. Hedgehog says 'frr' and catch mice. Etc.
1. Optional. Build your application as one jar file

## Exploring Generics
1. Compare implementation in 'generics' folder with 'example'

## 

