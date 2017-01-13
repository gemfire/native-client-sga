#include "ThinClientRegex.hpp"

DUNIT_MAIN
  {
    CALL_TASK(CreateLocator1);
    CALL_TASK(CreateServer1_With_Locator_XML)

    CALL_TASK(CreateClient1Regions);
    CALL_TASK(CreateClient2Regions);

    CALL_TASK(RegisterClient1Regex);
    CALL_TASK(RegisterClient2Regex);
    CALL_TASK(CreateClient1Entries);
    CALL_TASK(CreateAndVerifyClient2Entries);
    CALL_TASK(VerifyAndUpdateClient1Entries);
    CALL_TASK(VerifyAndUpdateClient2Entries);
    CALL_TASK(VerifyClient1Entries);
    CALL_TASK(CloseCache1);
    CALL_TASK(CloseCache2);
    CALL_TASK(CloseServer1);

    CALL_TASK(CloseLocator1);
  }
END_MAIN
