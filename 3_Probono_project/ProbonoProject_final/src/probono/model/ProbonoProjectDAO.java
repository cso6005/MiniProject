package probono.model;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.modelmapper.ModelMapper;

import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.model.entity.Activist;
import probono.model.entity.ProbonoProject;
import probono.model.util.DBUtil;

public class ProbonoProjectDAO {
	
	static ModelMapper modelMapper = new ModelMapper();

	/** 프로보노 프로젝트 저장 (insert) **/
	public static boolean addProbonoProject(ProbonoProjectDTO probonoProjectDto) throws Exception {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.persist(modelMapper.map(probonoProjectDto, ProbonoProject.class));
			tx.commit();
			result = true;

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

	/** 모든 프로보노 프로젝트 검색 (select) **/
	public static List<ProbonoProjectDTO> getAllProbonoProjects() throws Exception {

		List<ProbonoProject> projectEntity = null;
		List<ProbonoProjectDTO> projectDto = null;
		EntityManager em = DBUtil.getEntityManager();

		try {
			projectEntity = em.createQuery("select p from ProbonoProject p join fetch p.probonoId join fetch p.activistId join fetch p.receiveId").getResultList();
			projectDto = projectEntity.stream().map(v -> modelMapper.map(v, ProbonoProjectDTO.class)).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return projectDto;
	}

	/** 특정 프로보노 프로젝트 검색 (select) **/
	public static ProbonoProjectDTO getProbonoProject(int projectId) throws Exception {

		ProbonoProject projectEntity = null;
		ProbonoProjectDTO projectDto = null;
		EntityManager em = DBUtil.getEntityManager();

		try {
			projectEntity = (ProbonoProject) em.createQuery("select p from ProbonoProject p join fetch p.probonoId join fetch p.activistId join fetch p.receiveId where p.probonoProjectId=:id")
					.setParameter("id", projectId).getSingleResult();
			projectDto = modelMapper.map(projectEntity, ProbonoProjectDTO.class);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return projectDto;
	}

	/** 특정 프로보노 프로젝트 이름 검색 (select) **/
	public static String getProbonoProjectName(int projectId) throws Exception {

		String projectName = null;
		EntityManager em = DBUtil.getEntityManager();

		try {
			projectName = (String) em
					.createQuery("select p.probonoProjectName from ProbonoProject p where p.probonoProjectId=:id")
					.setParameter("id", projectId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return projectName;
	}

	/** 프로보노 프로젝트 ID로 재능기부자 수정 **/
	public static boolean updateProbonoProjectActivist(int projectId, ActivistDTO activistDto) throws SQLException {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			
			ProbonoProject p = em.find(ProbonoProject.class, projectId);
			p.setActivistId(modelMapper.map(activistDto, Activist.class));
			tx.commit();
			result = true;

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
			em = null;
		}

		return result;
	}

	/** 프로보노 프로젝트 id로 프로보노 프로젝트 삭제 **/
	public static boolean deleteProbonoProject(int probonoProjectId) throws Exception {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			ProbonoProject p = em.find(ProbonoProject.class, probonoProjectId);
			em.remove(p);
			tx.commit();
			result = true;

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
			em = null;
		}

		return result;

	}

}
