package com.ohgiraffers.mvc.menudb.controller;

import com.ohgiraffers.mvc.menudb.model.dto.menuDTO;
import com.ohgiraffers.mvc.menudb.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/menudb/list")
public class SelectAllMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MenuService menuService = new MenuService();
        List<menuDTO> menuList = menuService.selectAllMenu();

        String path = "";
        if(menuList != null && !menuList.isEmpty()) {
            path = "/WEB-INF/views/menudb/menuList.jsp";
            req.setAttribute("menuList", menuList);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "메뉴 전체 목록이 조회 되지 않았습니다.");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
