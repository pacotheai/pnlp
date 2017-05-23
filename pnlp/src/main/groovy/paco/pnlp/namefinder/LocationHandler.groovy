package paco.pnlp.namefinder

import static ratpack.rx.RxRatpack.promise
import static paco.pnlp.common.HandlerUtils.rasjson

import javax.inject.Inject
import ratpack.handling.Handler
import ratpack.handling.Context
import rx.Observable

class LocationHandler implements Handler {

  @Inject
  NameFinderService service

  @Override
  void handle(Context context) {
    Map payload = context.get(Map)
    Observable<Map> result = Observable.from(service.findNames('location', "${payload.text}"))

    promise(result).then(rasjson(context))
  }
}
