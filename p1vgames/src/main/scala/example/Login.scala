package example

import scala.io.Source 

object Login {
    var admin = "admin"
    var user = "mira"
    var adminKey = "adminkey"
    var userKey = "miraKey"
    var updateUser = ""
    var failedAttempts = 0
    

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
           // case 3 => updateUser
           // case 4 => exit
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
                    println("Welcome Admin")
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
        var username = scala.io.StdIn.readLine

        if(username == mira){
            println("Enter password")
            var pswd = scala.io.StdIn.readLine
                if(pswd == adminKey){
                    println("Welcome Admin")
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
    

    def updateUser{
        var updateSeq: Seq[String] = Seq("1.Update Username", "2. Update Password")
        println("Select")

        for(x <- updateSeq){
            println(x)
        }
        var selection = scala.io.StdIn.readLine

        selection match{
            case 1 => println("Enter your username")
                var username = scala.io.StdIn.readLine

                if(username == admin){
                    println("Enter your password")
                    var pswd = scala.io.StdIn.readLine
                        if(pswd == adminKey){
                            println("Create new username")
                            admin = scala.io.StdIn.readLine
                            println("Your new username:" + admin)
                            println("Back to Main menu")
                            userOptions
                        }
                        else if(failedAttempts == 2){
                            println("Too many failed attempts. Returning to Main menu")
                            failedAttempts = 0
                            userOptions
                        }
                        else{
                            println("Enter valid username")
                            failedAttempts += 1
                            updateUser
                        }
                    }
                else if(username == mira){
                    println("Enter your password")
                    var pswd = scala.io.StdIn.readLine
                    if(pswd == miraKey){
                        println("Create new username")
                        user = scala.io.StdIn.readLine
                        println("Your new username:" + user)
                        println("Back to Main menu")
                        userOptions
                    }
                    else if(failedAttempts == 2){
                        println("Too many failed attempts. Resturning to Main menu")
                        failedAttempts = 0
                        userOptions
                    }
                    else{
                            println("Enter valid username")
                            failedAttempts += 1
                            updateUser
                        }
                    }
        
            case 2 => println("Enter your")
         }
        
    }
}




//while with condition =true is infinite loop