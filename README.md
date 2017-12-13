# shell4j


shell4j requires Maven and Java 8.

## Build
`$ mvn clean package`

## Usage
```java
$ java -jar shell4j-1.0-SNAPSHOT.jar 

shell4j> int i = 4;
4
shell4j> i + 3;
7
shell4j> i
4
shell4j> "Lol".substring(1);
ol
shell4j> /help
Available shell4j commands:

/quit - Save and quit
/ragequit - Quit
/save - Save session to file
/help - Print this page
/clean - Clear all existing variables

shell4j> /ragequit
Goodbye!
```