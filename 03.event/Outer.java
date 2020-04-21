package site.itwill.event;

//외부클래스(Outer 클래스) : 내부클래스가 선언된 클래스
// => 내부클래스로 인스턴스를 생성하여 인스턴스로 필드와 메소드 접근 가능 
public class Outer {
	private int outerNum;
	
	public Outer() {
		// TODO Auto-generated constructor stub
	}

	public Outer(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getOuterNum() {
		return outerNum;
	}

	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void outerDisplay() {
		System.out.println("outerNum = "+outerNum);
	}
	
	public void outerInnerDisplay() {
		//System.out.println("innerNum = "+innerNum);
		
		//내부클래스를 이용하여 인스턴스 생성
		Inner inner=new Inner(100);
		//인스턴스를 이용하여 필드와 메소드 접근 가능
		//System.out.println("innerNum = "+inner.innerNum);
		inner.innerDisplay();
	}
	
	//내부클래스(Inner Class) : 클래스 안에 선언된 클래스
	// => 외부클래스에 선언된 필드와 메소드에 접근 가능
	// => 외부클래스에서만 사용 가능한 클래스
	public class Inner {
		private int innerNum;
		
		public Inner() {
			// TODO Auto-generated constructor stub
		}

		public Inner(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}
		
		public void innerDisplay() {
			System.out.println("innerNum = "+innerNum);
		}
		
		public void innerOuterDisplay() {
			//System.out.println("outerNum = "+outerNum);
			outerDisplay();
		}
	}
	
	//내부정적클래스(Nested Class) : 클래스 안에 선언된 Static 클래스
	// => 외부클래스에 선언된 필드와 메소드에 접근 불가능
	// => 외부클래스에 선언된 정적필드와 정적메소드에 접근 가능
	// => 외부클래스를 통해 다른 클래스에서 사용 가능한 클래스
	public static class Nested {
		private int nestedNum;
		
		public Nested() {
			// TODO Auto-generated constructor stub
		}

		public Nested(int nestedNum) {
			super();
			this.nestedNum = nestedNum;
		}

		public int getNestedNum() {
			return nestedNum;
		}

		public void setNestedNum(int nestedNum) {
			this.nestedNum = nestedNum;
		}
		
		public void nestedDisplay() {
			System.out.println("nestedNum = "+nestedNum);
		}
	}
}







