package org.knoldus.repo

import org.knoldus.models.{User, UserType}
import org.scalatest.flatspec.AsyncFlatSpec

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class UserRepositoryTest extends AsyncFlatSpec {

  val userRepository = new UserRepository
  val user = User(1001, "Kuldeepak Gupta","kuldeepak.gupta@knoldus.com" , "Kuldeepak@knoldus123" ,UserType.ADMIN)

  "createUser " should "create a user " in {
    val result = Await.result(userRepository.createUser(user) , 5 seconds)
    assert(result)
  }

  "listUser" should "Display the list " in {
    Await.result(userRepository.createUser(user) , 10 seconds)
    val result = Await.result(userRepository.listUser() , 10 seconds)
    assert(result == List(User(1001,"Kuldeepak Gupta","kuldeepak.gupta@knoldus.com","Kuldeepak@knoldus123",UserType.ADMIN)))
  }

  "updateUser " should "update " in {
    Await.result(userRepository.createUser(user) , 5 seconds)
    val result = Await.result(userRepository.updateUser(1001 , "Prabhat Kashyap") , 5 seconds)
    assert(result)
  }

  it should " not update " in {
    Await.result(userRepository.createUser(user), 5 seconds)
    val result = Await.result(userRepository.updateUser(1002 , "Prabhat Kashyap") ,  5 seconds )
    assert(!result)
  }

  "deleteUser " should "delete " in {
    Await.result(userRepository.createUser(user) , 5 seconds)
    val result = Await.result(userRepository.deleteUser(1001), 5 seconds)
    assert(result)
  }

 "getUserById " should " return a name " in {
   Await.result(userRepository.createUser(user) , 5 seconds)
   val result = Await.result(userRepository.getUserNameById(1001) , 5 seconds)
   assert(result == "Kuldeepak Gupta")
 }

  "listUserId " should "Display " in {
    Await.result(userRepository.createUser(user), 5 seconds)
    val result = Await.result(userRepository.listUserId() , 5 seconds )
    assert(result.nonEmpty)
  }
}
