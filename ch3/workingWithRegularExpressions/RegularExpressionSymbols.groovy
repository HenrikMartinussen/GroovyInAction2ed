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
assert 'abc   123   ,.-' =~ /.{6}/        //Find 6 any characters
assert 'abc   123   ,.-' =~ /.{15}/       //Find 15 any characters
assert !('abc   123   ,.-' =~ /.{16}/)    //Can't find 16 any characters
assert 'abc   123   ,.-' =~ /abc.{12}/    //Find characters 'abc' followed by 12 any characters
assert 'abc   123   ,.-' =~ /abc.{9}.../  //Find characters 'abc' followed by 9 any characters followed by 3 * 1 any character
assert 'abc   123   ,.-' =~ /abc.{9},.-/  //Find characters 'abc' followed by 9 any characters followed by character ',' followed by 1 any character followed by '-'
assert 'abc   123   ,.-' =~ /abc.{9},\.-/ //Find characters 'abc' followed by 9 any characters followed by characters ',.-' - note that the dot has to be escaped to match a dot and not any character
assert 'abc   123   ,.-' =~ /abc.{9}.\../
assert '.' =~ /./                         //any character
assert '.' =~ /\./                        //a dot

/* ^ Start of line (or start of document, when in single-line mode) */
assert 'abc123' =~ /abc/  //Find characters 'abc'
assert 'abc123' =~ /^abc/ //Find characters 'abc' from start of line
assert 'abc123' =~ /123/  //Find characters '123'
assert !('abc123' =~ /^123/) //Can't find characters '123' from start of line

/* $ End of line (or end of document, when in single-line mode) */
assert 'abc123' =~ /123/     //Find characters '123'
assert 'abc123' =~ /123$/    //Find characters '123' in the end of the line
assert !('abc123' =~ /abc$/) //Can't find characters 'abc' in the end of the line

/*
\d Digit character
\D Any character except digits
\s Whitespace character
\S Any character except whitespace
\w Word character
\W Any character except word characters
\b Word boundary
() Grouping
*/

print 'Ok'