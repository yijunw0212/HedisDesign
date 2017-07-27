package connection

import java.sql.{Connection, DriverManager}

/**
  * Created by jwang on 7/18/2017.
  */
trait DatabaseConnection extends Connection{
  var driver : String
  var url: String
  var username: String
  var password: String

  // there's probably a better way to do this
  var connection:Connection

  def createConnection(): Connection


}
