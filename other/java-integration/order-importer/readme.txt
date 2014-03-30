http://mrhaki.blogspot.dk/2009/11/groovy-goodness-running-groovy-scripts.html
http://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java

depends on groovy-all.jar being on the classpath


gradle clean compileJava runSimple

Embedded tests in the groovy script can be run from the project home folder like this: 
groovy src\main\resources\SimpleScript.groovy