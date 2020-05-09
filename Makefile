JCC = javac
JFLAGS = -g
CLASSPATH = .:json.jar:json-simple.jar

all: modell modelw viewl vieww editor controller story launcher testall
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

editor:
	javac -cp $(CLASSPATH) src/editor/view/*.java -d bin

controller:
	javac -cp $(CLASSPATH) src/controller/*.java -d bin

story:
	javac -cp $(CLASSPATH) src/story/*.java -d bin

testall:
	javac -cp $(CLASSPATH) src/Test.java -d bin

launcher:
	javac -cp $(CLASSPATH) src/Launcher.java -d bin

run:
	java -cp bin:json.jar:json-simple.jar src.Launcher

andrun:	all run

clean :
	rm -r bin/src/model/langage/*.class
	rm -r bin/src/model/world/*.class
	rm -r bin/src/view/langage/*.class
	rm -r bin/src/view/world/*.class
	rm -r bin/src/controller/*.class
	rm -r bin/src/*.class
