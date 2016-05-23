(ns greedy-algorithms.coin-change
  (:gen-class))

(defn coin-change
  ([amt coins]
   (coin-change amt (reverse (sort coins)) []))

  ([amt coins used]
   (let [biggest (first coins)]
     (cond
      (empty? coins)   (if (> amt 0)
                         []
                         (reverse used))
       ;; first coin won't fit so new sub-problem doesn't consider it
       (> biggest amt) (recur (+ amt 0) (rest coins) used)
       ;; if it will fit use it - we reduce the amount and store and coin
       :else           (recur (- amt biggest) coins (conj used biggest))))))
