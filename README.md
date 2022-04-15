# KotlinKalculator
Calculator created using Kotlin to mimic the Windows calculator application.

To run program, open 'build.gradle' with Intellij IDEA and run from main function.

Short Demo: https://youtu.be/P0YjwKYUwd8 (Cursor disapearing was a problem with the video not the application)

Changes to be made:
 1. Spend some more time on the UI
 2. Add a respresentation of the current equation above the number displayed on the calculator
 3. Remove the decimal in the case that it is a whole number
 
Overall, it went pretty smoothly and I began to get a pretty good understanding of Compose and Kotlin. My main problem I ran into was that I have all of the buttons piled on top of each other in rows in one 'draw()' function wihtin my calculator class. I thought there must be a way to create a class that could have objects instantiated from it and could draw a button with my desired design customizations, but I ran into problems where I was unable to use some modifiers if the 'Button()' was not directly placed within a 'Row()'. Definitely would want to look for ways to fix this in order to have a better class structure.
