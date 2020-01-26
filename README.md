# Springフレームワークを習得するための勉強用リポジトリ

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
  - インスタンス化しただけではアドレスしか知ることができない
    - （例）newした変数をそのまま標準出力に書き出すと、アドレスが確認できる
- ヒープ領域
  - インスタンスの中身が保管される
  - ヒープ領域を見ることを「参照する」という（インスタンスが参照型とかいう会話になる）
  - getterやsetterを使用するとインスタンスの値を参照することができる

## シングルトン

- そのクラスのインスタンスが必ず1つであることを保証するデザインパターン
- staticなクラスオブジェクトを持つクラスが呼び出されるタイミングで1度だけnewする
- コンストラクタはprivateにし、外からnewできなくする（クラスオブジェクトが呼び出されるタイミングしかnewできない）
- インスタンスの取得は、取得用のメソッドを追加で作成しておく必要がある

## Gradle

- ソースコードのコンパイル、テストを実行してレポートを出力、クラスファイルのアーカイブ生成、アーカイブをステージング環境にリリースする、など定型的な作業を自動化するソフトウェア（ビルドツール）
- Eclipseにもビルド機能はあるが、ビルド職人がEclipseを立ち上げる必要があり手間がかかる
- Gradleではディレクトリ構造にルールを設けることでビルドを効率化している

## アノテーション

#### @SpringBootApplication
Springのデフォルトの設定を自動的に行う（これがないと、XMLで書く必要があり大変）

#### @ControllerAdvice  
コントローラークラスの中で、メソッドを呼び出す前のタイミングで共通処理を行う設定ファイルにすることができる

#### @Controller
自動的にインスタンス化される  
newしなくてもDependency Injection(DI)という仕組みにより、インスタンス化したオブジェクトをいつでも使えるように保管している

#### @RequestMapping
ドメイン以降のURLになる

#### @GetMapping
リクエストメソッドがGETの場合
GETはURLでデータを、POSTはヘッダー情報としてデータを渡す
Modelクラスは自動で渡されてくる
Viewクラスに処理が移り、渡した値とともにHTMLファイルがレンダリングされる

## Modelクラス

- リクエストスコープのこと（１つのリクエストの中でデータを保持する仕組み）
- リクエストスコープでは1回のリクエストの間にメモリ上にデータを保持できるので、ViewがHTMLデータを作るときに必要なデータを与えることができる

## Thymeleafの導入

- 「thymeleaf.org」で検索し、Doc > Thymeleaf 3.0: Read online > 3 Using Texts にtymeleafをHTMLに追加する記述例が載っている
