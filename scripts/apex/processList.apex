// ParallelexecutionFunction.java と同じ処理をApexで実行する。

final Integer ARRAY_SIZE = 5000;
final Integer BASE_NUM = 1000;

List<Integer> intList = new List<Integer>();

for (Integer i = 0; i < ARRAY_SIZE; i++) {
    intList.add(i + BASE_NUM);
}

// 処理時間の計測開始
long startTime = System.currentTimeMillis();

// 1000から5999までの素数を見つける
for (Integer num : intList){
    Boolean isPrime = true;
    for (Integer i = 2; i < num; i++) {
        if (Math.mod(num, i) == 0){
            isPrime = false;
            break;
        }
    }
    // System.LimitException: Apex CPU time limit exceeded
    // Maximum CPU time: 15035 out of 10000 ******* CLOSE TO LIMIT
    if (isPrime) {
        System.debug(num);
    }
}

// 処理時間の計測終了
long endTime = System.currentTimeMillis();

System.debug (Logginglevel.INFO, '開始時刻：' + startTime + ' ms');
System.debug (Logginglevel.INFO, '終了時刻：' + endTime + ' ms');
System.debug (Logginglevel.INFO, '処理時間：' + (endTime - startTime) + ' ms');