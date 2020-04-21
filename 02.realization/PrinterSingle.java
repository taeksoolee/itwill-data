package realization;

public class PrinterSingle implements Printable {
	@Override
	public void print() {
		System.out.println("[프린터]문서를 출력합니다.");
	}
}
