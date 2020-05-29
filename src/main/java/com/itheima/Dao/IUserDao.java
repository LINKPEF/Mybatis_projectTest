package com.itheima.Dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * 持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     *
     * @return
     */
    List<User> findAll();
}

