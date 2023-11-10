package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Student;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "StudentService")
public class StudentService implements IDao<Student>,IDaoLocal<Student>{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@PermitAll
	@Override
	public Student create(Student o) {
		em.persist(o);
		return o;
	}
	@PermitAll
	@Override
	public Student delete(Student o) {
		Student mergeStudent = em.merge(o);
		em.remove(mergeStudent);
		return mergeStudent;
	}
	@PermitAll
	@Override
	public Student update(Student o) {
		Student student = em.find(Student.class, o.getId());
		student.setEmail(o.getEmail());
		student.setFirstName(o.getFirstName());
		student.setLastName(o.getLastName());
		student.setTelephone(o.getTelephone());
		em.merge(student);
		return student;
	}
	@PermitAll
	@Override
	public Student findById(int id) {
		return em.find(Student.class, id);
	}
	@PermitAll
	@Override
	public List<Student> findAll() {
		Query q = em.createQuery("select s from Student s");
	    return q.getResultList();
	}

}
