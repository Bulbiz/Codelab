JCC = javac
JFLAGS = -g
CLASSPATH = .:json.jar

all: modell modelw viewl vieww testall
	cp -r json.jar bin

modell: 
	javac -cp $(CLASSPATH) src/model/langage/*.java -d bin

modelw:
	javac -cp $(CLASSPATH) src/model/world/*.java -d bin

viewl:
	javac -cp $(CLASSPATH) src/view/langage/*.java -d bin

vieww:
	javac -cp $(CLASSPATH) src/view/langage/*.java -d bin

testall:
	javac -cp $(CLASSPATH) src/Test.java -d bin

andrun:	all
	java -cp bin:json.jar src.Test

clean :
	rm -r bin
