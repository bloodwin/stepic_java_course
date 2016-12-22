package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anna Bloodwina
 * @version 1.0.201612152036
 */
public class AccountService  {
    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;
    private final DBService dbService;

    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
        dbService = new DBService();
    }

    public void addNewUser(UserProfile userProfile) throws DBException {

        String name = userProfile.getLogin();
        String password = userProfile.getPassword();

        long id;

        if (password == null) {
            id = dbService.addUser(name);
        }

        id = dbService.addUser(name, password);

        userProfile.setId(id);

        //loginToProfile.put(userProfile.getLogin(), userProfile);

    }

    public UserProfile getUserByLogin(String login) throws DBException {
        //UserProfile profile = loginToProfile.get(login);

        UsersDataSet usersData = dbService.getUserByLogin(login);

        UserProfile profile = new UserProfile(usersData.getName(),
                                              usersData.getPassword(),
                                              usersData.getName());
        profile.setId(usersData.getId());

        return profile;
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile profile) {
        sessionIdToProfile.put(sessionId, profile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }

}
