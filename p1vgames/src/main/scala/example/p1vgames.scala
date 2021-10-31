package example

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
import example.Login

object VGames {
    def main(args: Array[String]){
        println("Welcome to the VGames App") //Initial
        
        println("Loading, please wait...")

        println("Login Menu")
        Login.userSelection

    
    }
    def mainScreen{
        println("Welcome to Main Screen")
    }
}