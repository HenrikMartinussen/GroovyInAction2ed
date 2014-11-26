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
assert c =~ /./                // Any character
assert c =~ /\d/               // Digit character
assert !(c =~ /^\d/)           // Begins with digit character
assert c =~ /\D/               // Any character except digits
assert !(c =~ /\s/)            // Whitespace character
assert c =~ /\S/               // Any character except whitespace
assert c =~ /\w/               // Word character
assert c =~ /^\w/              // Begins with word character
assert c =~ /\W/               // Any character except Word characters
assert c =~ /\d{2}/            // Exactly 2 occurences of digit character
assert c =~ /\d{3}/            // Exactly 3 occurences of digit character
assert !(c =~ /\d{4}/)         // Exactly 4 occurences of digit character
assert !(c =~ /^\d{3}/)        // Begins with exactly 3 occurences of digit character
                               
c =  'abc'                     
assert c =~ /./                // Any character
assert !(c =~ /\d/)            // Digit character
assert c =~ /\D/               // Any character except digits
assert !(c =~ /\s/)            // Whitespace character
assert c =~ /\S/               // Any character except whitespace
assert c =~ /\w/               // Word character
assert !(c =~ /\W/)            // Any character except Word characters
assert c =~ /\w{3}/            // Exactly 3 occurences of word character
assert c =~ /\w{2}/            // Exactly 2 occurences of word character
assert !(c =~ /\w{4}/)         // Exactly 4 occurences of word character
assert c ==~ /\w{3}/           // Matches exactly 3 occurences of word character
assert !(c ==~ /\w{2}/)        // Doesn't match exactly 2 occurences of word character
                         
c = '123'                
assert c =~ /./                // Any character
assert c =~ /\d/               // Digit character
assert !(c =~ /\D/)            // Any character except digits
assert c =~ /\d{3}/            // Exactly 3 occurences of digit character
assert c =~ /\d{2}/            // Exactly 2 occurences of digit character
assert !(c =~ /\d{4}/)         // Exactly 4 occurences of digit character
assert !(c =~ /\s/)            // Whitespace character
assert c =~ /\S/               // Any character except whitespace
assert c =~ /\w/               // Word character
assert !(c =~ /\W/)            // Any character except Word characters
                               
c = ',.-'                      
assert c =~ /./                // Any character
assert !(c =~ /\d/)            // Digit character
assert c =~ /\D/               // Any character except digits
assert !(c =~ /\s/)            // Whitespace character
assert c =~ /\S/               // Any character except whitespace
assert !(c =~ /\w/)            // Word character
assert c =~ /\W/               // Any character except Word characters
                               
c = ''                         
assert !(c =~ /./)             // Any character
assert !(c =~ /\d/)            // Digit character
assert !(c =~ /\D/)            // Any character except digits
assert !(c =~ /\s/)            // Whitespace character
assert !(c =~ /\S/)            // Any character except whitespace
assert !(c =~ /\w/)            // Word character
assert !(c =~ /\W/)            // Any character except Word characters
                               
c = ' '                        
assert c =~ /./                // Any character
assert !(c =~ /\d/)            // Digit character
assert c =~ /\D/               // Any character except digits
assert c =~ /\s/               // Whitespace character
assert c =~ /\s{1}/            // Exactly 1 occurences of whitespace character
assert c =~ /^\s{1}/           // Begins with exactly 1 occurences of whitespace character
assert !(c =~ /\S/)            // Any character except whitespace
assert !(c =~ /\w/)            // Word character
assert c =~ /\W/               // Any character except Word characters

c = '   Abc   ' 
assert c =~ /./                // Any character
assert !(c =~ /\d/)            // Digit character
assert c =~ /\D/               // Any character except digits
assert c =~ /\s/               // Whitespace character
assert c =~ /\S/               // Any character except whitespace
assert c =~ /\w/               // Word character
assert c =~ /\W/               // Any character except Word characters
assert c =~ /\w{3}/            // Exactly 3 occurences of word character
assert c =~ /\w{2}/            // Exactly 2 occurences of word character
assert !(c =~ /\w{4}/)         // Exactly 4 occurences of word character
assert !(c ==~ /\w{3}/)        // Doesn't Match exactly 3 occurences of word character
assert c ==~ /\s{3}\w{3}\s{3}/ // Matches exactly 3 occurences of whitespace character, followed by exactly 3 occurences of word character, followed by exactly 3 occurences of whitespace character
assert c ==~ /\s*\w{3}\s*/     // Matches 0 or more whitespace character, followed by exactly 3 occurences of word character, followed by zero or more occurences of whitespace character


print 'OK'