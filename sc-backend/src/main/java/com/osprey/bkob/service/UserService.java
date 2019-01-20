package com.osprey.bkob.service;

import com.osprey.bkob.domain.entities.User;
import com.osprey.bkob.domain.enums.Role;
import com.osprey.bkob.domain.enums.State;
import com.osprey.bkob.domain.forms.UserRegistration;
import com.osprey.bkob.repository.BaseRepository;
import com.osprey.bkob.repository.UserRepository;
import com.osprey.bkob.service.common.AbstractBaseService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.logging.Level;


@Service
@Log
public class UserService extends AbstractBaseService<User> {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository repository;

	@Override
	protected BaseRepository<User, Long> getRepository() {
		return repository;
	}

	@Autowired
	private MailService mailService;

	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		this.passwordEncoder = passwordEncoder;
		this.repository = userRepository;
	}

	@Transactional
	public  boolean activateUser(String code) {
		try {
			User user = repository.findByActivationCode(code).get();
			user.setActivationCode(null); // Означает что пользователь подтвердил свой почтовый ящик
			user.getRoles().add(Role.JUNIOR);
			user.setActive(true);
			repository.save(user);
		} catch (Exception ex) {
			log.log(Level.SEVERE, "Unable to save user", ex);
			return false;
		}
		return true;

	}
	public ResponseEntity<User> getByCountry(User user, String city, String name, String phone, String skills , String about_me){
		try {
//			User user = repository.findByCountry(city).get();
			user.setCity(city);
			user.setFirstName(name);
			user.setPhone(passwordEncoder.encode(phone));
			user.setSkills(skills);
			user.setAbout_me(about_me);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e){
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	public  String generateCode() {
		String UUID = java.util.UUID.randomUUID().toString();
		return  UUID;

	}

	public ResponseEntity<User> getByName(String name) {
		Optional<User> result = repository.findByuserName(name);
		if (StringUtils.isEmpty(name)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else
			return result.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public User getByEmail(String email) {
		Optional<User> result = repository.findByEmail(email);
		return result.get();
	}



		public void setBan (Long id){

			User user = getRepository().findById(id).get();

			user.setState(State.BANNED);
			repository.save(user);


		}
		public void unBan (Long id){
			User user = getRepository().findById(id).get();

			user.setState(State.ACTIVE);

			repository.save(user);
		}

		public void sendMessage (UserRegistration user){

			if (!StringUtils.isEmpty(user.getEmail())) {   //В SpringUtils есть метод isEmpty который проверяет что строчки не равны null и непустые
				String message = String.format(
						"Hello, %s! \n" +
								"Welcome to bkob. Please activate your account: http://localhost:8080/activate/%s",
						user.getEmail(),
						user.getActivationCode()
				);

				mailService.send(user.getEmail(), "Activation Code", message);
			}
		}




}
//	public boolean hasSuchAccount(String email, String username){
//		return repository.findByEmail(email) && repository.findByuserName()
//	}

//	@Autowired
//	private UserRepository userRepo;
//	@Autowired
//	private PasswordEncoder passwordencoder;
//
//	private static List<User> userList;
//
//	public TokenDto login(UserDto userDto) {
//		User findUser = userRepo.findUserByEmail(userDto.getEmail());
//
//		if (findUser != null) {
//
//			if (passwordencoder.matches(userDto.getPassword(), findUser.getPassword())) {
//				findUser.setToken(TokenGenerator.generateToken(findUser.getEmail()));
//				userRepo.save(findUser);
//				return new TokenDto(findUser.getToken(), findUser.getEmail());
//			}
//			return null;
//		}
//		return null;
//	}
//
//
//
//	public boolean authentication(String token) {
//
//		User user = userRepo.findByToken(token);
//
//		return user != null && token.equals(user.getToken());
//	}
//
//	public User findByuserName(String name) {
//		for(User user : userList){
//			if(user.getFirstName().equalsIgnoreCase(name)){
//				return user;
//			}
//		}
//		return null;
//	}
//
//	public List<User> findAllUsers() {
//		return userRepo.findAll();
//	}
//
//	public Optional<User> findById(Long id) {
//		return userRepo.findById(id);
//	}
//
//	public User signUp(UserDto userDto) {
//
//		if (userRepo.findByEmail(userDto.getEmail()).isEmpty() &&
//				userDto.getPassword().equals(userDto.getMatchingPassword())) {
//
//			userDto.setPassword(passwordencoder.encode(userDto.getPassword()));
//
//			return userRepo.save(new User(userDto));
//		}
//		System.out.println("Регистрирую");
//		return null;

