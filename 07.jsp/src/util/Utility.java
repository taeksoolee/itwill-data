package site.itwill.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

//���α׷� �ۼ��� �ʿ��� ����� �����ϴ� Ŭ����
public class Utility {
	//���ڿ��� ���޹޾� �±� ���� ���ڿ��� ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public static String stripTag(String source) {
		//Pattern : ����ǥ������ �����ϱ� ���� Ŭ����
		//Pattern.compile(String regEx) : ���ڿ��� ����ǥ�������� ��ȯ�Ͽ�
		//�����ϴ� Pattern �ν��Ͻ��� ��ȯ�޾� �޼ҵ�
		//Pattern.CASE_INSENSITIVE : ��ҹ��ڸ� �������� �ʵ��� �����ϱ� ���� ����ʵ�
		Pattern htmlScript=Pattern.compile("\\]*?<.*?\\/script\\>", Pattern.CASE_INSENSITIVE);
		Pattern htmlStlye=Pattern.compile("\\]*?<.*?\\/style\\>", Pattern.CASE_INSENSITIVE);
		Pattern htmlOption=Pattern.compile("\\]*?<.*?\\/option\\>", Pattern.CASE_INSENSITIVE);
		Pattern htmlTag=Pattern.compile("\\<.*?\\>", Pattern.CASE_INSENSITIVE);
		
		//Pattern.matcher(String source) : ����ǥ���İ� ���ް��� �� ó���ϱ�
		//���� Matcher �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//Matcher.replaceAll(String replacement) : ����ǥ���İ� ���� ������
		//���ڿ��� �˻��Ͽ� ���ϴ� ���ڿ��� �����ϴ� �޼ҵ�
		source=htmlScript.matcher(source).replaceAll("");//�±�����
		source=htmlStlye.matcher(source).replaceAll("");
		source=htmlOption.matcher(source).replaceAll("");
		source=htmlTag.matcher(source).replaceAll("");
		
		return source;
	}
	
	//���ڿ��� ���޹޾� ��ȣȭ �˰����� �̿��Ͽ� ��ȣȭ ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
	public static String encrypt(String source) {
		//��ȣȭ�� ���ڿ��� �����ϱ� ���� ����
		String password="";
		
		try {
			//MessageDigest : ��ȣȭ �˰����� �̿��Ͽ� ��ȣȭ ó���ϴ� ����� �����ϴ� Ŭ����
			//MessageDigest.getInstance(String algorithm) : ��ȣȭ �˰�����
			//���޹޾� MessageDigest �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
			// => NoSuchAlgorithmException ���� �߻� - ����ó��
			//��ȣȭ �˰���(�ܹ���) : MD5, SHA-1, SHA-256(����), SHA-512 �� 
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			
			//MessageDigest.update(byte[] input) : MessageDigest �ν��Ͻ���
			//��ȣȭ �ϰ��� ���ڿ��� byte �迭�� �����Ͽ� �����ϴ� �޼ҵ�
			//String.getBytes() : ���ڿ��� byte �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			md.update(source.getBytes());
			
			//MessageDigest.digest() : MessageDigest �ν��Ͻ��� ����� byte
			//�迭�� ��ȣȭ �˰����� �̿��Ͽ� ��ȣȭ ó�� �� byte �迭��
			//��ȯ�ϴ� �޼ҵ�
			byte[] digest=md.digest();
			
			//byte �迭�� ��Ұ��� ���ڿ�(String �ν��Ͻ�)�� ��ȯ�Ͽ� ����
			// => byte �迭�� ��Ұ����� ���ʿ��� �� ���� �� 16������ ���ڿ��� ��ȯ�Ͽ� ����
			for(int i=0;i<digest.length;i++) {
				password+=Integer.toHexString(digest[i]&0xff);
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("[����]�߸��� ��ȣȭ �˰����� ��� �Ͽ����ϴ�.");
		}
		
		return password;
	}
	
	
}






