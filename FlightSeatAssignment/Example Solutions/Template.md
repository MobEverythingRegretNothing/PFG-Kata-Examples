# Requirement Gathering

This problem has a lot of ambiguity to resolve. It's giving you free reign to come up with a broad range of solutions based on how creative you want to get. Below are some examples of questions that can resolve some of the ambiguity

*What constitutes a "Blocked" seat?*

These definition resolution questions are important. There is extra info added to the problem that the directions did not specify. Is that something we need to worry about? Is it going to affect the outcome? Are the same seats blocked in every plane or is it on a per-flight basis? 

*How are we measuring the success of the system?*

This is a good general question to poke at, especially if there is no good description in the problem. A lot of times katas will ask for the "best" solution, but that could mean a lot, especially with technical limitations. In regards to this question it could mean fitting a specific algorithm the interviewer wants, it could be based on how good a fit the result is when compared to user preferences, or it could even be based on metrics we won't get ("User Happiness", "Survey Results"). Each of these points to a different way of thinking about the problem.

*What sort of data do we have access to in regards to the user preference?*

It's good to know the limitations of our data. We don't know what preferences the users are allowed to have, or where we are getting that data. The interviewer may provide you a list of preferences (window vs aisle, front vs back, blocks of seats together, nearness to bathroom) or they may let you imagine what sort of preferences airlines might care about.

*What should we do in the case that user preferences are equal/unable to be met*

Let's say that a user's only preference is a window seat but - Oops, there are none available on this flight! How might we resolve this? You could ignore this user's preferences, you could give them a highly desireable seat, you could put them in a middle seat (is a middle seat the next best thing?). All good things to think through. 


# Architecture and Design

