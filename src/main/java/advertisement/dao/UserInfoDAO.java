package advertisement.dao;

import advertisement.model.UserInfo;

public interface UserInfoDAO {
    UserInfo getActiveUser(String userName);
}
