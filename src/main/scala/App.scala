object App {
  def revers (arg:String): String={
    var result = ""
    var i = 0
    while ( {i < arg.length}) {
      result = arg.charAt(i) + result
      i = i+1
    }
    return result
  }
  def oklad (year_zp:Double, add:Double, eda:Double):Double={
    var result:Double= 0
    //0.87 - остаток после уплаты налогов
    result = (year_zp*(1+add/100)*0.87/12+eda)
    return result
  }
  def mid_zp(zp:Array[Int]):Double ={
    var summ:Double=0

    for (s <- zp) summ=summ+s
    return summ/zp.length
  }

   def main(args: Array[String]): Unit={
// a.    Напишите программу, которая:
     val str = "Hello, Scala!"
     println(str)
     //   i.     выводит фразу «Hello, Scala!» справа налево
     println (revers(str))
     // ii.     переводит всю фразу в нижний регистр
     println(str.toLowerCase)
     //iii.     удаляет символ!
     //iv.     добавляет в конец фразы «and goodbye python!»
     println (str.substring(0, str.length-1)+" and goodbye Python!")
     //Напишите программу, которая вычисляет ежемесячный оклад сотрудника после вычета налогов.
     // На вход вашей программе подается значение годового дохода до вычета налогов,
     // размер премии – в процентах от годового дохода и компенсация питания.
     val arg1:Double = 123456 //годовой доход до вычета налогов в $
     val arg2:Double = 20 //премия в %
     val arg3:Double = 123 //ежемесячная компенсация питания в $
     print ("Ежемесячный оклад: ")
     print (oklad(arg1,arg2,arg3).round)
     println(" $")

     //с. Напишите программу, которая рассчитывает для каждого сотрудника отклонение(в процентах)
     // от среднего значения оклада на уровень всего отдела. В итоговом значении должно учитываться
     // в большую или меньшую сторону отклоняется размер оклада. На вход вышей программе подаются все
     // значения, аналогичные предыдущей программе, а также список со значениями окладов сотрудников отдела
     // 100, 150, 200, 80, 120, 75.

     //Зарплата сотрудников
     val zp = Array(100, 150, 200, 80, 120, 75)
     // средняя зарплата
     val m = mid_zp(zp)
     println("------------------------------")
     print("Средняя зарплата:")
     println(m)
     println ("Отклонения зарплаты от среднего: ")
     for (dev<-zp) {
       print(dev)
       print("$: ")
       print (((dev-m)/dev*100).round)
       print("%; ")
     }
     println()
   }
}
