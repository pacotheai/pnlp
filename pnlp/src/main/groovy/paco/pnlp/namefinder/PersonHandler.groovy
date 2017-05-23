package paco.pnlp.namefinder

import static ratpack.rx.RxRatpack.promise
import static paco.pnlp.common.HandlerUtils.rasjson

import javax.inject.Inject
import ratpack.handling.Handler
import ratpack.handling.Context
import ratpack.rx.RxRatpack
import rx.Observable

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
