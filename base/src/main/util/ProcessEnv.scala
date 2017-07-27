package util


/**
  * Created by jwang on 7/19/2017.
  */
object ProcessEnv extends Enumeration {
  type ProcessEnv = Value
  val STD, HADOOP, TEST, CERTIFICATE = Value
}
