package com.doer.mraims.security.application.service;

import com.doer.mraims.core.util.IdGenerator;
import com.doer.mraims.core.util.MessageCode;
import com.doer.mraims.core.util.ResponseCode;
import com.doer.mraims.security.adapter.out.persistance.database.repository.LoginRepository;
import com.doer.mraims.security.application.port.in.LoginFeatureUseCase;
import com.doer.mraims.security.application.port.in.dto.request.LoginRequest;
import com.doer.mraims.security.application.port.out.LoginPersistencePort;
import com.doer.mraims.security.domain.Login;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import com.doer.mraims.core.util.repository.UtilRepository;
import com.doer.mraims.core.util.response.CommonObjectResponseBody;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import static com.doer.mraims.core.util.Constant.ACTIVE;

@RequiredArgsConstructor

@Service
public class LoginService implements LoginFeatureUseCase {

    private final ModelMapper modelMapper;
    private final IdGenerator idGenerator;
    private final UtilRepository utilRepository;
    private final LoginPersistencePort loginPersistencePort;
    private final LoginRepository loginRepository;

    @Override
    public CommonObjectResponseBody userLogin(Map<String, String> params) throws ExceptionHandlerUtil {
        Login login = new Login();
        int countLoginId = loginRepository.countLoginId(params);
        if(countLoginId == 1){
            login = loginPersistencePort.userLogin(params);
            if(login.getPassword().equals(params.get("password"))){
                CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(login).build();
                response.setStatus(true);
                response.setCode(ResponseCode.OK.getValue());
                response.setMessageCode(MessageCode.MSG_2000.getCode());
                response.setMessage(MessageCode.MSG_2000.getMessage());
                return response;
            } else {
                login.setPassword(params.get("password"));
                CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(login).build();
                response.setStatus(false);
                response.setCode(ResponseCode.UNAUTHORIZED.getValue());
                response.setMessageCode(MessageCode.MSG_2011.getCode());
                response.setMessage(MessageCode.MSG_2011.getMessage());
                return response;
            }
        } else {
            login.setLoginId(params.get("loginId"));
            login.setPassword(params.get("password"));
            CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(login).build();
            response.setStatus(false);
            response.setCode(ResponseCode.NOT_FOUND.getValue());
            response.setMessageCode(MessageCode.MSG_2010.getCode());
            response.setMessage(MessageCode.MSG_2010.getMessage());
            return response;
        }
    }

    @Override
    public CommonObjectResponseBody checkLoginId(Map<String, String> params) throws ExceptionHandlerUtil {
        Login login = new Login();
        int countLoginId = loginRepository.countLoginId(params);
        if(countLoginId == 1){
            login = loginPersistencePort.findLoginId(params);
            CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(login).build();
            response.setStatus(true);
            response.setCode(ResponseCode.OK.getValue());
            response.setMessageCode(MessageCode.MSG_2000.getCode());
            response.setMessage(MessageCode.MSG_2000.getMessage());
            return response;
        } else {
            login.setLoginId(params.get("loginId"));
            CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(login).build();
            response.setStatus(false);
            response.setCode(ResponseCode.NOT_FOUND.getValue());
            response.setMessageCode(MessageCode.MSG_2010.getCode());
            response.setMessage(MessageCode.MSG_2010.getMessage());
            return response;
        }
    }

    @Override
    public CommonObjectResponseBody saveLogin(LoginRequest saveRequest, Map<String, String> params) throws ExceptionHandlerUtil {
        params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
        int count = loginPersistencePort.countBranch(params.get("schemaName"));
        saveRequest.setStatus(ACTIVE);
        saveRequest.setBranchId(idGenerator.generateBranchId(count));
        saveRequest.setComBranchId(idGenerator.generateComBranchId(count));
        Login requestedBranch = mapRequestToDomain(saveRequest, params);
        Login branch = loginPersistencePort.save(requestedBranch, params);
        if (branch == null) throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "Login data not saved");
        CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(branch).build();
        response.setStatus(true);
        response.setCode(200);
        response.setMessageCode("MSG_2005");
        response.setMessage("Successfully Submitted Data Saved");
        return response;
    }

    @Override
    public CommonObjectResponseBody updateLogin(LoginRequest updateRequest, String oid, Map<String, String> params) throws ExceptionHandlerUtil {
        Login login = null;
        params.put("schemaName", utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid")));
        Login existBranch = loginPersistencePort.findByOid(oid, params);
        if (existBranch != null) {
            updateRequest.setOid(oid);
            login = loginPersistencePort.updateState(mapRequestToDomain(updateRequest, params), params);
        }
        if (login == null) throw new ExceptionHandlerUtil(HttpStatus.INTERNAL_SERVER_ERROR, "Login data not updated");
        CommonObjectResponseBody response = CommonObjectResponseBody.builder().data(login).build();
        response.setStatus(true);
        response.setCode(200);
        response.setMessageCode("MSG_2007");
        response.setMessage("Successfully Submitted Data Updated");
        return response;
    }

    private Login mapRequestToDomain(LoginRequest loginRequest, Map<String, String> params) throws ExceptionHandlerUtil {
        Login existBranch;
        if (loginRequest.getOid() != null) {
            existBranch = loginPersistencePort.findByOid(loginRequest.getOid(),  params);
            loginRequest.setCreatedBy(existBranch.getCreatedBy());
            loginRequest.setCreatedOn(existBranch.getCreatedOn());
            loginRequest.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
            loginRequest.setUpdatedBy(loginRequest.getUpdatedBy());
        } else {
            loginRequest.setCreatedBy(loginRequest.getCreatedBy());
            loginRequest.setCreatedOn(loginRequest.getCreatedOn() == null ? Timestamp.valueOf(LocalDateTime.now()) : loginRequest.getCreatedOn());
        }
        Login branch = modelMapper.map(loginRequest, Login.class);
        return branch;
    }

}
