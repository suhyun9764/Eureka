package com.springboot.springbootjpabasiccrudfind.lombok;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
//생성자는 롬복 어노테이션과 실제 코드가 중복되면 오류발생
// 생성자를 통해서 초기화되어야 하는 final field를 위한 생성자 = RequiredArgs
//@RequiredArgsConstructor

// 필요한 기본 어노테이션을 한꺼번에 합쳐서 사용하는 효과
@Data	//@Getter + @Setter + @ToString + @EqualsAndHashCOde +@RequiredArgsConstructor
// 생성자 대신 Builder 패턴을 사용하자 흐름 + Lombok 자체가 생성자 코드 눈에 보이지 않음
// builder 패턴을 이용해서 객체를 생성하는 방법 추천
@Builder
@Slf4j
public class EmpDto2 {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String hireDate;

	final String departmentId;

	public int getEmployeeId(){
		log.info("test log");
		return employeeId;
	}
}