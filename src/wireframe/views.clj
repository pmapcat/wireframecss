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
   [wireframe.styles :as styles]
   [wireframe.styles-specific :as specific-styles]
   [wireframe.gen-doc :as gen-doc]))


(def STYLES
  ["/pure-min.css" "/grids-responsive-min.css" "/highlight/styles/vs.css"
   "https://fonts.googleapis.com/css?family=Open+Sans|Monoton"
   "/carousel.css"])

(defn head []
  [:head {:itemtype "http://schema.org/Article", :itemscope "itemscope"}
   (concat
    [[:meta {:charset "utf-8"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
     [:meta {:content "IE=edge,chrome=1", :http-equiv "X-UA-Compatible"}]
     
     [:title "Documentation site"]
     (for [item STYLES]
       [:link {:href item :rel "stylesheet"}])
     [:style (garden/css (styles/base-styles))]
     [:style (garden/css specific-styles/specific-styles)]])])

(defn main
  []
  (hiccup/html
   [:html
    (head)
    [:body
     [:header.mik-tiny-container
      [:div.pure-u-1.mik-pad-top.mik-pad-bottom
       [:h1.mik-line-justify.mik-fs-3.mik-cut-bottom "W i r e f r a m e"]
       [:h6.mik-cut-top.mik-fw-2.mik-flush-right "A set of practical, framework agnostic, zero configuration CSS classes"]
       [:p.mik-flush-right [:a {:href "#"} "Github"]]
       [:p.mik-flush-right [:a {:href "#"} "Download: [mik] [qq] [dd]"]]]]
     [:b "TODO:" [:br]
      "fix up sizes" [:br]
      "make download button" [:br]
      "write readme for the system" [:br]
      "push this stuff to github"]
     
     [:main.mik-small-container {:role "main"}
      [:p.mik-pad-2.border-color-background "Use " [:b "-angry "] "suffix to override (add " [:b "  !important "]
       " ) to the selector rules" [:br]
       "For example:" [:b " .mik-cut-bottom "] "becomes" [:b " .mik-cut-bottom-angry "]]
      gen-doc/datum]
     [:footer.mik-small-container
      [:div
       [:div.smaller.warm-gray.mik-flush-right.mik-footer  "Made with ❤ in Clojure" [:br]
        "Copyright © 2018 M.L" [:br]
        "All rights reserved" [:br]]]]]]))








