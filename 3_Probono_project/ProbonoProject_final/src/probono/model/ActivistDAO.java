package probono.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.modelmapper.ModelMapper;

import probono.model.dto.ActivistDTO;
import probono.model.entity.Activist;
import probono.model.util.DBUtil;

/** 기부자 table과 관계된 DAO 클래스 **/

public class ActivistDAO {

	static ModelMapper modelMapper = new ModelMapper();

	/** 기부자 등록 (insert) **/
	public static boolean addActivist(ActivistDTO activistDto) throws Exception {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.persist(modelMapper.map(activistDto, Activist.class));
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

	/** 기부자 id 로 주요 기부 내용 수정 (update) **/
	public static boolean updateActivistMajor(String activistId, String major) throws Exception {

		boolean b = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.find(Activist.class, activistId).setMajor(major);
			tx.commit();
			b = true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return b;

	}

	/** 기부자 id 로 비밀번호 수정 (update) **/
	public static boolean updateActivistPw(String activistId, String pw) throws Exception {

		boolean b = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.find(Activist.class, activistId).setPassword(pw);
			tx.commit();
			b = true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return b;

	}

	/** 기부자 id 로 기부자 정보 삭제 (delete) **/
	public static boolean deleteActivist(String activistId) throws Exception {

		boolean b = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.remove(em.find(Activist.class, activistId));
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
			em = null;
		}
		return b;

	}

	/** id로 해당 기부자의 모든 정보 반환 (select) **/
	public static ActivistDTO getActivist(String activistId) throws Exception {

		Activist activistEntity = null;
		ActivistDTO activistDto = null;
		EntityManager em = DBUtil.getEntityManager();

		try {
			activistEntity = (Activist) em.createQuery("select a from Activist a where a.activistId = :id")
					.setParameter("id", activistId).getSingleResult();
			activistDto = modelMapper.map(activistEntity, ActivistDTO.class);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
			em = null;
		}
		return activistDto;

	}

	/** 모든 기부자 조회 후 반환 (select) **/
	public static List<ActivistDTO> getAllActivists() throws Exception {

		List<Activist> activistEntity = null;
		List<ActivistDTO> activistDto = null;

		EntityManager em = DBUtil.getEntityManager();

		try {
			activistEntity = em.createQuery("select a from Activist a").getResultList();
			activistDto = activistEntity.stream().map(v -> modelMapper.map(v, ActivistDTO.class))
					.collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
			em = null;
		}
		return activistDto;

	}
}
