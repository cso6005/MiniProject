package service;

import java.util.ArrayList;

import model.dto.Member;
import model.dto.Movie;
import model.dto.ReservationList;
import model.dto.Theater;
import view.EndView;

/**
 * 영화 예매 시스템 서비스
 */
public class MovieReservationService {

	private static MovieReservationService instance = new MovieReservationService();

	private MovieReservationService() {
	}

	public static MovieReservationService getInstance() {
		return instance;
	}

	private static Member member = new Member();

	private ArrayList<Movie> selectAllMovieList = new ArrayList<Movie>();
	private ArrayList<Theater> selectAllTheaterList = new ArrayList<Theater>();
	private ArrayList<ReservationList> allreservaitionList = new ArrayList<ReservationList>();

	/**
	 * 모든 영화 조회
	 * 
	 * @return 상영중인 영화 List
	 */
	public ArrayList<Movie> selectAllMovie() {
		return selectAllMovieList;
	}

	/**
	 * 전체 영화관 목록 조회
	 * 
	 */
	public ArrayList<Theater> selectAllTheater() {
		return selectAllTheaterList;
	}

	/**
	 * 영화명을 통해 하나의 영화 객체를 받아오는 메소드
	 * 
	 * @param title
	 * @return 하나의 Movie 객체
	 */
	public Movie searchMovieName(String title) {
		Movie movie = null;

		for (Movie movies : selectAllMovieList) {
			if (movies.getTitle().equals(title)) {
				movie = movies;
			}
		}
		return movie;
	}

	/**
	 * 하나의 영화 객체를 추가하는 메소드
	 * 
	 * @param movie
	 */
	public void movieInsert(Movie movie) {
		selectAllMovieList.add(movie);
	}

	public void getSeat(Movie movie) {

		String[][] seatState = { {} };
		for (Theater i : selectAllTheaterList) {
			if (movie.getTitle().equals(i.getMovie().getTitle())) {
				seatState = i.getSeat().getSeat();
			}
		}

		for (int i = 0; i < seatState.length; i++) {
			for (int j = 0; j < seatState.length; j++) {
				System.out.print(seatState[i][j]);
				System.out.print(" ");
				if (j == seatState.length - 1) {
					System.out.println("");
				}
			}
		}
	}

	public Theater getTheater(Movie movie) {

		Theater theater = selectAllTheaterList.get(0);
		for (Theater i : selectAllTheaterList) {
			if (movie.getTitle().equals(i.getMovie().getTitle())) {
				theater = i;
			}
		}
		return theater;
	}

	/**
	 * 잔액 조회, member.cash 정보를 넘겨받는 메소드
	 * 
	 * @param member
	 * @param theater
	 * @return 하나의 member 객체
	 * @throws Exception
	 */
	public Member getCash(Member member, Theater theater) {
		if (member.getCash() >= theater.getSeat().getPrice()) {
			member.setCash(member.getCash() - theater.getSeat().getPrice());
			System.out.println("정상 예매");
		} else {
			EndView.printMsg("잔액 부족");
		}
		return member;
	}

	/**
	 * 예매 좌석을 변경하는 메소드
	 * 
	 * @param x, y, i
	 * @param theater
	 * @throws Exception
	 */
	public Theater upDateSeat(int x, int y, Theater theater) {

		String arr[][] = theater.getSeat().getSeat();

		arr[x][y] = "◼︎";
		theater.getSeat().setSeat(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
				if (j == arr.length - 1) {
					System.out.println("");
				}
			}
		}
		return theater;
	}

	/**
	 * 회원의 예매 정보를 저장하는 메소드
	 * 
	 * @param reservationList
	 */
	public void reservationListInsert(ReservationList reservationList) {
		allreservaitionList.add(reservationList);
	}

	/**
	 * 회원의 예매 내역을 불러오는 메소드
	 * 
	 * @param mName
	 * @return ReservationList 객체
	 */
	public ReservationList selectMovieReservationList(String mName) {
		ReservationList result = null;

		for (ReservationList r : allreservaitionList) {
			if (r.getMTitle().equals(mName)) {
				result = r;
				break;
			}
		}
		return result;
	}

	/**
	 * 예매 취소 메소드
	 * 
	 * @param movieName
	 * @return ReservationList 객체
	 */
	public ReservationList deleteReservationMovie(String movieName) {
		ReservationList result = null;

		for (ReservationList r : allreservaitionList) {
			if (r.getMTitle().equals(movieName)) {

				int i = r.getSeatIndex()[0]; 
				int j = r.getSeatIndex()[1]; 
				r.getSeat().getSeat()[i][j] = "◻︎";

				member.setCash(member.getCash() + r.getSeat().getPrice());

				r = null;
				result = r;
				break;
			}
		}
		return result;
	}

	public void theaterInsert(Theater theater) {
		selectAllTheaterList.add(theater);
	}

	public void upDateSeat2(int x, int y, Theater theater2) {
		String[][] arr = theater2.getSeat().getSeat();

		for (int z = 0; z < arr.length; z++) {
			for (int k = 0; k < arr.length; k++) {
				if (arr[z][k].equals("◼︎")) {
					arr[z][k] = "◻︎";
				}
			}
		}
		arr[x][y] = "◼︎";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
				if (j == arr.length - 1) {
					System.out.println("");
				}
			}
		}
		System.out.println("변경이 완료되었습니다");
	}

}
