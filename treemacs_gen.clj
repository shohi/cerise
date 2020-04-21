#!/usr/bin/env bb

(defn is-matched-dir?
  [ptn file]
  (let [p (re-pattern ptn)]
    (and (.isDirectory file)
         (re-find p (.getName file)))))

(defn project-item
  [file]
  (let [abs-path (.getCanonicalPath file)
        name (.getName file)]
    (format "** %s\n - path :: %s" name abs-path)))

(defn create-project-items
  [dir ptn]
  (let [files (.listFiles (io/file dir))]
    (-> files
      (#(filter (partial is-matched-dir? ptn) %))
      (#(map project-item %))
      (#(clojure.string/join "\n" %)))))

(defn create-project-list
  "create treemacs workspace project lists"
  [ws dir ptn]
  (let [header (format "* %s" ws)]
    (str header "\n" (create-project-items dir ptn))))

;; main entry
(let  [[ws dir ptn] *command-line-args*]
  (when (or (empty? ws) (empty? dir) (empty? ptn))
    (println "Usage: <workspace> <dir> <pattern>")
    (System/exit 1))
  (println (create-project-list ws dir ptn)))

(System/exit 0)
