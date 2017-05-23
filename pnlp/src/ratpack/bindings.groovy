import static ratpack.groovy.Groovy.ratpack

import paco.pnlp.init.StartupModule
import paco.pnlp.sentences.SentenceModule
import paco.pnlp.tokenizer.TokenizerModule
import paco.pnlp.namefinder.NameFinderModule
import paco.pnlp.sentiment.SentimentModule

ratpack {
  bindings {
    module StartupModule
    module SentenceModule
    module TokenizerModule
    module NameFinderModule
    module SentimentModule
  }
}
