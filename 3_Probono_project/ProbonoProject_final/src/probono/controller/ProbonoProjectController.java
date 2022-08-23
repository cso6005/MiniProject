package probono.controller;

import java.sql.SQLException;

import probono.model.ActivistDAO;
import probono.model.ProbonoDAO;
import probono.model.ProbonoProjectDAO;
import probono.model.RecipientDAO;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.model.dto.RecipientDTO;
import probono.view.RunningEndView;
import probono.view.RunningSuccessView;

public class ProbonoProjectController {

	/** Activist - crud **/
	/** 기부자 등록 **/
	public static void addActivist(ActivistDTO activistDto) throws Exception {

		try {
			ActivistDAO.addActivist(activistDto);
			RunningSuccessView.succMsg("기부자 ID " + activistDto.getActivistId() + "의 정보를 등록 완료 했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("새로운 기부자 저장시 에러 발생");
		}
	}

	/** 기부자 id 로 주요 기부 major 내용 수정 **/
	public static void updateActivistMajor(String activistId, String major) throws Exception {

		try {
			ActivistDAO.updateActivistMajor(activistId, major);
			RunningSuccessView.succMsg("기부자 ID " + activistId + "의 정보를 수정 완료 했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("기부 내용 수정 시 에러 발생");
		}
	}

	/** 기부자 id 로 패스워드 수정 **/
	public static void updateActivistPw(String activistId, String pw) throws Exception {

		try {
			ActivistDAO.updateActivistPw(activistId, pw);
			RunningSuccessView.succMsg("기부자 ID " + activistId + "의 정보를 수정 완료 했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("기부 내용 수정 시 에러 발생");
		}
	}

	/** 기부자 id 로 기부자 정보 삭제 **/
	public static void deleteActivist(String activistId) throws Exception {

		try {
			ActivistDAO.deleteActivist(activistId);
			RunningSuccessView.succMsg("기부자 ID " + activistId + "의 정보를 삭제 완료 했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("기부 내용 수정 시 에러 발생");
		}

	}

	/** 기부자 id 로 기부자 전체 정보 조회 **/
	public static void getActivist(String activistId) throws Exception {
		try {
			RunningEndView.allView(ActivistDAO.getActivist(activistId));
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("해당 기부자 검색 오류. 기부자 id 를 확인하세요.");
		}
	}

	/** 기부자 목록 검색 **/
	public static void getAllActivist() throws Exception {
		try {
			RunningEndView.activistListView(ActivistDAO.getAllActivists());
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("기부자 목록 검색시 에러 발생");
		}
	}

	/** Recipient - crud **/
	/** 새로운 수혜자 저장 **/
	public static void addRecipient(RecipientDTO recipientDto) throws Exception {

		try {
			RecipientDAO.addRecipient(recipientDto);
			RunningSuccessView.succMsg("수혜자 ID " + recipientDto.getRecipientId() + "의 정보를 등록 완료 했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("새로운 수혜자 저장시 에러 발생");
		}
	}

	/** 수혜자 아이디로 수혜자 목적 수정 **/
	public static void updateRecipientContent(String recipientId, String receiveHopeContent) throws Exception {
		try {
			RecipientDAO.updateRecipientContent(recipientId, receiveHopeContent);
			RunningSuccessView.succMsg("수혜자 ID " + recipientId + "의 정보를 수정 완료 했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("수혜자 id로 수혜자 목적 변경 오류");
		}
	}

	/** 수혜자 아이디로 수혜자 삭제 **/
	public static void deleteRecipient(String recipientId) throws Exception {
		try {
			RecipientDAO.deleteRecipient(recipientId);
			RunningSuccessView.succMsg("수혜자 ID " + recipientId + "의 정보를 삭제 완료 했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("수혜자 삭제시 에러 발생");
		}
	}

	/** 수혜자 아이디로 수혜자 검색 **/
	public static void getRecipient(String recipientId) throws Exception {
		try {
			RunningEndView.allView(RecipientDAO.getRecipient(recipientId));
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("수혜자 id로 해당 수혜자 검색 오류");
		}
	}

	/** 모든 수혜자 검색 **/
	public static void getAllRecipient() throws Exception{
		try {
			RunningEndView.recipientListView(RecipientDAO.getAllRecipient());
		} catch (Exception s) {
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}

	/** probono - crud **/
	/** 프로보노 생성 **/
	public static void createProbonoView(ProbonoDTO probonoDto) throws Exception {
		try {
			RunningEndView.createProbono(probonoDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 전체 프로보노 목록 조회 **/
	public static void getProbonoView(String probonoId) throws Exception {
		try {
			RunningEndView.getProbono(probonoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 특정 프로보노 조회 **/
	public static void getAllProbonoView() throws Exception {
		try {
			RunningEndView.getAllProbono();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 특정 프로보노 목적 정보 수정**/
	public static void updateProbonoView(String probonoId, String probonoPurpose) throws Exception {
		try {
			RunningEndView.updateProbono(probonoId, probonoPurpose);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 특정 프로보노 정보 삭제 **/
	public static void deleteProbonoView(String probonoId) throws Exception {
		try {
			RunningEndView.deleteProbono(probonoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** ProbonoProject - crud **/
	/** 새로운 프로젝트 생성 **/
	public static void addProbonoProject(String name, String probonoId, String activistId, String recevieId, String content) throws Exception {

		ProbonoDTO probonoDto = null;
		ActivistDTO activistDto = null;
		RecipientDTO recipientDto = null;

		try {
			probonoDto = ProbonoDAO.getProbono(probonoId);
			activistDto = ActivistDAO.getActivist(activistId);
			recipientDto = RecipientDAO.getRecipient(recevieId);

			ProbonoProjectDAO
					.addProbonoProject(new ProbonoProjectDTO(name, probonoDto, activistDto, recipientDto, content));
			RunningSuccessView.succMsg(name + " 정보를 등록 완료했습니다.");

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("새로운 프로젝트 저장시 에러 발생");
		}
	}

	/** 모든 프로젝트 정보 검색 **/
	public static void getAllProbonoProjects() throws Exception {
		try {
			RunningEndView.projectListView(ProbonoProjectDAO.getAllProbonoProjects());
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("프로젝트 목록 검색시 에러 발생");
		}
	}

	/** 프로젝트 id 로 프로젝트 전체 정보 조회 **/
	public static void getProbonoProject(int projectId) throws Exception {
		try {
			RunningEndView.allView(ProbonoProjectDAO.getProbonoProject(projectId));
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("해당 프로젝트 검색 오류. 프로젝트 id 를 확인하세요.");
		}
	}

	/** 프로젝트 id 로 프로젝트 이름 정보 조회 **/
	public static void getProbonoProjectName(int projectId) throws Exception {
		try {
			RunningEndView.allView(ProbonoProjectDAO.getProbonoProjectName(projectId));
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("해당 프로젝트 검색 오류. 프로젝트 id 를 확인하세요.");
		}
	}

	/** 프로보노 프로젝트 ID로 재능기부자 수정 **/
	public static void updateProbonoProjectActivist(int projectId, String activistId) throws Exception {
		ActivistDTO activistDto = null;

		try {
			activistDto = ActivistDAO.getActivist(activistId);
			ProbonoProjectDAO.updateProbonoProjectActivist(projectId, activistDto);
			RunningSuccessView.succMsg(projectId + " 의 기부자 정보를 수정 완료 했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("프로젝트 수정시 에러 발생");
		}
	}

	/** 프로젝트 id 로 프로젝트 정보 삭제 **/
	public static void deleteProbonoProject(int probonoProjectId) throws Exception {

		try {
			ProbonoProjectDAO.deleteProbonoProject(probonoProjectId);
			RunningSuccessView.succMsg(probonoProjectId + "의 정보를 삭제 완료 했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("프로젝트 삭제시 에러 발생");
		}
	}

}
