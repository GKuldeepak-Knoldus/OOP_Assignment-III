package org.knoldus.repo

import org.knoldus.dao.DAO
import org.knoldus.models.User

import scala.util.{Failure, Success, Try}
import scala.collection.mutable.Map

class UserRepository extends DAO [User]{
  private val dataRepository : Map[Int , User] = Map()

  override def createUser(user: User): Boolean = {
    Try { dataRepository.addOne(user.id -> user ) } match {
      case Success(value) => true
      case Failure(exception) => false
    }
  }

  override def listUser(): List[User] = dataRepository.values.toList

  override def listUserId(): List[Int] = dataRepository.keySet.toList

  override def updateUser(id: Int, new_name: String) = {
    Try {
      val user = User(id, new_name, dataRepository(id).usertype)
      dataRepository(id) = user
    } match {
      case Failure(exception) => false
      case Success(value) =>true
    }
  }

  override def deleteUser(id : Int) = {
    Try {
      dataRepository -= id
    } match {
      case Failure(exception) => false
      case Success(value) =>true
    }
  }

  override def getUserNameById(id: Int): String = dataRepository(id).name

}
