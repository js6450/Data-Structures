class Convert {
	public static boolean isOperand(char op){
		return ((op >= '0') && (op <= '9'));
	}
	public static boolean isOperator(char op){
		return ((op == '*') || (op == '/') || (op == '+') || (op == '-') || (op == ')') || (op == '('));
	}
	public static String[] tokensOperand(String s){
		String operand = s;
		String delimsOperand = "[()+\\-*/\\^ ]+";
		String[] tokensOperand = operand.split(delimsOperand);
		return tokensOperand;
	}
	public static QueueAr convert(String s){
		String[] tokensOperand = tokensOperand(s);
		char token;
		int cd = 0;
		String postfix = new String();
		StackList oper = new StackList();
		for (int i = 0; i < s.length();) {

			token = s.charAt(i);
			if(isOperand(token)){
				if(tokensOperand[cd].length() == 2){
					i += 2;
					postfix = postfix + tokensOperand[cd] + " ";
				}
				else{
					postfix = postfix + tokensOperand[cd] + " ";
					i++;
				}
				cd++;
			}
			else if(isOperator(token)){
				if(token == ')'){
					while(!oper.isEmpty() && oper.top().compareTo("(")!=0){
						postfix = postfix + oper.topAndPop() + " ";
					}
				}
				else if(token=='('){oper.push("(");}
				
				else if(token =='*' || token == '/'){
					while(!oper.isEmpty() && oper.top().compareTo("(")!=0 && oper.top().compareTo("+")!=0 && oper.top().compareTo("-")!=0){
				}
				oper.push(Character.toString(token));
			}
				else if(token =='+' || token == '-'){
					while(!oper.isEmpty() && oper.top().compareTo("(")!=0){
					postfix = postfix + oper.topAndPop();
				}
				oper.push(Character.toString(token));
			}	
				i++;
				}
			
		}
			while(!oper.isEmpty()){
				postfix += oper.topAndPop();
			}
		QueueAr Q = new QueueAr(postfix.length());
		for(int i = 0; i < postfix.length(); i++){
			Q.enqueue(postfix.charAt(i));
		}
		System.out.println("Postfix expression is: " + postfix);
		return Q;
	}

}