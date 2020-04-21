package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��� ��Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => ��Ŭ������ ó���޼ҵ� �ۼ��� ���� ��Ģ ����
//ó���޼ҵ�� HttpServletRequest �ν��Ͻ��� HttpServletResponse �ν��Ͻ���
//�̿��Ͽ� ��û�� ���� ó���۾��� �����ϰ� �� ���� ���� ��ȯ
public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
