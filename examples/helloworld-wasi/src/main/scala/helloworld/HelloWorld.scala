package helloworld

import scalajs.component.annotation._
import scalajs.{component => cm}

import scala.scalajs.wasi.cli.Stdout._

object HelloWorld {
  @ComponentExport("wasi:cli/run@0.2.0", "run")
  def run(): cm.Result[Unit, Unit] = {
    val msg = "Hello world by wasi write() function"
    val bytes = msg.getBytes ()

    val out = getStdout()

    // out.blockingWriteAndFlush (bytes)

    out.write (bytes)

    new cm.Ok(())
  }
}
