/*
 * 2021. 12. 17 클래스에 대한 이해
 * 1. 속성: 학생명, 나이, ......
 * 2. 생성자
 * 3. 기능: 공부한다, 잠을 잔다..... 
 */

package kr.co.func;

public class Student {
	String name;
	int age;
	
	// default 생성자 - 자동생성
	Student(){
		System.out.println("학생출현-생성하기");
	}	
	
	void studying() {
		System.out.println("000으로 공부를 합니다");
	}
	void sleeping() {
		System.out.println("00로 가서 잠을 잡니다.");
	}
}
 