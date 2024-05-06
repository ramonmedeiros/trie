import scala.io.Source

class TrieNode {
  val children = new Array[TrieNode](50)
  var value = new String("")
}

def constructTrie(filename: String, root: TrieNode): Unit = {
  val source = Source.fromFile(filename)
  val lines = source.getLines
  for (word <- lines) {
    var node = root
    for (c <- word) {
      val calc = (c - 'a').abs
      if (node.children(calc) == null){
        node.children(calc) = new TrieNode
      }
      node = node.children(calc)
    }
    node.value = word
  }
  source.close()
}

def findWord(word: String, root: TrieNode): String = {
  var node = root
  for (c <- word) {
    val calc = (c - 'a').abs
    if (node.children(calc) != null) {
      node = node.children(calc)
    }
  }
  node.value
}

@main def main(filename: String, word: String): Unit = {
  var root = new TrieNode
  constructTrie(filename, root)
  println(findWord(word, root))
}
