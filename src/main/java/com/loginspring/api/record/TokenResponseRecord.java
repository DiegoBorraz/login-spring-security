package com.loginspring.api.record;

import lombok.Builder;

@Builder
public record TokenResponseRecord(String token, String refreshToken) {

}
