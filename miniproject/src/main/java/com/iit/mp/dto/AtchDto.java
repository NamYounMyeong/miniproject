package com.iit.mp.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AtchDto {
	private int atchNo, atchFileSz;
	private String atchExtnNm, atchFileNm;
	private Date atchStrgYmd;
}
