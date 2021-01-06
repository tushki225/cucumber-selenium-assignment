Feature: Verification of countdown functionality of EggTimer Website 

	Scenario Outline: Egg Timer Page Load successful 
		Given I open the EggTimer website <url> and launched the application			
		When I verify the title of the page	
		Then I verify Page load is successful
		
		Examples:                  		
		| url                    |		
		| http://e.ggtimer.com/  |  	

	Scenario Outline: Specify Timer and validate countdown of the timer 
		Given I open the EggTimer website <url> and launched the application			
		Then I verify Page load is successful
		And I Specify time in seconds <time>
		When I click Start button
		Then I verify counter <time>
		
		Examples:                  		
		| url                    | time      |		
		| http://e.ggtimer.com/  | 25        |
#		| http://e.ggtimer.com/  | 70        |
#		| http://e.ggtimer.com/  | 2 minutes |
#		| http://e.ggtimer.com/  | 2m        |
#		| http://e.ggtimer.com/  | 1 hour    |
#		| http://e.ggtimer.com/  | 1 hour 4 minutes   |
#		| http://e.ggtimer.com/  | 2 minutes 3 second |
		