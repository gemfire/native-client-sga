/*=========================================================================
 * Copyright (c) 2010-2014 Pivotal Software, Inc. All Rights Reserved.
 * This product is protected by U.S. and international copyright
 * and intellectual property laws. Pivotal products are covered by
 * one or more patents listed at http://www.pivotal.io/patents.
 *=========================================================================
 */
/*=========================================================================
 * Copyright (c) 2010-2014 Pivotal Software, Inc. All Rights Reserved.
 * This product is protected by U.S. and international copyright
 * and intellectual property laws. Pivotal products are covered by
 * one or more patents listed at http://www.pivotal.io/patents.
 *=========================================================================
 */
package javaobject;


import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.FunctionAdapter;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.RegionFunctionContext;
import java.util.Properties;
import org.apache.geode.internal.cache.GemFireCacheImpl;

/**
 * Function that puts the value from the argument at the key passed in through
 * the filter.
 */
public class PutKeyFunction extends FunctionAdapter implements Declarable {

  private static final String ID = "PutKeyFunction";

  public void execute(FunctionContext context) {
    RegionFunctionContext regionContext = (RegionFunctionContext)context;
    Region dataSet = regionContext.getDataSet();
    Object key = regionContext.getFilter().iterator().next();
    Object value = regionContext.getArguments();
    dataSet.put(key, value);
    context.getResultSender().lastResult(Boolean.TRUE);
  }

  public String getId() {
    return ID;
  }

  public boolean hasResult() {
    return true;
  }

  public void init(Properties p) {
  }

  public boolean optimizeForWrite() {
    return true;
  }
  public boolean isHA() {
    return true;
  }
}

