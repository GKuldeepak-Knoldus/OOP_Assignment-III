package org.knoldus.repo

import org.knoldus.models.{User, UserType}
import org.knoldus.repo.UserRepository
import org.mockito.MockitoSugar.{mock, verify, when}
import org.scalatest.flatspec.AsyncFlatSpec

import scala.collection.immutable.HashMap

class UserRepositoryTest extends AsyncFlatSpec {

  val userRepository = new UserRepository

  "A user " should "be created " in {
    val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
    val result = userRepository.createUser(user)
    assert(result)
  }

  "A List " should "Displayed " in {
    val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
    userRepository.createUser(user)
    val result = userRepository.listUser()
    assert(result == List((1001, User(1001,"Kuldeepak Gupta",UserType.ADMIN))))
  }

  "User Name " should "update " in {
    val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
    userRepository.createUser(user)
    val result = userRepository.updateUser(1001 , "Prabhat Kashyap")
    assert(result)
  }

  "User Name " should " not be updated " in {
    val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
    userRepository.createUser(user)
    val result = userRepository.updateUser(1002 , "Prabhat Kashyap")
    assert(!result)
  }

  "User " should "Deleted " in {
    val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
    userRepository.createUser(user)
    val result = userRepository.deleteUser(1001)
    assert(result)
  }

 "User with id " should " exist " in {
   val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
   userRepository.createUser(user)
   val result = userRepository.getUserNameByName(1001)
   assert(result == "Kuldeepak Gupta")
 }

 "User Data " should " be available " in {
   val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
   userRepository.createUser(user)
   val result = userRepository.getRepository()
   assert(result== HashMap(1001 -> User(1001,"Kuldeepak Gupta",UserType.ADMIN)))
 }



}
