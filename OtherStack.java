
import java.util.Stack;

public class OtherStack
{
    String str;
    int ch;
    Stack<Character> charStack;

    public OtherStack(String str, int ch, Stack<Character> charStack) {
        this.str = str;
        this.ch = ch;
        this.charStack = charStack;
    }
    public String state()
    {
        return str;
    }
    public int inputIndex()
    {
        return ch;
    }
    public Stack<Character> PDAstack()
    {
        return charStack;
    }



    
}

