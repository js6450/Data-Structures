class PostCalc
{
	public static boolean isOperator(Object op)
	{
		return ((op=="*") || (op =="/") || (op=="+") || (op=="-"));
	}
	public static double evaluate(double op1, String operator, double op2 )
	{
		switch( operator)
		{
			case "*": return op1*op2;
			case "/": return op1/op2;
			case "+": return op1+op2;
			case "-": return op1-op2;
		}
		
		System.out.println("not a valid operator");
		return 0;
	}
	
	public static String evaluate(QueueAr Q){
		StackList stack = new StackList();
		double result;
		while(!Q.isEmpty()){
			if(isOperator(Q.getFront())){
				try{
					String digit2 = stack.topAndPop();
					String digit1 = stack.topAndPop();
					Double op2 = new Double(digit2);
					Double op1 = new Double(digit1);
					result = evaluate(op1, (String)Q.getFront(), op2);
					String r = Double.toString(result);
					stack.push(r);
				} catch (Exception e) {}  //catch but do nothing
				Q.dequeue();
			}
			else if(!isOperator(Q.getFront()) ){
				try{
					stack.push(Q.getFront());
				}
				catch(Exception e){}
				Q.dequeue();
			}
		}
		String ans = stack.topAndPop();
		return "result is " + ans;
	}
}