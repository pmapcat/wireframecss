(ns wireframe.handler
  (:require [compojure.core :as cj]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [wireframe.views :as views]))

;; In config website make background

(cj/defroutes app-routes
  (cj/GET "/" [] (views/main))
  (cj/GET "/style.css" [] "This is the CSS style")
  (route/not-found "Not Found"))
(def app
  (wrap-defaults app-routes site-defaults))
