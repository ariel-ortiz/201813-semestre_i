;;;; A Simple Web Server in Clojure.
;;;; Uses the Ring library.

(ns webapp1.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.file :refer [wrap-file]]))

(def port 8080)

(defn not-found [request] ;
  {:status   404
   :headers  {"content-type" "text/plain; charset=utf-8"}
   :body     (str "Resource not found: " (:uri request))})

(def app (wrap-file not-found "public")) ;

(defn -main [] ;
  (run-jetty app {:port port}))


