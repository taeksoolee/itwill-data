package site.itwill.util;

public class Utility {
	//JSON �ؽ�Ʈ ����Ÿ�� ���޹޾� �ڹٽ�Ʈ��Ʈ ��ü�� ������ ǥ�� �Ұ�����
	//���ڸ� ȸ�ǹ���(Escape Character)�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
	public static String toJSON(String source) {
		return source.replace("\\", "\\\\").replace("\"", "\\\"")
				.replace("\n", "\\n").replace("\r\n", "\\n");
	}
}
