(ns greedy-algorithms.core
  (:gen-class))

(declare coin-change)

(defn -main
  "here’s your change"
  [& args]
  (let [coins [100 50 20 10 5 2 1]]
    (println (coin-change 26 coins))
    ;; => (1 5 20)
    (println (coin-change 30 coins))
    ;; => (10 20)
    (println (coin-change 26 [20 10 5]))
    ;; => []
    ))

(defn coin-change
  ([amt coins]
   (coin-change amt (reverse (sort coins)) []))

  ([amt coins used]
   (if (empty? coins)
     (if (> amt 0)
       []
       (reverse used))
     (let [biggest (first coins)]
       (if (> biggest amt)
         ;; first coin won't fit so new sub-problem doesn't consider it
         (coin-change (+ amt 0) (rest coins) used)
         ;; if it will fit use it - we reduce the amount and store and coin
         (coin-change (- amt biggest) coins (conj used biggest)))))))

;; (defn sum
;;   ([vals] (sum vals 0))
;;   ([vals acc]
;;    (if (empty? vals)
;;      acc
;;      (sum (rest vals) (+ (first vals) acc)))))

