
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

//MAIN THING, THING ABOUT A STACK DECISION TREE THAT YOU CAN MAKE
@SuppressWarnings("unchecked")
public class newPDA {

    int timer = 0;
    //the states in the 6-tuple, we are mainly just checking for validity
    HashSet<String> states = new HashSet();
    //the alphabet in the 6-tuple
    HashSet<Character> alphabet = new HashSet();
    //the stackalphabet in the 6-tuple
    HashSet<Character> stackalphabet = new HashSet();
    //the start state in the 6-tuple
    String start;

    //the transition function in the 6-tuple
    //we will store the current stack state and current input
    //to see what it will map to
    HashMap<String, ArrayList<String[]>> transition = new HashMap();

    //the final states in the 6-tuple
    HashSet<String> finalstates = new HashSet();
    int stackmax = 0;
    int timemax = 0;

    String in;
    public static int maxInd;

    //this is the string we are testing against
    String isInLang;
    boolean canrun = true;
    boolean isIn = false;
    Stack<OtherStack> choiceList = new Stack();

    newPDA(String in) {
        int i = 0;
        this.in = in;
        maxInd = in.length() - 1;
        i = parseStates(i);
        i = parsealphabet(i);
        i = parsestackalphabet(i);
        i = parsetransitions(i);
        i = parsestart(i);
        i = parseaccept(i);
        i = testedStringParser(i);
        if (i < maxInd) {
            canrun = false;
        }
        //stackmax = Integer.MAX_VALUE;
        //timemax = Integer.MAX_VALUE;
        stackmax = (isInLang.length() + 2) * (states.size()) * (states.size());
        timemax = isInLang.length() * (states.size()) * (states.size());

    }

    private int parseStates(int i) {
        while (in.charAt(i) != '{' && i < in.length()) {
            i++;
        }
        if (in.charAt(i) == '{') {
            i++;
            StringBuilder sb = new StringBuilder();
            while (in.charAt(i) != '}' && i < in.length()) {

                if (in.charAt(i) == ',') {
                    states.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(in.charAt(i));
                }
                i++;
            }
            states.add(sb.toString());
            sb.setLength(0);
            i += 2;

            //debugging
            /*System.out.println("The states are: ");
            for (String element : states) 
            { 
                System.out.print(element + " "); 
            }*/
            return i;
        } else {
            return -1;
        }
    }

    private int parsealphabet(int i) {
        while (in.charAt(i) != '{' && i < in.length()) {
            i++;
        }
        if (in.charAt(i) == '{') {
            i++;
            while (in.charAt(i) != '}' && i < in.length()) {

                if (in.charAt(i) != ',') {
                    alphabet.add(in.charAt(i));
                }
                i++;
            }
            i += 2;

            //debugging
            /*System.out.println();
            System.out.println("The alphabet is: ");
            for (Character element : alphabet) 
            { 
                System.out.print(element + " "); 
            }*/
            return i;
        } else {
            return -1;
        }
    }

    private int parsestackalphabet(int i) {
        while (in.charAt(i) != '{') {
            i++;
        }
        if (in.charAt(i) == '{') {
            i++;
            while (in.charAt(i) != '}' && i < in.length()) {

                if (in.charAt(i) != ',') {
                    stackalphabet.add(in.charAt(i));
                }
                i++;
            }
            i += 2;

            //debugging
            /*System.out.println();
            System.out.println("The stack alphabet is: ");
            for (Character element : stackalphabet) 
            { 
                System.out.print(element + " "); 
            }*/
            return i;
        } else {
            return -1;
        }
    }

    private int parsetransitions(int i) {
        while (in.charAt(i) != '{' && i < in.length()) {
            i++;
        }
        if (in.charAt(i) == '{') {
            i++;
            StringBuilder sb = new StringBuilder();
            while (in.charAt(i) != '}') {
                if (in.charAt(i) == '(') {
                    i++;
                    while (in.charAt(i) != ')') {
                        sb.append(in.charAt(i));
                        i++;
                    }
                    String input = sb.toString();
                    sb.setLength(0);

                    //get output now
                    String[] output = new String[2];
                    while (in.charAt(i) != '(') {
                        i++;
                    }
                    i++;

                    //get the state info first
                    while (in.charAt(i) != ',') {
                        sb.append(in.charAt(i));
                        i++;
                    }
                    i++;

                    //record the stack info
                    output[0] = sb.toString();
                    sb.setLength(0);
                    while (in.charAt(i) != ')') {
                        sb.append(in.charAt(i));
                        i++;
                    }
                    //stack info recorded
                    output[1] = sb.toString();
                    sb.setLength(0);
                    if (!transition.containsKey(input)) {
                        transition.put(input, new ArrayList());
                    }
                    ArrayList<String[]> add = transition.get(input);
                    add.add(output);

                }
                i++;
            }
            i++;

            for (Map.Entry<String, ArrayList<String[]>> entry : transition.entrySet()) {
                String key = entry.getKey();
                ArrayList<String[]> value = entry.getValue();
                System.out.println();
                System.out.println("function: " + key);
                System.out.println("maps to : ");
                // Iterate through the ArrayList associated with the current key 
                for (String[] item : value) {
                    System.out.println(item[0] + "," + item[1]);
                }
            }

            return i;
        } else {
            return -1;
        }
    }

