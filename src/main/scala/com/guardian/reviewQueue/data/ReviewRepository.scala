package com.guardian.reviewQueue.data
import com.guardian.reviewQueue.model.{ReviewTypes, Review}

class ReviewRepository(dbFilePath: String) extends db4oRepository[Review](dbFilePath){
  def getReviews(reviewType : ReviewTypes) = {
    val reviews =  List(new Review(ReviewType = ReviewTypes.Books))
  }
}