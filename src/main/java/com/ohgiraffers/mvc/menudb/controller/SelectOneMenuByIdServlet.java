package com.ohgiraffers.mvc.menudb.controller;

import com.ohgiraffers.mvc.menudb.model.dto.menuDTO;
import com.ohgiraffers.mvc.menudb.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menudb/select")
public class SelectOneMenuByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuCode = req.getParameter("menuCode");
        System.out.println("menuCode : " + menuCode);

        MenuService menuService = new MenuService();
        menuDTO selectedMenu = menuService.selectOneMenuById(menuCode);
        System.out.println("selectedMenu : " + selectedMenu);

        String path = "";
        if(selectedMenu != null) {
            path = "/WEB-INF/views/menudb/showMenuInfo.jsp";
            req.setAttribute("selectedMenu", selectedMenu);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "해당 메뉴코드를 가진 메뉴는 없습니다.");
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }
}
