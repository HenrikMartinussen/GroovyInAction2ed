//Listing 4.4 Specifying lists
//ReGinA 2.ed p. 99

List myList = [1, 2, 3]
assert myList[0] == 1
assert myList.size == 3
assert myList instanceof ArrayList

List myEmptyList = []
assert myEmptyList.size == 0

def myOtherList = []
(1..10).each{
  myOtherList << it
}
assert myOtherList.size == 10
assert myOtherList instanceof ArrayList
assert myOtherList.class.name == 'java.util.ArrayList'

def LongList = (0..1000).toList()
assert LongList[555] == 555

List explicitList = new ArrayList()
assert explicitList.class.name == 'java.util.ArrayList'