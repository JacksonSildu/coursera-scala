package recfun

import Main.balance

object workSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); 
  println("Welcome to the Scala worksheet");$skip(23); 

 
 val l = List("(");System.out.println("""l  : List[String] = """ + $show(l ));$skip(18); val res$0 = 
 
 l.tail.isEmpty;System.out.println("""res0: Boolean = """ + $show(res$0))}
  
}
