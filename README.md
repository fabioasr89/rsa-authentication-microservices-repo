#ESEMPIO DI GESTIONE DI UN TOKEN JWT CON ALGIRITMO DI CIFRATURA SRA

Nell'esempio si espone un primo caso di utilizzo del token jwt mediante la codifica/decodifica basata
su RS256. Una chiave privata, residente sul servizio che gestisce il token, viene utilizzata per 
la cifratura del dato e la generazione del token jwt.
Una chiave pubblica, invece, residente su tutti i servizi delle risorse da proteggere tramite api-gateway(che committerò nella prossima versione )
viene utilizzata per la decodifica del token jwt. 

In questa prima versione, si recupera il token da un username settato nell'header della richiesta inviata al jwt-token-svc, e questo
viene settato nell'header della richiesta del secondo servizio (quello delle "risorse"), al momento ancora privo di api-gateway.
Nel servizio delle risorse ho esposto un rest che recupera l'username dal token, dopo aver proceduto con le relative fasi di verifica validita e firma.

ps. Negli esempi committati nei repository collaterali, relativi a jwtToken, avevamo utilizzato un algoritmo di cifratura a chiave simmetrica,
nel quale una chiave condivisa tra provider di autenticazione e service delle risorse permetteva la codicifica/decodifica del token.
In questo tipo di codifica, invece, abbiamo due chiavi,private/public, ed è un tipico esempio di algoritmo a cifratura asimmetrica