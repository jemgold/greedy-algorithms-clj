(ns greedy-algorithms.schedule-events
  (:gen-class))

(defn overlaps [a b]
  (not (<= (:finish b)
           (:start a))))

(defn schedule-events
  ([inbox] (schedule-events (sort-by :finish inbox) []))
  ([inbox cal]
   (let [next (first inbox)
         last-sched (last cal)]
     (cond
       (empty? inbox) cal
       (empty? cal) (recur (rest inbox) (conj cal next))
       (overlaps next last-sched) (recur (rest inbox) cal)
       :else (recur (rest inbox) (conj cal next))))))
