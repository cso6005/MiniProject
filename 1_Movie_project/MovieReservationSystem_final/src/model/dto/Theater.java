package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Theater {
	private int name; // 관 번호
	private Seat seat; // 좌석수
	private String startTime; // 상영 시작 시간
	private String endTime; // 상영 종료 시간
	private Movie movie; // 해당 관에서 상영중인 영화
}
