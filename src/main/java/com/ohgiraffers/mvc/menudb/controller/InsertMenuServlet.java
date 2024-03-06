package com.ohgiraffers.mvc.menudb.controller;

import com.ohgiraffers.mvc.menudb.model.dto.menuDTO;
import com.ohgiraffers.mvc.menudb.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menudb/insert")
public class InsertMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String menuName = req.getParameter("menuName");
        String menuPrice = req.getParameter("menuPrice");
        String orderableStatus = req.getParameter("orderableStatus");
        String categoryCode = req.getParameter("categoryCode");



        menuDTO menu = new menuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setOrderableStatus(orderableStatus);
        menu.setCategoryCode(categoryCode);

        System.out.println("insert request menu : " + menu);

       MenuService menuService = new MenuService();
        int result = menuService.insertMenu(menu);

        if (result > 0) {
        /* insert가 성공 했을 경우 요청이 url이 그대로 남아있으면 브라우저 새로고침 시 insert 재요청이 발생한다.
        * forward가 아닌 redirect 처리가 필요하며 전체 사원 목록을 조회하는 기능을 요청하도록 한다.*/
            resp.sendRedirect(req.getContextPath() + "/menudb/list");
        } else {
            req.setAttribute("message","신규 메뉴 등록에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
        }
    }
}
