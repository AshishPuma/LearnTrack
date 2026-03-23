# Setup Instructions

JDK version used
- This project was developed and tested with JDK 22. You can use any JDK version 17 or later, but make sure to adjust the installation instructions and commands accordingly.

Installing Java (Windows)
1. Download a JDK distribution (e.g., Eclipse Temurin, Oracle JDK, or Azul Zulu) for Windows from the provider's website.
2. Run the installer and follow prompts.
3. Add the JDK `bin` folder to the PATH environment variable (for example: `C:\Program Files\Eclipse Adoptium\jdk-17.0.x\bin`).

Verify installation
Open PowerShell and run:

```
java -version
javac -version
```

You should see output similar to:

```
openjdk version "17.0.x" 202x-xx-xx
Java(TM) SE Runtime Environment (build 17.0.x+xx)
javac 17.0.x
```

Hello World / Running the project
1. From the project root (folder that contains `src`), compile the sources into an `out` directory:

```
javac -d out -sourcepath src src/com/airtribe/learntrack/Main.java
```

2. Run the program using the fully-qualified main class name:

```
java -cp out com.airtribe.learntrack.Main
```

Expected output:

```
LearnTrack started...
```

Using an IDE
- If you use IntelliJ IDEA or Eclipse, import the project folder as a Java project and set the Project SDK to your installed JDK (17 recommended).

Notes
- The project uses only core Java (no external build tool required). The commands above are sufficient for compiling and running the simple console app.
