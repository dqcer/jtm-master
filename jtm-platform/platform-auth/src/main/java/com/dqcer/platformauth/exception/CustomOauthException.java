package com.dqcer.platformauth.exception;

import com.dqcer.jtmcommon.base.vo.Result;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
class CustomOauthException extends OAuth2Exception {

    private final Result result;

    CustomOauthException(OAuth2Exception oAuth2Exception) {
        super(oAuth2Exception.getSummary(), oAuth2Exception);
        this.result = Result.businessMessage(AuthErrorType.valueOf(oAuth2Exception.getOAuth2ErrorCode().toUpperCase()) +  oAuth2Exception.toString());
    }
}
