package com.amis.system.mapper;

import com.amis.common.core.domain.entity.SysAutoCodeResult;

import java.util.List;

public interface SysAutoCodeResultMapper {
    public List<SysAutoCodeResult> selectSysAutoCodeResultList(SysAutoCodeResult sysAutoCodeResult);

    public void add(SysAutoCodeResult sysAutoCodeResult);

    public void updateAutoCodeResult(SysAutoCodeResult sysAutoCodeResult);

    public void deleteById(Long codeId);


}
