/*CREATE TABLE recipient (
       recipient_id         VARCHAR2(20) PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       receiveHopeContent   VARCHAR2(50) NULL
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
public class Recipient {
	
	@Id
	@Column(name = "recipient_id")
	private String recipientId;
	
	@NonNull
	private String name;

	@NonNull
	private String password;

	@NonNull
	@Column(name = "receive_hope_content")
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
