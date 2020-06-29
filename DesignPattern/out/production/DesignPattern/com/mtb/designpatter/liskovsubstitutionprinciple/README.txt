What Is the Liskov Substitution Principle (LSP)?

As per the LSP, functions that use references to base classes must be able to use objects of the derived class without knowing it. In simple words, derived classes must be substitutable for the base class.


What Code Quality Characteristic Is Represented by LSP?
The following are some of the code quality characteristics that are represented by the Liskov Substitution Principle.
•	It is only when derived types are completely substitutable for their base types that functions that use those base types can be reused with impunity, and the derived types can be changed with impunity.
•	The LSP is also, at times, termed as “Design by Contract.” Using this scheme, methods of classes declare pre-conditions and post-conditions. The pre-conditions must be true in order for the method to execute. Upon completion, the method guarantees that the post-condition will be true.
•	Design by Contract does influence the declaration of “throws” exceptions, as well as the throwing of runtime exceptions and try/catch in general.

