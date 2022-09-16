package tour.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TravelDTO {
	
	private String travelId;
	
	private String travelName;
	
	private String city;
	
	private String period;
	
	private int price;
	
	private int starRate;
	

}
