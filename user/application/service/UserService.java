package com.doer.mraims.user.application.service;

import com.doer.mraims.core.util.ResponseCode;
import com.doer.mraims.core.util.MessageCode;
import com.doer.mraims.user.application.port.in.UserFeatureUseCase;
import com.doer.mraims.user.application.port.in.dto.request.UserSaveRequest;
import com.doer.mraims.user.application.port.out.UserPersistencePort;
import com.doer.mraims.user.domain.User;
import com.doer.mraims.core.util.IdGenerator;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import com.doer.mraims.core.util.repository.UtilRepository;
import com.doer.mraims.core.util.response.CommonListResponseBody;
import com.doer.mraims.core.util.response.CommonObjectResponseBody;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.doer.mraims.core.util.Constant.ACTIVE;


@RequiredArgsConstructor

@Service
public class UserService implements UserFeatureUseCase {


    private final ModelMapper modelMapper;

    private final IdGenerator idGenerator;

    private final UtilRepository utilRepository;

    private final UserPersistencePort userPersistencePort;

    @Override
    public CommonListResponseBody<Object> findAllUser(Map<String, String> params) throws ExceptionHandlerUtil {
       try {
           List<User> userList = userPersistencePort.findAllUser(params);
           int existingUserCount = userPersistencePort.countTotalUserForPagination(params);
           CommonListResponseBody<Object> response;
           if (userList.isEmpty()) {
               response = CommonListResponseBody.builder().data(new ArrayList<>()).build();
               //            throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
           }else {
               response = CommonListResponseBody.builder().data(Arrays.asList(userList.toArray())).build();
               response.setStatus(true);
               response.setCode(ResponseCode.OK.getValue());
               response.setMessageCode(MessageCode.MSG_2000.getCode());
               response.setMessage(MessageCode.MSG_2000.getMessage());
               response.setCount(existingUserCount);
           }
           return response;
       }catch(Exception ex){
           ex.printStackTrace();
           throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found");
       }
    }

    @Override
    public CommonObjectResponseBody findUserInfoByLoginId(Map<String, String> params) throws ExceptionHandlerUtil {
        User user  = userPersistencePort.findUserInfoByLoginId(params);
        if (user == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "User Data not found by this branch ID: " + params.get("loginId"));
        CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(user).build();
        response.setStatus(true);
        response.setCode(ResponseCode.OK.getValue());
        response.setMessageCode(MessageCode.MSG_2002.getCode());
        response.setMessage(MessageCode.MSG_2002.getMessage());
        return response;
    }

    @Override
    public CommonObjectResponseBody findUserByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil {
        User branch = userPersistencePort.findUserByOid(oid, params);
        if (branch == null) throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not found by this oid: " + oid);
        CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(branch).build();
        response.setStatus(true);
        response.setCode(ResponseCode.OK.getValue());
        response.setMessageCode(MessageCode.MSG_2003.getCode());
        response.setMessage(MessageCode.MSG_2003.getMessage());
        return response;
    }

    @Override
    public CommonObjectResponseBody saveUser(UserSaveRequest request, Map<String, String> params) throws ExceptionHandlerUtil {
        params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
        int count = userPersistencePort.countUser(params.get("schemaName"));
        request.setStatus(ACTIVE);
//        request.setBranchId(idGenerator.generateBranchId(count));
//        request.setComBranchId(idGenerator.generateComBranchId(count));
        User requestedBranch = mapRequestToDomain(request, params);
        User branch = userPersistencePort.saveUser(requestedBranch, params);
        if (branch == null) throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not saved");
        CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(branch).build();
        response.setStatus(true);
        response.setCode(ResponseCode.CREATED.getValue());
        response.setMessageCode(MessageCode.MSG_2005.getCode());
        response.setMessage(MessageCode.MSG_2005.getMessage());
        return response;
    }

    @Override
    public CommonObjectResponseBody updateUser(UserSaveRequest request, String oid, Map<String, String> params) throws ExceptionHandlerUtil {
        User branch = null;
        params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
        User existBranch = userPersistencePort.findUserByOid(oid, params);
        if (existBranch != null) {
            request.setOid(oid);
            branch = userPersistencePort.updateUser(mapRequestToDomain(request, params), params);
        }
        if (branch == null) throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "User data not updated");
        CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(branch).build();
        response.setStatus(true);
        response.setCode(ResponseCode.CREATED.getValue());
        response.setMessageCode(MessageCode.MSG_2007.getCode());
        response.setMessage(MessageCode.MSG_2007.getMessage());
        return response;
    }

    private User mapRequestToDomain(UserSaveRequest userSaveRequest, Map<String, String> params) throws ExceptionHandlerUtil {
        User existBranch;
        if (userSaveRequest.getOid() != null) {
            existBranch = userPersistencePort.findUserByOid(userSaveRequest.getOid(),  params);
            userSaveRequest.setCreatedBy(existBranch.getCreatedBy());
            userSaveRequest.setCreatedOn(existBranch.getCreatedOn());
            userSaveRequest.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
            userSaveRequest.setUpdatedBy(userSaveRequest.getUpdatedBy());
        } else {
            userSaveRequest.setCreatedBy(userSaveRequest.getCreatedBy());
            userSaveRequest.setCreatedOn(userSaveRequest.getCreatedOn() == null ? Timestamp.valueOf(LocalDateTime.now()) : userSaveRequest.getCreatedOn());
        }
        User branch = modelMapper.map(userSaveRequest, User.class);
        return branch;
    }

}
