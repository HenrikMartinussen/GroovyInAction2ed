// p.43

def l = [1,2,3]

l.each { number -> // parameter number is not an alias for "it"
  println number
}