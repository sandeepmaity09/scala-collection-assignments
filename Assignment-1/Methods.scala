object Methods {

  def passFailChecker(subjectId: Int, criteria: Float, flag: String): String = {
    val marks = DataSets.marksList.flatMap(x => x.map(y => y))

    flag match {
      case "Pass" | "pass" => marks.filter(_.subjectId == subjectId)
        .partition(_.marksObtained >= criteria)._1.size.toString
      case "Fail" | "fail" => marks.filter(_.subjectId == subjectId)
        .partition(_.marksObtained < criteria)._1.size.toString
      case _ => "Please Provide the flag as Pass or Fail"
    }
  }

  def topperLoserChecker(subjectId: Int, count: Int, flag: String): Any = {
    val marks = DataSets.marksList.flatMap(x => x.map(y => y))

    flag match {
      case "top" | "Top" => {
        val toppers = marks.filter(_.subjectId == subjectId).sortBy(_.marksObtained).reverse.slice(0, count)
        //val toppersId = toppers.map(top => top.studentId)

        toppers.foreach(topper => {
          DataSets.studentList.foreach(student => if (topper.studentId == student.id)
            println(student.name + " " + topper.marksObtained)
          )
        })
      }

      case "bottom" | "Bottom" => {
        val losers = marks.filter(_.subjectId == subjectId).sortBy(_.marksObtained).slice(0, count)
        //val losersId = losers.map(loser => loser.studentId)
        losers.foreach(loser => {
          DataSets.studentList.foreach(student => if (loser.studentId == student.id)
            println(student.name + " " + loser.marksObtained)
          )
        })
      }

      case _ => {
        println("Please Provide the flag as Top or Bottom")
      }
    }
  }

  def toperLoserOverall(flag: String, count: Int): Any = {

    val marks = DataSets.marksList.flatMap(x => x.map(y => y))
    val result = average(marks)

    flag match {

      case "top" | "Top" => {
        val list = result.toList.sortBy(_._2).reverse.slice(0, count)
        list.foreach(lis => {
          DataSets.studentList.foreach(student => if (lis._1 == student.id)
            println(student.name + " " + lis._2)

          )
        })
      }

      case "bottom" | "Bottom" => {
        val list = result.toList.sortBy(_._2).slice(0, count)
        list.foreach(lis => {
          DataSets.studentList.foreach(student => if (lis._1 == student.id)
            println(student.name + " " + lis._2)
          )
        })
      }

      case _ => {
        "Please Provide the correct Parameters"
      }
    }
  }

  def schlorshipChecker(percentage: Float, goodScholar: Int, noScholar: Int): Any = {

    val marks = DataSets.marksList.flatMap(x => x.map(y => y))
    val result = average(marks)

    val partitionMap = result.partition(_._2 >= percentage)
    val scholorStudentsKeys = partitionMap._1.map(x => x._1).toList
    val noScholorStudentsKeys = partitionMap._2.map(x => x._1)

    DataSets.studentList.foreach(student => {
      if (scholorStudentsKeys.contains(student.id)) {
        println(student.name + " " + goodScholar.toString)
      }
      else {
        println(student.name + " " + noScholar.toString)
      }
    })
  }

  def passFailChecker(flag: String, percentage: Long): Any = {

    val marks = DataSets.marksList.flatMap(x => x.map(y => y))
    val result = average(marks)

    flag match {
      case "pass" | "Pass" => {
        val passStudents = result.filter(_._2 >= percentage).toList.sortBy(_._2).reverse
        passStudents.foreach(pass => {
          DataSets.studentList.foreach(student => {
            if (pass._1 == student.id)
              println(student.name + " " + pass._2)
          })
        })
      }

      case "fail" | "Fail" => {
        val failStudents = result.filter(_._2 < percentage).toList.sortBy(_._2)
        failStudents.foreach(fail => {
          DataSets.studentList.foreach(student => {
            if (fail._1 == student.id)
              println(student.name + " " + fail._2)
          })
        })
      }

      case _ => {
        println("Please provide the correct parameters")
      }
    }
  }

  def aboveNintyFive():Any={

    val marks = DataSets.marksList.flatMap(x => x.map(y => y))
    val result = average(marks).toList.filter(_._2>=95)
    result.foreach(res=>{
      DataSets.studentList.foreach(student=>{
        if(res._1==student.id)
          println(student.name + " " +res._2)
      })
    })
  }

  def reportCard():Any={
    val marks = DataSets.marksList.flatMap(x => x.map(y => y))
    val result = average(marks).toList.sortBy(_._1)

    DataSets.studentList.foreach(stud=>{
      print(stud.name+"   ")
      result.foreach(res=>{
        marks.foreach(mark=>{
          if(stud.id==res._1&&stud.id==mark.studentId)
            print(mark.marksObtained+"  ")
        })
        if(res._1 == stud.id)
        print(res._2)
      })
      println()
    })


  }

  private def average(list: List[Marks]): Map[Long, Float] = {

    var totalMarks: Float = 0
    var averageNumberOfStudents: scala.collection.mutable.Map[Long, Float] = scala.collection.mutable.Map[Long, Float]()

    DataSets.studentList.foreach(student => {
      list.groupBy(_.studentId == student.id)(true).foreach(mark => totalMarks += mark.marksObtained)
      averageNumberOfStudents = averageNumberOfStudents + ((student.id.toLong) -> (totalMarks.toFloat / 5))
      totalMarks = 0
    }
    )
    averageNumberOfStudents.toMap
  }

}
