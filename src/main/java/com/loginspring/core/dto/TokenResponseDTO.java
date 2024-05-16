package com.loginspring.core.dto;

import lombok.Builder;

@Builder
public record TokenResponseDTO(String token, String refreshToken) {

}
