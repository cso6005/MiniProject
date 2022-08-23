package probono.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.modelmapper.ModelMapper;

import probono.model.dto.ProbonoDTO;
import probono.model.entity.Probono;
import probono.model.util.DBUtil;

public class ProbonoDAO {

	static ModelMapper modelMapper = new ModelMapper();

	/** 프로보노 생성 (insert) **/
	public static boolean createProbono(ProbonoDTO probonoDto) throws Exception {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;
		try {
			em.persist(modelMapper.map(probonoDto, Probono.class));
			tx.commit();
			result = true;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

	/** 특정 프로보노 조회 (select) **/
	public static ProbonoDTO getProbono(String probonoId) throws Exception {

		EntityManager em = DBUtil.getEntityManager();
		Probono probonoEntity = null;
		ProbonoDTO proboDto = null;

		try {
			probonoEntity = em.find(Probono.class, probonoId);
			proboDto = modelMapper.map(probonoEntity, ProbonoDTO.class);
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return proboDto;
	}

	/** 전체 프로보노 정보 조회 (select) **/
	public static List<ProbonoDTO> getAllProbonos() throws Exception {

		List<Probono> probonoEntity = null;
		List<ProbonoDTO> probonoDto = null;
		EntityManager em = DBUtil.getEntityManager();

		try {
			probonoEntity = em.createQuery("select p from Probono p").getResultList();
			probonoDto = probonoEntity.stream().map(v -> modelMapper.map(v, ProbonoDTO.class))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return probonoDto;
	}

	/** 프로보노 id로 목적 수정 (update) **/
	public static boolean updateProbono(String probonoId, String probonoPurpose) throws Exception {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.find(Probono.class, probonoId).setProbonoPurpose(probonoPurpose);
			tx.commit();
			result = true;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

	/** 프로보노 id 로 프로보노 정보 섹제 (delete) **/
	public static boolean deleteProbono(String probonoId) throws Exception {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Probono p = em.find(Probono.class, probonoId);
			em.remove(p);
			tx.commit();
			result = true;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

}
