package paco.pnlp.sentiment

import static ratpack.jackson.Jackson.json

import ratpack.handling.Context
import ratpack.handling.Handler

import javax.inject.Inject

class SentimentHandler implements Handler {

  @Inject
  SentimentService service

  void handle(Context context) {
    Map<String,String> payload = context.get(Map)
    Map isPositive = service.isPositive(payload.text)

    context.render(json(isPositive))
  }
}
