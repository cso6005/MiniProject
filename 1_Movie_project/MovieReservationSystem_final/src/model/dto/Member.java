package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String name; // 이름
	private String id; // id
	private String pw; // pw
	private char grade; // 등급
	private int cash;  // 보유 금액
}
