package processors

import checkers.LogicChecker
import dataQualityEnforcement.DataQualityChecker
import logicModels.{Code, Event, MeasureBase}
import org.apache.spark.SparkContext
import systemComponents.{Loader, Logging}
import util.DataQualityIssueTypes
import util.ProcessEnv.ProcessEnv


/**
  * Created by jwang on 7/17/2017.
  */
trait ProcessorBase extends Logging{
  var proceeEnv:ProcessEnv = _
  var measures:List[MeasureBase] = List()
  var requiredUtilsLoaders:List[Loader] = List()
  var eventLoaders:List[Loader] = List()
  var logicCheckers:List[LogicChecker] = List()
  var dataQualityCheckers:List[DataQualityChecker] = List()
  var sc: SparkContext = _
  var codeList: List[Code] = _
  var eventsList: List[Event]


  def init( meas:List[MeasureBase],
            loaders:List[Loader],
            events:List[Loader],
            logics:List[LogicChecker],
            dataQuality:List[DataQualityChecker]): Unit = {
    measures = meas
    requiredUtilsLoaders = loaders
    eventLoaders = events
    logicCheckers = logics
    dataQualityCheckers = dataQuality
    sc = null
  }

  def init(
            meas:List[MeasureBase],
            loaders:List[Loader],
            events:List[Loader],
            logics:List[LogicChecker],
            dataQuality:List[DataQualityChecker],
            sparkC: SparkContext): Unit = {
    measures = meas
    requiredUtilsLoaders = loaders
    eventLoaders = events
    logicCheckers = logics
    dataQualityCheckers = dataQuality
    sc = sparkC
  }

  def process(): Unit

  def integrateData(entities: List[Loader], standard: Any): List[Any] = {
    entities.filter( e => e.output._1 == standard)
      .map( e => e.output._2).reduce((e1,e2) => e1.union(e2))
  }

  def boardCast(value : List[Any]) : Unit = {
    sc.broadcast(value)
  }

}
