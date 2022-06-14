// LibrarysampleFunction.javaのApex版。
// Account を Csv にする。
List<Account> accountList = [SELECT Id, Name FROM Account];
List<String> csvStr = new List<String>();
for(Account acc : accountList){
    String accountId = acc.Id;
    String accountName = acc.Name;
    // 自前で組み立てが必要
    String csvRow = '"' + accountId + '","' + accountName + '"';
    csvStr.add(csvRow);
}
System.debug(csvStr);