package com.iit.mp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BoardAttachDto {
	private Number pstgNo,pstgImgAtchNo;
}
