package com.osprey.bkob.controller;


import com.osprey.bkob.controller.common.AbstractBaseRestController;
import com.osprey.bkob.domain.entities.User;
import com.osprey.bkob.service.UserService;
import com.osprey.bkob.service.common.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.osprey.bkob.controller.AdminRestController.NAME_RESOURCE;

@RestController
@RequestMapping("/admin/" + AdminRestController.ROOT_PATH)
@Api(description = "/" + NAME_RESOURCE)    // показывает свагер название ресурса
public class AdminRestController extends AbstractBaseRestController<User> {
    private final UserService userService;
    public static final String ROOT_PATH = "user";
    public static final String NAME_RESOURCE = "name_resurses";


    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected BaseService<User> getService() {
        return userService;
    }

//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
//            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
//            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
//    })
//    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/bkob.app-v1.0+json")
//    @Override
//    public ResponseEntity<User> getById(Long id) {
//        return super.getById(id);
//    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })
    @RequestMapping(path = "/byusername/{name}", method = RequestMethod.GET, produces = "application/bkob.app-v1.0+json")

    public ResponseEntity<User> getByName(@PathVariable("name") String name) {
        return userService.getByName(name);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })
    @RequestMapping(path = "/allusers", method = RequestMethod.GET, produces = "application/bkob.app-v1.0+json")
    @Override
    public ResponseEntity<Iterable<User>>getAll() {
        return super.getAll();
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET, produces = "application/bkob.app-v1.0+json")

    public ResponseEntity<User> deleteuser(@PathVariable("id")Long id) {
        try{
            super.delete(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })
    @RequestMapping(path = "/users", method = RequestMethod.PUT, produces = "application/bkob.app-v1.0+json")
    @Override
    public ResponseEntity<User> update(User user) {
      return   super.update(user);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })
    @RequestMapping(path = "/ban/{id}", method = RequestMethod.GET, produces = "application/bkob.app-v1.0+json")

    public ResponseEntity<User> setBan(@PathVariable Long id) {
        try{
            userService.setBan(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })
    @RequestMapping(path = "/unban/{id}", method = RequestMethod.GET, produces = "application/bkob.app-v1.0+json")

    public ResponseEntity<User> unBan(@PathVariable Long id) {
        try{
            userService.unBan(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
