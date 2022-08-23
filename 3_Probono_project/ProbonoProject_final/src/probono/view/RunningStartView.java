package probono.view;

import probono.controller.ProbonoProjectController;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.RecipientDTO;

public class RunningStartView {

	public static void main(String[] args) throws Exception {

//		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
//		System.out.println("***** 프로보노 포로젝트 *****");
//		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯\n");

		System.out.println("***** 기부자 전체 정보 조회 *****");
		ProbonoProjectController.getAllActivist();

		System.out.println("***** 기부자 id 로 기부자 전체 정보 조회 *****");
		ProbonoProjectController.getActivist("giver3");

		System.out.println("***** 새로운 기부자 등록 *****");
		ProbonoProjectController.addActivist(new ActivistDTO("giver4", "도의사", "gp4", "dermatology"));
		ProbonoProjectController.getActivist("giver4");

		System.out.println("***** 기부자 id 로 주요 기부 내용 수정 *****");
		ProbonoProjectController.updateActivistMajor("giver4", "culture");
		ProbonoProjectController.getAllActivist();

		System.out.println("***** 기부자 id 로 비밀번호 정보 수정 *****");
		ProbonoProjectController.updateActivistPw("giver4", "1234");
		ProbonoProjectController.getActivist("giver4");

		System.out.println("***** 기부자 id 로 기부자 정보 삭제 *****");
		ProbonoProjectController.deleteActivist("giver4");
		ProbonoProjectController.getAllActivist();

		System.out.println("***** 현재 수혜자 정보 조회 *****");
		ProbonoProjectController.getAllRecipient();

		System.out.println("***** 새로운 수혜자 저장 *****");
		ProbonoProjectController.addRecipient(new RecipientDTO("receivePeople5", "나드름", "rp4", "여드름 치료"));
		ProbonoProjectController.getAllRecipient();

		System.out.println("***** 수혜자 내용 수정 *****");
		ProbonoProjectController.updateRecipientContent("receivePeople5", "등드름 치료");
		ProbonoProjectController.getRecipient("receivePeople5");

		System.out.println("***** 수혜자 정보 삭제 *****");
		ProbonoProjectController.deleteRecipient("receivePeople5");
		ProbonoProjectController.getAllRecipient();

		System.out.println("***** 프로보노 생성 *****");
		ProbonoProjectController.createProbonoView(new ProbonoDTO("Monkey D Luffy", "해적왕 프로젝트", "세계의 보물 원피스를 찾는 사람 분야"));

		System.out.println("***** 프로보노 조회 *****");
		ProbonoProjectController.getProbonoView("Monkey D Luffy");

		System.out.println("***** 프로보노 수정 *****");
		ProbonoProjectController.updateProbonoView("Monkey D Luffy", "세계에서 가장 자유로운 사람 분야");

		System.out.println("***** 모든 프로보노 정보 조회 *****");
		ProbonoProjectController.getAllProbonoView();

		System.out.println("***** 프로보노 정보 삭제 *****");
		ProbonoProjectController.deleteProbonoView("Monkey D Luffy");

		System.out.println("***** 새로운 프로젝트 저장 *****");
		ProbonoProjectController.addProbonoProject("룰루 프로젝트", "schweitzer", "giver2", "receivePeople2", "장학금지원");
		ProbonoProjectController.addProbonoProject("호호호 프로젝트", "schweitzer", "giver1", "receivePeople1", "문화지원");

		System.out.println("***** 진행되는 모든 Project 검색 *****");
		ProbonoProjectController.getAllProbonoProjects();

		System.out.println("***** 특정 프로보노 프로젝트 검색 *****");
		ProbonoProjectController.getProbonoProject(10003);

		System.out.println("***** 특정 프로보노 프로젝트 이름 검색 *****");
		ProbonoProjectController.getProbonoProjectName(10000);

		System.out.println("***** 특정 프로보노 프로젝트의 기부자 정보 수정  *****");
		ProbonoProjectController.updateProbonoProjectActivist(10003, "giver2");
		ProbonoProjectController.getProbonoProject(10003);

		System.out.println("***** 프로젝트 내용 삭제 *****");
		ProbonoProjectController.deleteProbonoProject(10004);
		ProbonoProjectController.getAllProbonoProjects();

	}

}
