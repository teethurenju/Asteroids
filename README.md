Asteroids
--------------------------------------

Asteroids application shows is a RESTful web service for near earth Asteroid information. 

Java Module contains AsteroidsApplication class which works as a Asteroids api which have options to search for Asteroids based on their closest 	approach date to Earth.

The Asteroids application supports the following operations:

1. Show 10 asteroids that passed the closest to Earth between two user-provided dates.
2. Show characteristics of the largest asteroid (estimated diameter) passing Earth during a user-provided year.


How to run the module
--------------------------------------

1. Run the main class in AsteroidsApplication.java.
2. From postman hit the URL for 10 asteroids that passed the closest to Earth between two user-provided dates

		Example :- http://localhost:8080/v1/spondAsteroidsApi/near-asteroids?startDate=2008-08-24&endDate=2008-08-26
		
3. From postman hit the URL for characteristics of the largest asteroid (estimated diameter) passing Earth during a user-provided year

		Example :- http://localhost:8080/v1/spondAsteroidsApi/large-asteroid?year=2008


Implementation Details
--------------------------------------

Implementation consist of 2 methods for retrieving near asteroids to Earth and largest asteroid using estimated diameter.


Method Details
--------------------------------------

	getAsteroids
	---------
	1. Method accepts startDate and endDate.
	2. If start and end date pattern is incorrect will throw an exception
	3. Then invoke the asteroids details from database
	4. If the asteroids details is not available for the user provided dates, then will call for the external api and save 		the details to database
	5. Method will return 10 asteroids details 
	
	getLargeAsteroidsDetails
	----------
	1. Method accepts year.
	2. Invoke the asteroids details from database.
	3. Method will return characteristics of the largest asteroid
		
	getAsteroidsDetails
	----------
	1. Method accepts startDate and endDate.
	2. Call to the external api
	3. Method will return the body
	
	  
	For Example:
	URL:- http://localhost:8080/v1/spondAsteroidsApi/near-asteroids?startDate=2008-08-24&endDate=2008-08-26
	
	Output:-    
		
	[
        902,
        "(2021 WA1)",
        "54224159",
        "2008-08-24",
        17.1411509231
    ],
    [
        915,
        "(2021 PR6)",
        "54184278",
        "2008-08-25",
        93.7648317729
    ],
    [
        892,
        "(2021 JQ2)",
        "54144233",
        "2008-08-26",
        5.9161609261
    ],
    [
        891,
        "(2021 HS1)",
        "54139083",
        "2008-08-26",
        33.422580561
    ],
    [
        914,
        "(2020 BF10)",
        "3989235",
        "2008-08-25",
        21.5794304844
    ],
    [
        890,
        "(2020 AU)",
        "3972420",
        "2008-08-26",
        43.0566244241
    ],
    [
        889,
        "(2019 KG7)",
        "3843056",
        "2008-08-26",
        622.3575733667
    ],
    [
        913,
        "(2019 FU2)",
        "3840743",
        "2008-08-25",
        39.2681081809
    ],
    [
        901,
        "(2019 EB1)",
        "3838898",
        "2008-08-24",
        45.0858206172
    ],
    [
        900,
        "(2019 BT2)",
        "3838020",
        "2008-08-24",
        472.1064988055
    ]
    
    URL:- http://localhost:8080/v1/spondAsteroidsApi/large-asteroid?year=2008
   
    Output:-
     
     [
        1241.766612574,
        "481775 (2008 SX7)",
        "2481775",
        "2008-08-26"
    ]
    
 Solution Implemented
--------------------------------------
Currently system will check the asteroid details for the user provided dates which is available in database or not . If not available will invoke the external api and get the details and save in database.

System will filter 10 asteroids details and return the details to user.

	System Limitations
		The Feed date limit is only 7 Days. So we are saving the data for 7 days based on the user provided date.
		If the user search for a data for a year they will get the database saved details only.
		 
Other Solution(Not Implemented)
--------------------------------------
We can implement external api call with a cron job and save the details to database.
System will filter 10 asteroids details and return the details to user.

  
  

