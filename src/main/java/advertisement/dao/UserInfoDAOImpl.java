package advertisement.dao;

import advertisement.model.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserInfo getActiveUser(String username) {
        UserInfo userInfo = new UserInfo();
        Query query = entityManager.createQuery("SELECT u FROM UserInfo u WHERE u.username = :username ");
        query.setParameter("username", username);
        List<UserInfo> results = query.getResultList();
        if (!results.isEmpty()) {
            userInfo = (UserInfo) results.get(0);
        }
        return userInfo;
    }
}