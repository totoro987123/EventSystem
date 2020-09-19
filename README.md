# EventSystem

The files in src are the core and can be used in other projects.
The files in example are the core + some that use it to demonstrate the functionality of the system.

This event system was created with the goal of stream lining event management in Java. 
Most event systems use complex inheritance or interface schemes in order to have event listeners, each oh which can only listen to one event at once.
This system allows for the removal of both inheritance/interface schemes aswell as allowing classes to listen to multiple things directly.
