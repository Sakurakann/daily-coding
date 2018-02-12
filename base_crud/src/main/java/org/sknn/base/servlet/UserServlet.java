package org.sknn.base.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sknn.base.domain.User;
import org.sknn.base.utils.RequestParamsConverter;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: ${PACKAGE_NAME}.
 * User: Administrator. Date: 2018-02-08 15:21. Author: Haiyangp.
 */
@WebServlet("user")
public class UserServlet extends BaseServlet {

  private static final long serialVersionUID = 2738800472772970796L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);
  }


  public String registerPre(HttpServletRequest request,
      HttpServletResponse response) {
    return "/WEB-INF/jsp/user/register.jsp";
  }

  public String register(HttpServletRequest request,
      HttpServletResponse response) {
    Map<String, String[]> paramsMap = request.getParameterMap();
    User user = RequestParamsConverter.paramsMap2Pojo(paramsMap, User.class);

    return "/WEB-INF/jsp/user/registerSuccess.jsp";
  }

  public String login(HttpServletRequest request,
      HttpServletResponse response) {
    User user = RequestParamsConverter
        .paramsMap2Pojo(request.getParameterMap(), User.class);
    System.out.println(user);

    request.getSession().setAttribute("user", user);

    return "/WEB-INF/jsp/main.jsp";
  }
}
