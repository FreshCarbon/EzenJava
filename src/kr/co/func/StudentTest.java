/*
 * �л� 2���� �����Ͽ� ���۽�Ű��
 */
package kr.co.func;

public class StudentTest {
	
	public static void main(String[] args) {
		//��ü���� �� ����.(�ν��Ͻ�ȭ)
		Student stu1 = new Student();
		
		//��ü�� �ʵ尪 �ֱ� 
		stu1.name = "������";
		stu1.age = 28;
		
		//�����ϰ� �ڰ�.
		stu1.studying();
		stu1.sleeping();
	}

}
