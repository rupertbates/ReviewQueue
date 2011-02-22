package com.guardian.reviewQueue.service

import com.guardian.reviewQueue.model.Review
import com.google.gson._
class ReviewConverterService {

    def convertReviews(json : String ) : List[Review] =
    {
      val reviews = ReviewConverterService.gson.fromJson(json, classOf[Array[Review]])
      return reviews.toList
    }
}
object ReviewConverterService{
    private val b = new GsonBuilder();
    b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    val gson = b.create();
}
