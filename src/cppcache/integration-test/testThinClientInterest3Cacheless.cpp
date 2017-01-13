#include "ThinClientInterest3Cacheless.hpp"

DUNIT_MAIN
  {
    CALL_TASK(CreateLocator1);
    CALL_TASK(CreateServer1_With_Locator_XML)

    CALL_TASK(SetupClient1_Pool_Locator);

    CALL_TASK(testCreatesAndUpdates);
    CALL_TASK(StopClient1);
    CALL_TASK(StopServer);

    CALL_TASK(CloseLocator1);
  }
END_MAIN
