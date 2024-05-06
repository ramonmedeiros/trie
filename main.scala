import scala.io.Source

def filename = "sample_prefixes.txt"

class TrieNode {
  val children = new Array[TrieNode](50)
  var value = " ".charAt(0) 
}

def constructTrie(root: TrieNode): Unit = {
  val source = Source.fromFile(filename)
  val lines = source.getLines
  for (word <- lines) {
    var node = root
    for (c <- word) {
      val calc = (c - 'a').abs
      if (node.children(calc) == null){
        node.children(calc) = new TrieNode
        node.value = c
      }
      node = node.children(calc)
    }
  }
  source.close()
}

def findWord(word: String, root: TrieNode): String = {
  var node = root
  var prefix = ""
  for (c <- word) {
    val calc = (c - 'a').abs
    if (node.children(calc) != null) {
      node = node.children(calc)
      prefix = prefix + c
    }
  }
  prefix
}

@main def main(word: String): Unit = {
  var root = new TrieNode
  constructTrie(root)
  println(findWord(word, root))
}
