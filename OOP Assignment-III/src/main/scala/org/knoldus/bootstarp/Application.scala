package org.knoldus.bootstarp

import org.knoldus.dao.DAO
import org.knoldus.service.Operations
import org.knoldus.models._
import org.knoldus.repo.Repository

import java.util.UUID
import java.util.UUID.randomUUID

object Application  {

  def main(args: Array[String]): Unit = {
    val repository : DAO[User] = new Repository
    val operations = new Operations(repository)
    val userMain = new User(randomUUID() , "Prabhat Sir" , UserType.ADMIN)
    val userOne = new User(randomUUID() , "Kuldeepak Gupta" , UserType.ADMIN)
    val userTwo = new User(randomUUID() , "Yash Gupta" , UserType.CUSTOMER)
    operations.addUser(userMain)
    operations.addUser(userOne)
    operations.addUser(userTwo)
    print(operations.getUserList())

  }
}
