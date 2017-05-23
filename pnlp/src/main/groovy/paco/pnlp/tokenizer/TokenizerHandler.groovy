package paco.pnlp.tokenizer

import static ratpack.jackson.Jackson.json

import javax.inject.Inject
import ratpack.handling.Handler
import ratpack.handling.Context
import ratpack.rx.RxRatpack
import rx.Observable

class TokenizerHandler implements Handler {

  @Inject
  TokenizerService service

  @Override
  void handle(Context context) {
    Map<String,String> payload = context.get(Map)
    Observable<String> tokens = Observable.from(service.tokenize(payload.text))

    RxRatpack
      .promise(tokens)
      .then {
        context.render(json(it))
      }
  }
}
