# Matching Prefixes

Given a file containing prefixes and a string, find the longest prefix

## How to build

```sh
$ scalac main.scala
```

## How to run

```sh
$ scala main <filename> <prefix>
```

## Performance analysis for the solution

This code uses a tree-like data structure, which adds each letter to node
and find the prefix by breadth first search. 

### Filling tree

It takes O(n) to create the tree, cpu wise, since it looks to every char in the file

Memory wise, it duplicates the input

### Searching and assembling result

Given a string, it loops in the string and run breadth first search. If first char is not found, will return empty,
taking O(1). If found some prefix, will take the size of the prefix.

## Other ideas

Maybe using a hashmap could have a similar result. So each key would host a prefix, and to search,
just loop in the string creating hash and searching it. 

Would take more CPU since hash function can be costly.

## Things I would like to improve

Since it was my first program in Scala, I lack knowledge on catching exceptions, loops and tests.

I would like to improve error handling, check if file exists, check command line params and better error messages.