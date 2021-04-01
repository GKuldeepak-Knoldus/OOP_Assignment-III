package org.knoldus.service

import org.knoldus.models.{DAO, User}
import org.knoldus.validator._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps

class UserOperations(repository: DAO[User]){

  val eMailVerification = new eMailValidator
  val passwordVerification = new PasswordValidator

  def addUser(user : User) : Future[Boolean]= {
    if(user.name.nonEmpty) {
      for {
        t <- repository.listUserId()
      } yield {
        if (t.contains(user.id))
          false
        else {
          repository.createUser(user)
          true
        }
      }
    }
    else Future.successful(false)
  }

  def getUserList() : Future[List[User]] = repository.listUser()

  def removeUser(id : Int) : Future[Boolean] = {
    for {
      t <- repository.listUserId()
    } yield {
      if (t.contains(id)) {
        repository.deleteUser(id)
        true
      } else {
        false
      }
    }
  }

  def changeUserName(id : Int , name: String) :Future[Boolean] =  {
    for {
      t <- repository.listUserId()
    } yield {
      if (t.contains(id)) {
        repository.updateUser(id , name)
        true
      } else {
        false
      }
    }
  }

  def getUser(id : Int)  : Future[String] = {
    repository.getUserNameById(id)
    }

  def getUserIdList() : Future[List[Int]] = repository.listUserId()

  def verifyEmail(email : String) : Boolean = eMailVerification.isValidEmail(email)

  def verifyPassword(password : String) : Boolean = passwordVerification.isValidPassword(password)

}
