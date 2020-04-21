package site.itwill06.oop;

//Proxy Ŭ���� : �ٽɰ��ɸ��� Ⱦ�ܰ��ɸ���� �����ϱ� ���� Ŭ���� - Aspect
// => �ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ带 ������ �޼ҵ� ����
public class AopProxy implements AopInterface {
	//�ٽɰ��ɸ���� �����ϱ� ���� �ʵ�
	private AopInterface target;
	
	//Ⱦ�ܰ��ɸ���� �����ϱ� ���� �ʵ�
	private AopLogger logger;
	
	//�ٽɰ��ɸ��� Ⱦ�ܰ��ɸ���� ���޹޾� �ʵ忡 �����ϴ� ������
	public AopProxy(AopInterface target) {
		this.target=target;
		this.logger=new AopLogger();
	}
	
	//Ⱦ�ܰ����ڵ带 �ٽɰ����ڵ忡 ���� ������ �޼ҵ� - Weaving 
	// => ���� ��ġ ���� : JoinPoint
	@Override
	public void display1() {
		logger.beforeLog();//Ⱦ�ܰ����ڵ�
		target.display1();//�ٽɰ����ڵ�
	}

	@Override
	public void display2() {
		logger.beforeLog();
		target.display2();
	}

	@Override
	public void display3() {
		logger.beforeLog();
		target.display3();
	}

}
