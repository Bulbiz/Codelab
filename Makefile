JCC = javac
JFLAGS = -g
MODULE =


all: modell modelw viewl vieww

modell: 
	javac -cp . src/model/langage/*.java -d bin

modelw:
	javac -cp . src/model/world/*.java -d bin

viewl:
	javac -cp . src/view/langage/*.java -d bin

vieww:
	javac -cp . src/view/langage/*.java -d bin

clean :
	rm -r bin
