package org.sknn.base.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: ${PACKAGE_NAME}.
 * User: Administrator. Date: 2018-02-08 15:24. Author: Haiyangp.
 */
public class BaseServlet extends HttpServlet {

  private static final long serialVersionUID = 5537978871655540622L;

  /**
   * override original service method(dispatcher by httpMethod[post, get,
   * delete...])
   */
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");

    String cmdMethod = req.getParameter("cmd");
    if (cmdMethod == null || cmdMethod.trim().isEmpty()) {
      doGet(req, res);
      System.out.println("The URL Parameter:[ cmd ] is required!");
      return;
    }
    Method method = null;
    try {
      method = this.getClass()
          .getMethod(cmdMethod, HttpServletRequest.class,
              HttpServletResponse.class);
    } catch (NoSuchMethodException e) {
      doGet(req, res);
      System.out.println(
          "Method name: " + cmdMethod + " is not found! Please check.");
      e.printStackTrace();
      return;
    }

    try {
      String result = (String) method.invoke(this, req, res);
      if (result != null && !result.trim().isEmpty()) {
        int colonIndex = result.indexOf(":");
        // not exist char ":"
        if (colonIndex < 1) {
          req.getRequestDispatcher(result)
              .forward(req, res);
        } else {
          String prefix = result.substring(0, colonIndex);
          String value = result.substring(colonIndex + 1);
          // forward
          if (prefix.indexOf("f") == 0) {
            req.getRequestDispatcher(value)
                .forward(req, res);
            // redirect
          } else if (prefix.indexOf("r") == 0) {
            res.sendRedirect(value);
            // json
          } else if (prefix.indexOf("j") == 0) {
            res.getWriter().write(value);
          } else {
            req.getRequestDispatcher(value)
                .forward(req, res);
          }
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
