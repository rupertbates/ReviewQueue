import com.guardian.reviewQueue.data.db4oRepository
import com.guardian.reviewQueue.model.User
import org.junit.Test
import org.scalatest.junit.{JUnitSuite, ShouldMatchersForJUnit}

class TestScalaRepository extends JUnitSuite with ShouldMatchersForJUnit {

  @Test def test_db4oRepository: Unit = {
    val dir: String = System.getProperty("user.dir") + "\\test.db4o"
    val repository = new db4oRepository[User](dir)
    val u = new User
    u.FullName = "Rupert Bates"
    u.Email = "rupert.bates@guardian.co.uk"
    repository.save(u)
    val users = repository.getAll
    var size = users
      .filter(u => u.Email.startsWith("rupert"))
      .size
    users.size should be > (0)

    var u2 = repository.getById(1)
  }

  def test_implicit_conversion() {
    //var jlist : java.util.LinkedList = new java.util.[String]
    //jlist.add("test1", "test2")

  }

  def test_manifest() = {
    class XYZ[T](implicit man: Manifest[T]) {
      def getOne: T = man.erasure.newInstance.asInstanceOf[T]
    }
    class Dog {
      def bark = "Woof"
    }
    val xyz = new XYZ[Dog]
    xyz.getOne.bark
  }

}