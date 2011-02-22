package scala

import com.guardian.reviewQueue.model.ReviewTypes
import com.reviewQueue.service.ReviewFetcherService
import org.junit.Assert
import org.junit.Test

import com.guardian.reviewQueue.service.ReviewConverterService

class TestHttpClient {
  @Test def can_get_results_from_live_webserver: Unit = {
    val svc = new ReviewFetcherService(new ReviewConverterService)
    val content = svc.getReviewJson(ReviewTypes.Music)
    Assert.assertTrue(!content.equals(""))
    val reviews = svc.getReviews(ReviewTypes.Film)
    Assert.assertTrue(reviews.size > 0)
  }
}