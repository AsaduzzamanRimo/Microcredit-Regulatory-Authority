package com.doer.mraims.user.application.service;

import com.doer.mraims.user.application.port.in.UnAuthBranchFeatureUseCase;
import com.doer.mraims.user.application.port.in.dto.request.UserSaveRequest;
import com.doer.mraims.user.application.port.in.dto.request.ApprovalUserRequest;
import com.doer.mraims.user.application.port.in.dto.request.LockUnlockUserRequest;
import com.doer.mraims.user.application.port.out.UnAuthUserPersistencePort;
import com.doer.mraims.user.domain.User;
import com.doer.mraims.core.util.Constant;
import com.doer.mraims.core.util.IdGenerator;
import com.doer.mraims.core.util.MessageCode;
import com.doer.mraims.core.util.ResponseCode;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import com.doer.mraims.core.util.repository.UtilRepository;
import com.doer.mraims.core.util.response.CommonListResponseBody;
import com.doer.mraims.core.util.response.CommonObjectResponseBody;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.doer.mraims.core.util.Constant.ACTIVE;


@RequiredArgsConstructor
@Service
public class UnAuthUserService implements UnAuthBranchFeatureUseCase {


    private final ModelMapper modelMapper;

    private final IdGenerator idGenerator;

    private final UtilRepository utilRepository;

    private final UnAuthUserPersistencePort unauthUserPersistencePort;


