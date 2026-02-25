package com.amis.mes.qc.service.impl;

import com.amis.mes.qc.domain.QcPendingInspect;
import com.amis.mes.qc.mapper.QcPendingInspectMapper;
import com.amis.mes.qc.service.IQcPendingInspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QcPendingInspectServiceImpl implements IQcPendingInspectService {

    @Autowired
    private QcPendingInspectMapper qcPendingInspectMapper;

    @Override
    public List<QcPendingInspect> selectQcPendingList(QcPendingInspect qcPendingInspect) {
        return qcPendingInspectMapper.selectQcPendingList(qcPendingInspect);
    }
}
