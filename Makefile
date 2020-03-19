JCC = javac
JFLAGS = -g
CLASSPATH = .:json.jar:json-simple.jar

all: modell modelw viewl vieww controller testall
	cp -r json.jar bin
	cp -r json-simple.jar bin

modell:
	javac -cp $(CLASSPATH) src/model/langage/*.java -d bin

modelw:
	javac -cp $(CLASSPATH) src/model/world/*.java -d bin

viewl:
	javac -cp $(CLASSPATH) src/view/langage/*.java -d bin

vieww:
	javac -cp $(CLASSPATH) src/view/langage/*.java -d bin

controller:
	javac -cp $(CLASSPATH) src/controller/*.java -d bin

testall:
	javac -cp $(CLASSPATH) src/Test.java -d bin

andrun:	all
	java -cp bin:json.jar:json-simple.jar src.Test

andrun:	all run

clean :
	rm -r bin/src/model/langage/*.class
	rm -r bin/src/model/world/*.class
	rm -r bin/src/view/langage/*.class
	rm -r bin/src/view/world/*.class
	rm -r bin/src/controller/*.class
	rm -r bin/src/*.class
