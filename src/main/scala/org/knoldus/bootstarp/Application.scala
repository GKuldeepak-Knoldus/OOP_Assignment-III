package org.knoldus.bootstarp

import org.knoldus.dao.DAO
import org.knoldus.service.UserOperations
import org.knoldus.models._
import org.knoldus.repo.UserRepository

object Application  {

  def main(args: Array[String]): Unit = {
    val repository : DAO[User] = new UserRepository
    val operations = new UserOperations(repository)
    val userMain = new User( 1245, "Prabhat Sir" , UserType.ADMIN)
    val userOne = new User(1234, "Kuldeepak Gupta" , UserType.ADMIN)
    val userTwo = new User(2345 , "Yash Gupta" , UserType.CUSTOMER)
    operations.addUser(userMain)
    operations.addUser(userOne)
    operations.addUser(userTwo)
    print(operations.getUserList())
    println(operations.getUser(1234))
    if(operations.changeUserName(1245 , "Prabhat Kashyap"))
      println("Updated")
    else
      println("Error")
    println(operations.getUserList())
    operations.removeUser(2345)
    println(operations.getUserList())
    println(operations.getUser(1245))
    println(operations.getUser(1000))

  }
}
