package com.ohgiraffers.mvc.menudb.model.dao;

import com.ohgiraffers.mvc.menudb.model.dto.menuDTO;

import java.util.List;

public interface MenudbMapper {
    menuDTO selectOneMenuById(String menuCode);

    List<menuDTO> selectAllMenu();

    int insertMenu(menuDTO menu);

    int updateMenu(menuDTO menu);

    int deleteMenu(String menu);
}
