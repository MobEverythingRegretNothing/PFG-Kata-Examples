# Java Solution

For this solution I tried to spend around 30min developing (don't worry about how much code I wrote, I've done this problem tens of times).

*Payment/Capital*: I had never tried to represent the entire amount of payment or money the machine had as a structure of actual physical denominations before, which had some interesting implications:

* What if you overpay but the price doesn't split well into the payment? Example: I give you 5 dollars but the price is 1.25. I need to then extract money from the capital in the machine and balance the payment & money in the machine.
  
* I felt like this made the problem overly complicated for this sort of kata. It really made me do a lot of extra coding without prompting. Also working with more complex data structures like maps makes it much harder to read.

*Position/Inventory*: I think I could have a more interesting model of position in the machine (rows/columns). Also I did NOT make the assumption that one position could have one type and that made it very interesting to interact with each position.

*Running the Problem*: I primarily used a unit test to run the code. I do like this way, as it mirrors how I typically develop, but I think writing a `Main` loop can represent the state machine better

*Configurations*: I tried to represent a configuration with a weird interface, I'm not sure I would do that again. I try to avoid inheritence in Java (Having a Vending Machine and then modeling sub-types as children), but that might be a good way of going about it. I prefer composition though, just kind of got stuck in some weird interface zone.

*Logging*: I just used System.out to log, not doing any crazy formatting. This seemed to work fine and I think it showed my progress well.

*Error Handling*: Didn't have time to do much error handling. I kind of liked largely ignoring it until I had a good situation (interacting with the vending service), as I didn't want to start throwing Runtime Exceptions everywhere.

## Handling Time

One way I reduced the time this took was to stop myself from implementing anything super complicated. Notice that there are a couple `TODOs` I wrote that would have gotten kind of complex. If an interviewer asked me to do it I would have focused on it but no sense in wasting a bunch of time in the weeds.


Another good tactical time reduction measure was letting "hardware" (i.e. Mock Services) act instead of doing any weird implementation stuff. That way I can get the skeleton of what I want without doing too much crazy implementation.


Also making sure you have whatever sort of things you want to set up ahead of time can be time-saving and VERY impressive. Like if you are going to do the exercise in Java you probably want a Java project with a build tool & dependency manager, and whatever
dependencies you feel comfortable with that you may want to use already installed. I like a lot of base Java 8 stuff (Collections, etc) so I really only setup Junit to run tests but many people may want to use Apache Commons, they may want a library to do data generation with, etc.


And finally, I always like to request from the interviewer any way I can reduce setup. For instance if they give you a list of Products you need to include you should always try to start with a reduced set so that you can test but not spend too much time
filling out arrays/json/maps with useless items. (Although I guess if you are really good at generating test data feel free.). I've seen plenty of problems where a JSON data set is given and interviewees spend a lot of time remembering how to read in a JSON file
and convert it to a good data model. I also am not good at file I/O off the top of my head (since I mostly interact with web APIs/REST Services) and so I'd rather spend my time writing code that does stuff instead of remembering how to use the java File interfaces.

