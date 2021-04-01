package org.knoldus.service

import org.knoldus.models.{User, UserType}
import org.knoldus.repo.UserRepository
import org.scalatest.flatspec.AsyncFlatSpec
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class OperationsIntegrationTest extends AsyncFlatSpec{
  val userRepository = new UserRepository
  val operations = new UserOperations(userRepository)
  val userOne = new User(1234 , "Kuldeepak Gupta" ,"Gupta.kuldeepak@knoldus.com" , "Kuldeepak@123" ,  UserType.ADMIN)


  "addUser " should "Add user in DataBase " in {
    val result = Await.result(operations.addUser(userOne) , 5 seconds)
    assert(result)
  }

   it should "not Add user in Database " in {
     val userOne = new User(1234 , "" ,"Gupta.kuldeepak@knoldus.com" , "Kuldeepak@123" ,  UserType.ADMIN)
     val result = Await.result(operations.addUser(userOne) , 5 seconds)
     assert(!result)
   }


  "getUserList " should "Display a list" in {
    Await.result(operations.addUser(userOne) , 5 seconds)
    val result = Await.result(operations.getUserList() ,  5 seconds)
    assert(result.nonEmpty)
  }


  "removeUser " should "remove a user " in {
    Await.result(operations.addUser(userOne) , 5 seconds)
    val result = Await.result(operations.removeUser(1234) , 5 seconds )
    assert(result)
  }


  it should " not remove a user " in {
    Await.result(operations.addUser(userOne) , 5 seconds)
    val result = Await.result(operations.removeUser(1235) , 5 seconds)
    assert(!result)
  }

  "changeUserName " should "change the name of User " in {
    Await.result(operations.addUser(userOne) , 5 seconds)
    val result = Await.result(operations.changeUserName(1234 , "Prabhat") , 5 seconds)
    assert(result)
  }

  it should "not update the username " in {
    Await.result(operations.addUser(userOne) , 5 seconds)
    val result = Await.result(operations.changeUserName(1245 ," Prabhat") , 5 seconds)
    assert(!result)
  }

  "getUser " should "return a User " in {
    Await.result(operations.addUser(userOne) , 5 seconds)
    val result = Await.result(operations.getUser(1234) , 5 seconds)
    assert(result=="Prabhat")
  }

  "getUserIdList" should "return a list of ID " in {
    Await.result(operations.addUser(userOne) , 5 seconds)
    val result = Await.result(operations.getUserIdList() , 5 seconds)
    assert(result.nonEmpty)
  }

  "verifyEmail " should "return true " in {
    val result = operations.verifyEmail("Guptakuldeepak@knoldus.com")
    assert(result)
  }

  "verifyPassword " should "return true " in {
    val result = operations.verifyPassword("KG@12345Gupta")
    assert(result)
  }
}
