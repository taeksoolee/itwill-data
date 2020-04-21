package site.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.PointUserDAO;
import site.itwill10.dto.PointUser;

@Service
public class PointUserServiceImpl implements PointUserService {
	@Autowired
	private PointUserDAO pointUserDAO;
	
	//����� ������ ���޹޾� POINTUSER ���̺� �����ϰ� ����� ����� 
	//������ �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public PointUser addPointUser(PointUser user) {
		//���޵� ������� ���̵� �ߺ� ���� �˻� - �ߺ��� ��� ������ ���� �߻�
		if(pointUserDAO.selectPointUser(user.getId())!=null) {
			throw new RuntimeException("�̹� ������� ���̵� �Դϴ�.");
		}
		//���ܰ� �߻��� ��� �ϴܿ� �����ϴ� ��� �̽���
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}

}





