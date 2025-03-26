
public class Main
{
	public static void main(String[] args) {

		String inSet = "{q0,q1,q2,q3,q4,q5,q6},{1,0},{e,0,$},{(q0,e,e)->(q1,$),(q1,e,e)->(q2,e),"+
		"(q1,e,e)->(q4,e),(q2,1,e)->(q2,0),(q2,e,e)->(q3,e),(q2,e,e)->(q5,e),"+
		"(q4,0,e)->(q2,0),(q4,e,e)->(q5,e),(q5,1,0)->(q5,e),(q3,0,0)->(q3,e),"+
		"(q5,e,$)->(q6,e),(q3,e,$)->(q6,e)},q0,{q6},11111111111111";
		newPDA testIN = new newPDA(inSet);
		boolean TESTINCHECK = testIN.membershiptest();
		System.out.println("String inSet returns : " + TESTINCHECK);


		/*String notinSet = "{q0,q2,q3},{1},{e},{(q0,e,e)->(q2,e),(q0,1,e)->(q2,e),(q2,e,e)->(q0,e),(q2,1,e)->(q0,e)},q0,{q3},11111111111";
		newPDA testOUT = new newPDA(notinSet);
		boolean TESTOUTCHECK = testOUT.membershiptest();
		System.out.println("String notinSet returns : " + TESTOUTCHECK);*/

	}


}

















