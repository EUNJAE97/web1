package com.ohgiraffers.mvc.menudb.controller;

import com.ohgiraffers.mvc.menudb.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menudb/delete")
public class DeleteMenuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int menuCode = Integer.parseInt(request.getParameter("menuCode"));

        MenuService menuService = new MenuService();
        int result = menuService.deleteMenu(String.valueOf(menuCode));

        if(result > 0) {
            response.sendRedirect(request.getContextPath() + "/menudb/list");
        } else {
            request.setAttribute("message", "메뉴 정보 삭제에 실패하였습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }
}

