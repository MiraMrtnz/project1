package project1

//Method imports

import java.io.IOException
import scala.util.Try
import scala.io.StdIn.readLine // user input

//Hive imports from HiveCL notes
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

//Login import
import project1.Login

object Main {
    def main(args: Array[String]): Unit = {
        println("Welcome to the VGames App")
        println("Login to continue")
        Login.loginUser

        var con: java.sql.Connection = null; // HiveCL notes...connection
       
        println("Connecting user..")

        try{
            var driverName = "org.apache.hive.jdbc.HiveDriver"
            val connnectionString = "jbdc:hive2://sandbox-hdp.hortonworks.com:10000/p1vgames";
            
            Class.forName(driverName); // revisit

            connection = DriverManager.getConnection(connectionString, "", "")
            val statement = connection.createStatement()

            statement.executeQuery = //something initial..maybe intro or login??
            var hiveResponse = statement.executeQuery(hiveQuery)

            while(hiveResponse.next()){
                println(hiveResponse.getString(1)), hiveResponse.getString(2))
            }
        }


        def connnectionToHive(): Unit = {

        }//maybe outside main
        
    }
// define user variables

  
}
