package tour.model.entity;

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
import lombok.ToString;
import tour.model.dto.TravelDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@Entity
@Table(name = "users")
public class UsersEntity {
	
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_pw")
	@NonNull
	private String userPw;
	
	@Column(name = "user_name")
	@NonNull
	private String userName;
	
	@JoinColumn(name = "travel_id")
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	private TravelEntity travelId;

}
