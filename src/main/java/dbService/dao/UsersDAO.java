package dbService.dao;

import dbService.dataSets.UsersDataSet;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Anna Bloodwina
 * @version 1.0.201612221505
 */
public class UsersDAO {

    private Session session;

    //private EntityManager em = HibernateUtil.getEm();

    public UsersDAO(Session session) { this.session = session; }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public Long getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet usersDataSet = (UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        if (usersDataSet == null) {
            return null;
        }
        return usersDataSet.getId();
    }

    public long insertUser(String name) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name));
    }

    public long insertPassword(String name, String password) {
        return (Long) session.save(new UsersDataSet(name, password));
    }
}
