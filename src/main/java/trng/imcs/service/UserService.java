package trng.imcs.service;

import javax.servlet.ServletConfig;

import trng.imcs.model.UserInfo;

public interface UserService {

	boolean validateUser(UserInfo user, ServletConfig servletConfig);

}
