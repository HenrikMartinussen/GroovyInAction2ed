/*
  Regina p 79 
*/
/*
Groovy relies on Java’s regex support 
Groovy adds three operators for convenience:
* The regex find operator =~
* The regex match operator ==~
* The regex pattern operator ~string
*/
//Table 3.6 Regular Expression symbols (excerpt)

/* . Any character */
assert 'abc   123   ,.-' =~ /.{6}/             //Find 6 any characters
assert 'abc   123   ,.-' =~ /.{15}/            //Find 15 any characters
assert !('abc   123   ,.-' =~ /.{16}/)         //Can't find 16 any characters
assert 'abc   123   ,.-' =~ /abc.{12}/         //Find characters 'abc' followed by 12 any characters
assert 'abc   123   ,.-' =~ /abc.{9}.../       //Find characters 'abc' followed by 9 any characters followed by 3 * 1 any character
assert 'abc   123   ,.-' =~ /abc.{9},.-/       //Find characters 'abc' followed by 9 any characters followed by character ',' followed by 1 any character followed by '-'
assert 'abc   123   ,.-' =~ /abc.{9},\.-/      //Find characters 'abc' followed by 9 any characters followed by characters ',.-' - note that the dot has to be escaped to match a dot and not any character
assert 'abc   123   ,.-' =~ /abc.{9}.\../      
assert '.' =~ /./                              //any character
assert '.' =~ /\./                             //a dot

/* ^ Start of line (or start of document, when in single-line mode) */
assert 'abc123' =~ /abc/                       //Find characters 'abc'
assert 'abc123' =~ /^abc/                      //Find characters 'abc' from start of line
assert 'abc123' =~ /123/                       //Find characters '123'
assert !('abc123' =~ /^123/)                   //Can't find characters '123' from start of line

/* $ End of line (or end of document, when in single-line mode) */
assert 'abc123' =~ /123/                       //Find characters '123'
assert 'abc123' =~ /123$/                      //Find characters '123' in the end of the line
assert !('abc123' =~ /abc$/)                   //Can't find characters 'abc' in the end of the line

/* \d Digit character */
assert 'abc   123   ,.-' =~ '\\d'              //Find a digit character
assert 'abc   123   ,.-' =~ "\\d{3}"           //Find 3 digit characters
assert !('abc   123   ,.-' =~ '\\d{4}')        //Can't find 4 digit characters
assert !('abc   123   ,.-' =~ /^\d{3}/)        //Can't find 3 digit characters in the beginning of the line
assert !('abc   123   ,.-' =~ /\d{3}$/)        //Can't find 3 digit characters in the end of the line
assert 'abc   123   ,.-' =~ /.{6}\d{3}.{6}/    //Find 6 any characters, followed by 3 digit characters, followed by 6 any characters
assert 'abc   123   ,.-' =~ /^.{6}\d{3}/       //Find 6 any characters, followed by 3 digit characters from start of line
assert 'abc   123   ,.-' =~ /\d{3}.{6}$/       //Find 3 digit characters, followed by 6 any characters in the end of the line

/* \D Any character except digits */
assert 'abc   123   ,.-' =~ '\\D'              //Find any character except digit character
assert 'abc   123   ,.-' =~ "\\D{6}"           //Find 6 any character except digit character
assert !('abc   123   ,.-' =~ "\\D{7}")        //Can't find 7 any character except digit character
assert 'abc   123   ,.-' =~ /\D{6}\d{3}\D{6}/  //Find 6 non digit characters, followed by 3 digit characters, followed by 6 non digit characters
assert 'abc   123   ,.-' =~ /^\D{6}\d{3}/      //Find 6 non digit characters, followed by 3 digit characters from start of line
assert 'abc   123   ,.-' =~ /\d{3}.{6}$/       //Find 3 digit characters, followed by 6 non digit characters in the end of the line

/* \s Whitespace character */
assert 'abc   123   ,.-' =~ '\\s'              //Find whitespace character
assert 'abc   123   ,.-' =~ '\\s{3}'           //Find 3 whitespace characters
assert !('abc   123   ,.-' =~ '\\s{4}')        //Can't find 4 whitespace characters
assert 'abc   123   ,.-' =~ /.{3}\s{3}\d{3}\s{3}.{3}/ 
                                               //Find 3 any characters, followed by 3 whitespace characters, followed by 3 digit characters, followed by 3 whitespace characters, followed by 3 any characters
assert !('abc   123   ,.-' =~ /^\s{3}/)        //Can't find 3 whitespace characters in the beginning of the line
assert !('abc   123   ,.-' =~ /\s{3}$/)        //Can't find 3 whitespace characters in the end of the line

/* \S Any character except whitespace */
assert 'abc   123   ,.-' =~ '\\S'              //Find non-whitespace character
assert 'abc   123   ,.-' =~ /\S{3}/            //Find 3 non-whitespace character
assert !('abc   123   ,.-' =~ '\\S{4}')        //Can't find 4 non-whitespace characters
assert 'abc   123   ,.-' =~ /\S{3}\s{3}\d{3}\s{3}\S{3}/
                                               //Find 3 non-whitespace character, followed by 3 whitespace characters, followed by 3 digit characters, followed by 3 whitespace characters, followed by 3 non whitespace characters
assert 'abc   123   ,.-' =~ /^\S{3}/           //Find 3 non-whitespace character in the beginning of the line   
assert 'abc   123   ,.-' =~ /\S{3}$/           //Find 3 non-whitespace character in the end of the line


/* \w Word character */
assert 'abc   123   ,.-' =~ '\\w'              //Find word character
assert 'abc   123   ,.-' =~ /\w{3}/            //Find 3 word characters
assert !('abc   123   ,.-' =~ /\w{4}/)         //Can't find 4 word characters
assert 'abc   123   ,.-' =~ /^\w{3}/           //Find 3 word characters in the beginning of the line
assert 'abc   123   ,.-' =~ /\w{3}\s{3}\d{3}/  //Find 3 word characters, followed by 3 whitespace characters, followed by 3 digit characters
assert 'abc   123   ,.-' =~ /^\w{3}\s{3}/      //Find 3 word characters, followed by 3 whitespace characters, in the beginning of the line

/* \W Any character except word characters */
assert 'abc   123   ,.-' =~ '\\W'              //Find non word character
assert 'abc   123   ,.-' =~ /\W{3}/            //Find 3 non word character
assert 'abc   123   ,.-' =~ /\w{3}\s{3}\d{3}\s{3}\W{3}/
                                               //Find 3 word character, 3 whitespace character, 3 digit character, 3 whitespace character, 3 non word character
/*
\b Word boundary
() Grouping
*/

print 'Ok'