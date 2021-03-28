package org.knoldus.db

import org.knoldus.models.User

import scala.collection.mutable.Map
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}

class UserTable {
  private val dataRepository : Map[Int , User] = Map()

  def addUser(user: User):Future[Boolean] = Future{
    Try { dataRepository.addOne(user.id -> user ) } match {
      case Success(value) => true
      case Failure(exception) => false
    }
  }

  def getUser(): Future[List[User]] = Future{
    dataRepository.values.toList
  }

  def getUserIdList(): Future[List[Int]] = Future{
    dataRepository.keySet.toList
  }

  def updateUserName(id: Int, new_name: String) = Future{
    Try {
      val user = User(id, new_name,dataRepository(id).email,dataRepository(id).password ,dataRepository(id).usertype)
      dataRepository(id) = user
    } match {
      case Failure(exception) => false
      case Success(value) =>true
    }
  }

  def removeUser(id : Int) = Future{
    Try {
      dataRepository -= id
    } match {
      case Failure(exception) => false
      case Success(value) =>true
    }
  }

  def getUserNameById(id: Int): Future[String] = Future{
    dataRepository(id).name
  }

}
