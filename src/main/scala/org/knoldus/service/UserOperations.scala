package org.knoldus.service

import org.knoldus.dao.DAO
import org.knoldus.models.User

class UserOperations(repository: DAO[User]){

  def addUser(user : User): Boolean = {
    if(user.name.length != 0 &&  !(repository.listUserId().contains(user.id)) )  {
      repository.createUser(user)
      true
    }
    else
      {
        false
      }
  }

  def getUserList() : List[User] = repository.listUser()

  def removeUser(id : Int) : Boolean = {
    if (repository.listUserId().contains(id)) {
      repository.deleteUser(id)
      true
    } else {
      false
    }
  }

  def changeUserName(id : Int , name: String) :Boolean = {
    if (repository.listUserId().contains(id)) {
      repository.updateUser(id, name)
      true
    }
   else
      false
  }

  def getUser(id : Int)  : String = {
    if(repository.listUserId().contains(id))
      repository.getUserNameById(id)
    else
      null
  }

  def getUserIdList() : List[Int] = repository.listUserId()

}
