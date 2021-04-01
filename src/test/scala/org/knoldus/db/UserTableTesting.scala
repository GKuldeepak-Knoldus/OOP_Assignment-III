package org.knoldus.db

import org.knoldus.models.{User, UserType}
import org.scalatest.flatspec.AsyncFlatSpec

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class UserTableTesting extends AsyncFlatSpec{
  val userTable = new UserTable
  val user = User(1001, "Kuldeepak Gupta","kuldeepak.gupta@knoldus.com" , "Kuldeepak@knoldus123" ,UserType.ADMIN)

  "addUser " should "Add user " in {
    val result = Await.result(userTable.addUser(user), 5 seconds)
    assert(result)
  }

  "getUser " should "return a list " in {
    Await.result(userTable.addUser(user) , 5 seconds)
    val result = Await.result(userTable.getUser(), 5 seconds)
    assert(result.nonEmpty)
  }

  "getUserIdList " should "return a list of ID" in {
    Await.result(userTable.addUser(user) , 5 seconds)
    val result = Await.result(userTable.getUserIdList() , 5 seconds)
    assert(result.nonEmpty)
  }

  "updateUserName " should "update the user name " in {
    Await.result(userTable.addUser(user) , 5 seconds)
    val result = Await.result(userTable.updateUserName(1001 , "Prabhat") ,5 seconds )
    assert(result)
  }

  it should "not update the username " in {
    Await.result(userTable.addUser(user), 5 seconds)
    val result = Await.result(userTable.updateUserName(1002,  "KG") , 5 seconds)
    assert(!result)
  }

  "removeUser " should "remove a user " in {
    Await.result(userTable.addUser(user) , 5 seconds)
    val result = Await.result(userTable.removeUser(1001) , 5 seconds)
    assert(result)
  }

  "getUserNameById " should "return a name " in {
    Await.result(userTable.addUser(user) , 5 seconds)
    val result = Await.result(userTable.getUserNameById(1001) , 5 seconds)
    assert(result.nonEmpty)
  }

}
