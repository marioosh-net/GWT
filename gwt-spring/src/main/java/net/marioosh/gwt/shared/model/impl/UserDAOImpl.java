package net.marioosh.gwt.shared.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.marioosh.gwt.shared.model.dao.UserDAO;
import net.marioosh.gwt.shared.model.entities.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

	private Logger log = Logger.getLogger(getClass());
	
	public UserDAOImpl() {
		super(User.class);
	}

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public User getByLogin(String login) {
		String sql = "from User where login = ?";
		Query query = getSession().createQuery(sql);
		query.setString(0, login);
		return (User) query.uniqueResult();
	}

	@Override
	public List<User> findAll() {
		String sql = "from User";
		Query query = getSession().createQuery(sql);
		return query.list();
	}
	
	@Override
	public List<User> findAll(int page) {
		int offset = page * 5;
		String sql = "from User";
		Query query = getSession().createQuery(sql);
		query.setMaxResults(5);
		query.setFirstResult(offset);
		return query.list();
	}
	
	@Override
	public int countPages(int rowPerPage) {
		String sql = "select count(*) from User";
		Query query = getSession().createQuery(sql);
		return (((Long)query.uniqueResult()).intValue() / rowPerPage) + 1;
	}
	
	@Override
	public Serializable add(User obj) {
		obj.setPassword(DigestUtils.md5Hex(obj.getPassword()));
		return super.add(obj);
	}

}
