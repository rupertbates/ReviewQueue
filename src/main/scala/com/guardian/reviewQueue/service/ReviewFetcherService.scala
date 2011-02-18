package com.reviewQueue.service

import com.reviewQueue.model.Review
import com.reviewQueue.model.ReviewTypes
import com.reviewQueue.service.interfaces.IReviewConverterService
import com.reviewQueue.service.interfaces.IReviewFetcherService
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.util.EntityUtils
import java.io.IOException
import java.util.List
import com.google.inject.Inject
import com.guardian.reviewQueue.service.ReviewConverterService
import com.guardian.reviewQueue.model.Review

class ReviewFetcherService {
  @Inject def this(converter: ReviewConverterService) {
    this ()
    _converter = converter
  }

  def getReviews(reviewType: ReviewTypes): List[Review] = {
    return _converter.convertReviews(getReviewJson(reviewType))
  }

  def getReviewJson(reviewType: ReviewTypes): String = {
    var url: String = String.format("http://reviewqueue.stage.guardianprofessional.co.uk/review/%s/json", reviewType.Name)
    var httpclient: HttpClient = new DefaultHttpClient
    var httpget: HttpGet = new HttpGet(url)
    var response: HttpResponse = httpclient.execute(httpget)
    var entity: HttpEntity = response.getEntity
    var content: String = ""
    if (entity != null) {
      content = EntityUtils.toString(entity)
    }
    return content
  }

  private[service] var _converter: ReviewConverterService = null
}