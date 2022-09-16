package tour.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tour.model.TourService;
import tour.model.dto.TravelDTO;
import tour.model.dto.UsersDTO;

@WebServlet("/tour")
public class TourFrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/** process **/
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String command = request.getParameter("command");

		try {
			if (command.equals("travelAll")) {
				travelAll(request, response);
			} else if (command.equals("travelId")) {
				travelId(request, response);
			} else if (command.equals("travelName")) {
				travelName(request, response);
			} else if (command.equals("user")) {
				user(request, response);
			} else if (command.equals("reservationReq")) {
				reservationReq(request, response);
			} else if (command.equals("reservation")) {
				reservation(request, response);
			} else if (command.equals("reservationUpdReq")) {
				reservationUpdReq(request, response);
			} else if (command.equals("reservationUpd")) {
				reservationUpdate(request, response);
			} else if (command.equals("reservationDel")) {
				reservationDelete(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	/** 모든 투어 여행 조회 메소드 **/
	public void travelAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.setAttribute("travelAll", TourService.getAllTravle());
			url = "travelList.jsp";
			System.out.println(TourService.getAllTravle());
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/** 고객 정보 내 예약 투어 정보 조회 메소드 - id **/
	public void travelId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.setAttribute("travel", TourService.getTravelId(request.getParameter("travelId")));
			url = "travelDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/** 투어 여행 검색 메소드 - name **/
	public void travelName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.setAttribute("travel", TourService.getTravelName(request.getParameter("travelName")));
			url = "travelDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/** 회원 정보 검색 메소드 **/
	public void user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.setAttribute("user", TourService.getUser(request.getParameter("userId")));
			url = "userDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/** 회원 여행 예약 등록 **/
	public void reservation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String travelId = request.getParameter("travelId");

		try {
			TravelDTO travel = TourService.getTravelId(travelId);
			if (travel != null) {
				UsersDTO user = new UsersDTO(userId, userPw, userName, travel);
				boolean result = TourService.addUser(user);
				if (result) {
					request.setAttribute("user", user);
					request.setAttribute("successMsg", "가입 완료");
					url = "userDetail.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/** 투어 예약 서비스 요구 **/
	public void reservationReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.setAttribute("travelId", request.getParameter("travelId"));
			url = "travelInsertCode.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/** 투어 예약 서비스 수정 요구 **/
	public void reservationUpdReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";

		try {
			request.setAttribute("user", TourService.getUser(request.getParameter("userId")));
			url = "userUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/** 투어 예약 정보 삭제 **/
	public void reservationDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";
		String userId = request.getParameter("userId");

		try {
			if (TourService.deleteUser(userId)) {
				request.setAttribute("msg", "예약 삭제 완료되었습니다.");
				url = "showMsg.jsp";
			} else {
				request.setAttribute("errorMsg", "재 실행 해 주세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", "재 실행 해 주세요");
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/** 예약 정보 투어 변경 **/
	public void reservationUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "showError.jsp";
		String userId = request.getParameter("userId");
		String travelId = request.getParameter("travelId");

		try {
			if (TourService.updateUserTravel(userId, travelId)) {
				request.setAttribute("user", TourService.getUser(userId));
				url = "userDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "재 실행 해 주세요");
			}
		} catch (Exception s) {
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
