package ott.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Contents {
	private String contentsName;
	private String contentsActor;
	private String contentsInform;
	private String contentsType;
	private String genre_name;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| 제목 |  " + contentsName );
		builder.append("\n| 타입 |  " + contentsType );
		builder.append("\n| 장르 |  " + genre_name );
		builder.append("\n| 배우 |  " + contentsActor );
		builder.append("\n| 소개 |  \n " + contentsInform );

		return builder.toString();
		

	}

}
