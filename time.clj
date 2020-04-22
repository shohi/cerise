#!/usr/bin/env bb

(defn time-main
  [cmds]
  (time
   (println (:out (apply shell/sh cmds)))))

(comment
  (time-main ["ls" "-al"])
  )

(time-main *command-line-args*)
