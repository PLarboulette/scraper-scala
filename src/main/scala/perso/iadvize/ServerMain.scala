package perso.iadvize


import _root_.controllers.PostsController
import com.fasterxml.jackson.module.scala.JacksonModule
import com.google.inject.Inject

import com.twitter.finatra.http._
import com.twitter.finatra.http.routing.HttpRouter
import perso.iadvize.scraper.Scrapper

/**
  * Created by pierre on 12/03/16.
  */
object ServerMain extends Server  {

}

class Server extends HttpServer {

  override val defaultFinatraHttpPort: String = ":8080"

  /*override val modules = Seq(
    JacksonModule
  )*/

  iniScrapper()

  def iniScrapper() : Unit = {
    Scrapper.init()
  }

  override def configureHttp(router: HttpRouter): Unit = {
    router.add[PostsController]
  }

}


