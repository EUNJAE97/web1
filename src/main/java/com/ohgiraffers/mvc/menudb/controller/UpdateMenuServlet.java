package com.ohgiraffers.mvc.menudb.controller;

import com.ohgiraffers.mvc.menudb.model.dto.menuDTO;
import com.ohgiraffers.mvc.menudb.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menudb/update")
public class UpdateMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int menuCode = Integer.parseInt(req.getParameter("menuCode"));
        String menuName = req.getParameter("menuName");

        menuDTO menuDTO = new menuDTO();
        menuDTO.setMenuCode(String.valueOf(menuCode));
        menuDTO.setMenuName(menuName);

        MenuService menuService = new MenuService();
        int result = menuService.updateMenu(menuDTO);

        if (result > 0) {
            resp.sendRedirect(req.getContextPath() + "/menudb/select?menuCode=" + menuCode);
        } else {
            req.setAttribute("message","메뉴 정보 수정에 실패하였습니다.");
            req.getRequestDispatcher("/WEP-INF/views/common/errorPage.jsp").forward(req, resp);
        }
    }
}
