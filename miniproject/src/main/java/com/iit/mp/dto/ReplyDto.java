package com.iit.mp.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ReplyDto {
	private int cmntNo, cmntPstgNo;
	private String cmntWrtNm, cmntWrtCn;
	private Date cmntWrtYmd, cmntMdfcnYmd;
}
