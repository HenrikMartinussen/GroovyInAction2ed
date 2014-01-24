//ReGinA p 95
assert (0..10).contains(0)
assert (0..10).contains(5)
assert (0..10).contains(10)

assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false

assert (0..<10).contains(0) 
assert (0..<10).contains(9)
assert (0..<10).contains(10) == false

def a = 0..10
assert a instanceof Range
assert a instanceof IntRange
assert a.class.name == 'groovy.lang.IntRange'
assert a.contains(5)

a = new IntRange(0,10)
assert a.contains(0)
assert a.contains(3)
assert a.contains(10)

assert (0.0..1.0).contains(0.0)
assert (0.0..1.0).contains(0.5) == false //wtf?
assert (0.0..1.0).contains(1.0)
assert (0.0..1.0).containsWithinBounds(0.5)

def today = new Date() 
def yesterday = today --
def dayBeforeYesterday = today - 2
assert (dayBeforeYesterday..today).size() == 3 

assert ('a'..'c').contains('b')

def s = "abc"
assert s.next() == "abd"

s = ''
('aa'..'af').each{
    s += it        
}
assert s == 'aaabacadaeaf'

def log = ''
for (element in 5..9){
    log += element
}
assert log == '56789'

log = ''
for (element in 9..5){
    log += element
}
assert log == '98765'

log = ''
(9..<5).each{
    log += it
}
assert log == '9876'

println 'success'