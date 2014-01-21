def a = 'text'
assert a.class.name == 'java.lang.String'
assert a == 'text'
assert a == "text"
assert a == /text/
assert a.length() == 4

def b = 'hello'
assert b.class.name == 'java.lang.String'
assert b == 'hello'
assert b == "hello"
assert b == /hello/
assert b.length() == 5

def c = a * 3
assert c.class.name == 'java.lang.String'
assert c.length() == 12
assert c == 'texttexttext'


def d = c << b
assert d.class.name == 'java.lang.StringBuffer'
assert d.toString() == 'texttexttexthello'


String e = c << b
assert e.class.name == 'java.lang.String'


assert (a * 3 << b).size() == 4 * 3 + 5
assert d == 'texttexttexthello'



