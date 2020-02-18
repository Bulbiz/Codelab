JCC = javac
JFLAGS = -g
MODULE =
SRC = $(shell find src/ -name '*.java')

compile :
	$(JCC) $(JFLAGS) $(SRC)

clean :
	rm $(SRC:.java=.class)
