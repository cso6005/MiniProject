/**
CREATE TABLE activist (
       activist_id          	VARCHAR2(20)  PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       password         	VARCHAR2(20) NOT NULL,
       major                	VARCHAR2(50) NOT NULL
); */

package probono.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ActivistDTO {

	private String activistId;
	private String name;
	private String password;
	private String major;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("   1)  아이디	" + activistId);
		builder.append("\n   2)  이름	" + name);
		builder.append("\n   3) 비밀번호	" + password);
		builder.append("\n   4)  분야	" + major);
		return builder.toString();
	}

}
