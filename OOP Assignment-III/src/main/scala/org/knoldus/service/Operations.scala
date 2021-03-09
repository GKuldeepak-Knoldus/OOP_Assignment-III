package org.knoldus.service

import org.knoldus.dao.DAO
import org.knoldus.models.User

import java.util.UUID

class Operations (repository: DAO[User]){

  def addUser(user : User) = repository.createUser(user)

  def getUserList() : List[UUID] = repository.listUser()

  def removeUser(id : UUID) = repository.deleteUser(id)

  def changeUserName(id : UUID , name: String) = repository.updateUser(id , name)

}
