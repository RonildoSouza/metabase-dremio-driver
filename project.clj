(defproject metabase/dremio-driver "1.1.2"
  :min-lein-version "2.5.0"

  :dependencies
  [[com.dremio.distribution/dremio-jdbc-driver "21.1.1-202204292111390812-57b1832f"]]

  :aot :all     ; Checks for compile-time failures when building the uberjar

  ;; https://download.dremio.com/jdbc-driver
  :repositories [["dremio-free" {:local/root "./dremio-jdbc-driver-21.1.1-202204292111390812-57b1832f.jar"}]
                 ["project" "file:repo"]]

  :profiles
  {:provided
   {:dependencies
    [[org.clojure/clojure "1.10.1"]
     [com.github.Baoqi/metabase-core "0.43"]]}

   :uberjar
   {:auto-clean    true
    :aot           :all
    :javac-options ["-target" "1.8", "-source" "1.8"]
    :target-path   "target/%s"
    :uberjar-name  "dremio.metabase-driver.jar"}})
