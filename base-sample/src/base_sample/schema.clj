(ns base-sample.schema
  (:require [clojure.java.io :as io]
            [com.walmartlabs.lacinia.util :as util]
            [com.walmartlabs.lacinia.schema :as schema]
            [clojure.edn :as edn]))

(def db (-> (io/resource "data.edn")
            slurp
            edn/read-string))

(defn get-books
  []
  (fn [context args user]
    (cond->> (:booksUser db)
      true (filter #(= (:id user) (:user-id %)))
      true (map (fn [book-user] (filter #(= (:id %) (:book-id book-user)) (:books db))))
      true flatten
      (contains? args :id) (filter #(= (:id args) (:id %))))))

(defn get-games
  []
  (fn [context args user]
    (cond->> (:gamesUser db)
      true (filter #(= (:id user) (:user-id %)))
      true (map (fn [game-user] (filter #(= (:id %) (:game-id game-user)) (:games db))))
      true flatten
      (contains? args :id) (filter #(= (:id args) (:id %))))))

(defn get-all-users
  []
  (fn [context _ _]
    (:users db)))

(defn get-user-by-id
  []
  (fn [context args _]
    (->> (:users db)
         (filter #(- (:id args) %))
         first)))


(defn resolver-map
  []
  {:User/books (get-books)
   :User/games (get-games)
   :Query/allUsers (get-all-users)
   :Query/userById (get-user-by-id)})

(defn load-schema
  []
  (-> (io/resource "schema.edn")
      slurp
      edn/read-string
      (util/attach-resolvers (resolver-map))
      schema/compile))
