package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private String title; // 영화 제목 
	private String actor; // 출연진
	private String genre; // 장르 
	private String director; // 감독 
	private String story; // 줄거리 
	private String runnigTime; // 러닝 타임
	
	@Override
	public String toString() {
		return "\n- 제목:  "+ title +
				"\n- 출연진:  "+ actor +
				"\n- 장르: " + genre +
				"\n- 감독: " + director +
				"\n- 줄거리:\n" + story +
				"\n- 러닝타임: " + runnigTime;
	}
	
}
