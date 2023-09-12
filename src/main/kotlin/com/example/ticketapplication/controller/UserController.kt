package com.example.ticketapplication.controller

import com.example.ticketapplication.entity.Login
import com.example.ticketapplication.entity.User
import com.example.ticketapplication.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/user")
class UserController(
    @Autowired
    val userRepository: UserRepository

) {
    @PostMapping("/add")
    fun addUser(@RequestBody user : User) : Mono<User> {
        return  userRepository.save(user)

    }
    @GetMapping("/")
    fun getAllUsers(): Flux<User>{
        return userRepository.findAll()
    }
    @PostMapping("/login")
    fun getlogin(@RequestBody login: Login): Mono<String> {
        val email = login.email;
        val pswd = login.password;
        return userRepository.findUserByEmailAndPassword(email, pswd)
            ?.flatMap { user ->
                if (user != null) {
                    Mono.just("success")
                } else {
                    Mono.just("failure")
                }
            } ?: Mono.just("failure")
    }
}
