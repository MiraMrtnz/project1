package example

import scala.io.Source 

object Login {
    var admin = "admin"
    var adminKey = "adminkey"
    var user = "mira"
    var userKey = "mirakey"
    var username = ""
    var x = 0
    

    def userSelection{
        var selectionSeq: Seq[String] = Seq("1. Admin log in","2. Already have an account? Log in.", "3. Update User", "4. Exit" )
        println("Select User")

        for(x <- selectionSeq){
            println(x)
        }

        var selection = scala.io.StdIn.readInt() //user

        selection match{
            case 1 => adminUser
            case 2 => existingUser
            case 3 => updateUser
            case 4 => exit
            case _ => println("Enter valid option..")
        }
    }


    def adminUser{
        println("Enter username")
        var username = scala.io.StdIn.readLine

        if(username == admin){
            println("Enter password")
            var pswd = scala.io.StdIn.readLine
                if(pswd == adminKey){
                    println("Hello Administrator, you're looking good today.")
                    println("Directing you to Main menu...")
                    VGames.mainScreen

                }else{
                    println("Incorrect password. Returning to Main menu.")
                    userSelection
                }

        }else{
            println("Incorrect username. Returning to Main menu.")
            userSelection
        } 
    }

    def existingUser{
        println("Enter username")
        var userInput = scala.io.StdIn.readLine

        if(userInput == user){
            println("Enter password")
            var pswd = scala.io.StdIn.readLine
                if(pswd == userKey){
                    println("Hi Mira, welcome back.")
                    println("Directing you to Main Screen...")
                    VGames.mainScreen

                }else{
                    println("Incorrect password. Returning to Login menu.")
                    userSelection
                }

        }else{
            println("Incorrect username. Returning to Login menu.")
            userSelection
        } 
    }
    

    def updateUser{
        println("1.Enter Username")
        var userInput = scala.io.StdIn.readLine

        if(userInput == admin){
            println("Hello Admin, please enter your password.")
            var pswd = scala.io.StdIn.readLine
                if(pswd == adminKey){
                    println("Sorry Admin, you cannot change your username. Returning to Login menu.")
                    userSelection
                
                }else{
                    println("Incorrect password. Returning to Login menu.")
                    userSelection
                }

        }else{
            println("Not valid username. Returning to Login menu.")
            userSelection
        }

        if(userInput == user){
            println("Hello Mira, please enter your password.")
            var pswd = scala.io.StdIn.readLine
                if(pswd == userKey){
                    println("Enter your new username")
                    var pswd = scala.io.StdIn.readLine
                    println("Your new username is: " + user)
                    println("Directing you to Main Screen...")
                    VGames.mainScreen

                }else{
                    println("Incorrect password. Returning to Login menu.")
                    userSelection
                }

        }else{
            println("Not valid username. Returning to Login menu.")
            userSelection
        }

    }

    def exit{
        var selectionSeq: Seq[String] = Seq("1. Yes, Welcome me again. ", "2. No, take me back to Login menu.")
        println("Are you sure you want to Exit to to Welcome Screen?")
        
        for(x <- selectionSeq){
            println(x)
        }
        
        var selection = scala.io.StdIn.readInt() 

        selection match{
            case 1 => println("Okay, taking you back to Welcome Screen.")
                    VGames.mainScreen
            case 2 => println("Okay, taking you back to Login menu.")
                    userSelection
        }
    } 

}




