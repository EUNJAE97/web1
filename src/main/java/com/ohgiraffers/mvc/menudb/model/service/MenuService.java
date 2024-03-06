package com.ohgiraffers.mvc.menudb.model.service;

import com.ohgiraffers.mvc.menudb.model.dao.MenudbMapper;
import com.ohgiraffers.mvc.menudb.model.dto.menuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.mvc.common.mybatis.Template.getSqlSession;

public class MenuService {

    private MenudbMapper menudbMapper;

    public menuDTO selectOneMenuById(String menuCode) {

        SqlSession sqlSession = getSqlSession();
        System.out.println("sqlSession : " + sqlSession);

        menudbMapper = sqlSession.getMapper(MenudbMapper.class);

        menuDTO selectedMenu = menudbMapper.selectOneMenuById(menuCode);

        sqlSession.close();

        return selectedMenu;
    }

    public List<menuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        menudbMapper = sqlSession.getMapper(MenudbMapper.class);
        List<menuDTO> empList = menudbMapper.selectAllMenu();
        sqlSession.close();
        return empList;
    }


    public int insertMenu(menuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        menudbMapper = sqlSession.getMapper(MenudbMapper.class);

        int result = menudbMapper.insertMenu(menu);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public int updateMenu(menuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        menudbMapper = sqlSession.getMapper(MenudbMapper.class);

        int result = menudbMapper.updateMenu(menu);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public int deleteMenu(String menu) {

        SqlSession session = getSqlSession();
         menudbMapper = session.getMapper(MenudbMapper.class);

        int result = menudbMapper.deleteMenu(menu);

        if(result > 0) {
            session.commit();
        } else {
            session.rollback();
        }

        session.close();

        return result;
    }
}
