package sessions;

import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Role;
import entities.Student;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "RoleService")
public class RoleService implements IDao<Role>,IDaoLocal<Role>{
	
	@PersistenceContext
	private EntityManager em;
	@PermitAll
	@Override
	public Role create(Role o) {
		em.persist(o);
		return o;
	}
	@PermitAll
	@Override
	public Role delete(Role o) {
		em.remove(o);
		return o;
	}
	@PermitAll
	@Override
	public Role update(Role o) {
		Role role = em.find(Role.class, o.getId());
		role.setName(o.getName());
		role.setUsers(o.getUsers());
		em.merge(role);
		return role;
	}
	@PermitAll
	@Override
	public Role findById(int id) {
		
		return em.find(Role.class, id);
	}
	@PermitAll
	@Override
	public List<Role> findAll() {
		Query q = em.createQuery("Select r from Role r");
		return q.getResultList();
	}

	

}
