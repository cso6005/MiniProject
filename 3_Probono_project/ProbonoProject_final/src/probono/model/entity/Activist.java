/**
CREATE TABLE activist (
       activist_id          	VARCHAR2(20)  PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       password         	VARCHAR2(20) NOT NULL,
       major                	VARCHAR2(50) NOT NULL
); */

package probono.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

@Entity
public class Activist {
	
	@Id
	@Column(name = "activist_id")
	private String activistId;
	
	@NonNull
	private String name;
	
	@NonNull
	private String password;
	
	@NonNull
	private String major;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("   1)  아이디	" + activistId);
		builder.append("\n   2)  이름	"  + name);
		builder.append("\n   3) 비밀번호	" + password);
		builder.append("\n   4)  분야	"  + major);
		return builder.toString();
	}

}
