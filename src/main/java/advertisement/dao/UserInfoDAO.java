package advertisement.dao;

import advertisement.model.UserInfo;

public interface UserInfoDAO {
    public abstract UserInfo getActiveUser(String userName);
}
