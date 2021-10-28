package project1

import scala.io.Source 

object Login {
    var Admin = "Admin"
    var User = "Mira"
    var newUser = ""


    def selection{
        var selectionSeq: Seq[String] = Seq("1. Admin log in","2. Already have an account? Log in.", "3. New User" )
        println("Select")

        for(x <- selectionSeq){
            println(x)
        }

        var selection = scala.io.StdIn.readInt() //user

        selection match{
            case 1 => adminUser
            case 2 => existingUser
            case 3 => newUser
            case 4 => exit
            case _ => println("Enter valid option..")
        }
    }


    def User{

        if(username == admin){
            println("Enter password")
            var pswd = scala.io.StdIn.readLine
            if(pswd == adminKey){
                println("Welcome Admin")
            }
        }
        else if(username == mira){
            println("Enter password")
            var pswd = scala.io.StdIn.readLine
            if(pswd == mirapwd){
                println("Welcome Mira")
            }
        }
        else if(username == ""){
            println("Create new username")
            var newUser = scala.io.StdIn.readLine
            println("Create new password")
            var pswd = scala.io.StdIn.readLine
        }
        else{
            println("Enter valid option")
            loginUser    
        } 
    }
}
