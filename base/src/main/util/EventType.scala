package util

/**
  * Created by jwang on 7/23/2017.
  */
object EventType extends Enumeration{
  type EventType = Value
  val VISIT, LAB, PHARMACY, PHARMACYCLINICAL, ENROLLMENT = Value
}
