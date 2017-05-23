import static ratpack.groovy.Groovy.ratpack

import ratpack.server.ServerConfigBuilder

import paco.pnlp.common.AppConfig
import paco.pnlp.common.HandlerUtils
import paco.pnlp.sentences.SentenceHandler
import paco.pnlp.tokenizer.TokenizerHandler
import paco.pnlp.namefinder.PersonHandler
import paco.pnlp.namefinder.LocationHandler
import paco.pnlp.sentiment.SentimentHandler

ratpack {

  serverConfig { ServerConfigBuilder config ->
    config
    .port(5050)
    .yaml("pnlp-conf.yml")
    .require("", AppConfig)
  }

  handlers {
    prefix('api/v1') {
      prefix('sentences') {
        all(HandlerUtils.createBindingHandler(Map))
        post('me', SentenceHandler)
      }
      prefix('tokenizer') {
        all(HandlerUtils.createBindingHandler(Map))
        post('me', TokenizerHandler)
      }
      prefix('finder') {
        all(HandlerUtils.createBindingHandler(Map))
        post('person', PersonHandler)
        post('location', LocationHandler)
      }

      prefix('sentiment') {
        all(HandlerUtils.createBindingHandler(Map))
        post('me', SentimentHandler)
      }
    }
  }
}