    private int parsestart(int i) {
        //System.out.println();
        //System.out.print(in.charAt(i));
        if (in.charAt(i) == ',') {
            i++;
        }
        while ((in.charAt(i) == ' ' && i < maxInd)) {
            //System.out.print(in.charAt(i));
            i++;
            //System.out.print(in.charAt(i));
        }
        if (i < in.length()) {
            //System.out.print(in.charAt(i));
            StringBuilder sb = new StringBuilder();
            while (in.charAt(i) != ',') {

                sb.append(in.charAt(i));
                i++;
            }
            start = sb.toString();
            //System.out.println("start state: " + start);
            //System.out.println();
            return i;
        } else {
            return -1;
        }

    }

    private int parseaccept(int i) {
        while (in.charAt(i) != '{' && i < in.length()) {
            i++;
        }
        if (in.charAt(i) == '{') {
            i++;
            StringBuilder sb = new StringBuilder();
            while (in.charAt(i) != '}' && i < in.length()) {

                if (in.charAt(i) == ',') {
                    finalstates.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(in.charAt(i));
                }
                i++;
            }
            finalstates.add(sb.toString());
            sb.setLength(0);
            i += 2;

            //debugging
            /*System.out.println("The final states are: ");
            for (String element : finalstates) 
            { 
                System.out.print(element + " "); 
            }*/
            return i;
        } else {
            return -1;
        }
    }

    private int testedStringParser(int i) {
        StringBuilder sb = new StringBuilder();

        /*System.out.println();
        System.out.println(i);
        System.out.println(in.charAt(i));
        System.out.println("max index: " + maxInd);
        System.out.println();*/
        while (i < maxInd) {
            //sb.append("");
            //System.out.println(in.charAt(i));
            if (in.charAt(i) != 'e') {
                sb.append(in.charAt(i));
                i++;
            }
        }
        if (i < in.length() && in.charAt(i) != 'e') {
            sb.append(in.charAt(i));
        }

        //System.out.println(sb.toString());
        //System.out.println(i);
        isInLang = sb.toString();
        //System.out.print(isInLang);
        return i;
    }

    public boolean membershiptest() {
        if (!canrun) {
            System.out.println("BAD INPUT");
            return canrun;
        } else {
            Stack<Character> stack = new Stack();
            stack.push('e');
            calculator(0, stack, start);

        }

        return isIn;

    }

