/*
 * page 28
 */

assert true
assert (true)
assert 1 == 1
def x = 1
assert x == 1
def y = 1; assert y == 1

def a = 5
def b  = 9
//assert b == a + a

assert 'text' == 'text'
assert ('text' ) == 'text'
assert ('text' * 3 ) == 'texttexttext'
assert ('hello' * 2) == 'hellohello'

def f = 'hel'
assert f == 'hel'
def g = 'lo'
assert g == 'lo'
def c = f << g 
assert c.class.name == 'java.lang.StringBuffer'
assert c.length() == 5

String e = f << g 
assert e.class.name == 'java.lang.String'
assert e == 'hello'


assert c.toString() == "hello"
assert c.toString() == 'hello'
assert (String) c == 'hello'

assert c == e
assert c.equals(e)


assert 'hel' << 'lo' == 'hello'

def d = ('text' * 3 << 'hello')
print d.size()

assert d.size() == 4 * 3 + 5
assert d == 'texttexttexthello'

assert ('texttexttexthello').equals('texttexttexthello')
assert 'texttexttexthello' == 'texttexttexthello'

assert ('text' * 3 << 'hello').equals('texttexttexthello')
assert ('text' * 3 << 'hello') == 'texttexttexthello'