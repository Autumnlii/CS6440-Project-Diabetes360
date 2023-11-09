# Changes made


# General notes of how things work
* MainActivity is the entry point
  * under src/main/java/edu.gatech.seclass.diabetes360/activities/MainActivity.java
* can define core classes under src/main/java/edu.gatech.seclass.diabetes360/
* Layouts are the different pages
  * under src/main/res/layout
  * activity_main.xml is the landing page
  * can define others here with on-click
* app/build.gradle, BuildConfig stuff for app name, etc

# Use cases of the application
1. Enter blood sugar level
   1. Specify the value and the date (month/day)
2. Enter how much exercise done 
   1. Current total
   2. new Exercise
   3. Specify the value (minutes) and the date (month/day)
3. Enter how much portions in the following categories: fish, veggies, fruits, red meat
4. in the end, will want to plot the historical data
5. Email the sql queries to different people
6. Set a reminder/Enter times to take medicine to take the medicine at x intervals (pop up)
   1. Set the date and time
   2. which medicine, dosage, with/without food
   3. 
