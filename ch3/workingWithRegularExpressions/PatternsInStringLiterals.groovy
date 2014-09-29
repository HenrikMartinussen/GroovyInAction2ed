/*
  Regina p 78 ff
*/

//Listing 3.6 Regular Expression GStrings
assert "abc" == /abc/
assert "\\d" == /\d/

def reference = "hello"
assert reference == /$reference/

//Table 3.8 Regular Expression symbols (excerpt) p. 78-80
def c = 'abc123,.-'
assert c =~ /./     // Any character
assert c =~ /\d/    // Digit character
assert c =~ /\D/    // Any character except digits
assert !(c =~ /\s/) // Whitespace character
assert c =~ /\S/    // Any character except whitespace
assert c =~ /\w/    // Word character
assert c =~ /\W/    // Any character except Word characters

c =  'abc'
assert c =~ /./     // Any character
assert !(c =~ /\d/) // Digit character
assert c =~ /\D/    // Any character except digits
assert !(c =~ /\s/) // Whitespace character
assert c =~ /\S/    // Any character except whitespace
assert c =~ /\w/    // Word character
assert !(c =~ /\W/) // Any character except Word characters
assert c =~ /\w{3}/ // Exactly 3 occurences of word character

c = '123'
assert c =~ /./     // Any character
assert c =~ /\d/    // Digit character
assert !(c =~ /\D/) // Any character except digits
assert c =~ /\d{3}/ // Exactly 3 occurences of digit character
assert !(c =~ /\s/) // Whitespace character
assert c =~ /\S/    // Any character except whitespace
assert c =~ /\w/    // Word character
assert !(c =~ /\W/) // Any character except Word characters

c = ',.-'
assert c =~ /./     // Any character
assert !(c =~ /\d/) // Digit character
assert c =~ /\D/    // Any character except digits
assert !(c =~ /\s/) // Whitespace character
assert c =~ /\S/    // Any character except whitespace
assert !(c =~ /\w/) // Word character
assert c =~ /\W/    // Any character except Word characters

c = ''
assert !(c =~ /./)  // Any character
assert !(c =~ /\d/) // Digit character
assert !(c =~ /\D/) // Any character except digits
assert !(c =~ /\s/) // Whitespace character
assert !(c =~ /\S/) // Any character except whitespace
assert !(c =~ /\w/) // Word character
assert !(c =~ /\W/) // Any character except Word characters

c = ' '
assert c =~ /./     // Any character
assert !(c =~ /\d/) // Digit character
assert c =~ /\D/    // Any character except digits
assert c =~ /\s/    // Whitespace character
assert c =~ /\s{1}/ // Exactly 1 occurences of whitespace character
assert !(c =~ /\S/) // Any character except whitespace
assert !(c =~ /\w/) // Word character
assert c =~ /\W/    // Any character except Word characters