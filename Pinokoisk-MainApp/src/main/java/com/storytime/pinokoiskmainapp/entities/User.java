//package com.storytime.pinokoiskmainapp.entities;
//
//
//import com.storytime.pinokoiskmainapp.repositories.UserRepository;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Optional;
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="users")
//public class User implements UserRepository {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(unique = true)
//    @NotNull
//    @Size(max = 20, message = "Слишком длинный юзернейм")
//    private String userName;
//
//    @NotNull
//    @Size(max=20, message = "Слишком длинное название")
//    private String role;
//
//    @Override
//    public <S extends User> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<User> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public Iterable<User> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<User> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(User entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends User> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    //TODO:: Аватарка ???, заполнить имплементы
//}
