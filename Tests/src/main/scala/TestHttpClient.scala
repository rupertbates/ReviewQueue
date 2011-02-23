package main.scala

import com.guardian.reviewQueue.model.ReviewTypes
import com.reviewQueue.service.ReviewFetcherService
import org.junit.Assert
import org.junit.Test

import com.guardian.reviewQueue.service.ReviewConverterService
import org.apache.http.impl.client.DefaultHttpClient
import org.scalatest.junit.{JUnitSuite, ShouldMatchersForJUnit}

class TestHttpClient extends JUnitSuite with ShouldMatchersForJUnit {
  @Test def can_get_results_from_live_webserver: Unit = {
    val svc = new ReviewFetcherService(new DefaultHttpClient, new ReviewConverterService)
    val content = svc.getReviewJson(ReviewTypes.Music)
    val reviews = svc.getReviews(ReviewTypes.Film)

    content should not be ('empty)
    reviews.size should be > (0)
  }
}