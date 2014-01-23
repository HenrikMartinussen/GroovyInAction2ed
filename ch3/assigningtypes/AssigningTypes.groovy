//ReGinA p.59
//Implicit typing
def a = 1                                 
assert a.class.name == 'java.lang.Integer'

def b = 1.0f
assert b.class.name == 'java.lang.Float'

//Explicit typing, using Java primitive type names
int c = 1
assert c.class.name == 'java.lang.Integer'

float d = 1 
assert d.class.name == 'java.lang.Float'

//Explicit typing, using reference type names
Integer e = 1
assert e.class.name == 'java.lang.Integer'

String f = '1'
assert f.class.name == 'java.lang.String'

println 'success'