    @Override
    public CommonObjectResponseBody saveUnAuthUser(UserSaveRequest saveRequest, Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            //params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
            //int count = unauthUserPersistencePort.countUnAuthUser(params.get("schemaName"));
            saveRequest.setStatus(ACTIVE);
            saveRequest.setCurrentVersion(String.valueOf(0));
            saveRequest.setEditCommit(Constant.YES);
            User requestedUser = mapRequestToDomain(saveRequest, params);
            User user = unauthUserPersistencePort.save(requestedUser, params);
            if (user == null)
                throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not saved");
            CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(user).build();
            response.setStatus(true);
            response.setCode(ResponseCode.CREATED.getValue());
            response.setMessageCode(MessageCode.MSG_2005.getCode());
            response.setMessage(MessageCode.MSG_2005.getMessage());
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not Save");
        }
    }

    @Override
    public CommonListResponseBody<Object> findAllUnAuthUser(Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            List<User> userList = unauthUserPersistencePort.findAllUnAuthUser(params);
            int existingBranchCount = unauthUserPersistencePort.countTotalUnAuthUserForPagination(params);
            CommonListResponseBody<Object> response;
            if (userList.isEmpty()) {
                response = CommonListResponseBody.builder().data(new ArrayList<>()).build();
                //            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
            } else {
                response = CommonListResponseBody.builder().data(Arrays.asList(userList.toArray())).build();
                response.setStatus(true);
                response.setCode(ResponseCode.OK.getValue());
                response.setMessageCode(MessageCode.MSG_2000.getCode());
                response.setMessage(MessageCode.MSG_2000.getMessage());
                response.setCount(existingBranchCount);
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
    }

    @Override
    public CommonObjectResponseBody findUnAuthUserByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            User user = unauthUserPersistencePort.findByOid(oid, params);
            if (user == null)
                throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found by this oid: " + oid);
            CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(user).build();
            response.setStatus(true);
            response.setCode(ResponseCode.OK.getValue());
            response.setMessageCode(MessageCode.MSG_2003.getCode());
            response.setMessage(MessageCode.MSG_2003.getMessage());
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
    }

    @Override
    public CommonObjectResponseBody updateUnAuthUser(UserSaveRequest request, String oid, Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            User user = null;
            //params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
            User existUser = unauthUserPersistencePort.findByOid(oid, params);
            if (existUser != null) {
                request.setOid(oid);
                user = unauthUserPersistencePort.updateState(mapRequestToDomain(request, params), params);
            }
            if (user == null)
                throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not updated");
            CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(user).build();
            response.setStatus(true);
            response.setCode(ResponseCode.CREATED.getValue());
            response.setMessageCode(MessageCode.MSG_2007.getCode());
            response.setMessage(MessageCode.MSG_2007.getMessage());
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not Updated");
        }
    }

    @Override
    public CommonListResponseBody<Object> lockUnAuthUser(@NotNull LockUnlockUserRequest request, Map<String, String> params) throws ExceptionHandlerUtil {

        try {
            List<User> userList = null;
            CommonListResponseBody response = null;
            //params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
            List<User> existUserList = unauthUserPersistencePort.findOidsByOidListExceptUnAuthOids(request.getOidList(), params);
            if (existUserList.size() > 0) {
                List<String> existOids = existUserList.stream().map(User::getOid).collect(Collectors.toList());
                userList = unauthUserPersistencePort.updateLockStatusUnAuthUser(request.getLoginId(), existOids, params);
                int[] insertUnAuthBranch = unauthUserPersistencePort.batchSaveUnAuthUser(userList, params, request.getLoginId());
                response = CommonListResponseBody.builder().data(Arrays.asList(userList.toArray())).build();
                response.setStatus(true);
                response.setCount(userList.size());
                response.setCode(ResponseCode.CREATED.getValue());
                response.setMessageCode(MessageCode.MSG_2010.getCode());
                response.setMessage(MessageCode.MSG_2010.getMessage());

            } else {
                if (existUserList.isEmpty() || existUserList.size() == 0)
                    throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "User data not Found !!!");
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
    }


    @Override
    public CommonListResponseBody<Object> unlockUnAuthUser(@NotNull LockUnlockUserRequest request, Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            List<User> userList = null;
            CommonListResponseBody response = null;
            //params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
            List<User> existUserList = unauthUserPersistencePort.findUnlockLoginListByOids(request.getOidList(), params, request.getLoginId());
            if (existUserList.size() > 0) {
                userList = unauthUserPersistencePort.updateUnlockStatusUnAuthUser(request.getLoginId(), existUserList.stream().map(User::getOid).collect(Collectors.toList()), params);
                response = CommonListResponseBody.builder().data(Arrays.asList(userList.toArray())).build();
                response.setStatus(true);
                response.setCount(userList.size());
                response.setCode(ResponseCode.CREATED.getValue());
                response.setMessageCode(MessageCode.MSG_2010.getCode());
                response.setMessage(MessageCode.MSG_2010.getMessage());
            } else {
                if (existUserList.isEmpty() || existUserList.size() == 0)
                    throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "User data not Found !!!");
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
    }


    @Override
    public CommonListResponseBody<Object> lockApprovalUnAuthUser(LockUnlockUserRequest request, Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            List<User> userList = null;
            CommonListResponseBody response = null;
            params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
            if (request.getOidList().size() > 0) {
                userList = unauthUserPersistencePort.updateLockStatusUnAuthUserForApprover(request.getLoginId(), request.getOidList(), params);
                response = CommonListResponseBody.builder().data(Arrays.asList(userList.toArray())).build();
                response.setStatus(true);
                response.setCount(userList.size());
                response.setCode(ResponseCode.CREATED.getValue());
                response.setMessageCode(MessageCode.MSG_2010.getCode());
                response.setMessage(MessageCode.MSG_2010.getMessage());

            } else {
                if (request.getOidList().isEmpty() || request.getOidList().size() == 0)
                    throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "User data not Found !!!");
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
    }

    @Override
    public CommonListResponseBody<Object> unlockApprovalUnAuthUser(LockUnlockUserRequest request, Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            List<User> userList = null;
            CommonListResponseBody response = null;
            params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
//        List<User> existBranchList = unauthUserPersistencePort.findUnlockBranchListByOids(request.getOidList(), params, request.getLoginId());
            if (request.getOidList().size() > 0) {
                userList = unauthUserPersistencePort.updateUnlockStatusUnAuthUserForApprover(request.getLoginId(), request.getOidList(), params);
                response = CommonListResponseBody.builder().data(Arrays.asList(userList.toArray())).build();
                response.setStatus(true);
                response.setCount(userList.size());
                response.setCode(ResponseCode.CREATED.getValue());
                response.setMessageCode(MessageCode.MSG_2010.getCode());
                response.setMessage(MessageCode.MSG_2010.getMessage());
            } else {
                if (request.getOidList().isEmpty() || request.getOidList().size() == 0)
                    throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "User data not Found !!!");
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
    }

    @Override
    public CommonListResponseBody<Object> findAllPendingApprovalUnAuthUser(Map<String, String> params) throws ExceptionHandlerUtil {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
        return null;
    }

    @Override
    public CommonObjectResponseBody approvalUnAuthUser(ApprovalUserRequest request, Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
            User user = unauthUserPersistencePort.approvalUser(request, params);
            if (user == null)
                throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not saved");
            CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(user).build();
            response.setStatus(true);
            response.setCode(ResponseCode.CREATED.getValue());
            response.setMessageCode(MessageCode.MSG_2005.getCode());
            response.setMessage(MessageCode.MSG_2005.getMessage());
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
    }


    private User mapRequestToDomain(UserSaveRequest userSaveRequest, Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            User existUser;
            if (userSaveRequest.getOid() != null) {
                existUser = unauthUserPersistencePort.findByOid(userSaveRequest.getOid(), params);
                userSaveRequest.setCreatedBy(existUser.getCreatedBy());
                userSaveRequest.setCreatedOn(existUser.getCreatedOn());
                userSaveRequest.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
                userSaveRequest.setUpdatedBy(userSaveRequest.getUpdatedBy());
            } else {
                userSaveRequest.setCreatedBy(userSaveRequest.getCreatedBy());
                userSaveRequest.setCreatedOn(userSaveRequest.getCreatedOn() == null ? Timestamp.valueOf(LocalDateTime.now()) : userSaveRequest.getCreatedOn());
            }
            User user = modelMapper.map(userSaveRequest, User.class);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
        }
    }

}
