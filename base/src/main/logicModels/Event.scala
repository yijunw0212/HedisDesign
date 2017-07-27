package logicModels
import util.EventType.EventType
/**
  * Created by jwang on 7/19/2017.
  */
trait Event extends Serializable with Ordered[Event]{
    var memberID: String
    var eventType : EventType

    override def toString: String

    override def equals(obj: scala.Any): Boolean
}
