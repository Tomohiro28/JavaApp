package com.example.demo.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;
//JpaRepositoryにはJQPL（SQL文）の簡易クエリが搭載
//クラスを継承する事によりSQL文を書く手間が省ける
@Repository
//DBアクセスのための入口
public interface UserRepository extends JpaRepository<User,Integer>{

}
