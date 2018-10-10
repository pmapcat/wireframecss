;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-09-10 17:23 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
(ns wireframe.styles
  (:require [garden.stylesheet :refer [at-media]]
            [wireframe.config :refer [conf]]
            [wireframe.utils :refer [dstr kstr angry]]))

(defn ratio
  [item]
  (try
    (str  (nth  (conf :ratio) item) "em")
    (catch Exception e (last (conf :ratio)))))

(defn p-cut
  ([on]
   (if (empty? on)
     [(dstr "cut")  {:padding (angry "0")
                  :margin  (angry "0")}]
     [(dstr  "cut" on)  {(kstr "padding" on) (angry "0")
                         (kstr "margin" on) (angry "0")}])))

(defn p-container [prefix tiny small normal]
  [[(dstr prefix "container")
    {:padding-right (angry "15px")
     :padding-left  (angry "15px")
     :margin-right (angry "auto")
     :margin-left (angry "auto")}]
   (at-media
    {:min-width "768px"}
    [(dstr prefix "container") {:width (angry tiny)}])
   (at-media
    {:min-width "992px"}
    [(dstr prefix "container") {:width (angry small)}])
   (at-media
    {:min-width "1200px"}
    [(dstr prefix "container") {:width (angry normal)}])])

(defn p-flush
  [on]
  [(dstr "flush" on) {:text-align (angry on)}])


(defn p-float
  [on]
  [(dstr  "float" on) {:float (angry on)}])

(defn p-signify
  [op-name op-prefix until on]
  (conj
   (for [item (range until)]
     [(dstr op-name  on item)
      {(kstr op-prefix on ) (angry (ratio item))}])
   [(dstr op-name on)
    {(kstr op-prefix on) (angry (ratio 1))}]))

;; (p-signify
;;  "pad" "padding" 1 "top")

(defn p-pad
  [until on]
  (p-signify "pad" "padding" until  on))

(defn p-margin
  [until on ]
  (p-signify "margin" "margin" until on))

(defn p-fs
  [until]
  (for [item (range until)]
    [(dstr  "fs" item)
     {:font-size (angry (ratio item))}]))

(defn p-as-button
  [name point]
  [(dstr name :as-button)
   {(kstr point "top") (angry "12.8px")
    (kstr point "bottom") (angry "6.4px")
    (kstr point "left") (angry "12.8px")
    (kstr point "right") (angry "12.8px")}])

(defn  p-fw []
  [[(dstr :fw) {:font-weight (angry "300")}]
   [(dstr :fw-0)   {:font-weight (angry "300")}]
   [(dstr :fw-1) {:font-weight (angry "600")}]
   [(dstr :fw-2)  {:font-weight (angry "900")}]])

(defn p-containers []
  [(p-container  "" "750px" "970px" "1170px")
   (p-container  "small" "750px" "970px" "970px")
   (p-container  "tiny" "500px" "500px" "500px")])

(defn  p-clearfix []
  [(dstr :clearfix) {:overflow (angry "auto;")}])
(defn p-line-justify []
   [(dstr :line-justify)
    {:text-align (angry "justify")}
    [:&:after {:content (angry "\"\"") :display (angry "inline-block") :width (angry "100%")}]])

(defn p-shadow []
  [(dstr :shadow) {:box-shadow (angry "0px 1px 1px 0 grey")}])

(defn p-square-border []
  [(dstr :square-border) {:border-radius (angry "0%")}])

(defn p-as-button-specificed []
  [(p-as-button "pad" "padding")
   (p-as-button "margin" "margin")])

(defn p-cut-specified []
  (map p-cut ["" "top" "bottom" "left" "right"]))

(defn p-float-specified []
  (map p-float ["left" "right"]))

(defn p-flush-specified []
  (map p-flush ["left" "right" "center" "justify"]))

(defn p-fs-specified []
  (p-fs 6))

(defn p-pad-specified []
  (map (partial p-pad 6)    ["" "top" "bottom" "left" "right"]))
(defn p-margin-specified []
  (map (partial p-margin 6) ["" "top" "bottom" "left" "right"]))


(defn base-styles
  []
  [(p-pad-specified)
   (p-margin-specified)
   (p-cut-specified)
   (p-float-specified)
   (p-flush-specified)
   (p-fs-specified)
   (p-fw)
   (p-containers)
   (p-line-justify)
   (p-shadow)
   (p-square-border)
   (p-as-button-specificed)])

