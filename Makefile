JCC = javac
JFLAGS = -g
CLASSPATH = bin:java-json.jar

all: modell modelw viewl vieww testall

modell: 
	javac -cp . src/model/langage/*.java -d bin

modelw:
	javac -cp . src/model/world/*.java -d bin

viewl:
	javac -cp . src/view/langage/*.java -d bin

vieww:
	javac -cp . src/view/langage/*.java -d bin

testall:
	javac -cp . src/Test.java -d bin

andrun:	all
	java -cp $(CLASSPATH) src.Test

clean :
	rm -r bin
