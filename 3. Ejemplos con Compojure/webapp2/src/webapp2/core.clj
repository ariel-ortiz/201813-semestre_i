;;;; A Simple Web Server in Clojure.
;;;; Uses the Ring library.

(ns webapp2.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.file :refer [wrap-file]]
            [ring.util.response :refer [response charset content-type status]]
            [compojure.core :refer [defroutes GET]]
            [selmer.parser :refer [render-file]]))

(def port 8080)

(defn wtf
  [request]
  (-> (response (render-file "404.html" {:recurso (:uri request)
                                         :mensaje "¡Saludos desde Clojure!"}))
      (content-type "text/html")
      (charset "utf-8")
      (status 404)))

(defn hello
  [request]
  (-> (response "
<!DOCTYPE html>
<html>
  <head lang=\"es\">
    <meta charset=\"utf-8\">
    <title>Hola Mundo</title>
  </head>
  <body>
    <h1>¡Hola Mundo!</h1>
    <p>Esta es una prueba.</p>
  </body>
</html>")
      (content-type "text/html")
      (charset "utf-8")
      (status 200)))

(defn hola-nombre
  [nombre]
  (fn [request]
    (-> (response (format "
<!DOCTYPE html>
<html>
  <head lang=\"es\">
    <meta charset=\"utf-8\">
    <title>Hola Mundo</title>
  </head>
  <body>
    <h1>¡Hola %s!</h1>
    <p>Esta es una prueba.</p>
  </body>
</html>" nombre))
      (content-type "text/html")
      (charset "utf-8")
      (status 418))))

(defn despide
  [nombre]
  (format "
<!DOCTYPE html>
<html>
  <head lang=\"es\">
    <meta charset=\"utf-8\">
    <title>Adios</title>
  </head>
  <body>
    <h1>¡Adios %s!</h1>
    <p>Esta es una prueba.</p>
  </body>
</html>" nombre))

(defroutes main-routes
  (GET "/" [] hello)
  (GET "/saluda/:nombre/" [nombre] (hola-nombre nombre))
  (GET "/despide/:nombre/" [nombre] (despide nombre))
  wtf)

(defn -main [] ;
  (run-jetty main-routes {:port port}))
