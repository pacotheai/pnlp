package paco.pnlp.init

import ratpack.rx.RxRatpack
import ratpack.server.Service
import ratpack.server.StartEvent

class StartupService implements Service {
  @Override
  void onStart(StartEvent event) {
    RxRatpack.initialize()
  }
}
