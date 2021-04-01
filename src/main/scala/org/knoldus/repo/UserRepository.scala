package org.knoldus.repo

import org.knoldus.db.UserTable
import org.knoldus.models.{DAO, User}
import scala.concurrent.Future

class UserRepository extends DAO [User]{
  val userTable = new UserTable

  override def createUser(user: User): Future[Boolean] = {
    userTable.addUser(user)
  }

  override def listUser(): Future[List[User]] = userTable.getUser()

  override def listUserId(): Future[List[Int]] = userTable.getUserIdList()

  override def updateUser(id: Int, new_name: String) : Future[Boolean] = {
    userTable.updateUserName(id , new_name)
  }

  override def deleteUser(id : Int) : Future[Boolean] = {
    userTable.removeUser(id)
  }

  override def getUserNameById(id: Int) = userTable.getUserNameById(id)

}
