(defproject org.clojars.ntestoc/clj-chrome-devtools "20220501"
  :description "Clojure API for Chrome DevTools remote"
  :license {:name "MIT License"}
  :url "https://github.com/tatut/clj-chrome-devtools"
  :plugins [[lein-codox "0.10.8"]
            [lein-tools-deps "0.4.5"]]
  :codox {:output-path "docs/api"
          :metadata {:doc/format :markdown}}
  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  :lein-tools-deps/config {:config-files [:install :user :project]})
