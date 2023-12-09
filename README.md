# ESEP Data Processing and Storage Assignment

To run the code, simply download both java files, place them in the same directory, and execute the `main` function in `DatabaseTests.java`.

## How to Improve this Assignment
I would've kept it at 5 sentences but I have very strong feelings about this for some reason.

1. Provide better tests for various programming languages and make them actually work (the given Java code is a mess; half the lines don't even have semicolons and an interface is instantiated on line 1).
2. Make it a bit clearer that you should do this in any programming language you want, I missed one line in the instructions and thought it had to be done in Java due to the example.
3. Alternatively, restrict the programming language and have a testing suite that can be run on the program so the student doesn't have to type the tests themselves. It's also infinitely easier to grade and doesn't rely on the students to submit instructions on how to run the program.
4. Rename rollback() to abort() or something similar. The current name makes it feel like it would roll back a previously committed change to the previous state.
5. Make a rollback() method that makes you roll back a previously committed change.
6. Elaborate on how the "Working Code" section of the grade is going to be tested. Are you just going to use a test function the student provides?
