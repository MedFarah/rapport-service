package org.tn.zitouna.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor
public class Entete {

	private int NDECL;
	private int KTENR;
	private int KTE;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date DDECL;
	private int KMDECL;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date DEMISS;
}
