package tour.model;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.modelmapper.ModelMapper;

import tour.model.dto.UsersDTO;
import tour.model.entity.TravelEntity;
import tour.model.entity.UsersEntity;
import tour.model.util.DBUtil;

public class UsersDAO {

	private static UsersDAO instance = new UsersDAO();

	private UsersDAO() {
	}

	public static UsersDAO getInstance() {
		return instance;
	}

	static ModelMapper modelMapper = new ModelMapper();

	/** 회원 등록 **/
	public boolean addUser(UsersDTO usersDto) throws Exception {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.persist(modelMapper.map(usersDto, UsersEntity.class));
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

	/** 특정 회원의 정보 조회 **/
	public UsersDTO getUser(String userId) throws Exception {

		EntityManager em = DBUtil.getEntityManager();

		UsersEntity userEntity = null;
		UsersDTO userDto = null;

		try {
			userEntity = (UsersEntity) em.createQuery("select u from UsersEntity u where u.userId = :id")
					.setParameter("id", userId).getSingleResult();
			userDto = modelMapper.map(userEntity, UsersDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}

		return userDto;
	}

	/** 고객 예약 정보 삭제 **/
	public boolean deleteUser(String userId) throws Exception {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			UsersEntity user = em.find(UsersEntity.class, userId);
			em.remove(user);
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

	/** 고객 예약 정보 수정 - travelId 변경 **/
	public boolean updateUserTravel(String userId, String travelId) throws SQLException {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			UsersEntity user = em.find(UsersEntity.class, userId);
			TravelEntity travel = em.find(TravelEntity.class, travelId);
			user.setTravelId(modelMapper.map(travel, TravelEntity.class));
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
