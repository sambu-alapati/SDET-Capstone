Feature: Home Page Functionalities 


Background:
   Given the user is on the login page
   When the user is logged in with valid username "Sambu9" and valid password "Sambu@123"
   And clicks the login button
 
Scenario: User Searchbar Functionality 
When User enter "Amazon Parrot" bird in searchbar
And Clicks the search button 
Then User Should able to see data releated to it 

