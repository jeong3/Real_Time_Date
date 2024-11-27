package springBootMVCAlbum.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class LoginCommand {
	String userId;
	String userPw;
	boolean idStore;
	boolean autoLogin;
}
