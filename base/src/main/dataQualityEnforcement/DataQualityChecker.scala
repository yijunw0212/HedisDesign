package dataQualityEnforcement

import logicModels.Event


/**
  * Created by jwang on 7/20/2017.
  */
trait DataQualityChecker {

  var issues: List[Event]

  def checkQuality(): Unit

  def resolveQualityIssues(): Unit
}
