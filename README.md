# Pushdown-Automata-simulation
This code will check to see if a certain string is recognized in the language of a pushdown automata.

This is part of a computational problem on Turing decidability. The problem is listed in detail below.
![Image](Images/Screenshot%202024-12-10%20155719.png)

This code checks to see if a certain string encoding of a PDA along with a string is in its language or not, returning `TRUE` if yes, or `FALSE` if no. 

## How input strings are parsed:


**The code will take in strings in the following form: `“Q, Σ, Γ, δ ,q0, F, STRING INPUT”`**

The code will then parse the what the string represents in this format, each important piece of information being separated by a comma.

**`Q`** is the set of States, it must be enclosed in `{}`. Each element is separated by a comma.

**`Σ`** is the input alphabet, or what the characters of the string being parsed will be. Must be enclosed in `{}` and separate each element by a comma.

**`Γ`** is the stack alphabet, the characters the machine pushes onto its stack. Must be enclosed in `{}` and each element separated by a comma.

**`δ`** is the transition function input. Must be enclosed in `{}`. Each element must be of the form `(q,x,y)->(qnew,z)`, `q` is the current state, `x` is the current character being read, `y` is the current top of stack. Then `qnew` is the new state, `z` is what happens to the stack. All transitions must be of this form for the machine to work.

**`q0`** is simply the starting state.

**`F`** is the set of final states, must be enclosed in `{}`, each element separated by a comma.

**`STRING INPUT`** is the string we are testing the machine against, it can be however long one wants it to be.



An example of a valid input string is:

`"{q0,q1,q2},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,a,a)->(q1,aa),(q1,b,a)->(q2,e),(q2,b,a)->(q2,e)},q0,{q2,q1},aabb"`

# Processing of two example strings in this code

## A string that returns true:

`"{q0,q1,q2,q3,q4,q5,q6},{1,0},{e,0,$},{(q0,e,e)->(q1,$),(q1,e,e)->(q2,e),(q1,e,e)->(q4,e),(q2,1,e)->(q2,0),(q2,e,e)->(q3,e),(q2,e,e)->(q5,e),(q4,0,e)->(q2,0),(q4,e,e)->(q5,e),(q5,1,0)->(q5,e),(q3,0,0)->(q3,e),(q5,e,$)->(q6,e),(q3,e,$)->(q6,e)},q0,{q6},11111111111111"`

**This string is an encoding of the following machine and string to test on it:**
![Image](Images/string%20in%20PDA%20set.png)

This will return true and we can prove why by tracing the computation. 

1. We start at q0, epsilon transition to q1 and add a bottom of the stack indicator, epsilon transition to q2. 

2. At q2 we will add 0 to the stack through the input 1 seven times, then we will pop 0 from the stack at input 1 seven times. 

3. We will then pop the stack bottom indicator and be at q6, thus making this string a member of the A_PDA language.


## A string that returns false:

`"{q0,q2,q3},{1},{e},{(q0,e,e)->(q2,e),(q0,1,e)->(q2,e),(q2,e,e)->(q0,e),(q2,1,e)->(q0,e)},q0,{q3},11111111111"`

**This string is an encoding of the following machine and string to test on it:**
![Image](Images/notin%20PDA%20set.png)

We can prove why this doesn't return true very trivially, it is simply that there is no accept state that 'q0' or `q2` have a valid transition to, q3 is the only accept state and impossible to get to given any amount of time, meaning this string is not in the set.















