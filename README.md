# Springフレームワークを習得するためのリポジトリ

## Entityクラス
- EntityとはDBのテーブルの構造を表したもの
- １つのレコードを１つのインスタンスにするために使用するクラス
- POJO（Plain Old Java Object）ともいう
- DBから取得したデータはMap型などになっているが、そのまま扱うのではなくオブジェクト指向ではEntityクラス（インスタンス）に詰め替える

## インターフェースの役割

- 機能の概要
  - TODOリストのようなもの
    - メソッド名と引数がどのようなものかだけを決めておき、実装は実装先のクラスに任せる
- インターフェースは、暗黙的に「abstract」と「public」が自動的に保管されるため、書く必要がない

## データの保存先（メモリ内の構造）

- スタック領域
  - インスタンスのアドレスが保管される
- ヒープ領域
  - インスタンスの中身が保管される
  - ヒープ領域を見ることを「参照する」という（インスタンスが参照型だとかいう会話になる）

インスタンスを変数に代入しただけではアドレスしか参照できない

## シングルトン

- そのクラスのインスタンスが必ず1つであることを保証するデザインパターン
- staticなクラスオブジェクトを持つクラスが呼び出されるタイミングで1度だけnewする
- コンストラクタはprivateにし、外からnewできなくする（クラスオブジェクトが呼び出されるタイミングしかnewできない）
- インスタンスの取得は、取得用のメソッドを追加で作成しておく必要がある

