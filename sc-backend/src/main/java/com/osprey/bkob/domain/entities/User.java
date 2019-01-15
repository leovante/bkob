package com.osprey.bkob.domain.entities;

import com.osprey.bkob.domain.enums.Role;
import com.osprey.bkob.domain.enums.State;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity
@Table(name = "users_tbl",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "email", name = "email_unique")})
public class User extends BaseEntity {
// TODO  сделать отдельные ентити и связать их
	public static final boolean BUN_NULL = false;
	public static final int LENGTH = 100;

	//    @NotBlank(message = "errors.user.firstname.not-null")
	@Column(name = "fist_name",  length = LENGTH)
	private String firstName;

	@Column(name = "user_name",  length = LENGTH)
	private String userName;

	@Column(name = "skills",  length = LENGTH)
	private String skills;

	@Column(name = "phone", length = LENGTH)
	private String phone;

	@Column(name = "about_me",  length = 500)
	private String about_me;

	@Column(name = "city",  length = LENGTH)
	private String city;

	//  @NotBlank(message = "errors.user.password.not-null")

	@Column(name = "password",nullable = BUN_NULL, length = LENGTH)
	private String password;

	@Email(message = "errors.user.email.value.email_not_correct")
	@Column(name = "email", nullable = BUN_NULL, length = LENGTH, unique = true) //unique уникальное значение
	private String email;

	@Column(name = "active")
	private Boolean active;

	@Enumerated(EnumType.STRING)
	@Column(name = "state_enum")
	private State state;
	@Column(name = "active_code")
	private String activationCode;

	public void setState(State state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public State getState() {
		return state;
	}

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "user2roles_tbl",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			foreignKey = @ForeignKey(name = "users2roles_user_fk"),
			uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "roles_enum"}))
	@Enumerated(EnumType.STRING)
	@Column(name = "roles_enum", length = LENGTH_ENUM )
	private Set<Role> roles = new HashSet<>();

	public boolean isAdmin() {
		return roles.contains(Role.ADMIN);
	}
	public boolean isGuest() { return roles.contains(Role.GUEST);
	}

	private String lang1;
	@Column
	private String lang2;
	@Column
	private String lang3;
	@Column
	private String country;
	@Column
	private Short year;
	@Column
	private String month;
	@Column
	private Short day;


//	@Transient // анатаия которая не даёт создавать поле в базе
//	private Avatar avatar;


//
//	@Column(unique = true, nullable = true)
//	private String token;
//
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles = new HashSet<>();


//	@Temporal(TemporalType.TIMESTAMP) // применяется к полям или
//	// свойствам с типом java.del.Date и java.del.Calendar.
//	// Например, если в БД время сохраняется как sql.Date,
//	// то чтобы использовать дату из java.del.Date указываем эту аннотацию.
//	private Date birth;


}
