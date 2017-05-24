package paco.pnlp.sentences

import static ratpack.jackson.Jackson.json

import javax.inject.Inject
import ratpack.handling.Handler
import ratpack.handling.Context
import ratpack.rx.RxRatpack
import rx.Observable

/**
 * It receives a given text and returns a list of
 * detected sentences
 *
 * @since 0.1.0
 */
class SentenceHandler implements Handler {

  @Inject
  SentenceService service

  @Override
  void handle(Context ctx) {
    Map<String,String> payload = ctx.get(Map)
    Observable<String> sentences = Observable.from(service.detectSentences(payload.text))

    RxRatpack
      .promise(sentences)
      .then {
        ctx.render(json(it))
      }
  }
}
