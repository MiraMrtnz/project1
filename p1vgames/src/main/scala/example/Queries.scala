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
    def queryResponses{
      var active = true
      while (active){
      var querySeq: Seq[String] = Seq("1. Highest Rated Games", "2. Game Names by Genres", "3. Average Playtime for Top 10 Games",  "4. Parent ESRB Rating", "5. Top Games with a Metacritic Score Above 90", "6. How Many Games With Highest Metacritic Score", "7. Which most popular genres by top scoring rating?", "8. Exit ")
      println("Make a selection")

     for(x<-querySeq){
       println(x)
    }
    var selection = scala.io.StdIn.readInt

    selection match{
        case 1 => HiveQueries("SELECT get_json_object(json,'$.name'), get_json_object(json,'$.rating') FROM gamesall WHERE get_json_object(json,'$.name') IS NOT NULL LIMIT 10")//Names&Ratings
        case 2 => HiveQueries("SELECT get_json_object(json,'$.genres[0].name'), get_json_object(json,'$.name') FROM gamesall WHERE get_json_object(json,'$.name') IS NOT NULL LIMIT 10")//Names&Genres
        case 3 => HiveQueries("SELECT get_json_object(json,'$.name'), CAST(get_json_object(json,'$.playtime')AS int) AS playtime FROM gamesall WHERE get_json_object(json,'$.name') IS NOT NULL SORT BY playtime DESC LIMIT 10")//mostAnticipatedGames
        case 4 => HiveQueries("SELECT get_json_object(json,'$.name'), get_json_object(json,'$.esrb_rating.name') FROM gamesall WHERE get_json_object(json,'$.name') IS NOT NULL LIMIT 10")//prePandemic
        case 5 => HiveQueries("SELECT 'Average', AVG (CAST(get_json_object(json,'$.playtime') AS int)) AS playtime FROM gamesall WHERE get_json_object(json,'$.name') IS NOT NULL LIMIT 10")//highestRatedByConsole
        case 6 => HiveQueries("SELECT 'Count', COUNT(get_json_object(json,'$.metacritic')) FROM gamesall WHERE CAST(get_json_object(json,'$.metacritic') AS int) > 90")//mostExpensiveProduction
        case 7 => HiveQueries("SELECT get_json_object(json,'$.genres[1].name'), COUNT(get_json_object(json,'$.rating')) FROM gamesall WHERE CAST(get_json_object(json,'$.rating') AS float) > 3.5 AND get_json_object(json,'$.genres[1].name') IS NOT NULL GROUP BY get_json_object(json,'$.genres[1].name')")
        case 8 => active = false

        case _ => println("Enter a valid selection")

    }
  }  
}

    def HiveQueries(query:String){
      var connection: java.sql.Connection = null

    try{
      var driverName = "org.apache.hive.jdbc.HiveDriver"
      val connectionString = "jdbc:hive2://sandbox-hdp.hortonworks.com:10000/project1_database"

      Class.forName(driverName)
      connection = DriverManager.getConnection(connectionString, "", "")
      val statement = connection.createStatement()

      println("Loading tables please wait...")
      

      var hiveCommand = query 
      var response = statement.executeQuery(hiveCommand)
      println("----------------------------------")
      while (response.next()) {
        println (response.getString(1) + " = " + response.getString(2))
      }
      println("----------------------------------")

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
    }

    def getApiData{  //API URL save to local
      val url = "https://api.rawg.io/api/games?&datatype=csv&key=a0a2b0f2c89f44b8bcace962b5942041" //https://api.rawg.io/api/games?&datatype=csv&key=a0a2b0f2c89f44b8bcace962b5942041 optional url
      var result = scala.io.Source.fromURL(url).mkString
      val startIndex = result.indexOf("results") + 11
      val endIndex = result.indexOf("seo_title") - 3
      result = result.substring(startIndex, endIndex)
      result = result.replace("}]},{\"id","}]},force{\"id")
      val dataArray = result.split(",force")
      println("Loading Data from API. Please wait...")
      
      
      result = ""
      for (x <- dataArray){
      result += x + "\n"
      } 
      moveDataToHDP(result)
    }

// JSON to HDP method here
    def moveDataToHDP(jsonresults: String): Unit = {
        val filePathHDP = "/tmp/p1data/gamedata.json"
        val writer = new PrintWriter(new File(filePathHDP))
        writer.write(jsonresults)
        writer.close()
        

        println("File created in HDP Path: " + filePathHDP)
        hiveAPI()
    }

  def hiveAPI(): Unit = { 

    var connection: java.sql.Connection = null

    try{
      var driverName = "org.apache.hive.jdbc.HiveDriver"
      val connectionString = "jdbc:hive2://sandbox-hdp.hortonworks.com:10000/project1_database"

      Class.forName(driverName)
      connection = DriverManager.getConnection(connectionString, "", "")
      val statement = connection.createStatement()

      println("Loading tables please wait...")
      
      var hiveCommand = "CREATE TABLE IF NOT EXISTS GamesAll(json string)" //hive commands
      statement.execute(hiveCommand)

      println("Please wait while data loads...")
      hiveCommand = "LOAD DATA LOCAL INPATH '/tmp/p1data/gamedata.json' INTO TABLE GamesAll"
      statement.execute(hiveCommand)  

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
    
  }
  
}
