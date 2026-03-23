# JVM Basics

What is the JVM, JRE, and JDK?

- JVM (Java Virtual Machine): The runtime that executes Java bytecode. It provides a platform-independent execution environment and manages resources like memory and threads for Java programs.

- JRE (Java Runtime Environment): A package that contains the JVM plus the standard Java class libraries needed to run Java programs. It does not include development tools.

- JDK (Java Development Kit): The JDK includes the JRE and development tools such as the Java compiler (`javac`), debugger, and other utilities needed to write and build Java applications.

What is bytecode?

- Java source code (.java) is compiled by `javac` into an intermediate, platform-independent format called bytecode (.class files). The JVM reads and executes bytecode.

What does "write once, run anywhere" mean?

- Java programs are compiled to bytecode which can run on any platform that has a compatible JVM implementation. Because the JVM abstracts the underlying operating system and hardware, the same compiled classes can run on Windows, Linux, or macOS without recompilation (as long as the target JDK/JVM versions are compatible). This is the essence of "write once, run anywhere."
