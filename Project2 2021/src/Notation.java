/** This class makes infixes to post fixes and vice versa
 * 
 * @author Tsegazeab Berhie
 *
 */
public class Notation {
	
	/**
	 * it evaluates the postfix expresiion
	 * @return a double that is the solution
	 */
	public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException {
		NotationStack<Double> evaluate = new NotationStack<Double>();
		for (int i = 0; i < postfix.length(); i++) {
			char check = postfix.charAt(i);
			try {

				if (check < 58 && check > 47)
					evaluate.push((double) check - 48);

				if ((check == '%' || check == '/' || check == '*' || check == '+' || check == '-')) {
					if (evaluate.size() < 2)
						throw new InvalidNotationFormatException(postfix);
					else {
						double a = evaluate.pop();
						double b = evaluate.pop();
						if (check == '+')
							evaluate.push(a + b);
						else if (check == '/')
							evaluate.push(b / a);
						else if (check == '-')
							evaluate.push(b - a);
						else if (check == '*')
							evaluate.push(a * b);
					}

				}
			} catch (StackOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}

		}
		if (evaluate.size() != 1)
			throw new InvalidNotationFormatException(postfix);
		return Double.parseDouble(evaluate.toString());
	}
	
	/**
	 * it converts a postfix to infix
	 * @return a infix string
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		NotationStack changed = new NotationStack();


		for(int i = 0; i<postfix.length();i++) {
			char current = postfix.charAt(i);
			try {
				if(current<58 && current>47)
					changed.push(current);

				if ((current == '%' || current == '/' || current == '*' || current == '+' || current == '-')){
					if(changed.size()<2)
						throw new InvalidNotationFormatException(postfix);
					else {
						Object a = changed.pop();
						changed.push("("+changed.pop()+current+a+")");
					}

				}

			} catch (StackOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}	
		}
		if(changed.size()!=1)
			throw new InvalidNotationFormatException(postfix);
		return changed.toString();
	}
	
	
	/**
	 * it converts an infix to postfix
	 * @return a postfix string
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		NotationQueue<Character> Convert = new NotationQueue<Character>();
		NotationStack<Character> symbol = new NotationStack<Character>();


		for(int i = 0; i<infix.length();i++) {
			char current = infix.charAt(i); 
			
			try {

				if(current<58 && current>47)
					Convert.enqueue(current); 

				if(current=='(')
					symbol.push(current);

				if ((current == '%' || current == '/' || current == '*' || current == '+' || current == '-')){

					if((symbol.size()!=0)&&(symbol.top() == '%' || symbol.top() == '/' || symbol.top() == '*' 
							|| symbol.top() == '+' || symbol.top() == '-')) {
						if(hasPres(current, symbol.top())==false)
							Convert.enqueue(symbol.pop());

					}
					else {
						symbol.push(current);

					}
				}

				if(current==')') {
					while(symbol.top()!='('){
						Convert.enqueue(symbol.pop());

						if(symbol.size()==0) {
							throw new InvalidNotationFormatException(infix);
						}
					}
					symbol.pop();
				}


			} catch (QueueOverflowException | StackOverflowException | StackUnderflowException e) {

			}


		}

		try {
			while(symbol.size()!=0)
				Convert.enqueue(symbol.pop());
		} catch (QueueOverflowException e) {
		} catch (StackUnderflowException e) {

		}

		return Convert.toString();
	}

	private static boolean hasPres(char c, char sec) {
		int a =  0;
		int b = 0;
		switch (c) {
		case '+': a = 1;
		case '-': a = 1;
		case '*': a = 2;
		case '/': a = 2;
		case '^': a = 3;
		}

		switch (sec) {
		case '+': b = 1;
		case '-': b = 1;
		case '*': b = 2;
		case '/': b = 2;
		case '^': b = 3;
		}

		if(a-b>0)
			return true;
		System.out.println(a-b);
		return false;

	}


	
	
	
}