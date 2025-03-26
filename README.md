# Pushdown-Automata-simulation
This code will check to see if a certain string is recognized in the language of a pushdown automata.

This is part of a computational problem on Turing decidability. The problem is listed in detail below.
![Image](Images/Screenshot%202024-12-10%20155719.png)


# How input strings are parsed:


**The code will take in strings in the following form: `“Q,Σ,Γ,δ,q0,F,STRING INPUT”`**

The code will then parse the what the string represents in this format, each important piece of information being separated by a comma.

**Q** is the set of States, it must be enclosed in `{}`. Each element is separated by a comma.

**Σ** is the input alphabet, or what the characters of the string being parsed will be. Must be enclosed in `{}` and separate each element by a comma.

**Γ** is the stack alphabet, the characters the machine pushes onto its stack. Must be enclosed in `{}` and each element separated by a comma.

**δ** is the transition function input. Must be enclosed in `{}`. Each element must be of the form `(q,x,y)->(qnew,z)`, q is the current state, x is the current character being read, `y` is the current top of stack. Then `qnew` is the new state, `z` is what happens to the stack. All transitions must be of this form for the machine to work.

**q0** is simply the starting state.

**F** is the set of final states, must be enclosed in `{}`, each element separated by a comma.

**STRING INPUT** is the string we are testing the machine against, it can be however long one wants it to be.

An example of this input is:

`"{q0,q1,q2},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,a,a)->(q1,aa),(q1,b,a)->(q2,e),(q2,b,a)->(q2,e)},q0,{q2,q1},aabb"`

