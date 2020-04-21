package site.itwill10.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//ÀÔ·Â°ªÀÌ ÀúÀåµÇ´Â ÇÊµå¿¡ À¯È¿¼º °Ë»ç °ü·Ã ¾î³ëÅ×ÀÌ¼ÇÀ» »ç¿ëÇÏ¿© Ã³¸®
public class Hewon {
	//@NotEmpty : ÀÔ·Â°ª Á¸Àç¸¦ °Ë»çÇÏ´Â ¾î³ëÅ×ÀÌ¼Ç
	// => ¿¡·¯ ¹ß»ı½Ã ¾î³ëÅ×ÀÌ¼ÇÀÌ Á¦°øÇÏ´Â ±âº» ¸Ş¼¼Áö Àü´Ş
	// => message ¼Ó¼ºÀ» ÀÌ¿ëÇÏ¿© Àü´Ş ¸Ş¼¼Áö ¼³Á¤ °¡´É
	@NotEmpty(message = "¾ÆÀÌµğ¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	//@Size : ÀÔ·Â°ª ±æÀÌ¸¦ °Ë»çÇÏ´Â ¾î³ëÅ×ÀÌ¼Ç
	// => min ¼Ó¼ºÀ¸·Î ÃÖ¼Ò ±æÀÌ, max ¼Ó¼ºÀ¸·Î ÃÖ´ë ±æÀÌ ¼³Á¤ °¡´É
	//@Size(min = 6, max = 20, message = "¾ÆÀÌµğ´Â ÃÖ¼Ò 6ÀÚ ÀÌ»ó ÃÖ´ë 20ÀÚ ÀÌÇÏ·Î¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.")
	//@Pattern : ÀÔ·Â°ª ±æÀÌ¸¦ °Ë»çÇÏ´Â ¾î³ëÅ×ÀÌ¼Ç
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$", message = "¾ÆÀÌµğ¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String id;
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$", message = "ºñ¹Ğ¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String passwd;
	@Pattern(regexp = "^[°¡-ÆR]{2,10}$", message = "ÀÌ¸§À» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String name;
	@NotEmpty(message = "ÀÌ¸ŞÀÏÀ» ¹İµå½Ã ¼±ÅÃÇØ ÁÖ¼¼¿ä.")
	//@Email : ÀÌ¸ŞÀÏ ÀÔ·Â°ªÀ» °Ë»çÇÏ´Â ¾î³ëÅ×ÀÌ¼Ç
	@Email(message = "ÀÌ¸ŞÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String email;
	@NotEmpty(message = "¼ºº°À» ¹İµå½Ã ¼±ÅÃÇØ ÁÖ¼¼¿ä.")
	private String gender;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
