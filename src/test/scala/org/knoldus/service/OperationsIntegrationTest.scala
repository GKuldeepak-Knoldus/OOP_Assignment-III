package org.knoldus.service

import org.knoldus.models.{User, UserType}
import org.knoldus.repo.UserRepository
import org.scalatest.flatspec.AsyncFlatSpec

class OperationsIntegrationTest extends AsyncFlatSpec{
  val userRepository = new UserRepository
  val operations = new UserOperations(userRepository)
  val userOne = new User(1234 , "Kuldeepak Gupta" , UserType.ADMIN)
  val userTwo = new User(1235 , "" , UserType.CUSTOMER)

  "addUser " should "Add user in DataBase " in {
    val result = operations.addUser(userOne)
    assert(result)
  }

   it should "not Add user in Database " in {
     val result = operations.addUser(userTwo)
     assert(!result)
   }

  "getUserList " should "Display a list" in {
    operations.addUser(userOne)
    val result = operations.getUserList()
    assert(result==List(User(1234 , "Kuldeepak Gupta" , UserType.ADMIN)))
  }

  "removeUser " should "remove a user " in {
    operations.addUser(userOne)
    val result = operations.removeUser(1234)
    assert(result)
  }

  it should " not remove a user " in {
    operations.addUser(userOne)
    val result = operations.removeUser(1235)
    assert(!result)
  }

  "changeUserName " should "change the name of User " in {
    operations.addUser(userOne)
    val result = operations.changeUserName(1234 , "Prabhat")
    assert(result)
  }

  it should "not update the username " in {
    operations.addUser(userOne)
    val result = operations.changeUserName(1245 ," Prabhat")
    assert(!result)
  }

  "getUser " should "return a User " in {
    operations.addUser(userOne)
    val result = operations.getUser(1234)
    assert(result=="Prabhat")
  }

  it should "not return a User" in {
    operations.addUser(userOne)
    val result = operations.getUser(1245)
    assert(result==null)
  }

  "getUserIdList" should "return a list of ID " in {
    operations.addUser(userOne)
    val result = operations.getUserIdList()
    assert(result==List(1234))
  }
}
