INSERT INTO etat(designation)
VALUES ("NEUF"),
       ("BON ETAT"),
       ("MAUVAIS ETAT");

INSERT INTO etiquette(designation)
VALUES ("Best seller"),
       ("Promo"),
       ("Saint Valentin"),
       ("A la une");


INSERT INTO produit (prix, nom, code, description, etat_id)
VALUES (20.99, 'Ecouteurs Bluetooth sans Fil, AOVOCE Casque Bluetooth 5.3 avec 4 ENC Réduction Bruit', 'AOVOCEA60B',
        'la nouvelle génération de puce Bluetooth 5.3 personnalisée du écouteurs Bluetooth sans fil A60Pro est deux
        fois plus rapide que la génération précédente (Bluetooth 5.2) et a une distance de transmission quatre fois
        plus longue. Audio de haute qualité plus rapide et plus stable (portée de transmission jusqu\'à 15 m). Grâce
à la fonction mémoire, le casque se connecte automatiquement à votre téléphone (après la première
connexion).', 1),
(11.99, 'Chargeur USB C 20W Rapide Prise', 'ChrgUSBC20WAnlikool', 'L\'adaptateur de multiple prise USB est
fabriqué en matériau ignifuge PC et fournit des protections multiples, y compris un court-circuit
anti-sortie, une surintensité intégrée, une surtension et une protection contre la surchauffe. Assure votre
sécurité et celle de vos appareils. Portables Telephone Caricatore usb c rapide et sûr.', 3);

INSERT INTO etiquette_produit (produit_id, etiquette_id)
VALUES (1, 1),
       (1, 4),
       (2, 1),
       (2, 2);

INSERT INTO utilisateur (email, mot_de_passe, administrateur)
VALUES ("a@a.com", "0101", false),
       ("b@b.com", "0000", false),
       ("c@c.com", "2222", false);

INSERT INTO statut_commande (designation)
VALUES ("Non validée"),
       ("Validée"),
       ("Annulée"),
       ("Expédier");

INSERT INTO commande (date, client_id, statut_id)
VALUES ("2020-02-15", 1, 4),
       ("2021-05-11", 2, 3),
       ("2023-06-10", 3, 4);

INSERT INTO ligne_commande (prix_vente, quantite, commande_id, produit_id)
VALUES (11.99, 1, 1, 1),
       (21.50, 2, 1, 2),
       (8, 1, 2, 1),
       (11.90, 1, 3, 2);

