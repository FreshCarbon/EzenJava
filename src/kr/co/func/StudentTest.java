/*
 * 학생 2명을 생성하여 동작시키기
 */
package kr.co.func;

public class StudentTest {
	
	public static void main(String[] args) {
		//객체선언 및 생성.(인스턴스화)
		Student stu1 = new Student();
		
		//객체의 필드값 주기 
		stu1.name = "길지수";
		stu1.age = 28;
		
		//공부하고 자고.
		stu1.studying();
		stu1.sleeping();
	}

}
