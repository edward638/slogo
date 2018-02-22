## Part 1

* What about your API/design is intended to be flexible?

Our API design is intended to have a clear separation of responsibility between different components. That way, if we wanted to add extra features to one component, this separation would allow for this to happen without things getting messy. 

* How is your API/design encapsulating your implementation decisions?

The internal APIs are designed to carry out functions only within its own class and external APIs do not give out unnecessary information.

* What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?

If the user types in an incorrect command, we handle this by passing the command onto the Parser, which will handle the error on its own; thus, we delegate the responsibility of command errors to the back-end.

* Why do you think your API/design is good (also define what your measure of good is)?

Our internal and external APIs are very easy to use and the methods defined are self-explanatory. This allows the user to easily learn the commands without knowing extra information of the simulation.

Both people should complete Part 1 before continuing on to Part 2.

## Part 2

* How do you think Design Patterns are currently represented in the design or could be used to help improve the design?

We specifically use design patterns to enable the different components to interact with one another externally. One example of this is the Observable pattern, which is when one component (in this case, the view) is listening for changes in another component (in this case, the model) in order to update themselves.

* What feature/design problem are you most excited to work on?

We are most excited to figure out how to communicate the frontend with the backend by using Properties, Observables, Listeners, and possibly lambda functions. These features and design patterns are new to us and we embrace this new implementation challenge.

* What feature/design problem are you most worried about working on?

We are worried about using properties because this is newfound territory for us, so we don’t know whether this approach fits well with our API design.

* Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).

1. The user enters a setBackground() command with an invalid color (e.g. the hex code is not valid) so the console will display an error about the invalid background.
2. The user types 'PRODUCT 21 8', the CommandParser checks and returns that this Math Operation command, then the product of 21 and 8 is printed in the Console.
3. User inputs ‘MAKE :X 5’ into the Command Box in the GUI and presses the Run button. A new variable x should be created and its value should be 5.
4. User clears all the command box and the command box is cleared of text
5. The user clicks “run” when the command box has a bunch of spaces - the program should bring the cursor back to the starting position and not execute any function
