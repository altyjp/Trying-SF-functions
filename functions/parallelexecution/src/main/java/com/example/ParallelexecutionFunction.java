package com.example;

import java.util.ArrayList;
import java.util.List;

import com.salesforce.functions.jvm.sdk.Context;
import com.salesforce.functions.jvm.sdk.InvocationEvent;
import com.salesforce.functions.jvm.sdk.SalesforceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describe ParallelexecutionFunction here.
 */
public class ParallelexecutionFunction implements SalesforceFunction<FunctionInput, FunctionOutput> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ParallelexecutionFunction.class);

  private final int ARRAY_SIZE = 5000;
  private final int BASE_NUM = 1000;

  @Override
  public FunctionOutput apply(InvocationEvent<FunctionInput> event, Context context)
      throws Exception {

        List<Integer> intList = new ArrayList<Integer>();

        for (int i = 0; i < ARRAY_SIZE; i++) {
          intList.add(i + BASE_NUM);
        }

        // 処理時間の計測開始
        long startTime = System.currentTimeMillis();

        // 1000から5999までの素数を見つける(80msec)
        intList.parallelStream().filter(n -> isPrime(n)).forEach(System.out::println);

        // 処理時間の計測終了
        long endTime = System.currentTimeMillis();

        System.out.println("開始時刻：" + startTime + " ms");
        System.out.println("終了時刻：" + endTime + " ms");
        System.out.println("処理時間：" + (endTime - startTime) + " ms");

        return new FunctionOutput();
  }

  /**
   * 指定した数が素数かどうか判定する。
   * @param n
   * @return
   */
  private boolean isPrime(long n) {
    for (int i = 2; i < n; i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}
}
