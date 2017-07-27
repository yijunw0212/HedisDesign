package logicModels

/**
  * Created by jwang on 7/19/2017.
  */
trait HedisOutput {

  var measureName: String
  var measureID: String
  var cap: String


  //override def toString(): String

  def artifactOutput()

  def additionalOutput()

  def Caption(): String
}
