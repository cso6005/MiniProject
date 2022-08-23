/*
CREATE TABLE probono (
       probono_id          	VARCHAR2(50) PRIMARY KEY,
       probono_name      VARCHAR2(50) NOT NULL,
       probono_purpose  	VARCHAR2(200) NOT NULL
);  */
package probono.model.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProbonoDTO {
	
	private String probonoId;
	private String probonoName;
	private String probonoPurpose;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("   1) 아이디	" + probonoId);
		builder.append("\n   2) 이름	" + probonoName);
		builder.append("\n   3) 목적	" + probonoPurpose);
		return builder.toString();

	}
}
