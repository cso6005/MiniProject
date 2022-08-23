/*
CREATE TABLE probono_project (
	   probono_project_id     		NUMBER(5) PRIMARY KEY,
	   probono_project_name 		VARCHAR2(50) NOT NULL,
       probono_id           			VARCHAR2(50) NOT NULL,       
       activist_id          				VARCHAR2(20) NOT NULL,
       receive_id           				VARCHAR2(20) NOT NULL, 
       project_content      			VARCHAR2(100) NOT NULL
);   */

package probono.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "probono_project")
public class ProbonoProject {
	
	@Id
	@Column(name = "probono_project_id")
	private int probonoProjectId;
	
	@Column(name = "probono_project_name")
	@NonNull
	private String probonoProjectName;
	
	@JoinColumn(name = "probono_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	private Probono probonoId;
	
	@JoinColumn(name = "activist_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	private Activist activistId;
	
	@JoinColumn(name = "receive_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	private Recipient receiveId;
	
	@Column(name = "project_content")
	@NonNull
	private String projectContent;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 1. 프로젝트 id  \n   ");
		builder.append(probonoProjectId);
		builder.append("\n 2. 프로보노 프로젝트명 \n   ");
		builder.append(probonoProjectName);
		builder.append("\n 3. 프로보노 정보 \n");
		builder.append(probonoId);
		builder.append("\n 4. 재능 기부자 정보 \n");
		builder.append(activistId);
		builder.append("\n 5. 수해자 정보 \n");
		builder.append(receiveId);
		builder.append("\n 6. 프로젝트 제공내용\n   ");
		builder.append(projectContent);
		return builder.toString();
	}

}
