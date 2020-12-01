#!/usr/bin/env bb
;; -*- mode: clojure; -*-

(require '[clojure.java.shell :as shell])

(defn time-main
  [cmds]
  (time
   (println (:out (apply shell/sh cmds)))))

(comment
  (time-main ["ls" "-al"])
  )

(time-main *command-line-args*)
