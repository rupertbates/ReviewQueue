package com.reviewQueue.service

import com.guardian.reviewQueue.model.Review
import com.guardian.reviewQueue.model.ReviewTypes
import android.util.Log
import java.net.{InetAddress, UnknownHostException}

//import com.guardian.reviewQueue.service.interfaces.IReviewConverterService
//import com.guardian.reviewQueue.service.interfaces.IReviewFetcherService

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.util.EntityUtils
import java.io.IOException

//import java.util.List

import com.google.inject.Inject
import com.guardian.reviewQueue.service.ReviewConverterService
import com.guardian.reviewQueue.model.{ReviewTypes, Review}

object ReviewFetcherService {

  val baseUrl = "http://reviewqueue.stage.guardianprofessional.co.uk/review/%s/json"
  warmUpDns
  def warmUpDns = {
    try {
      val i = InetAddress.getByName(ReviewFetcherService.baseUrl)
    } catch {
      case e: UnknownHostException => e.printStackTrace
    }
  }
}

class ReviewFetcherService(converter: ReviewConverterService = new ReviewConverterService) {

  def getReviews(reviewType: ReviewTypes): List[Review] = {
    //return List(new Review("Review 1", ReviewType = ReviewTypes.Music), new Review("Review 2", ReviewType = ReviewTypes.Music))
    return converter.convertReviews(getReviewJson(reviewType))
  }

  def getReviewJson(reviewType: ReviewTypes): String = {
    val url: String = String.format(ReviewFetcherService.baseUrl, reviewType.Name)
    val httpclient: HttpClient = new DefaultHttpClient
    val httpget: HttpGet = new HttpGet(url)
    var content: String = ""
    try {
      val response: HttpResponse = httpclient.execute(httpget)
      val entity: HttpEntity = response.getEntity
      if (entity != null) {
        content = EntityUtils.toString(entity)
      }
    }
    catch {
      case ioe: IOException => log(ioe) //  Log.e("ReviewFetcher", ioe.getMessage)
      case e: Exception => log(e) // Log.e("ReviewFetcher", e.getMessage)
    }

    return content
  }

  def log(e: Exception) = {
    val s = e.getMessage
    Log.e("ReviewFetcher", s, e)
  }
}