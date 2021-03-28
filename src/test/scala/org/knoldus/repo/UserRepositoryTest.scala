package org.knoldus.repo

import org.knoldus.models.{User, UserType}
import org.scalatest.flatspec.AsyncFlatSpec

class UserRepositoryTest extends AsyncFlatSpec {

  val userRepository = new UserRepository

  "createUser " should "create a user " in {
    val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
    val result = userRepository.createUser(user)
    assert(result)
  }

  "A List " should "Displayed " in {
    val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
    userRepository.createUser(user)
    val result = userRepository.listUser()
    assert(result == List(User(1001,"Kuldeepak Gupta",UserType.ADMIN)))
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
   val result = userRepository.getUserNameById(1001)
   assert(result == "Kuldeepak Gupta")
 }

  "UserId List " should "Display " in {
    val user = User(1001, "Kuldeepak Gupta", UserType.ADMIN)
    userRepository.createUser(user)
    val result = userRepository.listUserId()
    assert(result == List(1001))
  }



}