    public void calculator(int inputindex, Stack<Character> currStack, String currState) {
        OtherStack inital = new OtherStack(currState, inputindex, currStack);
        choiceList.push(inital);
        HashSet<String> history = new HashSet();
        System.out.println(inputindex);

        do {
            //evaluate choice at the top of the stack/most recent choice
            OtherStack currChoice = choiceList.pop();
            //this will be the PDA's current state, current stack, and current character int he input it is reading
            inputindex = currChoice.inputIndex();
            currState = currChoice.state();
            Stack<Character> currPDA = currChoice.PDAstack();
            char top = currPDA.peek();
            System.out.println(isInLang.length());
            if (finalstates.contains(currState) && inputindex == isInLang.length()) {
                isIn = true;
                break;
            }

            System.out.println();
            System.out.println("The current choicecount is : " + choiceList.size());
            System.out.println("The current inputINdex : " + inputindex);

            //System.out.println("Current character : " + isInLang.charAt(inputindex));
            System.out.println("Current stack size is: " + currPDA.size() + ", current peak is : " + top);
            System.out.println("current state evaluated is " + currState);

            //there are 2 types of spontaneous transitions we can have
            //check for spontaneous transition, this will mean it doesn't matter the input nor the stack
            String sponta = currState + ",e,e";

            //this one doesn't care for input, but it cares for stack
            String spontb = currState + ",e," + currPDA.peek();

            String stackchange = " ";
            String curr = " ";
            if (inputindex < isInLang.length()) {
                //this reads the current input for the function, which is currstate, current character being read, and top of PDA stack
                curr = currState + "," + isInLang.charAt(inputindex) + "," + top;

                //this one will add to the stack regardless of what is on the top of it
                stackchange = currState + "," + isInLang.charAt(inputindex) + "," + 'e';
            }

            //if we are at the same character being read, same exact state, and have the same sized PDA, there has been a loop
            if (!history.contains(inputindex + currState + currPDA.size())) {
                //now that we've been here, update the history
                history.add(inputindex + currState + currPDA.size() + top);
                System.out.println();
                System.out.println("sponta = : " + sponta);
                System.out.println("spontb = : " + spontb);
                System.out.println("stackchange = : " + stackchange);
                System.out.println("curr = : " + curr);
                System.out.println();

                //look at the sponta case
                checksponta(sponta, inputindex, currPDA, top);

                //look at spontb case
                checkspontb(spontb, inputindex, currPDA, top);

                //look at the pda top ignoring case that focuses on character input
                checkstackchange(stackchange, inputindex, currPDA, top);

                //look at the normal case
                checkcurr(curr, inputindex, currPDA, top);

            } else {
                System.out.println("stopped a possible loop");
                System.out.println("Would have collided with : " + inputindex + currState + currPDA.size());
            }
            System.out.println("looped :" + choiceList.size());
            timer++;
        } while (timer < timemax && !choiceList.empty());

    }

    public void checksponta(String sponta, int inputindex, Stack<Character> currPDA, char top) {
        if (transition.containsKey(sponta)) {
            System.out.println("sponta");
            //get the arraylist of choices from the function and what it maps to
            ArrayList<String[]> possibilities = transition.get(sponta);

            for (String[] in : possibilities) {
                System.out.println(sponta + " maps to : " + in[0] + "," + in[1]);
                //this will be the modified stack we put into choice stack
                //since this is spontaneous, we just want to see if we add to stack or do nothing to it
                Stack<Character> temp = new Stack();
                temp.addAll(currPDA);

                //now to see what happens to stack
                //since this is spontaneous where we have (state, e, e) -> (newstate, stackchange)
                //we only have the following shocases add to stack, or do nothing to stack
                if (in[1].charAt(0) != 'e') {
                    temp.push(in[1].charAt(0));
                }
                //index stays the same
                //state is something we want to see change however
                //we put it in as state, index, stack
                OtherStack toAdd = new OtherStack(in[0], inputindex, temp);
                if (stackmax >= temp.size()) {
                    choiceList.push(toAdd);
                }
            }
        }
    }

    public void checkspontb(String spontb, int inputindex, Stack<Character> currPDA, char top) {
        //case where its spontaneous, but we only do stuff to the stack
        if (transition.containsKey(spontb)) {
            //get the arraylist of choices from the function and what it maps to
            ArrayList<String[]> possibilities = transition.get(spontb);
            System.out.println("spontb");
            for (String[] in : possibilities) {
                System.out.println(spontb + " maps to : " + in[0] + "," + in[1]);
                //here we can push, pop, or do nothing to the stack, so we have three options
                Stack<Character> temp = new Stack();
                temp.addAll(currPDA);
                if (top == 'e' && in[1].charAt(0) != 'e') {
                    System.out.println("adding to empty stack");
                    temp.push(in[1].charAt(0));
                    System.out.println("Size is now " + temp.size());
                } else if (in[1].charAt(0) == 'e' && top != 'e') {
                    System.out.println("Popping " + top + ",current size is : " + temp.size());
                    temp.pop();
                    System.out.println("Size is now " + temp.size());
                } else if (in[1].length() == 2) {
                    System.out.println("adding to stack");
                    temp.push(in[1].charAt(0));
                    System.out.println("Size is now " + temp.size());
                } else {
                    System.out.println("Not changing stack");
                }
                OtherStack toAdd = new OtherStack(in[0], inputindex, temp);
                if (stackmax >= temp.size()) {
                    choiceList.push(toAdd);
                }
            }
        }
    }

