package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationList {
	private int tName; // 관 이름
	private String mName; // 고객 이름
	private String mTitle; // 영화 이름
	private String startTime; // 시작 시간
	private String endTime; // 종료 시간
	private int [] seatIndex; // 예매 좌석 인덱스
	private Seat seat; // 예매 전체 좌석, 가격 객체
}
