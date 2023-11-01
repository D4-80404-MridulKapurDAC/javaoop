package pkg;

class Box<T>{
	T val;
	Box(Box<?> obj){
//		val = obj;
	}
	Box(T obj){
		
	}
	T get(){
	//	val.over();
		return val;
	}
}

public class Program {
	
	public static <T> void naam(Box<? extends Parent> c){
		c.get();
	}
	
	public static void main(String[] args) {
	//	Box<GrandParent> naam2 = new Box<>(new GrandParent(10));
//		Box<Parent> naam3 = new Box<>(new Parent(20,20));
		Child cd = new Child(30,30,30);
//		Box<Child> naam4 = new Box< c>(cd);//Inference
   		Box<Child> method=new Box<Child>(naam4);
//		naam(naam2);
//		naam(naam3);
		naam(naam4);
	}
}
