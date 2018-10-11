;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-09-10 17:34 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

(ns wireframe.views
  (:require
   [garden.core :as garden]
   [hiccup.core :as hiccup]
   [wireframe.config :refer [*VIEWS-FONTS*]]
   [wireframe.gen-doc :as gen-doc]))
      ;; [:b "TODO:" [:br]
      ;;  "fix up sizes" [:br]
      ;;  "make download button" [:br]
      ;;  "write readme for the system" [:br]
      ;;  "push this stuff to github"]


(def STYLES
  ["/pure-min.css" *VIEWS-FONTS*
   "/mik/t/wireframe.css"
   "/specific.css"])

(defn head []
  [:head {:itemtype "http://schema.org/Article", :itemscope "itemscope"}
   (concat
    [[:meta {:charset "utf-8"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
     [:meta {:content "IE=edge,chrome=1", :http-equiv "X-UA-Compatible"}]
     
     [:title "Documentation site"]
     (for [item STYLES]
       [:link {:href item :rel "stylesheet"}])])])

(defn main
  []
  (hiccup/html
   [:html
    (head)
    [:body {:style "background:url('/background.png')"}
     [:div.mik-tiny-container {:style "background:white;"}
      [:header
       [:div.pure-u-1.mik-pad-top.mik-pad-bottom
        [:h1#top.mik-line-justify.mik-fs-4.mik-cut "W i r e"]
        [:h1#top.mik-line-justify.mik-fs-4.mik-cut-angry "f r a m e"]
        [:div.mik-fw-1.mik-fs-0
         [:p.mik-cut.mik-flush-right "A set of practical, framework agnostic, zero configuration CSS classes"]
         [:p.mik-cut.mik-flush-right "for everyday use"]]
        
        [:div.mik-fw-2.mik-fs-0.mik-pad-top-5
         [:p.mik-flush-right.mik-cut.mik-pad-top-0 [:a {:href "https://github.com/MichaelLeachim/wireframecss"} "Github"]]
         [:p.mik-flush-right.mik-cut  "Download"
          [:br]
          [:a {:href "/mik/f/wireframe.css"}  " [ mik- ] "]
          [:a {:href "/mik/t/wireframe.css"}  " [ color- ]"] [:br]
          [:a {:href "/qq/f/wireframe.css"} " [ qq- ] "]
          [:a {:href "/qq/t/wireframe.css"}  " [ color- ]"]  [:br]
          [:a {:href "/dd/f/wireframe.css"} " [ dd- ] "]
          [:a {:href "/dd/t/wireframe.css" }  " [ color- ]"]  ]]]]
      [:main {:role "main"}
       [:p.mik-pad-0.element-color-background "Use " [:b "-angry "] "suffix to override (add " [:b "  !important "]
        " ) to the selector rules" [:br]
        "For example:" [:b " .mik-cut-bottom "] "becomes" [:b " .mik-cut-bottom-angry "]]
       gen-doc/datum]
      [:footer.mik-fs-0
       [:div
        [:div.smaller.warm-gray.mik-flush-right.mik-footer  "Made with ❤ in Clojure" [:br]
         "Copyright © 2018 M.L" [:br]
         "All rights reserved" [:br]]
        [:div.mik-fs-0
         [:a {:href "/sheet.png"} "Sheet background"]
         [:a {:href "/background.png"} "Background image"]]]]]]]))




