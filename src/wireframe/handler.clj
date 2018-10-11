(ns wireframe.handler
  (:require [compojure.core :as cj]
            [compojure.route :as route]
            [garden.core :as css]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [wireframe.config :as config]
            [wireframe.utils :as utils]
            [wireframe.views :as views]
            [wireframe.styles :as styles]
            [wireframe.styles-specific :as styles-specific]
            [wireframe.color-material :as color-material]))

(defn generate-output
  [pp? prefix & gen-items]
  (binding [config/*PREFIX* prefix]
    (str
     (binding [config/*ANGRY* true]
       (css/css {:pretty-print? pp?} (map #(%) gen-items) )) "\n"
     (binding [config/*ANGRY* false]
       (css/css {:pretty-print? pp?} (map #(%) gen-items))))))

(cj/defroutes app-routes
  (cj/GET "/" [] (views/main))
  (cj/GET "/:prefix/:color{(t|f){1}}/wireframe.css" [prefix color]
          (binding [config/*PREFIX* prefix]
            (let [include-color? (if (= color "t") true false)]
              (if include-color?
                {:status 200 :headers {"Content-Type" "text/css"}
                 :body  (generate-output false prefix
                                         styles/base-styles
                                         color-material/gen-palette)}
                {:status 200 :headers {"Content-Type" "text/css"}
                 :body  (generate-output false prefix
                                         styles/base-styles)}))))
  (cj/GET "/specific.css" []
          (->>
           (styles-specific/specific-styles)
           (css/css {:pretty-print? false})
           (assoc {:status 200 :headers {"Content-Type" "text/css"}} :body)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
