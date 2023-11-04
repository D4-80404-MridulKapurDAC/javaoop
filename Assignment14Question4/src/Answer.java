import java.util.Scanner;

interface Arithmetic{
	abstract double calc(double a,double b);
}

enum MENU{
	ADD,SUB,MUL,DIV,EXIT
}

public class Answer {

	private static void calculate(double num1 , double num2 ,Arithmetic op) {
		double result = op.calc(num1, num2);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		MENU ch;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("ADD,SUB,MUL,DIV");
			ch = MENU.values()[sc.nextInt() - 1];
			switch(ch){
				case ADD:
					calculate(sc.nextDouble(),sc.nextDouble(),(N1,N2) -> N1+N2);
					break;
				case SUB:
					calculate(sc.nextDouble(),sc.nextDouble(),(N1,N2) -> N1-N2);
					break;
				case MUL:
					calculate(sc.nextDouble(),sc.nextDouble(),(N1,N2) -> N1*N2);
					break;
				case DIV:
					calculate(sc.nextDouble(),sc.nextDouble(),(N1,N2) -> N1/N2);
					break;
				default:
					break;
			}
		}while(ch!=MENU.EXIT);
	}

}
