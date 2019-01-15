package com.osprey.bkob.domain.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

	JUNIOR,MIDDLE,SENIOR,TEAMLEAD, ADMIN, MANAGER, GUEST, MODERATOR;

	@Override
	public String getAuthority() {
		return name();
	}

}