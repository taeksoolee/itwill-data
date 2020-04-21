package site.itwill.service;

import java.sql.SQLException;
import java.util.List;

import site.itwill.dao.UserinfoModelTwoDAO;
import site.itwill.dto.UserinfoDTO;
import site.itwill.exception.ExistsUserinfoException;
import site.itwill.exception.PasswordMissMatchException;
import site.itwill.exception.UserinfoNotFoundException;

//Service Ŭ���� : DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� �� Ŭ������ ��û ó��
//�޼ҵ忡�� ���ϴ� ����� �����ϱ� ���� Ŭ���� - ���۳�Ʈ Ŭ����(���)
// => ���ø����̼��� ���ϴ� ����� �����ϱ� ���� �޼ҵ� �ۼ�
public class UserinfoService {
	private static UserinfoService _service;
	
	private UserinfoService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_service=new UserinfoService();		
	}
	
	public static UserinfoService getService() {
		return _service;
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� �����ϴ� �޼ҵ�
	// => ���޵� ȸ������ �� ���̵� �ߺ��� ��� ������ ���� �߻�
	public void addUserinfo(UserinfoDTO userinfo) throws SQLException, ExistsUserinfoException {
		//���޵� ȸ���� ���̵� ���� ȸ�������� ������ ���
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())!=null) {
			//������ ���� �߻�
			throw new ExistsUserinfoException("�̹� ������� ���̵� �Է� �Ͽ����ϴ�.");
		}
		//���ܰ� �߻��� ��� �ϴܿ� �����ϴ� ��� �̽���
		UserinfoModelTwoDAO.getDAO().insertUserinfo(userinfo);
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� ����� ȸ�������� �����ϴ� �޼ҵ�
	// => ���޵� ȸ������ �� ���̵��� ȸ�������� ���� ��� ������ ���� �߻�
	public void modifyUserinfo(UserinfoDTO userinfo) throws SQLException, UserinfoNotFoundException {
		getUserinfo(userinfo.getUserid());
		UserinfoModelTwoDAO.getDAO().updateUserinfo(userinfo);
	}
	
	//���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �����ϴ� �޼ҵ�
	// => ���޵� ���̵��� ȸ�������� ���� ��� ������ ���� �߻�
	public void removeUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		getUserinfo(userid);
		UserinfoModelTwoDAO.getDAO().deleteUserinfo(userid);
	}
	
	//���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ���޵� ���̵��� ȸ�������� ���� ��� ������ ���� �߻�
	public UserinfoDTO getUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
		if(userinfo==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}
		return userinfo;
	}
	
	//USERINFO ���̺� ����� ��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<UserinfoDTO> getUserinfoList() throws SQLException {
		return UserinfoModelTwoDAO.getDAO().selectAllUserinfo();
	}
	
	//���������� ���޹޾� ����ó���ϴ� �޼ҵ� 
	// => ���� ���н� ������ ���� �߻�
	public void login(String userid, String password) throws SQLException, UserinfoNotFoundException, PasswordMissMatchException  {
		//���̵� ���� ���� ó�� => ���̵� ���� ȸ�������� ���� ��� ������ ���� �߻�
		UserinfoDTO userinfo=getUserinfo(userid);
		
		//��й�ȣ�� ���� ���� ó�� => ��й�ȣ�� ���� �ʴ� ��� ������ ���� �߻�
		if(!password.equals(userinfo.getPassword())) {
			throw new PasswordMissMatchException("�Է��� ���̵� �߸� �Ǿ��ų� ��й�ȣ�� ���� �ʽ��ϴ�.");
		}
	}
}









