package org.knoldus.repo

import org.knoldus.dao.DAO
import org.knoldus.models.User

import scala.collection.mutable
import scala.util.{Failure, Success, Try}
import scala.collection.mutable.Map

class UserRepository extends DAO [User]{
  private var dataRepository : Map[Int , User] = Map()

  override def createUser(user: User): Boolean = {
    Try { dataRepository.addOne(user.id -> user ) } match {
      case Success(value) => true
      case Failure(exception) => false
    }
  } // Adding user to DataStructure

  override def listUser(): List[(Int , User)] = dataRepository.toList //Listing Users

  override def updateUser(id: Int, new_name: String) = { // Updating the Names of Users by UUID
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
  } // Deleting user by UUID

  override def getUserNameByName(id: Int): String = dataRepository(id).name

  override def getRepository(): mutable.Map[Int, User] = dataRepository
}
