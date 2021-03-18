package org.knoldus.service

import org.knoldus.models.{User, UserType}
import org.knoldus.repo.UserRepository
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class OperationsUnitTest extends AsyncFlatSpec {

  val mockedUserRepository = mock[UserRepository]
  val operations = new UserOperations(mockedUserRepository)


  "A user " should "be added in Database " in {
    when(mockedUserRepository.listUserId()) thenReturn List.empty[Int]
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

  "User List " should " Display " in {
    val userOne = User(1001 , "Kuldeepak Gupta" , UserType.ADMIN)
    mockedUserRepository.createUser(userOne)
    when(mockedUserRepository.listUser()).thenReturn(List[User] (User(1001 , "Kuldeepak Gupta" , UserType.ADMIN)))
    val result = operations.getUserList()
    assert(result == List(User(1001 , "Kuldeepak Gupta" , UserType.ADMIN)))
  }

  "deleteUser " should "remove user " in {
    when(mockedUserRepository.listUserId()) thenReturn List.empty[Int]
    when(mockedUserRepository.deleteUser(1245)) thenReturn true
    val result = operations.removeUser(1245)
    assert(result)
  }

  "User " should "not be removed " in {
    when(mockedUserRepository.listUserId()) thenReturn List.empty[Int]
    val userMain = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    when(mockedUserRepository.createUser(userMain)) thenReturn true
    when(mockedUserRepository.deleteUser(1245)) thenReturn true
    val result = operations.removeUser(1246)
    assert(!result)
  }

  "User Name " should " not Change " in {
    when(mockedUserRepository.listUserId()) thenReturn List.empty[Int]
    val userOne = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    when(mockedUserRepository.createUser(userOne)) thenReturn true
    when(mockedUserRepository.updateUser(1246 , "Kuldeepak Gupta")) thenReturn false
    val result = operations.changeUserName(1245 , "Kuldeepak Gupta")
    assert(!result)
  }

  "User ID " should "Display " in {
    val userOne = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    when(mockedUserRepository.createUser(userOne)) thenReturn true
    when(mockedUserRepository.listUserId()) thenReturn List(1245)
    val result = operations.getUserIdList()
    assert(result==List(1245))
  }

  "User Name with ID " should " Display " in {
    when(mockedUserRepository.listUserId()) thenReturn List.empty[Int]
    val userOne = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    when(mockedUserRepository.createUser(userOne)) thenReturn true
    when(mockedUserRepository.getUserNameById(1246)) thenReturn null
    val result = operations.getUser(1246)
    assert(result != "Prabhat Sir")
  }

  "User Name " should "Change " in {
    when(mockedUserRepository.listUserId()) thenReturn List.empty[Int]
    when(mockedUserRepository.updateUser(1245 , "Prabhat Kashyap")) thenReturn true
    val result = operations.changeUserName(1245 , "Kuldeepak 1471")
    assert(result)
  }

}
