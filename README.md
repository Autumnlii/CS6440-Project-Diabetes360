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
   - Specify the value and the date (month/day)
2. Enter how much exercise done 
   - Specify the value (minutes) and the date (month/day)
3. Enter if the user takes the medications today
   - Choose Yes or No to indicate whether the user takes the medications. 
5. Show past 7 days blood sugar level
   - Allow users to see the historical trend of the blood sugar
6. Show the past 7-days exercise trend
   - Allow users to see the historical trend of the exercise
7. Enter contact information
   - Specify the shared contact information   
8. Email the sql queries to different people

