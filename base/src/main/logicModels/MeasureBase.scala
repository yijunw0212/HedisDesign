package logicModels

/**
  * Created by jwang on 7/17/2017.
  */
trait MeasureBase {
  var measureName: String
  var measureID: String
  var GUID: String
  var measureShortName: String
  //var ignoreCheckers: List[LogicChecker]

  def num(events: List[Event]): String

  def deno(events: List[Event]): String

  def epop(events: List[Event]): String

  def excl(events: List[Event]): String

  def process(): Unit
}


