package main.scala

import org.junit.Test
import com.guardian.reviewQueue.model.{Review, ReviewTypes}
import com.guardian.reviewQueue.service.ReviewConverterService
import org.scalatest.junit.{JUnitSuite, ShouldMatchersForJUnit}

class ReviewConverterAndGsonTests extends JUnitSuite with ShouldMatchersForJUnit {
  @Test def can_serialize_and_deserialize_ReviewTypes: Unit = {
    val json = ReviewConverterService.gson.toJson(ReviewTypes.Books)
    val reviewType = ReviewConverterService.gson.fromJson(json, classOf[ReviewTypes])

    ReviewTypes.Books.DisplayName should equal (reviewType.DisplayName)
    ReviewTypes.Books.Id should equal (reviewType.Id)
    ReviewTypes.Books.Name should equal (reviewType.Name)
  }

  @Test def can_deserialize_some_reviews: Unit = {

    val reviews = Array(
      new Review("test title", ReviewType = ReviewTypes.Books),
      new Review("test music review", ReviewType = ReviewTypes.Music)
    )

    val json = ReviewConverterService.gson.toJson(reviews)
    val reviews2 = ReviewConverterService.gson.fromJson(json, classOf[Array[Review]])

    "" should be ('empty)
    json should not be ('empty)
    reviews.size should equal (reviews2.size)
  }

  @Test def can_deserialize_some_real_json: Unit = {

    val file = System.getProperty("user.dir") + "\\Tests\\files\\reviewsfromreviewqueue.js"
    val json = FileHelper.readTextFromFile(file)
    val reviews = ReviewConverterService.gson.fromJson(json, classOf[Array[Review]])

    reviews.size should be > (0)
    val reviews2 = new ReviewConverterService().convertReviews(json)
    reviews.size should equal (reviews2.size)
  }
}