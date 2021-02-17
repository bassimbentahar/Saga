# Saga
L’objectif est d’implémenter le pattern SAGA pour créer une réservation devoyage. 
Un voyage est composé d’une réservation de Taxi, une réservation d’avion et une réservation d’hôtel, 
lorsque le client envoie à l’orchestrateur un objet « Travel » ce dernier sépare les 3 réservations pour envoyer chacune à un serveur dédié qui enregistre les
informations dans sa BD locale. 

Dans le pattern SAGA si une (ou plusieurs) transaction(s) n’est (ne sont) pas passée(s) l’orchestrateur fait des transactions de compensation dans tous les
services dans lesquels les transactions sont passées.

Composants:
• Un web service (orchestrateur) dans le service SEC qui créé les nouvelles réservations dans les différents services enregistrés :
    o Les ReservationTaxi dans le Service1
    o Les ReservationAvion dans le Service2
    o Les ReservationHotel dans le Service3
    Lorsqu’une réservation ne s’effectue pas l’orchestrateur arrête le processus de
    réservation et fait des requêtes de compensation vers tous les services où les
    transactions sont passées (grâce à son fichier log).
• 3 Write Services :
    o Chacun d’eux enregistre la réservation reçu dans sa BD locale(représentée
    ici par le fichier « filePathActualD »). Quand tout se passe bien chacun de 
    ces services retourne un 201 pour informer l’orchestrateur que la
    réservation a bien été créée
    o Un web service permettant de faire une transaction de compensation
  ▪ Dans chacun de ces services il faut implémenter un web service qui permet de retourner une réservation à partir de son id (si l’id de la
réservation n’existe pas il retourne un 404).

    o Pour tester le bon fonctionnement du pattern, simulez un crache dans un
    service en retournant un 500 et vérifiez que l’orchestrateur envoie des
    requêtes de compensation. 
