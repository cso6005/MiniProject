package tour.model;

import java.sql.SQLException;
import java.util.List;

import tour.exception.MessageException;
import tour.exception.NotExistException;
import tour.model.dto.TravelDTO;
import tour.model.dto.UsersDTO;

public class TourService {

	static TravelDAO tDAO = TravelDAO.getInstance();
	static UsersDAO uDAO = UsersDAO.getInstance();

	/** Travel - id 검색 정보 유무 확인 **/
	public static void notExistTravelId(String travelId) throws Exception {
		
		TravelDTO travel = tDAO.getTravelId(travelId);
		
		if (travel == null) {
			throw new NotExistException("검색하신 여행 정보가 없습니다.");
		}
	}

	/** Travel - name 검색 정보 유무 확인 **/
	public static void notExistTravelName(String travelName) throws Exception {
		
		TravelDTO travel = tDAO.getTravelName(travelName);
		
		if (travel == null) {
			throw new NotExistException("검색하신 여행 정보가 없습니다.");
		}
	}

	/** Travel - 모든 여행 정보 조회 **/
	public static List<TravelDTO> getAllTravle() throws Exception {
		
		List<TravelDTO> travelList = tDAO.getAllTravel();

		if (travelList == null) {
			throw new NotExistException("검색하신 여행 정보가 없습니다.");
		}
		
		return travelList;
	}

	/** Travel - 특정 여행 정보 조회 - id **/
	public static TravelDTO getTravelId(String travelId) throws Exception {

		TravelDTO travel = tDAO.getTravelId(travelId);

		if (travel == null) {
			throw new NotExistException("검색하신 여행 정보가 없습니다.");
		}
		
		return travel;
	}

	/** Travel - 특정 여행 정보 조회 - name **/
	public static TravelDTO getTravelName(String travelName) throws Exception {

		TravelDTO travel = tDAO.getTravelName(travelName);

		if (travel == null) {
			throw new NotExistException("검색하신 여행 정보가 없습니다.");
		}
		
		return travel;
	}

	/** Travel - 투어 여행 등록 **/
	public static boolean addTravel(TravelDTO travel) throws Exception {

		boolean result = false;

		try {
			result = tDAO.addTravel(travel);
		} catch (SQLException s) {
			throw new MessageException("이미 존재하는 ID입니다. 다시 시도 하세요");
		}
		
		return result;
	}

	/** User - 검색 정보 유무 확인 **/
	public static void notExistUser(String userId) throws Exception {

		UsersDTO user = uDAO.getUser(userId);

		if (user == null) {
			throw new NotExistException("해당 계정의 예약내역은 존재 없습니다.");
		}
	}

	/** User - 특정 고객 예약 정보 조회 **/
	public static UsersDTO getUser(String userId) throws Exception {

		UsersDTO user = uDAO.getUser(userId);

		if (user == null) {
			throw new NotExistException("검색하신 여행 정보가 없습니다.");
		}
		
		return user;
	}

	/** User - 투어 예약 등록 **/
	public static boolean addUser(UsersDTO user) throws Exception {

		boolean result = false;

		try {
			result = uDAO.addUser(user);
		} catch (SQLException s) {
			throw new MessageException("이미 존재하는 ID입니다. 다시 시도 하세요");
		}
		
		return result;
	}

	/** User - 투어 예약 취소 **/
	public static boolean deleteUser(String userId) throws Exception {

		notExistUser(userId);
		boolean result = uDAO.deleteUser(userId);

		if (!result) {
			throw new NotExistException("예약 정보 삭제 실패");
		}
		
		return result;
	}

	/** User - 투어 예약 변경 **/
	public static boolean updateUserTravel(String userId, String travelId) throws Exception {

		notExistUser(userId);
		notExistTravelId(travelId);

		boolean result = uDAO.updateUserTravel(userId, travelId);

		if (!result) {
			throw new NotExistException("예약 정보 변경 실패");
		}
		
		return result;
	}

}