    public void checkstackchange(String stackchange, int inputindex, Stack<Character> currPDA, char top) {
        //this input is where we actually consume a character and either do something to the stack or don't
        if (inputindex < isInLang.length() && transition.containsKey(stackchange)) {
            //stackchange of the format (currstate,character read,e) -> (newstate,something or nothing happens to stack)
            System.out.println("stackchange");
            ArrayList<String[]> possibilities = transition.get(stackchange);
            System.out.println();

            //the only thing this can be is us adding to the stack regardless of what's on it
            //the only case therefore is adding to the stack
            for (String[] in : possibilities) {
                Stack<Character> temp = new Stack();
                temp.addAll(currPDA);

                System.out.println(stackchange + " maps to : " + in[0] + "," + in[1]);
                if (in[1].charAt(0) != 'e') {
                    System.out.println("adding to stack regardless of whats at the top for size : " + temp.size());
                    temp.push(in[1].charAt(0));
                    System.out.println("Size is now " + temp.size());
                }

                OtherStack toAdd = new OtherStack(in[0], inputindex + 1, temp);
                if (stackmax >= temp.size()) {
                    choiceList.push(toAdd);
                }

            }

        }
    }

    public void checkcurr(String curr, int inputindex, Stack<Character> currPDA, char top) {
        if (inputindex < isInLang.length() && transition.containsKey(curr)) {
            System.out.println("curr");
            ArrayList<String[]> possibilities = transition.get(curr);

            System.out.println();
            for (String[] in : possibilities) {
                Stack<Character> temp = new Stack();
                temp.addAll(currPDA);
                System.out.println("THIS IS THE STACK SIZE HERE : " + currPDA.size());

                System.out.println(curr + " maps to : " + in[0] + "," + in[1]);
                //we have two cases, do something to stack, don't do something to stack

                //checks if the stack input is empty, if the input is empty we could:
                //push to the stack since it is empty
                if (top == 'e' && in[1].charAt(0) != 'e') {
                    System.out.println("adding to empty stack");
                    temp.push(in[1].charAt(0));
                    System.out.println("Size is now " + temp.size());
                } else if (in[1].charAt(0) == 'e' && top != 'e') {
                    System.out.println("Popping " + top + ",current size is : " + temp.size());
                    temp.pop();
                    System.out.println("Size is now " + temp.size());
                } else if (in[1].length() == 2) {
                    System.out.println("adding to stack");
                    temp.push(in[1].charAt(0));
                    System.out.println("Size is now " + temp.size());
                } else {
                    System.out.println("Not changing stack");
                }

                //we consume a character of input, so we continue the index
                OtherStack toAdd = new OtherStack(in[0], inputindex + 1, temp);
                if (stackmax >= temp.size()) {
                    choiceList.push(toAdd);
                }
            }
        }
    }