/*
String in1 = "{q0,q1,q2},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,a,a)->(q1,aa),(q1,b,a)->(q2,e),(q2,b,a)->(q2,e)},q0,{q2},aabb";
		String in2 = "{q0,q1,q2,q3,q4},{1,0},{e,1,0},{(q0,e,e)->(q1,e),(q0,e,e)->(q2,e),(q1,0,e)->(q1,e),(q2,1,e)->(q2,e),(q1,1,e)->(q3,e),(q2,0,e)->(q4,e)},q0,{q1,q2},11111111111";	
		String in3 = "{q0,q1,q2},{0,1},{e,0,1},{(q0,0,e)->(q1,0),(q1,0,0)->(q1,00),(q1,1,0)->(q2,e),(q2,1,0)->(q2,e)},q0,{q2},0011";
		String in4 = "{q0,q1,q2,q3},{x,y,z},{e,x,y,z},{(q0,x,e)->(q1,x),(q1,y,x)->(q1,xy),(q1,z,x)->(q2,e),(q2,z,x)->(q2,e),(q2,e,e)->(q3,e)},q0,{q3},xyzxyz";
		String in5 = "{q0,q1,q2,q3},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,a,a)->(q1,aa),(q1,b,a)->(q2,e),(q2,b,a)->(q2,e),(q2,e,e)->(q3,e)},q0,{q3},aabba";
		String in6 = "{q0,q1,q2},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,b,a)->(q2,e),(q2,e,e)->(q0,e)},q0,{q0},ab";
		String in7 = "{q0,q1,q2},{1,0},{e,1,0},{(q0,1,e)->(q1,1),(q1,0,1)->(q2,e),(q2,0,1)->(q2,e)},q0,{q2},1001";
		String in8 = "{q0,q1,q2,q3},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,a,a)->(q1,aa),(q1,b,a)->(q2,e),(q2,a,a)->(q2,a),(q2,b,a)->(q3,e)},q0,{q3},aabb";
		String in9 = "{q0,q1,q2},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,a,a)->(q1,aa),(q1,b,a)->(q2,e),(q2,b,a)->(q2,e),(q2,e,e)->(q3,e)},q0,{q3},aabbaa";
		String in10 = "{q0,q1,q2,q3},{0,1},{e,0,1},{(q0,0,e)->(q1,0),(q1,0,0)->(q1,00),(q1,1,0)->(q2,e),(q2,1,0)->(q2,e),(q2,e,e)->(q3,e)},q0,{q3},001001";
		String in11 = "{q0,q1,q2},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,b,a)->(q2,e),(q2,a,a)->(q2,a),(q2,b,a)->(q2,e)},q0,{q2},abab";
		String in12 = "{q0,q1,q2,q3},{x,y,z},{e,x,y,z},{(q0,x,e)->(q1,x),(q1,y,x)->(q1,xy),(q1,z,x)->(q2,e),(q2,y,y)->(q3,e),(q3,z,z)->(q3,e)},q0,{q3},xyzzyz";
		String in13 = "{q0,q1,q2,q3},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,a,a)->(q1,aa),(q1,b,a)->(q2,e),(q2,b,a)->(q2,e),(q2,e,e)->(q3,e)},q0,{q3},aaabbb";
		String in14 = "{q0,q1,q2},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,b,a)->(q2,e),(q2,a,a)->(q2,a),(q2,b,e)->(q2,e)},q0,{q2},abaa";
		String in15 = "{q0,q1,q2,q3},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,b,a)->(q2,e),(q2,a,e)->(q1,a),(q2,b,a)->(q3,e)},q0,{q3},abab";
		String in16 = "{q0,q1,q2,q3},{x,y,z},{e,x,y,z},{(q0,x,e)->(q1,x),(q1,y,x)->(q2,xy),(q2,x,y)->(q1,x),(q2,z,x)->(q3,e),(q3,e,e)->(q0,e)},q0,{q0},xyzxzy";
		String in17 = "{q0,q1,q2,q3},{a,b},{e,a,b},{(q0,a,e)->(q1,a),(q1,b,a)->(q2,e),(q2,a,e)->(q1,a),(q1,b,a)->(q3,e)},q0,{q3},abab";
		String in18 = "{q0,q1,q2,q3,q4,q5,q6},{a,b,c},{e,a,b,c},{(q0,a,e)->(q1,a),(q1,b,a)->(q2,e),(q2,c,e)->(q3,c),(q3,c,c)->(q4,c),(q4,b,c)->(q5,e),(q5,a,e)->(q6,e)},q0,{q6},abccba";
		//String in19 = "{q0,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13},{a,b,c},{e,a,b,c},{(q0,e,e)->(q1,e),(q0,e,e)->(q2,e),(q1,a,e)->(q3,a),(q2,b,e)->(q4,b),(q3,e,e)->(q5,e),(q4,e,e)->(q6,e),(q5,a,e)->(q7,a),(q5,e,e)->(q8,e),(q6,b,e)->(q9,b),(q6,e,e)->(q10,e),(q7,e,e)->(q11,e),(q8,c,e)->(q12,c),(q9,c,e)->(q13,c)},q0,{q11,q12,q13},abacbc";
		String in19 = "{q0,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14},{a,b,c},{e,a,b,c},{(q0,e,e)->(q1,e),(q1,e,e)->(q2,e),(q2,e,e)->(q3,e),(q3,a,e)->(q4,a),(q4,b,e)->(q5,b),(q5,e,e)->(q6,e),(q6,e,e)->(q7,e),(q7,a,e)->(q8,a),(q8,c,e)->(q9,c),(q9,b,e)->(q10,b),(q10,e,e)->(q11,e),(q11,e,e)->(q12,e),(q12,c,e)->(q13,c)},q0,{q13},abacbc";
		
		String in20 = "{q0,q1,q2},{1},{1},{(q0,1,e)->(q0,1),(q0,1,1)->(q0,11),(q0,e,e)->(q1,e),(q1,e,1)->(q1,e),(q1,e,e)->(q2,e)},q0,{q2},1111111111";
		String in21 = "{q0,q1,q2,q3},{1,0},{1),{(q0,1,e)->(q0,1),(q0,1,1)->(q0,11),(q0,e,e)->(q1,e),(q1,e,e)->(q2,e),(q2,0,e)->(q3,e),(q2,0,1)->(q2,e),(q1,e,e)->(q1,1)},q0,{q3},100000";
		String in22 = "{q0,q1,q2},{a,b},{a,b},{(q0,e,e)->(q0,a),(q0,b,a)->(q1,e),(q1,b,a)->(q1,e),(q1,b,e)->(q2,e)},q0,{q2},bbbbbbbbbbbbb";
		String in23 = "{q0,q1,q2},{a,b},{a,b},{(q0,e,e)->(q0,a),(q0,b,a)->(q1,e),(q1,b,a)->(q1,e),(q1,b,e)->(q2,e)},q0,{q2},abababab";
		String in24 = "{q0,q1},{a,b},{$,a,b},{(q0,e,$)->(q0,$),(q0,e,a)->(q0,a),(q0,e,b)->(q0,b)},q1,{q1},e";
		String in25 = "{q0,q1,q2,q3,q4,q5,q6},{a,b},{$,a,b},{(q0,e,e)->(q1,e),(q1,e,e)->(q2,e),(q2,e,e)->(q3,e),(q3,e,e)->(q4,e),(q4,e,e)->(q5,e),(q5,e,e)->(q6,e)},q0,{q6},e";
		String in26 = "{q0,q1,q2},{0,1},{0,1},{(q0,0,e)->(q0,0),(q0,1,0)->(q1,e),(q1,1,0)->(q2,e),(q1,1,0)->(q1,e)},q0,{q2},00000000001111111111";


		
		newPDA test = new newPDA(in1);
		newPDA test2 = new newPDA(in2);
		newPDA test3 = new newPDA(in3);
		newPDA test4 = new newPDA(in4);
		newPDA test5 = new newPDA(in5);
		newPDA test6 = new newPDA(in6);
		newPDA test7 = new newPDA(in7);
		newPDA test8 = new newPDA(in8);
		newPDA test9 = new newPDA(in9);
		newPDA test10 = new newPDA(in10);
		newPDA test11 = new newPDA(in11);
		newPDA test12 = new newPDA(in12);
		newPDA test13 = new newPDA(in13);
		newPDA test14 = new newPDA(in14);
		newPDA test15 = new newPDA(in15);
		newPDA test16 = new newPDA(in16);
		newPDA test17 = new newPDA(in17);
		newPDA test18 = new newPDA(in18);
		newPDA test19 = new newPDA(in19);
		newPDA test20 = new newPDA(in20);
		newPDA test22 = new newPDA(in22);
		newPDA test23 = new newPDA(in23);
		newPDA test24 = new newPDA(in24);
		newPDA test25 = new newPDA(in25);
		newPDA test26 = new newPDA(in26);

		ArrayList<Boolean> tested = new ArrayList<>();

		tested.add(test.membershiptest()); //should accept
		tested.add(test2.membershiptest()); //should accept
		tested.add(test3.membershiptest()); //should accept
		tested.add(test4.membershiptest()); //should reject
		tested.add(test5.membershiptest()); //reject
		tested.add(test6.membershiptest()); //accept
		tested.add(test7.membershiptest()); //reject
		tested.add(test8.membershiptest()); //accept

		tested.add(test9.membershiptest()); //reject
		tested.add(test10.membershiptest()); //reject
		tested.add(test11.membershiptest()); //reject
		tested.add(test12.membershiptest()); //reject

		tested.add(test13.membershiptest()); //accept
		tested.add(test14.membershiptest()); //reject
	    tested.add(test15.membershiptest()); //reject
		tested.add(test16.membershiptest()); //reject
		tested.add(test17.membershiptest()); //accept

		tested.add(test18.membershiptest()); //accepts
		tested.add(test19.membershiptest());
		tested.add(test20.membershiptest());
		tested.add(test22.membershiptest());
		tested.add(test23.membershiptest());
		tested.add(test24.membershiptest());
		tested.add(test25.membershiptest());
		tested.add(test26.membershiptest());
		
		
		


		System.out.println();
		
		for(int i = 0; i < tested.size(); i++)
		{
			if(tested.get(i))
			{
				System.out.println("accepted string " + (i + 1));
			}
			else
			{
				System.out.println("rejected string " + (i + 1));
			}
		}
		
	}
*/

