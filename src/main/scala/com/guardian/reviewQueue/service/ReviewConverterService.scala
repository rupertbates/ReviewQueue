/*
 * Created by IntelliJ IDEA.
 * User: rupert bates
 * Date: 18/02/11
 * Time: 16:02
 */
package com.guardian.reviewQueue.service

import com.google.gson.GsonBuilder
import reflect.Type
import com.google.gson.reflect.TypeToken
import java.util.{List, Collection}
import com.guardian.reviewQueue.model.Review

class ReviewConverterService {

    def convertReviews(json : String ) : List[Review] =
    {
        val collectionType = new TypeToken[Collection[Review]](){}.getType();
        return ReviewConverterService.gson.fromJson(json, collectionType);
    }
}
object ReviewConverterService{
    private val b = new GsonBuilder();
    b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    val gson = b.create();
}