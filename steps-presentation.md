C-x C-+ to make font bigger
## Terminal

`lein new pedestal-service presentation`

`mkdir presentation/resources`

`cp base-sample/resources/data.edn presentation/resources/` 

## Open editor

## open resources/data.edn and show it. This is our "database" for this presentation.

## Start repl

## open project.clj

Add
```
[com.walmartlabs/lacinia-pedestal "0.11.0"]
```

## open resources/schema.edn

Add
```
{:objects
 {:User
  {:fields
   {:id {:type (non-null ID)}
    :username {:type String}
    :games {:type (list :Game)
            :args {:id {:type ID}}
            :resolve :User/games}
    :books {:type (list :Book)
            :args {:id {:type ID}}
            :resolve :User/books}}}

  :Game
  {:fields
   {:id {:type (non-null ID)}
    :name {:type (non-null String)}}}

  :Book
  {:fields
   {:id {:type (non-null ID)}
    :name {:type (non-null String)}}}}

 :queries
 {:allUsers
  {:type (list :User)
   :resolve :Query/allUsers}
  :userById
  {:type :User
   :args {:id {:type ID}}
   :resolve :Query/userById}}}
```

## open src/presentation/schema.clj

Add
```
(:require [clojure.java.io :as io]
            [com.walmartlabs.lacinia.util :as util]
            [com.walmartlabs.lacinia.schema :as schema]
            [clojure.edn :as edn])
```
to namespace

Add
```
(def db (-> (io/resource "data.edn")
            slurp
            edn/read-string))
```

Add
```
(defn load-schema
  []
  (-> (io/resource "schema.edn")
      slurp
      edn/read-string
      (util/attach-resolvers (resolver-map))
      schema/compile))
```

Add
```
(defn resolver-map
  []
  {:User/books (get-books)
   :User/games (get-games)
   :Query/allUsers (get-all-users)
   :Query/userById (get-user-by-id)})
```

Add
```
(defn get-all-users
  []
  (fn [context _ _]
    (:users db)))

(defn get-user-by-id
  []
  (fn [context args _]
    (->> (:users db)
         (filter #(= (:id args) %))
         first)))
```

Add
```
(defn get-books
  []
  (fn [context args user]
    (println args)
    (cond->> (:booksUser db)
      true (filter #(= (:id user) (:user-id %)))
      true (map (fn [book-user] (filter #(= (:id %) (:book-id book-user)) (:books db))))
      true flatten
      (contains? args :id) (filter #(= (:id args) (:id %))))))
```

Copy-paste, select region replace `book` with `game`

## open src/presentation/service.clj

Remove all

Add 
```
[com.walmartlabs.lacinia.pedestal :as lp]
[presentation.schema :as schema]
```

 to require
 
 Add
 
 ```
(def compiled-schema (schema/load-schema))

(def service (-> compiled-schema
                 (lp/service-map {:graphiql true
                                  :port 8080})))
```

## open src/presentation/server.clj

Remove line 21 with routes

## Run app
`cd presentation`
`lein run-dev`
