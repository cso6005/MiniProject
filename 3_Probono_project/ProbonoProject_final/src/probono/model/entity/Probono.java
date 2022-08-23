/*
CREATE TABLE probono (
       probono_id          	VARCHAR2(50) PRIMARY KEY,
       probono_name      VARCHAR2(50) NOT NULL,
       probono_purpose  	VARCHAR2(200) NOT NULL
);  */
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
public class Probono {
	
	@Id
	@Column(name = "probono_id")
	private String probonoId;
	
	@NonNull
	@Column(name = "probono_name")
	private String probonoName;
	
	@Column(name = "probono_purpose")
	@NonNull
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
