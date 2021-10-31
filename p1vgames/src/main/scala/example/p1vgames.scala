package example

import example.Login
import example.Queries

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