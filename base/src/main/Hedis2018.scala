import checkers.LogicChecker
import dataQualityEnforcement.DataQualityChecker
import logicModels.MeasureBase
import processors.ProcessorBase
import systemComponents.{Loader}

import scala.collection.mutable.ListBuffer


/**
  * Created by jwang on 7/18/2017.
  */
class Hedis2018 extends Serializable{

  val mainProcessors: ListBuffer[ProcessorBase] = ListBuffer[ProcessorBase]()
  val measures :ListBuffer[MeasureBase] = ListBuffer[MeasureBase]()
  val loaders: ListBuffer[Loader] = ListBuffer[Loader]()
  val eventsLoaders:ListBuffer[Loader] = ListBuffer[Loader]()
  val ignoreLogicCheckers: ListBuffer[LogicChecker] = ListBuffer[LogicChecker]()
  val dataQualityCheckers: ListBuffer[DataQualityChecker] = ListBuffer[DataQualityChecker]()


  def process(): Unit = {
    mainProcessors.foreach{
      processor =>
      processor.init(measures.toList,loaders.toList,eventsLoaders.toList,ignoreLogicCheckers.toList,dataQualityCheckers.toList)
      processor.process()
    }
  }


  def registerEnvProcessor(envProcessor: ProcessorBase): Unit = {
    mainProcessors += envProcessor
  }

  def registerMeasure(measure: MeasureBase): Unit = {
    measures += measure
  }

  def registerRequiredUtilsLoader(loader: Loader): Unit = {
    loaders += loader
  }

  def registerEventLoader(eventloader: Loader): Unit = {
    eventsLoaders += eventloader
  }

  def registerIgnoreLogicChecker(logicChecker: LogicChecker): Unit = {
    ignoreLogicCheckers += logicChecker
  }

  def registerDataQualityChecker(dataQualityChecker: DataQualityChecker): Unit = {
    dataQualityCheckers += dataQualityChecker
  }

}

