object App {
  //переворот строки
  def revers (arg:String): String={
    var result = ""
    var i = 0
    while ( {i < arg.length}) {
      result = result.patch(0,arg.charAt(i).toString,0)
      i = i+1
    }
    return result
  }
  //расчет оклада
  def oklad (year_zp:Double, add:Double, eda:Double):Double={
    var result:Double= 0
    //0.87 - остаток после уплаты налогов
    result = (year_zp*(1+add/100)*0.87/12+eda)
    return result
  }
  //расчет средней зарплаты
  def mid_zp(zp:Array[Int]):Double ={
    var summ:Double=0

    for (s <- zp) summ=summ+s
    return summ/zp.length
  }
  //вычисление степени двойки
  def st2(n:Int): Long ={
    if(n <= 0) 1
    else 2 * st2(n-1)
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
     var zp = Array(100, 150, 200, 80, 120, 75)
     // средняя зарплата
     val m = mid_zp(zp)
     println("------------------------------")
// добавляем элемент в массив накинув 50$ за особые заслуги
     zp = zp :+ m.toInt+50
     print("Средняя зарплата:")
     println(m)
     print("Самая высокая зарплата: ")
     print(zp.max)
     println("$")
     print("Самая низкая зарплата: ")
     print(zp.min)
     println("$")
     // пришли 2 сотрудника с зп 350 и 90
     zp = zp :+ 350
     zp = zp :+ 90
     println("------------------------------")
     println("Сортировка")
     //сортировка
     zp=zp.sorted
     for (z <- zp) {
       print (z)
       print("$ - ")
     }
     // вставляем элемент в нужную позицию
     val new_zp=130
     zp = zp :+ zp(zp.length-1)
     var i=zp.length-1
     while (zp(i-1)>new_zp) {
       zp(i)=zp(i-1)
       i = i-1
     }
     zp(i)=new_zp
     println()
     println("Добавляем элемент 130  в нужную позицию")
     for (z <- zp) {
       print (z)
       print("$ - ")
     }
     println()
     println("------------------------------")
     println ("Отклонения зарплаты от среднего: ")
     for (dev<-zp) {
       print(dev)
       print("$: ")
       print (((dev-m)/dev*100).round)
       print("%; ")
     }
     println()
     //g.       Попробуйте вывести номера сотрудников из  полученного списка, которые попадают
     // под категорию middle. На входе программе подается «вилка» зарплаты специалистов уровня middle
     val min=110
     val max=160
     i=0
     println("------------------------------")
     println ("Номера элементов массива со значениями из диапазона 110-160")
     for (z <- zp) {
       if (zp(i) >= min)  {
         if (zp(i) <= max) {
           println(i,z)
         }
       }
       i=i+1
     }


       //o.      *Попробуйте написать функцию, которая вычисляет значение степени двойки:
     println("------------------------------")
     print ("2^34=")
     println (st2(34))
     println("------------------------------")
   }
}
