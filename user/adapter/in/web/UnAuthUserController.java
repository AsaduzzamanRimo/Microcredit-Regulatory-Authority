package com.doer.mraims.user.adapter.in.web;

import com.doer.mraims.user.application.port.in.UnAuthBranchFeatureUseCase;
import com.doer.mraims.user.application.port.in.dto.request.ApprovalUserRequest;
import com.doer.mraims.user.application.port.in.dto.request.UserSaveRequest;
import com.doer.mraims.user.application.port.in.dto.request.LockUnlockUserRequest;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import com.doer.mraims.core.util.response.CommonListResponseBody;
import com.doer.mraims.core.util.response.CommonObjectResponseBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

import static com.doer.mraims.core.util.Api.*;

@CrossOrigin(origins = SERVER_BASE)
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(API_BASE + UNAUTH_USER_BASE_PATH)
public class UnAuthUserController {

    private final UnAuthBranchFeatureUseCase unauthUserFeatureUseCase;

    @PostMapping(path = "/save")
    public CommonObjectResponseBody saveUnAuthUser(@Valid @RequestBody UserSaveRequest userSaveRequest, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for save UnAuth user: {}", userSaveRequest);
            CommonObjectResponseBody response = unauthUserFeatureUseCase.saveUnAuthUser(userSaveRequest, params);
            log.info("Save response sent for user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping(path = "/list")
    public CommonListResponseBody getUnAuthUserList(@RequestParam Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            CommonListResponseBody response = unauthUserFeatureUseCase.findAllUnAuthUser(params);
            log.info("List response sent for user: {}", response);

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
            CommonObjectResponseBody response = unauthUserFeatureUseCase.findUnAuthUserByOid(oid, params);
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
            CommonObjectResponseBody response = unauthUserFeatureUseCase.updateUnAuthUser(request, oid, params);
            log.info("Update response sent for user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(path = "/editor-lock")
//    @Transactional
    public CommonListResponseBody lockNewUnAuthUser(@Valid @RequestBody LockUnlockUserRequest lockUnlockUserRequest, String loginId, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for Lock & Unlock UnAuth user update: {}", lockUnlockUserRequest);
            CommonListResponseBody response = unauthUserFeatureUseCase.lockUnAuthUser(lockUnlockUserRequest, params);
            log.info("Update response sent for Lock & Unlock UnAuth user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(path = "/editor-unlock")
//    @Transactional
    public CommonListResponseBody unlockNewUnAuthUser(@Valid @RequestBody LockUnlockUserRequest unlockBranchRequest, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for Lock & Unlock UnAuth user update: {}", unlockBranchRequest);
            CommonListResponseBody response = unauthUserFeatureUseCase.unlockUnAuthUser(unlockBranchRequest, params);
            log.info("Update response sent for Lock & Unlock UnAuth user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(path = "/approver-lock")
    public CommonListResponseBody lockApprovalUnAuthUser(@Valid @RequestBody LockUnlockUserRequest lockUnlockUserRequest, String loginId, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for Lock & Unlock UnAuth user update: {}", lockUnlockUserRequest);
            CommonListResponseBody response = unauthUserFeatureUseCase.lockApprovalUnAuthUser(lockUnlockUserRequest, params);
            log.info("Update response sent for Lock & Unlock UnAuth user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(path = "/approver-unlock")
    public CommonListResponseBody unlockApprovalUnAuthUser(@Valid @RequestBody LockUnlockUserRequest unlockBranchRequest, @RequestParam Map<String, String> params) {
        try {
            log.info("Request got for Lock & Unlock UnAuth user update: {}", unlockBranchRequest);
            CommonListResponseBody response = unauthUserFeatureUseCase.unlockApprovalUnAuthUser(unlockBranchRequest, params);
            log.info("Update response sent for Lock & Unlock UnAuth user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping(path = "/approval/pending-list")
    public CommonListResponseBody getPendingApprovalList(@RequestParam Map<String, String> params) throws ExceptionHandlerUtil {
        try {
            CommonListResponseBody response = unauthUserFeatureUseCase.findAllUnAuthUser(params);
            log.info("List response sent for pending user list for approval: {}", response);

            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping(path = "/approval")
    public CommonObjectResponseBody approveUnAuthUser(@Valid @RequestBody ApprovalUserRequest request, @RequestParam Map<String, String> params) {
        try {
            System.out.println(request);
            log.info("Request got for Approve UnAuth user: {}", request);
            CommonObjectResponseBody response = unauthUserFeatureUseCase.approvalUnAuthUser(request, params);
            log.info("Approve response sent for user: {}", response);
            return response;
        } catch (ExceptionHandlerUtil ex) {
            throw new ResponseStatusException(ex.code, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
