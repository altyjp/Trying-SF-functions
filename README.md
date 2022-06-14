# Salesforce Functions を試してみた。
このコードは2022/7/1発表予定のSFDG発表で利用するプレゼンのソースコード部分になります。  
全てローカルでの実行を前提に作成しておりますので、デプロイ等はできません。

# 内容物
## Functions
以下のファイルは Functions 用です。  
- functions/parallelexecution
- functions/librarysample

ローカル環境で実行が可能です。  
実行するには、以下のコマンドでサーバを立ち上げます。
```
cd functions/librarysample # functions/parallelexecution
sf run function start
```
次に別のウィンドウでターミナルを開き、以下を入力します。
```
sf run function -l http://localhost:8080 -p '{}'
```
サーバーを立ち上げたターミナルに戻り、ログの出力を確認してください。

## Apex script
### scripts/apex/processList.apex
functions/parallelexecution のApex版です。  
重い処理のため、ガバナエラーになります。

### scripts/apex/withoutLibrary.apex
functions/librarysample のApex版です。  
ライブラリを使用しないため、csvを自前で組み立てています。
