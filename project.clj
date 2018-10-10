(defproject wireframe "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.6.1"]
                 [hiccup "1.0.5"]
                 [com.evocomputing/colors "1.0.4"]
                 [garden "1.3.5"]                 
                 [ring/ring-defaults "0.3.2"]]
  :plugins [[lein-ring "0.12.4"]
            [cider/cider-nrepl "0.17.0"]]
  :ring {:handler wireframe.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
