package com.iit.mp.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class MemberDto {
	private String mbrId, mbrPw, mbrNm, mbrMblTelno, mbrHomeAddr, mbrHomeDaddr, mbrGrd;
	private Date mbrBrdt, mbrRegYmd;
}
