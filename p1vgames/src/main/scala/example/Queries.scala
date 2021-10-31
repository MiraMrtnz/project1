package example

import scala.io.Source
import java.io.PrintWriter
import java.io.File

import scala.util.Try
import java.io.IOException
import java.sql.SQLException
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.sql.DriverManager


object Queries {
  
  def vAPI(): Unit = {

    var connection: java.sql.Connection = null

    try{
      var driverName = "org.apache.hive.jdbc.HiveDriver"
      val connectionString = "jdbc:hive2://sandbox-hdp.hortonworks.com:10000/project1_database"

      Class.forName(driverName)
      connection = DriverManager.getConnection(connectionString, "", "")
      val statement = connection.createStatement()

      println("Loading massive fun...")

    }catch{
      case ex =>{
          ex.printStackTrace();
          throw new Exception(s"${ex.getMessage}")
      }
    }finally{
      try{
          if (connection != null)
          connection.close();
      }catch{
          case ex => {
            ex.printStackTrace();
            throw new Exception(s"${ex.getMessage}")
          }
      }
    }
    var querySeq: Seq[String] = Seq("1. Top Games of All Time", "2. Top Games by Genre", "3. Most Anticipated Upcoming Games", "4. Most Popular Games Pre-Pandemic", "5. Highest Rated Games by Console", "6. Most Expensive Games to Develop")

    
  }
  
}
