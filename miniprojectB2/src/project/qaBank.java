
import java.util.Random;
public class qaBank {
	
	
	
	
	public int[] incOrRand(boolean incOrRand) {//incOrRand=true: Increasing difficulty. False: Random Questions
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		if (incOrRand) {
			return arr;
		} else {
			Random rand = new Random();
			for (int i = 0; i < arr.length; i++) {
				int randomIndexToSwap = rand.nextInt(arr.length-1);

				int temp = arr[randomIndexToSwap];
				arr[randomIndexToSwap] = arr[i];
				arr[i] = temp;
				//System.out.println(i+": "+temp);
				}
				}	
			return arr;
		}
	
	public String returnQuestion(int q) {
		String[] questionArr = {
				// Discrete Mathematics: q=0,1,2,3,4,5 | Novice:0,1 | Intermediate: 2,3 | Advanced: 4,5
				"What is the meaning of the biconditinal statement: (p<->q)?", 
				"What is the formula to calculate the number of required rows in a truth table based on the number of variables(n)?", 
				"Which of these propositions is a tautology", 
				"What is the cardinality of the Power set of set S, where S={1,2,3}?",
				"What is the structure of the identity matrix?",
				"What is the meaning of proof by Contraposition",
				// Computer Science: q=6,7,8,9,10,11 | Novice:6,7 | Intermediate: 8,9 | Advanced: 10,11
				"How can a non terminal symbol in BNF be identified?", 
				"True/False: All Hasse Diagrams are lattices.",
				"True/False: A lattice is both a sup-semilattice and an inf-semilattice.",
				"What are the properties of a partial order relation?",
				"True/False: If p is a lower bound of Y in (S,partial order),\n and there is an element q in the lower bounds of Y such that p partial order q holds for all p in the lower bounds of Y,\n then q is the minimum of Y in (S, partial order)",
				"True/False: Tarski's fixed point theorem states that,\n in a complete lattice, every order-preserving function has at least one fixed point.",
				//Computer Organization: q=12,13,14,15,16,17 | Novice:12,13 | Intermediate: 14,15 | Advanced: 16,17
				"What is the binary equivalent to 17?",
				"What is the Von Neumann Bottleneck caused by?",
				"What is Level 1 in the Contemporary Multilevel Machine?",
				"What does RISC stand for?",
				"When converting binary to hexadecimal, how many binary digits should one group per hexadecimal digit?",
				"What is the purpose of this assembly program?\n.begin\r\n"
				+ "    .org 2048\r\n"
				+ "progl:	ld    [x], %r1\r\n"
				+ "   	ld    [y], %r2\r\n"
				+ "   	subcc %r1, %r2, %r3\r\n"
				+ "  	st %r3, [z]\r\n"
				+ "    	!jmpl %r15 + 4, %r0\r\n"
				+ "x:    7\r\n"
				+ "y:    4\r\n"
				+ "z:    0\r\n"
				+ "    .end",};
		return questionArr[q];
	}
	public String returnAnswer(int i, int j) {
		String[][] choiceAnswer = { //True answers in comments
		// Discrete Mathematics: q=0,1,2,3,4,5 | Novice:0,1 | Intermediate: 2,3 | Advanced: 4,5
		{"Or","Exclusive Or","If","If and only if"}, //3
		{"n^2","2^n","2n","n^n"}, //1
		{"p^p'","(p → q) ↔ (q ∨ p')","(p → q) ^ (q → p)","p⊕p"},//1
		{"3","7","8","6"}, //2
		{"Alternating zeros and ones","Square Matrix with a diagonal of ones, from top left to bottom right, and zero otherwise","A square matrix of ones","A rectangular matrix of side ones and zero otherwise"},//1
		{"To prove A → B, prove B → A.","To prove A → B, prove statement B' → A'.","To prove A → B, prove A ^ B'.","To prove A → B, prove (A → B)'."}, //1
		// Computer Science: q=6,7,8,9,10,11 | Novice:6,7 | Intermediate: 8,9 | Advanced: 10,11
		{"Characters between '.","Character after a backslash.","Characters between < >.","::="}, //2
		{"True","False"}, //1
		{"True","False"}, //0
		{"Symettric, Transitive, Anti-reflexive","Anti-symettric, Anti-transitive, Reflexive","Asymettric, Transitive, Reflexive","Anti-symettric, Transitive, Reflexive"},//3
		{"True","False"},//1
		{"True","False"},//0
		//Computer Organization: q=12,13,14,15,16,17 | Novice:12,13 | Intermediate: 14,15 | Advanced: 16,17
		{"10001","1001","10010","10011"},//0
		{"The PSU not supplying sufficient voltage","Data loss in hard drives","The CPU awaiting instruction from cache, memory or hard drives","Newer operating systems running on older components"},//2
		{"Microarchitecture Level","Digital Logic Level","Instruction Set Architecture Level","Operating System Machine Level"},//1
		{"Reduced Input Selection Computer","Rapid Instruction Set Computing","Retailed Integrated System Chip","Reduced Instruction Set Computer"},//3
		{"1","2","4","8"},//2
		{"Add 2 numbers","Subtract 2 numbers","Subtract 3 numbers","Multiply 2 numbers by 0"}//1
		};
		//i+1 = question number, increment j from 0 to <= choiceAnswer[i].length to print list of optional answers
		return choiceAnswer[i][j];
		}
	
	public int correctAnswer(int k) {// k+1 = question number, returns corresponding correct j value for answerChoice method
		int[] correctAnswer = {3,1,1,2,1,1,2,1,0,3,1,0,0,2,1,3,2,1};
		return correctAnswer[k];
	}
	}
