;;;; A Simple Web Server in Clojure.
;;;; Uses the Ring library.

(ns webapp2.core
  (:import  [java.util Date Locale]
            [java.text SimpleDateFormat])
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.file :refer [wrap-file]]
            [ring.util.response :refer [response charset content-type status]]
            [ring.util.codec :refer [form-decode]]
            [compojure.core :refer [defroutes GET POST]]
            [selmer.parser :refer [render-file]]
            [clojure.pprint :refer [pprint]]))

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

(defn fecha-hoy
  []
  (.format (SimpleDateFormat. "dd' de 'MMMM' de 'yyyy." (Locale. "es"))
           (Date.)))

(defn ver-request
  [request]
  (render-file "request.html" {:request (with-out-str (pprint request))
                               :params (if (:query-string request)
                                          (form-decode
                                            (:query-string request))
                                          nil)}))

(defroutes main-routes
  (GET "/" [] hello)
  (GET "/saluda/:nombre/" [nombre] (hola-nombre nombre))
  (GET "/despide/:nombre/" [nombre] (despide nombre))
  (GET "/prueba/" [] (render-file "prueba.html"
                                  {:fecha (fecha-hoy)
                                   :idioma "en"
                                   :enanos '(Dwalin Balin Kili Fili Dori Nori
                                             Ori Oin Gloin Bifur Bofur Bombur
                                             Thorin)
                                   :palabras {"pollito" "chicken"
                                              "gallina" "hen"
                                              "lapiz"   "pencil"
                                              "pluma"   "pen" }}))
  (GET "/ruta/" [] ver-request)
  (POST "/ruta/" [] ver-request)
  (wrap-file wtf "public"))

(defn -main [] ;
  (run-jetty main-routes {:port port}))
