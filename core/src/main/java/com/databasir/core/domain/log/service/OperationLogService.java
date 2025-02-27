package com.databasir.core.domain.log.service;

import com.databasir.common.JsonData;
import com.databasir.core.domain.log.annotation.AuditLog;
import com.databasir.core.domain.log.converter.OperationLogPojoConverter;
import com.databasir.core.domain.log.converter.OperationLogRequestConverter;
import com.databasir.core.domain.log.data.OperationLogPageCondition;
import com.databasir.core.domain.log.data.OperationLogPageResponse;
import com.databasir.core.domain.log.data.OperationLogRequest;
import com.databasir.dao.impl.GroupDao;
import com.databasir.dao.impl.OperationLogDao;
import com.databasir.dao.impl.ProjectDao;
import com.databasir.dao.impl.UserDao;
import com.databasir.dao.tables.pojos.GroupPojo;
import com.databasir.dao.tables.pojos.OperationLogPojo;
import com.databasir.dao.tables.pojos.ProjectPojo;
import com.databasir.dao.tables.pojos.UserPojo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OperationLogService {

    private final OperationLogDao operationLogDao;

    private final UserDao userDao;

    private final GroupDao groupDao;

    private final ProjectDao projectDao;

    private final OperationLogRequestConverter operationLogRequestConverter;

    private final OperationLogPojoConverter operationLogPojoConverter;

    public Long save(OperationLogRequest request) {
        OperationLogPojo pojo = operationLogRequestConverter.toPojo(request);
        return operationLogDao.insertAndReturnId(pojo);
    }

    public void saveLoginFailedLog(String username, String msg) {
        try {
            JsonData result = JsonData.error("-1", Objects.requireNonNullElse(msg, "登录失败"));
            OperationLogRequest log = OperationLogRequest.builder()
                    .isSuccess(false)
                    .operationCode("login")
                    .operationModule(AuditLog.Modules.LOGIN)
                    .operationName("登录")
                    .operatorNickname(username)
                    .operatorUsername(username)
                    .operatorUserId(-1)
                    .operationResponse(result)
                    .build();
            OperationLogPojo pojo = operationLogRequestConverter.toPojo(log);
            operationLogDao.insertAndReturnId(pojo);
        } catch (Exception e) {
            log.error("保存登录日志失败", e);
        }
    }

    public void saveLoginLog(UserPojo user, Boolean success, String msg) {
        try {
            JsonData result;
            if (success) {
                result = JsonData.ok();
            } else {
                result = JsonData.error("-1", Objects.requireNonNullElse(msg, "登录失败"));
            }
            OperationLogRequest log = OperationLogRequest.builder()
                    .isSuccess(success)
                    .involvedUserId(user.getId())
                    .operationCode("login")
                    .operationModule(AuditLog.Modules.LOGIN)
                    .operationName("登录")
                    .operatorNickname(user.getNickname())
                    .operatorUsername(user.getUsername())
                    .operatorUserId(user.getId())
                    .operationResponse(result)
                    .build();
            OperationLogPojo pojo = operationLogRequestConverter.toPojo(log);
            operationLogDao.insertAndReturnId(pojo);
        } catch (Exception e) {
            log.error("保存登录日志失败", e);
        }
    }

    public Page<OperationLogPageResponse> list(Pageable page,
                                               OperationLogPageCondition condition) {
        Page<OperationLogPojo> pojoData = operationLogDao.selectByPage(page, condition.toCondition());
        List<Integer> groupIds = pojoData.filter(p -> p.getInvolvedGroupId() != null)
                .map(OperationLogPojo::getInvolvedGroupId)
                .toList();
        Map<Integer, GroupPojo> groupMapById = groupDao.selectAllInIds(groupIds)
                .stream()
                .collect(Collectors.toMap(GroupPojo::getId, Function.identity()));

        List<Integer> userIds = pojoData.filter(p -> p.getInvolvedUserId() != null)
                .map(OperationLogPojo::getInvolvedUserId)
                .toList();
        Map<Integer, UserPojo> userMapById = userDao.selectInIds(userIds)
                .stream()
                .collect(Collectors.toMap(UserPojo::getId, Function.identity()));

        List<Integer> projectIds = pojoData.filter(p -> p.getInvolvedProjectId() != null)
                .map(OperationLogPojo::getInvolvedProjectId)
                .toList();
        Map<Integer, ProjectPojo> projectMapById = projectDao.selectInIds(projectIds)
                .stream()
                .collect(Collectors.toMap(ProjectPojo::getId, Function.identity()));
        return pojoData.map(pojo -> operationLogPojoConverter.to(pojo, groupMapById, userMapById, projectMapById));
    }
}
