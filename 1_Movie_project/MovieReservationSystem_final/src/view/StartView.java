/** 
 * PROJECT : 영화 예매 시스템 
 * NAME : StartView.java
 * DESC : 실행 클래스
 * 		- 기부자, 수혜자, 재능기부 종류 및 실제 진행되는 프로젝트 생성 및 CRUD 로직을 test하는 클래스
 * @author 4조 
 * @version 1.0
 */

package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MovieReservationController;
import model.dto.Member;
import model.dto.Movie;
import model.dto.ReservationList;
import model.dto.Seat;
import model.dto.Theater;
import service.MovieReservationService;

public class StartView {
	public static void main(String[] args) {

		MovieReservationService service = MovieReservationService.getInstance();

		/** Member 객체 */
		Member customer1 = new Member("최윤지", "user1", "uPass1", '2', 50000);
		Member customer2 = new Member("최소영", "user2", "uPass2", '2', 13000);
		Member customer3 = new Member("성익제", "user3", "uPass3", '2', 50000);
		Member customer4 = new Member("최소제", "user4", "uPass4", '2', 50000);

		/** Movie 객체 */
		Movie mv1 = new Movie("한산-용의 출현", "박해일, 변요한, 안성기", "액션, 드라마", "김한민",
				"나라의 운명을 바꿀 압도적 승리의 전투가 시작된다!\n" + "1592년 4월, 조선은 임진왜란 발발 후 단 15일만에 왜군에 한양을 빼앗기며 절체절명의 위기에 놓인다.\n"
						+ "조선을 단숨에 점령한 왜군은 명나라로 향하는 야망을 꿈꾸며 대규모 병역을 부산포로 집결시킨다.",
				"130분");
		Movie mv2 = new Movie("헌트", "이정재, 정우성, 전혜진", "액션, 드라마", "이정재",
				"조직 내 숨어든 스파이를 색출하라!\n" + "‘사냥꾼’이 될 것인가, ‘사냥감’이 될 것인가!\n" + "망명을 신청한 북한 고위 관리를 통해 정보를 입수한\n"
						+ "안기부 해외팀 ‘박평호’(이정재)와 국내팀 ‘김정도’(정우성)는\n" + "조직 내 숨어든 스파이 ‘동림’ 색출 작전을 시작한다.",
				"125분");
		Movie mv3 = new Movie("비상선언", "송강호, 이병헌, 전도연", "드라마", "한재림",
				"베테랑 형사 팀장 인호(송강호)는 비행기 테러 예고 영상 제보를 받고 사건을 수사하던 중\n" + "용의자가 실제로 KI501 항공편에 타고 있음을 파악한다.\n"
						+ "이 소식을 들은 국토부 장관 숙희(전도연)는 대테러센터를 구성하고\n" + "비행기를 착륙시킬 방법을 찾기 위해 긴급회의를 소집하는데…",
				"141분");
		Movie mv4 = new Movie("탑건", "톰 크루즈, 마일즈 텔러, 제니퍼 코넬리", "액션", "조셉 코신스키",
				"최고의 파일럿이자 전설적인 인물 매버릭(톰 크루즈)은 자신이 졸업한 훈련학교 교관으로 발탁된다. \n"
						+ "그의 명성을 모르던 팀원들은 매버릭의 지시를 무시하지만 실전을 방불케 하는 상공 훈련에서 눈으로 봐도 믿기 힘든 전설적인 조종 실력에 모두가 압도된다. \n"
						+ "매버릭의 지휘아래 견고한 팀워크를 쌓아가던 팀원들에게 국경을 뛰어넘는 위험한 임무가 주어지자\n"
						+ "매버릭은 자신이 가르친 동료들과 함께 마지막이 될 지 모를 하늘 위 비행에 나서는데… ",
				"130분");
		Movie mv5 = new Movie("미니언즈2", "스티브 카렐, 타라지 P.헨슨, 양자경", "애니메이션, 어드벤처, 코미디", "카일 발다",
				"세계 최고의 슈퍼 악당을 꿈꾸는 미니보스 ‘그루’와 그를 따라다니는 미니언들.\n" + "어느 날 그루는 최고의 악당 조직 ‘빌런6’의 마법 스톤을 훔치는데 성공하지만 \n"
						+ "뉴페이스 미니언 ‘오토’의 실수로 스톤을 잃어버리고 빌런6에게 납치까지 당한다.",
				"87분");
		Movie mv6 = new Movie("헤어질 결심", "탕웨이, 박해일, 이정현", "로맨스, 멜로, 드라마", "박찬욱",
				"산 정상에서 추락한 한 남자의 변사 사건.\n" + "담당 형사 '해준'(박해일)은\n" + "사망자의 아내 '서래'(탕웨이)와 마주하게 된다.\n"
						+ "남편의 죽음 앞에서 특별한 동요를 보이지 않는 '서래'.\n" + "경찰은 보통의 유가족과는 다른 '서래'를 용의선상에 올린다.\n"
						+ "'해준'은 사건 당일의 알리바이 탐문과 신문,\n" + "잠복수사를 통해 '서래'를 알아가면서\n" + "그녀에 대한 관심이 점점 커져가는 것을 느낀다.",
				"138분");
		Movie mv7 = new Movie("외계+인 1부", "류준열, 김우빈, 김태리", "액션, 환타지, SF", "최동훈",
				"2022년 현재, ‘가드’(김우빈)’와 ‘썬더’는 인간의 몸에 가두어진 외계인 죄수를 관리하며 지구에 살고 있다.\n" + "어느 날, 서울 상공에 우주선이 나타나고 \n"
						+ "형사 ‘문도석’(소지섭)은 기이한 광경을 목격하게 되는데.." + "\n" + "2022년 인간 속에 수감된 외계인 죄수를 쫓는 이들\n"
						+ "1391년 고려 말 소문 속의 신검을 차지하려는 도사들\n" + "시간의 문이 열리고\n" + "모든 것이 바뀌기 시작했다!",
				"142분");
		Movie mv8 = new Movie("토이스토리3", "톰 행크스, 팀 알렌, 조앤 쿠삭", "애니메이션, 코미디, 가족, 판타지, 모험, 키즈", "리 언크리치",
				"어른이 된 대부분의 사람들이 그렇듯이\n" + "앤디는 더 이상 우디와 버즈를 비롯한 모든 장난감을 가지고 놀지 않게 되었고,\n" + "그들은 몇년째 상자안에만 갇혀지내고 있다.\n"
						+ "앤디가 고등학교를 졸업하여 대학에 진학, 집을 떠나게 된 앤디는 장난감들을 위에 다락방에 넣으려고 했지만\n"
						+ "어머니의 실수로 쓰레기차에 버려질 뻔하다가 다행히 써니사이드(햇빛 마을) 탁아소로 가게 된다.\n" + "\n"
						+ "앤디가 자신들을 버렸다고 생각하는 장난감들은 어린이집에 들어가게 되고 거대한 음모와 마주하게 된다.\n"
						+ "그러다 앤디가 자신들을 버리려고 한것이 아니었다는 사실을 알게 된 장난감들은 어린이집을 탈출하려고 한다.",
				"102분");

		/** seat 객체 - 1관 ~ 8관 */
		int x = 5;
		int y = 5;
		String[][] setSeat = { { "◻︎", "◻︎", "◻︎", "◻︎", "◻︎" }, { "◻︎", "◻︎", "◻︎", "◻︎", "◻︎" },
				{ "◻︎", "◻︎", "◻︎", "◻︎", "◻︎" }, { "◻︎", "◻︎", "◻︎", "◻︎", "◻︎" }, { "◻︎", "◻︎", "◻︎", "◻︎", "◻︎" } };

		Seat seat1 = new Seat(setSeat, 15000);
		Seat seat2 = new Seat(setSeat, 15000);
		Seat seat3 = new Seat(setSeat, 15000);
		Seat seat4 = new Seat(setSeat, 15000);
		Seat seat5 = new Seat(setSeat, 15000);
		Seat seat6 = new Seat(setSeat, 15000);
		Seat seat7 = new Seat(setSeat, 15000);
		Seat seat8 = new Seat(setSeat, 15000);

		/** theater 객체 - movie 1 ~ 8, seat 1 ~ 8 */
		Theater theater1 = new Theater(1, seat1, "07:10", "09:20", mv1);
		Theater theater2 = new Theater(2, seat2, "09:30", "11:35", mv2);
		Theater theater3 = new Theater(3, seat3, "11:45", "14:06", mv3);
		Theater theater4 = new Theater(4, seat4, "14:20", "16:30", mv4);
		Theater theater5 = new Theater(5, seat5, "16:40", "18:07", mv5);
		Theater theater6 = new Theater(6, seat6, "18:20", "20:38", mv6);
		Theater theater7 = new Theater(7, seat7, "20:50", "23:12", mv7);
		Theater theater8 = new Theater(8, seat8, "23:20", "25:02", mv8);

		/** reservationList 객체 **/
		int[] seatIndex1 = { 3, 3 };
		int[] seatIndex2 = { 2, 3 };
		int[] seatIndex3 = { 3, 2 };
		int[] seatIndex4 = { 2, 2 };
		int[] seatIndex5 = { 4, 4 };
		int[] seatIndex6 = { 2, 4 };
		int[] seatIndex7 = { 1, 1 };
		int[] seatIndex8 = { 2, 1 };

		/** 고객의 예매 정보 내역 등록 */
		ReservationList reservationList1 = new ReservationList(theater1.getName(), customer1.getName(), mv1.getTitle(),
				theater1.getStartTime(), theater1.getEndTime(), seatIndex1, seat1);
		ReservationList reservationList2 = new ReservationList(theater2.getName(), customer2.getName(), mv2.getTitle(),
				theater2.getStartTime(), theater2.getEndTime(), seatIndex2, seat2);
		ReservationList reservationList3 = new ReservationList(theater3.getName(), customer3.getName(), mv3.getTitle(),
				theater3.getStartTime(), theater3.getEndTime(), seatIndex3, seat3);
		ReservationList reservationList4 = new ReservationList(theater4.getName(), customer4.getName(), mv4.getTitle(),
				theater4.getStartTime(), theater4.getEndTime(), seatIndex4, seat4);
		ReservationList reservationList5 = new ReservationList(theater5.getName(), customer1.getName(), mv5.getTitle(),
				theater5.getStartTime(), theater5.getEndTime(), seatIndex5, seat5);
		ReservationList reservationList6 = new ReservationList(theater6.getName(), customer2.getName(), mv6.getTitle(),
				theater6.getStartTime(), theater6.getEndTime(), seatIndex6, seat6);
		ReservationList reservationList7 = new ReservationList(theater7.getName(), customer3.getName(), mv7.getTitle(),
				theater7.getStartTime(), theater7.getEndTime(), seatIndex7, seat7);
		ReservationList reservationList8 = new ReservationList(theater8.getName(), customer4.getName(), mv8.getTitle(),
				theater8.getStartTime(), theater8.getEndTime(), seatIndex8, seat8);

		MovieReservationController.reservationInsert(reservationList1);
		MovieReservationController.reservationInsert(reservationList2);
		MovieReservationController.reservationInsert(reservationList3);
		MovieReservationController.reservationInsert(reservationList4);
		MovieReservationController.reservationInsert(reservationList5);
		MovieReservationController.reservationInsert(reservationList6);
		MovieReservationController.reservationInsert(reservationList7);
		MovieReservationController.reservationInsert(reservationList8);

		/** 영화 정보 등록 */
		MovieReservationController.movieInsert(mv1);
		MovieReservationController.movieInsert(mv2);
		MovieReservationController.movieInsert(mv3);
		MovieReservationController.movieInsert(mv4);
		MovieReservationController.movieInsert(mv5);
		MovieReservationController.movieInsert(mv6);
		MovieReservationController.movieInsert(mv7);
		MovieReservationController.movieInsert(mv8);

		/** 상영관 정보 등록 */
		MovieReservationController.theaterInsert(theater1);
		MovieReservationController.theaterInsert(theater2);
		MovieReservationController.theaterInsert(theater3);
		MovieReservationController.theaterInsert(theater4);
		MovieReservationController.theaterInsert(theater5);
		MovieReservationController.theaterInsert(theater6);
		MovieReservationController.theaterInsert(theater7);
		MovieReservationController.theaterInsert(theater8);

		// --------------------------------------------------- start method
		
		Scanner sc = new Scanner(System.in);
		
		/** 상영중인 전체 영화 조회 */
		System.out.println("\n\n\n\n\n\n⎯⎯⎯ 상영중인 영화 조회 ⎯⎯⎯");
		ArrayList<Movie> movieList = service.selectAllMovie();
		EndView.selectAllMovieView(movieList);

		/** 특정 영화 정보 검색 */
		String title;
		String choice;
		Movie movie;

		while (true) {
			System.out.println("⎯⎯⎯ 영화 조회 ⎯⎯⎯");
			System.out.print("제목: ");
			title = sc.next();
			movie = service.searchMovieName(title);
			EndView.searchMovieNameView(movie);
			System.out.println("1. 예매 \t\t 2. 다른 영화 조회 ");
			choice = sc.next();
			if (choice.equals("1")) {
				break;
			}
		}

		System.out.println("⎯⎯⎯  좌석 현황 ⎯⎯⎯");
		service.getSeat(service.searchMovieName(title));
		System.out.println("⎯⎯⎯ 좌석 예매 ⎯⎯⎯");
		service.upDateSeat(seatIndex1[0], seatIndex1[1], service.getTheater(movie));
		System.out.println("⎯⎯⎯ 금액 확인 ⎯⎯⎯");
		service.getCash(customer1, service.getTheater(movie));

		/** 좌석 현황 조회 */
		String mName;

		while (true) {
			System.out.println("⎯⎯ 예매 내역 조회 ⎯⎯");
			System.out.print("제목: ");
			mName = sc.next();

			ReservationList reservationList = service.selectMovieReservationList(mName);
			EndView.reservationListView(reservationList);
			System.out.println("1. 예매 취소 \t\t 2. 예매 변경 ");
			choice = sc.next();
			if (choice.equals("1")) {
				ReservationList result = service.deleteReservationMovie(mName);
				System.out.println("⎯⎯ 예매 정보 조회 ⎯⎯");
				EndView.reservationListView(result);
				break;
			} else {
				System.out.println("현재 좌석");
				service.getSeat(service.searchMovieName(mName));
				System.out.println("변경된 좌석");
				service.upDateSeat2(seatIndex8[0], seatIndex8[1], service.getTheater(service.searchMovieName(mName)));

			}
		}
	}
}
