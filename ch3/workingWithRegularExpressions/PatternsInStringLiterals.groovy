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
assert c   =~  /./             // c contains any character
assert c   =~  /\d/            // c contains digit character
assert !(c =~  /^\d/)          // c doesn't begin with digit character
assert c   =~  /\D/            // c contains any character except digits
assert !(c =~  /\s/)           // c doesn't contain whitespace character
assert c   =~  /\S/            // c contains any character except whitespace
assert c   =~  /\w/            // c contains word character
assert c   =~  /^\w/           // c begins with word character
assert c   =~  /^\w{3}/        // c begins with a group of at least 3 word character
assert c   =~  /\W/            // c contains any character except Word characters
assert c   =~  /\d{2}/         // c contains a group of at least 2 of digit character
assert c   =~  /\d{3}/         // c contains a group of at least 3 digit character
assert !(c =~  /\d{4}/)        // c doesn't contain a group of at least 4 digit character
assert !(c =~  /^\d{3}/)       // c doesn't begins with a group of at least 3 digit character
assert c   ==~ /.{7}\..{1}/    // c matches exactly 7 occurances of any character, followed by a dot, followed by exactly one any character
assert c   ==~ /.{3}\d{3}.{3}/ // c matches exactly 3 occurances of any character, followed by exactly 3 digit character, followed by exactly 3 occurances of any character
                               
c =  'abc'                     
assert c   =~  /./             // c contains any character
assert !(c =~  /\d/)           // c doesn't contain digit character
assert c   =~  /\D/            // c contains Any character except digits
assert !(c =~  /\s/)           // c doesn't contain whitespace character
assert c   =~  /\S/            // c contains any character except whitespace
assert c   =~  /\w/            // c contains word character
assert c   =~  /^\w/           // c begins with word character
assert !(c =~  /\W/)           // c doesn't contain Any character except Word characters
assert c   =~  /\w{2}/         // c contains a group of at least 2 word character
assert c   =~  /\w{3}/         // c contains a group of at least 3 word character
assert !(c =~  /\w{4}/)        // c doesn't contain a group of at least 4 word character
assert c   ==~ /\w{3}/         // c matches exactly a group of 3 word character
assert !(c ==~ /\w{2}/)        // c doesn't match exactly a group of 2 word character
                         
c = '123'                
assert c =~ /./                // c contains any character
assert c =~ /\d/               // c contains digit character
assert c =~ /^\d/              // Begins with digit character
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
assert c =~ /./                // Any character
assert !(c =~ /\d/)            // Digit character
assert c =~ /\D/               // Any character except digits
assert !(c =~ /\s/)            // Whitespace character
assert c =~ /\S/               // Any character except whitespace
assert !(c =~ /\w/)            // Word character
assert c =~ /\W/               // Any character except Word characters
                               
c = ''                         
assert !(c =~ /./)             // c doesn't contain any character
assert !(c =~ /\d/)            // c doesn't contain digit character
assert !(c =~ /\D/)            // c doesn't contain any character except digits
assert !(c =~ /\s/)            // c doesn't contain whitespace character
assert !(c =~ /\S/)            // c doesn't contain any character except whitespace
assert !(c =~ /\w/)            // c doesn't contain word character
assert !(c =~ /\W/)            // c doesn't contain any character except Word characters
                               
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
assert !(c =~ /\d/)            // c doesn't contain any digit character
assert c =~ /\D/               // Any character except digits
assert c =~ /\s/               // Whitespace character
assert c =~ /\s{3}/            // c contains a group of at least 3 whitespace character
assert !(c =~ /\s{6}/)         // c doesn't contain a group of at least 6 whitespace character
assert c =~ /^\s/              // c begins with whitespace character
assert c =~ /\S/               // Any character except whitespace
assert c =~ /\S{3}/            // c contains at least 3 any character except whitespace
assert c =~ /\w/               // Word character
assert c =~ /\W/               // Any character except Word characters
assert c =~ /\w{3}/            // Exactly 3 occurences of word character
assert c =~ /\w{2}/            // Exactly 2 occurences of word character
assert !(c =~ /\w{4}/)         // Exactly 4 occurences of word character
assert !(c ==~ /\w{3}/)        // Doesn't Match exactly 3 occurences of word character
assert c ==~ /\s{3}\w{3}\s{3}/ // Matches exactly 3 occurences of whitespace character, followed by exactly 3 occurences of word character, followed by exactly 3 occurences of whitespace character
assert c ==~ /\s*\w{3}\s*/     // Matches 0 or more whitespace character, followed by exactly 3 occurences of word character, followed by zero or more occurences of whitespace character

c = '''abc\r\ndef'''
assert c =~ /\w/     
assert c =~ /\w{3}/
assert !(c =~ /\w{3}.\w{3}/)      //c doesn't contain a group of at least 3 word character followed by one any character followed by a group of at least 3 word character
assert !(c =~ /\w{3}.*\w{3}/)     //c doesn't contain a group of at least 3 word character followed by one or more any character followed by a group of at least 3 word character (in the outset java/groovy regEx doesn't include newline characters in any character)
assert c =~ /(?s)\w{3}.*\w{3}/    //c contains a group of at least 3 any character followed by one or more any character, followed by a group of at least 3 word character - (?s) turns on the "DOTALL" flag
assert c ==~ /(?s)\w{3}.*\w{3}/   //c matches exactly a group of 3 any character followed by one or more any character, followed by a group of 3 any character
assert c ==~ /(?s)\w{3}.{2}\w{3}/ //c matches exactly a group of 3 any character followed by two any character, followed by a group of 3 any character
     

print 'OK'