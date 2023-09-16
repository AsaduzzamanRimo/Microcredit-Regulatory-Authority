package com.doer.mraims.user.adapter.in.web;

import com.doer.mraims.core.util.Api;
import com.doer.mraims.user.application.port.in.UserFeatureUseCase;
import com.doer.mraims.user.application.port.in.dto.request.UserSaveRequest;
import com.doer.mraims.core.util.response.CommonListResponseBody;
import com.doer.mraims.core.util.response.CommonObjectResponseBody;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = Api.SERVER_BASE)
@RestController
@RequestMapping(Api.API_BASE + Api.USER_BASE_PATH)
public class UserController {

    private final UserFeatureUseCase userFeatureUseCase;

    @GetMapping(path = "/list")
    public CommonListResponseBody getUserList(@RequestParam Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            CommonListResponseBody response = userFeatureUseCase.findAllUser(params);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping(path = "/get-userinfo-by-login-id")
    public CommonObjectResponseBody getUserInfoByLoginId(@RequestParam Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            CommonObjectResponseBody response = userFeatureUseCase.findUserInfoByLoginId(params);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping(path = "/{oid}")
    public CommonObjectResponseBody getUserByOid(@PathVariable String oid, @RequestParam Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            CommonObjectResponseBody response = userFeatureUseCase.findUserByOid(oid, params);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping(path = "/save")
    public CommonObjectResponseBody saveUser(@Valid @RequestBody UserSaveRequest request, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for save user : {}", request);
            CommonObjectResponseBody response = userFeatureUseCase.saveUser(request, params);
            log.info("Save response sent for user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(path = "/update/{oid}")
    public CommonObjectResponseBody updateUser(@Valid @RequestBody UserSaveRequest request, @PathVariable String oid, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for user update: {}", request);
            CommonObjectResponseBody response = userFeatureUseCase.updateUser(request, oid, params);
            log.info("Update response sent for user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
