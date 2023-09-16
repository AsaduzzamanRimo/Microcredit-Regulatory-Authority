package com.doer.mraims.security.adapter.in.web;

import com.doer.mraims.core.util.Api;
import com.doer.mraims.security.application.port.in.LoginFeatureUseCase;
import com.doer.mraims.security.application.port.in.dto.request.LoginRequest;
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
@RequestMapping(Api.API_BASE + Api.LOGIN_BASE_PATH)
public class LoginController {

    private final LoginFeatureUseCase loginFeatureUseCase;

    @GetMapping(path = "/user-login")
    public CommonObjectResponseBody getUserLogin(@RequestParam Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            CommonObjectResponseBody response = loginFeatureUseCase.userLogin(params);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping(path = "/check-loginid")
    public CommonObjectResponseBody checkLoginId(@RequestParam Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            CommonObjectResponseBody response = loginFeatureUseCase.checkLoginId(params);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping(path = "/save")
    public CommonObjectResponseBody saveLogin(@Valid @RequestBody LoginRequest request, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for save login information : {}", request);
            CommonObjectResponseBody response = loginFeatureUseCase.saveLogin(request, params);
            log.info("Save response sent for branch: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(path = "/update/{oid}")
    public CommonObjectResponseBody updateLogin(@Valid @RequestBody LoginRequest request, @PathVariable String oid, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for login update: {}", request);
            CommonObjectResponseBody response = loginFeatureUseCase.updateLogin(request, oid, params);
            log.info("Update response sent for login: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
