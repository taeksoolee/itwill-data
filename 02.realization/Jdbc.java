package realization;

//DBMS�� �����Ͽ� CRUD ����� �����ϱ� ���� Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => ��ӹ��� Ŭ������ �޼ҵ� �ۼ� ��Ģ ����
public interface Jdbc {
	void insert();
	void update();
	void delete();
	void select();
}