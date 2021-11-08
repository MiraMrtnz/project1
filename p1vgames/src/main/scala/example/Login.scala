package example

import scala.io.Source 
import example.VGames

object Login {
    var admin = "Admin"
    var adminKey = "adminkey"
    var user = "Mira"
    var userKey = "mirakey"
    var username = ""
    var x = 0
    var failedAttempts = 0
    
    var returnMainMenu = true


    def userSelection: Unit ={
        
        while (returnMainMenu){
            var selectionSeq: Seq[String] = Seq("1. Admin log in","2. Already have an account? Log in.", "3. Update User", "4. Exit" )
            println("Select User")

            for(x <- selectionSeq){
                println(x)
            }

            var selection = scala.io.StdIn.readLine() //user

            selection match{
                case "1" => adminUser
                case "2" => existingUser
                case "3" => updateUser
                case "4" => exit 
                case _ => println("Enter valid option..")
            }
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
        var updateUserSeq: Seq[String] = Seq("1. Update Username ", "2. Update Password")
        println("Select an option")
        
        for(x <- updateUserSeq){
            println(x)
        }

        var selection = scala.io.StdIn.readInt

        selection match{
            case 1 => println("Enter current Username")
                    var username = scala.io.StdIn.readLine
            
                    if(username == admin){
                        println("Hello Admin, please enter your password.")
                        var pswd = scala.io.StdIn.readLine
                            if(pswd == adminKey){
                                println("Hello," + admin + "what would you like your new Username to be?")
                                println("Enter new Username")
                                admin = scala.io.StdIn.readLine
                                println("Your new Admin username is: " + admin)
                                println("Directing you to Main Screen...")
                                VGames.mainScreen
                            }else if(failedAttempts == 2){
                                println("Too many failed attempts. Returning to Login menu")
                                userSelection
                            
                            }else{
                                println("Not valid username. Returning to Login menu.")
                                failedAttempts += 2
                                userSelection
                            }
                }else if(username == user){
                        println("Hello Mira, please enter your password.")
                        var pswd = scala.io.StdIn.readLine
                            if(pswd == userKey){
                                println("Hello, " + user + " what would you like your new Username to be?")
                                println("Enter new Username")
                                user = scala.io.StdIn.readLine
                                println("Your new username is: " + user)
                                println("Directing you to Main Screen...")
                                VGames.mainScreen
                            }else if(failedAttempts == 2){
                                println("Too many failed attempts. Returning to Login menu")
                                failedAttempts = 0
                                userSelection
                            }else{
                                println("Not valid username. Returning to Login menu.")
                                failedAttempts += 2
                                userSelection
                            }  
                        }else if(failedAttempts == 2){
                            println("Too many failed attempts. Returning to Login menu")
                            failedAttempts = 0
                            userSelection
                        }else{
                            println("Enter a valid option")
                            failedAttempts +=2
                            updateUser
                        }      

            case 2 => println("Enter current Username")
                    var username = scala.io.StdIn.readLine

                    if(username == admin){
                        println("Enter your Password")
                        var pswd = scala.io.StdIn.readLine
                            if(pswd == adminKey){
                                println("Hello," + admin + "what would you like your new Password to be?")
                                println("Enter new Password")
                                adminKey = scala.io.StdIn.readLine
                                println("Your new Password is:" + adminKey)
                                println("Directing you to Main Screen...")
                                 VGames.mainScreen
                            }else if(failedAttempts == 2){
                                println("Too many failed attempts. Returning to Login menu.")
                                userSelection

                            }else{
                                println("Not valid username. Returning to Login menu.")
                                failedAttempts += 2
                                userSelection
                            }  
                    }else if(username == user){
                            println("Enter your password")
                            var pswd = scala.io.StdIn.readLine
                                if(pswd == userKey){
                                    println("Hello," + user + "what would you like your new Password to be?")
                                    println("Please enter a new Password")
                                    userKey = scala.io.StdIn.readLine
                                    println("Your password has been updated to: " + userKey)
                                    println("Directing you to Main Screen...")
                                    VGames.mainScreen
                                }else if(failedAttempts == 2){
                                    println("Too many failed attempts. Returning to Login menu")
                                    userSelection

                                }else{
                                    println("Not valid username. Returning to Login menu.")
                                    failedAttempts += 2
                                    userSelection
                                }
                        }else if(failedAttempts == 2){
                            println("Too many failed attempts. Returning to Login menu.")
                            failedAttempts = 0
                            userSelection
                        }        
            case _ => println("Enter valid selection.")
                        userSelection                  
            
        }
        
    }

    def exit{
        var selectionSeq: Seq[String] = Seq("1. Yes, get me out of here. ", "2. No, take me back to Login menu.")
        println("Are you sure you want to Exit to Welcome Screen?")
        
        for(x <- selectionSeq){
            println(x)
        }
        
        var selection = scala.io.StdIn.readInt() 

        selection match{
            case 1 => println("Okay, exiting the program.")
                    returnMainMenu = false
            case 2 => println("Okay, taking you back to Login menu.")
                    userSelection
        }
    } 

}




