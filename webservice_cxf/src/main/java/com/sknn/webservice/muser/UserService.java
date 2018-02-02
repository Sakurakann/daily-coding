package com.sknn.webservice.muser;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * com.sknn.webservice.muser. User: Administrator. Date: 2018-01-23 15:09.
 * Author: Haiyangp.
 */
@WebService
public interface UserService {

  @WebMethod
  public String MUserServer(@WebParam(name = "jsonParam") String jsonParam);

  @WebMethod
  public String modifyMuser(@WebParam(name = "jsonParam")String jsonParam);

  @WebMethod
  public String searchMuserCut(@WebParam(name = "jsonParam")String jsonParam);

  @WebMethod
  public String searchMuser(@WebParam(name = "jsonParam")String jsonParam);

  @WebMethod
  public String sendSmsBill(@WebParam(name = "jsonParam")String jsonParam);
}
