package probono.view;

import java.util.List;

import probono.model.ProbonoDAO;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.model.dto.RecipientDTO;

public class RunningEndView {

	/** 모든 프로젝트 정보 조회 **/
	public static void projectListView(List<ProbonoProjectDTO> activistListlProbonoProject) {

		int listSize = activistListlProbonoProject.size();

		if (listSize != 0) {
			activistListlProbonoProject
					.forEach(v -> System.out.println(v + "\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"));
			System.out.println("\n");

		} else {
			System.out.println("검색 정보 없음");
		}
	}

	/** 전체 수혜자 정보 조회 **/
	public static void recipientListView(List<RecipientDTO> recipients) {
		int listSize = recipients.size();
		if (listSize != 0) {
			recipients.forEach(v -> System.out.println(v + "\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"));
			System.out.println("\n");
		} else {
			System.out.println("검색 정보 없음");
		}
	}

	/** 전체 기부자 정보 조회 **/
	public static void activistListView(List<ActivistDTO> activists) {
		int listSize = activists.size();
		if (listSize != 0) {
			activists.forEach(v -> System.out.println(v + "\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"));
			System.out.println("\n");
		} else {
			System.out.println("검색 정보 없음");
		}
	}

	/** 모든 DTO 정보 출력 **/
	public static void allView(Object object) {
		System.out.println(object);
		System.out.println("\n");
	}

	/** 예외 상황 출력 **/
	public static void showError(String message) {
		System.out.println(message);
		System.out.println("\n");

	}

	/** 프로보노 생성 정보 출력  **/
	public static void createProbono(ProbonoDTO probonoDto) throws Exception {
		boolean result = ProbonoDAO.createProbono(probonoDto);
		if (result == true) {
			System.out.println("프로보노 ID " + probonoDto.getProbonoId() + "의 정보를 등록 완료 했습니다.");
			System.out.println("\n");
		} else {
			RunningEndView.showError("입력 오류 발생");
		}
	}

	/** 특정 프로보노 정보 조회 출력 **/
	public static void getProbono(String probonoId) throws Exception {
		ProbonoDTO p = ProbonoDAO.getProbono(probonoId);
		if (p != null) {
			System.out.println(p);
			System.out.println("\n");
		} else {
			RunningEndView.showError("데이터 조회 에러");
		}
	}

	/** 전체 프로보노 정보 조회 출력 **/
	public static void getAllProbono() throws Exception {
		List<ProbonoDTO> probonos = ProbonoDAO.getAllProbonos();
		int listSize = probonos.size();
		if (listSize != 0) {
			probonos.forEach(v -> System.out.println(v + "\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯\n"));
		} else {
			RunningEndView.showError("데이터 조회 에러");
		}
	}

	/** 프로보노 정보 수정 출력 **/
	public static void updateProbono(String probonoId, String probonoPurpose) throws Exception {
		boolean result = ProbonoDAO.updateProbono(probonoId, probonoPurpose);
		if (result == true) {
			System.out.println("프로보노 ID " + probonoId + "의 정보를 수정 완료 했습니다.");
			System.out.println("\n");
		} else {
			RunningEndView.showError("입력 오류 발생");
		}
	}

	/** 프로보노 정보 삭제 출력 **/
	public static void deleteProbono(String probonoId) throws Exception {
		boolean result = ProbonoDAO.deleteProbono(probonoId);
		if (result == true) {
			System.out.println("프로보노 ID " + probonoId + "의 정보를 삭제 완료 했습니다.");
			System.out.println("\n");
		} else {
			RunningEndView.showError("입력 오류 발생");
		}
	}

}
