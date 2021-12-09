PROJECT ONE:
    
    - A video game application that loads data from RAWG Video Game Data 
      API and queries HiveQL queries on data

Tech Stack: 


    - Visual Studio Code
    - Scala 2.11.8 + SBT
    - Hadoop HDFS, YARN, and HIVE
    - Alpha Vantage API
    - Git / Github

Features:


    - A login menu for Admin and Basic Users
    - Retrieves the most current video game information from RAWG API
    - Automated loading of JSON data file in Hive table for querying
    - VArious types of HiveQL aggregations:
        - Highest Rated Games
        - Average Playtime for Top 10 Games
        - Top Games By Genre


Project Setup:


    - Clone this repository to the desired location on your machine
    - To use and run this application, the user must have Hadoop Ecosytem and Hive installed
    - Create a file "gamesdata.json" in local machine in path "/tmp/p1data/gamesdata.json"
    - Create a directory in HDFS user path called "GamesAllData"
    - Create a Hive Database called "project1_database"

Usage:


    - Ensure there are no errors and use "clean" command in VSC terminal 
    - Package the scala project into a jar file with "package" command in VSC terminal
    - Secure Copy (-scp) the jar file to your Hadoop environment "scala projects" (or desired directory)
    - Spark-Submit the jar file to run the program
    - LOAD gamesdata.json into Hive table 
    - Query and Analyse data

Contributor:


    Mira Martinez

