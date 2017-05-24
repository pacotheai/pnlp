package paco.pnlp.namefinder

import static paco.pnlp.common.HandlerUtils.rasjson
import static ratpack.rx.RxRatpack.promise

import ratpack.handling.Context
import ratpack.handling.Handler
import rx.Observable

import javax.inject.Inject

class PersonHandler implements Handler {

  @Inject
  NameFinderService service

  @Override
  void handle(Context context) {
    Map payload = context.get(Map)
    Observable<Map> result = Observable.from(service.findNames('person', "${payload.text}"))

    promise(result).then(rasjson(context))
  }
}
