package org.knoldus.service

import org.knoldus.models.{User, UserType}
import org.knoldus.repo.UserRepository
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class OperationsTest extends AsyncFlatSpec {

  val mockedUserRepository = mock[UserRepository]
  val operations = new Operations(mockedUserRepository)
  when (mockedUserRepository.getRepository()) thenReturn(collection.mutable.Map.empty[Int , User])

  "A user " should "be added in Database " in {
    when (mockedUserRepository.getRepository()) thenReturn(collection.mutable.Map.empty[Int , User])
    val userMain = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    when(mockedUserRepository.createUser(userMain)) thenReturn true
    val result = operations.addUser(userMain)
    assert(result)
  }

  "A user " should "not be added " in {
    val userMain = new User(1001 , "" , UserType.CUSTOMER)
    when(mockedUserRepository.createUser(userMain)) thenReturn false
    val result = operations.addUser(userMain)
    assert(!result)
  }

  /*"User List " should " Display " in {
    val userOne = User(1001 , "Kuldeepak Gupta" , UserType.ADMIN)
    when (mockedUserRepository.createUser(userOne)) thenReturn true
    when(mockedUserRepository.listUser()) thenReturn List[(Int, User)]
    val result = operations.getUserList[(Int , User)]("(1234,User(1234,Kuldeepak Gupta,ADMIN)), (2345,User(2345,Yash Gupta,CUSTOMER))")
  }*/

  /*"User " should "be removed " in {
    when (mockedUserRepository.getRepository()) thenReturn(collection.mutable.Map.empty[Int , User])
    val userOne = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    when(mockedUserRepository.createUser(userOne)) thenReturn true
    when(mockedUserRepository.deleteUser(1245)) thenReturn true
    val result = operations.removeUser(1245)
    assert(result)
  }*/

  "User " should "not be removed " in {
    val userMain = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    when(mockedUserRepository.createUser(userMain)) thenReturn true
    when(mockedUserRepository.deleteUser(1245)) thenReturn true
    val result = operations.removeUser(1246)
    assert(!result)
  }

  "User Name " should " not Change " in {
    val userOne = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    operations.addUser(userOne)
    when(mockedUserRepository.updateUser(1246 , "Kuldeepak Gupta")) thenReturn false
    val result = operations.changeUserName(1245 , "Kuldeepak Gupta")
    assert(!result)
  }




}
