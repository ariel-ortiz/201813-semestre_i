;;;; A Simple Web Server in Clojure.
;;;; Uses the Ring library.

(ns webapp2.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.file :refer [wrap-file]]
            [ring.util.response :refer [response charset content-type status]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(def port 8080)

(defn wtf
  [request]
  (-> (response "404 Error: Not found")
      (content-type "text/html")
      (charset "utf-8")
      (status 404)))

(defroutes main-routes
  (GET "/" [] "Hello")
  (not-found wtf))

(defn -main [] ;
  (run-jetty main-routes {:port port}))
