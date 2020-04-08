(let [template (html "../build/index.html")
      template (enlive/at template [:link] (fn [t] (update-in t [:attrs :href] (fn [a] (str "public/" a)))))
      template (enlive/at template [:script] (enlive/substitute nil))
      static (html "slingcode-static.html")
      static (enlive/at static [:section#about] (enlive/content (markdown "../README.md" :hickory-seq))) 
      static (enlive/at static [:p#gh-logo] (enlive/substitute nil))
      ;static (enlive/at static [:section#about] (enlive/prepend (convert-to [:div [:p.title "Slingcode personal computing platform."]] :hickory-seq))) 
      ]
  (enlive/at template [:body] (enlive/content static)))
