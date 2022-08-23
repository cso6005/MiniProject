package controller;

import model.dto.Movie;
import model.dto.ReservationList;
import model.dto.Theater;
import service.MovieReservationService;
import view.EndView;
import view.SuccessView;

public class MovieReservationController {

	private static MovieReservationService model = MovieReservationService.getInstance();

//	static private ArrayList<Movie> selectAllMovieList = new ArrayList<Movie>();
	
	/** 하나의 영화 객체를 추가하는 메소드 
	 * StarView가 데이터 저장을 위해 전송하는 메서드
	 * -> 예외 발생시 Fail(End)View로 출력 위임 
	 * -> 정상 실행시 SuccessView로 저장 성공 출력 위임 
	 * @param movie
	 */
	public static void movieInsert(Movie movie) {
		try {
			model.movieInsert(movie);
			SuccessView.printMsg("영화 등록 완료!");
		} catch(Exception e) {
			e.printStackTrace();
			EndView.printMsg("잘못 입력하였습니다.");
		}
	}
	
	
	public static void theaterInsert(Theater theater) {
		try {
			model.theaterInsert(theater);
			SuccessView.printMsg("상영관 등록 완료!");
		} catch(Exception e) {
			e.printStackTrace();
			EndView.printMsg("잘못 입력하였습니다.");
		}
	}
	
	
	public static void reservationInsert(ReservationList reservationList) {
		try {
			model.reservationListInsert(reservationList);
			SuccessView.printMsg("예매 정보 등록 완료!");
		} catch(Exception e) {
			e.printStackTrace();
			EndView.printMsg("잘못 입력하였습니다.");
		}
	}
}
