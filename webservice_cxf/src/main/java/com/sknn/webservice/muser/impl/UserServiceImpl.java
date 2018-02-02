package com.sknn.webservice.muser.impl;

import com.sknn.webservice.muser.UserService;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * com.sknn.webservice.muser.impl. User: Administrator. Date: 2018-01-23 15:15.
 * Author: Haiyangp.
 */
@WebService
public class UserServiceImpl implements UserService {

  @Override
  public String MUserServer(String jsonParam) {
    return "";
  }

  @Override
  public String modifyMuser(String jsonParam) {
    return null;
  }

  @Override
  public String searchMuserCut(String jsonParam) {
    return null;
  }

  @Override
  public String searchMuser(String jsonParam) {
    return null;
  }

  @Override
  public String sendSmsBill(String jsonParam) {
    return null;
  }
}
