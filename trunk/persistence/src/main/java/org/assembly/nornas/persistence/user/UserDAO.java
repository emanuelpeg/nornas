package org.assembly.nornas.persistence.user;

import java.util.Arrays;
import java.util.List;

import org.assembly.nornas.model.user.User;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.user.UserRepository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 * @author emanuel
 *
 * class represents a DAO of Person 
 * 
 */
public class UserDAO extends BaseDao<User> implements UserRepository {

	@Override
	protected Class<User> getClase() {
		return User.class;
	}

	@Override
	public User findByEmail(String email) {
		String hql = " from "+ User.class.getCanonicalName() + " as u" +
				     " join u.emails as e " +
				     " where e = :email"; 
		
		Query query = this.getSession().createQuery(hql);
		query.setString("email", email);
		List<User> users = query.list();
		
		if (!users.isEmpty()) {
			return users.get(0);
		}
		
		return null;
	}

	@Override
	public User findByNick(String nick) {
		Criteria criteria = getCriteriaByNick(nick);
		List<User> users = criteria.list();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByNickAndPassword(String userNick, String userPassword) {
		Criteria criteria = getCriteriaByNick(userNick);
		criteria.add(Restrictions.eq("password", userPassword));
		List<User> users = criteria.list();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	private Criteria getCriteriaByNick(String userNick) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.eq("nick", userNick));
		return criteria;
	}


}