    /*public boolean calculator(int index, Stack<Character> currstack, String currState)
    {
        timer++;
        System.out.println(timer + "   "+ currstack.size());
        if(isIn == true || timer > 5)
        {
            return false;
        }
        //the pda's actual stack
        Stack<Character> PDAstack = new Stack();
        PDAstack.addAll(currstack);
        //pushing the empty string to indicate
        //our stack has nothing in it currently
        for(int i = index; i < isInLang.length(); i++)
        {
            spontaneousTransition(i, currState, PDAstack);
            String input = currState + "," + isInLang.charAt(i) + "," + PDAstack.peek(); 
            //System.out.println(input);
            //System.out.println("currindex : " + i);
            System.out.println();
            System.out.print("Current input data: " + input + " index: " + i );
            if(transition.containsKey(input))
            {
                //System.out.println("there is a valid transition");
                ArrayList<String> outputs = transition.get(input);
                
                
                System.out.println();
                for(int j = 0; j < outputs.size(); j++)
                {
                    transition(i,outputs.get(j),currState,PDAstack);
                }
                
            }
            else
            {
                System.out.println(": failed at this step");
                return false;
            }


        }
        spontaneousTransition(isInLang.length() + 1, currState, PDAstack);
        
        if(finalstates.contains(currState))
        {
            isIn = true;
        }
        return true;

    }


    public void spontaneousTransition(int i,String currState, Stack<Character> PDAstack)
    {
        if(transition.containsKey(currState + "," + "e" + ',' + "e"))
        {
            StringBuilder getstate = new StringBuilder();
            StringBuilder getstack = new StringBuilder();
            ArrayList<String> outputs = transition.get(currState + "," + "e" + ',' + "e");

            int tempind;
            for(String parsed : outputs)
            {
                tempind = 0;
                System.out.println("branching at character : " + i + " And parsing " + parsed);
                while(parsed.charAt(tempind) != ',')
                {
                    getstate.append(parsed.charAt(tempind));
                    tempind++;
                }
                tempind++;
                while (tempind < parsed.length()) {
                getstack.append(parsed.charAt(tempind));
                tempind++;
                }
                String stckinfo = getstack.toString();
                if(stckinfo.charAt(0) != 'e')
                {
                    PDAstack.push(stckinfo.charAt(0));
                }
                    
                String newState = getstate.toString();
                System.out.println("spontaneous movement to " + newState);
                System.out.println();
                calculator(i,PDAstack,newState);
                getstate.setLength(0);
                getstack.setLength(0);
            }
                
                
        }
    }

    public void transition(int i, String output, String currState,Stack<Character> PDAstack) {
        
        StringBuilder getstate = new StringBuilder();
        StringBuilder getstack = new StringBuilder();
        String stckinfo;
        int tempind = 0;
        while (output.charAt(tempind) != ',') {
            //System.out.print(output.charAt(tempind));
            getstate.append(output.charAt(tempind));
            tempind++;
        }
        //System.out.print(output.charAt(tempind));
        //System.out.println("what happens to state: " +  getstate.toString());
        tempind++;
        //System.out.print(output.charAt(tempind));
        while (tempind < output.length()) {
            //System.out.print(output.charAt(tempind));
            getstack.append(output.charAt(tempind));
            tempind++;
        }
        //System.out.print(output.charAt(tempind));
        System.out.println();
        currState = getstate.toString();
        stckinfo = getstack.toString();
        System.out.println("Transitioned to state: " + currState + "," + stckinfo);
        //System.out.println("what happens to stack: " +  stckinfo);
        //System.out.println();
        //System.out.println("what happens to state: " +  currState);
        //System.out.println();
        //this exluces the state transition where we ignore ths stack

        if (PDAstack.peek() == 'e' && stckinfo.length() != 'e') {
            PDAstack.push(stckinfo.charAt(0));
        } else if (PDAstack.peek() != 'e' || stckinfo.charAt(0) != 'e') {
            // we only care if it adds or makes
            //us pop
            if (stckinfo.charAt(0) == 'e') {
                //System.out.println("POPPED!");
                PDAstack.pop();
            } //the other situation is we add
            else if (stckinfo.length() == 2) {
                //System.out.println("pushing to the stack");
                PDAstack.push(stckinfo.charAt(0));
            } else {
                //System.out.println("Leaving stack the way it is");
            }

        }
        calculator(i + 1,PDAstack,currState);

    }*/
 /*
            //the pda's actual stack
            Stack<Character> PDAstack = new Stack();
            //pushing the empty string to indicate
            //our stack has nothing in it currently
            PDAstack.push('e');
            for(int i = 0; i < isInLang.length(); i++)
            {
                String input = currState + "," + isInLang.charAt(i) + "," + PDAstack.peek(); 
                System.out.println(input);
                StringBuffer getstate = new StringBuffer();
                StringBuffer getstack = new StringBuffer();
                String stckinfo;
                int tempind;
                System.out.println("currindex : " + i);
                if(transition.containsKey(input))
                {
                    ArrayList<String> outputs = transition.get(input);
                    String output = outputs.get(0);
                    tempind = 0;
                    while(output.charAt(tempind) != ',')
                    {
                        //System.out.print(output.charAt(tempind));
                        getstate.append(output.charAt(tempind));
                        tempind++;
                    }
                    //System.out.print(output.charAt(tempind));
                    //System.out.println("what happens to state: " +  getstate.toString());
                    tempind++;
                    //System.out.print(output.charAt(tempind));
                    while(tempind < output.length())
                    {
                        //System.out.print(output.charAt(tempind));
                        getstack.append(output.charAt(tempind));
                        tempind++;
                    }
                    //System.out.print(output.charAt(tempind));
                    System.out.println();
                    currState = getstate.toString();
                    stckinfo = getstack.toString();
                    System.out.println("what happens to stack: " +  stckinfo);
                    System.out.println();
                    System.out.println("what happens to state: " +  currState);
                    System.out.println();
                    //this exluces the state transition where we ignore ths stack
                    if(PDAstack.peek() == 'e' && stckinfo.length() == 1)
                    {
                        PDAstack.push(stckinfo.charAt(0));
                    }
                    else if(PDAstack.peek() != 'e' || stckinfo.charAt(0) != 'e')
                    {
                        // we only care if it adds or makes
                        //us pop
                        if(stckinfo.charAt(0) == 'e')
                        {
                            PDAstack.pop();
                        }

                        //the other situation is we add
                        else if(stckinfo.length() == 2)
                        {
                            PDAstack.push(stckinfo.charAt(0));
                        }
                        
                    }
                    

                }
                else
                {
                    return false;
                }
                
            }
            if(finalstates.contains(currState))
            {
                return true;
            }
    
            return false;
        }




























     */
}
