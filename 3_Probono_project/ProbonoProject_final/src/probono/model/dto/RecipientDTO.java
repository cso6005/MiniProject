/*CREATE TABLE recipient (
       recipient_id         VARCHAR2(20) PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       receiveHopeContent   VARCHAR2(50) NULL
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

public class RecipientDTO {

	private String recipientId;
	private String name;
	private String password;
	private String receiveHopeContent;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("   1) 아이디	" + recipientId);
		builder.append("\n   2) 이름	" + name);
		builder.append("\n   3) 비밀번호	" + password);
		builder.append("\n   4) 희망수혜내용	" + receiveHopeContent);
		return builder.toString();
	}

}
