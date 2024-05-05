default: build

build:
	scalac main.scala

run: build
	scala main