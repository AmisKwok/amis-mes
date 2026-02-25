package com.amis.system.service.impl;

import com.amis.system.domain.UserTask;
import com.amis.system.mapper.UserTaskMapper;
import com.amis.system.service.IUserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaskServiceImpl implements IUserTaskService {

    @Autowired
    private UserTaskMapper userTaskMapper;

    @Override
    public List<UserTask> listTodoList(String userName) {
        return userTaskMapper.listTodoList(userName);
    }

    @Override
    public List<UserTask> listFinishedList(String userName) {
        return userTaskMapper.listFinishedList(userName);
    }
}
