package com.guardian.reviewQueue.data
import com.guardian.reviewQueue.model.User


class UserDb4oRepository(dbFilePath: String)
  extends db4oRepository[User](dbFilePath)
{

}
