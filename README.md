## Vad vi gjort från tididigare iteration:



### Skapat Role entity
Role.java

### Lagt till roles-fält i User entity
User.java

### skapat Role repopository
RoleRepository.java

### uppdaterat securityConfig
SecurityConfiguration.java
- aktivera @preAuthorize() med @EnableMethodSecurity()

### uppdaterat UserDetailService
CustomUserDetailsService.java
- lägg till roller i loadUserByUsername()

### skapat commandlineRunner för initiering
DatabaseInitializer.java


### uppdaterat userService
UserService.java
- lägg till RoleRepository
- uppdatera registerUser()


### uppdatera endpoints med @preAuthorize()
AdminController.java 
- helloAdmin()

UserController.java
- sayHello()

