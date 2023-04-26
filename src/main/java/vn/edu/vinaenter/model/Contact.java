package vn.edu.vinaenter.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	private int cid;
	@NotBlank
	private String fullname;
	@Email
	private String email;
	@NotBlank
	private String subject;
	@NotBlank
	private String content;
}
