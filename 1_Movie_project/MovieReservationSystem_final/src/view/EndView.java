package view;

import java.util.ArrayList;

import model.dto.Movie;
import model.dto.ReservationList;

public class EndView {

	static private ArrayList<Movie> allMovieList = new ArrayList<Movie>();
	
	/** 상영중인 모든 영화를 조회하는 메소드
	 * 
	 * @param movieList
	 */
	public static void selectAllMovieView(ArrayList<Movie> movieList) {
		

		allMovieList = movieList;
		
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i) != null) {
				System.out.println(movieList.get(i));
			}
		}
	}

	public static void printMsg(String string) {
	}

	
	/** 특정 영화의 정보를 출력하는 메소드 
	 * 
	 * @param movie
	 */
	public static void searchMovieNameView(Movie movie) {
		System.out.println(movie);
	}
		
	
	/**
	 * 회원의 예매 정보를 조회하는 메소드
	 * 
	 * @param reservationList
	 */
	public static void reservationListView(ReservationList reservationList) {

		if (reservationList != null) {
			System.out.println("*** 예매 내역 조회 결과 ***");
			System.out.println(" - 상영관 번호 : " + reservationList.getTName() + "\n - 고객 이름 : "
					+ reservationList.getMName() + "\n - 영화 이름 : " + reservationList.getMTitle() + "\n - 시작 시간 : "
					+ reservationList.getStartTime() + "\n - 종료 시간 : " + reservationList.getEndTime() + "\n - 선택된 좌석 : "
					+ reservationList.getSeatIndex()[0] + "행" + reservationList.getSeatIndex()[1] + "열"
					+ "\n - 지불 금액 : " + reservationList.getSeat().getPrice());
		} else {
			System.out.println("해당 예매 정보는 존재하지 않습니다.");
		}
	}
}
