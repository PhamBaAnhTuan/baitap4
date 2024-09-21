package com.group2.baitap4;
import com.group2.baitap4.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer>
{
}
