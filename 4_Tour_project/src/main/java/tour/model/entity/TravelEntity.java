package tour.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@Entity
@Table(name = "travel")
public class TravelEntity {
	
	@Id
	@Column(name = "travel_id")
	private String travelId;
	
	@Column(name = "travel_name")
	@NonNull
	private String travelName;
	
	@NonNull
	private String city;
	
	@NonNull
	private String period;
	
	private int price;
	
	@Column(name = "star_rate")
	private int starRate;

}
