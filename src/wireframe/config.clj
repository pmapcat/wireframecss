;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-09-10 18:06 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
(ns wireframe.config)

(def ^{:dynamic true} *RATIO*  [0.5 1 1.5 2.5 4 6.5 10.5])
(def ^{:dynamic true} *LEVELS-AT*  6)

(def ^{:dynamic true} *PREFIX* "mik")
(def ^{:dynamic true} *ANGRY* false)
(def ^{:dynamic true} *MATERIAL-PALETTE*
  (read-string (slurp (clojure.java.io/resource "material_palette.edn"))))

(def ^{:dynamic true} *COLOR-NAMES*
  [:black   :white   :red   :pink   :purple
   :deeppurple :indigo  :blue   :lightblue :cyan
   :teal :green :lightgreen :lime :yellow :amber
   :orange :deeporange :brown :grey :bluegrey])

(def ^{:dynamic true} *VIEWS-FONTS*
  "https://fonts.googleapis.com/css?family=Open+Sans|Monoton|Patua+One")
