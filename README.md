# Spring Boot習得用リポジトリ

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

## hiddenタグ

Webはステートレスであるため（複数のリクエストの中でデータのやり取りをすることができない）、対応の1つとしてhiddenタグを使用する

## フラッシュスコープ

- リダイレクト後に1度だけ値を保持して表示できる
- リダイレクトではリクエストをし直すため、リクエストスコープにデータを保存しておいても次のリクエスト時には失われる
  - つまりmodelを渡せないため`redirectAttributes.addFlashSttribute("name", name);`の書き方をする
  - addFlashSttribute()は、リクエストを隔ててデータを保存する仕組みであるセッションの機能を内部的に使用している
- リダイレクト後にセッションデータを破棄する仕組みのフラッシュスコープという機能をSpringが提供しているだけで、自身でセッションを破棄するコードを実装してもよい

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
- 自動的にインスタンス化される
- newしなくてもDependency Injection(DI)という仕組みにより、インスタンス化したオブジェクトをいつでも使えるように保管している

#### @RequestMapping
ドメイン以降のURLになる

#### @GetMapping
- リクエストメソッドがGETの場合の処理を書く
- GETはURLでデータを、POSTはヘッダー情報としてデータを渡す
- ページを出力させるためにはメソッドが必要なので、例えばGETリクエストしてきたら表示させたいページの処理を書く
- Viewクラスに処理が移り、渡した値とともにHTMLファイルがレンダリングされる

#### @Autowired
Springではコンテナでクラスのnewを管理する（DIコンテナ）

#### @ModelAttribute
リダイレクトで飛んできたときにデータを受け取ることができる

#### @Service
DIコンテナで自動的にシングルトンにしてインスタンス化される

## Modelクラス

- リクエストスコープのこと（１つのリクエストの中でデータを保持する仕組み）
- リクエストスコープでは1回のリクエストの間にメモリ上にデータを保持できるので、ViewがHTMLデータを作るときに必要なデータを与えることができる
- 引数のModelクラスは自動で渡されてくる（自動的にインスタンス化される）

## Formクラス

引数に設定するとフォームの入力欄と紐づけられ、自動的に初期化される

## Thymeleafの導入

- 「thymeleaf.org」で検索し、Doc > Thymeleaf 3.0: Read online > 3 Using Texts にtymeleafをHTMLに追加する記述例が載っている

`<html xmlns:th="http://www.thymeleaf.org">`などを追加する

- $（ドル）を使った書き方はJSPでもあるが、thymeleafはタグの中に直接書き込むため、デザイナーが自身の環境でブラウザだけで出力した場合、まったく邪魔をせずにデフォルト値が反映される（thymeleafを動かせる環境でない場合、タグの中の記述は無視されるということ）
- JSPはタグを追加で書いていくためデザインを邪魔することがある

## Dependency Injection(DI)

- DIコンテナとは、DIという機能を提供するフレームワークのこと
- DAOはRepositoryと同じような意味
- 依存しているインスタンスをデフォルトコンストラクタで取得する
  - DIが自動的にInjectしてくれる
- 単体テスト時にMock(ダミー)に差し替えることも可能

## プロジェクトの構成

- Springスターター・プロジェクト

#### 型
Gradle(Buildship 3.x)

#### Javaバージョン
11

#### 開発ツール
- Spring Boot DevTools
  - Javaコードに変更を加えて保存したときに自動的にSpringが再起動する

#### SQL
- H2 Database
- JDBC API

#### テンプレートエンジン
- Thymeleaf

#### Web
Spring Web(Spring Web Starter)
