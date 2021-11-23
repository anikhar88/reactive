package com.anxistars.userservice.service;

import com.anxistars.userservice.dto.UserDto;
import com.anxistars.userservice.repository.UserRepository;
import com.anxistars.userservice.util.EntityDtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Flux<UserDto> getAllUser(){
        return this.userRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> getUserById(final Integer id){
        return this.userRepository.findById(id)
                    .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> createUser(final Mono<UserDto> userDtoMono) {
        return userDtoMono.map(EntityDtoUtil::toEntity)
                    .flatMap(this.userRepository::save)
                    .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> updateUser(final Integer id, final Mono<UserDto> userDtoMono) {
       
       return this.userRepository.findById(id)
                .flatMap(
                        u -> userDtoMono
                        .map(EntityDtoUtil::toEntity)
                        .doOnNext(ut -> ut.setId(id)))
                .flatMap(this.userRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<Void> deleteUser(final Integer id) {

        return this.userRepository.deleteById(id);
    }

}
