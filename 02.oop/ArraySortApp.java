package oop;

import java.util.Arrays;

//�迭 ��Ұ��� �����Ͽ� ����ϴ� ���α׷�
public class ArraySortApp {
	public static void main(String[] args) {
		int[] array={20,50,10,40,30};
		
		/*
		System.out.print("���� �� >> ");
		for(int number:array) {
			System.out.print(number+"  ");
		}
		System.out.println();
		
		//���� ���� �˰����� �̿��Ͽ� �迭 ��Ұ� ���� ó��
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]) {
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		
		System.out.print("���� �� >> ");
		for(int number:array) {
			System.out.print(number+"  ");
		}
		System.out.println();
		*/
		
		System.out.print("���� �� >> ");
		//Arrays.toString(Object array) : �迭�� ���޹޾� �迭 ��Ұ����� ���ڿ��� ��ȯ�Ͼ� ��ȯ�ϴ� �޼ҵ�
		System.out.println(Arrays.toString(array));

		//Arrays.sort(Object array) : �迭�� ���޹޾� �迭 ��Ұ����� ���� ó���ϴ� �޼ҵ�
		Arrays.sort(array);
		
		System.out.print("���� �� >> ");
		System.out.println(Arrays.toString(array));
	}
}











