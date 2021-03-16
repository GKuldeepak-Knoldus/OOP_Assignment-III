package org.knoldus.service

import org.knoldus.dao.DAO
import org.knoldus.models.User

class Operations (repository: DAO[User]){

  def addUser(user : User): Boolean = {
    if(user.name.length != 0 &&  !(repository.getRepository().keySet.contains(user.id)) )  {
      repository.createUser(user)
      true
    }
    else
      {
        false
      }
  }

  def getUserList() : List[(Int,User)] = repository.listUser()

  def removeUser(id : Int) : Boolean = {
    if (repository.getRepository().contains(id))
      true
    else {
      false
    }
  }

  def changeUserName(id : Int , name: String) :Boolean = {
    if (repository.getRepository().keySet.contains(id)) {
      repository.updateUser(id, name)
      true
    }
   else
      false
  }

  def getUser(id : Int)  : String = {
    if(repository.getRepository().contains(id))
      repository.getUserNameByName(id)
    else
      null
  }

}
