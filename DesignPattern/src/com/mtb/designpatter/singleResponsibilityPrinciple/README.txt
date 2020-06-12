SRP: Single Responsibility Principle

As the name suggests, this principle states that each class should have one responsibility, one single purpose.
This means that a class will do only one job, which leads us to conclude it should have only one reason to change.

We don’t want objects that know too much and have unrelated behavior.
These classes are harder to maintain. For example, if we have a class that we change a lot,
 and for different reasons, then this class should be broken down into more classes, each handling a single concern.
 Surely, if an error occurs, it will be easier to find.

Let’s consider a class that contains code that changes the text in some way.
The only job of this class should be manipulating text.

===================================================================================================================
…In object-oriented programming, the single responsibility principle states that every class should have a single responsibility, and that responsibility should be entirely encapsulated by the class. All its services should be narrowly aligned with that responsibility….
From Clean Code:
A class or module should have one, and only one, reason to change.
So if a class (or module) needs to be modified for more than one reason, it does more than one thing. I.e. has more than one responsibility.
Why SRP?
•	Organize the code
Let’s imagine a car mechanic who owns a repair shop.
He has many many tools to work with. The tools are divided into types; Pliers, Screw-Drivers (Phillips / Blade), Hammers, Wrenches (Tubing / Hex) and many more. How would it be easier to organize the tools?
Few drawers with different types in each one of them?
Or, many small drawers, each containing a specific type?Now, imagine the drawer as the module. This is why many small modules (classes) are more organized then few large ones.
•	Less fragile
When a class has more than one reason to be changed, it is more fragile.
A change in one location might lead to some unexpected behavior in totally other places.
•	Low Coupling
More responsibilities lead to higher coupling.
The couplings are the responsibilities.
Higher coupling leads to more dependencies, which is harder to maintain.
•	Code Changes
Refactoring is much easier for a single responsibility module.
If you want to get the shotgun effect, let your classes have more responsibilities.
•	Maintainability
It’s obvious that it is much easier to maintain a small single purpose class, then a big monolithic one.
•	Testability
A test class for a ‘one purpose class’ will have less test cases (branches).
If a class has one purpose it will usually have less dependencies, thus less mocking and test preparing.
The “self documentation by tests” becomes much clearer.
•	Easier Debugging
Since I started doing TDD and test-first approach, I hardly debug. Really.
But, there come times when I must debug in order to understand what’s going on.
In a single responsibility class, finding the bug or the cause of the problem, becomes a much easier task.
What needs to have single responsibility?
Each part of the system.
•	The methods
•	The classes
•	The packages
•	The modules
How to Recognize a Break of the SRP?
•	Class Has Too Many Dependencies
A constructor with too many input parameters implies many dependencies (hopefully you do inject dependencies). Another way too see many dependencies is by the test class.
If you need to mock too many objects, it usually means breaking the SRP.
•	Method Has Too Many Parameters
Same as the class’s smell. Think of the method’s parameters as dependencies.
•	The Test Class Becomes Too Complicated
If the test has too many variants, it might suggest that the class has too many responsibilities.
It might suggest that some methods do too much.
•	Class / Method is Long
If a method is long, it might suggest it does too much.
Same goes for a class.
My rule of thumb is that a class should not exceed 200-250 LOC. Imports included
•	Descriptive Naming
If you need to describe what your class / method / package is using with the AND world, it probably breaks the SRP.
•	Class With Low Cohesion
Cohesion is an important topic of its own and should have its own post.
But Cohesion and SRP are closely related and it is important to mention it here.
In general, if a class (or module) is not cohesive, it probably breaks the SRP. A hint for a non-cohesive class:
The class has two fields. One field is used by some methods. The other field is used by the other methods.
•	Change In One Place Breaks Another
If a change in the code to add a new feature or simply refactor broke a test which seems unrelated, it might suggest a breaking the SRP.
•	Shotgun Effect
If a small change makes a big ripple in your code. If you need to change many locations it might suggest, among other smells, that the SRP is broken.
•	Unable to Encapsulate a Module
I will explain using Spring, but the concept is important (not the implementation).
Suppose you use the @Configuration or XML configuration.
If you can’t encapsulate the beans in that configuration, it should give you a hint of too much responsibility.
The Configuration should hide any inner bean and expose minimal interfaces.
If you need to change the Configuration due to more than one reason, then, well, you know…
How to make the design compliant with the Single Responsibility Principle
The suggestions below can apply to other topics of the SOLID principles.
They are also good for any Clean Code suggestion.
But here they are aimed for the Single Responsibility Principle.
•	Awareness
This is a general suggestion for clean code.
We need to be aware of our code. We need to take care.
As for SRP, we need to try and catch as early as we can a class that is responsible for too much.
We need to always look for a ‘too big method’.
•	Testable Code
Write your code in a way that everything can be tested.
Then, you will surly want that your tests be simple and descriptive.
•	TDD
(I am not going to add anything here)
•	Code Coverage Metrics
Sometimes, when a class does too much, it won’t have 100% coverage at first shot.
Check the code quality metrics.
•	Refactoring and Design Patterns
For SRP, we’ll mostly do extract-method, extract-class, move-method.
We’ll use composition and strategy instead of conditionals.
•	Clear Modularization of the System
When using a DI injector (Spring), I think that Configuration class (or XML) can pinpoint the modules design. And modules’ single responsibility.
I prefer to have several small to medium size of configuration files (XML or Java) than having one big file / class.
It helps see the responsibility of the module and easier to maintain.
I think that the configuration approach of injection has an advantage of annotation approach. Simply because the Configuration approach put the modules in the spotlight.

