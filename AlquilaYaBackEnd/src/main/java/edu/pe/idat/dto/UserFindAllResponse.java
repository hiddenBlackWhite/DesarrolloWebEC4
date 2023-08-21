package edu.pe.idat.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import edu.pe.idat.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFindAllResponse {
	
	@JsonProperty("users")
	private List<User> users;
	
}
