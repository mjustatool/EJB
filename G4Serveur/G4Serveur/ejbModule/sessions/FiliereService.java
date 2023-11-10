package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Filiere;
import entities.Student;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "FiliereService")
public class FiliereService implements IDao<Filiere>,IDaoLocal<Filiere> {

	@PersistenceContext
	private EntityManager em;
	
	
	@PermitAll
	@Override
	public Filiere create(Filiere o) {
		em.persist(o);
		return o;
	}
	
	@PermitAll
	@Override
	public Filiere delete(Filiere o) {
		Filiere mergeFiliere = em.merge(o);
		em.remove(mergeFiliere);
		return mergeFiliere;
	}
	
	@PermitAll
	@Override
	public Filiere update(Filiere o) {
		Filiere filiere = em.find(Filiere.class, o.getId());
		filiere.setCode(o.getCode());
		filiere.setName(o.getName());
		em.merge(filiere);
		return filiere;
	}
	
	@PermitAll
	@Override
	public Filiere findById(int id) {
		return em.find(Filiere.class,id);
	}

	@PermitAll
	@Override
	public List<Filiere> findAll() {
		Query q = em.createQuery("Select f from Filiere f");
		return q.getResultList();
	}
	
	@PermitAll
	public Student assignFiliereToStudent(int filiereId,int studentId) {
		Student student = em.find(Student.class, studentId);
		Filiere filier = em.find(Filiere.class, filiereId);
		student.setFiliere(filier);
		em.merge(student);
		return student;
	}

}
