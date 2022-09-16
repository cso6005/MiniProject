package tour.model;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.modelmapper.ModelMapper;

import tour.model.dto.TravelDTO;
import tour.model.entity.TravelEntity;
import tour.model.util.DBUtil;

public class TravelDAO {

	private static TravelDAO instance = new TravelDAO();

	private TravelDAO() {
	}

	public static TravelDAO getInstance() {
		return instance;
	}

	static ModelMapper modelMapper = new ModelMapper();

	/** 투어 여행 등록 **/
	public boolean addTravel(TravelDTO travelDto) throws SQLException {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			em.persist(modelMapper.map(travelDto, TravelEntity.class));
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

	/** 전체 투어여행 정보 조회 **/
	public List<TravelDTO> getAllTravel() throws Exception {
		
		EntityManager em = DBUtil.getEntityManager();
		
		List<TravelEntity> travelEntity = null;
		List<TravelDTO> travelDto = null;

		try {
			travelEntity = em.createQuery("select t from TravelEntity t").getResultList();
			travelDto = travelEntity.stream().map(v -> modelMapper.map(v, TravelDTO.class))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
			em = null;
		}

		return travelDto;
	}

	/** 특정 투어 조회 - id **/
	public TravelDTO getTravelId(String travelId) throws Exception {

		EntityManager em = DBUtil.getEntityManager();

		TravelEntity travelEntity = null;
		TravelDTO travelDto = null;

		try {
			travelEntity = em.find(TravelEntity.class, travelId);
			travelDto = modelMapper.map(travelEntity, TravelDTO.class);
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
			em = null;
		}

		return travelDto;
	}

	/** 특정 투어 조회 - name **/
	public TravelDTO getTravelName(String travelName) throws Exception {

		EntityManager em = DBUtil.getEntityManager();

		TravelEntity travelEntity = null;
		TravelDTO travelDto = null;

		try {
			travelEntity = (TravelEntity) em.createQuery("select t from TravelEntity t where t.travelName = :name")
					.setParameter("name", travelName).getSingleResult();
			travelDto = modelMapper.map(travelEntity, TravelDTO.class);
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
			em = null;
		}

		return travelDto;
	}

	/** 투어 정보 삭제 **/
	public boolean deleteTravel(String travelId) throws Exception {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			TravelEntity travel = em.find(TravelEntity.class, travelId);
			em.remove(travel);
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
