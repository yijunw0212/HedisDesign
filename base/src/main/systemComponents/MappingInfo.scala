package systemComponents

/**
  * Created by jwang on 7/20/2017.
  */
class MappingInfo extends Serializable{
  var SourceSchema: String = ""
  var SourceFieldName: String = ""
  var SourceDataType: String = ""
  var TargetSchema: String = ""
  var TargetFieldName : String = ""
  var TargetDataType: String = ""
  var BeginIndex: Int = -1
  var EndIndex: Int = -1
  var Format: String = ""
  var AllowNull: Boolean = true
  var SplitSymbol: String = ""
}
