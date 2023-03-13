package com.iit.mp.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BoardDto {
	private String pstgWrtId, pstgWrtTitle, pstgWrtCn;
	private Number pstgNo, pstgInqCnt, pstgGroup, pstgDepth, pstgParent;
	private Date pstgWrtYmd, pstgMdfcnYmd;
}
