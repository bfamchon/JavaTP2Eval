JavaTP2Eval
=============

Proxy
-----
Nous n'avons pas mis en place de proxy pour le père, 
c'est une erreur de notre part car nous pensions ne pas en avoir besoin.
On a cependant implémenter un virtual proxy générique, et nous nous en servons pour une liste de personne.

SQL
---
Le script SQL utilisé pour la création de table est "crea_base.sql".
Le script "personnels.sql" est un export de la base, et "requete.sql" l'endroit où l'on place nos requêtes pour tester la base.

Diagrammes
----------
Nos différents diagrammes se trouvent dans le dossier du même nom, ils ont été réalisés manuellement avec l'outil en ligne LUCIDCHART.COM.

Lancement de notre application
------------------------------
Il suffit d'exécuter le main.

IdentityHashMap
---------------
Il aurait été intéressant de mettre en place ce pattern avec les weak-references pour éviter de récupérer deux fois le même objet en base.

À ne pas oublier
----------------
Rentrer vos identifiants dans DBConfig et dans les constantes.
