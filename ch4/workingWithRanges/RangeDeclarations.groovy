//ReGinA p 95
assert (0..10).contains(0)
assert (0..10).contains(5)
assert (0..10).contains(10)

assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false

assert (0..<10).contains(10) == false
assert (0..<10).contains(9)
println 'success'
