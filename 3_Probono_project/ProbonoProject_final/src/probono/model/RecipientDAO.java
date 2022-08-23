package probono.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.modelmapper.ModelMapper;

import probono.model.dto.RecipientDTO;
import probono.model.entity.Activist;
import probono.model.entity.Recipient;
import probono.model.util.DBUtil;

public class RecipientDAO {

	static ModelMapper modelMapper = new ModelMapper();

	/** 수혜자 등록 (insert) **/
	public static boolean addRecipient(RecipientDTO recipientDto) throws Exception {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.persist(modelMapper.map(recipientDto, Recipient.class));
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

	/** 수혜자 id 로 내용 수정 (update) **/
	public static boolean updateRecipientContent(String recipientId, String receiveHopeContent) throws Exception {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Recipient r = em.find(Recipient.class, recipientId);
			r.setReceiveHopeContent(receiveHopeContent);
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

	/** 수혜자 id 로 정보 삭제 (delete) **/
	public static boolean deleteRecipient(String recipientId) throws Exception {

		boolean result = false;
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Recipient r = em.find(Recipient.class, recipientId);
			em.remove(r);
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

	/** 특정 수혜자 정보 조회 (select) **/
	public static RecipientDTO getRecipient(String recipientId) throws Exception {

		Recipient recipientEntity = null;
		RecipientDTO recipientDto = null;
		EntityManager em = DBUtil.getEntityManager();

		try {
			recipientEntity = em.find(Recipient.class, recipientId);
			recipientDto = modelMapper.map(recipientEntity, RecipientDTO.class);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return recipientDto;
	}

	/** 전체 수혜자 정보 조회 (select) **/
	public static List<RecipientDTO> getAllRecipient() throws Exception {

		List<Recipient> recipientEntity = null;
		List<RecipientDTO> recipientDto = null;
		EntityManager em = DBUtil.getEntityManager();

		try {
			recipientEntity = em.createQuery("select r from Recipient r").getResultList();
			recipientDto = recipientEntity.stream().map(v -> modelMapper.map(v, RecipientDTO.class)).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
			em = null;
		}
		return recipientDto;
	}

}
