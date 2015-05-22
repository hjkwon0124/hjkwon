package step5

/**
 * Created by hjkwon on 15. 5. 22.
 */
object main extends App{


  maybeTwice(true, {println("1"); 42})
  maybeTwice2(true, Int => {println("2"); 42})
  maybeTwice3(true, {println("3"); 42})
  maybeTwice4(true, () => {println("4"); 42})

  def maybeTwice(b:Boolean, i: =>Int):Int ={
    lazy val j = i
    i+i
    j+j
  }

  def maybeTwice2(b:Boolean, i:Int =>Int):Int ={
    lazy val j = i
    i(0)+i(0)
    j(0)+j(0)
  }

  def maybeTwice3(b:Boolean, i:Int):Int ={
    lazy val j = i
    i+i
    j+j
  }

  def maybeTwice4(b:Boolean, i: ()=>Int):Int ={
    lazy val j=i
    i()+i()
    j()+j()
  }

}
